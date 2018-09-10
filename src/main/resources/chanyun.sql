CREATE TABLE `tb_index_banner` (                                                                                  
                   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',                                                        
                   `img_url` varchar(100) NOT NULL COMMENT '图片路径',                                                         
                   `img_description` varchar(500) NOT NULL COMMENT '描述',                                                       
                   `img_link` varchar(100) NOT NULL COMMENT '链接',                                                              
                   `sort` int(2) NOT NULL COMMENT '排序',                                                                        
                   `status` int(2) NOT NULL COMMENT '状态 0 启用 1禁用',                                                     
                   `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',  
                   PRIMARY KEY (`id`)                                                                                              
                 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_news` (                                                                                          
           `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',                                                        
           `news_title` varchar(50) NOT NULL COMMENT '资讯标题',                                                       
           `news_description` varchar(200) NOT NULL COMMENT '资讯描述',                                                
           `news_content` longtext NOT NULL COMMENT '资讯内容',                                                        
           `news_keywords` varchar(200) NOT NULL COMMENT '资讯关键字',                                                
           `news_type` int(1) NOT NULL COMMENT '资讯类型 0佛门动态 1政策法规 2佛学入门',                   
           `news_img` varchar(50) NOT NULL COMMENT '资讯封面',                                                         
           `news_sort` int(2) NOT NULL COMMENT '资讯首页排序',                                                       
           `news_status` int(2) NOT NULL COMMENT '资讯状态 0启用 1禁用',                                           
           `news_recommend` int(2) NOT NULL COMMENT '资讯首页推荐 0推荐 1不推荐 默认不推荐',               
           `news_templeid` int(11) NOT NULL COMMENT '寺庙id',                                                            
           `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',  
           `news_source` varchar(50) NOT NULL COMMENT '资讯来源',                                                      
           PRIMARY KEY (`id`)                                                                                              
         ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_temple` (                                                                                              
             `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',                                                              
             `temple_number` varchar(10) NOT NULL COMMENT '寺庙编号',                                                          
             `temple_name` varchar(50) NOT NULL COMMENT '寺庙名称',                                                            
             `temple_province` varchar(50) DEFAULT NULL COMMENT '寺庙所在省',                                                 
             `temple_city` varchar(50) DEFAULT NULL COMMENT '寺庙所在市',                                                     
             `temple_county` varchar(50) DEFAULT NULL COMMENT '寺庙所在区/县',                                               
             `temple_address` varchar(200) DEFAULT NULL COMMENT '寺庙详细地址',                                              
             `status` int(2) DEFAULT NULL COMMENT '状态 0 申请 1启用 2禁用 3申请未通过 4异常',                      
             `temple_contact_name` varchar(50) DEFAULT NULL COMMENT '寺庙联系人姓名',                                       
             `temple_contact_tel` varchar(20) DEFAULT NULL COMMENT '寺庙联系人电话',                                        
             `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '寺庙申请时间',  
             PRIMARY KEY (`id`)                                                                                                    
           ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
           
CREATE TABLE `tb_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `icon` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1705032705 DEFAULT CHARSET=utf8;

/*Data for the table `tb_menu` */

insert  into `tb_menu`(`id`,`icon`,`name`,`state`,`url`,`p_id`) values (1,'menu-plugin','系统菜单',1,NULL,-1),(10,'&#xe68e;','内容管理',1,NULL,1),(60,'&#xe631;','系统管理',1,NULL,1),(61,'&#xe705;','新闻资讯',1,'http://www.ifeng.com/',1),(1000,'icon-text','文章管理',2,'https://www.hongxiu.com/',10),(6000,'&#xe631;','菜单管理',2,'admin/menu/tomunemanage',60),(6010,'icon-icon10','角色管理',2,'admin/role/torolemanage',60),(6020,'&#xe612;','用户管理',2,'admin/user/tousermanage',60),(6030,'&#xe631;','sql监控',2,'druid/index.html',60),(6040,'icon-ziliao','修改密码',2,'admin/user/toUpdatePassword',60),(6050,'icon-tuichu','安全退出',2,'user/logout',60),(6100,'icon-text','凤凰网',2,'http://www.ifeng.com/',61),(200000,'44','44',3,'44',2000);

/*Table structure for table `tb_role` */

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bz` varchar(1000) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `tb_role` */

insert  into `tb_role`(`id`,`bz`,`name`,`remarks`) values (1,'系统管理员 最高权限','管理员',NULL),(2,'主管','主管',NULL),(4,'采购员','采购员',NULL),(5,'销售经理','销售经理','22'),(7,'仓库管理员','仓库管理员',NULL),(9,'总经理','总经理',NULL),(15,'111111','111111',NULL),(16,'222','222222',NULL),(17,'33','333333',NULL),(18,'444444','444444',NULL),(19,'555','555555',NULL),(20,'666666','666666',NULL);

/*Table structure for table `tb_role_menu` */

DROP TABLE IF EXISTS `tb_role_menu`;

CREATE TABLE `tb_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=289 DEFAULT CHARSET=utf8;

/*Data for the table `tb_role_menu` */

insert  into `tb_role_menu`(`id`,`menu_id`,`role_id`) values (36,10,2),(42,1,2),(45,1,4),(48,1,5),(55,1,9),(65,1,7),(66,10,7),(126,60,15),(127,6010,15),(128,6020,15),(129,6030,15),(130,6040,15),(131,6050,15),(248,2000,1),(259,100000,1),(278,10,1),(279,1000,1),(280,60,1),(281,6000,1),(282,6010,1),(283,6020,1),(284,6030,1),(285,6040,1),(286,6050,1),(287,61,1),(288,6100,1);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bz` varchar(1000) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `true_name` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`bz`,`password`,`true_name`,`user_name`,`remarks`) values (1,'管理员','1','赵佳涛','admin','1'),(2,'主管','123','王大锤','jack','2'),(3,'销售经理','123','玛丽','marry','33'),(5,'1','111111','1','111111',NULL),(6,'2','222222','2','222222',NULL),(7,'3','333333','3','333333',NULL),(8,'','444444','44','444444',NULL),(9,'5','555555','5','555555',NULL),(11,'7','777777','7','777777',NULL),(12,'88','888888','88','888888',NULL),(13,'9','999999','9','999999',NULL),(14,'121212','121212','121212','121212',NULL);

/*Table structure for table `tb_user_role` */

DROP TABLE IF EXISTS `tb_user_role`;

CREATE TABLE `tb_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user_role` */

insert  into `tb_user_role`(`id`,`role_id`,`user_id`) values (1,1,1),(19,2,2),(20,4,2),(21,5,2),(28,2,3),(29,4,3),(30,5,3),(31,7,3),(49,15,5),(50,1,5);
 