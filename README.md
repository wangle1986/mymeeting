# mymeeting项目简介

# mymeeting项目是使用springboot2.0作为底层框架来搭建项目的，为了实现前后端分离、微服务架构等。
# mymeeting加入了sock.js，用于实现websocket的实时通讯，当浏览器不支持H5时，代码自动可以切换成http ajax来实现。
       具体访问地址：http://localhost:8081/mymeeting/static/index.html
# mymeeting加入了apache shiro框架，用于控制具体某个功能点的用户权限，当然大菜单的权限，还是从数据库中直接获取即可。
# apache shiro还可以管理会话，对于哪些地址直接通过，哪些必须登录后访问等等。    
       输入项目地址访问会自动跳到login界面，登录后，再访问其他需要认证的界面（手动输入地址），比如上面的sock通讯界面。
# mymeeting加入logback日志，可以在测试、开发和生产环境下配置不同级别、不同输出地方的日志。 
# 使用bootstrap前端框架美化登录界面
