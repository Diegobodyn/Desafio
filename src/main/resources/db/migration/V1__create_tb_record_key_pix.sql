CREATE TABLE `tb_record_key_pix` (
  `id` bigint(20) NOT NULL auto_increment,
  `client_name` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,  
  `key_pix` bigint(20) DEFAULT NULL,
  `type_of_key` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);