/*
 Navicat Premium Data Transfer

 Source Server         : LOCAL
 Source Server Type    : MySQL
 Source Server Version : 100425
 Source Host           : localhost:3306
 Source Schema         : supermarket

 Target Server Type    : MySQL
 Target Server Version : 100425
 File Encoding         : 65001

 Date: 07/12/2022 01:56:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cargo
-- ----------------------------
DROP TABLE IF EXISTS `cargo`;
CREATE TABLE `cargo`  (
  `cod_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_cargo` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sueldo` int(11) NOT NULL,
  PRIMARY KEY (`cod_cargo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cargo
-- ----------------------------
INSERT INTO `cargo` VALUES (1, 'admin', 5000);
INSERT INTO `cargo` VALUES (2, 'usuario', 2000);

-- ----------------------------
-- Table structure for cliente
-- ----------------------------
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente`  (
  `CINIT` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `apellido_paterno` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `apellido_materno` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `direccion` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`CINIT`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1007 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cliente
-- ----------------------------
INSERT INTO `cliente` VALUES (1001, 'Miriam Sonia', 'Justo', 'Mamani', 'el alto villa ingenio');
INSERT INTO `cliente` VALUES (1002, 'nelly luna', 'mamani', 'poma', '16 de febrero el alto');
INSERT INTO `cliente` VALUES (1003, 'abner', 'aiiaga', 'sosa', 'zona tupack katary');
INSERT INTO `cliente` VALUES (1004, 'Julia', 'Sosa', 'Medrano', 'zona tupack katary calle 4');
INSERT INTO `cliente` VALUES (1006, 'Vasti', 'Aliaga', 'Sosa', 'En mi casa');

-- ----------------------------
-- Table structure for detalle_compra
-- ----------------------------
DROP TABLE IF EXISTS `detalle_compra`;
CREATE TABLE `detalle_compra`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `precio` double(8, 2) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `observaciones` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `cod_producto` int(11) NOT NULL,
  `id_factura` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cod_producto`(`cod_producto`) USING BTREE,
  INDEX `id_factura`(`id_factura`) USING BTREE,
  CONSTRAINT `detalle_compra_ibfk_1` FOREIGN KEY (`cod_producto`) REFERENCES `producto` (`cod_producto`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `detalle_compra_ibfk_2` FOREIGN KEY (`id_factura`) REFERENCES `factura_compra` (`id_factura`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of detalle_compra
-- ----------------------------
INSERT INTO `detalle_compra` VALUES (1, 5.50, 6, 'pues sin novedad', 2, 1);

-- ----------------------------
-- Table structure for detalle_venta
-- ----------------------------
DROP TABLE IF EXISTS `detalle_venta`;
CREATE TABLE `detalle_venta`  (
  `id_v` int(11) NOT NULL AUTO_INCREMENT,
  `precio` double(8, 2) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `detalle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cod_producto` int(11) NOT NULL,
  `nro_factura` int(11) NOT NULL,
  PRIMARY KEY (`id_v`) USING BTREE,
  INDEX `cod_producto`(`cod_producto`) USING BTREE,
  INDEX `nro_factura`(`nro_factura`) USING BTREE,
  CONSTRAINT `detalle_venta_ibfk_1` FOREIGN KEY (`cod_producto`) REFERENCES `producto` (`cod_producto`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `detalle_venta_ibfk_2` FOREIGN KEY (`nro_factura`) REFERENCES `factura_venta` (`nro_factura`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of detalle_venta
-- ----------------------------
INSERT INTO `detalle_venta` VALUES (1, 6.50, 6, 'producto recien llegado ', 2, 1000);
INSERT INTO `detalle_venta` VALUES (2, 7.00, 2, 'leche Cream', 3, 1000);

-- ----------------------------
-- Table structure for factura_compra
-- ----------------------------
DROP TABLE IF EXISTS `factura_compra`;
CREATE TABLE `factura_compra`  (
  `id_factura` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_compra` date NOT NULL,
  `nit` int(11) NOT NULL,
  `total` double(8, 2) NULL DEFAULT NULL,
  `nro_factura` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_factura`) USING BTREE,
  INDEX `NIT`(`nit`) USING BTREE,
  CONSTRAINT `factura_compra_ibfk_1` FOREIGN KEY (`nit`) REFERENCES `proveedores` (`nit`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of factura_compra
-- ----------------------------
INSERT INTO `factura_compra` VALUES (1, '2022-12-07', 2000, 33.00, 78965);

-- ----------------------------
-- Table structure for factura_venta
-- ----------------------------
DROP TABLE IF EXISTS `factura_venta`;
CREATE TABLE `factura_venta`  (
  `nro_factura` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_venta` date NOT NULL,
  `ci_nit` int(11) NOT NULL,
  `total` double(8, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`nro_factura`) USING BTREE,
  INDEX `CI-NIT`(`ci_nit`) USING BTREE,
  CONSTRAINT `factura_venta_ibfk_1` FOREIGN KEY (`ci_nit`) REFERENCES `cliente` (`CINIT`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1001 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of factura_venta
-- ----------------------------
INSERT INTO `factura_venta` VALUES (1000, '2022-12-07', 1006, 53.00);

-- ----------------------------
-- Table structure for personal
-- ----------------------------
DROP TABLE IF EXISTS `personal`;
CREATE TABLE `personal`  (
  `id_personal` int(11) NOT NULL AUTO_INCREMENT,
  `nombres_personal` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `usuario` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `password` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `celular` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `direccion` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cod_cargo` int(11) NOT NULL,
  `estado` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id_personal`) USING BTREE,
  INDEX `cod_cargo`(`cod_cargo`) USING BTREE,
  CONSTRAINT `personal_ibfk_1` FOREIGN KEY (`cod_cargo`) REFERENCES `cargo` (`cod_cargo`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of personal
-- ----------------------------
INSERT INTO `personal` VALUES (1, 'Josue AS', 'josue@gmail.com', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', '75292224', 'tupack katary calle 4', 1, 'activo');
INSERT INTO `personal` VALUES (2, 'Caleb Sosa', 'caleb@gmail.com', '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', '68025442', '16 de febrero camino laja', 2, 'activo');
INSERT INTO `personal` VALUES (3, 'miriam', 'miriam@gmail.com', '7b52009b64fd0a2a49e6d8a939753077792b0554', '7654321', 'zona villa ingenio', 2, 'activo');

-- ----------------------------
-- Table structure for producto
-- ----------------------------
DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto`  (
  `cod_producto` int(11) NOT NULL AUTO_INCREMENT,
  `stock` int(11) NOT NULL,
  `tipo` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `fecha_elaboracion` date NOT NULL,
  `id_personal` int(11) NOT NULL,
  `nombre_producto` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `imagen` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `estado` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`cod_producto`) USING BTREE,
  INDEX `id_personal`(`id_personal`) USING BTREE,
  CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`id_personal`) REFERENCES `personal` (`id_personal`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of producto
-- ----------------------------
INSERT INTO `producto` VALUES (1, 100, 'refrescos', '2022-12-08', '2022-01-01', 1, 'COCA COLA', NULL, 'activo');
INSERT INTO `producto` VALUES (2, 100, 'lacteos', '2023-12-08', '2022-01-01', 1, 'LECHE PIL', NULL, 'activo');
INSERT INTO `producto` VALUES (3, 98, 'lacteos', '2022-12-31', '2022-01-01', 3, 'CREAM', NULL, 'activo');
INSERT INTO `producto` VALUES (4, 100, 'cereales', '2023-12-08', '2020-10-01', 1, 'ARROZ', NULL, 'activo');
INSERT INTO `producto` VALUES (5, 100, 'pastas', '2023-12-31', '2020-10-01', 3, 'FIDEOS LAZARONI', NULL, 'activo');
INSERT INTO `producto` VALUES (6, 100, 'snacks', '2023-12-31', '2021-10-01', 1, 'LAYÂ´S', NULL, 'activo');

-- ----------------------------
-- Table structure for proveedores
-- ----------------------------
DROP TABLE IF EXISTS `proveedores`;
CREATE TABLE `proveedores`  (
  `nit` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nro_telefono` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `direccion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`nit`) USING BTREE,
  INDEX `nit`(`nit`) USING BTREE,
  INDEX `nit_2`(`nit`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2003 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of proveedores
-- ----------------------------
INSERT INTO `proveedores` VALUES (2000, 'EMPRESA PIL', '76543210', 'el alto');
INSERT INTO `proveedores` VALUES (2001, 'EMPRESA COCA COLA', '76543210', 'rio seco extranca');
INSERT INTO `proveedores` VALUES (2002, 'EMAPA', '75436215', 'ceja el alto');

SET FOREIGN_KEY_CHECKS = 1;
