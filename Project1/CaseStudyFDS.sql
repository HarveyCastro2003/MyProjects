CREATE SCHEMA `casestudy_fds` ;

CREATE TABLE `casestudy_fds`.`employee` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(30) NOT NULL,
  `lname` VARCHAR(30) NOT NULL,
  `position` VARCHAR(30) NOT NULL,
  `phone_num` VARCHAR(11) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`employee_id`));
  
INSERT INTO `casestudy_fds`.`employee` 
(`fname`, `lname`, `position`, `phone_num`, `email`) 
VALUES 
('Harvey', 'Castro', 'Parts Specialist', '09995117878', 'harveycastro03@gmail.com'),
('Jonathan', 'Ocampo', 'Shop Manager', '09091225689', 'jonathanocampo04@gmail.com'),
('Paul', 'Lim', 'Sales Associate', '09115487812', 'paullim05@gmail.com'),
('Renzo', 'Tresenio', 'Sales Associate 1', '09956565700', 'renzotresenio06@gmail.com'),
('Shiela Mae', 'Esquivel', 'Sales Associate 2', '09956565745', 'shielamae07@gmail.com'),
('Maria Yzabella Ghryz', 'Arellano', 'Cashier 1', '09956489200', 'mariayzabellaghryz08@gmail.com'),
('Jack', 'Campos', 'Cashier 2', '09952224760', 'jackcampos09@gmail.com'),
('Marck', 'Dizon', 'Detailer', '09912345700', 'marckdizon10@gmail.com'),
('Julius', 'Daquigan', 'Receptionist', '09577225570', 'juliusdaquigan11@gmail.com'),
('Alexander', 'Buan', 'Service Advisor', '09996345700', 'alexanderbuan12@gmail.com');

  
CREATE TABLE `casestudy_fds`.`customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `employee_id1` INT NOT NULL,
  `fname` VARCHAR(30) NOT NULL,
  `lname` VARCHAR(30) NOT NULL,
  `phone_num` VARCHAR(11) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `address1` VARCHAR(50) NOT NULL,
  `city` VARCHAR(20) NOT NULL,
  `province` VARCHAR(20) NOT NULL,
  `country` VARCHAR(20) NOT NULL,
  `zip_code` VARCHAR(4) NULL,
  PRIMARY KEY (`customer_id`));

INSERT INTO `casestudy_fds`.`customer`
(`employee_id1`, `fname`, `lname`, `phone_num`, `email`, `address1`, `city`, `province`, `country`, `zip_code`)
VALUE 
('6', 'Joseph', 'Villanueva', '09458156714', 'josephvillanueva23@gmail.com', 'Chico Street Ungot', 'Tarlac', 'Tarlac', 'Philippines', '2300'),
('6', 'Leonardo', 'Campos', '09458156714', 'leonardocampos23@gmail.com', 'Chita Street Ungot', 'Tarlac', 'Tarlac', 'Philippines', '2300'),
('6', 'Cepriano', 'Corpuz', '09458156714', 'cepriancorpuz23@gmail.com', 'Apple Street Ungot', 'Tarlac', 'Tarlac', 'Philippines', '2300'),
('6', 'Josephine', 'Manlapaz', '09458156714', 'josephinemanlapaz23@gmail.com', 'Mango Street Ungot', 'Tarlac', 'Tarlac', 'Philippines', '2300'),
('6', 'Larry', 'Buan', '09458156714', 'larrybuan23@gmail.com', 'Lemon Street Ungot', 'Tarlac', 'Tarlac', 'Philippines', '2300'),
('7', 'Jack', 'Tobia', '09458156714', 'jacktobia23@gmail.com', 'Lemon Street Ungot', 'Tarlac', 'Tarlac', 'Philippines', '2300'),
('7', 'Garry', 'Alcantara', '09458156714', 'garryalcantara23@gmail.com', 'Apple Street Ungot', 'Tarlac', 'Tarlac', 'Philippines', '2300'),
('7', 'Julius', 'Laxamana', '09458156714', 'juliuslaxamana23@gmail.com', 'Chico Street Ungot', 'Tarlac', 'Tarlac', 'Philippines', '2300'),
('7', 'Gella', 'Fernandez', '09458156714', 'gellafernandez23@gmail.com', 'Chita Street Ungot', 'Tarlac', 'Tarlac', 'Philippines', '2300'),
('7', 'Mercy', 'Dizon', '09458156714', 'mercydizon23@gmail.com', 'Lemon Street Ungot', 'Tarlac', 'Tarlac', 'Philippines', '2300');
  
CREATE TABLE `casestudy_fds`.`order` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `customer_id1` INT NOT NULL,
  `product_id1` INT NOT NULL,
  `product_name` VARCHAR(30) NOT NULL,
  `quantity` INT NOT NULL,
  `selling_price` DECIMAL(8,2) NOT NULL,
  `total` DECIMAL(8,2) NOT NULL,
  `purchased_date` DATE NOT NULL,
  PRIMARY KEY (`order_id`));

INSERT INTO `casestudy_fds`.`order`
(`customer_id1`, `product_id1`, `product_name`, `quantity`, `selling_price`, `total`, `purchased_date`)
VALUE 
('1', '1', 'AIR SHROUD (FAN COVER)', '1', '136.75', '136.75', '2023/05/01'),
('2', '1', 'AIR SHROUD (FAN COVER)', '2', '136.75', '273.50', '2023/05/02'),
('3', '1', 'AIR SHROUD (FAN COVER)', '3', '136.75', '410.25', '2023/05/03'),
('4', '1', 'AIR SHROUD (FAN COVER)', '4', '136.75', '547.00', '2023/05/04'),
('5', '2', 'EMBLEM AEROX', '1', '319.09', '319.09', '2023/05/05'),
('6', '2', 'EMBLEM AEROX', '2', '319.09', '638.18', '2023/05/06'),
('7', '2', 'EMBLEM AEROX', '3', '319.09', '957.27', '2023/05/07'),
('8', '3', 'MTRT DRIVE FACE MIOi125', '1', '709.10', '709.10', '2023/05/08'),
('9', '3', 'MTRT DRIVE FACE MIOi125', '2', '709.10', '1418.20', '2023/05/09'),
('10', '3', 'MTRT DRIVE FACE MIOi125', '3', '709.10', '2127.30', '2023/05/10');
  
CREATE TABLE `casestudy_fds`.`product` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `supplier_id1` INT NOT NULL,
  `category/brand` VARCHAR(20) NOT NULL,
  `motor_part` VARCHAR(20) NOT NULL,
  `product_name` VARCHAR(40) NOT NULL,
  `quantity` INT NOT NULL,
  `supplier_price` DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (`product_id`));

INSERT INTO `casestudy_fds`.`product` 
(`supplier_id1`, `category/brand`, `motor_part`, `product_name`, `quantity`, `supplier_price`) 
VALUES 
('2', 'Yamaha', 'Genuine Parts', 'AIR SHROUD (FAN COVER)', '50', '135.00'),
('2', 'Yamaha', 'Genuine Parts', 'EMBLEM AEROX', '60', '315.00'),
('3', 'MTRT', 'Drive Face', 'MTRT DRIVE FACE MIOi125', '70', '700.00'),
('1', 'JVT', 'Clutch Bell', 'JVT CLUTCH BELL CLICK/PCX', '80', '1560.00'),
('1', 'JVT', 'Pulley Set', 'JVT PULLEY SET CLICK 125/150', '90', '1640.00'),
('1', 'JVT', 'Pulley Set', 'JVT PULLEY SET PCX150/ADV', '100', '1700.00'),
('2', 'Yamaha', 'Genuine Parts', 'SIDE PANEL 1', '110', '800.00'),
('3', 'MTRT', 'Pulley', 'MTRT PULLEY ONLY CLICK125', '120', '850.00'),
('4', 'RS8', 'Camshaft', 'RS8 SNIPER CAMSHAFT 5.8', '130', '550.00'),
('4', 'RS8', 'Bushing', 'RS8 PULLEY BUSHING AEROX/NMAX', '140', '160.00');


CREATE TABLE `casestudy_fds`.`supplier` (
  `supplier_id` INT NOT NULL AUTO_INCREMENT,
  `supplier_name` VARCHAR(20) NOT NULL,
  `phone_num` VARCHAR(11) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `category/brand` VARCHAR(20) NOT NULL,
  `address1` VARCHAR(50) NOT NULL,
  `city` VARCHAR(20) NOT NULL,
  `province` VARCHAR(20) NOT NULL,
  `country` VARCHAR(20) NOT NULL,
  `zip_code` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`supplier_id`));

INSERT INTO `casestudy_fds`.`supplier` 
(`supplier_name`, `phone_num`, `email`, `category/brand`, `address1`, `city`, `province`, `country`, `zip_code`) 
VALUES 
('JVT', '09548998899', 'jvtph2023@gmail.com', 'JVT', 'Floor 12 Unit 5 Lolita Building San Pablo', 'Pasay ', 'Manila', 'Philippines', '1709'),
('Yamaha', '09995002525', 'yamahaph2023@gmail.com', 'Yamaha', 'Floor 6 Unit 2 Charles Building San Rafael', 'Tarlac', 'Tarlac', 'Philippines', '2300'),
('MTRT', '09597002895', 'mtrtph2023@gmail.com', 'MTRT', 'Floor 3 Unit 10 Getha Building Capaya', 'Angeles', 'Pampanga', 'Philippines', '2009'),
('RS8', '09597789495', 'rs8ph2023@gmail.com', 'RS8', 'Floor 5 Unit 7 Aquino Building Burgos', 'Alaminos', 'Pangasinan', 'Philippines', '2404');
  
ALTER TABLE `casestudy_fds`.`customer` 
ADD INDEX `employee_id1_idx` (`employee_id1` ASC) VISIBLE;
;
ALTER TABLE `casestudy_fds`.`customer` 
ADD CONSTRAINT `employee_id1`
  FOREIGN KEY (`employee_id1`)
  REFERENCES `casestudy_fds`.`employee` (`employee_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `casestudy_fds`.`order` 
