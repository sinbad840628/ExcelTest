CREATE TABLE `ChemPartner` (
  `cPNumber` varchar(5) NOT NULL,
  `VialCode` varchar(8) NOT NULL,
  `volume` varchar(6) NOT NULL,
  `PositionX` varchar(1) NOT NULL,
  `PositionY` varchar(1) NOT NULL,
   `ANumber` varchar(11) NOT NULL,
  `Lot` varchar(8) NOT NULL,
  PRIMARY KEY (`aNumber`,`VialCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;