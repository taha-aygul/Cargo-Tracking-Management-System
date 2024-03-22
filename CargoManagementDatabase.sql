
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `dtb`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `address`
--

CREATE TABLE `address` (
  `address_id` int(11) NOT NULL,
  `street_name` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `town_name` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `city_name` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `apartment_name` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `door_no` varchar(20) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `address`
--

INSERT INTO `address` (`address_id`, `street_name`, `town_name`, `city_name`, `apartment_name`, `door_no`) VALUES
(1, 'Işıklar', 'Ceylanpınar', 'Şanlıurfa', 'Sevgi', '245'),
(2, 'Durak', 'Karabağlar', 'İzmir', 'Çağdaş', '232'),
(3, 'Uğurmumcu', 'Selçuk', 'İzmir', 'Karanfil', '327'),
(4, 'Barutçular', 'Merkezefendi', 'Denizli', 'Çiçek', '786'),
(5, 'Sabunlu', 'Dalaman', 'Muğla', 'Deniz', '455'),
(6, 'Kaya', 'Güce', 'Giresun', 'Taş', '121'),
(7, 'Yolpınar', 'Suluova', 'Amasya', 'Elma', '695'),
(8, 'Cumhuriyet', 'Buca', 'İzmir', 'Gül', '717'),
(9, 'Zeybek', 'Efeler', 'Aydın', 'Uzay', '657'),
(10, 'Çiğdem', 'Konak', 'İzmir', 'Bilgi', '456'),
(11, 'Hudut', 'Doğanşehir', 'Kayseri', 'Ada', '897'),
(12, 'Dere', 'Gerze', 'Sinop', 'Kuzu', '461'),
(13, 'Hamzalar', 'Merkez', 'Karabük', 'Göl', '159'),
(14, 'Kibar', 'Karabağlar', 'İzmir', 'Sevinç', '357'),
(15, 'Çiğdemli', 'Merkez', 'İzmir', 'Erdemli', '624'),
(16, 'Evciler', 'Bayramiç', 'Çanakkale', 'Kavak', '654'),
(17, 'Kavakarası', 'Köyceğiz', 'Muğla', 'Çınar', '545'),
(18, 'Emir', 'Orhaneli', 'Bursa', 'Köy', '313'),
(19, 'Gevrake', 'Merkez', 'Artvin', 'Yusufeli', '787'),
(20, 'Düzyurt', 'Aşkale', 'Erzurum', 'Sıla', '741'),
(21, 'Metin', 'Buca', 'İzmir', 'Eslem', '10'),
(27, 'Uğur', 'Karadağlar', 'İzmir', 'Sevgi', '22'),
(28, 'Serasker', 'Kadıköy', 'İstanbul', 'Çakır', '111');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `cargo`
--

CREATE TABLE `cargo` (
  `cargoID` int(11) NOT NULL,
  `cargo_user_id` varchar(5) COLLATE utf8_turkish_ci NOT NULL,
  `delivery_address` varchar(70) COLLATE utf8_turkish_ci NOT NULL,
  `sent_address` varchar(70) COLLATE utf8_turkish_ci NOT NULL,
  `recipient_name` varchar(30) COLLATE utf8_turkish_ci NOT NULL,
  `recipient_surname` varchar(30) COLLATE utf8_turkish_ci NOT NULL,
  `sender_name` varchar(30) COLLATE utf8_turkish_ci NOT NULL,
  `shipping_date` varchar(10) COLLATE utf8_turkish_ci NOT NULL,
  `cargo_content` varchar(30) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `cargo`
--

INSERT INTO `cargo` (`cargoID`, `cargo_user_id`, `delivery_address`, `sent_address`, `recipient_name`, `recipient_surname`, `sender_name`, `shipping_date`, `cargo_content`) VALUES
(1, '11', 'Kuruçeşme Mh.', 'Yaylacık Mh.', 'Erdoğan', 'Kayalı', 'Ceyda Yumurtaş', '01/01/2022', 'Kitap'),
(3, '2', 'Yaylacık Mh.', 'Selçuk Mh.', 'Erdoğan', 'Kayalı', 'Feridun Hisar', '01/01/2022', 'Oyuncak'),
(4, '2', 'Cumhuriyet Mh.', 'Selçuk Mh.', 'Emre', 'Ekim', 'Feridun Hisar', '01/01/2022', 'Tehlikeli Madde'),
(10, '2', 'Kuruçeşme Mh.', 'Dalaman', 'Erdoğan', 'Kayalı', 'Feridun Hisar', '05/31/2022', 'Gizli'),
(12, '23', 'İzmir Buca', 'İzmir Karabağlar', 'Ahmet', 'Taş', 'Bora Papila', '05/31/2022', 'Kitap'),
(13, '24', 'Mersin', 'İzmir Merkez', 'Fadime', 'Kaplan', 'Erdoğan Kayalı', '05/31/2022', 'Tablo'),
(14, '40', 'Mersin', 'İzmir Karadağlar', 'Fadime', 'Kaplan', 'Ceren Ersöz', '05/31/2022', 'Giysi');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `people`
--

CREATE TABLE `people` (
  `ID` int(11) NOT NULL,
  `address_id` varchar(5) COLLATE utf8_turkish_ci NOT NULL,
  `name` varchar(30) COLLATE utf8_turkish_ci NOT NULL,
  `surname` varchar(30) COLLATE utf8_turkish_ci NOT NULL,
  `type` varchar(11) COLLATE utf8_turkish_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  `email` varchar(30) COLLATE utf8_turkish_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `people`
--

INSERT INTO `people` (`ID`, `address_id`, `name`, `surname`, `type`, `phone`, `email`, `password`) VALUES
(1, '', 'admin', 'admin', '1', '', 'admin@gmail.com', 'admin'),
(2, '1', 'Feridun', 'Hisar', '2', '+905616123850', 'fhisar@gmail.com', 'fhisar'),
(3, '2', 'Ceylin', 'İylem', '2', '+905616176401', 'ceylinnn@outlook.com', 'ceylinnn'),
(4, '3', 'Şule', 'Alaoğlu', '2', '+905073682352', 'salaoglu@hotmail.com', 'salaoglu'),
(5, '4', 'Alperen', 'Taşkın', '3', '+905162450937', 'alperen_taskin@icloud.com', 'ataskin'),
(6, '5', 'Lara', 'Kemaloğlu', '3', '+905616103152', 'lara01@gmail.com', 'lara01'),
(7, '6', 'Aykan', 'Dinç', '2', '+905616125337', 'aykan_dinc@gmail.com', 'aykandinc'),
(8, '7', 'Ece', 'Sakarya', '2', '+905070635943', 'ece_sakarya@gmail.com', 'ecesakarya'),
(9, '8', 'Atahan', 'Özmen', '3', '+905616149393', 'atahan05@gmail.com', 'atahan05'),
(10, '9', 'Safa', 'Dündar', '3', '+905105436748', 'safa_dundar@gmail.com', 'safadundar'),
(11, '10', 'Ceyda', 'Yumurtaş', '2', '+905243549854', 'ceyda_yumurtas@gmail.com', 'ceydayumurtas'),
(12, '11', 'Ali', 'Kaya', '2', '+905326541234', 'alikaya@gmail.com', 'alikaya'),
(13, '12', 'Ömer', 'Bayrak', '3', '+905879651225', 'omerbayrak@gmail.com', 'omerbayrak'),
(14, '13', 'Ayşe', 'Gezgin', '3', '+905348525698', 'aysegezgin@gmail.com', 'agezgin'),
(23, '14', 'Bora', 'Papila', '2', '+905456852531', 'borapapila@gmail.com', '1234'),
(24, '15', 'Erdoğan', 'Kayalı', '2', '+905456852531', 'erdokyl@gmail.com', '1234'),
(28, '16', 'Fatih', 'Varol', '2', '+905057417660', 'fatih_varol@gmail.com', 'fvarol'),
(29, '17', 'Günver', 'Hançer', '2', '+905051103540', 'gunverhancer@icloud.com', 'ghancer'),
(30, '18', 'Gözde', 'Dal', '3', '+905558479414', 'gozdedal@gmail.com', 'gdal'),
(32, '19', 'Jale', 'Silgi', '2', '+905456548557', 'jsilgi@gmail.com', '1234'),
(33, '20', 'Jülide', 'Ata', '2', '+905555555555', 'jata@gmail.com', '1234'),
(34, '21', 'Mehmet', 'Kara', '2', '+905555555555', 'mkara@gmail.com', '1234'),
(40, '27', 'Ceren', 'Ersöz', '2', '+905496542132', 'cersoz@gmail.com', '1234'),
(42, '28', 'Polat', 'Alemdar', '2', '+905324956323', 'palem@gmail.com', 'palem');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`address_id`);

--
-- Tablo için indeksler `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`cargoID`);

--
-- Tablo için indeksler `people`
--
ALTER TABLE `people`
  ADD PRIMARY KEY (`ID`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `address`
--
ALTER TABLE `address`
  MODIFY `address_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Tablo için AUTO_INCREMENT değeri `cargo`
--
ALTER TABLE `cargo`
  MODIFY `cargoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Tablo için AUTO_INCREMENT değeri `people`
--
ALTER TABLE `people`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
