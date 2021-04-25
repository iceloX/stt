/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : stt

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 25/04/2021 21:05:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id` bigint(65) NOT NULL COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `begin` datetime(6) NULL DEFAULT NULL COMMENT '开始时间',
  `end` datetime(6) NULL DEFAULT NULL COMMENT '结束时间',
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动封面',
  `place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地点',
  `score` float NULL DEFAULT NULL COMMENT '分数',
  `status` int(20) NULL DEFAULT NULL COMMENT '活动的状态：-1 未开始，0 进行中，1 已结束',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '修改',
  `version` int(255) NULL DEFAULT NULL COMMENT 'version，乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` bigint(20) NOT NULL COMMENT '编号',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐值加密',
  `stats` int(255) NULL DEFAULT NULL COMMENT '状态 1 启动，0 禁用',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '修改',
  `version` int(20) NULL DEFAULT NULL COMMENT 'version 乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `admin_id` bigint(20) NULL DEFAULT NULL COMMENT '管理员编号',
  `role` bigint(255) NULL DEFAULT NULL COMMENT '角色编号',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '修改',
  `version` int(20) NULL DEFAULT NULL COMMENT 'version 乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` bigint(20) NOT NULL COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面',
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '介绍',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `status` int(255) NULL DEFAULT NULL COMMENT '状态 1 展示，0不展示',
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类',
  `views` int(255) NULL DEFAULT NULL COMMENT '浏览量',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '修改',
  `version` int(20) NULL DEFAULT NULL COMMENT 'version，乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for com_act
-- ----------------------------
DROP TABLE IF EXISTS `com_act`;
CREATE TABLE `com_act`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `com_id` bigint(20) NULL DEFAULT NULL COMMENT '社团编号',
  `act_id` bigint(20) NULL DEFAULT NULL COMMENT '活动编号',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '修改',
  `version` int(255) NULL DEFAULT NULL COMMENT 'version；乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for com_admin
-- ----------------------------
DROP TABLE IF EXISTS `com_admin`;
CREATE TABLE `com_admin`  (
  `id` int(11) NOT NULL COMMENT '编号',
  `com_id` bigint(20) NULL DEFAULT NULL COMMENT '社团编号',
  `admin_id` bigint(20) NULL DEFAULT NULL COMMENT '管理员编号',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '修改',
  `version` int(20) NULL DEFAULT NULL COMMENT 'version 乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for community
-- ----------------------------
DROP TABLE IF EXISTS `community`;
CREATE TABLE `community`  (
  `id` bigint(65) NOT NULL COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'logo',
  `head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `status` int(255) NULL DEFAULT NULL COMMENT '状态 1 运营，0 关闭',
  `score` float NULL DEFAULT NULL COMMENT '分数',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '修改',
  `version` int(20) NULL DEFAULT NULL COMMENT 'version，乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` bigint(20) NOT NULL COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '修改',
  `version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'version 乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_per
-- ----------------------------
DROP TABLE IF EXISTS `role_per`;
CREATE TABLE `role_per`  (
  `id` int(11) NOT NULL COMMENT '编号',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色编号',
  `per_id` bigint(20) NULL DEFAULT NULL COMMENT '权限编号',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '修改',
  `version` int(20) NULL DEFAULT NULL COMMENT 'version 乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sign
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign`  (
  `id` bigint(65) NOT NULL COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `begin` datetime(6) NULL DEFAULT NULL COMMENT '开始时间',
  `end` datetime(6) NULL DEFAULT NULL COMMENT '结束时间',
  `jd` decimal(65, 0) NULL DEFAULT NULL COMMENT '经度',
  `wd` decimal(65, 0) NOT NULL COMMENT '纬度',
  `range` int(255) NULL DEFAULT NULL COMMENT '范围，整数表示从（0~range)',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '修改',
  `version` int(20) NULL DEFAULT NULL COMMENT 'version；乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(65) NOT NULL COMMENT '编号',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `snumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `open_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'openId',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `cls` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像链接',
  `status` int(20) NULL DEFAULT NULL COMMENT '状态：1正常，0禁用',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '修改',
  `version` int(255) NULL DEFAULT NULL COMMENT 'version，乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_act
-- ----------------------------
DROP TABLE IF EXISTS `user_act`;
CREATE TABLE `user_act`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(255) NULL DEFAULT NULL COMMENT '用户编号',
  `act_id` bigint(255) NULL DEFAULT NULL COMMENT '活动编号',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '修改',
  `version` int(20) NULL DEFAULT NULL COMMENT 'version；乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_com
-- ----------------------------
DROP TABLE IF EXISTS `user_com`;
CREATE TABLE `user_com`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(11) NULL DEFAULT NULL COMMENT '用户编号',
  `com_id` bigint(11) NULL DEFAULT NULL COMMENT '社团编号',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '修改',
  `version` int(20) NULL DEFAULT NULL COMMENT 'version 乐观锁',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_sign
-- ----------------------------
DROP TABLE IF EXISTS `user_sign`;
CREATE TABLE `user_sign`  (
  `id` bigint(255) NOT NULL COMMENT '编号',
  `user_id` bigint(255) NULL DEFAULT NULL COMMENT '用户编号',
  `sign_id` bigint(255) NULL DEFAULT NULL COMMENT '签到编号',
  `sign_time` datetime(6) NULL DEFAULT NULL COMMENT '签到时间',
  `sign_j` decimal(65, 0) NULL DEFAULT NULL COMMENT '签到经度',
  `sign_w` decimal(65, 0) NULL DEFAULT NULL COMMENT '签到纬度',
  `status` int(20) NULL DEFAULT NULL COMMENT '签到状态；-1 失败，1成功，0未签到',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '修改',
  `version` int(20) NULL DEFAULT NULL COMMENT 'version 乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
