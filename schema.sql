DROP TABLE IF EXISTS city;
CREATE TABLE IF NOT EXISTS city
(
    id        int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
    city_name varchar(255)     NOT NULL DEFAULT '' COMMENT 'City Name',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = 'City';
