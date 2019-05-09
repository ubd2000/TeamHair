
DROP TABLE Like CASCADE CONSTRAINTS PURGE;



DROP TABLE Comments CASCADE CONSTRAINTS PURGE;



DROP TABLE Follower CASCADE CONSTRAINTS PURGE;



DROP TABLE Following CASCADE CONSTRAINTS PURGE;



DROP TABLE Profile CASCADE CONSTRAINTS PURGE;



DROP TABLE Reservation CASCADE CONSTRAINTS PURGE;



DROP TABLE Photo CASCADE CONSTRAINTS PURGE;



DROP TABLE Tags CASCADE CONSTRAINTS PURGE;



DROP TABLE RentalHistory CASCADE CONSTRAINTS PURGE;



DROP TABLE RentContract CASCADE CONSTRAINTS PURGE;



DROP TABLE Space CASCADE CONSTRAINTS PURGE;



DROP TABLE Branch CASCADE CONSTRAINTS PURGE;



DROP TABLE Code CASCADE CONSTRAINTS PURGE;



DROP TABLE BoardComments CASCADE CONSTRAINTS PURGE;



DROP TABLE Board CASCADE CONSTRAINTS PURGE;



DROP TABLE Users CASCADE CONSTRAINTS PURGE;



CREATE TABLE Board
(
	BoardID               NUMBER  NOT NULL ,
	BoardName             VARCHAR2(20)  NULL ,
	BoardSubject          VARCHAR2(50)  NULL ,
	BoardContent          VARCHAR2(2000)  NULL ,
	FileName              VARCHAR2(50)  NULL ,
	ReplyRef              NUMBER  DEFAULT 0 ,
	ReplyDepth            NUMBER  DEFAULT 0 ,
	ReplySeq              NUMBER  DEFAULT 0 ,
	CreateDate            DATE  DEFAULT SYSDATE ,
	UpdateDate            DATE  DEFAULT SYSDATE ,
	ReadCount             NUMBER  DEFAULT 0 ,
	Notice                VARCHAR2(10)  NULL ,
	UserID                VARCHAR2(50)  NOT NULL 
);



CREATE UNIQUE INDEX XPKBoard ON Board
(BoardID  ASC);



-- ALTER TABLE Board
--	ADD CONSTRAINT - XPKBoard PRIMARY KEY (BoardID);



CREATE TABLE BoardComments
(
	CommentID             NUMBER  NOT NULL ,
	Comments              VARCHAR2(300)  NULL ,
	CreateDate            DATE  DEFAULT SYSDATE ,
	UpdateDate            DATE  DEFAULT SYSDATE ,
	BoardID               NUMBER  NOT NULL ,
	UserID                VARCHAR2(50)  NOT NULL 
);



CREATE UNIQUE INDEX XPKBoardComments ON BoardComments
(CommentID  ASC);



--ALTER TABLE BoardComments
--	ADD CONSTRAINT  XPKBoardComments PRIMARY KEY (CommentID);



CREATE TABLE Branch
(
	BranchID              NUMBER  NOT NULL ,
	BranchName            VARCHAR2(100)  NULL ,
	Address1              VARCHAR2(200)  NULL ,
    Address2              VARCHAR2(200)  NULL ,
	PostalCode            VARCHAR2(5)  NULL ,
	Phone                 VARCHAR2(20)  NULL ,
	Map_X                 NUMBER  NULL ,
	Map_Y                 NUMBER  NULL 
);



CREATE UNIQUE INDEX XPKBranch ON Branch
(BranchID  ASC);



--ALTER TABLE Branch
--	ADD CONSTRAINT  XPKBranch PRIMARY KEY (BranchID);



CREATE TABLE Code
(
	ClassCode             VARCHAR2(10)  NULL ,
	ClassName             VARCHAR2(50)  NULL ,
	Code                  VARCHAR2(10)  NULL ,
	CodeName              VARCHAR2(50)  NULL 
);



CREATE TABLE Comments
(
	CommentID             INTEGER  NOT NULL ,
	Comments              VARCHAR2(300)  NULL ,
	PhotoID               NUMBER  NOT NULL ,
	CreateDate            DATE  NULL ,
	UpdateDate            DATE  NULL ,
	wasUser               VARCHAR2(1)  NULL 
);



CREATE UNIQUE INDEX XPKComments ON Comments
(CommentID  ASC);



--ALTER TABLE Comments
--	ADD CONSTRAINT  XPKComments PRIMARY KEY (CommentID);



CREATE TABLE Follower
(
	FollowerID            VARCHAR2(20)  NOT NULL ,
	UserID                VARCHAR2(50)  NOT NULL 
);



