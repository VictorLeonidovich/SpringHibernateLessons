CREATE TABLE CONTACT (
ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT
BY 1)
, FIRST_NAME VARCHAR(60) NOT NULL
, LAST_NAME VARCHAR(40) NOT NULL
, BIRTH_DATE DATE
, VERSION INT NOT NULL DEFAULT 0
, UNIQUE (FIRST_NAME, LAST_NAME)
, PRIMARY KEY (ID)
) ;

CREATE TABLE HOBBY (
HOBBY_ID VARCHAR(20) NOT NULL
, PRIMARY KEY (HOBBY_ID)
);

CREATE TABLE CONTACT_TEL_DETAIL(
ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT
BY 1)
, CONTACT_ID INT NOT NULL
, TEL_TYPE VARCHAR (20) NOT NULL
, TEL_NUMBER VARCHAR (20) NOT NULL
, VERSION INT NOT NULL DEFAULT 0
, UNIQUE (CONTACT_ID, TEL_TYPE)
, PRIMARY KEY (ID)
, CONSTRAINT FK_CONTACT_TEL_DETAIL_1 FOREIGN KEY (CONTACT_ID)
REFERENCES CONTACT (ID)
) ;

CREATE TABLE CONTACT_HOBBY_DETAIL (
CONTACT_ID INT NOT NULL
, HOBBY_ID VARCHAR(20) NOT NULL
, PRIMARY KEY (CONTACT_ID, HOBBY_ID)
, CONSTRAINT FK_CONTACT_HOBBY_DETAIL_1 FOREIGN KEY (CONTACT_ID)
REFERENCES CONTACT (ID) ON DELETE CASCADE
, CONSTRAINT FK_CONTACT_HOBBY_DETAIL_2 FOREIGN KEY (HOBBY_ID)
REFERENCES HOBBY (HOBBY_ID)
) ;