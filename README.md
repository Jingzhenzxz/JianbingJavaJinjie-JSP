# 使用 JSP+Servlet+MySQL(Tomcat)技术实现的一个简易的能实现登录与注册功能的网页

## 创建数据库表

打开MySQL客户端，输入用户名和密码，执行下述语句：

```mysql
-- 创建数据库
CREATE DATABASE IF NOT EXISTS jianbingjavausersystemweb DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- 使用数据库
USE jianbingjavausersystemweb;

-- 创建 users 数据表
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```

## 运行程序

在项目的根目录中利用 mvn clean package 进行打包（也可以在 IDEA 中点击 Maven 插件中的 package 生命周期进行打包），把打包后的 UserSystemWeb.war 复制到
Tomcat 文件夹中的 webapps 目录下，然后双击 Tomcat 目录中的 bin 目录中的 startup.bat 文件运行 Tomcat。然后就可以访问 http://localhost:8080/UserSystemWeb/login
了。（Tomcat 默认运行在 8080 端口上）