ADD INDEX `product_id1_idx` (`product_id1` ASC) VISIBLE,
ADD INDEX `customer_id1_idx` (`customer_id1` ASC) VISIBLE;
;
ALTER TABLE `casestudy_fds`.`order` 
ADD CONSTRAINT `customer_id1`
  FOREIGN KEY (`customer_id1`)
  REFERENCES `casestudy_fds`.`customer` (`customer_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `product_id1`
  FOREIGN KEY (`product_id1`)
  REFERENCES `casestudy_fds`.`product` (`product_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `casestudy_fds`.`product` 
ADD INDEX `supplier_id1_idx` (`supplier_id1` ASC) VISIBLE;
;
ALTER TABLE `casestudy_fds`.`product` 
ADD CONSTRAINT `supplier_id1`
  FOREIGN KEY (`supplier_id1`)
  REFERENCES `casestudy_fds`.`supplier` (`supplier_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

INSERT INTO `casestudy_fds`.`customer` (`employee_id1`, `fname`, `lname`, `phone_num`, `email`, `address1`, `city`, `province`, `country`, `zip_code`) VALUE ('"+RANGE+"', '"+FNAME+"', '"+LNAME+"', '"+PHONENUM+"', '"+EMAIL+"', '"+ADDRESS1+"', '"+CITY+"', '"+PROVINCE+"', '"+COUNTRY+"', '"+ZIP_CODE+"');
UPDATE `casestudy_fds`.`product` SET `quantity` = '"+MINUS_QTY+"' WHERE (`product_id` = '"+PD_ID+"');
SELECT * FROM casestudy_fds.product WHERE product_id =" + x;
SELECT * FROM `casestudy_fds`.`customer`;
INSERT INTO `casestudy_fds`.`order` (`customer_id1`, `product_id1`, `product_name`, `quantity`, `selling_price`, `total`, `purchased_date`) VALUE ('"+lastdata+"', '"+PD_ID+"', '"+PRODUCT_NAME+"', '"+QUANTITY+"', '"+SELLP_FINAL+"', '"+TOTAL_FINAL+"', '"+DATE+"')";

ALTER TABLE `casestudy_fds`.`employee` AUTO_INCREMENT = 11;
ALTER TABLE `casestudy_fds`.`customer` AUTO_INCREMENT = 11;
ALTER TABLE `casestudy_fds`.`order` AUTO_INCREMENT = 11;

