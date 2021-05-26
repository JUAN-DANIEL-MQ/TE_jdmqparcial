/*
 Navicat Premium Data Transfer

 Source Server         : LOCAL
 Source Server Type    : MySQL
 Source Server Version : 100414
 Source Host           : localhost:3306
 Source Schema         : bd_aclmamani

 Target Server Type    : MySQL
 Target Server Version : 100414
 File Encoding         : 65001

 Date: 25/05/2021 23:49:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permisos
-- ----------------------------
DROP TABLE IF EXISTS `permisos`;
CREATE TABLE `permisos`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NULL DEFAULT NULL,
  `id_rol` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_rol`(`id_rol`) USING BTREE,
  INDEX `fk_usuario`(`id_usuario`) USING BTREE,
  CONSTRAINT `fk_rol` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permisos
-- ----------------------------
INSERT INTO `permisos` VALUES (1, 5, 3);
INSERT INTO `permisos` VALUES (2, 5, 5);

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES (3, 'Administrativo');
INSERT INTO `roles` VALUES (5, 'Docentes');

-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `correo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clave` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usuarios
-- ----------------------------
INSERT INTO `usuarios` VALUES (5, 'JUAN DANIEL MAMANI ', 'juandanielquispe123@gmail.com', '917332dd29ac2da989455909318c7ac4');
INSERT INTO `usuarios` VALUES (6, 'Gabriel Garcia', 'juandanielquispe12345@gmail.com', '2729c40846b3432dccc74137a9e7f150');

SET FOREIGN_KEY_CHECKS = 1;
