package kr.co.db_input.dto;

public class Dto_input {
	private String id;
	private String name;
	private String age;
	private String addr;
	private String writeday;
	
	public Dto_input() {

	}
	
	public Dto_input(String id, String name, String age, String addr, String writeday) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.writeday = writeday;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	
	
}
