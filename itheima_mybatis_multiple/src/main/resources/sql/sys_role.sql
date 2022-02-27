

CREATE TABLE `sys_role` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `roleName` VARCHAR(50) DEFAULT NULL,
  `roleDesc` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;



INSERT  INTO `sys_role`(`id`,`roleName`,`roleDesc`) VALUES (1,'院长','负责全面工作T'),(2,'研究员','课程研发工作S'),(3,'讲师','授课工作'),(4,'助教','协助解决学生的问题test'),(5,'班主任','负责生活问题'),(6,'asd','asdas'),(7,'asd','asdas'),(8,'testName','testDesc'),(9,'testName','testDesc'),(10,'test01','test0122'),(11,'test01','test0122'),(12,'lit','lit'),(13,'aaa','sss'),(14,'å°±ä¸æå¯¼','è´è´£å­¦çæ¯ä¸ä¹åçå°±ä¸æå¯¼å·¥ä½'),(15,'就业指导','负责学生毕业之后的就业指导工作'),(16,'测试角色','测试角色');

