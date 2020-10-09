INSERT INTO `language` VALUES (1, 'Scala', 0);
INSERT INTO `language` VALUES (2, 'Python', 5);
INSERT INTO `language` VALUES (3, 'Swift', 1);

LOAD DATA INFILE '/docker-entrypoint-initdb.d/DB_data.csv'
    INTO TABLE test_database.user
    FIELDS TERMINATED BY ',' ENCLOSED BY ''
    LINES TERMINATED BY '\n';
