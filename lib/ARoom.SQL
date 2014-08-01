CREATE TABLE `AROOM_Info` (
  `itemNo` varchar(8) NOT NULL,
  `aNumber` varchar(11) NOT NULL,
  `Lot` varchar(8) NOT NULL,
  `dispersalBarCode` varchar(10) NOT NULL,
  `PositionX` varchar(1) NOT NULL,
  `PositionY` varchar(1) NOT NULL,
  PRIMARY KEY (`aNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;