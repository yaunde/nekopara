package io.blotus.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 注意：这个地方使用了Spring的注解@Component，如果不是使用annotation的方式，而是使用xml的方式管理Bean，记得写入配置文件
 * <bean id="springContextUtil" class="com.ecdatainfo.util.SpringContextUtil" singleton="true" />
 *
 * 在web项目中，系统一旦启动，web服务器会初始化Spring的上下文的，我们可以很优雅的获得Spring的ApplicationContext对象。 如果使用new
 * ClassPathXmlApplicationContext("applicationContext.xml");
 * 相当于重新初始化一遍！！也就是说所有bean会再被创建一次！！就会有两个bean，如果有些bean是用来执行定时任务的，则就会有多个线程执行定时任务，造成重复执行！！ 其实，
 * ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
 * 这种方式获取Sping上下文环境，最主要是在测试环境中使用，比如写一个测试类，系统不启动的情况下手动初始化Spring上下文再获取对象！
 */
@Component
public class SpringContextHelper implements ApplicationContextAware {

  // Spring应用上下文环境
  private static ApplicationContext applicationContext;

  /**
   * 实现了ApplicationContextAware 接口，必须实现该方法； 通过传递applicationContext参数初始化成员变量applicationContext
   * 
   * @param applicationContext
   * @throws BeansException
   */
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    SpringContextHelper.applicationContext = applicationContext;
  }

  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  public static <T> T getBean(String name) throws BeansException {
    return (T) applicationContext.getBean(name);
  }

}
