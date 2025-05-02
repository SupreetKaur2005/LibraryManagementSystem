-- Replace 'appuser' and 'apppassword' with your desired username and password
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'apppassword';

GRANT ALL PRIVILEGES ON highracy_db.* TO 'appuser'@'localhost';

FLUSH PRIVILEGES;
