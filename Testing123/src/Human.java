
public class Human {
	private String name;
	private int age;
	
	public Human(){
		name = "";
		age = 0;
		System.out.println("1st");
	}
	
	public Human(String nm, int ag) {
		name = nm;
		age = ag;
		System.out.println(name + age + "2nd");
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String s) {
		name = s;
	}
	//override
	public String toString() {
		System.out.println("here");
		return "Human: " + getName() + ", Age: " + getAge();
	}
}
