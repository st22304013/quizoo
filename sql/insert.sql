/* userinfo テーブルへのデータ挿入 */
INSERT INTO userinfo (user_id, password, total_answer, correct_answer, rating) VALUES
('watoru5151@quizoo.ttc.ac.jp', 'password1', 2, 1, 0.5),
('jibiki@quizoo.ttc.ac.jp', 'password2', 3, 0, 0),
('eiya@quizoo.ttc.ac.jp', 'password3', 15, 15, 15),
('niko@quizoo.ttc.ac.jp', 'password4', 100, 80, 64),



/* nickname テーブルへのデータ挿入 */
INSERT INTO nickname (user_no, nickname) VALUES
(1, 'wataru'),
(2, 'bikki-daddydirty'),
(3, 'A8'),
(4, 'hachiware');


/* genre テーブルへのデータ挿入 */
INSERT INTO  genre(genre_no, genre_title) VALUES
(1, 'スポーツ'),
(2, '音楽'),
(3, '映画'),
(4, 'ゲーム'),
(5, '雑学'),
(6, '宇宙'),
(7, 'エンタメ・芸能'),
(8, 'なぞなぞ'),
(9, '生き物'),
(10, '歴史'),
(11, '数学'),
(12, '漫画'),
(13, '生活'),
(14, '地理'),
(15, 'お酒'),
(16, '美術'),
(17, 'ことば'),
(18, '文化'),
(19, '料理'),
(20, 'アニメ');



/* quiz テーブルへのデータ挿入 */
INSERT INTO quiz (author_no, title, question_count, genre_no, explanation, create_time, total_participants) VALUES
(1, '亘クイズ', 3, 5, 'おれに関するクイズやで', '2023-10-11 2:46:35', 1),
(2, 'びきクイズ', 1, 7, '', '2023-01-05 11:13:04', 1),
(3, '動物クイズ', 4, 9, 'いろんな動物のクイズ', '2023-12-02 0:17:53', 4),
(4, 'プロ野球クイズ', 5, 1, 'プロ野球のクイズ', '2023-08-01 10:49:09', 5),
(1, 'サッカークイズ', 1, 1, 'サッカーのクイズ', '2023-10-12 15:07:29', 1),
(1, '音楽クイズ', 3, 2, '音楽関連のクイズ', '2023-01-31 11:11:14', 3),
(4, '洋画クイズ', 5, 3, '海外映画のクイズ', '2023-05-12 7:43:36', 5),
(4, '邦画クイズ', 1, 3, '日本映画のクイズ', '2023-07-04 23:13:32', 1),
(3, 'ゲームクイズ', 2, 4, 'ゲームのクイズ', '2023-07-18 12:49:08', 2),
(2, '雑学クイズ', 2, 5, '雑学のクイズ', '2023-10-16 13:23:25', 2),
(2, '宇宙クイズ', 3, 6, '宇宙のクイズ', '2023-06-15 9:01:12', 3),
(1, '漫画クイズ', 4, 12, '漫画のクイズ', '2023-02-13 22:49:25', 4),
(4, '歴史クイズ', 5, 10, '歴史のクイズ', '2023-11-03 0:21:21', 5),
(3, '変わった雑学クイズ', 10, 5, '変わった雑学クイズ', '2023-09-02 5:08:34', 10),
(2, '料理クイズ', 5, 19, '料理のクイズ', '2023-04-06 20:57:40', 5),
(1, 'お酒クイズ', 3, 15, 'お酒のクイズ', '2023-03-22 14:32:47', 3),
(4, 'なぞなぞクイズ', 10, 8, 'なぞなぞ', '2023-02-18 8:13:43', 10),
(4, '地理クイズ', 10, 14, '地理', '2023-05-25 17:32:39', 10),
(4, '美術クイズ', 2, 16, '美術', '2023-08-17 13:57:57', 2),
(2, 'アニメクイズ', 10, 20, 'アニメ', '2023-03-01 23:49:13', 10),
(3, '海のクイズ', 10, 9, '海に関わる', '2023-08-05 10:49:39', 10),
(3, 'スポーツクイズ1', 5, 1, 'スポーツに関わる', '2022-11-15 8:37:22', 5),
(3, 'スポーツクイズ2', 5, 1, 'スポーツに関わる', '2023-04-23 17:12:45', 5),
(3, 'スポーツクイズ3', 5, 1, 'スポーツに関わる', '2022-09-07 11:24:58', 5),
(3, 'スポーツクイズ4', 5, 1, 'スポーツに関わる', '2023-02-18 6:56:31', 5),
(4, '音楽クイズ2', 5, 2, '音楽に関わる', '2022-07-29 22:09:14', 5),
(4, '音楽クイズ3', 5, 2, '音楽に関わる', '2023-06-12 14:43:27', 5),
(4, '音楽クイズ4', 5, 2, '音楽に関わる', '2022-12-03 9:18:50', 5),
(1, '映画クイズ2', 5, 3, '映画に関わる', '2023-01-27 3:31:03', 5),
(1, '映画クイズ3', 5, 3, '映画に関わる', '2022-08-19 19:54:16', 5),
(1, '映画クイズ4', 5, 3, '映画に関わる', '2023-05-31 12:26:39', 5);


