# SpringMybatis
SpringMybatis框架整合
  框架整合  mybatis+spring 

  mybatis
      备注：  1.读取连接数据库属性文件（jdbc.properties文件）
        2.配置数据源
        3.扫描mapper映射文件（加载数据源）
   4.全局属性设置  
   

  spring   (读取mybatis主配置文件)

     备注：（读取jdbc.properties文件
    bean 获取数据源  指定连接数据库的配置（四个属性）
      bean  sqlSessionFactory(数据源工厂  )
      也就是 bean class=“SqlSession” 注入=sqlSessionFactory 
        然后 bean Dao 注入 sqlSession 到Dao层 
          然后  bean service 注入Dao
        servlet中  service=调用getBean（“service层  bean 的id属性值”））



    1.读取jdbc.properties文件
    2.获取数据源  dataSource
    3.创建SqlSessionFactoryBean工厂对象(数据源工厂)
	3.1 加载数据源
        3.2 读取mybatis主配置文件
        3.3 读取mapper文件
        3.4 给实体类起一个别名
    4.创建MapperScannerConfigurer    
	4.1 将数据源注入Dao层(数据源工厂)
 	4.2 扫描Dao 


   示例步骤
     1.导入mybatis与spring所需要的jar
     2.在resources下引入jdbc.properties
     3.创建spring-mybatis.xml 主配置文件 
         3.1 读取jdbc.properties文件
	     <context:property-placeholder location="classpath:jdbc.properties"/>
         3.2 获取数据源  dataSource
	     <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        	<property name="driverClass" value="${jdbc.driver}"/>
        	<property name="jdbcUrl" value="${jdbc.url}"/>
        	<property name="user" value="${jdbc.username}"/>
        	<property name="password" value="${jdbc.password}"/>
        	<property name="maxPoolSize" value="${c3p0.maxPoolSize}"/>
        	<property name="minPoolSize" value="${c3p0.minPoolSize}"/>
        	<property name="autoCommitOnClose" value="${c3p0.autoCommitOnClose}"/>
        	<property name="checkoutTimeout" value="${c3p0.checkoutTimeout}"/>
        	<property name="acquireRetryAttempts" value="${c3p0.acquireRetryAttempts}"/>
    	     </bean>
         3.3 创建SqlSessionFactoryBean工厂对象(数据源工厂)
		（1） 加载数据源
        	（2） 读取mybatis主配置文件
        	（3） 读取mapper文件
        	（4） 给实体类起一个别名
    	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
         	<!--加载数据源-->
        	<property name="dataSource" ref="dataSource"/>
        	<!--读取mybatis主配置文件-->
        	 <property name="configLocation" value="classpath:mybatis.xml"/>
        	<!--读取mapper文件-->
         	<property name="mapperLocations" value="classpath:mappers/*.xml"/>
        	<!--给实体类起一个别名-->
         	<property name="typeAliasesPackage" value="com.hz.pojo"/>
    	</bean>

        3.4  创建MapperScannerConfigurer
        	1 将数据源注入Dao层(数据源工厂) 可以不写
 		2 扫描Dao 
   	 <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        	<!--扫描Dao -->
        	<property name="basePackage"  value="com.hz.dao"/>
        	<!--将数据源注入Dao层  可以不写  自动注入sqlSessionFactory-->
       		<!-- <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>-->
    	 </bean>

     4.创建mybatis主配置文件
   	<settings>
        	<!--打印SQL语句-->
        	<setting name="logImpl" value="STDOUT_LOGGING"/>
    	</settings>    

    5.编写DAO接口
    6.在resources下创建mappers文件夹  并创建.xml文件
    7.在spring-mybatis.xml中扫描service包
	<context:component-scan base-package="com.hz.service"/>
    8.读取spring-mybaits.xml配置文件获取实例 

  
