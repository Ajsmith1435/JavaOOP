public class Gameplay {
	public static void main (String[] args) {
		BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
		BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
		BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
		BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);
		RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
		RedAstronaut susPerson = new RedAstronaut("Suspicious Person", 100, "expert");
	}
		
//Have RedAstronaut Liam sabotage BlueAstronaut Bob. After the sabotage:

	liam.sabotage(bob);
	System.out.println(bob);
		
//Have RedAstronaut Liam freeze RedAstronaut Suspicious Person:
		
	liam.freeze(susPerson);
	System.out.println(susPerson);
		
//Have RedAstronaut Liam freeze BlueAstronaut Albert. After the freeze:
		
	liam.freeze(albert);
	System.out.println(albert);
	System.out.println(liam);
		
//Have BlueAstronaut Albert call an emergency meeting:
		
	System.out.println(bob);
	System.out.println(heath);
	System.out.println(albert);
	System.out.println(angel);
	System.out.println(liam);
	System.out.println(susPerson);
	albert.emergencyMeeting();
	System.out.println("--------------------------------");
	System.out.println(bob);
	System.out.println(heath);
	System.out.println(albert);
	System.out.println(angel);
	System.out.println(liam);
	System.out.println(susPerson);
		
//Have RedAstronaut Suspicious Person call an emergency meeting:
		
	susPerson.emergencyMeeting();
	System.out.println(bob);
	System.out.println(heath);
	System.out.println(albert);
	System.out.println(angel);
	System.out.println(liam);
	System.out.println(susPerson);
		
//Have BlueAstronaut Bob call an emergency meeting:
		
	bob.emergencyMeeting();
	System.out.println(susPerson);
		
//Have BlueAstronaut Heath complete tasks:
		
	heath.completeTask();
	System.out.println(heath);
		
//Have BlueAstronaut Heath complete tasks:
		
	heath.completeTask();
	System.out.println(heath);
		
//Have BlueAstronaut Heath complete tasks:
		
	heath.completeTask();
	System.out.println(heath);
		
//Have RedAstronaut Liam freeze Angel:
		
	liam.freeze(angel);
	System.out.println(angel);
	System.out.println(liam);
		
//Have RedAstronaut Liam sabotage Bob twice:
		
	liam.sabotage(bob);
	liam.sabotage(bob);
	System.out.println(bob);
		
//Have RedAstronaut Liam freeze Bob:
		
	liam.freeze(bob);
	System.out.println(bob);
		
//Have BlueAstronaut Angel call emergency meeting:
		
		
	angel.emergencyMeeting();
	System.out.println(liam);
	
		
//Have RedAstronaut Liam call sabotage on Heath 5 times:
		
	for(int i = 0; i<5; i++) {
		liam.sabotage(heath);
		}
	System.out.println(heath);
		
//Have RedAstronaut Liam freeze Heath:
		
	liam.freeze(heath);
	System.out.println(heath);

}