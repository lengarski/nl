CREATE USER 'nlpc'@'%' IDENTIFIED BY 'nlpc';
GRANT ALL PRIVILEGES ON nlpc.* TO 'nlpc'@'%';


FLUSH PRIVILEGES;
create database nlpc;
