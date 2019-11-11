package kr.co.work.dto;

public class Dto { // 생성자(빈, 전부입력), setter, getter
	private String name;
	private String age;
	private String addr;
	
	public Dto() { // 매개변수없는 생성자
		
	}
	
	public Dto(String name, String age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
