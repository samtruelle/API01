--drop table user;
create table if not exists user( 
	user_id integer NOT NULL AUTO_INCREMENT,
	password varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	first_name varchar(30) NOT NULL,
	last_name varchar(60) NOT NULL,
	adress varchar(60),
	telephone integer,
	creation_date timestamp,
	account_blocked integer,
	admin integer,
	PRIMARY KEY (user_id),
	UNIQUE KEY email (email)
);
--drop table idea;
create table if not exists idea(
 idea_id integer AUTO_INCREMENT,
 description text NOT NULL,
 application text NOT NULL,
 targeted_market text NOT NULL,
 fund DOUBLE,
 state ENUM("proposal","discussion","redaction","evaluation","fund"),
 long_summary text,
 PRIMARY KEY (idea_id) 
 );

--drop table detailed_score;
create table if not exists detailed_score(
 detailed_score integer NOT NULL AUTO_INCREMENT,
 feasability integer,
 market_interest integer,
 impact integer,
 idea_id integer,
 PRIMARY KEY (detailed_score),
 FOREIGN KEY (idea_id) REFERENCES idea(idea_id)
);

--drop table up_score;
create table if not exists up_score(
up_id integer NOT NULL AUTO_INCREMENT,
value integer NOT NULL,
user integer NOT NULL,
idea integer NOT NULL,
PRIMARY KEY (up_id),
FOREIGN KEY (user) REFERENCES user(user_id),
FOREIGN KEY (idea) REFERENCES idea(idea_id)
);