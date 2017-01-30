CREATE TABLE `teachers` (
  `id`       INT           NOT NULL  AUTO_INCREMENT,
  `version`  INT           NOT NULL  DEFAULT 0,
  `name`     VARCHAR(255)  NOT NULL,
  `gender`   ENUM('MALE', 'FEMALE') NOT NULL,
  `age`      INT           NOT NULL,
  `created`  TIMESTAMP     NOT NULL  DEFAULT NOW(),
  `modified` TIMESTAMP     NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));