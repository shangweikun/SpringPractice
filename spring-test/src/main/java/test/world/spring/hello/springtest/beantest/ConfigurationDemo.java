package test.world.spring.hello.springtest.beantest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class ConfigurationDemo {

	@Bean("getInteger")
	public Integer getInteger() {
		return new Integer(Objects.toString(Math.random() * 10).substring(0,1));
	}
}
