在springboot中filter配置有两种方式

 1. 通过注解
    在filter类添加注解 @WebFilter(urlPatterns = "/hello",filterName = "demofilter")
    在启动类添加注解   @ServletComponentScan

 2. 通过FilterRegistrationBean进行注册

    创建FilterRegistrationBean对象，对filter进行注册
        @Bean
    	public FilterRegistrationBean registrationBean(){
    		FilterRegistrationBean filterbean = new FilterRegistrationBean();
    		filterbean.setFilter(new DemoFilter());
    		filterbean.setName("demofilter");
    		filterbean.addUrlPatterns("/hello");
    		return filterbean;
    	}