package practice;

import java.util.ArrayList;
import java.util.List;

public class lists {

	public static void main(String[] args) {
		List<People> peoples = new ArrayList<>();
		peoples.add(new People("Hazal", "26"));
		peoples.add(new People("irem", "27"));
		peoples.add(new People("Asli", "28"));

		for (People p : peoples) {
			p.dataOfPerson();
		}
	}

}

class People {
	String name;
	String age;

	public People(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public void dataOfPerson() {
		System.out.print("Name is -->" + name);
		System.out.println(" Age  is -->" + age);

	}
}