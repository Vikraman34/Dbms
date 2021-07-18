
REM Drop table

drop table SungBy;
drop table Song;
drop table Album;
drop table Studio;
drop table Artist;
drop table Musician;


REM creating Musician table

CREATE TABLE Musician(
	m_id number(10) CONSTRAINT m_id_pk PRIMARY KEY,
	m_name varchar2(20),
	birth_place varchar2(20));

desc Musician;

REM creating Aritst table

CREATE TABLE Artist(
	ar_id number(10) CONSTRAINT ar_id_pk PRIMARY KEY,
	ar_name varchar2(20) CONSTRAINT ar_name_un UNIQUE);

desc Artist;


REM creating Studio table

CREATE TABLE Studio(
	s_name varchar2(20) CONSTRAINT s_name_pk PRIMARY KEY,
	address varchar2(50),
	phone varchar2(10));

desc Studio;

REM creating Album table

CREATE TABLE Album(
	a_name varchar2(20),
	a_id number(10) CONSTRAINT a_id_pk PRIMARY KEY,
	year_of_release number(4) CONSTRAINT y_ch CHECK(year_of_release>1945),
	no_of_tracks number(10) CONSTRAINT no_of_tracks_nn NOT NULL,
	s_name varchar2(20),
	genre varchar2(10) CONSTRAINT a_ch CHECK(genre in('CAR','DIV','MOV','POP')),
	m_id number(10),
	CONSTRAINT s_name_fk FOREIGN KEY(s_name) REFERENCES Studio(s_name),
	CONSTRAINT a_id_fk FOREIGN  KEY(m_id) REFERENCES Musician(m_id));

desc Album;

REM creating song table

CREATE TABLE Song(
	a_id number(10),
	track_no number(10),
	s_name varchar2(20),
	length number(10),
	genre varchar2(10) CONSTRAINT song_ch CHECK(genre IN('PHI','REL','LOV','DEV','PAT')),
	CONSTRAINT s_pk PRIMARY KEY(a_id,track_no),
	CONSTRAINT s_fk FOREIGN KEY(a_id) REFERENCES Album(a_id),
	CONSTRAINT s_pat CHECK (genre NOT IN ('PAT') OR length > 7));

desc Song;

REM creating SungBy table

CREATE TABLE SungBy(
	a_id  number(10),
	ar_id number(10),
	track_no number(10),
	rec_date date,
	CONSTRAINT sb_pk PRIMARY KEY(a_id,ar_id,track_no),
	CONSTRAINT sb_id_fk FOREIGN KEY(a_id,track_no) REFERENCES Song(a_id,track_no),
	CONSTRAINT sb_ar_id_fk FOREIGN KEY(ar_id) REFERENCES Artist(ar_id));

desc SungBy;


REM populating Musician table

INSERT INTO Musician VALUES(
	100,
	'Viki',
	'Coimbatore');


INSERT INTO Musician VALUES(
	101,
	'Ram',
	'Chennai');

 
INSERT INTO Musician VALUES(
	102,
	'Viki',
	'Erode');

INSERT INTO Musician VALUES(
	103,
	'Varsha',
	'Coimbatore');

REM populating Musician table(Invalid cases)

INSERT INTO Musician VALUES(
	100,			
	'Raj',
	'Erode');

REM populating Artist table

INSERT INTO Artist VALUES(
	1000,
	'Rahaman');


INSERT INTO Artist VALUES(
	1001,
	'Aniruth');


REM populating Artist table(Invalid cases)	

INSERT INTO Artist VALUES(
	1003,
	'Aniruth');

REM populating Studio table

INSERT INTO Studio VALUES(
	'Green Studios',
	'Chennai',
	'1234567890');

INSERT INTO Studio VALUES(
	'Apple Studios',
	'Coimbatore',
	'0987654321');

REM populating Studio table(Invlaid cases)

INSERT INTO Studio VALUES(
	'Apple Studios',
	'Coimbatore',
	'0987654321');

REM populating Album table

INSERT INTO Album VALUES
(
	'World',
	1,
	2019,
	7,
	'Green Studios',
	'POP',
	101);

INSERT INTO Album VALUES
(
	'Player',
	2,
	2018,
	10,
	'Apple Studios',
	'CAR',
	102);

INSERT INTO Album VALUES
(
	'Game',
	3,
	2018,
	10,
	'Green Studios',
	'MOV',
	100);

INSERT INTO Album VALUES
(
	'Game',
	4,
	2017,
	10,
	'Apple Studios',
	'MOV',
	101);

REM populating Album table(Invalid cases)

INSERT INTO Album VALUES
(
	'Game',
	3,
	2018,
	10,
	'Studios',
	'MOV',
	100);

