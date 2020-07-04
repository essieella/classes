package Animal;

public class Dog extends Animal{
	Dog(String n, int a, double w) {
		super(n, a, w);
	}
	Dog() {
		super();
	}
	public static void main(String[] args) {
		Dog terrier = new Dog();
		terrier.tostring();
		Dog pitbull = new Dog("herbert", 11, 10.0);
		pitbull.tostring();
	}
}
