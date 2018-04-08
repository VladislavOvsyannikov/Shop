-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: sql2.freesqldatabase.com    Database: sql2230448
-- ------------------------------------------------------
-- Server version	5.5.54-0ubuntu0.12.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES (1,NULL,'','Николай','89721340291'),(2,NULL,'','Иван','89249890144');
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1,'Cыр, Томатный соус, Болгарский перец, Шампиньоны, Лук, Зелёные оливки, Орегано','Вегетарианская','490','Белки - 10,95 г.\r\nЖиры - 16 г.\r\nУглеводы - 23,38 г.\r\nЭнергетическая ценность - 281,32 / 1177,04 ккал/кДж',1),(2,'Cыр, Томатный соус, Ветчина, Шампиньоны, Креветки, Мидии, Орегано','Кватро','620','Белки - 13,55 г.\r\nЖиры - 15,22 г.\r\nУглеводы - 21,13 г.\r\nЭнергетическая ценность - 275,7 / 1 153,53 ккал/кДж',1),(3,'Cыр, Томатный соус, Ветчина, Шампиньоны, Салями, Халопеньо, Болгарский перец, Чёрные Оливки, Орегано','Пепперони','630','Белки - 12,14 г.\r\nЖиры - 20,68 г.\r\nУглеводы - 19,82 г.\r\nЭнергетическая ценность - 313,96 / 1 313,61 ккал/кДж',1),(4,'Cыр, Томатный соус, Мясной фарш, Лук, Пири-пири, Перчик-пепперони, Консервированные Луковички, Чили перец, Орегано','Мафия','570','Белки - 12,85 г.\r\nЖиры - 15,61 г.\r\nУглеводы - 20,67 г.\r\nЭнергетическая ценность - 274,57 / 1 148,8 ккал/кДж',1),(5,'Cыр, Томатный соус, Мясной фарш, Консервированный болгарский перец, Смесь специй «Тако», Чёрные оливки, Соус горчичный, Орегано','Корсиканская','590','Белки - 11,67 г.\r\nЖиры - 17,62 г.\r\nУглеводы - 18,17 г.\r\nЭнергетическая ценность - 277,94 / 1 162,9 ккал/кДж',1),(6,'Рис, вода, сахар, рисовый уксус, соль, комбу, филе лосося, филе угря, свежий огурец, творожный сыр Cremette, нори.','Ролл с лососем и угрем','339','Энерг. ценность (100 г): 151 ккал,\r\nбелки 6.10 г, жиры 3.30 г, углеводы 24.30 г',2),(7,'Рис, вода, сахар, рисовый уксус, соль, комбу, свежий огурец, водоросли нори.','Ролл с огурцом','79','Энерг. ценность (100 г): 107 ккал,\r\nбелки 0.4 г, жиры 0.04 г, углеводы 26.3 г',2),(8,'Рис, вода, сахар, рисовый уксус, соль, комбу, филе угря, нори.','Ролл с угрем','229','Энерг. ценность (100 г): 134 ккал,\r\nбелки 2.3 г, жиры 2.1 г, углеводы 26.4 г',2),(9,'Рис, вода, сахар, рисовый уксус, соль, комбу, филе гребешка, омлет, творожный сыр Cremette, майонез, соус шрирача, соус табаско, специя шичими, нори','Острый ролл с гребешком','329','Энерг. ценность (100 г): 202 ккал,\r\nбелки 10.6 г, жиры 3.9 г, углеводы 31.2 г',2),(10,'Рис, вода, сахар, рисовый уксус, соль, комбу, филе лосося, свежий огурец, творожный сыр Cremette, нори.','Ролл «Филадельфия»','349','Энерг. ценность (100 г): 171 ккал,\r\nбелки 3.1 г, жиры 3.4 г, углеводы 32.1 г',2),(11,'Дрожжевое тесто, говядина, вареный картофель, репчатый лук, соевый соус, черный молотый перец, молотый кориандр, чеснок, молотый кумин, сливочное масло.','Осетинский пирог с говядиной','407','Энерг. ценность (100 г): 332 ккал,\r\nбелки 17.9 г, жиры 18 г, углеводы 24.7 г',3),(12,'Дрожжевое тесто, сулугуни, ветчина, вареный картофель, сливочное масло.','Осетинский пирог с ветчиной и сыром','407','Энерг. ценность (100 г): 240 ккал,\r\nбелки 15.6 г, жиры 8.7 г, углеводы 24.9 г',3),(13,'Дрожжевое тесто, вареный картофель, шампиньоны, черный молотый перец, репчатый лук, соль, сливочное масло.','Осетинский пирог с картофелем и грибами','407','Энерг. ценность (100 г): 221 ккал,\r\nбелки 5.5 г, жиры 3.7 г, углеводы 41.4 г',3),(14,'Дрожжевое тесто, филе лосося, укроп, черный молотый перец, соль, майонез, сливочное масло.','Осетинский пирог с лососем','497','Энерг. ценность (100 г): 209 ккал,\r\nбелки 7.8 г, жиры 8.3 г, углеводы 25.8 г',3),(15,'Дрожжевое тесто, тушеная капуста, куриное яйцо, репчатый лук, черный молотый перец, соль, сливочное масло.','Осетинский пирог с капустой и яйцом','347','Энерг. ценность (100 г): 183 ккал,\r\nбелки 5.6 г, жиры 5.4 г, углеводы 28 г',3),(16,'Булочка для гамбургера, дижонская горчица, майонез, чеддер, говядина, помидоры, маринованные огурцы, красный лук, салат айсберг, соус барбекю.','Чизбургер','269','Энерг. ценность (100 г): 363 ккал,\r\nбелки 13.9 г, жиры 17.9 г, углеводы 36.7 г',4),(17,'Булочка для гамбургера, филе курицы, куриное яйцо, соль, белый молотый перец, панировочные сухари, дижонская горчица, майонез, чеддер, помидоры, маринованные огурцы, салат айсберг, соевый соус, чеснок, укроп.','Чикенбургер','249','Энерг. ценность (100 г): 330 ккал,\r\nбелки 11.9 г, жиры 17.1 г, углеводы 32.2 г',4),(18,'Черная булочка для гамбургера, индейка, соль, белый молотый перец, куриное яйцо, панировочные сухари, дижонская горчица, майонез, чеддер, помидоры, маринованные огурцы, красный лук, салат айсберг, чеснок, черный молотый перец.','Черный бургер с индейкой','277','Энерг. ценность (100 г): 358 ккал,\r\nбелки 13.9 г, жиры 17.8 г, углеводы 35.7 г',4),(19,'Бургер с лососевой котлетой, тонкими слайсами чеддера, свежими томатами, маринованными огурцами, салатом айсберг, дижонской горчицей и специями.','Бургер с лососем','287','Энерг. ценность (100 г): 337 ккал,\r\nбелки 13.1 г, жиры 15.9 г, углеводы 35.4 г',4),(20,'Булочка для гамбургера, дижонская горчица, майонез, чеддер, говядина, помидоры, маринованные огурцы, красный лук, бекон, салат айсберг, соус барбекю.','BBQ бургер','299','Энерг. ценность (100 г): 319 ккал,\r\nбелки 12.1 г, жиры 15.6 г, углеводы 32.6 г',4);
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `foodincart`
--

LOCK TABLES `foodincart` WRITE;
/*!40000 ALTER TABLE `foodincart` DISABLE KEYS */;
/*!40000 ALTER TABLE `foodincart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (27);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'Пицца'),(2,'Суши'),(3,'Пироги'),(4,'Бургеры');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','123','ROLE_ADMIN',''),(2,'man1','1','ROLE_MANAGER',NULL),(3,'man2','2','ROLE_MANAGER',NULL),(25,'Влад','1','ROLE_USER',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-08 20:05:23