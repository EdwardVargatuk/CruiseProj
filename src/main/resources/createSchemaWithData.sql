-- MySQL Workbench Forward Engineering


SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Schema cruisedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cruisedb` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `cruisedb`;

-- -----------------------------------------------------
-- Table `cruisedb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cruisedb`.`user`
(
  `id`        INT                      NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(30)              NOT NULL,
  `password`  VARCHAR(12)              NOT NULL,
  `role`      ENUM ('OWNER', 'CLIENT') NOT NULL,

  PRIMARY KEY (`id`)

)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;

-- -----------------------------------------------------
-- Table `cruisedb`.`cruise`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cruisedb`.`cruise`
(
  `id`           INT                       NOT NULL AUTO_INCREMENT,
  `ship_id`      INT                       NOT NULL,
  `cruise_class` ENUM ('USUAL', 'PREMIUM') NOT NULL,
  `price`        DOUBLE                    NOT NULL,
  `date`         DATE                      NOT NULL,

  PRIMARY KEY (`id`),
  FOREIGN KEY (ship_id)
    REFERENCES cruisedb.ship (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;

-- -----------------------------------------------------
-- Table `cruisedb`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cruisedb`.`order`
(
  `id`          INT    NOT NULL AUTO_INCREMENT,
  `cruise_id`   INT    NOT NULL,
  `total_price` DOUBLE NOT NULL,
  `client_id`   INT    NOT NULL,

  PRIMARY KEY (`id`),
  FOREIGN KEY (cruise_id)
    REFERENCES cruisedb.cruise (id),
  FOREIGN KEY (client_id)
    REFERENCES cruisedb.user (id)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `cruisedb`.`ship`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cruisedb`.`ship`
(
  `id`                 INT         NOT NULL AUTO_INCREMENT,
  `ship_name`          VARCHAR(30) NOT NULL,
  `passenger_capacity` INT         NOT NULL,
  `count_of_ports`     INT         NOT NULL,
  `tour_duration`      INT         NOT NULL,
  `staff`              INT         NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `cruisedb`.`ports`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cruisedb`.`ports`
(
  `id`        INT         NOT NULL AUTO_INCREMENT,
  `port_name` VARCHAR(30) NOT NULL,


  PRIMARY KEY (`id`)

)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `cruisedb`.`ship_ports`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cruisedb`.`ship_ports`
(

  `ship_id` INT NOT NULL,
  `port_id` INT NOT NULL,


  FOREIGN KEY (ship_id)
    REFERENCES cruisedb.ship (id),

  FOREIGN KEY (port_id)
    REFERENCES cruisedb.ports (id)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `cruisedb`.`excursion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cruisedb`.`excursion`
(
  `id`              INT         NOT NULL AUTO_INCREMENT,
  `excursion_name`  VARCHAR(30) NOT NULL,
  `excursion_price` DOUBLE      NOT NULL,

  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `cruisedb`.`ports_excursions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cruisedb`.`ports_excursions`
(
  `port_id`      INT NOT NULL,
  `excursion_id` INT NOT NULL,
  FOREIGN KEY (port_id)
    REFERENCES cruisedb.ports (id),

  FOREIGN KEY (excursion_id)
    REFERENCES cruisedb.excursion (id)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `cruisedb`.`bonus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cruisedb`.`bonus`
(
  `id`         INT         NOT NULL AUTO_INCREMENT,
  `bonus_name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;

-- -----------------------------------------------------
-- Table `cruisedb`.`cruise_bonus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cruisedb`.`cruise_bonus`
(
  `cruise_id` INT NOT NULL,
  `bonus_id`  INT NOT NULL,
  FOREIGN KEY (cruise_id)
    REFERENCES cruisedb.cruise (id),

  FOREIGN KEY (bonus_id)
    REFERENCES cruisedb.bonus (id)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;



SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `cruisedb`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `cruisedb`;
INSERT INTO `cruisedb`.`user` (`id`, `user_name`, `password`, `role`)
VALUES (1, 'Ed', 'admin', 'OWNER');
INSERT INTO `cruisedb`.`user` (`id`, `user_name`, `password`, `role`)
VALUES (2, 'Mark', '123', 'CLIENT');
INSERT INTO `cruisedb`.`user` (`id`, `user_name`, `password`, `role`)
VALUES (3, 'Сергей', '345', 'CLIENT');
INSERT INTO `cruisedb`.`user` (`id`, `user_name`, `password`, `role`)
VALUES (4, 'Виктор', '679', 'CLIENT');
INSERT INTO `cruisedb`.`user` (`id`, `user_name`, `password`, `role`)
VALUES (5, 'Ann', '91011', 'CLIENT');
INSERT INTO `cruisedb`.`user` (`id`, `user_name`, `password`, `role`)
VALUES (6, 'Emmi', '121314', 'CLIENT');
INSERT INTO `cruisedb`.`user` (`id`, `user_name`, `password`, `role`)
VALUES (7, 'Aleks', '151617', 'CLIENT');
INSERT INTO `cruisedb`.`user` (`id`, `user_name`, `password`, `role`)
VALUES (8, 'Ben', '181920', 'CLIENT');
INSERT INTO `cruisedb`.`user` (`id`, `user_name`, `password`, `role`)
VALUES (9, 'Holly', '212223', 'CLIENT');
INSERT INTO `cruisedb`.`user` (`id`, `user_name`, `password`, `role`)
VALUES (10, 'Marta', '242526', 'CLIENT');
INSERT INTO `cruisedb`.`user` (`id`, `user_name`, `password`, `role`)
VALUES (11, 'Tom', '272829', 'CLIENT');
INSERT INTO `cruisedb`.`user` (`id`, `user_name`, `password`, `role`)
VALUES (12, 'Bob', '303132', 'CLIENT');
INSERT INTO `cruisedb`.`user` (`id`, `user_name`, `password`, `role`)
VALUES (13, 'Jane', '333435', 'CLIENT');

COMMIT;

START TRANSACTION;
USE `cruisedb`;
INSERT INTO `cruisedb`.`ship` (`id`, `ship_name`, `passenger_capacity`, `count_of_ports`, `tour_duration`,
                               `staff`)
VALUES (1, 'SILJA LINE', 20, 8, 6, 5);
INSERT INTO `cruisedb`.`ship` (`id`, `ship_name`, `passenger_capacity`, `count_of_ports`, `tour_duration`,
                               `staff`)
VALUES (2, 'TALLINK', 10,
        5, 4, 3);
INSERT INTO `cruisedb`.`ship` (`id`, `ship_name`, `passenger_capacity`, `count_of_ports`, `tour_duration`,
                               `staff`)
VALUES (3, 'ЛЯЛЯ РАТУШНА', 5, 2, 1, 2);

COMMIT;


START TRANSACTION;
USE `cruisedb`;
INSERT INTO `cruisedb`.`ports` (`id`, `port_name`)
VALUES (1, 'Вінниця');
INSERT INTO `cruisedb`.`ports` (`id`, `port_name`)
VALUES (2, 'Летичів');
INSERT INTO `cruisedb`.`ports` (`id`, `port_name`)
VALUES (3, 'Одеса');
INSERT INTO `cruisedb`.`ports` (`id`, `port_name`)
VALUES (4, 'Batumi');
INSERT INTO `cruisedb`.`ports` (`id`, `port_name`)
VALUES (5, 'Istanbul');
INSERT INTO `cruisedb`.`ports` (`id`, `port_name`)
VALUES (6, 'Athens');
INSERT INTO `cruisedb`.`ports` (`id`, `port_name`)
VALUES (7, 'Naples');
INSERT INTO `cruisedb`.`ports` (`id`, `port_name`)
VALUES (8, 'Rome');

COMMIT;

START TRANSACTION;
USE `cruisedb`;
INSERT INTO `cruisedb`.`ship_ports` (`ship_id`, `port_id`)
VALUES (1, 1);
INSERT INTO `cruisedb`.`ship_ports` (`ship_id`, `port_id`)
VALUES (1, 2);
INSERT INTO `cruisedb`.`ship_ports` (`ship_id`, `port_id`)
VALUES (1, 3);
INSERT INTO `cruisedb`.`ship_ports` (`ship_id`, `port_id`)
VALUES (1, 4);
INSERT INTO `cruisedb`.`ship_ports` (`ship_id`, `port_id`)
VALUES (1, 5);
INSERT INTO `cruisedb`.`ship_ports` (`ship_id`, `port_id`)
VALUES (1, 6);
INSERT INTO `cruisedb`.`ship_ports` (`ship_id`, `port_id`)
VALUES (1, 7);
INSERT INTO `cruisedb`.`ship_ports` (`ship_id`, `port_id`)
VALUES (1, 8);
INSERT INTO `cruisedb`.`ship_ports` (`ship_id`, `port_id`)
VALUES (2, 1);
INSERT INTO `cruisedb`.`ship_ports` (`ship_id`, `port_id`)
VALUES (2, 2);
INSERT INTO `cruisedb`.`ship_ports` (`ship_id`, `port_id`)
VALUES (2, 3);
INSERT INTO `cruisedb`.`ship_ports` (`ship_id`, `port_id`)
VALUES (2, 4);
INSERT INTO `cruisedb`.`ship_ports` (`ship_id`, `port_id`)
VALUES (2, 5);
INSERT INTO `cruisedb`.`ship_ports` (`ship_id`, `port_id`)
VALUES (3, 1);
INSERT INTO `cruisedb`.`ship_ports` (`ship_id`, `port_id`)
VALUES (3, 2);

COMMIT;


START TRANSACTION;
USE `cruisedb`;
INSERT INTO `cruisedb`.`excursion` (`id`, `excursion_name`, `excursion_price`)
VALUES (1, 'fountain', 5);
INSERT INTO `cruisedb`.`excursion` (`id`, `excursion_name`, `excursion_price`)
VALUES (2, 'theater', 19.99);
INSERT INTO `cruisedb`.`excursion` (`id`, `excursion_name`, `excursion_price`)
VALUES (3, 'Водопад в Махунцети', 10);
INSERT INTO `cruisedb`.`excursion` (`id`, `excursion_name`, `excursion_price`)
VALUES (4, 'The Bosphorus', 25.5);
INSERT INTO `cruisedb`.`excursion` (`id`, `excursion_name`, `excursion_price`)
VALUES (5, 'Troy', 30);
INSERT INTO `cruisedb`.`excursion` (`id`, `excursion_name`, `excursion_price`)
VALUES (6, 'Athens museum', 15);
INSERT INTO `cruisedb`.`excursion` (`id`, `excursion_name`, `excursion_price`)
VALUES (7, 'Peloponnese', 40);
INSERT INTO `cruisedb`.`excursion` (`id`, `excursion_name`, `excursion_price`)
VALUES (8, 'Coliseum', 50);
INSERT INTO `cruisedb`.`excursion` (`id`, `excursion_name`, `excursion_price`)
VALUES (9, 'Vatican', 20);

COMMIT;

START TRANSACTION;
USE `cruisedb`;
INSERT INTO `cruisedb`.`ports_excursions` (`port_id`, `excursion_id`)
VALUES (1, 1);
INSERT INTO `cruisedb`.`ports_excursions` (`port_id`, `excursion_id`)
VALUES (8, 1);
INSERT INTO `cruisedb`.`ports_excursions` (`port_id`, `excursion_id`)
VALUES (3, 2);
INSERT INTO `cruisedb`.`ports_excursions` (`port_id`, `excursion_id`)
VALUES (6, 2);
INSERT INTO `cruisedb`.`ports_excursions` (`port_id`, `excursion_id`)
VALUES (4, 3);
INSERT INTO `cruisedb`.`ports_excursions` (`port_id`, `excursion_id`)
VALUES (5, 4);
INSERT INTO `cruisedb`.`ports_excursions` (`port_id`, `excursion_id`)
VALUES (5, 5);
INSERT INTO `cruisedb`.`ports_excursions` (`port_id`, `excursion_id`)
VALUES (6, 6);
INSERT INTO `cruisedb`.`ports_excursions` (`port_id`, `excursion_id`)
VALUES (6, 7);
INSERT INTO `cruisedb`.`ports_excursions` (`port_id`, `excursion_id`)
VALUES (8, 8);
INSERT INTO `cruisedb`.`ports_excursions` (`port_id`, `excursion_id`)
VALUES (8, 9);


COMMIT;


START TRANSACTION;
USE `cruisedb`;
INSERT INTO `cruisedb`.`bonus` (`id`, `bonus_name`)
VALUES (1, 'Pool');
INSERT INTO `cruisedb`.`bonus` (`id`, `bonus_name`)
VALUES (2, 'Gym');
INSERT INTO `cruisedb`.`bonus` (`id`, `bonus_name`)
VALUES (3, 'Bar');
INSERT INTO `cruisedb`.`bonus` (`id`, `bonus_name`)
VALUES (4, 'Cinema');
INSERT INTO `cruisedb`.`bonus` (`id`, `bonus_name`)
VALUES (5, 'Fishing');
INSERT INTO `cruisedb`.`bonus` (`id`, `bonus_name`)
VALUES (6, 'Photo');

COMMIT;


START TRANSACTION;
USE `cruisedb`;
INSERT INTO `cruisedb`.`cruise` (`id`, `ship_id`, `cruise_class`, `price`, `date`)
VALUES (1, 1, 'USUAL', 1499, '2019.01.25');
INSERT INTO `cruisedb`.`cruise` (`id`, `ship_id`, `cruise_class`, `price`, `date`)
VALUES (2, 1, 'PREMIUM', 1899, '2019.01.25');
INSERT INTO `cruisedb`.`cruise` (`id`, `ship_id`, `cruise_class`, `price`, `date`)
VALUES (3, 2, 'USUAL', 699.9, '2019.02.05');
INSERT INTO `cruisedb`.`cruise` (`id`, `ship_id`, `cruise_class`, `price`, `date`)
VALUES (4, 2, 'PREMIUM', 999, '2019.02.05');
INSERT INTO `cruisedb`.`cruise` (`id`, `ship_id`, `cruise_class`, `price`, `date`)
VALUES (5, 3, 'USUAL', 55.05, '2019.04.05');
INSERT INTO `cruisedb`.`cruise` (`id`, `ship_id`, `cruise_class`, `price`, `date`)
VALUES (6, 3, 'PREMIUM', 65.07, '2019.04.05');
COMMIT;

START TRANSACTION;
USE `cruisedb`;
INSERT INTO `cruisedb`.`cruise_bonus` (`cruise_id`, `bonus_id`)
VALUES (2, 1);
INSERT INTO `cruisedb`.`cruise_bonus` (`cruise_id`, `bonus_id`)
VALUES (2, 2);
INSERT INTO `cruisedb`.`cruise_bonus` (`cruise_id`, `bonus_id`)
VALUES (2, 3);
INSERT INTO `cruisedb`.`cruise_bonus` (`cruise_id`, `bonus_id`)
VALUES (2, 4);
INSERT INTO `cruisedb`.`cruise_bonus` (`cruise_id`, `bonus_id`)
VALUES (2, 5);
INSERT INTO `cruisedb`.`cruise_bonus` (`cruise_id`, `bonus_id`)
VALUES (4, 1);
INSERT INTO `cruisedb`.`cruise_bonus` (`cruise_id`, `bonus_id`)
VALUES (4, 3);
INSERT INTO `cruisedb`.`cruise_bonus` (`cruise_id`, `bonus_id`)
VALUES (4, 4);
INSERT INTO `cruisedb`.`cruise_bonus` (`cruise_id`, `bonus_id`)
VALUES (4, 6);
INSERT INTO `cruisedb`.`cruise_bonus` (`cruise_id`, `bonus_id`)
VALUES (6, 6);


COMMIT;


