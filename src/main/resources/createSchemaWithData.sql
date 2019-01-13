-- MySQL Workbench Forward Engineering



# SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS;
# SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION;
# SET NAMES utf8;
# SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
# SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
# SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';
# SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0;
SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cruisedb
-- -----------------------------------------------------

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
  `id`       INT         NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(30) NOT NULL,
  `password` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `cruisedb`.`ship`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cruisedb`.`ship`
(
  `id`                 INT          NOT NULL AUTO_INCREMENT,
  `ship_name`          VARCHAR(30)  NOT NULL,
  `passenger_capacity` INT          NOT NULL,
  `route`              VARCHAR(255) NOT NULL,
  `count_of_ports`     INT          NOT NULL,
  `tour_duration`      INT          NOT NULL,
  `staff`              INT          NOT NULL,
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
#   `ship_id`   INT         NOT NULL,
  `port_name` VARCHAR(30) NOT NULL,
  `country`   VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`)
#   INDEX ship_id (ship_id),
#   FOREIGN KEY (ship_id)
#     REFERENCES cruisedb.ship (id)
#     ON DELETE NO ACTION
#     ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `cruisedb`.`route`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cruisedb`.`route`
(
  `id`      INT NOT NULL AUTO_INCREMENT,
  `ship_id` INT NOT NULL,
  `port_id` INT NOT NULL,

  PRIMARY KEY (`id`),
  INDEX ship_id (ship_id),
#   INDEX port_id (port_id),
  FOREIGN KEY (ship_id)
    REFERENCES cruisedb.ship (id)

#
#   FOREIGN KEY (port_id)
#     REFERENCES cruisedb.ports (id)




    ON DELETE NO ACTION
    ON UPDATE NO ACTION



)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;

# SET SQL_MODE=@OLD_SQL_MODE;
# SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
# SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
# SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT;
# SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS;
# SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION;
# SET SQL_NOTES=@OLD_SQL_NOTES;
SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `cruisedb`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `cruisedb`;
INSERT INTO `cruisedb`.`user` (`id`, `userName`, `password`)
VALUES (1, 'Ed', 'admin');
INSERT INTO `cruisedb`.`user` (`id`, `userName`, `password`)
VALUES (2, 'Mark', '123');
INSERT INTO `cruisedb`.`user` (`id`, `userName`, `password`)
VALUES (3, 'Сергей', '345');
INSERT INTO `cruisedb`.`user` (`id`, `userName`, `password`)
VALUES (4, 'Виктор', '679');
INSERT INTO `cruisedb`.`user` (`id`, `userName`, `password`)
VALUES (5, 'Ann', '91011');
INSERT INTO `cruisedb`.`user` (`id`, `userName`, `password`)
VALUES (6, 'Emmi', '121314');
INSERT INTO `cruisedb`.`user` (`id`, `userName`, `password`)
VALUES (7, 'Aleks', '151617');
INSERT INTO `cruisedb`.`user` (`id`, `userName`, `password`)
VALUES (8, 'Ben', '181920');
INSERT INTO `cruisedb`.`user` (`id`, `userName`, `password`)
VALUES (9, 'Holly', '212223');
INSERT INTO `cruisedb`.`user` (`id`, `userName`, `password`)
VALUES (10, 'Marta', '242526');
INSERT INTO `cruisedb`.`user` (`id`, `userName`, `password`)
VALUES (11, 'Tom', '272829');
INSERT INTO `cruisedb`.`user` (`id`, `userName`, `password`)
VALUES (12, 'Bob', '303132');

COMMIT;

# (SELECT route_ports FROM temp WHERE ship_id=1)
START TRANSACTION;
USE `cruisedb`;
INSERT INTO `cruisedb`.`ship` (`id`, `ship_name`, `passenger_capacity`, `route`, `count_of_ports`, `tour_duration`,
                               `staff`)
VALUES (1, 'SILJA LINE', 20, 'dsd', 8, 6, 5);
INSERT INTO `cruisedb`.`ship` (`id`, `ship_name`, `passenger_capacity`, `route`, `count_of_ports`, `tour_duration`,
                               `staff`)
VALUES (2, 'TALLINK', 10, 'sdfff',
        5, 4, 3);
INSERT INTO `cruisedb`.`ship` (`id`, `ship_name`, `passenger_capacity`, `route`, `count_of_ports`, `tour_duration`,
                               `staff`)
VALUES (3, 'ЛЯЛЯ РАТУШНА', 5, 'fff', 2, 1, 2);

COMMIT;