/* question テーブルへのデータ挿入 */
INSERT INTO question (quiz_id, question_id, question, choice_1, choice_2, choice_3, choice_4, judge) VALUES
(1, 1, '亘の好きな食べ物は？', 'ラーメン', '寿司', 'カツオ', 'プリン', b'1100'),
(1, 2, '亘の嫌いな食べ物は？', 'カツオ', 'プリン', 'カリフラワー', '大根', b'0010'),
(1, 3, '亘の身長は？', '169', '170', '171', '172', b'0010'),
(2, 1, '地引の居住地は？', '神栖', '筑波', '大洗', '取手', b'0001'),
(3, 1, '「く」から始まる幸せな顔をした動物は？', 'クシナダ', 'クオッカ', 'クジラ', 'バナナ', b'0100'),
(3, 2, 'オランウータンの握力は何キロ？', '100', '150', '200', '250', b'0010'),
(3, 3, 'コアラの1日の睡眠時間は？', '3', '8', '11', '22', b'0001'),
(3, 4, '犬猫牛には人間でいう指紋の様なものがあります。それは何でしょうか？', '耳', '足', '歯', '鼻', b'0001'),
(4, 1, '日本シリーズ2023で優勝したチームは?', '楽天', 'ヤクルト', '阪神', 'オリックス', b'0010'),
(4, 2, '2023ドラフト会議でヤクルトが1位指名した選手は？', '西村', '西条', '西舘', '西川', b'0010'),
(4, 3, '田中将大が記録した、連勝記録は？', '18勝', '20勝', '22勝', '24勝', b'0001'),
(4, 4, '2022年村上宗隆のホームラン数は？', '56本', '55本', '54本', '53本', b'1000'),
(4, 5, '佐々木朗希が記録した連続無安打記録は何回？', '9回', '11回', '15回', '17回', b'0001'),
(5, 1, '何々の1ミリと話題になったサッカー選手は?', '三笘', '三坂', '三島', '三苫', b'0001'),
(6, 1, 'Saucy Dogが結成されたのは何年?', '2017', '2016', '2013', '2012', b'0010'),
(6, 2, '映画「君の名は」で音楽を担当したバンドは？', 'RADWIMPS', 'B\z', 'スピッツ', 'KANA-BOON', b'1000'),
(6, 3, 'ONE OK ROCKボーカル、takaの父は？', '岸田文雄', '森進一', '王貞治', '落合博満', b'0100'),
(7, 1, 'ウルフ・オブ・ウォールストリートでヴェルフォートが詐欺のために売った株は？', 'ミニー株', 'ペニー株', 'ドニ―株', 'ソニー株', b'0100'),
(7, 2, '映画jokerでアーサーの同僚で小人症の名前は？', 'ゲイリー', 'トニー', 'ウェイン', 'ブラウン', b'1000'),
(7, 3, 'チャーリーとチョコレート工場の工場長は誰？', 'ピーターパーカー', 'マイケルジャクソン', 'ウィリーウォンカ', 'チャーリー', b'0010'),
(7, 4, 'アメリカンスナイパーの戦争は何？', 'イラク戦争', 'ベトナム戦争', 'アメリカ戦争', '朝鮮戦争', b'1000'),
(7, 5, 'ジョンウィックの殺されてしまった犬の名前は？', 'ハント', 'イーサン', 'ピットブル', 'デイジー', b'0001'),
(8, 1, '映画7つの会議で八角が所属していた部署は？', '営業', '総務', '経理', '人事', b'1000'),
(9, 1, '妖怪ウォッチ1のラスボスは?', 'イカカモネ議長', 'あやとり様', 'ゲソヒール大臣', 'ウバウネ', b'1000'),
(9, 2, '妖怪ウォッチ２のラスボスは？', 'カブキロイド', 'スベテ・ウバウネ', 'キン', 'ギン', b'0100'),
(10, 1, '耳かきについてるふわふわの名前は？', '毛払い', 'ふわふわ', 'わた', '梵天', b'0001'),
(10, 2, '傘の上についてるところの名前は？', '天突', '土突', '石突', '雨突', b'0010'),
(11, 1, '太陽系の惑星で、衛星の数が一番多いのは？', '地球', '土星', '冥王星', '木星', b'0100'),
(11, 2, '国際宇宙ステーションの広さに近いのは？', 'サッカーコート', '東京ドーム', 'ディズニーランド', '25mプール', b'1000'),
(11, 3, '宇宙服の断熱材は何層でしょうか？', '8層', '11層', '14層', '20層', b'0010'),
(12, 1, 'ジョジョの奇妙な冒険二部のワムウの必殺技は？', '神砂嵐', '輝彩滑刀', '怪焔王大車獄', '波紋疾走', b'1000'),
(12, 2, '和の国でゾロが名乗った偽名は？', 'ゾロ次郎', 'ゾロ十郎', 'ゾロ五郎', 'おゾロ', b'0100'),
(12, 3, 'デスノートでキラが最初に殺した人物は？', '渋井丸拓男', '夜神総一郎', 'L', '音原田九郎', b'0001'),
(12, 4, '葬送のフリーレンは何歳以上？', '1000歳', '500歳', '250歳', '100歳', b'1000'),
(13, 1, '江戸幕府を開いた人物は？', '織田信長', '徳川家康', '葛飾北斎', '平清盛', b'0100'),
(13, 2, '織田信長を暗殺した人物は？', '明智光秀', '徳川家康', '武田信玄', '伊達政宗', b'1000'),
(13, 3, '鎌倉幕府を開いた人物は？', '西郷隆盛', '坂本龍馬', '源義経', '源頼朝', b'0001'),
(13, 4, '中国大陸を統一した人物は？', '呉', '朕', '秦', '信', b'0010'),
(13, 5, '大化の改新が起こった年は？', '645年', '723年', '527年', '848年', b'1000'),
(14, 1, '人間は、一生のうち平均何回殺人犯とすれ違うでしょうか？', '1回', '6回', '11回', '16回', b'0001'),
(14, 2, '最初にパーを出すと何パーセントで勝てるでしょうか？', '33パーセント', '60パーセント', '25パーセント', '45パーセント', b'0100'),
(15, 1, '世界最小と言われているパスタはどれ？', 'ガラガラ', 'ニヤニヤ', 'カラカラ', 'クスクス', b'0001'),
(15, 2, 'シュールストレミングの材料の魚は？', 'ニシン', 'サケ', 'イワシ', 'アジ', b'1000'),
(15, 3, 'スペインでアホと呼ばれる食材は何？', '唐辛子', 'ハム', 'ニンニク', 'ソーセージ', b'0010'),
(15, 4, '三大料理に含まれないものは？', 'トルコ', '中国', 'イタリア', 'フランス', b'0010'),
(15, 5, '日本生まれの料理は？', 'ドリア', 'ピラフ', 'ハンバーグ', '餃子', b'1000'),
(16, 1, '日本酒の主な材料は？', 'ブドウ', 'お米', '小麦', 'トウモロコシ', b'0100'),
(16, 2, '世界で一番売れているスコッチウイスキーは？', 'J&B', 'バランタイン', 'シーバスリーガル', 'ジョニーウォーカー', b'0001'),
(16, 3, 'レゲエパンチの発祥の国はどこ？', '日本', '中国', 'アメリカ', 'アフリカ', b'1000'),
(17, 1, '夏になると作られていそうな揚げ物は何だ？', 'アジフライ', 'コロッケ', 'カキフライ', 'エビフライ', b'0010'),
(17, 2, '雨から守ってくれそうな動物は？', 'コウモリ', 'キリン', 'ゾウ', 'トラ', b'1000'),
(17, 3, '古ければ古いほど若いのはどれ？', '洗濯機', '写真', '冷蔵庫', 'タイヤ', b'0100'),
(17, 4, 'タヌキが宝くじを買ったよ結果は？', '一等', '二等', '三等', 'ハズレ', b'0001'),
(17, 5, '透明人間の職業は？', '探偵', '公務員', '無職', '警察', b'0010'),
(17, 6, '点を一つ取ると大きくなる動物は？', '犬', '猫', '鶏', '鳥', b'1000'),
(17, 7, '正義の味方が現れました。なぜ？', '寝ているから', '疲れたから', '泣いているから', '怒っているから', b'0100'),
(17, 8, '徹夜をした人の顔に動物が現れた。何でしょう？', '猿', '猫', '犬', '熊', b'0001'),
(17, 9, 'アメリカの両端に橋が作られた。何色でしょう？', '赤色', '青色', '黄色', '緑色', b'1000'),
(17, 10, '長さが35キロもある野菜は何でしょう？', 'じゃがいも', 'ごぼう', 'きゅうり', 'にんじん', b'0010'),
(18, 1, '日本で一番広い湖はどこ？', '猪苗代湖', '田沢湖', '霞ヶ浦', '琵琶湖', b'0001'),
(18, 2, '日本で一番長い川はどこ？', '信濃川', '利根川', '釈迦堂川', '阿武隈川', b'1000'),
(18, 3, '日本で二番めに大きい山は？', '富士山', '磐梯山', '北岳', '穂高岳', b'0010'),
(18, 4, '日本の国土は何割が山地？', '5割', '6割', '7割', '8割', b'0010'),
(18, 5, '日本で一番小さい都道府県は？', '沖縄', '香川', '石川', '福岡', b'0100'),
(18, 6, '縄文時代の日本の人口は？', '100万', '50万', '10万', '2万', b'0001'),
(18, 7, '名古屋を中心とした工業地帯は？', '阪神工業地帯', '京浜工業地帯', '中京工業地帯', '名古屋工業地帯', b'0010'),
(18, 8, '世界で一番長い川は？', 'ナイル川', 'アマゾン川', 'ガンジス川', 'ライン川', b'1000'),
(18, 9, '解体新書を作った奴は？', '福島孝徳', '高須克弥', '野口英世', '杉田玄白', b'0001'),
(18, 10, '世界一面積が小さい国は？', '日本', 'バチカン市国', 'インド', 'フランス', b'0100'),
(19, 1, '有名な画家でゲルニカを描いた画家は誰？', 'ゴッホ', 'ダヴィンチ', 'モネ', 'ピカソ', b'0001'),
(19, 2, 'モナリザがある美術館はどこ？', 'ルーブル美術館', 'メトロポリタン美術館', 'オルセー美術館', '国立新美術館', b'1000'),
(20, 1, 'どらえもんの正しい表記は？', 'どらえもん', 'ドラえもん', 'ドラエもん', 'ドらえもん', b'0100'),
(20, 2, 'ジャムおじさんの正体は？', '人間', '妖精', 'ばい菌', 'パン', b'0100'),
(20, 3, 'キティちゃんの身長は？', 'リンゴ5個', 'リンゴ3個', 'リンゴ1個', 'リンゴ10個', b'1000'),
(20, 4, 'のび太の特技は？', '勉強', '野球', '縄跳び', 'あやとり', b'0001'),
(20, 5, '炭次郎は何人兄弟？', '4人', '5人', '6人', '7人', b'0010'),
(20, 6, 'ちいかわの苦手な食べ物は？', 'カヌレ', 'ブロッコリー', 'プリン', 'シチュー', b'0100'),
(20, 7, 'デンジの心臓となった悪魔の名前は？', 'ポチタ', 'ポタチ', 'ポテチ', 'ポタチ', b'1000'),
(20, 8, '左目に十字傷があるキャラは？', '緋村剣心', 'ゾロ', '月詠', 'ミホーク', b'0001'),
(20, 9, 'うずまきナルトは何代目火影？', '4代目', '5代目', '6代目', '7代目', b'0001'),
(20, 10, '次のうち身長が一番高いのは？', 'ヒソカ', 'レオリオ', 'クロロ', 'キルア', b'0100'),
(21, 1, '海の水がしょっぱいのはなぜ？', '岩から塩が溶ける', '雨', 'プランクトン', '氷が溶けて', b'1000'),
(21, 2, '波が発生する原因は何？', 'サメ', '雨', '風', '魚', b'0010'),
(21, 3, '海の中で一番大きい奴は？', 'シロナガスクジラ', 'ネッシー', 'ホホジロザメ', 'ジンベエザメ', b'1000'),
(21, 4, '海の一番深いところは何m？', '3776m', '8849m', '10920m', '634m', b'0010'),
(21, 5, '海水魚は何種類確認されてるでしょう？', '14550種類', '1455種類', '4550種類', '5500種類', b'1000'),
(21, 6, '海の塩分濃度はどれぐらい？', '6.5パーセント', '5.5パーセント', '4.5パーセント', '3.5パーセント', b'0001'),
(21, 7, '生きた化石と呼ばれる魚は？', 'ニシオンデンザメ', 'シーラカンス', 'ダイオウイカ', 'メガマウス', b'0100'),
(21, 8, 'ジンベエザメの主な食べ物は？', 'プランクトン', 'サバ', 'サメ', 'クラゲ', b'1000'),
(21, 9, 'ペンギンが住んでいないところは？', '南極', '北極', '南アメリカ', 'オーストラリア', b'0100'),
(21, 10, '数の子は何の卵？', 'サメ', 'ニシン', 'サケ', 'タイ', b'0100'),
(22, 1, '2020年に延期された夏季オリンピックが開催される都市はどこですか？', 'ロンドン', '東京', 'パリ', 'リオデジャネイロ', b'0100'),
(22, 2, 'NBAで最も多くの優勝経験を持つチームはどれですか？', 'ロサンゼルス・レイカーズ', 'ボストン・セルティックス', 'シカゴ・ブルズ', 'ゴールデンステート・ウォリアーズ', b'0100'),
(22, 3, 'テニスの四大大会の一つで、クレーコートで開催される大会はどれですか？', '全豪オープン', '全仏オープン', 'ウィンブルドン', '全米オープン', b'0100'),
(22, 4, 'アメリカンフットボールのスーパーボウルで最も優勝回数が多いクォーターバックは誰ですか？', 'Tom Brady', 'Peyton Manning', 'Joe Montana', 'Brett Favre', b'1000'),
(22, 5, '2016年のリオデジャネイロオリンピックで最もメダルを獲得した国はどれですか？', 'アメリカ合衆国', '中国', 'イギリス', 'ドイツ', b'1000'),
(23, 1, 'ワールドカップサッカーの優勝回数が最も多い国はどれ？', 'ブラジル', 'ドイツ', 'アルゼンチン', 'イタリア', b'1000'),
(23, 2, 'オリンピックの開催都市で、最初に2回開催された都市はどこ？', 'ロンドン', '東京', 'パリ', 'アテネ', b'0001'),
(23, 3, 'テニスの四大大会で唯一クレーコートを使用しない大会はどれ？', '全豪オープン', '全仏オープン', 'ウィンブルドン', '全米オープン', b'0010'),
(23, 4, 'NBAで最も長い連勝記録を持つチームはどれ？', 'ロサンゼルス・レイカーズ', 'ボストン・セルティックス', 'シカゴ・ブルズ', 'ゴールデンステート・ウォリアーズ', b'0001'),
(23, 5, 'ゴルフのメジャー大会で最も古い大会はどれ？', 'マスターズ・トーナメント', '全英オープン', '全米オープン', 'PGAチャンピオンシップ', b'0100'),
(24, 1, 'サッカーのワールドカップで最も得点を挙げた選手は誰？', 'ペレ', 'マラドーナ', 'ミロスラフ・クローゼ', 'ロナウド', b'0010'),
(24, 2, 'テニスの「ビッグスリー」として知られる選手に含まれないのは誰？', 'ノバク・ジョコビッチ', 'ロジャー・フェデラー', 'ラファエル・ナダル', 'アンディ・マレー', b'0001'),
(24, 3, 'オリンピックのマラソン競技が始まった都市はどこ？', 'パリ', 'ローマ', 'アテネ', '東京', b'0010'),
(24, 4, 'MLB（メジャーリーグベースボール）のチーム「ヤンキース」の本拠地はどこ？', 'ニューヨーク', 'ロサンゼルス', 'ボストン', 'シカゴ', b'1000'),
(24, 5, 'バスケットボールの3ポイントラインの距離は何フィートですか？', '20フィート', '22フィート', '24フィート', '26フィート', b'0010'),
(25, 1, 'サッカーのワールドカップで最多得点を挙げた国はどこ？', 'ブラジル', 'ドイツ', 'アルゼンチン', 'イタリア', b'1000'),
(25, 2, 'テニスの四大大会で最も標高が高い場所で行われるのはどれ？', '全豪オープン', '全仏オープン', 'ウィンブルドン', '全米オープン', b'1000'),
(25, 3, 'オリンピック史上最も多くのメダルを獲得した女性選手は誰？', 'ユリア・チェプリャーノワ', 'ミハエラ・フィルモワ', 'ラリサ・ラトニナ', 'ミハエラ・ロシュ', b'0010'),
(25, 4, 'NBAで「バックボード・シェイク」を行ったことで知られる選手は誰？', 'マイケル・ジョーダン', 'シャキール・オニール', 'レブロン・ジェームズ', 'ウィルト・チェンバレン', b'0001'),
(25, 5, 'ゴルフのメジャー大会で「グランドスラム」を達成したことのある選手は誰？', 'ジョーダン・スピース', 'ローリー・マキロイ', 'フィル・ミケルソン', 'タイガー・ウッズ', b'0001'),
(26, 1, 'ビートルズのメンバーで最初に亡くなったのは誰？', 'ジョン・レノン', 'ポール・マッカートニー', 'ジョージ・ハリスン', 'リンゴ・スター', b'0010'),
(26, 2, 'マイケル・ジャクソンのアルバム「Thriller」に収録されている曲はどれ？', 'Billie Jean', 'Beat It', 'Thriller', 'Smooth Criminal', b'0010'),
(26, 3, 'レディー・ガガのデビューアルバムは次のうちどれ？', 'The Fame', 'Born This Way', 'Artpop', 'Joanne', b'1000'),
(26, 4, 'ローリング・ストーンズのギタリストで「キースリフ」として知られるのは誰？', 'ミック・ジャガー', 'キース・リチャーズ', 'ロン・ウッド', 'ブライアン・ジョーンズ', b'0100'),
(26, 5, 'クイーンのボーカリストは誰？', 'フレディ・マーキュリー', 'ブライアン・メイ', 'ロジャー・テイラー', 'ジョン・ディーコン', b'1000'),
(27, 1, 'ビートルズの曲「Hey Jude」の歌詞の中で誰に向けられている？', 'ポールの妻', 'ジョンの妻', 'ジョージの妻', 'リンゴの妻', b'0100'),
(27, 2, 'マイケル・ジャクソンのアルバム「Bad」に収録されている曲はどれ？', 'Thriller', 'Bad', 'Beat It', 'Billie Jean', b'0100'),
(27, 3, 'テイラー・スウィフトのアルバム「1989」に収録されている曲はどれ？', 'Shake It Off', 'Blank Space', 'Bad Blood', 'Style', b'1000'),
(27, 4, 'デビューシングル「I Kissed a Girl」で知られるアーティストは誰？', 'Katy Perry', 'Lady Gaga', 'Rihanna', 'Adele', b'1000'),
(27, 5, 'ビリー・アイリッシュの曲「Bad Guy」のリリース年はいつ？', '2017年', '2018年', '2019年', '2020年', b'0010'),
(28, 1, 'クイーンの「Bohemian Rhapsody」のジャンルは何？', 'ロック', 'ポップ', 'ヒップホップ', 'カントリー', b'1000'),
(28, 2, 'ビリー・ジョエルのアルバム「The Stranger」に収録されている曲はどれ？', 'Piano Man', 'Just the Way You Are', 'Uptown Girl', 'We Didnt Start the Fire', b'0100'),
(28, 3, 'レディー・ガガのデビューアルバムは次のうちどれ？', 'The Fame', 'Born This Way', 'Artpop', 'Joanne', b'1000'),
(28, 4, 'マイケル・ジャクソンの「Beat It」のギターソロを演奏したギタリストは誰？', 'Eddie Van Halen', 'Slash', 'Jimi Hendrix', 'Eric Clapton', b'1000'),
(28, 5, 'デビューシングル「Umbrella」で知られるアーティストは誰？', 'Beyonce', 'Rihanna', 'Katy Perry', 'Adele', b'0100'),
(29, 1, '映画『ショーシャンクの空に』の主演俳優は誰？', 'モーガン・フリーマン', 'タム・ハンクス', 'キアヌ・リーブス', 'ティム・ロビンス', b'1000'),
(29, 2, '『ハリー・ポッター』シリーズで主人公ハリー・ポッターを演じた俳優は誰？', 'ダニエル・ラドクリフ', 'ルパート・グリント', 'エマ・ワトソン', 'トム・フェルトン', b'1000'),
(29, 3, '映画『インセプション』の監督は誰？', 'クリストファー・ノーラン', 'ジェームズ・キャメロン', 'ピーター・ジャクソン', 'スティーヴン・スピルバーグ', b'1000'),
(29, 4, 'アニメ映画『千と千尋の神隠し』の監督は誰？', '宮崎駿', '石田卓也', '細田守', '中田秀夫', b'1000'),
(29, 5, '『ラ・ラ・ランド』で主演を務めた女優は誰？', 'エマ・ストーン', 'ナタリー・ポートマン', 'ジェニファー・ローレンス', 'レイチェル・マクアダムス', b'1000'),
(30, 1, '映画『タイタニック』の主演俳優は誰？', 'ケイト・ウィンスレット', 'ブラッド・ピット', 'ジュリア・ロバーツ', 'レオナルド・ディカプリオ', b'0001'),
(30, 2, '『ハリー・ポッター』シリーズでダンブルドア校長を演じた俳優は誰？', 'マイケル・ケイン', 'アラン・リックマン', 'イアン・マッケラン', 'リチャード・ハリス', b'0001'),
(30, 3, '映画『フォレスト・ガンプ』で主演を務めた俳優は誰？', 'ブルース・ウィリス', 'ジョニー・デップ', 'トム・ハンクス', 'ロバート・デ・ニーロ', b'0010'),
(30, 4, 'アニメ映画『となりのトトロ』の監督は誰？', '細田守', '宮崎駿', '押井守', '坂本賀勇', b'0100'),
(30, 5, '映画『インセプション』で主演を務めた俳優は誰？', 'トム・ハーディ', 'キリアン・マーフィー', 'レオナルド・ディカプリオ', 'ジョセフ・ゴードン＝レヴィット', b'0010'),
(31, 1, '映画『フォレスト・ガンプ』の主演俳優は誰？', 'メル・ギブソン', 'ジョニー・デップ', 'ブルース・ウィリス', 'トム・ハンクス', b'0001'),
(31, 2, '『インターステラー』の監督は誰？', 'マーティン・スコセッシ', 'クリストファー・ノーラン', 'スティーヴン・スピルバーグ', 'ジェームズ・キャメロン', b'0100'),
(31, 3, '映画『シンドラーのリスト』の主演俳優は誰？', 'ケビン・コスナー', 'トム・ハンクス', 'メル・ギブソン', 'リーアム・ニーソン', b'0001'),
(31, 4, 'アニメ映画『もののけ姫』の監督は誰？', '押井守', '細田守', '坂本賀勇', '宮崎駿', b'0001'),
(31, 5, '映画『インセプション』の主演俳優は誰？', 'キリアン・マーフィー', 'ジョセフ・ゴードン＝レヴィット', 'レオナルド・ディカプリオ', 'トム・ハーディ', b'0010');


