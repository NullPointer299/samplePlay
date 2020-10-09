DROP TABLE IF EXISTS `language`;

CREATE TABLE IF NOT EXISTS `language`
(
 `id`           INT(11)     AUTO_INCREMENT,
 `name`         TEXT        NOT NULL,
 `experience`   INT(3)      NOT NULL,
    PRIMARY KEY(`id`)
);

DROP TABLE IF EXISTS `user`;

CREATE TABLE IF NOT EXISTS `user`
(
 `id`           INT         AUTO_INCREMENT,
 `user_id`      CHAR(4)     NOT NULL,
 `last_name`    TEXT        NOT NULL,
 `first_name`   TEXT        NOT NULL,
 `mail_address` TEXT        NOT NULL,
 `hire_date`    DATE        NOT NULL,
    PRIMARY KEY(`id`)
);
