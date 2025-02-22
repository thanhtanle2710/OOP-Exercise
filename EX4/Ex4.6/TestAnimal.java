

public class TestAnimal {
public static void main(String[] args) {
	Animal m1= new Mammal("Harith");
	System.out.println(m1);
	Mammal d1= new Dog("Pluto");
	System.out.println(d1);
	((Dog)d1).greets();
	Mammal c1= new Cat("Kitty");
	System.out.println(c1);
	((Cat)c1).greets();
	
	
}
}
