CREATE TABLE board(

	bno NUMBER(8),
	name NVARCHAR2(10) NOT NULL,
	password VARCHAR(15) NOT NULL,
	title NVARCHAR2(50) NOT NULL,
	content NVARCHAR2(1000) NOT NULL,
	attach NVARCHAR2(100),
	
	re_ref NUMBER(8) NOT NULL,
	re_lev NUMBER(8) NOT NULL,
	re_seq NUMBER(8) NOT NULL,
	
	readcount NUMBER(8) DEFAULT 0,
	regdate DATE DEFAULT sysdate);
	

ALTER TABLE board ADD CONSTRAINT pk_board PRIMARY KEY(bno);

CREATE SEQUENCE board_seq;

select * from board;

select * from USER_TABLES;

-- 더미데이터(페이지 만들기)

INSERT INTO board(bno, name, password, title, content, re_ref, re_lev, re_seq)
(SELECT board_seq.nextval, name, password, title, content, board_seq.currval, re_lev, re_seq FROM board);

select * from board where bno=(select max(bno) from board);

-- 가장 최신글에 댓글달기
-- re_ref(그룹번호:원본글의 re_ref번호)
-- re_lev(원본 글의 댓글인지, 댓글의 댓글인지 : 원본글의 re_lev+1)
-- re_seq(댓글 순서 : re_seq+1)
insert into board(bno, name, password, title, content, attach, re_ref, re_lev, re_seq)
values(board_seq.nextval, 'Tester', '123', '댓글 테스트', '댓글 테스트중입니다.', null, 2310, 1, 1);

-- 원본글과 댓글 가져오기
select bno, name, re_ref, re_lev, re_seq from board where re_ref=2310 order by re_seq;

-- 댓글 작업하기
-- 1. 기존 댓글의 reseq 값 변경하기(기존 댓글이 존재한다면 re_seq+1를 할 것)
update board set re_seq = re_seq+1 where re_ref = 2310 and re_seq > 0;

-- 2. 댓글 삽입
-- 두번째 댓글
insert into board(bno, name, password, title, content, attach, re_ref, re_lev, re_seq)
values(board_seq.nextval, 'Tester', '123', '댓글 테스트 두번째', '댓글 테스트중입니다.', null, 2310, 1, 1);

-- 3. 원본과 댓글 가져오기
select bno, name, re_ref, re_lev, re_seq from board where re_ref=2310 order by re_seq;


-- 댓글에 댓글달기(원본글의 re_ref, re_seq, re_lev)
-- 1. 기존 댓글의 reseq 값 변경하기(기존 댓글이 존재한다면 re_seq+1를 할 것)
-- [re_seq > 1] == 원본글의 re_seq 보다 큰 것. 
update board set re_seq = re_seq+1 where re_ref = 2310 and re_seq > 1;

-- 2. 두번째 댓글
-- re_ref(그룹번호:원본글의 re_ref번호)
-- re_lev(원본 글의 댓글인지, 댓글의 댓글인지 : 원본글의 re_lev+1)
-- re_seq(댓글 순서 : re_seq+1)
insert into board(bno, name, password, title, content, attach, re_ref, re_lev, re_seq)
values(board_seq.nextval, 'Viewer', '123', 'Re:댓글 테스트 - 1', '댓글 테스트중입니다.', null, 2310, 2, 2);

-- 3. 원본과 댓글 가져오기
select bno, name, re_ref, re_lev, re_seq from board where re_ref=2310 order by re_seq;

