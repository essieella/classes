package Animal;

public class Animal {
	private int age;
	private String name;
	private double weight;
	Animal() {
		age = 12;
		name = "Bart";
		weight = 22.7;
	}
	Animal(String n, int a, double w) {
		age = a;
		name = n;
		weight = w;
	}
	
	public void tostring() {
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		System.out.println("weight: " + weight);
	}
	
	public static void main(String[] args) {
	//	Animal giraffe = new Animal();
	//	giraffe.tostring();
	}
}
