USE [master]
GO
CREATE DATABASE [MyContact]
GO
USE [MyContact]
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[phone] [varchar](15) NOT NULL,
)
GO
INSERT INTO users (username, phone) VALUES (N'Huynh Huu Binh', '0123456789')
INSERT INTO users (username, phone) VALUES (N'Nguyen Huy Linh', '0123456789')