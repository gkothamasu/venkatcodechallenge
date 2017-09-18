--Create a table as mentioned below in the Mysql DB

CREATE TABLE `dog_breed` (
  `ID` int(11) NOT NULL,
  `DOG_NAME` varchar(45) DEFAULT NULL,
  `DOG_DETAIL` varchar(45) DEFAULT NULL,
  `IAMGE_URL` varchar(45) DEFAULT NULL,
  `DOG_BREED` varchar(45) NOT NULL,
  `FAV_COUNT` int(11) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Sample data to be inserted to execute

insert into dogbreed.dog_breed values(1,"Niki","details","url","Akita",3);
insert into dogbreed.dog_breed values(2,"Miki","details","url","Beagle",6);
insert into dogbreed.dog_breed values(3,"cool","details","url","Beagle",1);
insert into dogbreed.dog_breed values(4,"pup","details","url","Golden Retriever",1);
insert into dogbreed.dog_breed values(5,"nine","details","url","Dachshund",1);
insert into dogbreed.dog_breed values(6,"Hike","details6","url","Beagle",1);
commit;

select * from dogbreed.dog_breed