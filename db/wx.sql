/*
 Navicat Premium Data Transfer

 Source Server         : SQLStudy
 Source Server Type    : MySQL
 Source Server Version : 80402 (8.4.2)
 Source Host           : localhost:3306
 Source Schema         : wx

 Target Server Type    : MySQL
 Target Server Version : 80402 (8.4.2)
 File Encoding         : 65001

 Date: 27/05/2025 11:11:46
*/

CREATE DATABASE `wx`;
USE `wx`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `aid` int NOT NULL COMMENT '自增id',
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `status` tinyint NOT NULL DEFAULT 1 COMMENT '0-封禁，1-正常',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '1-逻辑删除，0-逻辑保留',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'basil', '123', 1, 0, '2025-03-26 20:22:26', '2025-03-26 20:22:26');

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '自增的ID',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片的UUID或临时文件路径',
  `open_id` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '404' COMMENT '用户openId，唯一标识用户',
  `upload_type` tinyint NULL DEFAULT NULL COMMENT '上传方式，0-相册上传，1-拍照上传，2-后台上传',
  `disease` tinyint NOT NULL DEFAULT 0 COMMENT '疾病分类，\r\n0-未分类，\r\n1-锈病\"Leaf_Rust\"，\r\n2-灰斑病\"Gray_Spot\"，\r\n3-大斑病\"Leaf_Blight\"，\r\n4-叶斑病\"Leaf_Spot\"，\r\n5-矮花叶病\"Corn_Stunt\"，\r\n6-健康\"Healthy_leaf\"，\r\n7-干扰\"without_leaves\"',
  `status` tinyint NULL DEFAULT 0 COMMENT '模型处理，0-未处理，1-已处理',
  `is_deleted` tinyint NULL DEFAULT 0 COMMENT '1-逻辑删除，0-逻辑保留',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '图片上传时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '图片处理时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES (1, '00001', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 0, 0, 0, 1, '2025-03-26 20:14:19', '2025-03-26 20:14:19');
