insert into contact (FIRST_NAME, LAST_NAME, BIRTH_DATE)
values ('Chris', 'Schaefer', '1981-05-03');
insert into contact (FIRST_NAME, LAST_NAME, BIRTH_DATE)
values ('Scott', 'Tiger', '1990-11-02');
insert into contact (FIRST_NAME, LAST_NAME, BIRTH_DATE)
values ('John', 'Smith', '1964-02-28');
insert into contact_tel_detail (CONTACT_ID, TEL_TYPE, TEL_NUMBER)
values ( 1, 'Mobile', '1234567890');
insert into contact_tel_detail (CONTACT_ID, TEL_TYPE, TEL_NUMBER)
values (1, 'Home', '1234567890');
insert into contact_tel_detail (CONTACT_ID, TEL_TYPE, TEL_NUMBER)
values (2, 'Home', '1234567890');
insert into hobby (HOBBY_ID) values ( 'Swimming' ) ;
insert into hobby (HOBBY_ID) values ( 'Jogging') ;
insert into hobby (HOBBY_ID) values ('Programming');
insert into hobby (HOBBY_ID) values ( 'Movies');
insert into hobby (HOBBY_ID) values ( 'Reading' ) ;
insert into contact_hobby_detail(CONTACT_ID, HOBBY_ID) values (1, 'Swimming');
insert into contact_hobby_detail(CONTACT_ID, HOBBY_ID) values (1, 'Movies');
insert into contact_hobby_detail(CONTACT_ID, HOBBY_ID) values (2, 'Swimming');