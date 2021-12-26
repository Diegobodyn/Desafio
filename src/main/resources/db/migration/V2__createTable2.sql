CREATE TABLE `tb_registro_chavepix` (
  `id` bigint(20) NOT NULL auto_increment,
  `chave_pix` bigint(20) DEFAULT NULL,
  `nome_banco` varchar(255) DEFAULT NULL,
  `nome_cliente` varchar(255) DEFAULT NULL,
  `tipo_de_chave` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);