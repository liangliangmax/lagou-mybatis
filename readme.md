# 项目简介
本项目是mybatis原理的简单模拟实现（对应拉钩教程的第一章）

## 主要实现思路
1. 由 com.liang.mybatis.core.io.Resources 实现配置文件的读取
2. 由com.liang.mybatis.core.sqlSession.SqlSessionFactoryBuilder 负责解析配置文件，
   将读取的配置文件解析为配置文件解析成两部分，config 由 com.liang.mybatis.core.config.XMLConfigBuilder负责处理；mappedStatement 由 com.liang.mybatis.core.config.XmlMapperBuilder负责处理。
3. 配置文件解析完成之后，调用build方法即可获得sqlSessionFactory
4. 调用sqlSessionFactory的openSession方法即可获得sqlSession对象，即操作数据库的会话
5. sqlSession中提供了两种调取mapper的方法，一种是直接通过statementId去调用；另一种是通过getMapper方法，获取对应接口的代理对象来操作mapper文件中的sql语句
6. session中将要执行的mappedStatement对象委托给executor去执行
7. executor在执行的时候，会将解析的语句形成boundSql对象，里面封装着要执行的句子，以及参数列表
8. executor调用原生jdbc去执行sql，操作数据库
9. 执行完毕后将结果返回到调用方