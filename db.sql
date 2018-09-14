CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `t_user_id_info` (
  `user_id` int(11) NOT NULL COMMENT '用户id\r\n',
  `user_id_no` varchar(40) DEFAULT NULL COMMENT '身份证号码\r\n',
  `user_id_no_token` varchar(255) DEFAULT NULL COMMENT '身份证号码加密字段',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_no` (`user_id_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;