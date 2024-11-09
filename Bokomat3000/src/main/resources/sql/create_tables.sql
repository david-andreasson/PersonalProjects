CREATE TABLE IF NOT EXISTS `User` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `apartmentNumber` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    `phonenumber` VARCHAR(45) NOT NULL,
    `password_hash` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `apartmentNumber_UNIQUE` (`apartmentNumber` ASC),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC)
    );

CREATE TABLE IF NOT EXISTS `Booking` (
`id` INT NOT NULL AUTO_INCREMENT,
`userId` INT NOT NULL,
`date` DATE NOT NULL,
`timeslot` TIME NOT NULL,
PRIMARY KEY (`id`),
    FOREIGN KEY (`userId`) REFERENCES `User` (`id`)
    );