INSERT INTO `image` VALUES (2, '00002', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 2, 5, 0, 1, '2025-03-31 10:38:57', '2025-03-31 10:38:57');
INSERT INTO `image` VALUES (4, '090908', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 1, 7, 0, 1, '2025-03-31 11:47:40', '2025-03-31 11:47:40');
INSERT INTO `image` VALUES (5, '9347d03f1ff349cebe7b7fbb7ede25fd.jpg', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 1, 3, 0, 1, '2025-03-31 21:26:38', '2025-03-31 21:26:38');
INSERT INTO `image` VALUES (6, '2751e2d5b7bb4ec5a2ebf7bcb12008f4.jpg', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 1, 3, 0, 1, '2025-03-31 21:32:46', '2025-03-31 21:32:46');
INSERT INTO `image` VALUES (7, 'ab3fc1ea9ac741a3adf1d9954d91548e.jpg', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 1, 6, 0, 1, '2025-03-31 21:33:29', '2025-03-31 21:33:29');
INSERT INTO `image` VALUES (8, '3c2e2e2266a748b0ad1e4ed8a56debff.jpg', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 0, 1, 0, 0, '2025-03-31 22:34:21', '2025-03-31 22:34:21');
INSERT INTO `image` VALUES (9, '5c8cdf0a2eac4fe0a4427a8ce2a0473a.jpg', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 0, 1, 0, 0, '2025-03-31 22:35:27', '2025-03-31 22:35:27');
INSERT INTO `image` VALUES (10, '094a0e87f7b0443b96ad76b3f52bd67d.jpg', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 0, 2, 0, 0, '2025-03-31 22:36:09', '2025-03-31 22:36:09');
INSERT INTO `image` VALUES (11, '13747c576e2440ed9ed4ad4bba914b7f.jpg', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 0, 1, 0, 0, '2025-04-01 21:43:03', '2025-04-01 21:43:03');
INSERT INTO `image` VALUES (12, '92f88ee042974f09b0e3dbbfb74927a8.jpg', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 1, 5, 0, 1, '2025-04-01 22:10:25', '2025-04-01 22:10:25');
INSERT INTO `image` VALUES (13, 'e185aa6846b4419292883a0188a2e5ce.jpg', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 0, 5, 0, 1, '2025-04-01 22:10:48', '2025-04-01 22:10:48');
INSERT INTO `image` VALUES (14, 'bff1dd4b051345a3b69b01d1bf1210a0.jpg', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 0, 5, 0, 1, '2025-04-01 22:11:00', '2025-04-01 22:11:00');
INSERT INTO `image` VALUES (15, '589375d3c3b743fc85034a688803b547.jpg', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 0, 4, 0, 1, '2025-04-01 22:11:16', '2025-04-01 22:11:16');
INSERT INTO `image` VALUES (16, 'b2c9d174bd184bd4bf7fdf4b9b7bfbf0.jpg', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 0, 3, 0, 1, '2025-04-01 22:11:38', '2025-04-01 22:11:38');
INSERT INTO `image` VALUES (17, '9ad2be590e13445b986bfc8ce89f2395.jpg', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 0, 6, 0, 0, '2025-04-01 22:14:51', '2025-04-01 22:14:51');
INSERT INTO `image` VALUES (18, '3e9eb510155540268c84bdcc769ee3ce.png', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 0, 1, 0, 1, '2025-04-03 16:41:28', '2025-04-03 16:41:28');
INSERT INTO `image` VALUES (19, '62f1b0f7cf3640e4837b0ca921944a98.jpg', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 1, 5, 0, 1, '2025-04-03 16:43:56', '2025-04-03 16:43:56');
INSERT INTO `image` VALUES (20, '53c09af877be4539bcabcfbc85eb9764.jpg', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 1, 5, 0, 1, '2025-04-03 16:48:31', '2025-04-03 16:48:31');
INSERT INTO `image` VALUES (21, 'ba479d5f3afd45ac80eeedd85d543380.jpg', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 0, 6, 0, 1, '2025-04-03 16:57:52', '2025-04-03 16:57:52');
INSERT INTO `image` VALUES (22, '3f946afb43d84cf38c78dc31ebeafb01.png', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 0, 3, 0, 1, '2025-04-03 16:58:58', '2025-04-03 16:58:58');
INSERT INTO `image` VALUES (23, '9637cbc03924493fbe5f570efeda7e83.png', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 0, 1, 0, 1, '2025-04-03 16:59:57', '2025-04-03 16:59:57');
INSERT INTO `image` VALUES (24, 'd8736c47b7f04c68856acb02475a5d2b.jpg', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 1, 6, 0, 1, '2025-04-03 17:25:27', '2025-04-03 17:25:27');
INSERT INTO `image` VALUES (25, '7e74d4d048d44860880dfbaf5190782b.png', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 0, 3, 0, 1, '2025-04-03 17:27:39', '2025-04-03 17:27:39');
INSERT INTO `image` VALUES (26, '22e3bb6f04df4890a5bc3348a80c031e.png', 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', 0, 2, 0, 0, '2025-04-03 20:22:58', '2025-04-03 20:22:58');
INSERT INTO `image` VALUES (27, '1ffa1a905caa45c6a5b202eb9427817d.jpg', '123', 0, 6, 0, 0, '2025-04-14 21:46:32', '2025-04-14 21:46:32');
INSERT INTO `image` VALUES (28, '1df8fa73753e48b79f4884922c4c756c.jpg', '123', 0, 2, 0, 0, '2025-04-14 21:48:04', '2025-04-14 21:48:04');
INSERT INTO `image` VALUES (29, '9959571020274ea292df9c49b8e2cfff.png', '123', 0, 2, 0, 0, '2025-04-14 21:49:41', '2025-04-14 21:49:41');
INSERT INTO `image` VALUES (30, '9223edb7758c4022874914285d25c252.png', '123', 0, 1, 0, 0, '2025-04-14 21:49:57', '2025-04-14 21:49:57');
INSERT INTO `image` VALUES (31, '98507eae2b444488aafba1d3b8e336d5.png', '123', 0, 2, 0, 0, '2025-04-14 21:50:15', '2025-04-14 21:50:15');
INSERT INTO `image` VALUES (32, '769ab872b61f4d458f298efd6ee36263.png', '123456', 0, 6, 0, 0, '2025-05-27 09:55:33', '2025-05-27 09:55:33');

-- ----------------------------
-- Table structure for softmax
-- ----------------------------
DROP TABLE IF EXISTS `softmax`;
CREATE TABLE `softmax`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '自增索引id',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图像的UUID',
  `diseases` tinyint NULL DEFAULT NULL COMMENT '图像疾病',
  `diseases_1` decimal(5, 4) NULL DEFAULT NULL COMMENT '疾病1概率',
  `diseases_2` decimal(5, 4) NULL DEFAULT NULL COMMENT '疾病2概率',
  `diseases_3` decimal(5, 4) NULL DEFAULT NULL COMMENT '疾病3概率',
  `diseases_4` decimal(5, 4) NULL DEFAULT NULL COMMENT '疾病4概率',
  `diseases_5` decimal(5, 4) NULL DEFAULT NULL COMMENT '疾病5概率',
  `diseases_6` decimal(5, 4) NULL DEFAULT NULL COMMENT '疾病6概率',
  `diseases_7` decimal(5, 4) NULL DEFAULT NULL COMMENT '疾病7概率',
  `status` tinyint NOT NULL DEFAULT 1 COMMENT '状态，1-正常，2-异常',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除，0-未删除，1-删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of softmax
-- ----------------------------
INSERT INTO `softmax` VALUES (1, '12', 1, 0.9999, 0.0000, 0.0000, 0.0001, 0.0000, 0.0000, NULL, 1, 0, '2025-04-21 21:10:22', '2025-04-21 21:24:40');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `open_id` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'unfound' COMMENT '微信用户唯一id',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信用户昵称',
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信用户头像',
  `status` tinyint NOT NULL DEFAULT 0 COMMENT '用户状态0-正常，1-异常',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '是否删除0-正常登录，1-封禁',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `openid`(`open_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (8, 'oqx396_Vzss3UE1P-Xp_VKlTSu4E', '紫罗勒-Dark opal basil', 'https://thirdwx.qlogo.cn/mmopen/vi_32/VEicGEpdckNBGfvynQiaVkmZtmVsYflicf7Bl2Ldh99Czic369XZhIWvc50mur2xyACHdjuBvkEW91iag6azn5AmicYN7mCIl8UQkcvo2HibMEBic6U/132', 0, 0, '2025-03-31 09:36:06', '2025-03-31 09:36:06');

SET FOREIGN_KEY_CHECKS = 1;
