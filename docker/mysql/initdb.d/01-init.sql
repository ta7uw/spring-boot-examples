CREATE DATABASE IF NOT EXISTS `common_local`;
CREATE USER 'user'@'%' IDENTIFIED BY 'common_local';
GRANT ALL ON common_local.* TO 'user'@'%';

CREATE DATABASE IF NOT EXISTS `common_local_test`;
CREATE USER 'used'@'%' IDENTIFIED BY 'common_local_test';
GRANT ALL ON common_local_test.* TO 'user'@'%';

