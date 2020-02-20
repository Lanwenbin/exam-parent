/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : exam

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 20/02/2020 14:20:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pid` int(11) NOT NULL,
  `uri` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '试卷模块', 'true', 0, '/admin/testPaper.html');
INSERT INTO `menu` VALUES ('101', '试卷管理', 'false', 1, '/admin/testPaper.html');
INSERT INTO `menu` VALUES ('2', '题库模块', 'true', 0, '#');
INSERT INTO `menu` VALUES ('201', '判断题管理', 'false', 2, '/admin/judge-bank.html');
INSERT INTO `menu` VALUES ('202', '选择题管理', 'false', 2, '/admin/question-bank.html');
INSERT INTO `menu` VALUES ('3', '成绩模块', 'true', 0, '#');
INSERT INTO `menu` VALUES ('301', '考试记录', 'false', 3, '/admin/score.html');
INSERT INTO `menu` VALUES ('302', '补考记录', 'false', 3, '/admin/score.html');
INSERT INTO `menu` VALUES ('4', '用户模块', 'true', 0, '#');
INSERT INTO `menu` VALUES ('401', '用户管理', 'false', 4, '/admin/user.html');
INSERT INTO `menu` VALUES ('402', '角色管理', 'false', 4, '/admin/role.html');
INSERT INTO `menu` VALUES ('403', '考生管理', 'false', 4, '/admin/student.html');

-- ----------------------------
-- Table structure for options
-- ----------------------------
DROP TABLE IF EXISTS `options`;
CREATE TABLE `options`  (
  `options_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `op` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '选项',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '选项内容',
  `question_bank_id` int(11) NOT NULL,
  PRIMARY KEY (`options_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 467 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of options
-- ----------------------------
INSERT INTO `options` VALUES (375, 'A', 'Web应用的根目录下', 159);
INSERT INTO `options` VALUES (376, 'B', 'pictures目录下', 159);
INSERT INTO `options` VALUES (377, 'C', '在Web应用根目录下新建一个目录', 159);
INSERT INTO `options` VALUES (378, 'D', 'WEB-INF目录下 ', 159);
INSERT INTO `options` VALUES (379, 'A', '表示层', 160);
INSERT INTO `options` VALUES (380, 'B', '控制器', 160);
INSERT INTO `options` VALUES (381, 'C', '视图', 160);
INSERT INTO `options` VALUES (382, 'D', '模型', 160);
INSERT INTO `options` VALUES (383, 'A', 'Servlet ', 161);
INSERT INTO `options` VALUES (384, 'B', '业务类', 161);
INSERT INTO `options` VALUES (385, 'C', 'HTML', 161);
INSERT INTO `options` VALUES (386, 'D', 'JSP', 161);
INSERT INTO `options` VALUES (387, 'A', '标签选择器 ', 162);
INSERT INTO `options` VALUES (388, 'B', '类选择器', 162);
INSERT INTO `options` VALUES (389, 'C', 'ID选择器 ', 162);
INSERT INTO `options` VALUES (390, 'D', '自定义选择器', 162);
INSERT INTO `options` VALUES (391, 'A', '$(\"a\") ', 163);
INSERT INTO `options` VALUES (392, 'B', '$(\"#a\")', 163);
INSERT INTO `options` VALUES (393, 'C', '$(\".a\")', 163);
INSERT INTO `options` VALUES (394, 'D', '$(\"link\")', 163);
INSERT INTO `options` VALUES (395, 'A', '<import>', 164);
INSERT INTO `options` VALUES (396, 'B', '<embed>', 164);
INSERT INTO `options` VALUES (397, 'C', '<link>', 164);
INSERT INTO `options` VALUES (398, 'D', '<script>', 164);
INSERT INTO `options` VALUES (399, 'A', 'getElementById()', 165);
INSERT INTO `options` VALUES (400, 'B', 'getElementsByName()', 165);
INSERT INTO `options` VALUES (401, 'C', 'getElementByName()', 165);
INSERT INTO `options` VALUES (402, 'D', 'getElmentsByTagName()', 165);
INSERT INTO `options` VALUES (403, 'A', '百度', 168);
INSERT INTO `options` VALUES (404, 'B', '腾讯', 168);
INSERT INTO `options` VALUES (405, 'C', '阿里巴巴', 168);
INSERT INTO `options` VALUES (406, 'D', '奇虎', 168);
INSERT INTO `options` VALUES (407, 'A', '饮酒后驾驶机动车', 178);
INSERT INTO `options` VALUES (408, 'B', '超过规定时速10%', 178);
INSERT INTO `options` VALUES (409, 'C', '疲劳后驾驶机动车', 178);
INSERT INTO `options` VALUES (410, 'D', '行车中未系安全带', 178);
INSERT INTO `options` VALUES (411, 'A', '保护好现场再协商', 180);
INSERT INTO `options` VALUES (412, 'B', '不要移动车辆', 180);
INSERT INTO `options` VALUES (413, 'C', '疏导其他车辆绕行', 180);
INSERT INTO `options` VALUES (414, 'D', '撤离现场自行协商', 180);
INSERT INTO `options` VALUES (415, 'A', '大型货车', 185);
INSERT INTO `options` VALUES (416, 'B', '大型客车', 185);
INSERT INTO `options` VALUES (417, 'C', '中型客车', 185);
INSERT INTO `options` VALUES (418, 'D', '', 185);
INSERT INTO `options` VALUES (419, 'A', '警告', 187);
INSERT INTO `options` VALUES (420, 'B', '罚款', 187);
INSERT INTO `options` VALUES (421, 'C', '拘留', 187);
INSERT INTO `options` VALUES (422, 'D', '吊销驾驶证', 187);
INSERT INTO `options` VALUES (423, 'A', '交叉路口', 190);
INSERT INTO `options` VALUES (424, 'B', '窄路窄桥', 190);
INSERT INTO `options` VALUES (425, 'C', '路宽车少', 190);
INSERT INTO `options` VALUES (426, 'D', '弯道陡坡', 190);
INSERT INTO `options` VALUES (427, 'A', '便于观察，有利于安全', 192);
INSERT INTO `options` VALUES (428, 'B', '右侧为快速车道', 192);
INSERT INTO `options` VALUES (429, 'C', '左侧为慢速车道', 192);
INSERT INTO `options` VALUES (430, 'D', '我国实行左侧通行原则', 192);
INSERT INTO `options` VALUES (431, 'A', '可以熄火', 194);
INSERT INTO `options` VALUES (432, 'B', '可以空挡但不准熄火', 194);
INSERT INTO `options` VALUES (433, 'C', '可以空挡', 194);
INSERT INTO `options` VALUES (434, 'D', '不准空挡或熄火', 194);
INSERT INTO `options` VALUES (435, 'A', '为减少交会时间，加速通过', 195);
INSERT INTO `options` VALUES (436, 'B', '立即停车，上前查看是否有被困人员', 195);
INSERT INTO `options` VALUES (437, 'C', '停车后围观', 195);
INSERT INTO `options` VALUES (438, 'D', '立即停车，尽量远离，拨打报警电话', 195);
INSERT INTO `options` VALUES (439, 'A', '下坡车让上坡车', 197);
INSERT INTO `options` VALUES (440, 'B', '坡顶交会时距离坡顶远的一方让行', 197);
INSERT INTO `options` VALUES (441, 'C', '上坡车让下坡车', 197);
INSERT INTO `options` VALUES (442, 'D', '下坡车已行至中途而上坡车未上坡时，让上坡车', 197);
INSERT INTO `options` VALUES (443, 'A', '雪泥可以增加轮胎的附着力', 198);
INSERT INTO `options` VALUES (444, 'B', '雪泥可以增加轮胎的附着力', 198);
INSERT INTO `options` VALUES (445, 'C', '泥雪下的路面更容易打滑', 198);
INSERT INTO `options` VALUES (446, 'D', '遇紧急情况制动距离长', 198);
INSERT INTO `options` VALUES (447, 'A', '服务区', 201);
INSERT INTO `options` VALUES (448, 'B', '加速车道', 201);
INSERT INTO `options` VALUES (449, 'C', '减速车道', 201);
INSERT INTO `options` VALUES (450, 'D', '匝道', 201);
INSERT INTO `options` VALUES (451, 'A', '最左侧', 202);
INSERT INTO `options` VALUES (452, 'B', '中间', 202);
INSERT INTO `options` VALUES (453, 'C', '最右侧', 202);
INSERT INTO `options` VALUES (454, 'D', '任意', 202);
INSERT INTO `options` VALUES (459, 'A', '先避车后避物', 204);
INSERT INTO `options` VALUES (460, 'B', '先避人后避物', 204);
INSERT INTO `options` VALUES (461, 'C', '先避车后避人', 204);
INSERT INTO `options` VALUES (462, 'D', '先避物后避人', 204);
INSERT INTO `options` VALUES (463, 'A', '可以超车', 203);
INSERT INTO `options` VALUES (464, 'B', '可以倒车', 203);
INSERT INTO `options` VALUES (465, 'C', '依次通行', 203);
INSERT INTO `options` VALUES (466, 'D', '可以掉头', 203);

-- ----------------------------
-- Table structure for question_bank
-- ----------------------------
DROP TABLE IF EXISTS `question_bank`;
CREATE TABLE `question_bank`  (
  `question_bank_id` int(11) NOT NULL AUTO_INCREMENT,
  `stem` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '题目',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '正确答案',
  `tests_type` int(5) NULL DEFAULT NULL COMMENT '题目类型（判断 0或者选择 1）',
  `state` int(5) NULL DEFAULT NULL COMMENT '状态 0 删除 1有效',
  PRIMARY KEY (`question_bank_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 205 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_bank
-- ----------------------------
INSERT INTO `question_bank` VALUES (158, 'JSP页面经过编译之后，将创建一个（）。', 'C', 1, 1);
INSERT INTO `question_bank` VALUES (159, '在JAVAEE服务器中部署了一个Web应用，为了防止客户看到某些资源，应该把这些资源放置到（ ）目录下。', 'D', 1, 1);
INSERT INTO `question_bank` VALUES (160, '以下不属于MVC设计模式中3个模块的是（）', 'A', 1, 1);
INSERT INTO `question_bank` VALUES (161, '在MVC设计模式中，（）接收用户请求。', 'D', 1, 1);
INSERT INTO `question_bank` VALUES (162, '下列选择器中，不属于jQuery基本选择器的是（）', 'D', 1, 1);
INSERT INTO `question_bank` VALUES (163, '如何通过jQuery选择器获得页面中所有的超链接（ ）。', 'A', 1, 1);
INSERT INTO `question_bank` VALUES (164, '将JavaScript脚本文件导入到HTML页面所对应的标记是_______。', 'D', 1, 1);
INSERT INTO `question_bank` VALUES (165, '想要获得页面中多个名字相同的表单元素，则可以使用document对象的哪个方法_______。', 'B', 1, 1);
INSERT INTO `question_bank` VALUES (166, '表单验证的可以提高客户端程序运行效率。', '1', 0, 1);
INSERT INTO `question_bank` VALUES (167, '通过下拉框对象的 length 属性可以获得下拉框选项的数量', '1', 0, 1);
INSERT INTO `question_bank` VALUES (168, '微信是由哪个公司开发？', 'B', 1, 1);
INSERT INTO `question_bank` VALUES (169, '1+1=2？', 'B', 1, 1);
INSERT INTO `question_bank` VALUES (170, '你是程序员吗？', '1', 0, 1);
INSERT INTO `question_bank` VALUES (171, '程序员要加班？', '1', 0, 1);
INSERT INTO `question_bank` VALUES (172, 'java和.net一样高级', '1', 0, 1);
INSERT INTO `question_bank` VALUES (173, '我在做试卷？', '1', 0, 1);
INSERT INTO `question_bank` VALUES (174, '程序员不应该有女朋友', '0', 0, 1);
INSERT INTO `question_bank` VALUES (175, '程序员的自我修养(加班、自觉加班、抢着加班)', '0', 0, 1);
INSERT INTO `question_bank` VALUES (176, '做程序员最重要的是有 Mac book', '1', 0, 1);
INSERT INTO `question_bank` VALUES (177, 'spring是java程序员必会的', '1', 0, 1);
INSERT INTO `question_bank` VALUES (178, '驾驶人有哪种情形的，交通警察可依法扣留机动车驾驶证？', 'A', 1, 1);
INSERT INTO `question_bank` VALUES (179, '驾驶车辆通过人行横道线时，应注意礼让行人。', '1', 0, 1);
INSERT INTO `question_bank` VALUES (180, '驾驶机动车发生交通事故未造成人身伤亡的，责任明确双方无争议时，应当如何处置？', 'D', 1, 1);
INSERT INTO `question_bank` VALUES (181, '夜间行车，驾驶人视距变短，影响观察，同时注意力高度集中，易产生疲劳。', '1', 0, 1);
INSERT INTO `question_bank` VALUES (182, '驾驶机动车下长坡时，仅靠行车制动器制动，容易引起行车制动器失灵。', '1', 0, 1);
INSERT INTO `question_bank` VALUES (183, '驾驶机动车找不到停车位时可以借人行道停放。', '0', 0, 1);
INSERT INTO `question_bank` VALUES (184, '风、雨、雪、雾等复杂气象条件，遇前车速度较低时，应开启前照灯，连续鸣喇叭迅速超越。', '0', 0, 1);
INSERT INTO `question_bank` VALUES (185, '年满20周岁，可以初次申请下列哪种准驾车型？', 'A', 1, 1);
INSERT INTO `question_bank` VALUES (186, '当驾驶人的血液中酒精含量为100毫克/100毫升时，属于醉酒驾驶。', '1', 0, 1);
INSERT INTO `question_bank` VALUES (187, '上道路行驶的机动车驾驶人未携带机动车驾驶证、行驶证的，除扣留机动车外，并受到什么处罚？', 'B', 1, 1);
INSERT INTO `question_bank` VALUES (188, '年龄在60周岁以上的机动车驾驶人，应当每年进行一次身体检查。', '1', 0, 1);
INSERT INTO `question_bank` VALUES (189, '机油压力报警灯持续亮，可以变形时，边观察，等待报警灯自行熄灭', '0', 0, 1);
INSERT INTO `question_bank` VALUES (190, '夜间行车，可选择下列那个地段超车?', 'C', 1, 1);
INSERT INTO `question_bank` VALUES (191, '机动车之间发生交通事故，不管是否有人员伤亡，只要双方当事人同意，都可自行协商解决', '0', 0, 1);
INSERT INTO `question_bank` VALUES (192, '超车需从前车左侧超越，以下说法正确的是什么?', 'A', 1, 1);
INSERT INTO `question_bank` VALUES (193, '驾驶机动车在高速公路上行驶，错过出口时，如果确认后方无来车，可以倒回出口驶离高速公路。', '0', 0, 1);
INSERT INTO `question_bank` VALUES (194, '驾驶机动车下陡坡时，以下说法正确的是？', 'D', 1, 1);
INSERT INTO `question_bank` VALUES (195, '驾驶机动车，遇前方停驶的油料运输车起火冒烟，以下做法正确的是什么?', 'D', 1, 1);
INSERT INTO `question_bank` VALUES (196, '驾驶装有安全气囊的汽车可以不系安全带。', '0', 0, 1);
INSERT INTO `question_bank` VALUES (197, '机动车在狭窄的坡路会车时，正确的会车方法是什么？', 'A', 1, 1);
INSERT INTO `question_bank` VALUES (198, '为什么大雪天气，除了(  )在有雪泥的路上超车危险？', 'A', 1, 1);
INSERT INTO `question_bank` VALUES (199, '驾驶汽车通过连续弯道时，尽量靠弯道右侧行驶。', '1', 0, 1);
INSERT INTO `question_bank` VALUES (200, '驾驶机动车在高速公路上行驶，能见度小于200米时，与同车车道前车应保持100米以上的距离。', '1', 0, 1);
INSERT INTO `question_bank` VALUES (201, '在高速公路行车选择什么地方停车？', 'A', 1, 1);
INSERT INTO `question_bank` VALUES (202, '在同向3车道高速公路上行车，车速高于每小时90公里、低于每小时110公里的机动车不应该在哪条车道上行驶？', 'A', 1, 1);
INSERT INTO `question_bank` VALUES (203, '驾驶机动车在高速公路减速车道行驶时，以下做法正确的是什么？', 'A', 1, 1);
INSERT INTO `question_bank` VALUES (204, '高速公路行车紧急情况避险的处理原则是什么？', 'B', 1, 1);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员', '拥有至高无上的权利');
INSERT INTO `role` VALUES (2, '文员', '拥有大部分权限');
INSERT INTO `role` VALUES (3, '老师', '拥有系统的部分权限');

-- ----------------------------
-- Table structure for role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `role_privilege`;
CREATE TABLE `role_privilege`  (
  `role_id` int(11) NOT NULL,
  `privilege_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`role_id`, `privilege_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_privilege
-- ----------------------------
INSERT INTO `role_privilege` VALUES (1, '1');
INSERT INTO `role_privilege` VALUES (1, '101');
INSERT INTO `role_privilege` VALUES (1, '2');
INSERT INTO `role_privilege` VALUES (1, '201');
INSERT INTO `role_privilege` VALUES (1, '202');
INSERT INTO `role_privilege` VALUES (1, '3');
INSERT INTO `role_privilege` VALUES (1, '301');
INSERT INTO `role_privilege` VALUES (1, '4');
INSERT INTO `role_privilege` VALUES (1, '401');
INSERT INTO `role_privilege` VALUES (1, '402');
INSERT INTO `role_privilege` VALUES (1, '403');
INSERT INTO `role_privilege` VALUES (2, '1');
INSERT INTO `role_privilege` VALUES (2, '101');
INSERT INTO `role_privilege` VALUES (2, '2');
INSERT INTO `role_privilege` VALUES (2, '201');
INSERT INTO `role_privilege` VALUES (2, '202');
INSERT INTO `role_privilege` VALUES (2, '3');
INSERT INTO `role_privilege` VALUES (2, '302');
INSERT INTO `role_privilege` VALUES (2, '4');
INSERT INTO `role_privilege` VALUES (2, '401');
INSERT INTO `role_privilege` VALUES (3, '1');
INSERT INTO `role_privilege` VALUES (3, '101');
INSERT INTO `role_privilege` VALUES (3, '2');
INSERT INTO `role_privilege` VALUES (3, '201');
INSERT INTO `role_privilege` VALUES (3, '202');
INSERT INTO `role_privilege` VALUES (3, '3');
INSERT INTO `role_privilege` VALUES (3, '302');
INSERT INTO `role_privilege` VALUES (3, '4');
INSERT INTO `role_privilege` VALUES (3, '401');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `score_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分数ID',
  `users_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `testpaper_id` int(11) NULL DEFAULT NULL,
  `fraction` double(255, 0) NULL DEFAULT NULL COMMENT '分数',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `supplementary` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`score_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (59, '249000302', 10012, 90, '/static/images/user.jpeg', NULL);
INSERT INTO `score` VALUES (71, '249000302', 10014, 30, NULL, NULL);
INSERT INTO `score` VALUES (72, '249000302', 10015, 0, NULL, NULL);

-- ----------------------------
-- Table structure for testpaper
-- ----------------------------
DROP TABLE IF EXISTS `testpaper`;
CREATE TABLE `testpaper`  (
  `testpaper_id` int(11) NOT NULL AUTO_INCREMENT,
  `testpaper_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试卷名',
  `testpaper_state` int(5) NOT NULL COMMENT '试卷状态 0为无效  1为有效',
  `start_date` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '开始时间',
  `end_date` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '结束时间',
  `is_start` int(5) NULL DEFAULT 1 COMMENT '是否开始考试 0 关闭 1开始',
  PRIMARY KEY (`testpaper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10016 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of testpaper
-- ----------------------------
INSERT INTO `testpaper` VALUES (10012, '科目一', 1, '2019-12-19 19:11:00', '2019-12-21 19:12:00', 1);
INSERT INTO `testpaper` VALUES (10013, '科目四', 1, '2019-12-19 19:41:00', '2019-12-19 19:47:00', 1);
INSERT INTO `testpaper` VALUES (10014, 'Java测试', 1, '2019-12-22 10:27:00', '2019-12-22 10:32:00', 1);
INSERT INTO `testpaper` VALUES (10015, '.Net测试', 1, '2019-12-22 10:28:00', '2019-12-22 10:29:00', 1);

-- ----------------------------
-- Table structure for testpaper_tests
-- ----------------------------
DROP TABLE IF EXISTS `testpaper_tests`;
CREATE TABLE `testpaper_tests`  (
  `testpaper_tests_id` int(11) NOT NULL AUTO_INCREMENT,
  `testpaper_id` int(11) NULL DEFAULT NULL,
  `question_bank_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`testpaper_tests_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 289 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of testpaper_tests
-- ----------------------------
INSERT INTO `testpaper_tests` VALUES (229, 10012, 178);
INSERT INTO `testpaper_tests` VALUES (230, 10012, 179);
INSERT INTO `testpaper_tests` VALUES (231, 10012, 180);
INSERT INTO `testpaper_tests` VALUES (232, 10012, 181);
INSERT INTO `testpaper_tests` VALUES (233, 10012, 182);
INSERT INTO `testpaper_tests` VALUES (234, 10012, 183);
INSERT INTO `testpaper_tests` VALUES (235, 10012, 184);
INSERT INTO `testpaper_tests` VALUES (236, 10012, 185);
INSERT INTO `testpaper_tests` VALUES (237, 10012, 187);
INSERT INTO `testpaper_tests` VALUES (238, 10012, 190);
INSERT INTO `testpaper_tests` VALUES (239, 10013, 191);
INSERT INTO `testpaper_tests` VALUES (240, 10013, 193);
INSERT INTO `testpaper_tests` VALUES (241, 10013, 196);
INSERT INTO `testpaper_tests` VALUES (242, 10013, 198);
INSERT INTO `testpaper_tests` VALUES (243, 10013, 199);
INSERT INTO `testpaper_tests` VALUES (244, 10013, 200);
INSERT INTO `testpaper_tests` VALUES (245, 10013, 201);
INSERT INTO `testpaper_tests` VALUES (246, 10013, 202);
INSERT INTO `testpaper_tests` VALUES (247, 10013, 203);
INSERT INTO `testpaper_tests` VALUES (248, 10013, 204);
INSERT INTO `testpaper_tests` VALUES (259, 10014, 158);
INSERT INTO `testpaper_tests` VALUES (260, 10014, 159);
INSERT INTO `testpaper_tests` VALUES (261, 10014, 160);
INSERT INTO `testpaper_tests` VALUES (262, 10014, 161);
INSERT INTO `testpaper_tests` VALUES (263, 10014, 162);
INSERT INTO `testpaper_tests` VALUES (264, 10014, 166);
INSERT INTO `testpaper_tests` VALUES (265, 10014, 167);
INSERT INTO `testpaper_tests` VALUES (266, 10014, 170);
INSERT INTO `testpaper_tests` VALUES (267, 10014, 171);
INSERT INTO `testpaper_tests` VALUES (268, 10014, 177);
INSERT INTO `testpaper_tests` VALUES (279, 10015, 163);
INSERT INTO `testpaper_tests` VALUES (280, 10015, 164);
INSERT INTO `testpaper_tests` VALUES (281, 10015, 165);
INSERT INTO `testpaper_tests` VALUES (282, 10015, 168);
INSERT INTO `testpaper_tests` VALUES (283, 10015, 169);
INSERT INTO `testpaper_tests` VALUES (284, 10015, 172);
INSERT INTO `testpaper_tests` VALUES (285, 10015, 173);
INSERT INTO `testpaper_tests` VALUES (286, 10015, 174);
INSERT INTO `testpaper_tests` VALUES (287, 10015, 175);
INSERT INTO `testpaper_tests` VALUES (288, 10015, 176);

-- ----------------------------
-- Table structure for times
-- ----------------------------
DROP TABLE IF EXISTS `times`;
CREATE TABLE `times`  (
  `times_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `testpaper_id` int(11) NOT NULL COMMENT '试卷_id',
  `user_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `data_min` double NULL DEFAULT NULL,
  `times_state` int(5) NULL DEFAULT NULL COMMENT '数据状态',
  PRIMARY KEY (`times_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of times
-- ----------------------------
INSERT INTO `times` VALUES (41, 10012, '249000302', -1, 0);
INSERT INTO `times` VALUES (42, 10013, '249000302', -1, 0);
INSERT INTO `times` VALUES (43, 10013, '249000302', -1, 0);
INSERT INTO `times` VALUES (44, 10013, '249000302', -1, 0);
INSERT INTO `times` VALUES (45, 10013, '249000302', -2052, 1);
INSERT INTO `times` VALUES (46, 10014, '249000302', -1, 0);
INSERT INTO `times` VALUES (47, 10015, '249000302', -1, 0);
INSERT INTO `times` VALUES (48, 10014, '249000302', -1, 0);
INSERT INTO `times` VALUES (49, 10015, '249000302', -1, 0);
INSERT INTO `times` VALUES (50, 10014, '249000302', -1, 0);
INSERT INTO `times` VALUES (51, 10015, '249000302', -1, 0);
INSERT INTO `times` VALUES (52, 10014, '249000302', -1, 0);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (149000101, 1);
INSERT INTO `user_role` VALUES (149000201, 2);
INSERT INTO `user_role` VALUES (149000301, 3);
INSERT INTO `user_role` VALUES (149000302, 3);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `user_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户真实姓名',
  `user_pass` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登陆密码',
  `user_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码',
  `user_portrait` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `permission` int(5) NULL DEFAULT NULL COMMENT '用户权限',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('149000101', 'LWB(管理员)', 'admin', '15297844614', '/static/img/初始头像.jpg', 1);
INSERT INTO `users` VALUES ('149000201', 'DL(文员)', 'admin', '15297844615', '/static/img/初始头像.jpg', 1);
INSERT INTO `users` VALUES ('149000301', 'CJ(老师)', 'admin', '15297844616', '/static/img/初始头像.jpg', 1);
INSERT INTO `users` VALUES ('249000302', 'ZLB(学生)', 'admin', '15297844616', '/static/img/初始头像.jpg', 0);
INSERT INTO `users` VALUES ('3000002103763780', 'PSJ(学员)', 'admin', '19812140194', '/static/img/初始头像.jpg', 0);
INSERT INTO `users` VALUES ('4000000558073435', 'mmw', 'admin', '15297844614', '/static/img/初始头像.jpg', 0);
INSERT INTO `users` VALUES ('7000000227584051', '249000302', 'admin', '15297844614', '/static/img/初始头像.jpg', NULL);
INSERT INTO `users` VALUES ('9000000783584765', 'cxy(学员)', 'admin', '15297844614', '/static/img/初始头像.jpg', 0);

SET FOREIGN_KEY_CHECKS = 1;