CREATE UNIQUE INDEX XPKFollower ON Follower
(FollowerID  ASC,UserID  ASC);



--ALTER TABLE Follower
--	ADD CONSTRAINT  XPKFollower PRIMARY KEY (FollowerID,UserID);



CREATE TABLE Following
(
	FollowingID           VARCHAR2(20)  NOT NULL ,
	UserID                VARCHAR2(50)  NOT NULL 
);



CREATE UNIQUE INDEX XPKFollowing ON Following
(FollowingID  ASC,UserID  ASC);



--ALTER TABLE Following
--	ADD CONSTRAINT  XPKFollowing PRIMARY KEY (FollowingID,UserID);



CREATE TABLE Likes
(
	PhotoID               NUMBER  NOT NULL ,
	UserID                VARCHAR2(50)  NOT NULL ,
	isLike                VARCHAR2(1)  NULL ,
	wasUser               VARCHAR2(1)  NULL 
);



CREATE UNIQUE INDEX XPKLike ON Likes
(PhotoID  ASC,UserID  ASC);



--ALTER TABLE Like
--	ADD CONSTRAINT  XPKLike PRIMARY KEY (PhotoID,UserID);



CREATE TABLE Photo
(
	PhotoID               NUMBER  NOT NULL ,
	FileName              VARCHAR2(50)  NOT NULL ,
	Description           VARCHAR2(300)  NULL ,
	UserID                VARCHAR2(50)  NOT NULL ,
	CreateDate            DATE  NULL ,
	UpdateDate            DATE  NULL 
);



CREATE UNIQUE INDEX XPKPhoto ON Photo
(PhotoID  ASC);



--ALTER TABLE Photo
--	ADD CONSTRAINT  XPKPhoto PRIMARY KEY (PhotoID);



CREATE TABLE Profile
(
	UserID                VARCHAR2(50)  NOT NULL ,
	Introduction          VARCHAR2(300)  NULL ,
	Website               VARCHAR2(100)  NULL ,
	PhotoName             VARCHAR2(50)  NULL 
);



CREATE UNIQUE INDEX XPKProfile ON Profile
(UserID  ASC);



--ALTER TABLE Profile
--	ADD CONSTRAINT  XPKProfile PRIMARY KEY (UserID);



CREATE TABLE RentalHistory
(
	UserID                VARCHAR2(50)  NOT NULL ,
	SpaceID               NUMBER  NOT NULL ,
	RentID                NUMBER  NOT NULL ,
	BaseDate              VARCHAR2(8)  NOT NULL ,
	RentalRevenue         NUMBER  NULL ,
	Discount              NUMBER  NULL ,
	PayMethod             VARCHAR2(4)  NULL 
);



CREATE UNIQUE INDEX XPKRentalHistory ON RentalHistory
(UserID  ASC,SpaceID  ASC,RentID  ASC,BaseDate  ASC);



--ALTER TABLE RentalHistory
--	ADD CONSTRAINT  XPKRentalHistory PRIMARY KEY (UserID,SpaceID,RentID,BaseDate);



CREATE TABLE RentContract
(
	UserID                VARCHAR2(50)  NOT NULL ,
	SpaceID               NUMBER  NOT NULL ,
	StartDate             DATE  NULL ,
	EndDate               DATE  NULL ,
	RentID                NUMBER  NOT NULL ,
	MonthlyRental         NUMBER  NULL ,
	DiscountAmount        NUMBER  NULL ,
	CreateDate            DATE  NULL ,
	UpdateDate            DATE  NULL ,
	Deposit               NUMBER  NULL ,
	PayMethod             VARCHAR2(4)  NULL 
);



CREATE UNIQUE INDEX XPKRentContract ON RentContract
(UserID  ASC,SpaceID  ASC,RentID  ASC);



--ALTER TABLE RentContract
--	ADD CONSTRAINT  XPKRentContract PRIMARY KEY (UserID,SpaceID,RentID);



CREATE TABLE Reservation
(
	PhotoID               NUMBER  NOT NULL ,
	ReserveID             NUMBER  NOT NULL ,
	StartDateTime         TIMESTAMP  NULL ,
	SpaceID               NUMBER  NOT NULL ,
	CreateDate            DATE  NULL ,
	UpdateDate            DATE  NULL ,
	EndDateTime           TIMESTAMP  NULL ,
	isCancel              VARCHAR2(1)  NULL ,
	UserID                VARCHAR2(50)  NOT NULL 
);



CREATE UNIQUE INDEX XPKReservation ON Reservation
(ReserveID  ASC);



