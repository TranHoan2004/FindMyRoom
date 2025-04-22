-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: findmytro
-- ------------------------------------------------------
-- Server version	8.0.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

USE findmytro;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users`
    DISABLE KEYS */;
INSERT INTO `users`
VALUES (1, '2025-04-03', 'user1@gmail.com', 'Tran Xuan Hoan', _binary '', '/images/image1.png',
        '$2a$10$3KYpDuVjCZ8pXdWAZUEyfur1KNWPkijUErQrqkvUG8ZR0PwEq1MYi', '0123456789', 'ROLE_EMPLOYEE', _binary ''),
       (2, '2025-04-03', 'hoana5k44nknd@gmail.com', 'Tran Xuan Hoan', _binary '', '/images/image2.png',
        '$2a$10$3KYpDuVjCZ8pXdWAZUEyfur1KNWPkijUErQrqkvUG8ZR0PwEq1MYi', '0147852369', 'ROLE_ADMIN', _binary ''),
       (10, '2025-04-03', 'user2@gmail.com', 'Nguyễn Thuỳ Dương', _binary '\0', '/images/image2.png',
        '$2a$10$3KYpDuVjCZ8pXdWAZUEyfur1KNWPkijUErQrqkvUG8ZR0PwEq1MYi', '0513698478', 'ROLE_USER', _binary ''),
       (11, '2025-04-03', 'user3@gmail.com', 'Trần Hoàng Hà', _binary '', '/images/image2.png',
        '$2a$10$3KYpDuVjCZ8pXdWAZUEyfur1KNWPkijUErQrqkvUG8ZR0PwEq1MYi', '0912369587', 'ROLE_USER', _binary ''),
       (12, '2025-04-03', 'user4@gmail.com', 'Vũ Thúy Hồng', _binary '\0', '/images/image2.png',
        '$2a$10$3KYpDuVjCZ8pXdWAZUEyfur1KNWPkijUErQrqkvUG8ZR0PwEq1MYi', '0912456398', 'ROLE_USER', _binary ''),
       (13, '2025-04-03', 'user5@gmail.com', 'Nguyễn Minh Ngọc', _binary '\0', '/images/image2.png',
        '$2a$10$3KYpDuVjCZ8pXdWAZUEyfur1KNWPkijUErQrqkvUG8ZR0PwEq1MYi', '0949256318', 'ROLE_USER', _binary ''),
       (14, '2025-04-03', 'user6@gmail.com', 'Lê Hồng Quang', _binary '', '/images/image2.png',
        '$2a$10$3KYpDuVjCZ8pXdWAZUEyfur1KNWPkijUErQrqkvUG8ZR0PwEq1MYi', '0949785163', 'ROLE_BUSINESSMAN', _binary ''),
       (15, '2025-04-03', 'user7@gmail.com', 'Vân Anh', _binary '\0', '/images/image2.png',
        '$2a$10$3KYpDuVjCZ8pXdWAZUEyfur1KNWPkijUErQrqkvUG8ZR0PwEq1MYi', '0949123456', 'ROLE_EMPLOYEE', _binary '');
/*!40000 ALTER TABLE `users`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin`
    DISABLE KEYS */;
INSERT INTO `admin`
VALUES (1);
/*!40000 ALTER TABLE `admin`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `boarding_house`
--

LOCK TABLES `boarding_house` WRITE;
/*!40000 ALTER TABLE `boarding_house`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `boarding_house`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `booking`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `business`
--

LOCK TABLES `business` WRITE;
/*!40000 ALTER TABLE `business`
    DISABLE KEYS */;
INSERT INTO `business`
VALUES (14, 1000, '129817239812498719');
/*!40000 ALTER TABLE `business`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `cart`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee`
    DISABLE KEYS */;
INSERT INTO `employee`
VALUES (1, 1),
       (15, 1);
/*!40000 ALTER TABLE `employee`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `notification`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `notification_seq`
--

LOCK TABLES `notification_seq` WRITE;
/*!40000 ALTER TABLE `notification_seq`
    DISABLE KEYS */;
INSERT INTO `notification_seq`
VALUES (1);
/*!40000 ALTER TABLE `notification_seq`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;
/*!40000 ALTER TABLE `persistent_logins`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post`
    DISABLE KEYS */;
