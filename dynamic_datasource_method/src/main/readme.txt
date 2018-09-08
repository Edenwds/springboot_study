本项目实现了一主一从动态数据源的选择，使用切面判断sql方法的方式。

这里的多数据的动态选择，主要是一主一从的形式，若有一主多从的方式，怎么实现数据源的动态选择？

增删改可以使用一个主数据库，查则可以有多个从数据库可以选择，对于多个从数据库，如何选择?

当有多个从数据库时，初步设想使用负载均衡，使用轮询的方式将查询分布到多个从数据库中，那如何实现？

动态数据源的实现是继承了抽象类AbstractRoutingDataSource,实现了其中的抽象方法 determineCurrentLookupKey()
通过方法名可知，该方法返回一个key，通过阅读AbstractRoutingDataSource的源码，多个数据源的存储方式
是以key-value的形式存储在map中，当动态选择时，使用determineTargetDataSourc()根据key找到对应的DataSource。

现在要实现多个数据库，设想继承AbstractRoutingDataSource类，重写determineTargetDataSource()方法，将原来
Map<Object, Object> targetDataSources的存储方式改为Map<Object,List<Object>> slaveDataSources 用来存储从库数据源，
当动态选择时，在determineTargetDataSource()方法中 判断 determineCurrentLookupKey()方法的key，若为master，则直接返回
resolvedDefaultDataSource,(前提是在配置数据源时，必须将主数据设置为defaultDataSource).若为slave，则得到slave的List<DataSource>,
使用轮询的方式得到其中一个DataSource返回，实现多从的动态选择。