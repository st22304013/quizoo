/*set_questin_countをテストする文*/
insert into answerhistory(user_no, quiz_id, answered_time, correct_count) values(5,1,now(),3);


/*calculate_rating*をテストする文*/
update userinfo set total_answer=3, correct_answer=2 where user_no=5;

update userinfo set user_id='test' where user_no=5;


insert into userinfo(user_id, password) values("test6","test66");



--------------------------------------------------------------------------------------------------------------------------
drop TRIGGER set_question_count;
drop PROCEDURE CalculateRatingProcedure;

/*ratingを計算するプロシージャ*/
DELIMITER //
CREATE PROCEDURE CalculateRatingProcedure(INOUT total_answer_param INT, INOUT correct_answer_param INT, OUT rating_param FLOAT)
BEGIN
    IF correct_answer_param > total_answer_param THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'correct_answerがtotal_answerより大きい';
    END IF;

    SET total_answer_param = total_answer_param + correct_answer_param;
    SET correct_answer_param = correct_answer_param + correct_answer_param;
    SET rating_param = POW(correct_answer_param, 2) / total_answer_param;
END;
//
DELIMITER ;

/* answerhistoryにinsertしたときに、quizをupdateするトリガー callあり*/
DELIMITER //
CREATE TRIGGER set_question_count
BEFORE INSERT ON answerhistory
FOR EACH ROW
BEGIN
    SET NEW.question_count = (SELECT question_count FROM quiz WHERE quiz_id = NEW.quiz_id);

	CALL CalculateRatingProcedure(@total_answer, @correct_answer, @rating);

	UPDATE quiz SET 
		total_participants = total_participants+1,
		correct_rate = ((correct_rate * total_participants) + (NEW.correct_count / NEW.question_count)) / (total_participants)
	WHERE quiz_id = NEW.quiz_id;
END;
//
DELIMITER ;
