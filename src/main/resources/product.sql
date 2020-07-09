-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2020-07-09 05:24:46
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
-- 資料表結構 `product`
--

CREATE TABLE `product` (
  `name` varchar(255) DEFAULT NULL,
  `location` varchar(255) NOT NULL,
  `descript` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `unit` varchar(256) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `product`
--

INSERT INTO `product` (`name`, `location`, `descript`, `price`, `unit`, `id`) VALUES
('紐西蘭有機富士蘋果', '紐西蘭', '保存建議：\r\n・收到後建議立即放入冰箱冷藏，約可保存一～二週，但仍建議趁新鮮食用完畢，風味最佳。\r\n・若想保持蘋果的新鮮口感，冷藏時請以密封方式保存，例如包在密封的塑膠袋內，避免因冰箱內其他蔬果加速催熟。', 30, '個', 1),
('雙色冰淇淋火龍果', '台灣花東縱谷', '注意事項：果物因產地及氣候而有不同風貌，照片僅供參考，將以新鮮度及品質為出貨標準。', 35, '個', 2),
('Zespri 陽光金奇異果', '紐西蘭', '保存建議：\r\n．奇異果具後熟性，收到後可以放在掌心輕握，若握起來稍軟有彈性，即可趁新鮮儘快享用，若握起來稍硬，可放置於陰涼通風處二～三天，待其自然熟成即可食用，或放入冰箱冷藏，約可延長儲存至少一～二週。\r\n．果物因產地及氣候而有不同風貌，照片僅供參考，將以新鮮度及品質為出貨標準。', 25, '個', 3),
('美國經典西北櫻桃', '美國西北洛磯山脈地區', '注意事項：果物因產地及氣候而有不同風貌，照片僅供參考，將以新鮮度及品質為出貨標準。', 300, '斤', 5);

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
