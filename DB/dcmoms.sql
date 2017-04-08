/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : dcmoms

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-04-08 20:38:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bd_dic_dcm_common
-- ----------------------------
DROP TABLE IF EXISTS `bd_dic_dcm_common`;
CREATE TABLE `bd_dic_dcm_common` (
  `DIC_VALUE` varchar(20) NOT NULL COMMENT '字典值',
  `DIC_NAME` varchar(20) NOT NULL COMMENT '字典名称',
  `DIC_TYPE` varchar(20) NOT NULL COMMENT '字典类型',
  `DIC_TYPE_DESC` varchar(255) NOT NULL COMMENT '字典类型描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_dic_dcm_common
-- ----------------------------
INSERT INTO `bd_dic_dcm_common` VALUES ('0', '待下单', 'ORDER_STATUS', '订单状态');
INSERT INTO `bd_dic_dcm_common` VALUES ('1', '下单成功', 'ORDER_STATUS', '订单状态');
INSERT INTO `bd_dic_dcm_common` VALUES ('2', '缺货', 'ORDER_STATUS', '订单状态');
INSERT INTO `bd_dic_dcm_common` VALUES ('3', '折扣失效', 'ORDER_STATUS', '订单状态');
INSERT INTO `bd_dic_dcm_common` VALUES ('4', '发货后缺货', 'ORDER_STATUS', '订单状态');
INSERT INTO `bd_dic_dcm_common` VALUES ('unknown', '未知网站', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('6PM', '6PM', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('7FORALLMANKIND', '7FORALLMANKIND', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('abercrombie', 'abercrombie', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('adidas', 'adidas', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('adorama', 'adorama', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('AE', 'AE', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('aeropostale', 'aeropostale', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('agnesb', 'agnesb', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('ahavaus', 'ahavaus', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('aldoshoes', 'aldoshoes', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('alexandalexa', 'alexandalexa', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('alexandragrecco', 'alexandragrecco', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('amazon', 'AMAZON', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('anntaylor', 'anntaylor', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('anthropologie', 'anthropologie', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('apc', 'apc', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('armaniexchange', 'armaniexchange', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('ashford', 'ashford', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('ASKDERM', 'ASKDERM', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('ASOS', 'ASOS', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('backcountry', 'backcountry', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('bally', 'bally', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('barneys', 'barneys', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('barneyswarehouse', 'barneyswarehouse', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('bcbg', 'bcbg', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('beauty', 'beauty', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('BEAUTYBAR', 'BEAUTYBAR', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('beautybay', 'beautybay', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('beautycarechoices', 'beautycarechoices', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('bergdorfgoodman', 'bergdorfgoodman', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('bestbuy', 'bestbuy', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('biotherm', 'biotherm', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('blissworld', 'blissworld', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('bloomingdales', 'bloomingdales', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('BLUEFLY', 'BLUEFLY', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('bobbi brown', 'bobbi brown', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('bonton', 'bonton', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('brittaniesthyme', 'brittaniesthyme', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('brooksbrothers', 'brooksbrothers', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('burberry', 'burberry', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('BUTTERLONDON', 'BUTTERLONDON', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('c21store', 'c21store', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('calvinklein', 'calvinklein', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('carters', 'carters', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('childrensplace', 'childrensplace', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('clarinsusa', 'clarinsusa', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('clarisonic', 'clarisonic', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('clark', 'clark', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('clinique', 'clinique', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('coach', 'coach', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('coachoutlet', 'coachoutlet', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('colehaan', 'colehaan', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('columbia', 'columbia', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('cosme-de', 'cosme-de', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('cosstores', 'cosstores', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('COSTCO', 'COSTCO', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('crabtree-evelyn', 'crabtree-evelyn', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('cremedelamer', 'cremedelamer', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('crocs', 'crocs', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('dailyvita', 'dailyvita', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('dermadoctor', 'dermadoctor', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('dermstore', 'dermstore', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('diapers', 'diapers', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('dillards', 'dillards', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('diptyqueparis', 'diptyqueparis', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('disneystore', 'disneystore', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('dkny', 'dkny', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('drjays', 'drjays', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('DRUGSTORE', 'DRUGSTORE', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('dsw', 'dsw', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('eastdane', 'eastdane', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('ebags', 'ebags', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('ebay', 'ebay', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('elizabetharden', 'elizabetharden', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('envirosax', 'envirosax', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('esteelauder', 'esteelauder', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('EXPRESS', 'EXPRESS', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('famousfootwear', 'famousfootwear', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('finishline', 'finishline', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('footlocker', 'footlocker', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('fragrancenet', 'fragrancenet', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('freepeople', 'freepeople', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('frenchconnection', 'frenchconnection', 'GROUP_ID', '团号');
INSERT INTO `bd_dic_dcm_common` VALUES ('fresh', 'fresh', 'GROUP_ID', '团号');

-- ----------------------------
-- Table structure for bd_dw_dcm_customer_addr
-- ----------------------------
DROP TABLE IF EXISTS `bd_dw_dcm_customer_addr`;
CREATE TABLE `bd_dw_dcm_customer_addr` (
  `ROW_ID_INNER` int(8) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '内部字段',
  `DCM_ID` varchar(10) DEFAULT NULL COMMENT '大肠面用户号',
  `ADDR_TYPE` varchar(100) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `START_DATE` varchar(8) DEFAULT NULL,
  `END_DATE` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`ROW_ID_INNER`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_dw_dcm_customer_addr
-- ----------------------------
INSERT INTO `bd_dw_dcm_customer_addr` VALUES ('00000001', '1', '家庭', 'xxx区XXX路XX号xxx', '20160622', '99991231');
INSERT INTO `bd_dw_dcm_customer_addr` VALUES ('00000002', '1', '工作', 'YY区yyy路yy号yyy', '20160622', '99991231');
INSERT INTO `bd_dw_dcm_customer_addr` VALUES ('00000003', '1', '工作2', '啦啦啦啦啦啦', '20160623', '99991231');
INSERT INTO `bd_dw_dcm_customer_addr` VALUES ('00000004', '1', '工作4', '哦吼吼吼吼', '20160623', '99991231');
INSERT INTO `bd_dw_dcm_customer_addr` VALUES ('00000005', '1', '212', '21', '20160623', '99991231');
INSERT INTO `bd_dw_dcm_customer_addr` VALUES ('00000006', '1', 'test', '1111', '20160623', '99991231');
INSERT INTO `bd_dw_dcm_customer_addr` VALUES ('00000007', '1', '工作test', '2302', '20160623', '99991231');
INSERT INTO `bd_dw_dcm_customer_addr` VALUES ('00000008', '1', 'aaa', '啊啊啊', '20160623', '99991231');
INSERT INTO `bd_dw_dcm_customer_addr` VALUES ('00000011', '1', '3', '3', '20160623', '99991231');
INSERT INTO `bd_dw_dcm_customer_addr` VALUES ('00000012', '1', '4', '4', '20160623', '99991231');
INSERT INTO `bd_dw_dcm_customer_addr` VALUES ('00000013', '1', '5', '5', '20160623', '99991231');
INSERT INTO `bd_dw_dcm_customer_addr` VALUES ('00000014', '1', '1', '1', '20160624', '99991231');

-- ----------------------------
-- Table structure for bd_dw_dcm_group_info
-- ----------------------------
DROP TABLE IF EXISTS `bd_dw_dcm_group_info`;
CREATE TABLE `bd_dw_dcm_group_info` (
  `GROUP_ID` char(10) NOT NULL DEFAULT '' COMMENT '团号',
  `GROUP_NAME` char(30) NOT NULL COMMENT '团名',
  `CREATE_DATE` char(8) NOT NULL COMMENT '建团日期',
  `SUCC_DATE` char(8) DEFAULT NULL COMMENT '成团日期',
  `IS_SEPARATE` char(1) NOT NULL DEFAULT '0' COMMENT '是否分团: 0-否; 1-是',
  `IS_DELIVER` char(1) NOT NULL DEFAULT '0' COMMENT '是否发货: 0-否; 1-是',
  PRIMARY KEY (`GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_dw_dcm_group_info
-- ----------------------------
INSERT INTO `bd_dw_dcm_group_info` VALUES ('', '123', '20151230', null, '0', '0');

-- ----------------------------
-- Table structure for bd_dw_dcm_group_sprt_detail
-- ----------------------------
DROP TABLE IF EXISTS `bd_dw_dcm_group_sprt_detail`;
CREATE TABLE `bd_dw_dcm_group_sprt_detail` (
  `GROUP_ID` char(10) DEFAULT NULL COMMENT '团号',
  `SUB_GROUP_ID` char(30) NOT NULL DEFAULT '' COMMENT '子团号',
  `SUB_GROUP_NAME` char(30) DEFAULT NULL COMMENT '子团名',
  `CREATE_DATE` char(8) DEFAULT NULL COMMENT '分团日期',
  PRIMARY KEY (`SUB_GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_dw_dcm_group_sprt_detail
-- ----------------------------

-- ----------------------------
-- Table structure for bd_dw_dcm_order_op_log
-- ----------------------------
DROP TABLE IF EXISTS `bd_dw_dcm_order_op_log`;
CREATE TABLE `bd_dw_dcm_order_op_log` (
  `ORDER_ID` int(10) NOT NULL,
  `ORDER_TYPE` varchar(1) NOT NULL DEFAULT '0',
  `OPERATOR` varchar(8) DEFAULT NULL,
  `OP_TIME` varchar(19) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_dw_dcm_order_op_log
-- ----------------------------

-- ----------------------------
-- Table structure for bd_dw_dcm_order_record
-- ----------------------------
DROP TABLE IF EXISTS `bd_dw_dcm_order_record`;
CREATE TABLE `bd_dw_dcm_order_record` (
  `ORDER_ID` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `ORDER_TIME` varchar(19) NOT NULL COMMENT '下单日期',
  `GROUP_ID` varchar(100) DEFAULT NULL COMMENT '团号',
  `DCM_ID` varchar(10) NOT NULL COMMENT '大肠面编号',
  `CST_ID` varchar(30) NOT NULL COMMENT '客户id（相当于大肠面用户名）',
  `LINK` varchar(1000) NOT NULL COMMENT '商品链接',
  `COMMODITY_NAME` varchar(500) NOT NULL COMMENT '商品英文名称',
  `COMMODITY_DESC` varchar(100) DEFAULT NULL COMMENT '商品中文描述',
  `UNIT_PRICE` float(10,4) NOT NULL COMMENT '商品单价',
  `AMOUNT` float(10,4) NOT NULL COMMENT '数量',
  `GOODS_COLOR` varchar(255) NOT NULL COMMENT '颜色',
  `GOODS_SIZE` varchar(50) NOT NULL COMMENT '尺寸',
  `DISCOUNT_DESC` varchar(100) DEFAULT NULL COMMENT '折扣描述',
  `DISCOUNT_FINAL` float(5,4) NOT NULL DEFAULT '1.0000' COMMENT '最终折扣',
  `TOTAL_PRICE` float(10,4) DEFAULT NULL COMMENT '商品总价',
  `FINAL_PRICE` float(10,4) DEFAULT NULL COMMENT '折后总价',
  `COMMENTS` char(200) DEFAULT NULL COMMENT '备注',
  `PICTURE` varchar(1000) DEFAULT NULL COMMENT '图片地址',
  `OVERSEAS_FREIGH` float(4,4) DEFAULT NULL COMMENT '国际运费',
  `INLAND_FREIGH` float(10,4) DEFAULT NULL COMMENT '国内运费',
  `ORDER_STATUS` varchar(1) NOT NULL DEFAULT '0' COMMENT '订单状态',
  `ORDER_TYPE` varchar(1) NOT NULL DEFAULT '0' COMMENT '订单分类',
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_dw_dcm_order_record
-- ----------------------------
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000092', '2016-05-27 21:53:47', 'amazon', '1', 'admin', 'http://www.amazon.com/gp/product/B014D7XGNS/ref=s9_acss_bw_hsb_TV16Wk21_s1_s?pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-3&pf_rd_r=0309Z1H86ZXAC5NRJF1H&pf_rd_t=101&pf_rd_p=2502522122&pf_rd_i=1266092011', 'Epson Home Cinema 1040 1080p, 2x HDMI (1 MHL), 3LCD, 3000 Lumens Color and White Brightness Home Theater Projector', null, '564.6000', '1.0000', 'WHITE', '无', '', '1.0000', null, null, '', 'downloadpic\\20160527-215347.jpg', null, null, '3', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000093', '2016-06-24 00:07:02', 'amazon', '1', 'admin', 'https://www.amazon.de/Miele-S-8340-EcoLine-41834042/dp/B0094QU3HQ/ref=sr_1_1?ie=UTF8&qid=1466697564&sr=8-1&keywords=miele', '41834042 [Energy Class D]', null, '179.0000', '1.0000', 'white', '无', '', '1.0000', null, null, '', 'downloadpic\\20160624-000702.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000094', '2016-06-24 00:07:24', 'amazon', '1', 'admin', 'https://www.amazon.de/Miele-S-8340-EcoLine-41834042/dp/B0094QU3HQ/ref=sr_1_1?ie=UTF8&qid=1466697564&sr=8-1&keywords=miele', '41834042 [Energy Class D]', null, '179.0000', '1.0000', 'white', '无', '', '1.0000', null, null, '', 'downloadpic\\20160624-000724.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000095', '2016-06-24 00:09:34', 'amazon', '1', 'admin', 'https://www.amazon.de/Miele-SGEE1-BRRT-PL1200W-Bodenstaubsauger/dp/B00UL5VTPE/ref=sr_1_5?ie=UTF8&qid=1466697564&sr=8-5&keywords=miele', 'E502358 Bodenstaubsauger Complete C3 [Energy Class D]', null, '269.0000', '1.0000', '无', '无', '', '1.0000', null, null, '', 'downloadpic\\20160624-000934.jpg', null, null, '0', '2');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000096', '2016-06-28 01:07:37', 'amazon', '1', 'admin', 'https://www.amazon.com/StyleStalker-Womens-Miranda--Line-X-Small/dp/B01G3FA5YG/ref=sr_1_11?m=ATVPDKIKX0DER&s=apparel&ie=UTF8&qid=1467047196&sr=1-11&nodeID=11006703011&refinements=p_6%3AATVPDKIKX0DER', 'StyleStalker Women\'s Miranda A-Line Dress', null, '199.0000', '1.0000', '无', '无', '100-10', '1.0000', null, null, '', 'downloadpic\\20160628-010737.jpg', null, null, '0', '2');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000097', '2016-06-28 01:18:40', 'amazon', '1', 'admin', 'https://www.amazon.com/Lucy-Love-Womens-Whisper-Shoulder/dp/B01BN8TSC8/ref=sr_1_16?m=ATVPDKIKX0DER&s=apparel&ie=UTF8&qid=1467047255&sr=1-16&nodeID=11006703011&refinements=p_6%3AATVPDKIKX0DER', 'Lucy Love Women\'s Whisper In My Ear Off Shoulder Dress', null, '74.0000', '2.0000', 'Black', 'Large', '0.7', '1.0000', null, null, '分开寄', 'downloadpic\\20160628-011840.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000098', '2016-06-28 02:03:17', 'amazon', '1', 'admin', 'https://www.amazon.com/BCBGeneration-Womens-Dress-Black-XX-Small/dp/B01FRGE3U4/ref=sr_1_26?m=ATVPDKIKX0DER&s=apparel&ie=UTF8&qid=1467047255&sr=1-26&nodeID=11006703011&refinements=p_6%3AATVPDKIKX0DER', 'BCBGeneration Women\'s Tube Dress', null, '78.0000', '3.0000', 'black', 'large', '1000-100', '1.0000', null, null, '哈哈', 'downloadpic\\20160628-020317.jpg', null, null, '0', '3');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000099', '2016-06-28 02:07:21', 'amazon', '1', 'admin', 'https://www.amazon.com/BCBGeneration-Womens-Dress-Black-XX-Small/dp/B01FRGE3U4/ref=sr_1_26?m=ATVPDKIKX0DER&s=apparel&ie=UTF8&qid=1467047255&sr=1-26&nodeID=11006703011&refinements=p_6%3AATVPDKIKX0DER', 'BCBGeneration Women\'s Tube Dress', null, '78.0000', '1.0000', 'black', 'large', '1200-200', '1.0000', null, null, '黑', 'downloadpic\\20160628-020721.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000100', '2016-06-28 02:08:48', 'amazon', '1', 'admin', 'https://www.amazon.com/BCBGeneration-Womens-Insert-Dress-Optic/dp/B01FRGE5E8/ref=sr_1_27?m=ATVPDKIKX0DER&s=apparel&ie=UTF8&qid=1467047255&sr=1-27&nodeID=11006703011&refinements=p_6%3AATVPDKIKX0DER', 'BCBGeneration Women\'s Woven Lace Insert Sleeveless Dress', null, '118.0000', '1.0000', 'white', 'large', '75折', '1.0000', null, null, '白', 'downloadpic\\20160628-020848.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000101', '2016-06-28 02:11:44', 'unknown', '1', 'admin', 'https://www.amazon.com/BCBGeneration-Womens-Insert-Dress-Optic/dp/B01FRGE5E8/ref=sr_1_27?m=ATVPDKIKX0DER&s=apparel&ie=UTF8&qid=1467047255&sr=1-27&nodeID=11006703011&refinements=p_6%3AATVPDKIKX0DER', 'BCBGeneration Women\'s Woven Lace Insert Sleeveless Dress', null, '118.0000', '3.0000', 'white', 'small', '额外8折', '1.0000', null, null, '直运', 'downloadpic\\20160628-021144.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000102', '2016-06-28 02:15:56', 'amazon', '1', 'admin', 'https://www.amazon.com/BCBGeneration-Womens-Insert-Dress-Optic/dp/B01FRGE5E8/ref=sr_1_27?m=ATVPDKIKX0DER&s=apparel&ie=UTF8&qid=1467047255&sr=1-27&nodeID=11006703011&refinements=p_6%3AATVPDKIKX0DER', 'BCBGeneration Women\'s Woven Lace Insert Sleeveless Dress', null, '118.0000', '1.0000', 'white', 'xl', '额外9折', '1.0000', null, null, '无', 'downloadpic\\20160628-021556.jpg', null, null, '0', '3');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000113', '2015-07-11 03:04:24', 'amazon', '1', 'admin', 'https://www.amazon.com/StyleStalker-Womens-Miranda--Line-Medium/dp/B01G3FA5WS/ref=sr_1_39?m=ATVPDKIKX0DER&s=apparel&ie=UTF8&qid=1468177377&sr=1-39&nodeID=11006703011&refinements=p_6%3AATVPDKIKX0DER', 'StyleStalker Women\'s Miranda A-Line Dress', null, '199.0000', '1.0000', '无', 'Medium', '100-10', '1.0000', null, null, '', 'downloadpic\\20160711-030424.jpg', null, null, '0', '2');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000114', '2016-07-11 03:26:14', 'amazon', '1', 'admin', 'https://www.amazon.com/Adrianna-Papell-Womens-Sleeveless-Faille/dp/B01D5TKSH2/ref=sr_1_40?m=ATVPDKIKX0DER&s=apparel&ie=UTF8&qid=1468177454&sr=1-40&nodeID=11006703011&refinements=p_6%3AATVPDKIKX0DER', 'Adrianna Papell Women\'s Sleeveless Lace and Faille Fit and Flare Party Dress', null, '179.0000', '1.0000', '无', 'Medium', '200-10', '1.0000', null, null, '', 'downloadpic\\20160711-032614.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000115', '2016-07-12 01:29:57', 'cosstores', '1', 'admin', 'http://www.cosstores.com/us/', '测试1', null, '1000.0000', '1.0000', '无', '无', '100', '1.0000', null, '5241.0000', '', 'downloadpic\\20160712-012957.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000116', '2016-07-13 02:48:30', 'coach', '1', 'admin', 'http://www.coach.com/coach-mens-leather-backpacks-archival-rucksack-in-glovetanned-leather/72132.html?dwvar_color=DKES5', 'THE rainger in glovetanned leather', null, '795.0000', '1.0000', ' DARK GUNMETAL/CARMINE/SADDLE', '无', '', '1.0000', null, '541587.0000', '', 'downloadpic\\20160713-024830.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000117', '2016-07-13 02:50:42', 'coachoutlet', '1', 'admin', 'http://www.coachoutlet.com', 'THE rainger in glovetanned leather', null, '795.0000', '1.0000', ' DARK GUNMETAL/CARMINE/SADDLE', '无', '', '1.0000', null, null, '', 'downloadpic\\20160713-025042.jpg', null, null, '0', '3');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000118', '2017-02-20 00:20:24', 'AE', 'undefined', 'admin', 'https://www.amazon.cn/dp/B00AEJXXI8/ref=cngwdyfloorv2_recs_0/452-0547127-9202728?pf_rd_m=A1AJ19PSB66TGU&pf_rd_s=desktop-2&pf_rd_r=VW27QHQ49VPV3QH0V55W&pf_rd_r=VW27QHQ49VPV3QH0V55W&pf_rd_t=36701&pf_rd_p=78d99717-ba38-48ca-89aa-e501d77b022f&pf_rd_p=78d99717-ba38-48ca-89aa-e501d77b022f&pf_rd_i=desktop', 'Canon 佳能 EOS 6D 单反数码相机 单头套机 (EF 24-105mm f/4L IS USM)', null, '13159.0000', '1.0000', '无', '无', '0.8', '1.0000', null, null, '', 'downloadpic\\20170220-002024.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000119', '2017-02-20 00:39:19', 'AE', 'undefined', 'admin', 'https://www.amazon.cn/dp/B00AEJXXI8/ref=cngwdyfloorv2_recs_0/452-0547127-9202728?pf_rd_m=A1AJ19PSB66TGU&pf_rd_s=desktop-2&pf_rd_r=VW27QHQ49VPV3QH0V55W&pf_rd_r=VW27QHQ49VPV3QH0V55W&pf_rd_t=36701&pf_rd_p=78d99717-ba38-48ca-89aa-e501d77b022f&pf_rd_p=78d99717-ba38-48ca-89aa-e501d77b022f&pf_rd_i=desktop', 'Canon 佳能 EOS 6D 单反数码相机 单头套机 (EF 24-105mm f/4L IS USM)', null, '13159.0000', '1.0000', '无', '无', '0.8', '1.0000', null, '5415.0000', '', 'downloadpic\\20170220-003919.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000120', '2017-02-20 00:52:04', 'unknown', '1', 'custom', 'https://www.amazon.com/Advanced-Dissection-Anatomy-Medical-Students/dp/B01M7VYU82/ref=gbps_img_s-3_bb19_d55bdd5d?smid=A2IEIBOAW6TQT9&pf_rd_p=41fd713f-6bfe-4299-a021-d2b94872bb19&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=01VNZGFJWEWDAVB3M007', '22 Pcs Advanced Dissection Kit For Anatomy & Biology Medical Students With Scalpel Knife Handle - 11 Blades - Case - Lab Veterinary Botany Stainless Steel Dissecting Tool Set For Frogs Animals etc', null, '21.5700', '2.0000', '无', '无', '0.66', '1.0000', null, null, '', 'downloadpic\\20170220-005204.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000121', '2017-02-20 01:15:05', 'AE', '1', '笑笑', 'https://www.amazon.com/Color-Technik-Glitter-Amazing-Sparkling/dp/B0190DAES0/ref=gbps_img_s-3_bb19_2530f8ee?smid=A2029BUGW4JY69&pf_rd_p=41fd713f-6bfe-4299-a021-d2b94872bb19&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=S9N97WX6QYJWZ8MC2Z9Z', 'Color Technik Glitter Gel Pens, Amazing Sparkling Colors with Comfort Grip, Set of 12', null, '5.1900', '1.0000', '无', '无', '0.65', '1.0000', null, null, '', 'downloadpic\\20170220-011505.jpg', null, null, '0', '1');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000122', '2017-02-20 01:22:58', 'unknown', '1', '嘿嘿', 'https://www.amazon.com/Signature-Sleep-Mattress-CertiPUR-US-Certified/dp/B005A4OO80/ref=sr_1_1?s=home-garden&ie=UTF8&qid=1487524977&sr=1-1', 'Signature Sleep Memoir 12 Inch Memory Foam Mattress with Low VOC CertiPUR-US Certified Foam, 12 Inch Queen Size Memory Foam Mattress - Available in Multiple Sizes', null, '228.9900', '3.0000', '无', '无', '0.3', '1.0000', null, null, '', 'downloadpic\\20170220-012258.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000123', '2017-02-20 01:33:29', 'unknown', '1', ' 喵喵', 'https://www.amazon.com/Studio-Designs-10050-Futura-Station/dp/B001KWEYP4/ref=gbps_img_s-3_bb19_ca830ceb?smid=ATVPDKIKX0DER&pf_rd_p=41fd713f-6bfe-4299-a021-d2b94872bb19&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=QSZN8M1W66WHBSQSB4JZ', 'Studio Designs 10050 Futura Craft Station, Silver/Blue Glass', null, '119.9900', '1.0000', '无', '无', '0.69', '1.0000', null, null, '', 'downloadpic\\20170220-013329.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000124', '2017-02-21 01:53:44', 'unknown', '1', '大腸麵', 'https://www.amazon.cn/dp/B01MR5B9G2/ref=cngwdyfloorv2_recs_0?pf_rd_p=7645736c-6759-4677-9dfb-2a3fd04770aa&pf_rd_s=desktop-2&pf_rd_t=36701&pf_rd_i=desktop&pf_rd_m=A1AJ19PSB66TGU&pf_rd_r=0YHHH23PHNS6ZWFTY3B0&pf_rd_r=0YHHH23PHNS6ZWFTY3B0&pf_rd_p=7645736c-6759-4677-9dfb-2a3fd04770aa', '小蚁 4K运动相机(黑色)智能摄像机 户外航拍潜水防抖相机 遥控相机', null, '1159.0000', '1.0000', '无', '无', null, '1.0000', null, null, '', 'downloadpic\\20170221-015344.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000125', '2017-02-21 01:57:57', 'unknown', '1', '啦啦啦', 'https://www.amazon.cn/服饰箱包/dp/B01KT78QXQ/ref=lp_1536482071_1_2?s=apparel&ie=UTF8&qid=1487613478&sr=1-2', 'Samsonite 新秀丽 FLOREN系列 可扩展耐磨万向轮四轮拉杆箱 BQ1*09004 黑色 20寸+24寸+28寸 三件套', null, '2479.0000', '3.0000', '无', '无', null, '0.8000', null, null, '', 'downloadpic\\20170221-015757.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000126', '2017-02-22 00:31:39', 'amazon', '1', 'å¦å¦', 'https://www.amazon.com/Makita-Lithium-Ion-Cordless-11-Piece-Ultra-Magnetic/dp/B06VSBDX33/ref=gbps_tit_s-3_bb19_e3068d9f?smid=ATVPDKIKX0DER&pf_rd_p=41fd713f-6bfe-4299-a021-d2b94872bb19&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=7CA3EFH47NM2246ZWSFQ', 'Makita XT218 18V LXT Lithium-Ion Cordless 2-Piece Combo Kit with 11-Piece Makita Impact Gold Torsion Magnetic Bit Set and Makita Impact Gold Ultra-Magnetic Torsion Bit Holder', null, '219.9900', '2.0000', 'æ ', 'æ ', null, '0.8500', null, null, '', 'downloadpic\\20170222-003139.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000127', '2017-02-22 00:33:32', 'amazon', '1', 'å¦å¦', 'https://www.amazon.com/Makita-Lithium-Ion-Cordless-11-Piece-Ultra-Magnetic/dp/B06VSBDX33/ref=gbps_tit_s-3_bb19_e3068d9f?smid=ATVPDKIKX0DER&pf_rd_p=41fd713f-6bfe-4299-a021-d2b94872bb19&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=7CA3EFH47NM2246ZWSFQ', 'Makita XT218 18V LXT Lithium-Ion Cordless 2-Piece Combo Kit with 11-Piece Makita Impact Gold Torsion Magnetic Bit Set and Makita Impact Gold Ultra-Magnetic Torsion Bit Holder', null, '219.9900', '2.0000', 'æ ', 'æ ', null, '0.8500', null, null, '', 'downloadpic\\20170222-003332.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000128', '2017-02-22 00:35:29', 'amazon', '1', 'å¦å¦', 'https://www.amazon.com/Makita-Lithium-Ion-Cordless-11-Piece-Ultra-Magnetic/dp/B06VSBDX33/ref=gbps_tit_s-3_bb19_e3068d9f?smid=ATVPDKIKX0DER&pf_rd_p=41fd713f-6bfe-4299-a021-d2b94872bb19&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=7CA3EFH47NM2246ZWSFQ', 'Makita XT218 18V LXT Lithium-Ion Cordless 2-Piece Combo Kit with 11-Piece Makita Impact Gold Torsion Magnetic Bit Set and Makita Impact Gold Ultra-Magnetic Torsion Bit Holder', null, '219.9900', '2.0000', 'æ ', 'æ ', null, '0.8500', null, null, '', 'downloadpic\\20170222-003529.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000129', '2017-02-22 00:39:59', 'amazon', '1', 'å¦å¦', 'https://www.amazon.com/Makita-Lithium-Ion-Cordless-11-Piece-Ultra-Magnetic/dp/B06VSBDX33/ref=gbps_tit_s-3_bb19_e3068d9f?smid=ATVPDKIKX0DER&pf_rd_p=41fd713f-6bfe-4299-a021-d2b94872bb19&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=7CA3EFH47NM2246ZWSFQ', 'Makita XT218 18V LXT Lithium-Ion Cordless 2-Piece Combo Kit with 11-Piece Makita Impact Gold Torsion Magnetic Bit Set and Makita Impact Gold Ultra-Magnetic Torsion Bit Holder', null, '219.9900', '2.0000', 'æ ', 'æ ', null, '0.8500', null, null, '', 'downloadpic\\20170222-003959.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000130', '2017-02-22 00:45:57', 'amazon', '1', 'å¦å¦å¦å¦', 'https://www.amazon.com/Makita-Lithium-Ion-Cordless-11-Piece-Ultra-Magnetic/dp/B06VSBDX33/ref=gbps_tit_s-3_bb19_e3068d9f?smid=ATVPDKIKX0DER&pf_rd_p=41fd713f-6bfe-4299-a021-d2b94872bb19&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=7CA3EFH47NM2246ZWSFQ', 'Makita XT218 18V LXT Lithium-Ion Cordless 2-Piece Combo Kit with 11-Piece Makita Impact Gold Torsion Magnetic Bit Set and Makita Impact Gold Ultra-Magnetic Torsion Bit Holder', null, '219.9900', '2.0000', 'æ ', 'æ ', null, '0.8900', null, null, '', 'downloadpic\\20170222-004557.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000131', '2017-02-22 00:50:43', 'amazon', '1', 'å¦å¦å¦å¦', 'https://www.amazon.com/Makita-Lithium-Ion-Cordless-11-Piece-Ultra-Magnetic/dp/B06VSBDX33/ref=gbps_tit_s-3_bb19_e3068d9f?smid=ATVPDKIKX0DER&pf_rd_p=41fd713f-6bfe-4299-a021-d2b94872bb19&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=7CA3EFH47NM2246ZWSFQ', 'Makita XT218 18V LXT Lithium-Ion Cordless 2-Piece Combo Kit with 11-Piece Makita Impact Gold Torsion Magnetic Bit Set and Makita Impact Gold Ultra-Magnetic Torsion Bit Holder', null, '129.9900', '2.0000', 'æ ', 'æ ', null, '0.8900', null, null, '', 'downloadpic\\20170222-005043.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000132', '2017-02-22 00:55:30', 'amazon', '1', 'å¦å¦å¦å¦', 'https://www.amazon.com/Makita-Lithium-Ion-Cordless-11-Piece-Ultra-Magnetic/dp/B06VSBDX33/ref=gbps_tit_s-3_bb19_e3068d9f?smid=ATVPDKIKX0DER&pf_rd_p=41fd713f-6bfe-4299-a021-d2b94872bb19&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=7CA3EFH47NM2246ZWSFQ', 'Makita XT218 18V LXT Lithium-Ion Cordless 2-Piece Combo Kit with 11-Piece Makita Impact Gold Torsion Magnetic Bit Set and Makita Impact Gold Ultra-Magnetic Torsion Bit Holder', null, '219.9900', '2.0000', 'æ ', 'æ ', null, '0.8900', null, null, '', 'downloadpic\\20170222-005530.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000133', '2017-02-22 00:58:09', 'amazon', '1', 'å¦å¦å¦', 'https://www.amazon.com/Makita-Lithium-Ion-Cordless-11-Piece-Ultra-Magnetic/dp/B06VSBDX33/ref=gbps_tit_s-3_bb19_e3068d9f?smid=ATVPDKIKX0DER&pf_rd_p=41fd713f-6bfe-4299-a021-d2b94872bb19&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=7CA3EFH47NM2246ZWSFQ', 'Makita XT218 18V LXT Lithium-Ion Cordless 2-Piece Combo Kit with 11-Piece Makita Impact Gold Torsion Magnetic Bit Set and Makita Impact Gold Ultra-Magnetic Torsion Bit Holder', null, '219.9900', '2.0000', 'æ ', 'æ ', null, '0.8800', null, null, '', 'downloadpic\\20170222-005809.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000134', '2017-02-22 01:00:41', 'amazon', '1', 'å¦å¦å¦', 'https://www.amazon.com/Makita-Lithium-Ion-Cordless-11-Piece-Ultra-Magnetic/dp/B06VSBDX33/ref=gbps_tit_s-3_bb19_e3068d9f?smid=ATVPDKIKX0DER&pf_rd_p=41fd713f-6bfe-4299-a021-d2b94872bb19&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=7CA3EFH47NM2246ZWSFQ', 'Makita XT218 18V LXT Lithium-Ion Cordless 2-Piece Combo Kit with 11-Piece Makita Impact Gold Torsion Magnetic Bit Set and Makita Impact Gold Ultra-Magnetic Torsion Bit Holder', null, '219.9900', '2.0000', 'æ ', 'æ ', null, '0.8900', null, null, '', 'downloadpic\\20170222-010041.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000135', '2017-02-22 01:00:58', 'amazon', '1', 'å¦å¦å¦', 'https://www.amazon.com/Makita-Lithium-Ion-Cordless-11-Piece-Ultra-Magnetic/dp/B06VSBDX33/ref=gbps_tit_s-3_bb19_e3068d9f?smid=ATVPDKIKX0DER&pf_rd_p=41fd713f-6bfe-4299-a021-d2b94872bb19&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=7CA3EFH47NM2246ZWSFQ', 'Makita XT218 18V LXT Lithium-Ion Cordless 2-Piece Combo Kit with 11-Piece Makita Impact Gold Torsion Magnetic Bit Set and Makita Impact Gold Ultra-Magnetic Torsion Bit Holder', null, '219.9900', '2.0000', 'æ ', 'æ ', null, '0.8900', null, null, '', 'downloadpic\\20170222-010058.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000136', '2017-02-22 01:17:26', 'amazon', '1', 'heihei', 'https://www.amazon.com/Microsoft-Surface-512GB-Tablet-Intel/dp/B00XJXO4E8/ref=gbps_img_s-3_bb19_53d4d3d6?smid=A334XHS1C5Y12J&pf_rd_p=41fd713f-6bfe-4299-a021-d2b94872bb19&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=9DAET09283AWEYS18ZBW', 'Microsoft Surface Pro 3 512GB WiFi Tablet 12\" Intel Core i7 - Silver - Free Windows 10 Upgrade (Certified Refurbished)', null, '649.9900', '2.0000', 'æ ', 'æ ', null, '0.8900', null, '414.0000', '', 'downloadpic\\20170222-011726.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000137', '2017-02-22 01:42:51', 'amazon', '1', 'lala', 'https://www.amazon.com/dp/B01N2PL2IF/ref=s9_acsd_bw_wf_a_SAOLAdot_cdl_0?pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-6&pf_rd_r=D1RBQ2VC8YW1FCPXTB0Y&pf_rd_t=101&pf_rd_p=cd2baa72-5cab-47ce-942d-b4473cf9967c&pf_rd_i=15500541011', 'PURELL Hand Soap HEALTHY SOAP Fresh Botanicals (Pack of 6)', null, '20.8000', '1.0000', 'æ ', 'æ ', null, '0.8000', null, '521.0000', '', 'downloadpic\\20170222-014251.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000138', '2017-03-06 20:27:15', 'amazon', '1', 'lalla', 'https://www.amazon.cn/gp/product/B01N5XVFX3/ref=s9_acsd_hps_bw_c_x_3_w?pf_rd_m=A1AJ19PSB66TGU&pf_rd_s=merchandised-search-6&pf_rd_r=T2PXM6Y2T9KZADYRTP32&pf_rd_t=101&pf_rd_p=9034a6fa-8564-4862-94a0-078fd6473ad9&pf_rd_i=1537840071&th=1', 'Michael Kors è¿åÂ·ç§å°æ¯ JET SET åå£è¢æç¹/åè©å çç® åç  848 Cherry/æ¨±æ¡çº¢ 30F2GTTT8L ï¼ç¾å½åç é¦æ¸¯ç´é®ï¼', null, '1899.0000', '1.0000', 'æ¨±æ¡çº¢è²', 'æ ', null, '0.9000', null, '515.0000', '', 'downloadpic\\20170306-202715.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000139', '2017-03-06 21:08:36', 'amazon', '1', 'å¦å¦å¦', 'https://www.amazon.cn/dp/B01NBTY4RB/ref=s9_acss_bw_cg_1_1b1_w?pf_rd_m=A1U5RCOVU0NYF2&pf_rd_s=merchandised-search-4&pf_rd_r=P2B59BXG4M1PDMDZH4V1&pf_rd_t=101&pf_rd_p=652aa8d3-4c16-4022-85b1-f512e18fc95b&pf_rd_i=1883241071', 'De\'Longhi å¾·é¾ Iconaå¤å¤ç³»åçµæ°´å£¶-æ©æ¦ç»¿ ï¼æå¤§å©åç é¦æ¸¯ç´é®ï¼', null, '1220.0000', '2.0000', 'æ ', 'æ ', null, '0.8000', null, '5458.0000', '', 'downloadpic\\20170306-210836.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000140', '2017-03-06 22:00:09', 'amazon', '1', 'å¦å¦å¦', 'https://www.amazon.cn/dp/B01F6YG8VY/ref=s9_acss_bw_cg_1_1a1_w?pf_rd_m=A1U5RCOVU0NYF2&pf_rd_s=merchandised-search-4&pf_rd_r=P2B59BXG4M1PDMDZH4V1&pf_rd_t=101&pf_rd_p=652aa8d3-4c16-4022-85b1-f512e18fc95b&pf_rd_i=1883241071', 'De\'Longhi å¾·é¾ æ³µåå¼åèªå¨åå¡æºIcona Vintage ECO310.VGRå¤å¤ç³»å æ©æ¦ç»¿è²ï¼æå¤§å©åç é¦æ¸¯ç´é® å½åå®æ¹èä¿ä¸¤å¹´ï¼', null, '1999.0000', '2.0000', 'æ ', 'æ ', null, '0.8900', null, '5465.0000', '', 'downloadpic\\20170306-220009.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000141', '2017-03-11 00:33:03', 'fresh', '1', 'lalal', 'https://www.amazon.com/LAMPAT-Dimmable-Desk-Lamp-Black/dp/B00KSQ8ZNA/ref=s9_cartx_gw_g60_i1_r?_encoding=UTF8&fpl=fresh&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=&pf_rd_r=4AFR8J2NADDC4S6B01VM&pf_rd_t=36701&pf_rd_p=2a4fafb6-9fdc-425a-aee8-c82daa7b18ed&pf_rd_i=desktop', 'LAMPAT Dimmable LED Desk Lamp, Black', null, '26.9900', '2.0000', 'Black', 'æ ', null, '0.8100', null, null, '', 'downloadpic\\20170311-003303.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000142', '2017-03-11 00:41:57', 'fresh', '1', 'lalal', 'https://www.amazon.com/LAMPAT-Dimmable-Desk-Lamp-Black/dp/B00KSQ8ZNA/ref=s9_cartx_gw_g60_i1_r?_encoding=UTF8&fpl=fresh&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=&pf_rd_r=4AFR8J2NADDC4S6B01VM&pf_rd_t=36701&pf_rd_p=2a4fafb6-9fdc-425a-aee8-c82daa7b18ed&pf_rd_i=desktop', 'LAMPAT Dimmable LED Desk Lamp, Black', null, '26.9900', '2.0000', 'Black', 'æ ', null, '0.8100', null, null, '', 'downloadpic\\20170311-004157.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000143', '2017-03-11 01:08:58', 'amazon', '1', 'ååå', 'https://www.amazon.com/dp/B01LRK9DTA/ref=strm_fn_nad_1_1', 'Beats Solo3 Wireless On-Ear Headphones - Rose Gold', null, '52.5800', '3.0000', 'Rose Gold', 'æ ', null, '0.8500', null, '56.0000', '', 'downloadpic\\20170311-010858.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000144', '2017-03-15 23:35:38', 'coach', '1', 'miao', 'http://china.coach.com/product/86850_LHBCE/detail.htm?collection=women_newarrivals', 'éçè¶ç«ç°æµèç²é¢ç®é©DINKIER æè¢', null, '5950.0000', '2.0000', 'éç²è²', 'æ ', null, '0.8000', null, '4798.0000', '', 'downloadpic\\20170315-233538.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000145', '2017-03-15 23:35:38', 'coach', '1', 'miao', 'http://china.coach.com/product/86850_LHBCE/detail.htm?collection=women_newarrivals', 'éçè¶ç«ç°æµèç²é¢ç®é©DINKIER æè¢', null, '5950.0000', '2.0000', 'éç²è²', 'æ ', null, '0.8000', null, '1213.0000', '', 'downloadpic\\20170315-233538.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000146', '2017-03-15 23:39:43', 'coach', '1', 'miao', 'http://china.coach.com/product/86850_LHBCE/detail.htm?collection=women_newarrivals', 'éçè¶ç«ç°æµèç²é¢ç®é©DINKIER æè¢', null, '5950.0000', '2.0000', 'éç²è²', 'æ ', null, '0.8000', null, '554.0000', '', 'downloadpic\\20170315-233943.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000147', '2017-03-20 00:06:19', 'unknown', '1', 'åµ', '123', '133MIAOMII', null, '1232.0000', '23.0000', 'æ ', 'æ ', null, '0.9800', null, '27769.2812', '', 'downloadpic\\20170320-000619.jpg', null, null, '0', '0');
INSERT INTO `bd_dw_dcm_order_record` VALUES ('0000000148', '2017-04-08 20:22:58', 'amazon', '1', '喵喵', 'https://www.amazon.cn/gp/product/B01ISWJSPO/ref=zg_bs_wireless_1?ie=UTF8&psc=1&refRID=XQ1SCHABR5GJTY2FGJEY', 'HUAWEI 华为 荣耀8 FRD-AL10 4GB+64GB 全网通版4G手机(魅海蓝)', null, '2599.0000', '5.0000', '魅海蓝', '4GB+64GB版', null, '0.8900', null, '11565.5498', '', 'downloadpic\\20170408-202258.jpg', null, null, '0', '1');

-- ----------------------------
-- Table structure for bd_dw_dcm_order_record_copy
-- ----------------------------
DROP TABLE IF EXISTS `bd_dw_dcm_order_record_copy`;
CREATE TABLE `bd_dw_dcm_order_record_copy` (
  `ORDER_ID` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `ORDER_DATE` varchar(8) NOT NULL COMMENT '下单日期',
  `GROUP_ID` varchar(10) DEFAULT NULL COMMENT '团号',
  `CST_ID` varchar(30) NOT NULL COMMENT '客户id',
  `LINK` varchar(100) NOT NULL COMMENT '商品链接',
  `COMMODITY_NAME` varchar(100) NOT NULL COMMENT '商品英文名称',
  `COMMODITY_DESC` varchar(100) NOT NULL COMMENT '商品中文描述',
  `UNIT_PRICE` float(10,4) NOT NULL COMMENT '商品单价',
  `AMOUNT` float(4,4) NOT NULL COMMENT '数量',
  `GOODS_COLOR` varchar(255) NOT NULL,
  `GOODS_SIZE` varchar(50) NOT NULL COMMENT '尺寸',
  `DISCOUNT_1` float(4,4) DEFAULT NULL COMMENT '折扣1',
  `DISCOUNT_2` float(4,4) DEFAULT NULL COMMENT '折扣2',
  `TOTAL_PRICE` float(4,4) DEFAULT NULL COMMENT '商品总价',
  `COMMENTS` char(200) DEFAULT NULL COMMENT '备注',
  `PICTURE` blob COMMENT '图片地址',
  `OVERSEAS_FREIGH` float(4,4) DEFAULT NULL COMMENT '国际运费',
  `INLAND_FREIGH` float(10,4) DEFAULT NULL COMMENT '国内运费',
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_dw_dcm_order_record_copy
-- ----------------------------
INSERT INTO `bd_dw_dcm_order_record_copy` VALUES ('0000000001', '20160129', '1', 'CATHY', 'WWW.BAIDU.COM', 'LALALA', 'LALALA', '20.0000', '0.0000', 'BLACK', 'xl', null, null, null, 'HAHA', null, null, null);

-- ----------------------------
-- Table structure for bd_dw_dcm_usr_customer_info
-- ----------------------------
DROP TABLE IF EXISTS `bd_dw_dcm_usr_customer_info`;
CREATE TABLE `bd_dw_dcm_usr_customer_info` (
  `USER_ID` varchar(20) NOT NULL COMMENT '用户名',
  `MEMBER_LEVEL` varchar(1) NOT NULL,
  `COMMEN_ADDR` varchar(255) DEFAULT NULL,
  `START_DATE` varchar(8) DEFAULT NULL,
  `END_DATE` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_dw_dcm_usr_customer_info
-- ----------------------------
INSERT INTO `bd_dw_dcm_usr_customer_info` VALUES ('fruitss', '1', '上海宝山区XX路XX号', null, null);
INSERT INTO `bd_dw_dcm_usr_customer_info` VALUES ('fullcolour', '3', '上海宝山区XX路XX号', null, null);
INSERT INTO `bd_dw_dcm_usr_customer_info` VALUES ('glue', '2', '上海宝山区XX路XX号', null, null);
INSERT INTO `bd_dw_dcm_usr_customer_info` VALUES ('honeyck', '1', '上海宝山区XX路XX号', null, null);
INSERT INTO `bd_dw_dcm_usr_customer_info` VALUES ('iamxq', '3', '上海宝山区XX路XX号', null, null);
INSERT INTO `bd_dw_dcm_usr_customer_info` VALUES ('Janet1578', '2', '上海宝山区XX路XX号', null, null);
INSERT INTO `bd_dw_dcm_usr_customer_info` VALUES ('linda93_lee', '2', '上海宝山区XX路XX号', null, null);
INSERT INTO `bd_dw_dcm_usr_customer_info` VALUES ('LV小桑', '2', '上海宝山区XX路XX号', null, null);
INSERT INTO `bd_dw_dcm_usr_customer_info` VALUES ('海棉baby', '2', '上海宝山区XX路XX号', null, null);

-- ----------------------------
-- Table structure for bd_prm_dcm_usr_exchange_rate
-- ----------------------------
DROP TABLE IF EXISTS `bd_prm_dcm_usr_exchange_rate`;
CREATE TABLE `bd_prm_dcm_usr_exchange_rate` (
  `MEMBER_LEVEL` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '会员等级(0-钻石,1-黄金,2-普通）',
  `MEMBER_DESC` varchar(20) DEFAULT NULL,
  `EXCHANGE_RATE` float(4,2) NOT NULL,
  `START_DATE` varchar(8) NOT NULL,
  `END_DATE` varchar(8) NOT NULL,
  PRIMARY KEY (`MEMBER_LEVEL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_prm_dcm_usr_exchange_rate
-- ----------------------------
INSERT INTO `bd_prm_dcm_usr_exchange_rate` VALUES ('1', '钻石会员', '7.45', '20040101', '99991231');
INSERT INTO `bd_prm_dcm_usr_exchange_rate` VALUES ('2', '黄金会员', '7.55', '20040101', '99991231');
INSERT INTO `bd_prm_dcm_usr_exchange_rate` VALUES ('3', '普通会员', '7.65', '20040101', '99991231');

-- ----------------------------
-- Table structure for bd_prm_dcm_usr_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `bd_prm_dcm_usr_sys_user`;
CREATE TABLE `bd_prm_dcm_usr_sys_user` (
  `USER_ID` varchar(20) NOT NULL COMMENT '用户名',
  `USER_PWD` varchar(255) NOT NULL COMMENT '登录密码',
  `ROLE` varchar(2) NOT NULL COMMENT '角色(0-系统用户,1-管理员,2-客服,3-买手,4-转运公司)',
  `LOCATION` varchar(20) NOT NULL COMMENT '地点'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bd_prm_dcm_usr_sys_user
-- ----------------------------
INSERT INTO `bd_prm_dcm_usr_sys_user` VALUES ('Cathy', 'mianmian898989', '0', 'SH');
INSERT INTO `bd_prm_dcm_usr_sys_user` VALUES ('Mianmian', 'mianmian898989', '1', 'SH');
INSERT INTO `bd_prm_dcm_usr_sys_user` VALUES ('JOJO', 'mianmian898989', '2', 'SH');

-- ----------------------------
-- Table structure for heroes
-- ----------------------------
DROP TABLE IF EXISTS `heroes`;
CREATE TABLE `heroes` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(70) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of heroes
-- ----------------------------
INSERT INTO `heroes` VALUES ('1', 'Thanos', 'thanos@infgauntlet.com', '5555555555');
INSERT INTO `heroes` VALUES ('2', 'Spider Man', 'peter.parker@thebugle.net', '2125555555');
INSERT INTO `heroes` VALUES ('3', 'Daredevil', 'matt.murdock@nelsonandmurdock.org', '2125555555');
INSERT INTO `heroes` VALUES ('4', 'The Maker', 'reed.richards@therealreedrichards.net', '2125555555');
INSERT INTO `heroes` VALUES ('5', 'Rocket', 'rocket@starlordstinks.com', '5555555555');
INSERT INTO `heroes` VALUES ('6', 'Galactus', 'galactus@worldeater.com', '5555555555');
INSERT INTO `heroes` VALUES ('7', 'Silver Surfer', 'norrin.radd@zenn-la.gov', '5555555555');
INSERT INTO `heroes` VALUES ('8', 'Hulk', 'bruce.banner@hulkout.org', '2125555555');
INSERT INTO `heroes` VALUES ('9', 'Squirrel Girl', 'doreen.green@nannyservices.net', '2125555555');
INSERT INTO `heroes` VALUES ('10', 'Thor', 'thor@odinson.gov', '5555555555');
