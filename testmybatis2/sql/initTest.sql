CREATE DATABASE  `test` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

Create TABLE `user` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `userName` varchar(50) DEFAULT NULL,
 `userAge` int(11) DEFAULT NULL,
 `userAddress` varchar(200) DEFAULT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


Insert INTO `user` VALUES ('1', 'summer', '100', 'chengdu,pudong');

-- 

Create TABLE `article` (
 `id` int(11) NOT NULL auto_increment,
 `userid` int(11) NOT NULL,
 `title` varchar(100) NOT NULL,
 `content` text NOT NULL,
 PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- 添加几条测试数据
-- ----------------------------
Insert INTO `article` VALUES ('1', '1', 'test_title', 'test_content');
Insert INTO `article` VALUES ('2', '1', 'test_title_2', 'test_content_2');
Insert INTO `article` VALUES ('3', '1', 'test_title_3', 'test_content_3');
Insert INTO `article` VALUES ('4', '1', 'test_title_4', 'test_content_4');