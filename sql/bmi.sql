-- -----------------------------------------------------
-- Schema BMI
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `BMI`;

-- -----------------------------------------------------
-- Schema BMI
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BMI` DEFAULT CHARACTER SET utf8;
USE `BMI`;

-- -----------------------------------------------------
-- Table `Bmi_liste`
-- -----------------------------------------------------
DROP TABLE IF EXISTS Bmi_liste;

CREATE TABLE Bmi_liste (
	ID int NOT NULL AUTO_INCREMENT,
    dato datetime NOT NULL,
    height varchar(45) NOT NULL,
    weight varchar(45) NOT NULL,
    bmi decimal(10,2) NOT NULL,
    status varchar(45) NOT NULL,
    color varchar(45) NOT NULL,
    PRIMARY KEY (ID)
) ENGINE = InnoDB;