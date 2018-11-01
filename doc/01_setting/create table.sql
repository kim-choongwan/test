#DROP TABLE TB_BOARD
;

CREATE TABLE TB_BOARD(
   BOARD_ID      BIGINT(20)    NOT NULL AUTO_INCREMENT COMMENT '게시물번호'
  ,CONTENT       VARCHAR(2000)                         COMMENT '내용'      
  ,UPD_USER_ID   VARCHAR(20)   NOT NULL                COMMENT '수정자'    
  ,UPD_DTM       DATETIME      NOT NULL DEFAULT NOW()  COMMENT '수정일시'  
  ,REG_USER_ID   VARCHAR(20)   NOT NULL                COMMENT '등록자'    
  ,REG_DTM       DATETIME      NOT NULL DEFAULT NOW()  COMMENT '등록일시'  
  ,PRIMARY KEY (BOARD_ID)
) COMMENT='게시판'
;

INSERT INTO TB_BOARD(
   CONTENT             
  ,UPD_USER_ID       
  ,REG_USER_ID       
)VALUES(
   'TEST CONTENT'             
  ,'ADMIN'       
  ,'ADMIN'       
)
;
