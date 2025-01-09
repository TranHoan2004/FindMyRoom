USE [master]
GO
/****** Object:  Database [FindMyRoom]    Script Date: 1/9/2025 9:21:32 AM ******/
CREATE DATABASE [FindMyRoom]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'FindMyRoom', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\FindMyRoom.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'FindMyRoom_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\FindMyRoom_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [FindMyRoom] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [FindMyRoom].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [FindMyRoom] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [FindMyRoom] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [FindMyRoom] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [FindMyRoom] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [FindMyRoom] SET ARITHABORT OFF 
GO
ALTER DATABASE [FindMyRoom] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [FindMyRoom] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [FindMyRoom] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [FindMyRoom] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [FindMyRoom] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [FindMyRoom] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [FindMyRoom] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [FindMyRoom] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [FindMyRoom] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [FindMyRoom] SET  ENABLE_BROKER 
GO
ALTER DATABASE [FindMyRoom] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [FindMyRoom] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [FindMyRoom] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [FindMyRoom] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [FindMyRoom] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [FindMyRoom] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [FindMyRoom] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [FindMyRoom] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [FindMyRoom] SET  MULTI_USER 
GO
ALTER DATABASE [FindMyRoom] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [FindMyRoom] SET DB_CHAINING OFF 
GO
ALTER DATABASE [FindMyRoom] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [FindMyRoom] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [FindMyRoom] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [FindMyRoom] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [FindMyRoom] SET QUERY_STORE = ON
GO
ALTER DATABASE [FindMyRoom] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [FindMyRoom]
GO
/****** Object:  Table [dbo].[admin]    Script Date: 1/9/2025 9:21:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[admin](
	[admin_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[admin_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[boarding_house]    Script Date: 1/9/2025 9:21:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[boarding_house](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[address] [varchar](255) NOT NULL,
	[area] [int] NOT NULL,
	[available_room] [varchar](max) NULL,
	[number_of_rented_rooms] [int] NOT NULL,
	[special_items] [varchar](max) NULL,
	[total_rooms] [int] NOT NULL,
	[type] [varchar](255) NOT NULL,
	[business_id] [bigint] NULL,
	[star] [int] NOT NULL,
	[media] [varchar](max) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[booking]    Script Date: 1/9/2025 9:21:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[booking](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[booking_date] [date] NULL,
	[house_id] [bigint] NULL,
	[user_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[business]    Script Date: 1/9/2025 9:21:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[business](
	[balance] [real] NOT NULL,
	[permission_number] [varchar](20) NOT NULL,
	[user_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cart]    Script Date: 1/9/2025 9:21:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cart](
	[size] [int] NOT NULL,
	[user_id] [bigint] NOT NULL,
	[post_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[employee]    Script Date: 1/9/2025 9:21:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[employee](
	[employee_id] [bigint] NOT NULL,
	[admin_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[employee_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[post]    Script Date: 1/9/2025 9:21:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[post](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[address] [varchar](255) NOT NULL,
	[content] [varchar](255) NOT NULL,
	[created_date] [date] NULL,
	[media] [varchar](max) NULL,
	[special_items] [varchar](255) NOT NULL,
	[status] [bit] NOT NULL,
	[thumbnai_url] [varbinary](max) NULL,
	[title] [varchar](255) NOT NULL,
	[view_count] [bigint] NOT NULL,
	[business_id] [bigint] NULL,
	[cart_id] [bigint] NULL,
	[user_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[review]    Script Date: 1/9/2025 9:21:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[review](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[content] [varchar](255) NOT NULL,
	[created_date] [date] NULL,
	[house_id] [bigint] NULL,
	[author_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[service]    Script Date: 1/9/2025 9:21:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[service](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[content] [varchar](255) NOT NULL,
	[end_date] [date] NULL,
	[name] [varchar](255) NOT NULL,
	[price] [real] NOT NULL,
	[sale_price] [real] NULL,
	[sold_quantity] [int] NOT NULL,
	[start_date] [date] NULL,
	[admin_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[slider]    Script Date: 1/9/2025 9:21:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[slider](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[image_url] [varbinary](max) NULL,
	[status] [bit] NOT NULL,
	[author_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 1/9/2025 9:21:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[created_date] [date] NULL,
	[email] [varchar](30) NOT NULL,
	[fullname] [varchar](255) NULL,
	[gender] [bit] NULL,
	[image_url] [varbinary](max) NULL,
	[password] [varchar](255) NOT NULL,
	[phone_number] [varchar](255) NOT NULL,
	[status] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[boarding_house] ADD  DEFAULT ((0)) FOR [star]
GO
ALTER TABLE [dbo].[post] ADD  DEFAULT ((0)) FOR [view_count]
GO
ALTER TABLE [dbo].[service] ADD  DEFAULT ((0)) FOR [sold_quantity]
GO
ALTER TABLE [dbo].[admin]  WITH CHECK ADD  CONSTRAINT [FK5wu7m4u6dii7801jnfs4xqvfu] FOREIGN KEY([admin_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[admin] CHECK CONSTRAINT [FK5wu7m4u6dii7801jnfs4xqvfu]
GO
ALTER TABLE [dbo].[boarding_house]  WITH CHECK ADD  CONSTRAINT [FK6n6ew9e2it77eqrx7r0q5d58i] FOREIGN KEY([business_id])
REFERENCES [dbo].[business] ([user_id])
GO
ALTER TABLE [dbo].[boarding_house] CHECK CONSTRAINT [FK6n6ew9e2it77eqrx7r0q5d58i]
GO
ALTER TABLE [dbo].[booking]  WITH CHECK ADD  CONSTRAINT [FK6j63xgpmbcmbbmc2mll0jr2dl] FOREIGN KEY([house_id])
REFERENCES [dbo].[boarding_house] ([id])
GO
ALTER TABLE [dbo].[booking] CHECK CONSTRAINT [FK6j63xgpmbcmbbmc2mll0jr2dl]
GO
ALTER TABLE [dbo].[booking]  WITH CHECK ADD  CONSTRAINT [FK7udbel7q86k041591kj6lfmvw] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[booking] CHECK CONSTRAINT [FK7udbel7q86k041591kj6lfmvw]
GO
ALTER TABLE [dbo].[business]  WITH CHECK ADD  CONSTRAINT [FKtm7f6x8bo3o8pk2kraawyq18u] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[business] CHECK CONSTRAINT [FKtm7f6x8bo3o8pk2kraawyq18u]
GO
ALTER TABLE [dbo].[cart]  WITH CHECK ADD  CONSTRAINT [FKg5uhi8vpsuy0lgloxk2h4w5o6] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[cart] CHECK CONSTRAINT [FKg5uhi8vpsuy0lgloxk2h4w5o6]
GO
ALTER TABLE [dbo].[cart]  WITH CHECK ADD  CONSTRAINT [FKja4r135g12e4pvv1xl17s19l2] FOREIGN KEY([post_id])
REFERENCES [dbo].[post] ([id])
GO
ALTER TABLE [dbo].[cart] CHECK CONSTRAINT [FKja4r135g12e4pvv1xl17s19l2]
GO
ALTER TABLE [dbo].[employee]  WITH CHECK ADD  CONSTRAINT [FK1tlwbsan0praxhnixgo3i2js4] FOREIGN KEY([admin_id])
REFERENCES [dbo].[admin] ([admin_id])
GO
ALTER TABLE [dbo].[employee] CHECK CONSTRAINT [FK1tlwbsan0praxhnixgo3i2js4]
GO
ALTER TABLE [dbo].[employee]  WITH CHECK ADD  CONSTRAINT [FK7oa45fd2yfp32wxpx7s1ssllw] FOREIGN KEY([employee_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[employee] CHECK CONSTRAINT [FK7oa45fd2yfp32wxpx7s1ssllw]
GO
ALTER TABLE [dbo].[post]  WITH CHECK ADD  CONSTRAINT [FK7ky67sgi7k0ayf22652f7763r] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[post] CHECK CONSTRAINT [FK7ky67sgi7k0ayf22652f7763r]
GO
ALTER TABLE [dbo].[post]  WITH CHECK ADD  CONSTRAINT [FK7wme1kqwojip4cofh951p4lnk] FOREIGN KEY([cart_id])
REFERENCES [dbo].[cart] ([user_id])
GO
ALTER TABLE [dbo].[post] CHECK CONSTRAINT [FK7wme1kqwojip4cofh951p4lnk]
GO
ALTER TABLE [dbo].[post]  WITH CHECK ADD  CONSTRAINT [FKsisx1ooe39b84fe1fruhtdaxc] FOREIGN KEY([business_id])
REFERENCES [dbo].[business] ([user_id])
GO
ALTER TABLE [dbo].[post] CHECK CONSTRAINT [FKsisx1ooe39b84fe1fruhtdaxc]
GO
ALTER TABLE [dbo].[review]  WITH CHECK ADD  CONSTRAINT [FK9o91rotu09ywxerf1evksnxhd] FOREIGN KEY([author_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[review] CHECK CONSTRAINT [FK9o91rotu09ywxerf1evksnxhd]
GO
ALTER TABLE [dbo].[review]  WITH CHECK ADD  CONSTRAINT [FKrqlaurwq7xgljeh2tgrltbcpa] FOREIGN KEY([house_id])
REFERENCES [dbo].[boarding_house] ([id])
GO
ALTER TABLE [dbo].[review] CHECK CONSTRAINT [FKrqlaurwq7xgljeh2tgrltbcpa]
GO
ALTER TABLE [dbo].[service]  WITH CHECK ADD  CONSTRAINT [FK31t5g7sj6nqcmonyp4eou3dsg] FOREIGN KEY([admin_id])
REFERENCES [dbo].[admin] ([admin_id])
GO
ALTER TABLE [dbo].[service] CHECK CONSTRAINT [FK31t5g7sj6nqcmonyp4eou3dsg]
GO
ALTER TABLE [dbo].[slider]  WITH CHECK ADD  CONSTRAINT [FKtb29ntt9rmyfihev71r6p3gk0] FOREIGN KEY([author_id])
REFERENCES [dbo].[employee] ([employee_id])
GO
ALTER TABLE [dbo].[slider] CHECK CONSTRAINT [FKtb29ntt9rmyfihev71r6p3gk0]
GO
ALTER TABLE [dbo].[boarding_house]  WITH CHECK ADD CHECK  (([type]='Has_Mezzanine' OR [type]='Single'))
GO
USE [master]
GO
ALTER DATABASE [FindMyRoom] SET  READ_WRITE 
GO
