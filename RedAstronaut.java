import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor{

//Variables
	//skill - a String that represents skill of the Red crewmate a String value of either inexperienced, experienced, or expert.
		private String skill;
	//defaults
		public static final int default_susLevel = 15;
		public static final String default_skill = "experienced";


//Constructors 
	// A constructor that takes in the name, susLevel, and skill and sets all fields accordingly. It must accept the variables in the specified order. Assume that the passed in parameter for skill will be one of the three values, although it may have different capitalization.

	public RedAstronaut (String name, int susLevel, String skill) {
		super(name, susLevel);
		this.skill = skill;
	}

// A constructor that takes in just a name and assigns the following default values: susLevel: 15 skill: experienced
	//added default values to variables

	public RedAstronaut (String name) {
		this(name, default_susLevel, default_skill);
	}
		
// Methods

	// emergencyMeeting() - A Player that is frozen cannot call an emergency meeting. Holds a meeting and votes out (freezes) the most suspicious Player, only considering Players that are not frozen The player that has the highest susLevel (that is NOT the current impostor calling the meeting) will be accused of being the impostor and will be voted off If two players have the same highest susLevel, no player will be voted off.

	public void emergencyMeeting() {
		if (!super.isFrozen()) {
			Player[] players = super.getPlayers();
			Arrays.sort(players);
			int voter = players.length - 1;
			int second;
			while (players[voter].isFrozen() == true) {
				voter--;
			}
			second = voter - 1;
			while (players[second].isFrozen() == true) {
				second--;
			}
			if (players[voter].getSusLevel() == players[second].getSusLevel()) {
					
			} else if (players[voter].getName() != super.getName()) {
				players[voter].setFrozen(true);
			}
		}
		gameOver();
	}

	
	//freeze(Player p) - Implements the method provided in the Impostor interface. It is not possible to freeze another Impostor, and an Impostor that is frozen cannot attempt to freeze. If the passed in Player is an Impostor, the method should end. Freezing an already frozen Player should also do nothing. A freeze is successful if the RedAstronaut's susLevel is less than the Player's If the freeze is unsuccessful, the RedAstronaut's susLevel doubles (multiply the current susLevel by 2) Remember to change the frozen boolean value for the Crewmate as needed. After the freeze attempt, check if the game is over using the provided method in Player.java Does not return anything

	public void freeze(Player p) {
		if (p instanceof Imposter || p.isFrozen() == true || super.isFrozen() == true) {
			return;
		}
		else {
			if (super.getSusLevel() < p.getSusLevel()) {
				p.setFrozen(true);
			}
			else {
				super.setSusLevel(p.getSusLevel() * 2);
			}
		}
		gameOver();
	}

	//sabotage(Player p) - It is not possible to sabotage another Impostor, and an Impostor that is frozen cannot sabotage. Also, sabotaging a frozen Player should do nothing. If the Impostor's susLevel is under 20, through shifty maneuvers and cunning words, they are able to increase the Crewmate’s susLevel by 50% Otherwise, they can only manage to increase the Crewmate's susLevel by 25% (Note: In both cases, the the Crewmate's susLevel is rounded down to the nearest int value) Does not return anything

	public void sabotage(Player p) {
		if (p instanceof Impostor || super.isFrozen() == true || p.isFrozen() == true) {
			return;
		} 
		else {
			if (this.getSusLevel() < 20) {
				p.setSusLevel((int)(1.5*p.getSusLevel()));
			} else {
				p.setSusLevel((int)(1.25*p.getSusLevel()));
			}
		}

	}


	//equals (Object o) - Two Red are equal if they both have the same name, frozen, susLevel, and skill. Returns a boolean
			
	public boolean equals(Object o) {
        	if (o instanceof RedAstronaut) {
           		 RedAstronaut red = (RedAstronaut) o;
            			return super.getName().equals(red.getName()) && super.isFrozen() == red.isFrozen()
                    && super.getSusLevel() == red.getSusLevel();
        }
        return false;
    }
	
	//toString() returns a String describing RedAstronaut as follows: (Note: replace the values in brackets [] with the actual value)
	//"My name is [name], and I have a suslevel of [susLevel]. I am currently (frozen / not frozen). I am an [skill] player!" If susLevel is greater than 15, return the String in all capital letters. You must use the toString() method from the Player class to receive full credit. Getters and Setters as necessary.

	public String toString() {
		String output = super.toString();

        	if (super.isFrozen() == true) {
			output = super.toString() + "My name is " + super.getName() + ", and I have a suslevel of " + super.getSusLevel() + ". I am currently frozen. I am a " + skill + " player!";
		}
		else {
			output = super.toString() + "My name is " + super.getName() + ", and I have a suslevel of " + super.getSusLevel() + ". I am currently not frozen. I am a " + skill + " player!";
		}
       		if(this.getSusLevel() > 15) {
        		return output.toUpperCase();
       		} 
		else {
        		return output;
        	}
	}
	public static void main(String[] args) {
	}
}




