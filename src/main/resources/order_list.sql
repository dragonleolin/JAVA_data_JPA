-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2020-07-09 05:24:56
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
-- 資料表結構 `order_list`
--

CREATE TABLE `order_list` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `creare_time` varchar(255) DEFAULT NULL,
  `customer` varchar(255) DEFAULT NULL,
  `total_price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `order_list`
--

INSERT INTO `order_list` (`id`, `address`, `creare_time`, `customer`, `total_price`) VALUES
(1, 'newTaipei', '2020-07-04', 'luke', 500),
(3, 'newTaipei', '2020-07-08', 'luke2', 345),
(4, 'newTaipei', NULL, 'luke3', 110),
(5, 'newTaipei', NULL, 'luke5', 230),
(6, 'newTaipei2', '2020-07-08', 'luke6', 140),
(7, 'newTaipei3', '2020/07/09 10:13:51', 'luke7', 225);

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `order_list`
--
ALTER TABLE `order_list`
  ADD PRIMARY KEY (`id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `order_list`
--
ALTER TABLE `order_list`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
