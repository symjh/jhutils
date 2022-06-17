

#网络通的两台服务器
mysqldump 

#导出文件方式
mysqldump 

#导入文件方式


#binlog文件转码
mysqlbinlog --base64-output=DECODE-ROWS -v ./data/binlog/mysql-bin.000001 > view.log


#清空此日期前的binlog，保留最新一个
purge master logs before '2022-05-13 15:30:00';
#创建一个新的binlog文件
flush logs;
#重置binlog 
reset master;