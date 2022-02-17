INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('sample@google.com', '크리스브라운' ,'https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/user1.png');
INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('person@naver.com', '산드라','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/user2.png');
INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('sam@naver.com', '테일러','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/user3.png');
INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('ple@naver.com', '샤이아','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/user4.png');
INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('banana@naver.com', '미어캣','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-profile-testfolder/2022-02-13T15%3A29%3A44.600013_Meerkat.png');

INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('song@naver.com', '졸리','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/user6.png');
INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('jaein@naver.com', '김제이','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/user7.png');
INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('apple@naver.com', '애쉬','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/user8.png');
INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('ample@google.com', '린제이','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/user5.png');
INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('minibus@naver.com', '미니버스','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-profile-testfolder/2022-02-14T13%3A03%3A02.010436_logo_bus.png');

INSERT INTO TRANSPORTATION (NAME) VALUES ('버스');
INSERT INTO TRANSPORTATION (NAME) VALUES ('지하철');
INSERT INTO TRANSPORTATION (NAME) VALUES ('택시');
INSERT INTO TRANSPORTATION (NAME) VALUES ('기타');

INSERT INTO REGION VALUES (null ,'서울');
INSERT INTO REGION VALUES (null ,'경기 남부');
INSERT INTO REGION VALUES (null ,'경기 북부');
INSERT INTO REGION VALUES (null ,'인천');

