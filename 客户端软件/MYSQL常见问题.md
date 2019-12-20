# MYSQL常见问题

- 关闭大小写敏感开关

  ```
  mysql服务端默认开启表名大小写敏感开关，即lower_case_table_names=0
  通过客户端查看：
  	Navicat for Mysql或者mysql.exe工具连接服务端，使用语句show variables like 'lower%',显示如下
  ```

  | lower_case_file_system | OFF  | 只读参数，无法被修改，这个参数是用来告诉你在当前的系统平台下，是否对文件名大小写敏感 |
  | ---------------------- | ---- | ------------------------------------------------------------ |
  | lower_case_table_names | 0    | 默认为0，0-大小写敏感，1-大小写不敏感，2-表名存储为给定的大小写，比较时转成小写（实践发现2无用） |

  ```
  修改lower_case_table_names：
  	1. linux centos7版本下修改/etc/my.cnf文件增加
  		[mysqld]
  		lower_case_table_names=1
  	2. 重启数据库服务
  	3. 删除原来的数据库
  		drop database 数据库名 或者 Navicat for Mysql手动删除
  		可能会出现在客户端无法删除数据库的情况，那么只能在服务端删除，进入/var/lib/mysql，手动删除对		应的数据库
  	4. 重新导入数据库数据（实现需要备份），表名存储为给定的大小写（大小写不敏感生效）
  ```

  

  