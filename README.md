# 这是一个微信小程序的Java后端服务器项目
### [微信小程序开发: 2024-10-09]
## 项目介绍
> 本项目是一个微信小程序的Java后端服务器，用于给微信小程序提供数据服务，包括用户注册、登录、数据查询、数据更新，以及最重要的图像识别功能。
>> 该项目使用Spring Boot框架，并使用了MySQL数据库作为数据存储，完整项目的全部源码已上传至GitHub。

#### 完整的项目包括:
* 一个微信小程序前端
* 一个Vue3前端服务器
* 一个Java后端服务器
* 一个Python后端服务器
* （所有项目仓库都已上传到GitHub）

#### 项目架构：
<img src="https://github.com/DarkOpalBasil/weapp-cornleaf/blob/main/image/preview/liuchengtu.png" width="1200px">

#### 所需环境：
* Java 17
* Spring Boot 3.2.5
* MySQL 8.4
* Python 3.11
* Vue3
* 调试基础库 2.26.2
* wx-server-sdk 2.6.3

#### 所需外部支持：
* 腾讯云轻量级服务器 ECS
* 阿里云对象存储服务 OSS
* 域名注册
* 域名解析
* ICP备案
* SSL证书签发部署
* 微信开发者注册

## 项目结构：
```
.
├── .gitignore
├── .idea/
├── db/
│   └── wx.sql
├── docker-compose.yml
├── wx-admin/
│   ├── Dockerfile
│   ├── pom.xml
│   ├── src/
│   │   └── main/
│   └── target/
│       ├── classes/
│       └── generated-sources/
├── wx-common/
│   ├── pom.xml
│   ├── src/
│   │   └── main/
│   └── target/
│       ├── classes/
│       └── generated-sources/
├── wx-mbg/
│   ├── pom.xml
│   ├── src/
│   │   └── main/
│   └── target/
│       ├── classes/
│       └── generated-sources/
├── wx-portal/
│   ├── Dockerfile
│   ├── pom.xml
│   ├── src/
│   │   └── main/
│   └── target/
│       ├── classes/
│       └── generated-sources/
├── pom.xml
├── README.md
├── wx-admin.iml
└── wx-portal.iml
```

## 使用说明
> 微信搜索 “玉黍助农-玉米叶部病变识别” 获取小程序体验版
> 
> <img src="https://github.com/DarkOpalBasil/weapp-cornleaf/blob/main/image/weapplogo.png" width="50px">玉黍助农

## 项目其他仓库
* [微信小程序前端](https://github.com/DarkOpalBasil/weapp-cornleaf)
* [Vue3前端服务器](https://github.com/DarkOpalBasil/weapp-admin)
* [Python后端服务器](https://github.com/DarkOpalBasil/pytorch-resnet152)
* [Java后端服务器](https://github.com/DarkOpalBasil/wx-java-service)


---

English version:
# This a Java Service for the WeChat Mini Program
### [WeChat Mini Program: 2024-10-09]
## Project Introduction
> This project is a Java backend server for a WeChat Mini Program, providing data services including user registration, login, data query, data update, and the most important image recognition function.
>> The project uses the Spring Boot framework and MySQL as the data storage. The complete source code of the project has been uploaded to GitHub.

#### The complete project includes:
* A WeChat Mini Program frontend
* A Vue3 frontend server
* A Java backend server
* A Python backend server
* (All project repositories have been uploaded to GitHub)

#### Project Architecture:
<img src="https://github.com/DarkOpalBasil/weapp-cornleaf/blob/main/image/preview/liuchengtu.png" width="1200px">

#### Required Environment:
* Java 17
* Spring Boot 3.2.5
* MySQL 8.4
* Python 3.11
* Vue3
* Debugging Base Library 2.26.2
* wx-server-sdk 2.6.3

#### Required External Support:
* Tencent Cloud Lightweight Server ECS
* Alibaba Cloud Object Storage Service OSS
* Domain Registration
* Domain Resolution
* ICP Filing
* SSL Certificate Issuance and Deployment
* WeChat Developer Registration

## Project Structure:
```
.
├── .gitignore
├── .idea/
├── db/
│   └── wx.sql
├── docker-compose.yml
├── wx-admin/
│   ├── Dockerfile
│   ├── pom.xml
│   ├── src/
│   │   └── main/
│   └── target/
│       ├── classes/
│       └── generated-sources/
├── wx-common/
│   ├── pom.xml
│   ├── src/
│   │   └── main/
│   └── target/
│       ├── classes/
│       └── generated-sources/
├── wx-mbg/
│   ├── pom.xml
│   ├── src/
│   │   └── main/
│   └── target/
│       ├── classes/
│       └── generated-sources/
├── wx-portal/
│   ├── Dockerfile
│   ├── pom.xml
│   ├── src/
│   │   └── main/
│   └── target/
│       ├── classes/
│       └── generated-sources/
├── pom.xml
├── README.md
├── wx-admin.iml
└── wx-portal.iml
```

## Usage Instructions
> Search for "玉黍助农-玉米叶部病变识别" on WeChat to get the Mini Program trial version
>
> <img src="https://github.com/DarkOpalBasil/weapp-cornleaf/blob/main/image/weapplogo.png" width="100px">玉黍助农

## Other Project Repositories
* [WeChat Mini Program Frontend](https://github.com/DarkOpalBasil/weapp-cornleaf)
* [Vue3 Frontend Server](https://github.com/DarkOpalBasil/weapp-admin)
* [Python Backend Server](https://github.com/DarkOpalBasil/pytorch-resnet152)
* [Java Backend Server](https://github.com/DarkOpalBasil/wx-java-service)