drop database if exists bike;
create database bike;
use bike;


create table userLoginData (
	id int not null primary key auto_increment,
	userName varchar(50),
	userPassword varchar(16),
	userAge int,
	userMail varchar(50),
	userGender varchar(10),
	comment varchar(1000),
	bike1 varchar(50),
	bike2 varchar(50),
	bike3 varchar(50),
	img varchar(255)
);



create table ivent (
	id int not null primary key auto_increment,
	iventName varchar(50),
	iventDate date,
	rindo_id int,
	rindoName varchar(50),
	sponsor varchar(50),
	sponsor_id int,
	maxPeople int,
	currentPeople int,
	comment varchar(1000),
	participant1 varchar(50),
	participant1_id int,
	participant2 varchar(50),
	participant2_id int,
	participant3 varchar(50),
	participant3_id int,
	createDate date
);

create table rindo (
	id int not null primary key auto_increment,
	rindoName varchar(50),
	rindoPlaceName varchar(50),
	difficulty int,
	img1 varchar(255),
	img2 varchar(255),
	img3 varchar(255),
	comment varchar(1000),
	latitude DOUBLE,
	longitude DOUBLE,
	updateDate date
);

INSERT INTO userLoginData (userName,userPassword,userAge,userMail,userGender) VALUES ("hosoda","123",26,"hosoda@aaaaaa","男");
INSERT INTO userLoginData (userName,userPassword,userAge,userMail,userGender) VALUES ("さくらい","123",26,"sakurai@aaaaaa","男");

INSERT INTO rindo (rindoName,rindoPlaceName,difficulty,comment,latitude,longitude,img1) VALUES ("スーパー林道天龍","中部地方",2,"初心者でも楽しめる林道。フラットダートで見晴らしがよく、比較的安全です。山頂からの眺めは格別です。","34.9473399","137.8347025","../img/rindoImg1.jpg");
INSERT INTO rindo (rindoName,rindoPlaceName,difficulty,comment,latitude,longitude,img1) VALUES ("山道","四国地方",1,"四国の酷道。","33.7833276","133.5223045","../img/rindoImg2.jpg");
INSERT INTO rindo (rindoName,rindoPlaceName,difficulty,comment,latitude,longitude,img1) VALUES ("皇居","関東地方",3,"皇居。","35.6850073","139.7529505","../img/rindoImg3.jpg");

INSERT INTO ivent (iventName,iventDate,rindo_id,rindoName,sponsor,sponsor_id,maxPeople,currentPeople,comment) VALUES ("林道楽しもう", "2019/07/21",1,"スーパー林道天龍","hosoda",1,4,1,"楽しもう");
INSERT INTO ivent (iventName,iventDate,rindo_id,rindoName,sponsor,sponsor_id,maxPeople,currentPeople,comment) VALUES ("林道楽しもう", "2017/07/21",1,"スーパー林道天龍","hosoda",1,4,1,"楽しもう");
INSERT INTO ivent (iventName,iventDate,rindo_id,rindoName,sponsor,sponsor_id,maxPeople,currentPeople,comment) VALUES ("林道楽しもう3", "2018/08/21",1,"スーパー林道天龍","さくらい",2,4,1,"楽しもう");
INSERT INTO ivent (iventName,iventDate,rindo_id,rindoName,sponsor,sponsor_id,maxPeople,currentPeople,comment) VALUES ("林道楽しもう4", "2018/06/10",1,"スーパー林道天龍","hosoda",1,4,1,"楽しもう");
INSERT INTO ivent (iventName,iventDate,rindo_id,rindoName,sponsor,sponsor_id,maxPeople,currentPeople,comment) VALUES ("林道楽しもう5", "2018/01/21",2,"山道","hosoda",1,4,1,"楽しもう");
INSERT INTO ivent (iventName,iventDate,rindo_id,rindoName,sponsor,sponsor_id,maxPeople,currentPeople,comment) VALUES ("林道楽しもう6", "2018/03/21",2,"山道","さくらい",2,4,1,"楽しもう");
INSERT INTO ivent (iventName,iventDate,rindo_id,rindoName,sponsor,sponsor_id,maxPeople,currentPeople,comment) VALUES ("林道楽しもう7", "2018/07/21",2,"山道","hosoda",1,4,1,"楽しもう");
