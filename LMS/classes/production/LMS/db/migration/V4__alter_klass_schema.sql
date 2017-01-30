ALTER TABLE `klasses`
ADD COLUMN `teachers_id` INT NOT NULL ,
ADD CONSTRAINT`fk_teacher_id` FOREIGN KEY(`teachers_id`)  REFERENCES `teachers`(`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
