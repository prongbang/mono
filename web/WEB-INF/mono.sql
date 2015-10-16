USE [mono]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 10/16/2015 2:37:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[user_id] [int] NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Users]    Script Date: 10/16/2015 2:37:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[id] [int] NOT NULL,
	[name] [nvarchar](50) NULL,
	[surname] [nvarchar](50) NULL
) ON [PRIMARY]

GO

INSERT INTO [dbo].[Account]
           ([username]
           ,[password]
           ,[user_id])
     VALUES
           ('prongbang' ,'1111',1),('user' ,'2222',2)
GO 
