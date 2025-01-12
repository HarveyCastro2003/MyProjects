DROP DATABASE `case_study_oop`;

CREATE DATABASE `case_study_oop` ;

CREATE TABLE `case_study_oop`.`user_admin_login` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30) NOT NULL,
  `position` VARCHAR(10) NOT NULL,
  `contactNum` VARCHAR(11) NOT NULL,
  `address` VARCHAR(50) NOT NULL,
  `pin_code` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `case_study_oop`.`user_admin_login` 
(`username`, `position`, `contactNum`, `address`, `pin_code`) 
VALUES 
('Althea Manlapaz', 'Staff', '09094001600', 'Matatalaib, Tarlac Ctiy', 'Althea123'),
('Harvey Castro', 'Staff', '09095001700', 'Ungot, Tarlac City', 'Harvey123'),
('Justin Buan', 'Staff', '09096001800', 'Concepcion, Tarlac City', 'Justin123'),
('Shiela Mae Esquivel', 'Staff', '09097001900', 'San Rafael, Tarlac City', 'Shiela123');

CREATE TABLE `case_study_oop`.`view_orders` (
  `view_orders_id` INT NOT NULL AUTO_INCREMENT,
  `order_by` VARCHAR(30) NOT NULL,
  `order` VARCHAR(60) NOT NULL,
  `add_ons` VARCHAR(60) NOT NULL,
  `size` VARCHAR(20) NOT NULL,
  `milk_type` VARCHAR(20) NOT NULL,
  `sweetness` INT NOT NULL,
  `type` VARCHAR(10) NOT NULL,
  `num_pieces` INT NOT NULL,
  `price` DOUBLE(10,1) NOT NULL,
  PRIMARY KEY (`view_orders_id`));
