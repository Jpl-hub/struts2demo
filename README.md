# JavaEE 课设项目（Struts2+JSP+MySQL）

## 一、项目简介
本项目为JavaEE课程小作业，采用Maven+Struts2+JSP+MySQL实现，包含注册、登录、退出、黑名单拦截、过滤器、文件上传、留言板、评价、排序等功能。页面美观，数据真实写入数据库，适合课设交付和二次部署。

## 二、技术栈说明
- **后端框架**：Struts2 2.5.x
- **前端页面**：JSP + CSS
- **数据库**：MySQL 8.x
- **依赖管理**：Maven
- **服务器**：Tomcat 9.x
- **开发工具**：IntelliJ IDEA

## 三、功能列表
- 用户注册、登录、退出
- 登录过滤器（未登录不能访问主页）
- 黑名单拦截器（黑名单用户禁止登录）
- 文件上传（支持上传到webapp/uploads目录）
- 留言板（支持留言、排序、持久化）
- 评价（支持评分、内容、排序、持久化）
- 所有页面美观，入口清晰

## 四、数据库建表SQL
详见`db.sql`文件，或参考下方：
```sql
CREATE DATABASE IF NOT EXISTS struts2demo DEFAULT CHARSET utf8mb4;
USE struts2demo;

CREATE TABLE IF NOT EXISTS user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS message (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  content TEXT NOT NULL,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS comment (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  score INT NOT NULL,
  content TEXT NOT NULL,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
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
   - 如需修改，编辑`src/main/java/com/demo/dao/MessageDao.java`、`CommentDao.java`、`javabean/DBAccess.java`等文件中的连接信息。
6. **运行项目**
   - 启动Tomcat，浏览器访问`http://localhost:8080/struts2demo/`。
   - 首页自动跳转到登录页。
   - 注册新用户后可登录，体验所有功能。

## 六、常见问题与解决
- **依赖下载失败**：检查Maven配置，建议使用阿里云镜像。
- **500错误**：查看IDEA控制台红色报错，常见为数据库未启动、表未建、JSP标签属性错误（如`id`应改为`var`）。
- **数据库写入失败**：确认数据库连接信息、表结构、MySQL已启动。
- **页面打不开/404**：检查Tomcat部署路径、端口、项目名。
- **文件上传失败**：确认`webapp/uploads`目录存在且有写权限。

## 七、页面美化与交互说明
- 所有JSP页面均采用现代美观CSS，表单居中，按钮高亮，交互友好。
- 首页、注册、登录、留言板、评价、文件上传等页面入口清晰。
- 排序按钮用Struts2标签生成URL，切换排序后内容不丢失。

## 八、交付与部署到他人电脑注意事项
- 确保目标电脑已安装JDK 8+/11+、MySQL 8+、Tomcat 9+、IDEA（或Eclipse）。
- 数据库连接信息如有变动需同步修改源码。
- 上传到GitHub后，建议在新环境完整测试一遍。
- 如遇问题，优先查看IDEA控制台和Tomcat日志，按本README排查。

---

如有更多问题，欢迎联系本项目开发者！ 