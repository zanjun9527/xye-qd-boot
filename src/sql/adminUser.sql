

CREATE TABLE `admin_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cell_phone` varchar(20) NOT NULL COMMENT '手机号',
  `pass_word` varchar(50) NOT NULL COMMENT '密码',
  `date_insert` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

