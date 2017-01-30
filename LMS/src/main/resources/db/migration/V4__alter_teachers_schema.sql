ALTER TABLE `teachers`
ADD COLUMN `klasses_id` INT NOT NULL ,
ADD CONSTRAINT `fk_klasses_id` FOREIGN KEY(`klasses_id`)  REFERENCES  `klasses` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION;