package test.world.spring.hello.springtest.deputy;

import org.springframework.stereotype.Component;

@Component("TargetClassImpl")
public class TargetClassImpl implements OriginalInterface {

	@Override
	@RedisDemo
	public String say() {
		return "Hi Apple";
	}
}
