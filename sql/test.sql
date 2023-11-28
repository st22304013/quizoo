/*set_questin_countをテストする文　question_countに入る数は何でもいい。自動的にquiz表のquestion_countに変わる*/
insert into answerhistory(user_no, quiz_id, answered_time, question_count, correct_count) values(3,2,now(),1,1);

/*calculate_rating*をテストする文*/
update userinfo set total_answer=2, correct_answer=2 where user_no=5;