package test.world.spring.hello.springtest;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.world.spring.hello.springtest.deputy.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.math.BigDecimal;

@SpringBootApplication
@RestController
public class SpringTestApplication {

static class Demo{

	@RedisDemo
	void say(){
		System.out.println("?");
	};
}

    public static void main(String[] args) {
//	    Method[] methods = Demo.class.getDeclaredMethods();    必须通过Declare才能获得非public声明方法
	    Method[] methods = TestClass.class.getMethods();
	    for(Method method :methods){
		    Annotation[] annotations = method.getDeclaredAnnotations();
		    for (Annotation annotation : annotations){
			    System.out.println(annotation.toString());
		    }
	    }
        /*SpringApplication.run(SpringTestApplication.class, args);
        BigDecimal a = new BigDecimal(1);
        BigDecimal b = a;
        a = a.add(new BigDecimal(1));
        System.out.println(a.toBigInteger());
        System.out.println(b.toBigInteger());*/
        String key = "TargetClassImpl";
        ConfigurableApplicationContext context = SpringApplication.run(SpringTestApplication.class, args);
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
		Object obj = beanFactory.getBean(key);

		if (obj.getClass().toString().matches("(.)*TargetClassImpl$")) {

			BeanDefinition beanDefinition = beanFactory.getBeanDefinition("TargetClassImpl");
			beanFactory.removeBeanDefinition(key);
			System.out.println("----    cglib begin    ---");
			DemoCglibProxy proxy = new DemoCglibProxy();
			Object proxyObj = proxy.createProxy(TargetClassImpl.class);
			System.out.println(((OriginalInterface) proxyObj).say());
			System.out.println("----    cglib end    ---");
			beanDefinition.setBeanClassName(proxyObj.getClass().getCanonicalName());
			beanFactory.registerBeanDefinition(key, beanDefinition);
			beanFactory.registerSingleton(key, proxyObj);
		}
		System.out.println(((OriginalInterface) beanFactory.getBean(key)).say());
	    System.out.println(((OriginalInterface) beanFactory.getBean(key)).getClass());
    }

    @RequestMapping("/hello")
    public void hello() {
        System.out.println("Hello Spring");
    }

    @RequestMapping("/hello2")
    public String hello2() {
        return "Hello Spring";
    }

}
