import java.util.Arrays;

//This file defines a BlueAstronaut, which is a Player and should have all attributes of one. Have BlueAstronaut implement the Crewmate interface.	
public class BlueAstronaut extends Player implements Crewmate {

//variables
	private int numTasks;
	private int taskSpeed;
	//defaults
	public static final int default_susLevel = 15;
	public static final int default_numTasks = 6;
	public static final int default_taskSpeed = 10;


// Constructors

	//A constructor that takes in the name, susLevel, numTasks, and taskSpeed and sets all fields accordingly. It must accept the variables in the specified order.

	public BlueAstronaut (String name, int susLevel, int numTasks, int taskSpeed) {
		super(name, susLevel);
		this.numTasks = numTasks;
		this.taskSpeed = taskSpeed;
	}

	// A constructor that takes in just a name and assigns the following default values: suslevel, numtasks, taskspeed)
	
	public BlueAstronaut (String name) {
		this(name, default_susLevel, default_numTasks, default_taskSpeed);
	
	}

//Methods
	//emergencyMeeting() - A Player that is frozen cannot call an emergency meeting. Holds a meeting and votes out (freezes) the most suspicious individual of the Player objects, only considering Players that are not frozen The player that has the highest susLevel will be accused of being the impostor and will be voted off (This could be them!) If two players have the same highest susLevel, no player will be voted off. Hint: think of an easy way to do this without having to iterate through the entire array. Check the Java API for Arrays for a method you can use. Make sure to change the frozen variable of the player to true when voting off players (don't call freeze!) At the end of the vote, check if the game is over using the provided method in Player.java Does not return anything

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
			}
	
			else if (players[voter].getName() != super.getName()) {
				players[voter].setFrozen(true);
			}
		}
		gameOver();
	}

	// completeTask() - A BlueAstronaut that is frozen cannot complete tasks. If taskSpeed is greater than 20, subtract 2 from numTasks. Otherwise, subtract 1 from numTasks. If numTasks falls below 0, set it to 0 After BlueAstronaut is done with their tasks, meaning numTasks is equal to 0 (only for the first time), Print out "I have completed all my tasks" Then reduce BlueAstronaut’s susLevel by 50% (round down)

		public void completeTask() {
		int count = 0;
			if (!super.isFrozen()) {
				if (taskSpeed > 20) {
					numTasks = numTasks - 2;
			} 
				else {
					numTasks = numTasks - 1;
			}	
				if (numTasks <= 0) {
					numTasks = 0;
					taskSpeed = 0;
					count++;
			}
			if (numTasks == 0 && count == 1) {
				System.out.println("I have completed all my tasks");
				super.setSusLevel((int)(0.5*getSusLevel()));	
				}
			}
		}

	// equals(Object o) Two BlueAstronauts are equal if they both have the same name, frozen, susLevel, numTasks, and taskSpeed Returns a boolean

	public boolean equals(Object o) {
        	if (o instanceof BlueAstronaut) {
           		 BlueAstronaut blue = (BlueAstronaut) o;
            			return super.getName().equals(blue.getName()) && super.isFrozen() == blue.isFrozen()
                    && super.getSusLevel() == blue.getSusLevel();
      		}
       		return false;
    	}

	//toString() - returns a String describing BlueAstronaut as follows: "My name is [name], and I have a suslevel of [susLevel]. I am currently (frozen / not frozen). I have [numTasks] left over." If susLevel is greater than 15, return the String in all capital letters. (Note: replace the values in brackets [] with the actual value) You must use the toString() method from the Player class to receive full credit. Getters and Setters as necessary.

	public String toString() {
		String output = super.toString();

        	if (super.isFrozen() == true) {
			output = super.toString() + "My name is " + super.getName() + ", and I have a suslevel of " + super.getSusLevel() + ". I am currently frozen. I have " + numTasks + " left over.";
		}
		else {
			output = super.toString() + "My name is " + super.getName() + ", and I have a suslevel of " + super.getSusLevel() + ". I am currently not frozen. I have " + numTasks + " left over.";
		}
       		if (this.getSusLevel() > 15) {
        		return output.toUpperCase();
       		} 
		else {
			return output;
		}
			
		
	}

	public static void main(String[] args) {
	}
}

