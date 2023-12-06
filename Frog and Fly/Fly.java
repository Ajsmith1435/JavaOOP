public class Fly {

	private double mass;
	private double speed;

	private static double default_mass = 5;
	private static double default_speed = 10;
	
	
	
//constructors
// A constructor that takes in mass and speed of a Fly.

	public Fly (double mass, double speed) {
		this.mass = mass;
		this.speed = speed;
		}

// A constructor that takes in only mass. By default, the Fly will have 10 speed.

	public Fly (double mass) {
		this(mass, default_speed);
		}

//A constructor that takes in no parameters. By default, the Fly will have 5 mass and 10 speed.
	
	public Fly () {
		this(default_mass);
		}


//methods

//Setters and getters (using appropriately named methods) for all variables in Fly.java. (mass and speed)

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		if (mass >= 0) {
			this.mass = mass;
		}
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		if (speed > 0) {
			this.speed = speed;
		}
	}
//methods - toString - takes in no parameters and returns a String describing the Fly as follows:
	//If mass is 0: I’m dead, but I used to be a fly with a speed of [speed].
	//Otherwise: I’m a speedy fly with [speed] speed and [mass] mass.

	public String toString() {
		if (mass == 0) {
			return String.format("I'm dead, but I used to be a fly with a speed of %.2f.", speed);
		}
		else {
			return String.format("I'm a speedy fly with %.2f speed and %.2f mass.", speed, mass);
		}
	}

	//grow - takes in an integer parameter representing the added mass. Then it increases the mass the Fly by the given number of mass. As mass increases, speed changes as follows:
		// If mass is less than 20: increases speed by 1 for every mass the Fly grows until it reaches 20 mass.
		//If the mass is 20 or more: decreases speed by 0.5 for each mass unit added over 20.

	public void grow(int plusMass) {
		int i = 0;
			while (i != plusMass) {
			mass++;
			if (mass + plusMass < 20) {
				speed += plusMass;
			}
			else if (mass >= 20)
				speed -= 0.5 * plusMass;
			}
			mass += plusMass;
		}
		
//isDead – if mass is zero, return true. Otherwise, return false.

	public boolean isDead() {
		return (mass == 0);
		
		}

}
