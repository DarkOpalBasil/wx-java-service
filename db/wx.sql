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

 Date: 03/04/2025 15:49:50
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
  `aid` int NOT NULL,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` tinyint NULL DEFAULT 1 COMMENT '0-封禁，1-正常',
  `is_deleted` tinyint NULL DEFAULT 0 COMMENT '1-逻辑删除，0-逻辑保留',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123', 1, 0, '2025-03-26 20:22:26', '2025-03-26 20:22:26');

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '自增的ID',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片的UUID或临时文件路径',
  `open_id` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '404' COMMENT '用户openId，唯一标识用户',
  `upload_type` tinyint NULL DEFAULT NULL COMMENT '上传方式，0-相册上传，1-拍照上传，2-后台上传',
  `disease` int NOT NULL DEFAULT 0 COMMENT '疾病分类，\r\n0-未分类，\r\n1-锈病\"Leaf_Rust\"，\r\n2-灰斑病\"Gray_Spot\"，\r\n3-大斑病\"Leaf_Blight\"，\r\n4-叶斑病\"Leaf_Spot\"，\r\n5-矮花叶病\"Corn_Stunt\"，\r\n6-健康\"Healthy_leaf\"，\r\n7-干扰\"without_leaves\"',
  `status` tinyint NULL DEFAULT 0 COMMENT '模型处理，0-未处理，1-已处理',
  `is_deleted` tinyint NULL DEFAULT 0 COMMENT '1-逻辑删除，0-逻辑保留',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '图片上传时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '图片处理时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES (1, '9347d03f1ff349cebe7b7fbb7ede25fd.jpg', '123456', 1, 3, 0, 1, '2025-03-31 21:26:38', '2025-03-31 21:26:38');
INSERT INTO `image` VALUES (2, '9ad2be590e13445b986bfc8ce89f2395.jpg', '123456', 0, 6, 0, 0, '2025-04-01 22:14:51', '2025-04-01 22:14:51');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `open_id` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'unfound' COMMENT '微信用户唯一id',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信用户昵称',
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '微信用户头像',
  `status` tinyint NULL DEFAULT 0 COMMENT '用户状态0-正常，1-异常',
  `is_deleted` tinyint NULL DEFAULT 0 COMMENT '是否删除0-正常登录，1-封禁',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `openid`(`open_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '123456', '紫罗勒-Dark opal basil', 'https://thirdwx.qlogo.cn/mmopen/vi_32/VEicGEpdckNBGfvynQiaVkmZtmVsYflicf7Bl2Ldh99Czic369XZhIWvc50mur2xyACHdjuBvkEW91iag6azn5AmicYN7mCIl8UQkcvo2HibMEBic6U/132', 0, 0, '2025-03-31 09:36:06', '2025-03-31 09:36:06');

SET FOREIGN_KEY_CHECKS = 1;
