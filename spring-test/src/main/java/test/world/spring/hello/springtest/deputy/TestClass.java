package test.world.spring.hello.springtest.deputy;

public class TestClass {

	@RedisDemo
	public void say(){
		System.out.println("?");
	}

	@RedisDemo
	public String sayTwo(){
		System.out.println("Two");
		return "Two";
	}
}