--ALTER TABLE Reservation
--	ADD CONSTRAINT  XPKReservation PRIMARY KEY (ReserveID);



CREATE TABLE Space
(
	SpaceID               NUMBER  NOT NULL ,
	SpaceType             VARCHAR2(2)  NULL ,
	BranchID              NUMBER  NOT NULL ,
	SpaceName             VARCHAR2(100)  NULL 
);



CREATE UNIQUE INDEX XPKSpace ON Space
(SpaceID  ASC);



--ALTER TABLE Space
--	ADD CONSTRAINT  XPKSpace PRIMARY KEY (SpaceID);



CREATE TABLE Tags
(
	TagID                 INTEGER  NOT NULL ,
	TagName               VARCHAR2(300)  NULL 
);



CREATE UNIQUE INDEX XPKTags ON Tags
(TagID  ASC);



--ALTER TABLE Tags
--	ADD CONSTRAINT  XPKTags PRIMARY KEY (TagID);



CREATE TABLE Users
(
	UserID                VARCHAR2(50)  NOT NULL ,
	Passwords             VARCHAR2(50)  NOT NULL ,
	Email                 VARCHAR2(50)  NULL ,
	Phone                 VARCHAR2(50)  NULL ,
	Gender                VARCHAR2(1)  NOT NULL ,
	CreateDate            DATE  NULL ,
	UpdateDate            DATE  NULL ,
	isHairDesigner        VARCHAR2(1)  NOT NULL ,
	isActive              VARCHAR2(1)  NULL 
);



CREATE UNIQUE INDEX XPKUsers ON Users
(UserID  ASC);

/*

ALTER TABLE Users
	ADD CONSTRAINT  XPKUsers PRIMARY KEY (UserID);



ALTER TABLE Board
	ADD (CONSTRAINT  R_17 FOREIGN KEY (UserID) REFERENCES Users(UserID));



ALTER TABLE Board
	ADD (CONSTRAINT  R_20 FOREIGN KEY (BoardID) REFERENCES Board(BoardID) ON DELETE SET NULL);



ALTER TABLE BoardComments
	ADD (CONSTRAINT  R_18 FOREIGN KEY (BoardID) REFERENCES Board(BoardID));



ALTER TABLE BoardComments
	ADD (CONSTRAINT  R_19 FOREIGN KEY (UserID) REFERENCES Users(UserID));



ALTER TABLE Comments
	ADD (CONSTRAINT  R_4 FOREIGN KEY (PhotoID) REFERENCES Photo(PhotoID));



ALTER TABLE Follower
	ADD (CONSTRAINT  R_5 FOREIGN KEY (UserID) REFERENCES Users(UserID));



ALTER TABLE Following
	ADD (CONSTRAINT  R_6 FOREIGN KEY (UserID) REFERENCES Users(UserID));



ALTER TABLE Like
	ADD (CONSTRAINT  R_3 FOREIGN KEY (PhotoID) REFERENCES Photo(PhotoID));



ALTER TABLE Photo
	ADD (CONSTRAINT  R_2 FOREIGN KEY (UserID) REFERENCES Users(UserID));



ALTER TABLE Profile
	ADD (CONSTRAINT  R_7 FOREIGN KEY (UserID) REFERENCES Users(UserID));



ALTER TABLE RentalHistory
	ADD (CONSTRAINT  R_16 FOREIGN KEY (UserID,SpaceID,RentID) REFERENCES RentContract(UserID,SpaceID,RentID));



ALTER TABLE RentContract
	ADD (CONSTRAINT  R_11 FOREIGN KEY (UserID) REFERENCES Users(UserID));



ALTER TABLE RentContract
	ADD (CONSTRAINT  R_12 FOREIGN KEY (SpaceID) REFERENCES Space(SpaceID));



ALTER TABLE Reservation
	ADD (CONSTRAINT  R_8 FOREIGN KEY (PhotoID) REFERENCES Photo(PhotoID));



ALTER TABLE Reservation
	ADD (CONSTRAINT  R_15 FOREIGN KEY (SpaceID) REFERENCES Space(SpaceID));



ALTER TABLE Reservation
	ADD (CONSTRAINT  R_21 FOREIGN KEY (UserID) REFERENCES Users(UserID));



ALTER TABLE Space
	ADD (CONSTRAINT  R_10 FOREIGN KEY (BranchID) REFERENCES Branch(BranchID));


*/

CREATE SEQUENCE ID_SEQ
  START WITH 1
  INCREMENT BY 1
;

CREATE SEQUENCE BOARD_ID_SEQ
  START WITH 1
  INCREMENT BY 1
;


