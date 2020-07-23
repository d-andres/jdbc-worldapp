use WorldApp;

create table Country(
	CountryId int auto_increment primary key,
    CountryName varchar(50),
    Population int,
    CityId int NOT NULL
);
ALTER TABLE `WorldApp`.`Country` 
ADD UNIQUE INDEX `CityId_UNIQUE` (`CityId` ASC) VISIBLE;

create table City(
	CityId int,
    CityName varchar(50),
    isCapital varchar(1),
    foreign key (CityId) references Country(CityId)
);

insert into Country(CountryName, Population, CityId) values
	('United States of America', 331002651, 1),
	('Cuba', 11326616, 2),
    ('Dominican Republic', 10847910, 3),
    ('Mexico', 128932753, 4),
    ('Argentina', 45195774, 5);
insert into City(CityId, CityName, isCapital) values 
	('1', 'Houston', 'N'),
    ('1', 'Austin', 'Y'),
	('2', 'Havana', 'Y'),
    ('3', 'Santo Domingo', 'Y'),
    ('4', 'Tijuana', 'N'),
    ('4', 'Cancun', 'N'),
    ('5', 'Buenos Aires', 'Y');
