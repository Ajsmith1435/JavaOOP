public class Frog {
	private String name;
	private int age; //age in months
	private double tongueSpeed;
	private boolean isFroglet;
	private static String species = "Rare Pepe";
	private static final int default_age = 5;
	private static final double default_tongueSpeed = 5;

//Constructors
	//A constructor that takes in name, age, and tongueSpeed and sets all variables appropriately.

	public Frog(String name, int age, double tongueSpeed) {
		this.name = name;
		this.age = age;
		this.tongueSpeed = tongueSpeed;
	}

	//A constructor that takes in name, ageInYears representing the age of the Frog in years as a double, and tongueSpeed and sets all variables appropriately.
	//When converting ageInYears to age (in an integer number of months), round down to the nearest month without using any method calls (Hint: Java can automatically do this for you with casting).

	public Frog(String name, double ageInYears, double tongueSpeed) {
		this.name = name;
		this.age = (int) age * 12;
		this.tongueSpeed = tongueSpeed;
		this.isFroglet(age);
	}

	//A constructor that takes in just a name. By default, a Frog is 5 months old and has a tongueSpeed of 5.

	public Frog(String name) {
		this.name = name;
		age = default_age;
		tongueSpeed = default_tongueSpeed;
		this.isFroglet(age);	
	}

//methods 

	//isFroglet
	
	private void isFroglet(int age) {
		if (age < 7  && age > 1) {
			isFroglet = true; 
		} 
		else {
			isFroglet = false;
		}
	}

	//grow - takes in a whole number parameter representing the number of months. Then it ages the Frog by the given number of months and increases tongueSpeed by 1 for every month the Frog grows until it becomes 12 months old. If the Frog is 30 months old or more, then decrease tongueSpeed by 1 for every month that it ages beyond 30 months. You must not decrease tongueSpeed to less than 5. Remember to update isFroglet accordingly

	public void grow(int months) {
		for (int i = 0; i < months; i++) {
			this.age++;
			if(this.age <= 12)
				this.tongueSpeed++;
			else if(this.age > 30 && tongueSpeed >= 6)
				tongueSpeed--;
		}
		this.isFroglet = this.age > 1 && this.age < 7;	
	}


// grow - takes in no parameters and ages the Frog by one month and updates tongueSpeed accordingly as for the other grow method

	public void grow() {
		/*age = age + 1;
		if (age < 12) {
			tongueSpeed = tongueSpeed++;
		}
		else if (age >= 30) {
			if  ((tongueSpeed - (age - 30)) >= 5) {
				tongueSpeed = tongueSpeed - (age - 30);
			}
		}
		this.isFroglet(age);*/
		grow(1);
	}

// eat – takes in a parameter of a Fly to attempt to catch and eat. Check if Fly is dead, and if it is dead then terminate the method. The Fly is caught if tongueSpeed is greater than the speed of the Fly. If the Fly is caught and the mass is at least 0.5 times the age of the Frog, the Frog ages by one month using the method grow. If the Fly is caught, the mass of the Fly must be set to 0. If the Fly is NOT caught, the mass of the Fly must be increased by 1 while updating the speed of the Fly using only one Fly method.
	
	public void eat (Fly x) {
		if (x.isDead()) { }
		if (tongueSpeed > x.getSpeed()) {
			System.out.println("The fly is caught!");
			if (x.getMass() >= (0.5*age)) {
				this.grow();
			}
			x.setMass(0);
		} 
			else {
			x.grow(1);
		}
	}

//toString - returns a String describing the Frog as follows: (Note: replace the values in brackets [] with the actual value. Do not include the double quotes  or the square brackets [] in the output. Specify all decimal values to 2 decimal points.) If frog is a froglet, returns My name is [name] and I’m a rare froglet! Im [age] months old and my tongue has a speed of [tongueSpeed]. Otherwise, returns My name is [name] and I’m a rare frog. Im [age] months old and my tongue has a speed of [tongueSpeed].

	public String toString() {
		if (age < 7  && age > 1) {
			return "My name is " +  name + " and I'm a rare froglet! I'm " + age + " months old and my tongue has a speed of " + tongueSpeed + ".";
		}
		else {
			return "My name is " + name + " and I'm a rare frog. I'm " + age + " months old and my tongue has a speed of " + tongueSpeed + ".";
		}
	}

//Setter and getter for species which must change the value for all instances of the class. Points will be deducted if you include an unnecessary or inappropriate setter/getter.

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String setSpecies) {
		this.species = species;
	}

	public static void main(String[] args) {
		Frog frog1 = new Frog("Frogger", 10, 3);
		System.out.println(frog1.toString());
	}		

}
