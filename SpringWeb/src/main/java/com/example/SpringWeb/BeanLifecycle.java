package com.example.SpringWeb;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanLifecycle implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {

	static int count = 0;

	public BeanLifecycle() {
		System.err.println(count++ + " BeanLifeCycle() run");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println(count++ + " BeanNameAware.setBeanName() run");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(count++ + " DisposableBean.destroy() run");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(count++ + " InitializingBean.afterPropertiesSet() run");
	}

	public void lifecycleInit() {
		System.out.println(count++ + " lifeCycleInit() run - init-method");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println(count++ + " ApplicationContextAware.setApplicationContext() run");
	}

	public void lifecycleInitDestroy(){
		System.out.println(count++ + " lifeCycleInitDestroy() run - destroy-method");
	}
}