START TRANSACTION;
USE `cruisedb`;
INSERT INTO `cruisedb`.`route` (`id`, `ship_id`, `port_id`)
VALUES (1, 1, 1);
INSERT INTO `cruisedb`.`route` (`id`, `ship_id`, `port_id`)
VALUES (2, 1, 2);
INSERT INTO `cruisedb`.`route` (`id`, `ship_id`, `port_id`)
VALUES (3, 1, 3);
INSERT INTO `cruisedb`.`route` (`id`, `ship_id`, `port_id`)
VALUES (4, 1, 4);
INSERT INTO `cruisedb`.`route` (`id`, `ship_id`, `port_id`)
VALUES (5, 1, 5);
INSERT INTO `cruisedb`.`route` (`id`, `ship_id`, `port_id`)
VALUES (6, 1, 6);
INSERT INTO `cruisedb`.`route` (`id`, `ship_id`, `port_id`)
VALUES (7, 1, 7);
INSERT INTO `cruisedb`.`route` (`id`, `ship_id`, `port_id`)
VALUES (8, 1, 8);
INSERT INTO `cruisedb`.`route` (`id`, `ship_id`, `port_id`)
VALUES (9, 2, 1);
INSERT INTO `cruisedb`.`route` (`id`, `ship_id`, `port_id`)
VALUES (10, 2, 2);
INSERT INTO `cruisedb`.`route` (`id`, `ship_id`, `port_id`)
VALUES (11, 2, 3);
INSERT INTO `cruisedb`.`route` (`id`, `ship_id`, `port_id`)
VALUES (12, 2, 4);
INSERT INTO `cruisedb`.`route` (`id`, `ship_id`, `port_id`)
VALUES (13, 2, 5);
INSERT INTO `cruisedb`.`route` (`id`, `ship_id`, `port_id`)
VALUES (14, 3, 1);
INSERT INTO `cruisedb`.`route` (`id`, `ship_id`, `port_id`)
VALUES (15, 3, 2);

COMMIT;


START TRANSACTION;
USE `cruisedb`;
INSERT INTO `cruisedb`.`ports` (`id`, `port_name`, `country`)
VALUES (1, 'Вінниця', 'Україна');
INSERT INTO `cruisedb`.`ports` (`id`, `port_name`, `country`)
VALUES (2, 'Летичів', 'Україна');
INSERT INTO `cruisedb`.`ports` (`id`, `port_name`, `country`)
VALUES (3, 'Одеса', 'Україна');
INSERT INTO `cruisedb`.`ports` (`id`, `port_name`, `country`)
VALUES (4, 'Batumi', 'Georgia');
INSERT INTO `cruisedb`.`ports` (`id`, `port_name`, `country`)
VALUES (5, 'Istanbul', 'Turkey');
INSERT INTO `cruisedb`.`ports` (`id`, `port_name`, `country`)
VALUES (6, 'Athens', 'Greece');
INSERT INTO `cruisedb`.`ports` (`id`, `port_name`, `country`)
VALUES (7, 'Naples', 'Italy');
INSERT INTO `cruisedb`.`ports` (`id`, `port_name`, `country`)
VALUES (8, 'Rome', 'Italy');

COMMIT;

CREATE TABLE IF NOT EXISTS `cruisedb`.`temp` AS (SELECT route.ship_id, GROUP_CONCAT(ports.port_name) as route_ports FROM cruisedb.route LEFT JOIN ports ON ports.id = route.port_id group by route.ship_id);

UPDATE ship
SET route = (SELECT route_ports FROM temp WHERE ship_id=ship.id);
-- -----------------------------------------------------
-- Data for table `cruisedb`.`ship`
-- -----------------------------------------------------


