CREATE TABLE Member(
	userid varchar2(15) primary key,
	password varchar2(20) not null,
	name nvarchar2(10) not null,
	gender varchar2(2) not null,
	email varchar2(50) not null
	);
	
insert into Member values('junjun1116', 'aassddad123', '허준', '남', 'junjun1116@naver.com');

select * from Member;