/*
 Navicat Premium Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 100137
 Source Host           : 114.116.7.87:3306
 Source Schema         : canteen

 Target Server Type    : MySQL
 Target Server Version : 100137
 File Encoding         : 65001

 Date: 17/02/2020 20:36:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for askedfood
-- ----------------------------
DROP TABLE IF EXISTS `askedfood`;
CREATE TABLE `askedfood`  (
  `foodname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fooduid` int(11) NOT NULL AUTO_INCREMENT COMMENT '每次进货不同东西的编号',
  `askedamount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `finishtime` datetime(0) NULL DEFAULT NULL,
  `ordernumber` int(11) NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0未处理，1已处理',
  PRIMARY KEY (`fooduid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 111 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of askedfood
-- ----------------------------
INSERT INTO `askedfood` VALUES ('白菜', 1, '100', '2019-11-27 16:09:08', 2, '1');
INSERT INTO `askedfood` VALUES ('白菜', 2, '100', '2019-11-27 16:09:18', 2, '1');
INSERT INTO `askedfood` VALUES ('白菜', 3, '100', '2019-11-27 16:09:26', 2, '1');
INSERT INTO `askedfood` VALUES ('白菜', 4, '150', '2019-11-27 16:14:02', 2, '1');
INSERT INTO `askedfood` VALUES ('猪肉', 5, '150', '2019-11-27 16:21:58', 2, '1');
INSERT INTO `askedfood` VALUES ('白菜', 6, '150', '2019-11-27 16:49:32', 2, '1');
INSERT INTO `askedfood` VALUES ('白菜', 7, '100', '2019-11-27 16:52:20', 2, '1');
INSERT INTO `askedfood` VALUES ('猪肉', 8, '100', '2019-11-27 16:52:23', 3, '1');
INSERT INTO `askedfood` VALUES ('白菜', 9, '300', '2019-11-27 17:23:03', 3, '1');
INSERT INTO `askedfood` VALUES ('白菜', 10, '200', '2019-11-28 09:36:45', 4, '1');
INSERT INTO `askedfood` VALUES ('猪肉', 11, '100', '2019-11-28 09:42:49', 4, '1');
INSERT INTO `askedfood` VALUES ('猪肉', 12, '0', '2019-11-28 09:42:51', 6, '1');
INSERT INTO `askedfood` VALUES ('白菜', 13, '150', '2019-11-29 13:17:31', 5, '1');
INSERT INTO `askedfood` VALUES ('白菜', 14, '200', '2019-11-29 14:16:38', 7, '1');
INSERT INTO `askedfood` VALUES ('白菜', 15, '450', '2019-11-29 16:54:39', 7, '1');
INSERT INTO `askedfood` VALUES ('鸡肉', 17, '250', '2019-11-29 16:54:54', 7, '1');
INSERT INTO `askedfood` VALUES ('白菜', 18, '300', '2019-11-29 16:57:04', 7, '1');
INSERT INTO `askedfood` VALUES ('白菜', 19, '400', '2019-11-29 16:57:10', 8, '1');
INSERT INTO `askedfood` VALUES ('猪肉', 20, '100', '2019-11-29 16:57:15', 8, '1');
INSERT INTO `askedfood` VALUES ('白菜', 21, '100', '2019-11-29 16:58:40', 8, '1');
INSERT INTO `askedfood` VALUES ('白菜', 22, '100', '2019-11-29 17:06:51', 8, '1');
INSERT INTO `askedfood` VALUES ('猪肉', 23, '0', '2019-11-29 17:06:59', 8, '1');
INSERT INTO `askedfood` VALUES ('猪肉', 24, '0', '2019-11-29 17:07:00', 19, '1');
INSERT INTO `askedfood` VALUES ('鸡肉', 25, '250', '2019-11-29 17:07:07', 14, '1');
INSERT INTO `askedfood` VALUES ('白菜', 26, '50', '2019-11-29 17:33:24', 14, '1');
INSERT INTO `askedfood` VALUES ('白菜', 27, '100', '2019-11-29 17:35:18', 14, '1');
INSERT INTO `askedfood` VALUES ('白菜', 28, '0', '2019-11-29 17:35:46', 15, '1');
INSERT INTO `askedfood` VALUES ('白菜', 29, '150', '2019-12-02 13:38:51', 15, '1');
INSERT INTO `askedfood` VALUES ('鸡肉', 30, '100', '2019-12-02 13:39:02', 15, '1');
INSERT INTO `askedfood` VALUES ('鸡肉', 31, '100', '2019-12-02 13:39:04', 17, '1');
INSERT INTO `askedfood` VALUES ('猪肉', 32, '100', '2019-12-02 13:39:06', 17, '1');
INSERT INTO `askedfood` VALUES ('生菜', 33, '100', '2019-12-02 13:39:07', 16, '1');
INSERT INTO `askedfood` VALUES ('猪肉', 34, '0', '2019-12-02 14:04:46', 19, '1');
INSERT INTO `askedfood` VALUES ('鸡肉', 35, '350', '2019-12-02 14:09:12', 16, '1');
INSERT INTO `askedfood` VALUES ('生菜', 36, '150', '2019-12-02 14:45:17', 18, '1');
INSERT INTO `askedfood` VALUES ('猪肉', 37, '100', '2019-12-02 14:45:19', 18, '1');
INSERT INTO `askedfood` VALUES ('鸡肉', 38, '150', '2019-12-02 14:45:21', 18, '1');
INSERT INTO `askedfood` VALUES ('白菜', 39, '150', '2019-12-02 18:49:25', 19, '1');
INSERT INTO `askedfood` VALUES ('白菜', 40, '150', '2019-12-04 19:34:26', 26, '1');
INSERT INTO `askedfood` VALUES ('生菜', 41, '150', '2019-12-04 19:34:28', 26, '1');
INSERT INTO `askedfood` VALUES ('猪肉', 42, '150', '2019-12-04 19:34:29', 26, '1');
INSERT INTO `askedfood` VALUES ('鸡肉', 43, '200', '2019-12-04 19:34:32', 26, '1');
INSERT INTO `askedfood` VALUES ('猪肉', 44, '200', '2019-12-04 19:34:37', 27, '1');
INSERT INTO `askedfood` VALUES ('生菜', 45, '200', '2019-12-04 19:34:39', 26, '1');
INSERT INTO `askedfood` VALUES ('鱼', 46, '300', '2019-12-04 19:34:43', 21, '1');
INSERT INTO `askedfood` VALUES ('韭菜', 47, '300', '2019-12-04 19:34:47', 21, '1');
INSERT INTO `askedfood` VALUES ('白菜', 48, '250', '2019-12-04 19:34:50', 21, '1');
INSERT INTO `askedfood` VALUES ('猪肉', 49, '200', '2019-12-04 19:34:52', 21, '1');
INSERT INTO `askedfood` VALUES ('鸡肉', 50, '200', '2019-12-04 19:34:55', 21, '1');
INSERT INTO `askedfood` VALUES ('花菜', 51, '200', '2019-12-04 19:34:56', 21, '1');
INSERT INTO `askedfood` VALUES ('猪肉', 52, '0', '2019-12-04 19:34:59', 21, '1');
INSERT INTO `askedfood` VALUES ('白菜', 53, '200', '2019-12-04 19:35:02', 21, '1');
INSERT INTO `askedfood` VALUES ('生菜', 54, '200', '2019-12-04 19:35:03', 21, '1');
INSERT INTO `askedfood` VALUES ('鸡肉', 55, '0', '2019-12-05 19:11:44', 27, '1');
INSERT INTO `askedfood` VALUES ('生菜', 56, '300', '2019-12-05 19:11:50', 27, '1');
INSERT INTO `askedfood` VALUES ('猪肉', 57, '250', '2019-12-05 19:11:52', 27, '1');
INSERT INTO `askedfood` VALUES ('白菜', 58, '350', '2019-12-06 13:50:41', 28, '1');
INSERT INTO `askedfood` VALUES ('白菜', 59, '100', '2019-12-06 13:50:51', 28, '1');
INSERT INTO `askedfood` VALUES ('鸡肉', 60, '150', '2019-12-06 14:24:41', 31, '1');
INSERT INTO `askedfood` VALUES ('鱼', 71, '300', '2019-12-13 14:02:34', 43, '1');
INSERT INTO `askedfood` VALUES ('鱼', 72, '350', '2019-12-13 14:03:18', 42, '1');
INSERT INTO `askedfood` VALUES ('鸡肉', 73, '450', '2019-12-13 14:04:06', 37, '1');
INSERT INTO `askedfood` VALUES ('鱼', 74, '800', '2019-12-28 20:07:06', 37, '1');
INSERT INTO `askedfood` VALUES ('花菜', 75, '100', '2019-12-28 20:07:07', 37, '1');
INSERT INTO `askedfood` VALUES ('猪肉', 76, '2508', '2019-12-28 20:07:09', 37, '1');
INSERT INTO `askedfood` VALUES ('生菜', 77, '150', '2019-12-28 20:07:11', 37, '1');
INSERT INTO `askedfood` VALUES ('白菜', 78, '100', '2019-12-28 20:07:13', 37, '1');
INSERT INTO `askedfood` VALUES ('生菜', 79, '522', '2019-12-28 20:10:49', 37, '1');
INSERT INTO `askedfood` VALUES ('花菜', 87, '50', '2020-02-16 15:02:23', 42, '1');
INSERT INTO `askedfood` VALUES ('韭菜', 88, '200', '2020-02-16 15:02:48', 43, '1');
INSERT INTO `askedfood` VALUES ('鱼', 89, '50', '2020-02-16 15:02:52', 43, '1');
INSERT INTO `askedfood` VALUES ('韭菜', 90, '20', '2020-02-16 19:13:18', 45, '1');
INSERT INTO `askedfood` VALUES ('鱼', 91, '40', '2020-02-16 19:13:26', 45, '1');
INSERT INTO `askedfood` VALUES ('生菜', 92, '100', '2020-02-16 19:13:34', 44, '1');
INSERT INTO `askedfood` VALUES ('鸡肉', 93, '450', '2020-02-16 19:13:41', 44, '1');
INSERT INTO `askedfood` VALUES ('韭菜', 94, '200', '2020-02-17 12:23:03', 42, '1');
INSERT INTO `askedfood` VALUES ('鱼', 95, '50', '2020-02-17 12:23:06', 42, '1');
INSERT INTO `askedfood` VALUES ('花菜', 96, '50', '2020-02-17 12:23:08', 47, '1');
INSERT INTO `askedfood` VALUES ('花菜', 97, '50', '2020-02-17 12:23:12', 46, '1');
INSERT INTO `askedfood` VALUES ('韭菜', 98, '100', '2020-02-17 12:35:28', 46, '1');
INSERT INTO `askedfood` VALUES ('鸡肉', 99, '100', '2020-02-17 12:35:38', 46, '1');
INSERT INTO `askedfood` VALUES ('生菜', 100, '200', '2020-02-17 12:35:44', 47, '1');
INSERT INTO `askedfood` VALUES ('鸭肉', 101, '10', '2020-02-17 13:52:27', 47, '1');
INSERT INTO `askedfood` VALUES ('鸭肉', 102, '20', '2020-02-17 13:52:31', NULL, '0');
INSERT INTO `askedfood` VALUES ('鸭肉', 103, '50', '2020-02-17 13:52:34', NULL, '0');
INSERT INTO `askedfood` VALUES ('牛肉', 104, '100', '2020-02-17 13:52:40', 47, '1');
INSERT INTO `askedfood` VALUES ('牛肉', 105, '15', '2020-02-17 13:52:44', NULL, '0');
INSERT INTO `askedfood` VALUES ('牛肉', 106, '30', '2020-02-17 13:52:49', NULL, '0');
INSERT INTO `askedfood` VALUES ('芹菜', 107, '80', '2020-02-17 13:52:54', 47, '1');
INSERT INTO `askedfood` VALUES ('芹菜', 108, '158', '2020-02-17 13:52:59', NULL, '0');
INSERT INTO `askedfood` VALUES ('芹菜', 109, '60', '2020-02-17 13:53:02', NULL, '0');
INSERT INTO `askedfood` VALUES ('韭菜', 110, '455', '2020-02-17 13:53:08', NULL, '0');

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food`  (
  `foodname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `foodid` int(11) NOT NULL AUTO_INCREMENT,
  `foodamount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库存量',
  `alarmamount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报警值',
  `money` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单价',
  `changenum` int(11) NULL DEFAULT NULL,
  `lowalarmamount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '低报警值',
  PRIMARY KEY (`foodid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('白菜', 1, '4502', '300', '10', NULL, '0');
INSERT INTO `food` VALUES ('生菜', 2, '1300', '125', '20', NULL, '0');
INSERT INTO `food` VALUES ('猪肉', 3, '2080', '350', '80', NULL, '0');
INSERT INTO `food` VALUES ('鸡肉', 4, '1350', '300', '50', NULL, '0');
INSERT INTO `food` VALUES ('花菜', 5, '-50', '500', '5', NULL, '0');
INSERT INTO `food` VALUES ('鱼', 6, '-50', '200', '30', NULL, '0');
INSERT INTO `food` VALUES ('韭菜', 7, '-200', '600', '6', NULL, '0');
INSERT INTO `food` VALUES ('芹菜', 8, '500', '800', '10', 0, '200');
INSERT INTO `food` VALUES ('牛肉', 11, '100', '200', '25', 0, '10');
INSERT INTO `food` VALUES ('鸭肉', 12, '95', '500', '25', 0, '200');

-- ----------------------------
-- Table structure for historybuy
-- ----------------------------
DROP TABLE IF EXISTS `historybuy`;
CREATE TABLE `historybuy`  (
  `foodid` int(11) NOT NULL,
  `time` datetime(0) NULL,
  `buynumber` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of historybuy
-- ----------------------------
INSERT INTO `historybuy` VALUES (1, '2019-11-29 16:54:39', 450);
INSERT INTO `historybuy` VALUES (3, '2019-11-29 16:54:44', 100);
INSERT INTO `historybuy` VALUES (4, '2019-11-29 16:54:54', 250);
INSERT INTO `historybuy` VALUES (1, '2019-11-29 17:06:52', 100);
INSERT INTO `historybuy` VALUES (3, '2019-11-29 17:06:59', 0);
INSERT INTO `historybuy` VALUES (3, '2019-11-29 17:07:00', 0);
INSERT INTO `historybuy` VALUES (4, '2019-11-29 17:07:07', 250);
INSERT INTO `historybuy` VALUES (1, '2019-11-29 17:33:24', 50);
INSERT INTO `historybuy` VALUES (1, '2019-11-29 17:35:18', 100);
INSERT INTO `historybuy` VALUES (1, '2019-11-29 17:35:46', 0);
INSERT INTO `historybuy` VALUES (1, '2019-12-02 13:38:51', 150);
INSERT INTO `historybuy` VALUES (4, '2019-12-02 13:39:02', 100);
INSERT INTO `historybuy` VALUES (4, '2019-12-02 13:39:04', 100);
INSERT INTO `historybuy` VALUES (3, '2019-12-02 13:39:06', 100);
INSERT INTO `historybuy` VALUES (2, '2019-12-02 13:39:08', 100);
INSERT INTO `historybuy` VALUES (3, '2019-12-02 14:04:46', 0);
INSERT INTO `historybuy` VALUES (4, '2019-12-02 14:09:12', 350);
INSERT INTO `historybuy` VALUES (2, '2019-12-02 14:45:17', 150);
INSERT INTO `historybuy` VALUES (3, '2019-12-02 14:45:19', 100);
INSERT INTO `historybuy` VALUES (4, '2019-12-02 14:45:21', 150);
INSERT INTO `historybuy` VALUES (1, '2019-12-02 18:49:25', 150);
INSERT INTO `historybuy` VALUES (1, '2019-12-04 19:34:26', 150);
INSERT INTO `historybuy` VALUES (2, '2019-12-04 19:34:28', 150);
INSERT INTO `historybuy` VALUES (3, '2019-12-04 19:34:30', 150);
INSERT INTO `historybuy` VALUES (4, '2019-12-04 19:34:32', 200);
INSERT INTO `historybuy` VALUES (3, '2019-12-04 19:34:37', 200);
INSERT INTO `historybuy` VALUES (2, '2019-12-04 19:34:40', 200);
INSERT INTO `historybuy` VALUES (6, '2019-12-04 19:34:44', 300);
INSERT INTO `historybuy` VALUES (7, '2019-12-04 19:34:47', 300);
INSERT INTO `historybuy` VALUES (1, '2019-12-04 19:34:50', 250);
INSERT INTO `historybuy` VALUES (3, '2019-12-04 19:34:52', 200);
INSERT INTO `historybuy` VALUES (4, '2019-12-04 19:34:55', 200);
INSERT INTO `historybuy` VALUES (5, '2019-12-04 19:34:57', 200);
INSERT INTO `historybuy` VALUES (3, '2019-12-04 19:34:59', 0);
INSERT INTO `historybuy` VALUES (1, '2019-12-04 19:35:02', 200);
INSERT INTO `historybuy` VALUES (2, '2019-12-04 19:35:03', 200);
INSERT INTO `historybuy` VALUES (4, '2019-12-05 19:11:44', 0);
INSERT INTO `historybuy` VALUES (2, '2019-12-05 19:11:50', 300);
INSERT INTO `historybuy` VALUES (3, '2019-12-05 19:11:52', 250);
INSERT INTO `historybuy` VALUES (1, '2019-12-06 13:50:41', 350);
INSERT INTO `historybuy` VALUES (1, '2019-12-06 13:50:51', 100);
INSERT INTO `historybuy` VALUES (4, '2019-12-06 14:24:42', 150);
INSERT INTO `historybuy` VALUES (4, '2019-12-06 14:24:47', 200);
INSERT INTO `historybuy` VALUES (1, '2019-12-06 22:31:39', 0);
INSERT INTO `historybuy` VALUES (4, '2019-12-06 22:33:48', 0);
INSERT INTO `historybuy` VALUES (1, '2019-12-09 02:02:57', 0);
INSERT INTO `historybuy` VALUES (4, '2019-12-09 02:03:37', 0);
INSERT INTO `historybuy` VALUES (1, '2019-12-09 02:04:10', 0);
INSERT INTO `historybuy` VALUES (1, '2019-12-09 02:05:04', 100);
INSERT INTO `historybuy` VALUES (7, '2019-12-13 12:35:12', 50);
INSERT INTO `historybuy` VALUES (1, '2019-12-13 12:35:40', 100);
INSERT INTO `historybuy` VALUES (1, '2019-12-13 13:10:58', 100);
INSERT INTO `historybuy` VALUES (6, '2019-12-13 14:02:35', 300);
INSERT INTO `historybuy` VALUES (6, '2019-12-13 14:03:19', 350);
INSERT INTO `historybuy` VALUES (4, '2019-12-13 14:04:06', 450);
INSERT INTO `historybuy` VALUES (6, '2019-12-28 20:07:06', 800);
INSERT INTO `historybuy` VALUES (5, '2019-12-28 20:07:07', 100);
INSERT INTO `historybuy` VALUES (3, '2019-12-28 20:07:09', 2508);
INSERT INTO `historybuy` VALUES (2, '2019-12-28 20:07:11', 150);
INSERT INTO `historybuy` VALUES (1, '2019-12-28 20:07:13', 100);
INSERT INTO `historybuy` VALUES (2, '2019-12-28 20:10:49', 522);
INSERT INTO `historybuy` VALUES (7, '2020-02-15 20:00:59', 200);
INSERT INTO `historybuy` VALUES (7, '2020-02-15 20:10:07', 200);
INSERT INTO `historybuy` VALUES (6, '2020-02-15 20:10:11', 50);
INSERT INTO `historybuy` VALUES (5, '2020-02-16 15:02:23', 50);
INSERT INTO `historybuy` VALUES (7, '2020-02-16 15:02:49', 200);
INSERT INTO `historybuy` VALUES (6, '2020-02-16 15:02:52', 50);
INSERT INTO `historybuy` VALUES (7, '2020-02-16 19:13:19', 20);
INSERT INTO `historybuy` VALUES (6, '2020-02-16 19:13:27', 40);
INSERT INTO `historybuy` VALUES (2, '2020-02-16 19:13:34', 100);
INSERT INTO `historybuy` VALUES (4, '2020-02-16 19:13:42', 450);
INSERT INTO `historybuy` VALUES (7, '2020-02-17 12:23:03', 200);
INSERT INTO `historybuy` VALUES (6, '2020-02-17 12:23:06', 50);
INSERT INTO `historybuy` VALUES (5, '2020-02-17 12:23:12', 50);
INSERT INTO `historybuy` VALUES (5, '2020-02-17 12:23:13', 50);
INSERT INTO `historybuy` VALUES (7, '2020-02-17 12:35:30', 100);
INSERT INTO `historybuy` VALUES (4, '2020-02-17 12:35:38', 100);
INSERT INTO `historybuy` VALUES (2, '2020-02-17 12:35:44', 200);
INSERT INTO `historybuy` VALUES (12, '2020-02-17 13:52:27', 10);
INSERT INTO `historybuy` VALUES (12, '2020-02-17 13:52:31', 20);
INSERT INTO `historybuy` VALUES (12, '2020-02-17 13:52:35', 50);
INSERT INTO `historybuy` VALUES (11, '2020-02-17 13:52:40', 100);
INSERT INTO `historybuy` VALUES (11, '2020-02-17 13:52:45', 15);
INSERT INTO `historybuy` VALUES (11, '2020-02-17 13:52:49', 30);
INSERT INTO `historybuy` VALUES (8, '2020-02-17 13:52:55', 80);
INSERT INTO `historybuy` VALUES (8, '2020-02-17 13:52:59', 158);
INSERT INTO `historybuy` VALUES (8, '2020-02-17 13:53:03', 60);
INSERT INTO `historybuy` VALUES (7, '2020-02-17 13:53:09', 455);

-- ----------------------------
-- Table structure for historyuse
-- ----------------------------
DROP TABLE IF EXISTS `historyuse`;
CREATE TABLE `historyuse`  (
  `foodid` int(11) NOT NULL,
  `time` datetime(0) NULL,
  `usenumber` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of historyuse
-- ----------------------------
INSERT INTO `historyuse` VALUES (1, '2019-11-29 16:54:59', 200);
INSERT INTO `historyuse` VALUES (3, '2019-11-29 16:54:50', 100);
INSERT INTO `historyuse` VALUES (2, '2019-11-29 17:06:58', 100);
INSERT INTO `historyuse` VALUES (3, '2019-11-29 17:07:04', 100);
INSERT INTO `historyuse` VALUES (1, '2019-11-29 19:44:52', 100);
INSERT INTO `historyuse` VALUES (1, '2019-11-29 19:44:55', 0);
INSERT INTO `historyuse` VALUES (1, '2019-11-29 19:44:59', 100);
INSERT INTO `historyuse` VALUES (1, '2019-11-29 19:45:05', 50);
INSERT INTO `historyuse` VALUES (1, '2019-11-29 19:45:09', 100);
INSERT INTO `historyuse` VALUES (4, '2019-11-29 20:52:00', 0);
INSERT INTO `historyuse` VALUES (4, '2019-11-29 20:52:03', 100);
INSERT INTO `historyuse` VALUES (4, '2019-11-29 20:52:07', 50);
INSERT INTO `historyuse` VALUES (4, '2019-11-29 20:52:10', 50);
INSERT INTO `historyuse` VALUES (4, '2019-11-29 20:52:13', 100);
INSERT INTO `historyuse` VALUES (4, '2019-11-29 20:52:15', 50);
INSERT INTO `historyuse` VALUES (3, '2019-11-29 20:52:49', 50);
INSERT INTO `historyuse` VALUES (3, '2019-11-29 20:52:52', 50);
INSERT INTO `historyuse` VALUES (3, '2019-11-29 20:52:56', 150);
INSERT INTO `historyuse` VALUES (2, '2019-12-02 13:38:57', 100);
INSERT INTO `historyuse` VALUES (4, '2019-12-02 13:39:11', 100);
INSERT INTO `historyuse` VALUES (4, '2019-12-02 14:09:06', 350);
INSERT INTO `historyuse` VALUES (2, '2019-12-02 18:49:29', 200);
INSERT INTO `historyuse` VALUES (4, '2019-12-05 19:11:56', 50);
INSERT INTO `historyuse` VALUES (6, '2019-12-05 19:12:09', 150);
INSERT INTO `historyuse` VALUES (6, '2019-12-05 19:12:12', 200);
INSERT INTO `historyuse` VALUES (7, '2019-12-05 19:12:15', 250);
INSERT INTO `historyuse` VALUES (2, '2019-12-06 13:47:32', 200);
INSERT INTO `historyuse` VALUES (2, '2019-12-06 13:47:43', 200);
INSERT INTO `historyuse` VALUES (1, '2019-12-06 13:51:39', 350);
INSERT INTO `historyuse` VALUES (2, '2019-12-06 13:51:48', 100);
INSERT INTO `historyuse` VALUES (1, '2019-12-06 13:51:57', 150);
INSERT INTO `historyuse` VALUES (4, '2019-12-06 14:24:45', 150);
INSERT INTO `historyuse` VALUES (1, '2019-12-09 02:03:59', 100);
INSERT INTO `historyuse` VALUES (1, '2019-12-09 02:04:08', 100);
INSERT INTO `historyuse` VALUES (4, '2019-12-09 02:04:17', 0);
INSERT INTO `historyuse` VALUES (4, '2019-12-09 02:04:28', 300);
INSERT INTO `historyuse` VALUES (4, '2019-12-09 02:04:48', 300);
INSERT INTO `historyuse` VALUES (1, '2019-12-09 08:59:07', 300);
INSERT INTO `historyuse` VALUES (5, '2019-12-28 20:07:21', 250);
INSERT INTO `historyuse` VALUES (3, '2019-12-28 20:11:37', 200);
INSERT INTO `historyuse` VALUES (1, '2019-12-28 20:16:04', 100);
INSERT INTO `historyuse` VALUES (1, '2019-12-28 20:16:06', 50);
INSERT INTO `historyuse` VALUES (1, '2019-12-28 20:16:10', 200);
INSERT INTO `historyuse` VALUES (1, '2019-12-28 20:16:13', 150);
INSERT INTO `historyuse` VALUES (1, '2019-12-28 20:16:16', 400);
INSERT INTO `historyuse` VALUES (1, '2019-12-28 20:16:19', 150);
INSERT INTO `historyuse` VALUES (1, '2020-02-15 15:42:05', 20);
INSERT INTO `historyuse` VALUES (1, '2020-02-15 17:30:14', 400);
INSERT INTO `historyuse` VALUES (2, '2020-02-15 17:30:31', 200);
INSERT INTO `historyuse` VALUES (1, '2020-02-15 18:35:06', 20);
INSERT INTO `historyuse` VALUES (1, '2020-02-15 18:35:15', 50);
INSERT INTO `historyuse` VALUES (1, '2020-02-15 18:35:24', 40);
INSERT INTO `historyuse` VALUES (1, '2020-02-15 18:35:33', 80);
INSERT INTO `historyuse` VALUES (1, '2020-02-15 18:35:41', 50);
INSERT INTO `historyuse` VALUES (3, '2020-02-15 18:36:54', 10);
INSERT INTO `historyuse` VALUES (3, '2020-02-15 18:37:00', 20);
INSERT INTO `historyuse` VALUES (3, '2020-02-15 18:37:07', 40);
INSERT INTO `historyuse` VALUES (3, '2020-02-15 18:37:15', 100);
INSERT INTO `historyuse` VALUES (1, '2020-02-16 19:13:50', 78);
INSERT INTO `historyuse` VALUES (1, '2020-02-17 12:35:51', 500);
INSERT INTO `historyuse` VALUES (1, '2020-02-17 12:35:57', 1000);
INSERT INTO `historyuse` VALUES (12, '2020-02-17 13:53:15', 5);

-- ----------------------------
-- Table structure for orderfood
-- ----------------------------
DROP TABLE IF EXISTS `orderfood`;
CREATE TABLE `orderfood`  (
  `ordernumber` int(11) NOT NULL,
  `provideraccount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `totalmoney` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0待审核，1审核成功，2已经发货，3入库成功',
  `ordertime` datetime(0) NULL,
  PRIMARY KEY (`ordernumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orderfood
-- ----------------------------
INSERT INTO `orderfood` VALUES (1, '11111111111', '40', '3', '2019-12-02 13:49:19');
INSERT INTO `orderfood` VALUES (2, '11111111111', '19000', '3', '2019-12-01 09:35:53');
INSERT INTO `orderfood` VALUES (3, '11111111111', '11000', '3', '2019-12-01 09:31:52');
INSERT INTO `orderfood` VALUES (4, '11111111111', '10000', '3', '2019-12-01 09:39:39');
INSERT INTO `orderfood` VALUES (5, '11111111111', '1500', '3', '2019-12-01 09:38:58');
INSERT INTO `orderfood` VALUES (6, '11111111111', '0', '4', '2019-12-01 09:39:01');
INSERT INTO `orderfood` VALUES (7, '11111111111', '14000', '3', '2019-12-05 10:13:23');
INSERT INTO `orderfood` VALUES (8, '11111111111', '14000', '3', '2019-12-02 13:49:16');
INSERT INTO `orderfood` VALUES (9, '11111111111', '0', '4', '2019-12-02 13:49:19');
INSERT INTO `orderfood` VALUES (10, '11111111111', '0', '4', '2019-12-05 08:31:32');
INSERT INTO `orderfood` VALUES (11, '11111111111', '0', '3', '2019-12-05 08:31:31');
INSERT INTO `orderfood` VALUES (12, '11111111111', '0', '4', '2019-12-05 08:31:30');
INSERT INTO `orderfood` VALUES (13, NULL, '0', '1', '2019-12-02 13:40:03');
INSERT INTO `orderfood` VALUES (14, '11111111111', '14000', '3', '2019-12-02 13:49:22');
INSERT INTO `orderfood` VALUES (15, '11111111111', '6500', '3', '2019-12-02 14:08:07');
INSERT INTO `orderfood` VALUES (16, '11111111111', '19500', '3', '2019-12-02 14:47:07');
INSERT INTO `orderfood` VALUES (17, '11111111111', '13000', '3', '2019-12-28 21:12:19');
INSERT INTO `orderfood` VALUES (18, '11111111111', '18500', '3', '2019-12-02 14:47:12');
INSERT INTO `orderfood` VALUES (19, '11111111111', '1500', '3', '2019-12-28 21:12:22');
INSERT INTO `orderfood` VALUES (20, '11111111111', '0', '3', '2019-12-05 08:31:29');
INSERT INTO `orderfood` VALUES (21, '11111111111', '46300', '2', '2019-12-28 21:12:24');
INSERT INTO `orderfood` VALUES (22, '11111111111', '0', '4', '2019-12-05 08:31:28');
INSERT INTO `orderfood` VALUES (23, '11111111111', '0', '4', '2019-12-05 08:31:28');
INSERT INTO `orderfood` VALUES (24, '11111111111', '0', '4', '2019-12-05 08:31:27');
INSERT INTO `orderfood` VALUES (25, '11111111111', '0', '4', '2019-12-05 08:31:25');
INSERT INTO `orderfood` VALUES (26, '11111111111', '30500', '3', '2019-12-28 21:12:26');
INSERT INTO `orderfood` VALUES (27, '11111111111', '42000', '3', '2019-12-28 21:12:47');
INSERT INTO `orderfood` VALUES (28, '11111111111', '4500', '3', '2019-12-28 21:12:48');
INSERT INTO `orderfood` VALUES (29, NULL, '0', '1', '2019-12-09 02:06:00');
INSERT INTO `orderfood` VALUES (30, NULL, '0', '1', '2019-12-09 02:08:56');
INSERT INTO `orderfood` VALUES (31, '99999999999', '7500', '3', '2020-02-17 13:58:12');
INSERT INTO `orderfood` VALUES (32, NULL, '0', '1', '2019-12-12 21:14:55');
INSERT INTO `orderfood` VALUES (33, NULL, '0', '1', '2019-12-13 13:10:10');
INSERT INTO `orderfood` VALUES (37, '99999999999', '262080', '2', '2020-02-17 13:58:17');
INSERT INTO `orderfood` VALUES (39, NULL, '0', '0', '2020-02-16 14:09:19');
INSERT INTO `orderfood` VALUES (42, NULL, '10750', '1', '2020-02-16 15:04:29');
INSERT INTO `orderfood` VALUES (43, '99999999999', '11700', '2', '2020-02-17 13:58:24');
INSERT INTO `orderfood` VALUES (44, NULL, '24500', '0', '2020-02-16 19:14:12');
INSERT INTO `orderfood` VALUES (45, NULL, '1320', '0', '2020-02-16 19:14:24');
INSERT INTO `orderfood` VALUES (46, '99999999999', '5850', '2', '2020-02-17 14:01:32');
INSERT INTO `orderfood` VALUES (47, NULL, '7800', '0', '2020-02-17 13:53:59');

-- ----------------------------
-- Table structure for providermsg
-- ----------------------------
DROP TABLE IF EXISTS `providermsg`;
CREATE TABLE `providermsg`  (
  `providernum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shopname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `connect` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shopmsg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `license` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0代认证，1认证成功',
  PRIMARY KEY (`providernum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of providermsg
-- ----------------------------
INSERT INTO `providermsg` VALUES ('11111111111', '江南大学', '18561751539', '846329490@qq.com', 'safadf', '370284199811202718', '1');
INSERT INTO `providermsg` VALUES ('12345678912', NULL, NULL, NULL, NULL, NULL, '0');
INSERT INTO `providermsg` VALUES ('1234567891298', NULL, NULL, NULL, NULL, NULL, '2');
INSERT INTO `providermsg` VALUES ('187521463269', NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `providermsg` VALUES ('8455@QQ.com', NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `providermsg` VALUES ('88888888888', NULL, NULL, NULL, NULL, NULL, '0');
INSERT INTO `providermsg` VALUES ('98765432198', NULL, NULL, NULL, NULL, NULL, '2');
INSERT INTO `providermsg` VALUES ('98765432199', NULL, NULL, NULL, NULL, NULL, '2');
INSERT INTO `providermsg` VALUES ('99999999999', 'jiangnan', '11111111111', '1561563@qq.com', 'XXXXXXXXX', '333333333330000000', '1');
INSERT INTO `providermsg` VALUES ('das', NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `providermsg` VALUES ('wang@125.com', NULL, NULL, NULL, NULL, NULL, '1');

-- ----------------------------
-- Table structure for receivedfood
-- ----------------------------
DROP TABLE IF EXISTS `receivedfood`;
CREATE TABLE `receivedfood`  (
  `ordernumber` int(11) NOT NULL COMMENT '订单号',
  `foodname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fooduid` int(11) NOT NULL AUTO_INCREMENT,
  `trueamount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `finishtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`fooduid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of receivedfood
-- ----------------------------
INSERT INTO `receivedfood` VALUES (5, '白菜', 1, '150', '2019-12-01 09:38:58');
INSERT INTO `receivedfood` VALUES (6, '猪肉', 2, '0', '2019-12-01 09:39:01');
INSERT INTO `receivedfood` VALUES (4, '白菜', 3, '200', '2019-12-01 09:39:39');
INSERT INTO `receivedfood` VALUES (4, '猪肉', 4, '100', '2019-12-01 09:39:39');
INSERT INTO `receivedfood` VALUES (8, '白菜', 5, '400', '2019-12-02 13:49:16');
INSERT INTO `receivedfood` VALUES (8, '猪肉', 6, '100', '2019-12-02 13:49:16');
INSERT INTO `receivedfood` VALUES (8, '白菜', 7, '100', '2019-12-02 13:49:16');
INSERT INTO `receivedfood` VALUES (8, '白菜', 8, '100', '2019-12-02 13:49:16');
INSERT INTO `receivedfood` VALUES (8, '猪肉', 9, '0', '2019-12-02 13:49:16');
INSERT INTO `receivedfood` VALUES (14, '鸡肉', 10, '250', '2019-12-02 13:49:22');
INSERT INTO `receivedfood` VALUES (14, '白菜', 11, '50', '2019-12-02 13:49:22');
INSERT INTO `receivedfood` VALUES (14, '白菜', 12, '100', '2019-12-02 13:49:22');
INSERT INTO `receivedfood` VALUES (15, '白菜', 13, '0', '2019-12-02 14:08:07');
INSERT INTO `receivedfood` VALUES (15, '白菜', 14, '150', '2019-12-02 14:08:07');
INSERT INTO `receivedfood` VALUES (15, '鸡肉', 15, '100', '2019-12-02 14:08:07');
INSERT INTO `receivedfood` VALUES (16, '生菜', 16, '100', '2019-12-02 14:47:07');
INSERT INTO `receivedfood` VALUES (16, '鸡肉', 17, '350', '2019-12-02 14:47:07');
INSERT INTO `receivedfood` VALUES (18, '生菜', 18, '150', '2019-12-02 14:47:12');
INSERT INTO `receivedfood` VALUES (18, '猪肉', 19, '100', '2019-12-02 14:47:12');
INSERT INTO `receivedfood` VALUES (18, '鸡肉', 20, '150', '2019-12-02 14:47:12');
INSERT INTO `receivedfood` VALUES (7, '白菜', 21, '200', '2019-12-05 10:13:23');
INSERT INTO `receivedfood` VALUES (7, '白菜', 22, '450', '2019-12-05 10:13:23');
INSERT INTO `receivedfood` VALUES (7, '猪肉', 23, '-100', '2019-12-05 10:13:23');
INSERT INTO `receivedfood` VALUES (7, '鸡肉', 24, '250', '2019-12-05 10:13:23');
INSERT INTO `receivedfood` VALUES (7, '白菜', 25, '300', '2019-12-05 10:13:23');
INSERT INTO `receivedfood` VALUES (17, '鸡肉', 26, '100', '2019-12-28 21:12:19');
INSERT INTO `receivedfood` VALUES (17, '猪肉', 27, '100', '2019-12-28 21:12:19');
INSERT INTO `receivedfood` VALUES (19, '猪肉', 28, '0', '2019-12-28 21:12:22');
INSERT INTO `receivedfood` VALUES (19, '猪肉', 29, '0', '2019-12-28 21:12:22');
INSERT INTO `receivedfood` VALUES (19, '白菜', 30, '150', '2019-12-28 21:12:22');
INSERT INTO `receivedfood` VALUES (21, '鱼', 31, '300', '2019-12-28 21:12:24');
INSERT INTO `receivedfood` VALUES (21, '韭菜', 32, '300', '2019-12-28 21:12:24');
INSERT INTO `receivedfood` VALUES (21, '白菜', 33, '250', '2019-12-28 21:12:24');
INSERT INTO `receivedfood` VALUES (21, '猪肉', 34, '200', '2019-12-28 21:12:24');
INSERT INTO `receivedfood` VALUES (21, '鸡肉', 35, '200', '2019-12-28 21:12:24');
INSERT INTO `receivedfood` VALUES (21, '花菜', 36, '200', '2019-12-28 21:12:24');
INSERT INTO `receivedfood` VALUES (21, '猪肉', 37, '0', '2019-12-28 21:12:24');
INSERT INTO `receivedfood` VALUES (21, '白菜', 38, '200', '2019-12-28 21:12:24');
INSERT INTO `receivedfood` VALUES (21, '生菜', 39, '200', '2019-12-28 21:12:24');
INSERT INTO `receivedfood` VALUES (26, '白菜', 40, '150', '2019-12-28 21:12:26');
INSERT INTO `receivedfood` VALUES (26, '生菜', 41, '150', '2019-12-28 21:12:26');
INSERT INTO `receivedfood` VALUES (26, '猪肉', 42, '150', '2019-12-28 21:12:26');
INSERT INTO `receivedfood` VALUES (26, '鸡肉', 43, '200', '2019-12-28 21:12:26');
INSERT INTO `receivedfood` VALUES (26, '生菜', 44, '200', '2019-12-28 21:12:26');
INSERT INTO `receivedfood` VALUES (27, '猪肉', 45, '200', '2019-12-28 21:12:47');
INSERT INTO `receivedfood` VALUES (27, '鸡肉', 46, '0', '2019-12-28 21:12:47');
INSERT INTO `receivedfood` VALUES (27, '生菜', 47, '300', '2019-12-28 21:12:47');
INSERT INTO `receivedfood` VALUES (27, '猪肉', 48, '250', '2019-12-28 21:12:47');
INSERT INTO `receivedfood` VALUES (28, '白菜', 49, '350', '2019-12-28 21:12:48');
INSERT INTO `receivedfood` VALUES (28, '白菜', 50, '100', '2019-12-28 21:12:48');
INSERT INTO `receivedfood` VALUES (31, '鸡肉', 51, '150', '2020-02-17 13:58:12');
INSERT INTO `receivedfood` VALUES (37, '鸡肉', 52, '450', '2020-02-17 13:58:17');
INSERT INTO `receivedfood` VALUES (37, '鱼', 53, '800', '2020-02-17 13:58:17');
INSERT INTO `receivedfood` VALUES (37, '花菜', 54, '100', '2020-02-17 13:58:17');
INSERT INTO `receivedfood` VALUES (37, '猪肉', 55, '2508', '2020-02-17 13:58:17');
INSERT INTO `receivedfood` VALUES (37, '生菜', 56, '150', '2020-02-17 13:58:17');
INSERT INTO `receivedfood` VALUES (37, '白菜', 57, '100', '2020-02-17 13:58:17');
INSERT INTO `receivedfood` VALUES (37, '生菜', 58, '522', '2020-02-17 13:58:17');
INSERT INTO `receivedfood` VALUES (43, '鱼', 59, '300', '2020-02-17 13:58:24');
INSERT INTO `receivedfood` VALUES (43, '韭菜', 60, '200', '2020-02-17 13:58:24');
INSERT INTO `receivedfood` VALUES (43, '鱼', 61, '50', '2020-02-17 13:58:24');
INSERT INTO `receivedfood` VALUES (46, '花菜', 62, '50', '2020-02-17 13:58:36');
INSERT INTO `receivedfood` VALUES (46, '韭菜', 63, '100', '2020-02-17 13:58:36');
INSERT INTO `receivedfood` VALUES (46, '鸡肉', 64, '100', '2020-02-17 13:58:36');
INSERT INTO `receivedfood` VALUES (46, '花菜', 65, '50', '2020-02-17 14:01:32');
INSERT INTO `receivedfood` VALUES (46, '韭菜', 66, '100', '2020-02-17 14:01:32');
INSERT INTO `receivedfood` VALUES (46, '鸡肉', 67, '100', '2020-02-17 14:01:32');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0总管理，1库房，2采购',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (10, '11111111111', 'admin', '123456', '3');
INSERT INTO `user` VALUES (15, '12358463247', 'ii', '458123', '3');
INSERT INTO `user` VALUES (17, '123456', '666', '123456', '1');
INSERT INTO `user` VALUES (24, '15964812561', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '0');
INSERT INTO `user` VALUES (26, '33333333333', 'admin2', 'e10adc3949ba59abbe56e057f20f883e', '1');
INSERT INTO `user` VALUES (27, '33333333334', 'admin3', 'e10adc3949ba59abbe56e057f20f883e', '2');
INSERT INTO `user` VALUES (28, '12345612345', 'admin5', 'e10adc3949ba59abbe56e057f20f883e', '0');
INSERT INTO `user` VALUES (29, '18561751539', 'ad', 'e10adc3949ba59abbe56e057f20f883e', '0');
INSERT INTO `user` VALUES (34, '12378965412', 'admin7', 'e10adc3949ba59abbe56e057f20f883e', '1');
INSERT INTO `user` VALUES (35, '99999999999', '99999999999', 'e10adc3949ba59abbe56e057f20f883e', '3');
INSERT INTO `user` VALUES (36, '88888888888', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '3');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` int(11) NOT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `identity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