#
# -- -----------------------------------------------------
# -- Data for table `parkdb`.`area`
# -- -----------------------------------------------------
# START TRANSACTION;
# USE `parkdb`;
# INSERT INTO `parkdb`.`area` (`id`, `name`, `description`, `taskmasterId`) VALUES (1, 'High trees', 'This park area has hight trees', 2);
# INSERT INTO `parkdb`.`area` (`id`, `name`, `description`, `taskmasterId`) VALUES (2, 'Big flowers', 'This park area has big flowers', 3);
#
# COMMIT;
#
#
# -- -----------------------------------------------------
# -- Data for table `parkdb`.`plant`
# -- -----------------------------------------------------
# START TRANSACTION;
# USE `parkdb`;
# INSERT INTO `parkdb`.`plant` (`id`, `name`, `state`, `imgPath`, `description`, `areaId`) VALUES (1, 'Rain Tree', 'NORMAL', 'https://www.nparks.gov.sg/~/media/nparks-real-content/activities/family-time-with-nature/know-10-trees/1-rain-tree/yellow-rt.jpg?h=300&&w=490&la=en', 'The large and majestic Rain Tree can be seen growing by our roadsides. It provides plenty of shade with its big umbrella-shaped crown', 1);
# INSERT INTO `parkdb`.`plant` (`id`, `name`, `state`, `imgPath`, `description`, `areaId`) VALUES (2, 'Angsana', 'NORMAL', 'https://www.nparks.gov.sg/~/media/nparks-real-content/activities/family-time-with-nature/know-10-trees/2-angsana/angsana-tree-main-pic.jpg?h=300&w=275&la=en', 'The Angsana is a large deciduous tree that grows up to 40m tall. It can be recognised by its drooping, dome-shaped crown. ', 1);
# INSERT INTO `parkdb`.`plant` (`id`, `name`, `state`, `imgPath`, `description`, `areaId`) VALUES (3, 'Yellow Flame', 'NORMAL', 'https://www.nparks.gov.sg/~/media/nparks-real-content/activities/family-time-with-nature/know-10-trees/3-yellow-flame/overall-main-pic.jpg?h=300&&w=436&la=en', 'The Yellow Flame grows up to 20m tall. It is a popular tree for roadside planting. It is drought-resistant, which makes it well adapted to Singapore’s sunny urban conditions.', 1);
# INSERT INTO `parkdb`.`plant` (`id`, `name`, `state`, `imgPath`, `description`, `areaId`) VALUES (4, 'Senegal Mahogany', 'NORMAL', 'https://www.nparks.gov.sg/~/media/nparks-real-content/activities/family-time-with-nature/know-10-trees/4-senegal-mahogany/overall-tree.jpg?h=300&&w=223&la=en', 'The Senegal Mahogany is a fast growing evergreen tree. It can grow to more than 30m in height, and has a girth of 1 – 2m. It has a straight, robust and cylindrical trunk, with buttresses at the base. ', 1);
# INSERT INTO `parkdb`.`plant` (`id`, `name`, `state`, `imgPath`, `description`, `areaId`) VALUES (5, 'Broad-leafed Mahogany', 'NORMAL', 'https://www.nparks.gov.sg/~/media/nparks-real-content/activities/family-time-with-nature/know-10-trees/5-broad-leafed-mahogany/overall-tree.jpg?h=300&&w=314&la=en', 'The Broad-leafed Mahogany is a large hardwood tree that can grow up to 30m or more. It can be easily recognised by its crown, which is dense dark green and round to oblong in shape. ', 1);
# INSERT INTO `parkdb`.`plant` (`id`, `name`, `state`, `imgPath`, `description`, `areaId`) VALUES (6, 'Tembusu', 'NORMAL', 'https://www.nparks.gov.sg/~/media/nparks-real-content/activities/family-time-with-nature/know-10-trees/6-tembusu/$5-tembusu-tree.jpg?h=300&&w=372&la=en', 'The Tembusu is one of Singapore’s most distinctive trees. This native of Singapore is a large, evergreen tree that grows up to 40m in height.', 1);
# INSERT INTO `parkdb`.`plant` (`id`, `name`, `state`, `imgPath`, `description`, `areaId`) VALUES (7, 'Saga', 'NORMAL', 'https://www.nparks.gov.sg/~/media/nparks-real-content/activities/family-time-with-nature/know-10-trees/8-saga/overall.jpg?h=300&&w=322&la=en', 'The Saga Tree is a deciduous tree that grows up to 15-20m tall. It is hardy, fast-growing, and low-maintenance.', 1);
# INSERT INTO `parkdb`.`plant` (`id`, `name`, `state`, `imgPath`, `description`, `areaId`) VALUES (8, 'Trumpet Tree', 'NORMAL', 'https://www.nparks.gov.sg/~/media/nparks-real-content/activities/family-time-with-nature/know-10-trees/9-trumpet-tree/overall-tree.jpg?h=300&&w=277&la=en', 'The Trumpet Tree grows up to 18-25m tall, and has a large, broadly conical and shady crown. The tree’s name comes from its large trumpet-shaped flowers, which range in colour from pink to white.', 1);
# INSERT INTO `parkdb`.`plant` (`id`, `name`, `state`, `imgPath`, `description`, `areaId`) VALUES (9, 'Sea Almond', 'NORMAL', 'https://www.nparks.gov.sg/~/media/nparks-real-content/activities/family-time-with-nature/know-10-trees/10-sea-almond/overall.jpg?h=300&w=448&la=en', 'The Sea Almond or Ketapang is a large coastal tree which grows up to 25m tall. It can be recognised by its distinct pagoda shape, formed by its tiered branching pattern.', 1);
# INSERT INTO `parkdb`.`plant` (`id`, `name`, `state`, `imgPath`, `description`, `areaId`) VALUES (10, 'Sea Apple', 'NORMAL', 'https://www.nparks.gov.sg/~/media/nparks-real-content/activities/family-time-with-nature/know-10-trees/7-sea-apple/overall-2.jpg?h=300&&w=207&la=en', 'The Sea Apple is a tall coastal tree of this region that grows up to 30m in height. It is a robust tree with large white flowers arranged in compact clusters with showy stamens. ', 1);
# INSERT INTO `parkdb`.`plant` (`id`, `name`, `state`, `imgPath`, `description`, `areaId`) VALUES (11, 'Anemone', 'NORMAL', 'http://www.namesofflowers.net/images/anemones-flower-1.jpg', 'The Anemone genus is part of the Ranunculaceae (buttercup) family. There are a little over 120 species of anemones in a wide range of colors.\n\nAnemones are popular in gardens as individual species flower in the spring, summer, or fall, providing continual color. ', 2);
# INSERT INTO `parkdb`.`plant` (`id`, `name`, `state`, `imgPath`, `description`, `areaId`) VALUES (12, 'The Aster', 'NORMAL', 'http://www.namesofflowers.net/images/aster-flower-1.jpg', 'The aster is a flower with a bit of a wild appearance, but it fits nicely in many garden settings. The aster flower is the birth flower for the month of September, and is often used to mark twenty years of marriage.\n\nIn gardens, asters continue to attract bees and butterflies long after most other flowers have disappeared. People have enjoyed the simple beauty of aster flowers for many generations, and it is likely that these flowers will continue to be celebrated for years to come. ', 2);
# INSERT INTO `parkdb`.`plant` (`id`, `name`, `state`, `imgPath`, `description`, `areaId`) VALUES (13, 'Begonia', 'NORMAL', 'http://www.namesofflowers.net/images/begonia.jpg', '', 2);
# INSERT INTO `parkdb`.`plant` (`id`, `name`, `state`, `imgPath`, `description`, `areaId`) VALUES (14, 'Bellflower', 'NORMAL', 'http://www.namesofflowers.net/images/bell-flower.jpg', '', 2);
# INSERT INTO `parkdb`.`plant` (`id`, `name`, `state`, `imgPath`, `description`, `areaId`) VALUES (15, 'Bergamot', 'NORMAL', 'http://www.namesofflowers.net/images/bee-balm.jpg', '', 2);
# INSERT INTO `parkdb`.`plant` (`id`, `name`, `state`, `imgPath`, `description`, `areaId`) VALUES (16, 'Bluebell', 'NORMAL', 'http://www.namesofflowers.net/images/bluebell.jpg', '', 2);
# INSERT INTO `parkdb`.`plant` (`id`, `name`, `state`, `imgPath`, `description`, `areaId`) VALUES (17, 'Camellia', 'NORMAL', 'http://www.namesofflowers.net/images/camellias-flower-1.jpg', 'Glossy green leaves, lovely blossoms, oil, and the invigorating beverage that spurred the American revolution all come from plants in the Camellia family.\n\nBeautiful in a naturalized wooded setting, functional as a flowering formal hedge, and lovely as a focal centerpiece, camellias are evergreen shrubs and small trees that grow well in slightly acidic soils with lots of humus and good drainage.\n\nAlmost all camellia plants are happiest with plentiful water. ', 2);
#
# COMMIT;
#
#
# -- -----------------------------------------------------
# -- Data for table `parkdb`.`credential`
# -- -----------------------------------------------------
# START TRANSACTION;
# USE `parkdb`;
# INSERT INTO `parkdb`.`credential` (`userId`, `login`, `password`) VALUES (1, 'admin', 'admin');
# INSERT INTO `parkdb`.`credential` (`userId`, `login`, `password`) VALUES (2, 'igor', 'igor');
# INSERT INTO `parkdb`.`credential` (`userId`, `login`, `password`) VALUES (3, 'ivan', 'ivan');
# INSERT INTO `parkdb`.`credential` (`userId`, `login`, `password`) VALUES (4, 'roman', 'roman');
# INSERT INTO `parkdb`.`credential` (`userId`, `login`, `password`) VALUES (5, 'evhen', 'evhen');
# INSERT INTO `parkdb`.`credential` (`userId`, `login`, `password`) VALUES (6, 'mykola', 'mykola');
#
# COMMIT;

