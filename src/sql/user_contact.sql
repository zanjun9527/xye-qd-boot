
/*Table structure for table `user_contact` */
CREATE TABLE `user_contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL COMMENT '姓名',
  `cell_phone` varchar(20) NOT NULL COMMENT '联系手机号',
  `location` int(11) NOT NULL COMMENT '地点，最小地区id',
  `flag` int(2) NOT NULL DEFAULT '0' COMMENT '0 未联系，1已联系',
  `date_insert` datetime DEFAULT NULL,
  `date_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