INSERT INTO REPORT_REASON VALUES (null, '욕설이나 비속어');
INSERT INTO REPORT_REASON VALUES (null, '스팸메세지나 광고성 메세지');
INSERT INTO REPORT_REASON VALUES (null, '가학적이거나 혐오적인 콘텐츠');
INSERT INTO REPORT_REASON VALUES (null, '민감하거나 선정적인 콘텐츠');
INSERT INTO REPORT_REASON VALUES (null, '기타');

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (10,'2층버스 보셨나욥?', 'VISIBLE',1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 1, '사람살려~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'미쳤다 사람 너무많은데...', 'VISIBLE',1,3, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 2, '일찍일어났다면?', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (10,'아... 열차놓침', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 3, '저는 이제 퇴근여~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'골병라인 사람 반 공기반!!', 'VISIBLE',2,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (5, 4, '반갑습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (10,'서울가는 버스 앉아버리기', 'VISIBLE',1,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 5, '나도앉아버리기~', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (10,'인천에도 공유킥보드 생겼어요', 'VISIBLE', 4,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (6,'불금~', 'VISIBLE', 2,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'버스에 이거놓고간사람!!!!!!', 'VISIBLE', 1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 8, '이거 제꺼에여! 찾아줘서 고맙습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (10,'새로운 노선 이제 빙글빙글 돌지않고 바로 서울로 가요!', 'VISIBLE', 4,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 9, '와 빠르다!', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'버스정류장에 교통카드 가져다대면 잔액 나오는 거 알고 잇었음? 근데 문제는 이제 저기까지 손이 닿느냐의 문제인데...', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (10,'버스터미널까지 FLEX!!', 'VISIBLE', 2,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'아니...오늘 개춥고 기분 안 좋은 일 있어서 별 생각없이 얼른 집에가자는 마음으로 정류장에 서 있었는데. 이건 반칙 아닌가요. 산타가 이제는 루돌프로 버스를 끌고 다니네ㅋㅋㅋㅋㅋㅋㅋ', 'VISIBLE', 2,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'선생님...덕분에 늦지 않게 도착할 수 있었어요. 진짜 루나버스 갈 수 있어서 요캇타. 하필 오늘 교대 해주는 사람이 늦게와서 교대하자마자 택시타고 장충으로 날아왔다. 기사 아저씨 운전때문에 살짝 멀미했지만...그래도 진짜 즐거웠음.', 'VISIBLE', 1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'지루한 이동시간을 활용해보세요', 'VISIBLE', 2,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'미니버스 이용해보니 시간이 솔솔', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'지하철 사람이 완전많다~', 'VISIBLE',1,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'늦어서 택시를 탔는데도 늦었어!!', 'VISIBLE',1,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'오늘 하루도 경기도 고통길 시작 ㅋㅋㅋㅋ', 'VISIBLE',1,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'골병라인 사람 반 공기반!!', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'서울가는 버스 앉아버리기', 'VISIBLE',1,3, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (10,'아니...오늘 개춥고 기분 안 좋은 일 있어서 별 생각없이 얼른 집에가자는 마음으로 정류장에 서 있었는데. ' ||
                                                                                                        '이건 반칙 아닌가요. 산타가 이제는 루돌프로 버스를 끌고 다니네ㅋㅋㅋㅋㅋㅋㅋ', 'VISIBLE', 3,1, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'요즘 버정 안내판은 모스부호 쓰냐... 뭔데', 'VISIBLE', 1,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (9,'와 이건 좀 아니지...버스정류장 한복판에 이걸 떡하니 두고 갔다고? 양심 어디갔냐', 'VISIBLE', 1,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'이거 알고 네이버스하는 중? 버스 정류장에 와이파이된다. 진심 잘 찾아보면 와이파이 써있는 스티커 붙어있음.', 'VISIBLE', 1,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'공익을 위해서 남깁니다. 버스에서 뭐 두고 내리신 분들 세가지만 기억하세요.', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'#정원이데이 #생일축하해 #빛나는리더_정원이의_태어난날 아니 길가다가 이건 안 찍을 수 없어서 정류장에 떡하니 있는 우리 정원이. 정원이 하고 싶은 거 다해!', 'VISIBLE', 1,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (10,'지하철 사람이 완전많다~', 'VISIBLE',1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 1, '사람살려~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'늦어서 택시를 탔는데도 늦었어!!', 'VISIBLE',1,3, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 2, '일찍일어났다면?', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'오늘 하루도 경기도 고통길 시작 ㅋㅋㅋㅋ', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 3, '저는 이제 퇴근여~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (10,'골병라인 사람 반 공기반!!', 'VISIBLE',2,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (5, 4, '반갑습니다.', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'지하철 사람이 완전많다~', 'VISIBLE',1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 1, '사람살려~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'늦어서 택시를 탔는데도 늦었어!!', 'VISIBLE',1,3, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 2, '일찍일어났다면?', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'오늘 하루도 경기도 고통길 시작 ㅋㅋㅋㅋ', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 3, '저는 이제 퇴근여~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'골병라인 사람 반 공기반!!', 'VISIBLE',2,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (5, 4, '반갑습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'서울가는 버스 앉아버리기', 'VISIBLE',1,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 5, '나도앉아버리기~', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'지하철 사람이 완전많다~', 'VISIBLE',1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 1, '사람살려~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'늦어서 택시를 탔는데도 늦었어!!', 'VISIBLE',1,3, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 2, '일찍일어났다면?', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'오늘 하루도 경기도 고통길 시작 ㅋㅋㅋㅋ', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 3, '저는 이제 퇴근여~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'골병라인 사람 반 공기반!!', 'VISIBLE',2,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (5, 4, '반갑습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'서울가는 버스 앉아버리기', 'VISIBLE',1,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 5, '나도앉아버리기~', 'VISIBLE', current_timestamp, current_timestamp);


INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'지하철 사람이 완전많다~', 'VISIBLE',1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 1, '사람살려~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'늦어서 택시를 탔는데도 늦었어!!', 'VISIBLE',1,3, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 2, '일찍일어났다면?', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'오늘 하루도 경기도 고통길 시작 ㅋㅋㅋㅋ', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 3, '저는 이제 퇴근여~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'골병라인 사람 반 공기반!!', 'VISIBLE',2,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (5, 4, '반갑습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'서울가는 버스 앉아버리기', 'VISIBLE',1,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 5, '나도앉아버리기~', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (5,'인천에도 공유킥보드 생겼어요', 'VISIBLE', 4,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (6,'불금~', 'VISIBLE', 3,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'버스에 이거놓고간사람!!!!!!', 'VISIBLE', 1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 8, '이거 제꺼에여! 찾아줘서 고맙습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'새로운 노선 이제 빙글빙글 돌지않고 바로 서울로 가요!', 'VISIBLE', 4,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 9, '와 빠르다!', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'버스정류장에 교통카드 가져다대면 잔액 나오는 거 알고 잇었음? 근데 문제는 이제 저기까지 손이 닿느냐의 문제인데...', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'버스터미널까지 FLEX!!', 'VISIBLE', 2,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'아니...오늘 개춥고 기분 안 좋은 일 있어서 별 생각없이 얼른 집에가자는 마음으로 정류장에 서 있었는데. 이건 반칙 아닌가요. 산타가 이제는 루돌프로 버스를 끌고 다니네ㅋㅋㅋㅋㅋㅋㅋ', 'VISIBLE', 2,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'선생님...덕분에 늦지 않게 도착할 수 있었어요. 진짜 루나버스 갈 수 있어서 요캇타. 하필 오늘 교대 해주는 사람이 늦게와서 교대하자마자 택시타고 장충으로 날아왔다. 기사 아저씨 운전때문에 살짝 멀미했지만...그래도 진짜 즐거웠음.', 'VISIBLE', 1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'지루한 이동시간을 활용해보세요', 'VISIBLE', 2,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'미니버스 이용해보니 시간이 솔솔', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'지하철 사람이 완전많다~', 'VISIBLE',1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 1, '사람살려~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'늦어서 택시를 탔는데도 늦었어!!', 'VISIBLE',1,3, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 2, '일찍일어났다면?', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'오늘 하루도 경기도 고통길 시작 ㅋㅋㅋㅋ', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 3, '저는 이제 퇴근여~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'골병라인 사람 반 공기반!!', 'VISIBLE',2,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (5, 4, '반갑습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'서울가는 버스 앉아버리기', 'VISIBLE',1,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 5, '나도앉아버리기~', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (5,'인천에도 공유킥보드 생겼어요', 'VISIBLE', 4,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (6,'불금~', 'VISIBLE', 3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'버스에 이거놓고간사람!!!!!!', 'VISIBLE', 1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 8, '이거 제꺼에여! 찾아줘서 고맙습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'새로운 노선 이제 빙글빙글 돌지않고 바로 서울로 가요!', 'VISIBLE', 4,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 9, '와 빠르다!', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'버스정류장에 교통카드 가져다대면 잔액 나오는 거 알고 잇었음? 근데 문제는 이제 저기까지 손이 닿느냐의 문제인데...', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (10,'버스터미널까지 FLEX!!', 'VISIBLE', 2,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'아니...오늘 개춥고 기분 안 좋은 일 있어서 별 생각없이 얼른 집에가자는 마음으로 정류장에 서 있었는데. 이건 반칙 아닌가요. 산타가 이제는 루돌프로 버스를 끌고 다니네ㅋㅋㅋㅋㅋㅋㅋ', 'VISIBLE', 2,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'선생님...덕분에 늦지 않게 도착할 수 있었어요. 진짜 루나버스 갈 수 있어서 요캇타. 하필 오늘 교대 해주는 사람이 늦게와서 교대하자마자 택시타고 장충으로 날아왔다. 기사 아저씨 운전때문에 살짝 멀미했지만...그래도 진짜 즐거웠음.', 'VISIBLE', 1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'지루한 이동시간을 활용해보세요', 'VISIBLE', 2,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'미니버스 이용해보니 시간이 솔솔', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'지하철 사람이 완전많다~', 'VISIBLE',1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 1, '사람살려~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'늦어서 택시를 탔는데도 늦었어!!', 'VISIBLE',1,3, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 2, '일찍일어났다면?', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'오늘 하루도 경기도 고통길 시작 ㅋㅋㅋㅋ', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 3, '저는 이제 퇴근여~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'골병라인 사람 반 공기반!!', 'VISIBLE',2,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (5, 4, '반갑습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'서울가는 버스 앉아버리기', 'VISIBLE',1,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 5, '나도앉아버리기~', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (5,'인천에도 공유킥보드 생겼어요', 'VISIBLE', 4,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (6,'불금~', 'VISIBLE', 1,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'버스에 이거놓고간사람!!!!!!', 'VISIBLE', 1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 8, '이거 제꺼에여! 찾아줘서 고맙습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'새로운 노선 이제 빙글빙글 돌지않고 바로 서울로 가요!', 'VISIBLE', 4,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 9, '와 빠르다!', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'버스정류장에 교통카드 가져다대면 잔액 나오는 거 알고 잇었음? 근데 문제는 이제 저기까지 손이 닿느냐의 문제인데...', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'버스터미널까지 FLEX!!', 'VISIBLE', 2,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'아니...오늘 개춥고 기분 안 좋은 일 있어서 별 생각없이 얼른 집에가자는 마음으로 정류장에 서 있었는데. 이건 반칙 아닌가요. 산타가 이제는 루돌프로 버스를 끌고 다니네ㅋㅋㅋㅋㅋㅋㅋ', 'VISIBLE', 2,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'선생님...덕분에 늦지 않게 도착할 수 있었어요. 진짜 루나버스 갈 수 있어서 요캇타. 하필 오늘 교대 해주는 사람이 늦게와서 교대하자마자 택시타고 장충으로 날아왔다. 기사 아저씨 운전때문에 살짝 멀미했지만...그래도 진짜 즐거웠음.', 'VISIBLE', 1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'지루한 이동시간을 활용해보세요', 'VISIBLE', 2,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'미니버스 이용해보니 시간이 솔솔', 'VISIBLE', 1,4, current_timestamp, current_timestamp);



INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'지하철 사람이 완전많다~', 'VISIBLE',1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 1, '사람살려~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'늦어서 택시를 탔는데도 늦었어!!', 'VISIBLE',1,3, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 2, '일찍일어났다면?', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'오늘 하루도 경기도 고통길 시작 ㅋㅋㅋㅋ', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 3, '저는 이제 퇴근여~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'골병라인 사람 반 공기반!!', 'VISIBLE',2,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (5, 4, '반갑습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'서울가는 버스 앉아버리기', 'VISIBLE',1,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 5, '나도앉아버리기~', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (5,'인천에도 공유킥보드 생겼어요', 'VISIBLE', 4,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (6,'불금~', 'VISIBLE', 2,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'버스에 이거놓고간사람!!!!!!', 'VISIBLE', 1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 8, '이거 제꺼에여! 찾아줘서 고맙습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'새로운 노선 이제 빙글빙글 돌지않고 바로 서울로 가요!', 'VISIBLE', 4,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 9, '와 빠르다!', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'버스정류장에 교통카드 가져다대면 잔액 나오는 거 알고 잇었음? 근데 문제는 이제 저기까지 손이 닿느냐의 문제인데...', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'버스터미널까지 FLEX!!', 'VISIBLE', 2,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'아니...오늘 개춥고 기분 안 좋은 일 있어서 별 생각없이 얼른 집에가자는 마음으로 정류장에 서 있었는데. 이건 반칙 아닌가요. 산타가 이제는 루돌프로 버스를 끌고 다니네ㅋㅋㅋㅋㅋㅋㅋ', 'VISIBLE', 2,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'선생님...덕분에 늦지 않게 도착할 수 있었어요. 진짜 루나버스 갈 수 있어서 요캇타. 하필 오늘 교대 해주는 사람이 늦게와서 교대하자마자 택시타고 장충으로 날아왔다. 기사 아저씨 운전때문에 살짝 멀미했지만...그래도 진짜 즐거웠음.', 'VISIBLE', 1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'지루한 이동시간을 활용해보세요', 'VISIBLE', 2,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'미니버스 이용해보니 시간이 솔솔', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'지하철 사람이 완전많다~', 'VISIBLE',1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 1, '사람살려~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'늦어서 택시를 탔는데도 늦었어!!', 'VISIBLE',1,3, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 2, '일찍일어났다면?', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'오늘 하루도 경기도 고통길 시작 ㅋㅋㅋㅋ', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 3, '저는 이제 퇴근여~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'골병라인 사람 반 공기반!!', 'VISIBLE',2,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (5, 4, '반갑습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'서울가는 버스 앉아버리기', 'VISIBLE',1,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 5, '나도앉아버리기~', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (5,'인천에도 공유킥보드 생겼어요', 'VISIBLE', 3,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (6,'불금~', 'VISIBLE', 1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'버스에 이거놓고간사람!!!!!!', 'VISIBLE', 1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 8, '이거 제꺼에여! 찾아줘서 고맙습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'새로운 노선 이제 빙글빙글 돌지않고 바로 서울로 가요!', 'VISIBLE', 4,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 9, '와 빠르다!', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'버스정류장에 교통카드 가져다대면 잔액 나오는 거 알고 잇었음? 근데 문제는 이제 저기까지 손이 닿느냐의 문제인데...', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'버스터미널까지 FLEX!!', 'VISIBLE', 2,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'아니...오늘 개춥고 기분 안 좋은 일 있어서 별 생각없이 얼른 집에가자는 마음으로 정류장에 서 있었는데. 이건 반칙 아닌가요. 산타가 이제는 루돌프로 버스를 끌고 다니네ㅋㅋㅋㅋㅋㅋㅋ', 'VISIBLE', 2,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'선생님...덕분에 늦지 않게 도착할 수 있었어요. 진짜 루나버스 갈 수 있어서 요캇타. 하필 오늘 교대 해주는 사람이 늦게와서 교대하자마자 택시타고 장충으로 날아왔다. 기사 아저씨 운전때문에 살짝 멀미했지만...그래도 진짜 즐거웠음.', 'VISIBLE', 1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'지루한 이동시간을 활용해보세요', 'VISIBLE', 2,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'미니버스 이용해보니 시간이 솔솔', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'아니...오늘 개춥고 기분 안 좋은 일 있어서 별 생각없이 얼른 집에가자는 마음으로 정류장에 서 있었는데. 이건 반칙 아닌가요. 산타가 이제는 루돌프로 버스를 끌고 다니네ㅋㅋㅋㅋㅋㅋㅋ', 'VISIBLE', 2,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'10번 버스 지나감!', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'지하철 사람이 완전많다~', 'VISIBLE',1,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 1, '사람살려~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'늦어서 택시를 탔는데도 늦었어!!', 'VISIBLE',1,3, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 2, '일찍일어났다면?', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'오늘 하루도 경기도 고통길 시작 ㅋㅋㅋㅋ', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 3, '저는 이제 퇴근여~', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'골병라인 사람 반 공기반!!', 'VISIBLE',3,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (5, 4, '반갑습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'서울가는 버스 앉아버리기', 'VISIBLE',1,2, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 5, '나도앉아버리기~', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (5,'인천에도 공유킥보드 생겼어요', 'VISIBLE', 1,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (6,'불금~', 'VISIBLE', 3,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'버스에 이거놓고간사람!!!!!!', 'VISIBLE', 1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 8, '이거 제꺼에여! 찾아줘서 고맙습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'새로운 노선 이제 빙글빙글 돌지않고 바로 서울로 가요!', 'VISIBLE', 3,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 9, '와 빠르다!', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'버스정류장에 교통카드 가져다대면 잔액 나오는 거 알고 잇었음? 근데 문제는 이제 저기까지 손이 닿느냐의 문제인데...', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (10,'버스터미널까지 FLEX!!', 'VISIBLE', 2,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'아니...오늘 개춥고 기분 안 좋은 일 있어서 별 생각없이 얼른 집에가자는 마음으로 정류장에 서 있었는데. 이건 반칙 아닌가요. 산타가 이제는 루돌프로 버스를 끌고 다니네ㅋㅋㅋㅋㅋㅋㅋ', 'VISIBLE', 2,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'선생님...덕분에 늦지 않게 도착할 수 있었어요. 진짜 루나버스 갈 수 있어서 요캇타. 하필 오늘 교대 해주는 사람이 늦게와서 교대하자마자 택시타고 장충으로 날아왔다. 기사 아저씨 운전때문에 살짝 멀미했지만...그래도 진짜 즐거웠음.', 'VISIBLE', 1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'지루한 이동시간을 활용해보세요', 'VISIBLE', 2,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'미니버스 이용해보니 시간이 솔솔', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (5,'인천에도 공유킥보드 생겼어요', 'VISIBLE', 1,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (6,'불금~', 'VISIBLE', 3,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'버스에 이거놓고간사람!!!!!!', 'VISIBLE', 1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 8, '이거 제꺼에여! 찾아줘서 고맙습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'새로운 노선 이제 빙글빙글 돌지않고 바로 서울로 가요!', 'VISIBLE', 3,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 9, '와 빠르다!', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'버스정류장에 교통카드 가져다대면 잔액 나오는 거 알고 잇었음? 근데 문제는 이제 저기까지 손이 닿느냐의 문제인데...', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'버스터미널까지 FLEX!!', 'VISIBLE', 2,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'아니...오늘 개춥고 기분 안 좋은 일 있어서 별 생각없이 얼른 집에가자는 마음으로 정류장에 서 있었는데. 이건 반칙 아닌가요. 산타가 이제는 루돌프로 버스를 끌고 다니네ㅋㅋㅋㅋㅋㅋㅋ', 'VISIBLE', 2,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'선생님...덕분에 늦지 않게 도착할 수 있었어요. 진짜 루나버스 갈 수 있어서 요캇타. 하필 오늘 교대 해주는 사람이 늦게와서 교대하자마자 택시타고 장충으로 날아왔다. 기사 아저씨 운전때문에 살짝 멀미했지만...그래도 진짜 즐거웠음.', 'VISIBLE', 1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'지루한 이동시간을 활용해보세요', 'VISIBLE', 2,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'미니버스 이용해보니 시간이 솔솔', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (5,'인천에도 공유킥보드 생겼어요', 'VISIBLE', 1,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (6,'불금~', 'VISIBLE', 3,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'버스에 이거놓고간사람!!!!!!', 'VISIBLE', 1,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 8, '이거 제꺼에여! 찾아줘서 고맙습니다.', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'새로운 노선 이제 빙글빙글 돌지않고 바로 서울로 가요!', 'VISIBLE', 3,1, current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 9, '와 빠르다!', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'버스정류장에 교통카드 가져다대면 잔액 나오는 거 알고 잇었음? 근데 문제는 이제 저기까지 손이 닿느냐의 문제인데...', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'버스터미널까지 FLEX!!', 'VISIBLE', 2,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'아니...오늘 개춥고 기분 안 좋은 일 있어서 별 생각없이 얼른 집에가자는 마음으로 정류장에 서 있었는데. 이건 반칙 아닌가요. 산타가 이제는 루돌프로 버스를 끌고 다니네ㅋㅋㅋㅋㅋㅋㅋ', 'VISIBLE', 2,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'선생님...덕분에 늦지 않게 도착할 수 있었어요. 진짜 루나버스 갈 수 있어서 요캇타. 하필 오늘 교대 해주는 사람이 늦게와서 교대하자마자 택시타고 장충으로 날아왔다. 기사 아저씨 운전때문에 살짝 멀미했지만...그래도 진짜 즐거웠음.', 'VISIBLE', 1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'지루한 이동시간을 활용해보세요', 'VISIBLE', 2,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (10,'미니버스 이용해보니 시간이 솔솔', 'VISIBLE', 1,4, current_timestamp, current_timestamp);

-- 루돌프
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A04%3A56.985840_2020121801001085900047101.jpeg', 21);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A04%3A57.145395__122309948_301ce903-e9cc-4641-9568-268933794a58.jpeg', 21);

-- 택시 콘서트
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A15%3A41.882605_p1065596788137816_911_thum.jpeg', 13);

-- 모스 부호
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A19%3A12.143674_FLiBnvfacAAJZoR.jpeg', 22);

-- 킥보드
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A21%3A01.324122_FLYQPjWaIAIaMxZ.jpeg', 6);

-- 장비설치
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A28%3A07.134144_02.%E1%84%87%E1%85%A5%E1%84%89%E1%85%B3%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%85%E1%85%B2%E1%84%8C%E1%85%A1%E1%86%BC-%E1%84%8C%E1%85%A1%E1%86%BC%E1%84%87%E1%85%B5%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5.jpg', 24);

-- 분실 안내
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A29%3A06.349648_c3130a5e2dcc25eca2e68684abf533f0.jpeg', 25);

-- 버스 표지판
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A31%3A03.964258_nt5t3324943r965vjle0.jpeg', 10);

-- 이층 버스
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A47%3A49.487894_%ED%99%94%EB%A9%B4+%EC%BA%A1%EC%B2%98+2022-02-14+154720.png', 1);

-- 사람 많다
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T16%3A01%3A59.462836_image+(1).png', 2);

-- 열차 놓침
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T16%3A02%3A51.554927_image+(2).png', 3);



INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A04%3A56.985840_2020121801001085900047101.jpeg', 100);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A04%3A57.145395__122309948_301ce903-e9cc-4641-9568-268933794a58.jpeg', 100);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A15%3A41.882605_p1065596788137816_911_thum.jpeg', 130);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A19%3A12.143674_FLiBnvfacAAJZoR.jpeg', 141);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A21%3A01.324122_FLYQPjWaIAIaMxZ.jpeg', 133);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A28%3A07.134144_02.%E1%84%87%E1%85%A5%E1%84%89%E1%85%B3%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%85%E1%85%B2%E1%84%8C%E1%85%A1%E1%86%BC-%E1%84%8C%E1%85%A1%E1%86%BC%E1%84%87%E1%85%B5%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5.jpg', 143);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A29%3A06.349648_c3130a5e2dcc25eca2e68684abf533f0.jpeg', 133);

INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A31%3A03.964258_nt5t3324943r965vjle0.jpeg', 10);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A47%3A49.487894_%ED%99%94%EB%A9%B4+%EC%BA%A1%EC%B2%98+2022-02-14+154720.png', 123);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T16%3A01%3A59.462836_image+(1).png', 112);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T16%3A02%3A51.554927_image+(2).png', 139);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A04%3A56.985840_2020121801001085900047101.jpeg', 98);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A04%3A57.145395__122309948_301ce903-e9cc-4641-9568-268933794a58.jpeg', 84);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A15%3A41.882605_p1065596788137816_911_thum.jpeg', 67);

INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A19%3A12.143674_FLiBnvfacAAJZoR.jpeg', 77);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A21%3A01.324122_FLYQPjWaIAIaMxZ.jpeg', 88);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A28%3A07.134144_02.%E1%84%87%E1%85%A5%E1%84%89%E1%85%B3%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%85%E1%85%B2%E1%84%8C%E1%85%A1%E1%86%BC-%E1%84%8C%E1%85%A1%E1%86%BC%E1%84%87%E1%85%B5%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5.jpg', 101);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A29%3A06.349648_c3130a5e2dcc25eca2e68684abf533f0.jpeg', 123);


INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A31%3A03.964258_nt5t3324943r965vjle0.jpeg', 109);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A47%3A49.487894_%ED%99%94%EB%A9%B4+%EC%BA%A1%EC%B2%98+2022-02-14+154720.png', 122);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T16%3A01%3A59.462836_image+(1).png', 102);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T16%3A02%3A51.554927_image+(2).png', 103);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A04%3A56.985840_2020121801001085900047101.jpeg', 104);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A04%3A57.145395__122309948_301ce903-e9cc-4641-9568-268933794a58.jpeg', 105);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A15%3A41.882605_p1065596788137816_911_thum.jpeg', 108);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A19%3A12.143674_FLiBnvfacAAJZoR.jpeg', 109);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A21%3A01.324122_FLYQPjWaIAIaMxZ.jpeg', 110);


INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A28%3A07.134144_02.%E1%84%87%E1%85%A5%E1%84%89%E1%85%B3%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%85%E1%85%B2%E1%84%8C%E1%85%A1%E1%86%BC-%E1%84%8C%E1%85%A1%E1%86%BC%E1%84%87%E1%85%B5%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5.jpg', 111);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A29%3A06.349648_c3130a5e2dcc25eca2e68684abf533f0.jpeg', 117);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A31%3A03.964258_nt5t3324943r965vjle0.jpeg', 119);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A47%3A49.487894_%ED%99%94%EB%A9%B4+%EC%BA%A1%EC%B2%98+2022-02-14+154720.png', 83);

INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T16%3A01%3A59.462836_image+(1).png', 98);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T16%3A02%3A51.554927_image+(2).png', 97);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A04%3A56.985840_2020121801001085900047101.jpeg', 96);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A04%3A57.145395__122309948_301ce903-e9cc-4641-9568-268933794a58.jpeg', 122);

INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A15%3A41.882605_p1065596788137816_911_thum.jpeg', 97);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A19%3A12.143674_FLiBnvfacAAJZoR.jpeg', 76);

INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A21%3A01.324122_FLYQPjWaIAIaMxZ.jpeg', 77);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A28%3A07.134144_02.%E1%84%87%E1%85%A5%E1%84%89%E1%85%B3%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%85%E1%85%B2%E1%84%8C%E1%85%A1%E1%86%BC-%E1%84%8C%E1%85%A1%E1%86%BC%E1%84%87%E1%85%B5%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5.jpg', 65);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A29%3A06.349648_c3130a5e2dcc25eca2e68684abf533f0.jpeg', 64);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A31%3A03.964258_nt5t3324943r965vjle0.jpeg', 63);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A47%3A49.487894_%ED%99%94%EB%A9%B4+%EC%BA%A1%EC%B2%98+2022-02-14+154720.png', 62);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T16%3A01%3A59.462836_image+(1).png', 91);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T16%3A02%3A51.554927_image+(2).png', 92);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A04%3A56.985840_2020121801001085900047101.jpeg', 93);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A04%3A57.145395__122309948_301ce903-e9cc-4641-9568-268933794a58.jpeg', 96);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A15%3A41.882605_p1065596788137816_911_thum.jpeg', 97);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A19%3A12.143674_FLiBnvfacAAJZoR.jpeg', 102);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A21%3A01.324122_FLYQPjWaIAIaMxZ.jpeg', 141);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A28%3A07.134144_02.%E1%84%87%E1%85%A5%E1%84%89%E1%85%B3%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%85%E1%85%B2%E1%84%8C%E1%85%A1%E1%86%BC-%E1%84%8C%E1%85%A1%E1%86%BC%E1%84%87%E1%85%B5%E1%84%89%E1%85%A5%E1%86%AF%E1%84%8E%E1%85%B5.jpg', 143);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A29%3A06.349648_c3130a5e2dcc25eca2e68684abf533f0.jpeg', 54);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A31%3A03.964258_nt5t3324943r965vjle0.jpeg', 55);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T15%3A47%3A49.487894_%ED%99%94%EB%A9%B4+%EC%BA%A1%EC%B2%98+2022-02-14+154720.png', 50);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T16%3A01%3A59.462836_image+(1).png', 34);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-14T16%3A02%3A51.554927_image+(2).png', 37);





INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (10, 1, '진짜로?? ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 1, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 1, '오 참고할게요', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (10, 2, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 3, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 3, '저도 그거 타봤는데 좋던데', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 5, '지루해..', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (7, 5, '배고파ㅠㅠ 집 빨리좀 가고싶다', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 5, '저 버스 진짜 안옴 ㅡㅡ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 1, '8호선 잠실역도 사람 겁나 많음', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 11, '1호선 사람 디지게 많다 하..', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (7, 15, '와 나도 저거 타봄', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 21, '엌ㅋㅋㅋㅋ 별게 다 나오네', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (7, 21, '우리집 앞은 안오나??', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 21, '얼른 올라타서 후기 점', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 21, '세상 좋아졌넼ㅋㅋ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 4, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 37, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (1, 27, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 7, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 17, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (1, 18, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 38, '1호선 사람 디지게 많다 하..', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 11, '1호선 사람 디지게 많다 하..', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 71, '1호선 사람 디지게 많다 하..', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 82, '1호선 사람 디지게 많다 하..', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (10, 83, '1호선 사람 디지게 많다 하..', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 93, '우리집 앞은 안오나??', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (7, 45, '우리집 앞은 안오나??', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (5, 45, '우리집 앞은 안오나??', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (5, 55, '우리집 앞은 안오나??', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 81, '우리집 앞은 안오나??', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (1, 134, '진짜로?? ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 144, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 132, '오 참고할게요', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 124, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 103, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 103, '저도 그거 타봤는데 좋던데', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 123, '저도 그거 타봤는데 좋던데', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (7, 112, '저도 그거 타봤는데 좋던데', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (1, 111, '진짜로?? ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 109, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 98, '오 참고할게요', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (5, 97, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 95, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 96, '저도 그거 타봤는데 좋던데', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (1, 95, '진짜로?? ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 91, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 89, '오 참고할게요', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 88, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 87, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 86, '저도 그거 타봤는데 좋던데', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 85, '지루해..', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (7, 85, '배고파ㅠㅠ 집 빨리좀 가고싶다', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 84, '저 버스 진짜 안옴 ㅡㅡ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 83, '8호선 잠실역도 사람 겁나 많음', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 141, '1호선 사람 디지게 많다 하..', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (1, 114, '진짜로?? ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 117, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 112, '오 참고할게요', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 127, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 131, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 139, '저도 그거 타봤는데 좋던데', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 76, '지루해..', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (7, 77, '배고파ㅠㅠ 집 빨리좀 가고싶다', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 78, '저 버스 진짜 안옴 ㅡㅡ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 79, '8호선 잠실역도 사람 겁나 많음', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 71, '1호선 사람 디지게 많다 하..', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (1, 69, '진짜로?? ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 68, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 67, '오 참고할게요', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (1, 66, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 65, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 64, '저도 그거 타봤는데 좋던데', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 63, '지루해..', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (7, 62, '배고파ㅠㅠ 집 빨리좀 가고싶다', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 61, '저 버스 진짜 안옴 ㅡㅡ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 60, '8호선 잠실역도 사람 겁나 많음', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 11, '1호선 사람 디지게 많다 하..', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (1, 71, '진짜로?? ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 81, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 91, '오 참고할게요', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 102, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 103, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 38, '저도 그거 타봤는데 좋던데', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 59, '지루해..', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (7, 54, '배고파ㅠㅠ 집 빨리좀 가고싶다', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 53, '저 버스 진짜 안옴 ㅡㅡ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (10, 12, '8호선 잠실역도 사람 겁나 많음', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 111, '1호선 사람 디지게 많다 하..', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (1, 110, '진짜로?? ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 131, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 11, '오 참고할게요', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 22, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 53, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 63, '저도 그거 타봤는데 좋던데', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 35, '지루해..', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (10, 75, '배고파ㅠㅠ 집 빨리좀 가고싶다', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 45, '저 버스 진짜 안옴 ㅡㅡ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 21, '8호선 잠실역도 사람 겁나 많음', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 141, '1호선 사람 디지게 많다 하..', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (1, 17, '진짜로?? ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 18, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (10, 19, '오 참고할게요', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (10, 22, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 33, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 36, '저도 그거 타봤는데 좋던데', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 59, '지루해..', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (7, 52, '배고파ㅠㅠ 집 빨리좀 가고싶다', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 53, '저 버스 진짜 안옴 ㅡㅡ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 11, '8호선 잠실역도 사람 겁나 많음', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 121, '1호선 사람 디지게 많다 하..', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 17, '진짜로?? ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 17, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 17, '오 참고할게요', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (7, 28, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 39, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 34, '저도 그거 타봤는데 좋던데', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (10, 54, '지루해..', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 53, '배고파ㅠㅠ 집 빨리좀 가고싶다', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 53, '저 버스 진짜 안옴 ㅡㅡ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 12, '8호선 잠실역도 사람 겁나 많음', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 111, '1호선 사람 디지게 많다 하..', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 17, '진짜로?? ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 31, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 71, '오 참고할게요', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 82, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 83, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 83, '저도 그거 타봤는데 좋던데', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 85, '지루해..', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 95, '배고파ㅠㅠ 집 빨리좀 가고싶다', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (10, 95, '저 버스 진짜 안옴 ㅡㅡ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 44, '8호선 잠실역도 사람 겁나 많음', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 33, '1호선 사람 디지게 많다 하..', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 23, '진짜로?? ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 18, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 66, '오 참고할게요', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 123, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 23, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 10, '저도 그거 타봤는데 좋던데', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 77, '지루해..', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 57, '배고파ㅠㅠ 집 빨리좀 가고싶다', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (5, 54, '저 버스 진짜 안옴 ㅡㅡ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 15, '8호선 잠실역도 사람 겁나 많음', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 13, '1호선 사람 디지게 많다 하..', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 27, '진짜로?? ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (9, 37, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (10, 3, '오 참고할게요', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (10, 57, '그거 제꺼 같아요 ㅠㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 46, '맞아요 그 버스 불편해요ㅜㅠ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (8, 25, '저도 그거 타봤는데 좋던데', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 41, '지루해..', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (6, 52, '배고파ㅠㅠ 집 빨리좀 가고싶다', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (5, 53, '저 버스 진짜 안옴 ㅡㅡ', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 13, '8호선 잠실역도 사람 겁나 많음', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 61, '1호선 사람 디지게 많다 하..', 'VISIBLE', current_timestamp, current_timestamp);


INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 21, 1);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 21, 2);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 21, 3);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 21, 4);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 21, 5);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 21, 6);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 21, 7);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 21, 8);

INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 10, 1);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 10, 2);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 10, 3);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 10, 4);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 10, 5);

INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 2, 1);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 3, 1);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 2, 2);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 3, 2);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 4, 2);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 3, 3);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 4, 3);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 5, 3);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 6, 3);

INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 11, 1);

INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 23, 1);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 24, 2);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 25, 6);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 26, 2);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 21, 7);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 27, 7);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 22, 2);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 31, 3);

INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 61, 10);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 62, 10);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 63, 5);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 62, 2);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 63, 9);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 64, 6);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 63, 7);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 100, 9);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 75, 8);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 76, 3);