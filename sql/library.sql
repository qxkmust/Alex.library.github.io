/*
 Navicat MySQL Data Transfer

 Source Server         : 120.77.169.130
 Source Server Type    : MySQL
 Source Server Version : 50646
 Source Host           : 120.77.169.130:33306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 50646
 File Encoding         : 65001

 Date: 20/11/2019 11:29:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for LIB_BOOK
-- ----------------------------
DROP TABLE IF EXISTS `LIB_BOOK`;
CREATE TABLE `LIB_BOOK`  (
  `S_BOOK_ID` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '书籍序号，唯一标识',
  `S_BOOK_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '书名',
  `S_BOOK_AUTHOR` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '作者',
  `S_BOOK_PUB` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '出版社',
  `I_BOOK_NUM` int(11) NOT NULL DEFAULT 1 COMMENT '是否在书架上 0-否 1-是',
  `S_BOOK_SORT` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '书籍分类',
  `S_BOOK_RECORD` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '登记时间',
  PRIMARY KEY (`S_BOOK_ID`) USING BTREE,
  INDEX `INDEX_BOOK_ID`(`S_BOOK_ID`) USING BTREE,
  INDEX `INDEX_BOOK_NAME`(`S_BOOK_NAME`(191)) USING BTREE,
  INDEX `INDEX_BOOK_RECORD`(`S_BOOK_SORT`(191)) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of LIB_BOOK
-- ----------------------------
INSERT INTO `LIB_BOOK` VALUES ('2019101001', '西游记', '吴承恩', '新华出版社', 1, 'BK_SORT_01', '2019-11-19 14:59:33');
INSERT INTO `LIB_BOOK` VALUES ('2019101002', '水浒传', '施耐庵', '新华出版社', 0, 'BK_SORT_01', '2019-11-09 21:38:45');
INSERT INTO `LIB_BOOK` VALUES ('2019101003', '三国演义', '罗贯中', '新华出版社', 0, 'BK_SORT_01', '2019-11-10 05:54:18');
INSERT INTO `LIB_BOOK` VALUES ('2019101004', '红楼梦', '曹雪芹', '新华出版社', 1, 'BK_SORT_01', '2019-11-09 21:13:43');
INSERT INTO `LIB_BOOK` VALUES ('2019101005', '封神演义', '陈忠琳', '新华出版社', 1, 'BK_SORT_01', '2019-11-09 21:13:40');
INSERT INTO `LIB_BOOK` VALUES ('2019101006', '简爱', '夏洛蒂-勃朗特', '清华出版社', 1, 'BK_SORT_02', '2019-11-17 03:37:38');
INSERT INTO `LIB_BOOK` VALUES ('2019101007', '神曲', '但丁', '北大出版社', 1, 'BK_SORT_02', '2019-11-17 03:37:41');
INSERT INTO `LIB_BOOK` VALUES ('2019101008', '雪国', '川端康成', '新华出版社', 1, 'BK_SORT_04', '2019-11-09 21:13:47');
INSERT INTO `LIB_BOOK` VALUES ('2019101009', '边城', '沈从文', '新华出版社', 0, 'BK_SORT_03', '2019-11-17 03:37:46');
INSERT INTO `LIB_BOOK` VALUES ('2019101010', '儒林外史', '吴敬梓', '新华出版社', 1, 'BK_SORT_01', '2019-11-09 21:14:36');

-- ----------------------------
-- Table structure for LIB_BOOK_SORT
-- ----------------------------
DROP TABLE IF EXISTS `LIB_BOOK_SORT`;
CREATE TABLE `LIB_BOOK_SORT`  (
  `S_SORT_ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '分类编号',
  `S_SORT_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`S_SORT_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of LIB_BOOK_SORT
-- ----------------------------
INSERT INTO `LIB_BOOK_SORT` VALUES ('BK_SORT_01', '中国古典文学');
INSERT INTO `LIB_BOOK_SORT` VALUES ('BK_SORT_02', '西方古典文学');
INSERT INTO `LIB_BOOK_SORT` VALUES ('BK_SORT_03', '中国现代文学');
INSERT INTO `LIB_BOOK_SORT` VALUES ('BK_SORT_04', '日本古典文学');

-- ----------------------------
-- Table structure for LIB_BORROW
-- ----------------------------
DROP TABLE IF EXISTS `LIB_BORROW`;
CREATE TABLE `LIB_BORROW`  (
  `S_STU_ID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学生编号',
  `S_BOOK_ID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '书籍编号',
  `S_BORROW_DATE` timestamp(0) NULL DEFAULT NULL COMMENT '借书时间',
  `S_EXPECT_RETURN_DATE` timestamp(0) NULL DEFAULT NULL COMMENT '预期归还时间',
  PRIMARY KEY (`S_STU_ID`, `S_BOOK_ID`) USING BTREE,
  INDEX `INDEX_BORROW`(`S_STU_ID`, `S_BOOK_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of LIB_BORROW
-- ----------------------------
INSERT INTO `LIB_BORROW` VALUES ('2019704101', '2019101002', '2019-11-01 14:29:35', '2019-11-09 14:29:35');
INSERT INTO `LIB_BORROW` VALUES ('2019704101', '2019101003', '2019-10-29 22:06:58', '2019-11-12 22:06:58');
INSERT INTO `LIB_BORROW` VALUES ('2019704104', '2019101009', '2019-11-10 22:07:17', '2019-11-17 22:07:17');

-- ----------------------------
-- Table structure for LIB_BORROW_HIS
-- ----------------------------
DROP TABLE IF EXISTS `LIB_BORROW_HIS`;
CREATE TABLE `LIB_BORROW_HIS`  (
  `S_STU_ID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学生编号',
  `S_BOOK_ID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '书籍编号',
  `S_BORROW_DATE` datetime(0) NULL DEFAULT NULL COMMENT '借书时间',
  `S_RETURN_DATE` datetime(0) NULL DEFAULT NULL COMMENT '预期归还时间',
  PRIMARY KEY (`S_STU_ID`, `S_BOOK_ID`) USING BTREE,
  INDEX `INDEX_BORROW`(`S_STU_ID`, `S_BOOK_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of LIB_BORROW_HIS
-- ----------------------------
INSERT INTO `LIB_BORROW_HIS` VALUES ('2019704101', '2019101002', '2019-10-17 17:17:02', '2019-11-01 17:17:09');
INSERT INTO `LIB_BORROW_HIS` VALUES ('2019704101', '2019101003', '2019-10-17 17:17:02', '2019-11-01 17:17:09');
INSERT INTO `LIB_BORROW_HIS` VALUES ('2019704101', '2019101005', '2019-10-17 17:17:02', '2019-10-25 17:17:09');
INSERT INTO `LIB_BORROW_HIS` VALUES ('2019704103', '2019101004', '2019-10-17 17:17:02', '2019-11-01 17:17:09');
INSERT INTO `LIB_BORROW_HIS` VALUES ('2019704103', '2019101006', '2019-11-02 12:01:10', '2019-11-10 12:01:10');

-- ----------------------------
-- Table structure for LIB_LOG
-- ----------------------------
DROP TABLE IF EXISTS `LIB_LOG`;
CREATE TABLE `LIB_LOG`  (
  `I_LOG_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `S_USERNAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `S_IP` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户IP',
  `S_LOG_DETAIL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '日志详情',
  `S_LOG_TIME` timestamp(0) NULL DEFAULT NULL COMMENT '开始时刻',
  `I_TIMESPAN` int(255) NULL DEFAULT NULL COMMENT '操作用时，单位ms',
  PRIMARY KEY (`I_LOG_ID`) USING BTREE,
  INDEX `INDEX_LOG_ID`(`I_LOG_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for LIB_MANAGER
-- ----------------------------
DROP TABLE IF EXISTS `LIB_MANAGER`;
CREATE TABLE `LIB_MANAGER`  (
  `S_MANAGER_ID` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '管理员编号，唯一标识',
  `S_MANAGER_PWD` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '管理员密码',
  `S_MANAGER_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '姓名',
  `I_MANAGER_AGE` int(11) NOT NULL COMMENT '年龄',
  `S_MANAGER_PHONE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '电话',
  PRIMARY KEY (`S_MANAGER_ID`) USING BTREE,
  INDEX `INDEX_MANAGER_ID`(`S_MANAGER_ID`) USING BTREE,
  INDEX `INDEX_MANAGER_NAME`(`S_MANAGER_NAME`(191)) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of LIB_MANAGER
-- ----------------------------
INSERT INTO `LIB_MANAGER` VALUES ('2009001001', '1', '郭沫若', 30, '');
INSERT INTO `LIB_MANAGER` VALUES ('2009001002', '1', '梁思成', 32, '');
INSERT INTO `LIB_MANAGER` VALUES ('2009001003', '1', '鲁迅', 35, '');

-- ----------------------------
-- Table structure for LIB_RETURN
-- ----------------------------
DROP TABLE IF EXISTS `LIB_RETURN`;
CREATE TABLE `LIB_RETURN`  (
  `S_STU_ID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学生学号',
  `S_BOOK_ID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '书籍编号',
  `S_BORROW_DATE` datetime(0) NULL DEFAULT NULL COMMENT '借书时间',
  `S_RETURN_DATE` datetime(0) NULL DEFAULT NULL COMMENT '实际还书时间',
  PRIMARY KEY (`S_STU_ID`, `S_BOOK_ID`) USING BTREE,
  INDEX `INDEX_RETURN`(`S_STU_ID`, `S_BOOK_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for LIB_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `LIB_ROLE`;
CREATE TABLE `LIB_ROLE`  (
  `I_ROLE` int(2) NOT NULL COMMENT '角色唯一标识',
  `S_ROLE_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名',
  PRIMARY KEY (`I_ROLE`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of LIB_ROLE
-- ----------------------------
INSERT INTO `LIB_ROLE` VALUES (1, 'Student');
INSERT INTO `LIB_ROLE` VALUES (2, 'Teacher');
INSERT INTO `LIB_ROLE` VALUES (3, 'Administrator');

-- ----------------------------
-- Table structure for LIB_STUDENT
-- ----------------------------
DROP TABLE IF EXISTS `LIB_STUDENT`;
CREATE TABLE `LIB_STUDENT`  (
  `S_STU_ID` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学号，唯一标识',
  `S_STU_PWD` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '登录密码',
  `S_STU_NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `S_STU_SEX` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '性别',
  `I_STU_AGE` int(11) NOT NULL COMMENT '年龄',
  `S_STU_MAJOR` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '专业',
  `S_STU_GRADE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '年级',
  `I_STU_INTEGRITY` int(11) NOT NULL DEFAULT 1 COMMENT '诚信级别,0- 差 1-优',
  PRIMARY KEY (`S_STU_ID`) USING BTREE,
  INDEX `INDEX_STUDENT_ID`(`S_STU_ID`) USING BTREE,
  INDEX `INDEX_STUDENT_NAME`(`S_STU_NAME`(191)) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of LIB_STUDENT
-- ----------------------------
INSERT INTO `LIB_STUDENT` VALUES ('2019704101', '1', '杉菜', '女', 20, '舞蹈专业', '一年级', 0);
INSERT INTO `LIB_STUDENT` VALUES ('2019704102', '1', '道明寺', '男', 22, '体育专业', '二年级', 1);
INSERT INTO `LIB_STUDENT` VALUES ('2019704103', '1', '花泽类', '男', 21, '美术专业', '一年级', 1);
INSERT INTO `LIB_STUDENT` VALUES ('2019704104', '1', '美作玲', '男', 21, '武术专业', '二年级', 0);
INSERT INTO `LIB_STUDENT` VALUES ('2019704105', '1', '阿香', '女', 20, '美术专业', '一年级', 1);
INSERT INTO `LIB_STUDENT` VALUES ('2019704106', '1', '小优', '女', 20, '体操专业', '一年级', 1);

-- ----------------------------
-- Table structure for LIB_TICKET
-- ----------------------------
DROP TABLE IF EXISTS `LIB_TICKET`;
CREATE TABLE `LIB_TICKET`  (
  `S_STU_ID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学生学号',
  `S_BOOK_ID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '书籍编号',
  `I_OVER_DAY` int(11) NULL DEFAULT NULL COMMENT '逾期天数',
  `F_TICKET_FEE` float NULL DEFAULT NULL COMMENT '处罚金额',
  `I_PAYOFF` int(1) NULL DEFAULT 1 COMMENT '是否支付，0-已支付 1-未支付',
  PRIMARY KEY (`S_STU_ID`, `S_BOOK_ID`) USING BTREE,
  INDEX `INDEX_TICKET`(`S_STU_ID`, `S_BOOK_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of LIB_TICKET
-- ----------------------------
INSERT INTO `LIB_TICKET` VALUES ('2019704101', '2019101002', 8, 0.8, 1);
INSERT INTO `LIB_TICKET` VALUES ('2019704101', '2019101003', 14, 1.4, 1);
INSERT INTO `LIB_TICKET` VALUES ('2019704104', '2019101009', 7, 0.7, 1);

-- ----------------------------
-- Table structure for LIB_USER_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `LIB_USER_ROLE`;
CREATE TABLE `LIB_USER_ROLE`  (
  `S_USER_ID` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  `I_ROLE_ID` int(2) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`S_USER_ID`, `I_ROLE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Function structure for FUNC_GET_BOOK_NUM
-- ----------------------------
DROP FUNCTION IF EXISTS `FUNC_GET_BOOK_NUM`;
delimiter ;;
CREATE FUNCTION `FUNC_GET_BOOK_NUM`(`BOOK_ID` VARCHAR(11))
 RETURNS int(11)
BEGIN
	RETURN(SELECT I_BOOK_NUM FROM LIB_BOOK WHERE S_BOOK_ID = BOOK_ID);
END
;;
delimiter ;

-- ----------------------------
-- Function structure for FUNC_GET_CREDIT
-- ----------------------------
DROP FUNCTION IF EXISTS `FUNC_GET_CREDIT`;
delimiter ;;
CREATE FUNCTION `FUNC_GET_CREDIT`(`STU_ID` VARCHAR(11))
 RETURNS int(11)
BEGIN
	RETURN(SELECT I_STU_INTEGRITY FROM LIB_STUDENT WHERE S_STU_ID = STU_ID);
END
;;
delimiter ;

-- ----------------------------
-- Function structure for FUNC_GET_OVERDUE_NUM
-- ----------------------------
DROP FUNCTION IF EXISTS `FUNC_GET_OVERDUE_NUM`;
delimiter ;;
CREATE FUNCTION `FUNC_GET_OVERDUE_NUM`(`sStuId` varchar(11))
 RETURNS int(11)
BEGIN
	RETURN(SELECT COUNT(*) FROM LIB_TICKET WHERE S_STU_ID = sStuId AND I_PAYOFF = 1);
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for PROC_BORROW
-- ----------------------------
DROP PROCEDURE IF EXISTS `PROC_BORROW`;
delimiter ;;
CREATE PROCEDURE `PROC_BORROW`(IN stu_id VARCHAR(11),IN book_id VARCHAR(11),IN borrow_date DATETIME,IN expect_return_date DATETIME)
BEGIN
	IF FUNC_GET_CREDIT(STU_ID) = 1 AND FUNC_GET_BOOK_NUM(BOOK_ID) = 1
	THEN
		INSERT INTO LIB_BORROW VALUES(stu_id,book_id,borrow_date,expect_return_date);
	ELSE
	  SELECT 'failed to borrow';
	END IF;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for PROC_INSERT_TICKET
-- ----------------------------
DROP PROCEDURE IF EXISTS `PROC_INSERT_TICKET`;
delimiter ;;
CREATE PROCEDURE `PROC_INSERT_TICKET`()
BEGIN
	REPLACE INTO LIB_TICKET(S_STU_ID,S_BOOK_ID,I_OVER_DAY,F_TICKET_FEE)
	SELECT S_STU_ID,S_BOOK_ID,TIMESTAMPDIFF(DAY,S_BORROW_DATE,S_EXPECT_RETURN_DATE),TIMESTAMPDIFF(DAY,S_BORROW_DATE,S_EXPECT_RETURN_DATE) * 0.1 FROM LIB_BORROW;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for PROC_RESET_STU_INTEGRITY
-- ----------------------------
DROP PROCEDURE IF EXISTS `PROC_RESET_STU_INTEGRITY`;
delimiter ;;
CREATE PROCEDURE `PROC_RESET_STU_INTEGRITY`(IN `sStuId` varchar(11))
BEGIN
	IF FUNC_GET_BOOK_NUM(sStuId) = 0
	THEN 
		UPDATE LIB_STUDENT SET I_STU_INTEGRITY = 1;
	END IF;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for PROC_RETURN
-- ----------------------------
DROP PROCEDURE IF EXISTS `PROC_RETURN`;
delimiter ;;
CREATE PROCEDURE `PROC_RETURN`(IN stu_id VARCHAR(11), IN book_id VARCHAR(11), IN return_date datetime)
BEGIN
	DECLARE borrow_date DATETIME;
	IF (SELECT I_PAYOFF FROM LIB_TICKET WHERE S_STU_ID = stu_id AND S_BOOK_ID = book_id) = 1
	THEN 
		SELECT 'please pay off the fee';
		
	ELSE
		SET borrow_date = (SELECT S_BORROW_DATE FROM LIB_BORROW WHERE S_STU_ID = stu_id AND S_BOOK_ID = book_id);
		INSERT INTO LIB_RETURN VALUES(stu_id,book_id,borrow_date,return_date);
		DELETE FROM LIB_BORROW WHERE S_STU_ID = stu_id AND S_BOOK_ID = book_id;
	END IF;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for PROC_TICKET
-- ----------------------------
DROP PROCEDURE IF EXISTS `PROC_TICKET`;
delimiter ;;
CREATE PROCEDURE `PROC_TICKET`()
BEGIN
  REPLACE INTO LIB_TICKET(S_STU_ID,S_BOOK_ID,I_OVER_DAY,F_TICKET_FEE)
	SELECT S_STU_ID,S_BOOK_ID,DATEDIFF(now(),S_EXPECT_RETURN_DATE), 0.1*DATEDIFF(now(),S_EXPECT_RETURN_DATE) FROM LIB_BORROW WHERE now() > S_EXPECT_RETURN_DATE;
END
;;
delimiter ;

-- ----------------------------
-- Event structure for EVENT_BORROW
-- ----------------------------
DROP EVENT IF EXISTS `EVENT_BORROW`;
delimiter ;;
CREATE EVENT `EVENT_BORROW`
ON SCHEDULE
EVERY '1' DAY STARTS '2019-10-30 10:54:31'
ON COMPLETION PRESERVE
DO CALL PROC_INSERT_TICKET()
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table LIB_BORROW
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_INSERT_BORROW`;
delimiter ;;
CREATE TRIGGER `TRIGGER_INSERT_BORROW` AFTER INSERT ON `LIB_BORROW` FOR EACH ROW UPDATE LIB_BOOK SET I_BOOK_NUM = 0 WHERE S_BOOK_ID = NEW.S_BOOK_ID
;
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table LIB_LOG
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_INSERT`;
delimiter ;;
CREATE TRIGGER `TRIGGER_INSERT` AFTER INSERT ON `LIB_LOG` FOR EACH ROW UPDATE LIB_LOG SET new.S_LOG_TIME = now()
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table LIB_RETURN
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_INSERT_RETURN`;
delimiter ;;
CREATE TRIGGER `TRIGGER_INSERT_RETURN` AFTER INSERT ON `LIB_RETURN` FOR EACH ROW UPDATE LIB_BOOK SET I_BOOK_NUM = 1 WHERE S_BOOK_ID = new.S_BOOK_ID
;
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table LIB_TICKET
-- ----------------------------
DROP TRIGGER IF EXISTS `TRIGGER_INSERT_TICKET`;
delimiter ;;
CREATE TRIGGER `TRIGGER_INSERT_TICKET` AFTER INSERT ON `LIB_TICKET` FOR EACH ROW IF(SELECT COUNT(*) FROM LIB_TICKET WHERE S_STU_ID = new.S_STU_ID) > 1
THEN UPDATE LIB_STUDENT SET I_STU_INTEGRITY = 0 WHERE S_STU_ID = new.S_STU_ID;
END IF
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
