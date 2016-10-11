# admin
通用后台管理
web样式参照：
http://keenthemes.com/preview/metronic/theme/admin_1/index.html

sql文件：
/admin-web/src/main/webapp/admin.sql
/admin-web/src/main/webapp/city.sql
/admin-web/src/main/webapp/county.sql
/admin-web/src/main/webapp/province.sql
/admin-web/src/main/webapp/icon.sql

metronic开发参考文件：
http://www.cnblogs.com/wuhuacong/p/4757984.html

项目部署方法:
1,在mysql上执行admin.sql,city.sql,county.sql,province.sql文件初始化项目所需基础表
2,更改mysql数据库连接/admin-web/src/main/resources/filters下的配置文件
3,maven选定项目运行环境(filters文件夹)
4,启动tomcat部署war