INSERT INTO `post`
VALUES (2, 'Hai Bà Trưng, Hà Nội, Việt Nam',
        'Cho thuê phòng tiện nghi, gần trường ĐH Bách Khoa, đầy đủ nội thất.',
        '2025-04-02', 'video_single_room.mp4', 'Giá hợp dẫn', _binary '', '/images/Google.png',
        'Phòng gần trường ĐH Bách Khoa', 2, 14, 1, '', 2, 3),

       (3, 'Đống Đa, Hà Nội, Việt Nam',
        'Phòng đôi rộng rãi, gần trung tâm Đống Đa, phù hợp với cặp đôi hoặc bạn bè ở ghép.',
        '2025-04-02', 'video_single_room.mp4', 'Miễn phí wifi', _binary '', '/images/Google.png',
        'Phòng đôi tiện nghi tại Đống Đa', 2, 14, 15, '', 5, 4),

       (4, 'Cầu Giấy, Hà Nội, Việt Nam',
        'Cho thuê nhà nguyên căn, gần trường học và chợ, phù hợp cho gia đình.',
        '2025-04-02', 'video_single_room.mp4', 'Giới hạn giá thuê dưới hạn', _binary '',
        '/images/Google.png', 'Nhà nguyên căn tại Cầu Giấy', 2, 14, 2, '', 9, 1),

       (5, 'Cầu Giấy, Hà Nội, Việt Nam',
        'Tìm bạn ở ghép, phòng rộng rãi, đầy đủ nội thất, ngay gần ĐH Ngoại Thương.',
        '2025-04-02', 'video_single_room.mp4', 'Chi phí chia sẻ hợp lý', _binary '',
        '/images/Google.png', 'Ở ghép phòng gần ĐH Ngoại Thương', 2, 14, 1, '', 11, 2),

       (6, 'Hà Nội, Việt Nam',
        'Phòng trọ sạch sẽ, giá rẻ, gần ĐH Quốc Gia Hà Nội.',
        '2025-04-02', 'video_single_room.mp4', 'Giảm giá tháng đầu tiên', _binary '',
        '/images/Google.png', 'Phòng trọ giá rẻ gần ĐH Quốc Gia', 2, 14, 15, '', 52, 13),

       (7, 'Hà Nội, Việt Nam',
        'Cho thuê phòng trọ tiện nghi, gần trường cấp 3, phù hợp cho học sinh và gia đình nhỏ.',
        '2025-04-02', 'video_single_room.mp4', 'Trang bị điều hòa miễn phí',
        _binary '', '/images/Google.png',
        'Phòng trọ tiện nghi gần trường cấp 3', 2, 14, 15, '', 34, 13),

       (8, 'Bắc Ninh, Việt Nam',
        'Phòng trọ gần khu công nghiệp, thuận tiện đi lại, giá cả hợp lý.',
        '2025-04-02', 'video_single_room.mp4', 'Có xe miễn phí', _binary '',
        '/images/Google.png', 'Nhà trọ gần khu công nghiệp Bắc Ninh', 2, 14, 2, '', 13, 17),

       (9, 'Hà Nội, Việt Nam',
        'Phòng rộng rãi, gần chợ và bến xe buýt, tìm người ở ghép chia sẻ chi phí.',
        '2025-04-02', 'video_single_room.mp4',
        'Miễn phí tiền nước tháng đầu', _binary '', '/images/Google.png',
        'Tìm người ở ghép tại Thanh Xuân', 2, 14, 1, '', 16, 7),

       (10, 'Đà Nẵng, Việt Nam',
        'Cho thuê phòng đôi, ngay trung tâm thành phố Đà Nẵng, đầy đủ tiện nghi.',
        '2025-04-02', 'video_single_room.mp4', 'Giá ưu đãi cuối tuần', _binary '',
        '/images/Google.png', 'Phòng đôi gần trung tâm Đà Nẵng', 2, 14, 15, '', 9, 5),

       (11, 'TP.HCM, Việt Nam',
        'Cho thuê nhà nguyên căn, gần trung tâm thương mại và trường học, phù hợp gia đình lớn.',
        '2025-04-02', 'video_single_room.mp4', 'Tặng voucher mua sắm', _binary '', '/images/Google.png',
        'Nhà nguyên căn tại TP.HCM', 2, 14, 2, '', 20, 9);
/*!40000 ALTER TABLE `post`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `post_cart`
--

LOCK TABLES `post_cart` WRITE;
/*!40000 ALTER TABLE `post_cart`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `post_cart`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `review`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `room_type`
--

LOCK TABLES `room_type` WRITE;
/*!40000 ALTER TABLE `room_type`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `room_type`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `service`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `slider`
--

LOCK TABLES `slider` WRITE;
/*!40000 ALTER TABLE `slider`
    DISABLE KEYS */;
INSERT INTO `slider`
VALUES (1, '/images/slide1.png', _binary '', 1),
       (2, '/images/slide2.png', _binary '', 15),
       (3, '/images/slide3.png', _binary '', 15),
       (4, '/images/slide4.jpg', _binary '', 15),
       (5, '/images/slide5.jpg', _binary '', 1),
       (6, '/images/slide6.jpg', _binary '', 15),
       (7, '/images/slide1.png', _binary '', 1),
       (8, '/images/image1.png', _binary '', 15),
       (9, '/images/image2.png', _binary '', 1),
       (10, '/images/image3.png', _binary '', 15);
/*!40000 ALTER TABLE `slider`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `story`
--

LOCK TABLES `story` WRITE;
/*!40000 ALTER TABLE `story`
    DISABLE KEYS */;
INSERT INTO `story`
VALUES (1, 'description1', 'link1', _binary '/images/image3.png', 'title1', 1),
       (2, 'description1', 'link1', _binary '/images/image2.png', 'title1', 2),
       (3, 'description1', 'link1', _binary '/images/image1.png', 'title1', 1),
       (4, 'description1', 'link1', _binary '/images/image2.png', 'title1', 2),
       (5, 'description1', 'link1', _binary '/images/image1.png', 'title1', 1),
       (6, 'description1', 'link1', _binary '/images/image3.png', 'title1', 2),
       (7, 'description1', 'link1', _binary '/images/image3.png', 'title1', 1),
       (8, 'description1', 'link1', _binary '/images/image3.png', 'title1', 2),
       (9, 'description1', 'link1', _binary '/images/image3.png', 'title1', 2),
       (10, 'description1', 'link1', _binary '/images/image3.png', 'title1', 2),
       (11, 'description1', 'link1', _binary '/images/image3.png', 'title1', 1);
/*!40000 ALTER TABLE `story`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `story_type`
--

LOCK TABLES `story_type` WRITE;
/*!40000 ALTER TABLE `story_type`
    DISABLE KEYS */;
INSERT INTO `story_type`
VALUES (1, 'Notification'),
       (2, 'Event');
/*!40000 ALTER TABLE `story_type`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2025-04-21 23:38:19
