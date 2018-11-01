#DB 생성
SHOW character set;
CREATE DATABASE cg default CHARACTER SET 'utf8mb4'; 
SHOW DATABASES;
#DROP DATABASE cg

#사용자 생성
CREATE USER 'cg' identified by '1111';
# DROP USER 'cg'

#사용자권한부여
GRANT ALL PRIVILEGES ON *.* TO 'cg';
#REVOKE ALL ON *.* FROM 'cg'@'%';
