# JavaEE 课设项目（Struts2+JSP+MySQL）

## 一、项目简介
本项目为JavaEE课程设计，采用Maven+Struts2+JSP+MySQL实现，包含注册、登录、退出、黑名单拦截、过滤器、文件上传、留言板、评价、排序、用户详细信息管理、登录日志记录等功能。页面美观，数据真实写入数据库，适合课设交付和二次部署。

## 二、技术栈说明
- **后端框架**：Struts2 2.5.x
- **前端页面**：JSP + CSS
- **数据库**：MySQL 8.x
- **依赖管理**：Maven
- **服务器**：Tomcat 9.x
- **开发工具**：IntelliJ IDEA

## 三、功能列表
### 基础功能
- 用户注册、登录、退出
- 登录过滤器（未登录不能访问主页）
- 黑名单拦截器（黑名单用户禁止登录）
- 文件上传（支持上传到webapp/uploads目录）

### 核心功能
- 留言板（支持留言、排序、持久化）
- 评价（支持评分、内容、排序、持久化）

### 新增功能
- **个人资料管理**：用户可以完善和修改个人详细信息（真实姓名、手机号码、地址等）
- **登录日志记录**：自动记录用户登录历史，包括登录时间、IP地址、设备信息、登录状态等
- **登录历史查看**：用户可以查看自己的登录记录，便于安全监控

### 页面特色
- 所有页面美观，入口清晰，响应式设计
- 主页分类导航（个人中心、功能模块）

## 四、数据库建表SQL
详见`db.sql`文件，包含5张表：
```sql
CREATE DATABASE IF NOT EXISTS struts2demo DEFAULT CHARSET utf8mb4;
USE struts2demo;

-- 用户基本信息表
CREATE TABLE IF NOT EXISTS user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL
);

-- 留言表
CREATE TABLE IF NOT EXISTS message (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  content TEXT NOT NULL,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 评价表
CREATE TABLE IF NOT EXISTS comment (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  score INT NOT NULL,
  content TEXT NOT NULL,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 用户详细信息表
CREATE TABLE IF NOT EXISTS user_profile (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  real_name VARCHAR(50),
  phone VARCHAR(20),
  address TEXT,
  avatar VARCHAR(200),
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE KEY unique_username (username)
);

-- 用户登录日志表
CREATE TABLE IF NOT EXISTS user_login_log (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  login_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  login_ip VARCHAR(50),
  login_device VARCHAR(500),
  status VARCHAR(20) DEFAULT 'SUCCESS'
);
```

## 五、IDEA导入、配置、运行详细步骤（适合小白）
1. **克隆项目**
   - 在GitHub新建仓库，上传本项目代码（见本README顶部操作指引）。
   - 也可直接下载zip解压。
2. **用IDEA打开项目根目录**
   - 选择"Open"或"导入项目"，选中`pom.xml`自动识别为Maven项目。
3. **配置Maven依赖**
   - IDEA右侧Maven面板点击"刷新"或`Reload All Maven Projects`，等待依赖下载完成。
4. **配置Tomcat**
   - IDEA菜单：`Run` -> `Edit Configurations` -> `Add New Configuration` -> `Tomcat Server` -> `Local`。
   - 选择本地Tomcat目录（建议Tomcat 9.x）。
   - 部署Artifact：选择`struts2demo:war exploded`。
5. **配置数据库**
   - 安装MySQL，创建数据库和表（可用`db.sql`一键导入）。
   - 默认数据库连接：`localhost:3306/struts2demo`，用户名`root`，密码`abc123`。
   - 如需修改，编辑`src/main/java/com/demo/javabean/DBAccess.java`中的连接信息。
6. **运行项目**
   - 启动Tomcat，浏览器访问`http://localhost:8080/struts2demo/`。
   - 首页自动跳转到登录页。
   - 注册新用户后可登录，体验所有功能。

## 六、功能使用说明
### 个人中心功能
1. **个人资料**：
   - 首次使用需要完善个人信息（真实姓名必填）
   - 支持修改真实姓名、手机号码、详细地址
   - 保存成功后会显示当前资料信息

2. **登录历史**：
   - 自动记录每次登录尝试（成功/失败）
   - 显示登录时间、IP地址、设备信息、登录状态
   - 最多显示最近20条记录

### 功能模块
1. **文件上传**：支持文件上传到webapp/uploads目录
2. **留言板**：支持发布留言，按时间排序（最新/最早）
3. **评价**：支持评分（1-5分）和评价内容，按评分排序（高/低）

## 七、常见问题与解决
- **依赖下载失败**：检查Maven配置，建议使用阿里云镜像。
- **500错误**：查看IDEA控制台红色报错，常见为数据库未启动、表未建、JSP标签属性错误（如`id`应改为`var`）。
- **数据库写入失败**：确认数据库连接信息、表结构、MySQL已启动。
- **页面打不开/404**：检查Tomcat部署路径、端口、项目名。
- **文件上传失败**：确认`webapp/uploads`目录存在且有写权限。
- **登录日志不显示**：确认user_login_log表已创建，DBAccess类已更新。

## 八、页面美化与交互说明
- 所有JSP页面均采用现代美观CSS，表单居中，按钮高亮，交互友好。
- 主页采用分类导航设计，个人中心和功能模块分开显示。
- 排序按钮用Struts2标签生成URL，切换排序后内容不丢失。
- 个人资料页面支持查看当前信息和修改功能。
- 登录历史页面采用表格展示，设备信息自动换行。

## 九、交付与部署到他人电脑注意事项
- 确保目标电脑已安装JDK 8+/11+、MySQL 8+、Tomcat 9+、IDEA（或Eclipse）。
- 数据库连接信息如有变动需同步修改源码。
- 使用`db.sql`文件一键创建所有必要的数据库表。
- 上传到GitHub后，建议在新环境完整测试一遍。
- 如遇问题，优先查看IDEA控制台和Tomcat日志，按本README排查。

## 十、项目亮点
1. **功能完整**：涵盖用户管理、内容管理、日志记录等多个模块
2. **技术规范**：采用MVC架构，代码结构清晰，易于维护
3. **安全考虑**：黑名单拦截、登录过滤、登录日志记录
4. **用户体验**：界面美观、操作简便、反馈及时
5. **扩展性强**：模块化设计，便于添加新功能

---

如有更多问题，欢迎联系本项目开发者！

