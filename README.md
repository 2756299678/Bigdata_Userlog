# Bigdata_Userlog
[功能描述]：
当用户对网站进行访问时，会留下用户的行为日志，通过对行为日志进行分析，统计最受欢迎的视频/文章的TopN访问流量和次数。

[开发环境]：
系统：Windows+VMware 10(CentensOS)
环境配置：Eclipes+Tomcat+mysql+hadoop+hive+sqoop

[项目结构简介]：

src/main/java/com/dao         存放方法类的接口
src/main/java/com/impl        对dao方法进行实现
src/main/java/com/entity      存放实体类
src/main/java/com/mapreduce   mapreduce操作类
src/main/java/com/service     存放控制类
src/main/java/com/utils       工具类

[程序思路]：
1.对日志进行清洗：
    日志的清洗分为两个阶段：
	第一阶段，将需要的信息从原始日志中提出来。
	第二阶段：将提取的信息进行精细化的操作。
2.对清洗后的数据进行入库处理。
    将清洗后的数据导入到hive中。
3.通过hive统计最受欢迎的视频/文章的TopN
4.将hive的结果存储到List列表中。
5.将列表中的数据导入到mysql.
6.网页的前端利用Echart插件进行结果图表的展示。


[作者列表]：
Lighter


[历史版本]：
1.0版本（2018-7-24）

[联系方式]：
QQ:2756299678