REM populating Song table

INSERT INTO Song VALUES(
	1,
	5,
	'Senorita',
	10,
	'LOV');

INSERT INTO Song VALUES(
	2,
	6,
	'Loose You To Love Me',
	9,
	'PHI');


INSERT INTO Song VALUES(
	2,
	5,
	'rand',
	6,
	'PHI');

INSERT INTO Song VALUES(
	3,
	10,
	'Dont let me down',
	9,
	'PAT');

INSERT INTO Song VALUES(
	4,
	8,
	'Never say never',
	11,
	'PHI');

REM populating Song table(Invalid cases)

INSERT INTO Song VALUES(
	1,
	8,
	'temp',
	5,
	'PAT');

REM populating SungBy table

INSERT INTO SungBy VALUES
(
	1,
	1000,
	5,
	'03-mar-19'
);

INSERT INTO SungBy VALUES
(
	2,
	1001,
	6,
	'03-nov-19'
);

INSERT INTO SungBy VALUES
(
	3,
	1000,
	10,
	'03-apr-19'
);

INSERT INTO SungBy VALUES
(
	4,
	1001,
	8,
	'05-nov-18'
);

REM populating SungBy table(Invalid cases)

INSERT INTO SungBy VALUES
(
	100,
	1000,
	5,
	'03-mar-19'
);

SELECT * from Musician;

SELECT * FROM Artist;

SELECT * FROM Studio;

SELECT * FROM Album;

SELECT * FROM Song;

SELECT * FROM SungBy;

DELETE From Song where a_id=1;
DELETE FROM Album where a_id=2;
DELETE FROM SungBy where a_id=1;

INSERT INTO SungBy VALUES
(
	1,
	1000,
	5,
	'03-mar-19'
);

REM 10)It is necessary to represent the gender of an artist in the table.

desc Artist;

ALTER TABLE Artist ADD Gender char(1);

desc Artist;
 

REM 11)The first few words of the lyrics constitute the song name. The song name do not accommodate some of the words (in lyrics).

desc Song;

ALTER TABLE Song MODIFY s_name varchar2(50);

desc Song;


REM 12)The phone number of each studio should be different.

desc Studio;

ALTER TABLE Studio ADD CONSTRAINT phone_un UNIQUE(phone);

desc Studio;


REM 13)An artist who sings a song for a particular track of an album can not be recorded without the record_date.

desc SungBy;

ALTER TABLE SungBy MODIFY rec_date NOT NULL;

desc SungBy;

REM 14)It was decided to include the genre NAT for nature songs.

ALTER TABLE Song DROP CONSTRAINT song_ch;

ALTER TABLE Song ADD CONSTRAINT song_ch CHECK(genre IN('PHI','REL','LOV','DEV','PAT','NAT'));

REM 15)Due to typoerror,there may be a possibility of false information. Hence while deleting the song information, make sure that all the corresponding information are also deleted

ALTER TABLE Album DROP CONSTRAINT s_name_fk;
ALTER TABLE Album DROP CONSTRAINT a_id_fk;
ALTER TABLE Song Drop CONSTRAINT s_fk;
ALTER TABLE SungBy DROP CONSTRAINT sb_id_fk;
ALTER TABLE SungBy DROP CONSTRAINT sb_ar_id_fk;


ALTER TABLE Album ADD CONSTRAINT s_name_fk FOREIGN KEY(s_name) REFERENCES Studio(s_name) ON DELETE CASCADE;
ALTER TABLE Album ADD CONSTRAINT a_id_fk FOREIGN  KEY(m_id) REFERENCES Musician(m_id) ON DELETE CASCADE;
ALTER TABLE Song ADD CONSTRAINT s_fk FOREIGN KEY(a_id) REFERENCES Album(a_id);
ALTER TABLE SungBy ADD CONSTRAINT sb_id_fk FOREIGN KEY(a_id,track_no) REFERENCES Song(a_id,track_no) ON DELETE CASCADE;
ALTER TABLE SungBy ADD CONSTRAINT sb_ar_id_fk FOREIGN KEY(ar_id) REFERENCES Artist(ar_id) ON DELETE CASCADE;


REM checking the alterations
REM 10
desc Artist;

REM 11
desc Song

REM 12 violating unique constarint
INSERT INTO Studio VALUES(
	'r1',
	'Pondy',
	'1234'	
);

REM 13
desc SungBy;

REM 14
INSERT INTO Song VALUES(
	1,
	6,
	'Loose You To Love Me',
	9,
	'NAT');
SELECT * FROM Song;

REM 15
DELETE FROM Song Where a_id = 1;
DELETE FROM Album Where a_id = 1;
SELECT * FROM Song;
SELECT * FROM SungBy;


