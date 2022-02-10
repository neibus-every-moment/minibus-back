INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('sample@google.com', 'sample' ,'https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png');
INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('bample@naver.com', 'bample','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png');
INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('sam@naver.com', 'sam','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.943884_test_image2.png');
INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('ple@naver.com', 'ple','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.943884_test_image2.png');
INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('ample@google.com', 'ample','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png');
INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('song@naver.com', 'song','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png');
INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('jaein@naver.com', 'jaein','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png');
INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('apple@naver.com', 'apple','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png');
INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('banana@naver.com', 'banana','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png');
INSERT INTO USER (EMAIL, NICKNAME, PROFILE_IMAGE) VALUES ('minibus@naver.com', 'minibus','https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png');

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

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'test', 'VISIBLE',1,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'test', 'VISIBLE',1,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE',1,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'test', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE',1,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'test', 'VISIBLE',1,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'test', 'VISIBLE',1,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE',1,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'test', 'VISIBLE',1,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'test', 'VISIBLE', 3,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'test', 'VISIBLE', 4,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'test', 'VISIBLE', 1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'test', 'VISIBLE', 4,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'test', 'VISIBLE', 2,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE', 1,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'test', 'VISIBLE', 2,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'test', 'VISIBLE', 1,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'test', 'VISIBLE', 1,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'test', 'VISIBLE', 3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE',3,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'test', 'VISIBLE', 3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'test', 'VISIBLE', 4,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'test', 'VISIBLE',1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE',1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (9,'test', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (9,'test', 'VISIBLE', 3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (9,'test', 'VISIBLE',3,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'test', 'VISIBLE',3,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'test', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'test', 'VISIBLE',3,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'test', 'VISIBLE', 3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'test', 'VISIBLE', 4,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'test', 'VISIBLE',1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (10,'test', 'VISIBLE',1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (10,'test', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (10,'test', 'VISIBLE', 3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'test', 'VISIBLE',3,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'test', 'VISIBLE',3,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'test', 'VISIBLE',3,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'test', 'VISIBLE',3,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'test', 'VISIBLE',1,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE',2,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE',1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'test', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE',2,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'test', 'VISIBLE',1,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'test', 'VISIBLE',1,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE',1,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'test', 'VISIBLE',2,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'test', 'VISIBLE', 3,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'test', 'VISIBLE', 3,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE', 1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'test', 'VISIBLE', 4,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE', 2,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'test', 'VISIBLE', 3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'test', 'VISIBLE', 2,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'test', 'VISIBLE', 1,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE', 3,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'test', 'VISIBLE', 2,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'test', 'VISIBLE',3,4, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (5,'test', 'VISIBLE', 2,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'test', 'VISIBLE', 4,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'test', 'VISIBLE',2,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (5,'test', 'VISIBLE',3,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (5,'test', 'VISIBLE',3,2, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE', 3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (5,'test', 'VISIBLE',3,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (5,'test', 'VISIBLE',3,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'test', 'VISIBLE',3,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (6,'test', 'VISIBLE',2,3, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'test', 'VISIBLE', 3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (5,'test', 'VISIBLE', 4,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (5,'test', 'VISIBLE',2,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'test', 'VISIBLE',1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'test', 'VISIBLE',2,1, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (9,'test', 'VISIBLE', 3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (9,'test', 'VISIBLE',3,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'test', 'VISIBLE',2,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'test', 'VISIBLE',3,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (10,'test', 'VISIBLE',3,3, current_timestamp, current_timestamp);




INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'test', 'VISIBLE', 1,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (6,'test', 'VISIBLE', 1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (6,'test', 'VISIBLE',1,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE',2,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (8,'test', 'VISIBLE',2,1, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (10,'test', 'VISIBLE', 2,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'test', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'test', 'VISIBLE',3,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (9,'test', 'VISIBLE',3,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE',4,3, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (1,'test', 'VISIBLE', 4,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (5,'test', 'VISIBLE', 4,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'test', 'VISIBLE',1,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (3,'test', 'VISIBLE',1,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (4,'test', 'VISIBLE',1,1, current_timestamp, current_timestamp);

INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (5,'test', 'VISIBLE', 2,3, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE',1,1, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'test', 'VISIBLE',4,4, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (7,'test', 'VISIBLE',2,2, current_timestamp, current_timestamp);
INSERT INTO POST (USER_ID, CONTENT, STATUS, REGION_ID, TRANSPORT_ID, CREATED_AT, UPDATED_AT) VALUES (2,'test', 'VISIBLE',4,2, current_timestamp, current_timestamp);

INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 1);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.943884_test_image2.png', 1);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 2);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.943884_test_image2.png', 2);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 3);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.943884_test_image2.png', 3);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 4);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 5);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 6);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 1);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 17);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 30);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 1);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 2);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 10);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 31);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 13);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 11);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 7);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 21);

INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 23);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 55);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 62);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 55);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 55);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 19);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 33);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 44);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 33);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 44);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 24);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 26);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 27);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 26);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 45);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 59);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 49);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 14);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 23);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 64);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 36);
INSERT INTO IMAGE(PATH, POST_ID) VALUES ('https://minibus-bucket.s3.ap-northeast-2.amazonaws.com/minibus-image-testfolder/2022-02-09T17%3A37%3A53.401389_test_image.png', 51);





INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (1, 1, 'test comment1', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (1, 1, 'test comment2', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 1, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 2, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 3, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 3, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 5, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 5, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 5, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 1, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 11, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 15, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 21, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (1, 21, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 30, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 37, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 4, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 37, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (1, 27, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (3, 7, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (2, 17, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);
INSERT INTO COMMENT (USER_ID, POST_ID, CONTENT, STATUS, CREATED_AT, UPDATED_AT) VALUES (4, 18, 'test comment3', 'VISIBLE', current_timestamp, current_timestamp);

INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 1, 1);
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
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 21, 1);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 23, 1);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 24, 2);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 25, 6);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 26, 2);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 26, 7);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 27, 7);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 28, 7);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 29, 8);

INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 61, 10);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 62, 10);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 63, 5);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 62, 2);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 63, 9);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 64, 6);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 63, 7);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 74, 8);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 75, 8);
INSERT INTO LIKE_POST(ID, CREATED_AT, POST_ID, USER_ID) VALUES(null, current_time(), 76, 3);