create table users(
	username varchar(50) not null primary key,
	password varchar(200) not null,
	enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);

INSERT INTO users (username, password, enabled) values ('eduardo', '$2a$10$4Hz55NSFtp0qW.Am6Q/51uGjosoz5d1pWwgtPIwh0.Xi09AXyWWJu', true);
INSERT INTO authorities (username, authority) values ('eduardo', 'USER');