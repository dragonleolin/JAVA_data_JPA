-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2020-07-09 05:25:48
-- 伺服器版本： 10.4.13-MariaDB
-- PHP 版本： 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `dvdlibrary`
--

-- --------------------------------------------------------

--
-- 資料表結構 `order_item`
--

CREATE TABLE `order_item` (
  `id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `order_item`
--

INSERT INTO `order_item` (`id`, `order_id`, `price`, `product_name`, `product_id`, `qty`) VALUES
(1, 1, 35, '雙色冰淇淋火龍果', 2, 3),
(2, 1, 25, 'null', 3, 4),
(3, 1, 30, '', 1, 5),
(4, 1, 30, '紐西蘭有機富士蘋果', 1, 5),
(5, 2, 30, '紐西蘭有機富士蘋果', 1, 5),
(6, 3, 30, '紐西蘭有機富士蘋果', 1, 4),
(7, 3, 35, '雙色冰淇淋火龍果', 2, 5),
(8, 3, 25, 'Zespri 陽光金奇異果', 3, 2),
(9, 4, 25, 'Zespri 陽光金奇異果', 3, 2),
(10, 4, 30, '紐西蘭有機富士蘋果', 1, 2),
(11, 5, 30, '紐西蘭有機富士蘋果', 1, 3),
(12, 5, 35, '雙色冰淇淋火龍果', 2, 4),
(13, 6, 35, '雙色冰淇淋火龍果', 2, 4),
(14, 7, 30, '紐西蘭有機富士蘋果', 1, 4),
(15, 7, 35, '雙色冰淇淋火龍果', 2, 3);

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `order_item`
--
ALTER TABLE `order_item`
  ADD PRIMARY KEY (`id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `order_item`
--
ALTER TABLE `order_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
