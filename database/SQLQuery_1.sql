-- CREATE DATABASE management

-- CREATE TABLE Users
-- (
-- CitizenID NVARCHAR(10) PRIMARY KEY NOT NULL,
-- [Name] NVARCHAR(225) CHECK([Name] NOT LIKE '%[0-9.]%') NOT NULL,
-- Gender NVARCHAR(6) DEFAULT 'M' CHECK([Gender] IN ('M', 'F', 'Others')) NOT NULL,
-- Phone_Num Nvarchar(11) CHECK(Phone_Num LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' or [Phone_Num] like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,
-- House_Num NVARCHAR(20) NOT NULL,
-- Street_Or_Alley_Name NVARCHAR(225) NOT NULL,
-- Commune NVARCHAR(225) NOT NULL,
-- Dob DATE CHECK(Dob <= getDate()) NOT NULL
-- )

-- CREATE TABLE Boarding_House
-- (
-- Id NVARCHAR(10) PRIMARY KEY NOT NULL,
-- UserID NVARCHAR(10) FOREIGN KEY REFERENCES Users(CitizenID),
-- [Name] NVARCHAR(225) CHECK([Name] NOT LIKE '%[0-9.]%') NOT NULL,
-- Name_Of_Owner NVARCHAR(225) CHECK([Name_Of_Owner] NOT LIKE '%[0-9.]%') NOT NULL,
-- Phone_Num Nvarchar(11) CHECK(Phone_Num LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' or [Phone_Num] like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,
-- House_Num NVARCHAR(20) NOT NULL,
-- Street_Or_Alley_Name NVARCHAR(225) NOT NULL,
-- Commune NVARCHAR(225) NOT NULL
-- )

-- CREATE TABLE Type_Of_BoardingHouse
-- (
--     Code NVARCHAR(10) PRIMARY KEY NOT NULL,
--     [Type] NVARCHAR(225) NOT NULL,
--     [Price] NVARCHAR(10) CHECK(Price like '%[0-9.]%') NOT NULL
-- )

-- CREATE TABLE BH_Type (
--     BoardingHouseId NVARCHAR(10) FOREIGN KEY REFERENCES Boarding_House(Id),
--     TypeCode NVARCHAR(10) FOREIGN KEY REFERENCES Type_Of_BoardingHouse(Code)
-- )

-- CREATE TABLE Eatery
-- (
--     Id NVARCHAR(10) PRIMARY KEY NOT NULL,
--     UserID NVARCHAR(10) FOREIGN KEY REFERENCES Users(CitizenID),
--     [Name] NVARCHAR(225) CHECK([Name] NOT LIKE '%[0-9.]%') NOT NULL,
--     Name_Of_Owner NVARCHAR(225) CHECK([Name_Of_Owner] NOT LIKE '%[0-9.]%') NOT NULL,
--     Phone_Num Nvarchar(11) CHECK(Phone_Num LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' or [Phone_Num] like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,
--     House_Num NVARCHAR(20) NOT NULL,
--     Street_Or_Alley_Name NVARCHAR(225) NOT NULL,
--     Commune NVARCHAR(225) NOT NULL
-- )

-- CREATE TABLE Menu_Of_Eatery
-- (
--     Code NVARCHAR(10) PRIMARY KEY NOT NULL,
--     [Name] NVARCHAR(225) CHECK([Name] NOT LIKE '%[0-9.]%') NOT NULL,
--     [Price] NVARCHAR(10) CHECK(Price like '%[0-9.]%') NOT NULL
-- )

-- CREATE TABLE Eatery_Menu (
--     EateryID NVARCHAR(10) FOREIGN KEY REFERENCES Eatery(Id),
--     MenuCode NVARCHAR(10) FOREIGN KEY REFERENCES Menu_Of_Eatery(Code)
-- )

-- CREATE TABLE Grocery (
--     Id NVARCHAR(10) PRIMARY KEY NOT NULL,
--     UserID NVARCHAR(10) FOREIGN KEY REFERENCES Users(CitizenID),
--     [Name] NVARCHAR(225) CHECK([Name] NOT LIKE '%[0-9.]%') NOT NULL,
--     Name_Of_Owner NVARCHAR(225) CHECK([Name_Of_Owner] NOT LIKE '%[0-9.]%') NOT NULL,
--     Phone_Num Nvarchar(11) CHECK(Phone_Num LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' or [Phone_Num] like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,
--     House_Num NVARCHAR(20) NOT NULL,
--     Street_Or_Alley_Name NVARCHAR(225) NOT NULL,
--     Commune NVARCHAR(225) NOT NULL
-- )

-- CREATE TABLE Menu_Of_Grocery (
--     Code NVARCHAR(10) PRIMARY KEY NOT NULL,    
--     [Name] NVARCHAR(225) CHECK([Name] NOT LIKE '%[0-9.]%') NOT NULL,
--     [Price] NVARCHAR(10) CHECK(Price like '%[0-9.]%') NOT NULL
-- )

-- CREATE TABLE Grocery_Menu (
--     GroceryID NVARCHAR(10) FOREIGN KEY REFERENCES Grocery(Id),
--     MenuCode NVARCHAR(10) FOREIGN KEY REFERENCES Menu_Of_Grocery(Code)
-- )

-- CREATE TABLE Entertainment (
--     Id NVARCHAR(10) PRIMARY KEY NOT NULL,
--     UserID NVARCHAR(10) FOREIGN KEY REFERENCES Users(CitizenID),
--     [Name] NVARCHAR(225) CHECK([Name] NOT LIKE '%[0-9.]%') NOT NULL,
--     Name_Of_Owner NVARCHAR(225) CHECK([Name_Of_Owner] NOT LIKE '%[0-9.]%') NOT NULL,
--     Phone_Num Nvarchar(11) CHECK(Phone_Num LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' or [Phone_Num] like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,
--     House_Num NVARCHAR(20) NOT NULL,
--     Street_Or_Alley_Name NVARCHAR(225) NOT NULL,
--     Commune NVARCHAR(225) NOT NULL,
--     ServiceType NVARCHAR(225) NOT NULL
-- )

-- CREATE TABLE Orders (    
--     UserID NVARCHAR(10) FOREIGN KEY REFERENCES Users(CitizenID),
--     EateryID NVARCHAR(10) FOREIGN KEY REFERENCES Eatery(Id),
--     GroceryID NVARCHAR(10) FOREIGN KEY REFERENCES Grocery(Id)
-- )

-- CREATE TABLE Transportation (
--     Id NVARCHAR(10) PRIMARY KEY NOT NULL,
--     UserID NVARCHAR(10) FOREIGN KEY REFERENCES Users(CitizenID),
--     [Type] NVARCHAR(225) NOT NULL,
--     [Name_Or_TripNumber] NVARCHAR(255) NOT NULL,
--     Rout NVARCHAR(255) NOT NULL,
--     [Price] NVARCHAR(10) CHECK(Price like '%[0-9.]%') NOT NULL,
--     [Status] NVARCHAR(255) DEFAULT N'Còn chỗ' CHECK([Status] in (N'Còn chỗ', N'Hết chỗ')) NOT NULL 
-- )

-- INSERT Into Users
--     (CitizenID, Name, Gender, Phone_Num, House_Num, Street_Or_Alley_Name, Commune, Dob)
-- VALUES
--     ('AB1234567', N'Nguyễn Văn A', 'M', '0123456789', '123A', N'Đường Lê Lợi', N'Xã Thạch Hòa', '1990-05-15'),
--     ('CD9876543', N'Trần Thị B', 'F', '0987654321', '456B', N'Ngõ Hà Nội', N'Xã Bình Yên', '1990-05-15'),
--     ('EF5432198', N'Lê Quang C', 'Others', '0765432109', '789C', N'Phố Trần Phú', N'Xã Thạch Hòa', '1990-05-15'),
--     ('GH8765432', N'Phạm Thị D', 'F', '0345678901', '101D', N'Đường Hùng Vương', N'Xã Bình Yên', '1990-05-15'),
--     ('IJ2345678', N'Vũ Văn E', 'M', '0567890123', '202E', N'Ngõ Trần Khát Chân', N'Xã Tân Xã', '1990-05-15'),
--     ('KL7654321', N'Hoàng Thị F', 'F', '0234567890', '303F', N'Phố Lê Duẩn', N'Xã Hạ Bằng', '1990-05-15'),
--     ('MN3456789', N'Ngô Quang G', 'M', '0456789012', '404G', N'Đường Trường Chinh', N'Xã Thạch Hòa', '1990-05-15'),
--     ('OP6543210', N'Đặng Thị H', 'F', '0678901234', '505H', N'Ngõ Nguyễn Chí Thanh', N'Xã Thạch Hòa', '1990-05-15'),
--     ('QR4321098', N'Trịnh Văn I', 'M', '0789012345', '606I', N'Phố Lý Thường Kiệt', N'Xã Hạ Bằng', '1990-05-15'),
--     ('ST2109876', N'Lý Thị K', 'Others', '0890123456', '707K', N'Đường Nguyễn Văn Linh', N'Xã Tân Xã', '1990-05-15');

-- INSERT Into Boarding_House
--     (Id, UserID, Name, Name_Of_Owner, Phone_Num, House_Num, Street_Or_Alley_Name, Commune)
-- VALUES
--     ('AA1234567', 'CD9876543',N'Tuấn Yên', N'', '0912326327', '255', N'Đường Phan Châu Trinh', N'Xã Hạ Bằn'),
--     ('BB9876543', 'EF5432198',N'Ông Bà', N'', '0912797289', '1a', N'Ngõ 11c', N'Xã Tân Xã'),
--     ('CC5432198', 'GH8765432',N'Happy', N'', '0912556778', '20c', N'Phố Trần Nhân Tông', N'Xã Thạch Hòa'),
--     ('DD8765432', 'IJ2345678',N'', N' Anh Cò', '0912555667', '232b', N'Đường Hùng Vương', N'Xã Bình Yên'),
--     ('EE2345678', 'KL7654321',N'', N'Hòa Lạc An Motel', '0322145678', '221b', N'Ngõ 23', N'Xã Xã Hạ Bằng'),
--     ('FF7654321', 'MN3456789',N'', N'Mig Motel', '0948123456', '201a', N'Phố Nguyễn Thị Minh Khai', N'Xã Tân Xã'),
--     ('GG3456789', 'OP6543210',N'', N'Hòa Lạc Motel', '0912444567', '15a', N'Đường Trường Chinh', N'Xã Thạch Hòa'),
--     ('HH6543210', 'QR4321098',N'', N'Bình Yên', '0948551456', '30b', N'Ngõ 61', N'Xã Bình Yên'),
--     ('II4321098', 'ST2109876',N'', N'Long Vũ', '0912345999', '44a', N'Phố Vị Xuyên', N'Xã Hạ Bằng'),
--     ('KK2109876', 'AB1234567',N'', N'Ngọc My', '0949278203', '12', N'Đường Trần Nhật Duật', N'Xã Tân Xã');


-- drop table transportation
-- drop table Boarding_House
-- drop table Type_Of_BoardingHouse
-- drop table Entertainment
-- drop table Menu_Of_Eatery
-- drop table Menu_Of_Grocery
-- drop table Order_Of_Eatery
-- drop table Order_Of_Grocery
-- drop table Grocery
-- drop table Eatery
-- drop table Users