INSERT INTO answerhistory (user_no, quiz_id, answered_time, question_count, correct_count) VALUES
(6, 2, '2023-10-11 2:46:35', 3, 1),
(3, 1, '2023-01-05 11:13:04', 1, 2),
(6, 3, '2023-12-02 0:17:53', 4, 2),
(6, 3, '2023-12-02 0:17:53', 4, 1),
(4, 3, '2023-12-02 0:17:53', 4, 3),
(6, 4, '2023-08-01 10:49:09', 5, 5),
(3, 5, '2023-10-12 15:07:29', 1, 1),
(6, 6, '2023-01-31 11:11:14', 3, 2),
(2, 7, '2023-05-12 7:43:36', 5, 3),
(3, 8, '2023-07-04 23:13:32', 1, 1),
(6, 9, '2023-07-18 12:49:08', 2, 2),
(2, 10, '2023-10-16 13:23:25', 2, 1),
(6, 11, '2023-06-15 9:01:12', 3, 3),
(4, 12, '2023-02-13 22:49:25', 4, 1),
(6, 13, '2023-11-03 0:21:21', 5, 3),
(6, 14, '2023-09-02 5:08:34', 10, 8),
(2, 15, '2023-04-06 20:57:40', 5, 3),
(4, 16, '2023-03-22 14:32:47', 3, 3),
(2, 17, '2023-02-18 8:13:43', 10, 9),
(4, 18, '2023-05-25 17:32:39', 10, 2),
(2, 19, '2023-08-17 13:57:57', 2, 2),
(3, 20, '2023-03-01 23:49:13', 10, 10),
(4, 21, '2023-08-05 10:49:39', 10, 10),
(1, 22, '2022-11-15 8:37:22', 5, 5),
(1, 23, '2023-04-23 17:12:45', 5, 5),
(1, 24, '2022-09-07 11:24:58', 5, 5),
(1, 25, '2023-02-18 6:56:31', 5, 5),
(1, 26, '2022-07-29 22:09:14', 5, 5),
(1, 27, '2023-06-12 14:43:27', 5, 5),
(1, 28, '2022-12-03 9:18:50', 5, 5),
(1, 29, '2023-01-27 3:31:03', 5, 5),
(1, 30, '2022-08-19 19:54:16', 5, 5),
(1, 31, '2023-05-31 12:26:39', 5, 5);

