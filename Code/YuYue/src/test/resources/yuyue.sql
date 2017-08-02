CREATE DATABASE /*!32312 IF NOT EXISTS*/`yuyue` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `yuyue`;

CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `token` varchar(50) DEFAULT NULL COMMENT '标识',
  `wx_id` varchar(50) DEFAULT NULL COMMENT '微信id',
  `password` char(50) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机标识码',
  `father_id` bigint(20) DEFAULT NULL COMMENT '父用户id',
  `shop_id`  bigint(20) DEFAULT NULL COMMENT '属于的店铺id',
  `money` float(10, 1) DEFAULT NULL COMMENT '余额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_time` datetime DEFAULT NULL COMMENT '最近登录时间',
  PRIMARY KEY (`id`),
  KEY `shop_id`(`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户表';


insert  into `user`(`token`,`wx_id`,`password`,`nickname`,`phone`) values ('token1','wxid1','111111','haha','18801618932');
insert  into `user`(`token`,`wx_id`,`password`,`nickname`,`phone`) values ('token2','wxid2','222','gugu','18801618931');
insert  into `user`(`token`,`wx_id`,`password`,`nickname`,`phone`) values ('token3','wxid3','333','yuyu','18801618933');


CREATE TABLE `service_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `name` varchar(50) DEFAULT NULL COMMENT '分类名称',
  `status` int NOT NULL DEFAULT '0' COMMENT '是否在使用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='服务分类表';
insert  into `service_category`(`name`,`status`) values ('分类1',1);
insert  into `service_category`(`name`,`status`) values ('分类2',1);

CREATE TABLE `service` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '服务id',
  `name` varchar(50) DEFAULT NULL COMMENT '服务名称',
  `title` varchar(50) DEFAULT NULL COMMENT '服务标题',
  `content` varchar(255) DEFAULT NULL COMMENT '服务内容',
  `price` float(10, 1) DEFAULT NULL COMMENT '价格',
  `unit`  varchar(50) DEFAULT NULL COMMENT '单位',
  `status` int DEFAULT '0' COMMENT '在线状态',
  `category_id` bigint(20) DEFAULT NULL COMMENT '属于的分类id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '属于的用户id',
  `shop_id` bigint(20) DEFAULT NULL COMMENT '属于的店铺id',
  `type` int DEFAULT NULL COMMENT '服务类别（商户，个人）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
   KEY `shop_id`(`shop_id`),
   KEY `user_id`(`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='服务表';

insert  into `service`(`name`,`content`,`user_id`) values ('服务1','服务1的内容',1);
insert  into `service`(`name`,`content`,`shop_id`) values ('服务2','服务2的内容',2);

CREATE TABLE `orders` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_no` bigint(40) DEFAULT NULL COMMENT '订单号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '下单用户id',
  `service_id` bigint(20) DEFAULT NULL COMMENT '被申请的服务id',
  `service_title` varchar(50) DEFAULT NULL COMMENT '被申请的服务名称',
  `server_id` bigint(20) DEFAULT NULL COMMENT '被申请的服务者id',
  `shop_id` bigint(20) DEFAULT NULL COMMENT '被申请的店铺id',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `start_time` datetime DEFAULT NULL COMMENT '服务开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '服务结束时间',
  `total_price` float(10,1) DEFAULT NULL COMMENT '订单金额',
  `status` int(10) DEFAULT NULL COMMENT '订单状态',
  `pay_id` int DEFAULT NULL COMMENT '支付方式id',
  `pay_name` varchar(50) DEFAULT NULL COMMENT '支付名称',
  `pay_status` int DEFAULT NULL COMMENT '支付状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `apply_user`(`server_id`),
  KEY `user_id`(`user_id`),
  KEY `shop_id` (`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='订单表';

insert  into `orders`(`order_no`,`server_id`,`service_id`,`start_time`, `end_time`, `total_price`, `status`) 
values ('111',1,2, '2017-06-25 17:30', '2017-06-25 19:00', '798', 0);
insert  into `orders`(`order_no`,`server_id`,`service_id`,`start_time`, `end_time`, `total_price`, `status`) 
values ('222',2,1, '2017-06-27 17:30', '2017-06-27 19:00', '8000', 0);

CREATE TABLE `comment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录表id',
   `user_id` bigint(20) DEFAULT NULL COMMENT '评论用户id',
  `server_id` bigint(20) DEFAULT NULL COMMENT '被评论用户id',
  `content` varchar(100) DEFAULT NULL COMMENT '评论内容',
  `grade` int DEFAULT NULL COMMENT '评价打分',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `user_id`(`user_id`),
  KEY `server_id`(`server_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='评论表';
insert  into `comment`(`user_id`,`server_id`,`content`,`grade`) values('1', '2', '很好', 3);

CREATE TABLE `user_record` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录表id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
   `order_no` bigint(40) DEFAULT NULL COMMENT '订单号',
  `dealcost` float(10, 1) DEFAULT NULL COMMENT '交易额度',
  `dealtype` int(10) DEFAULT NULL COMMENT '交易类别',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `user_id`(`user_id`),
  KEY `order_id`(`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户账户流水记录表';

CREATE TABLE `shop` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '商户id',
  `shop_no` varchar(50) DEFAULT NULL COMMENT '商户编码',
  `shop_name` varchar(50) DEFAULT NULL COMMENT '商户名称',
  `shop_phone` varchar(50) DEFAULT NULL COMMENT '商户电话',
  `shop_address` varchar(50) DEFAULT NULL COMMENT '商户地址',
  `shop_status` int DEFAULT 0 COMMENT '商户状态',
   `money` float(10, 1) DEFAULT NULL COMMENT '余额',
  `owner_id` bigint(20) DEFAULT NULL COMMENT '拥有者id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `admin_id`(`owner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='商户表';

insert  into `shop`(`shop_name`,`owner_id`) values('商戶一', '1');
insert  into `shop`(`shop_name`,`owner_id`) values('商戶二', '2');
insert  into `shop`(`shop_name`,`owner_id`) values('商戶三', '3');

CREATE TABLE `admin` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `admin_token` varchar(50) DEFAULT NULL COMMENT '标识',
  `admin_wxid` varchar(50) DEFAULT NULL COMMENT '微信id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` char(50) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机标识码',
  `admin_status` int DEFAULT 0 COMMENT '管理员状态',
  `last_time` datetime DEFAULT NULL COMMENT '最近登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='管理员表';

insert  into `admin`(`admin_token`,`admin_wxid`,`password`,`nickname`,`phone`) values ('admintoken1','adminwxid1','111111','haha','18801618932');
insert  into `admin`(`admin_token`,`admin_wxid`,`password`,`nickname`,`phone`) values ('admintoken2','adminwxid2','2222','haha','18801618931');

CREATE TABLE `shop_admin` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `admin_id` bigint(20) DEFAULT NULL COMMENT '管理员id',
  `shop_id` bigint(20) DEFAULT NULL COMMENT '店id',
  `status` int DEFAULT NULL COMMENT '是否主用戶',
  PRIMARY KEY (`id`),
  KEY `shop_id`(`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='管理员店铺表';

insert into `shop_admin` (`admin_id`, `shop_id`, `status`) values ('1', '1', '1'); 
insert into `shop_admin` (`admin_id`, `shop_id`, `status`) values ('2', '1', '0'); 

CREATE TABLE `shop_record` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '记录表id',
    `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `shop_id` bigint(20) DEFAULT NULL COMMENT '店铺id',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
  `order_no` bigint(40) DEFAULT NULL COMMENT '订单号',
  `server_id` bigint(20) DEFAULT NULL COMMENT '服务者id',
  `server_nickname` varchar(50) DEFAULT NULL COMMENT '服务者昵称',
  `dealcost` float(10, 1) DEFAULT NULL COMMENT '交易额度',
  `dealtype` int(10) DEFAULT NULL COMMENT '交易类别',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `user_id`(`shop_id`),
  KEY `order_id`(`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户账户流水记录表';

--2017.07。31
--service表增加grade字段
 alter table service add column grade int default null after shop_id;
-- 2017.08.01
--user表增加avatar_url头像
 alter table user add column avatar_url varchar(100) default null after nickname;


