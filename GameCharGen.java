import java.util.Scanner;

public class GameCharGen
{
	
	public static void main(String[] args) throws NoGameCharacterFoundException
	{
		GameCharGenModel myCharGen = new GameCharGenModel();
		Scanner menuInput = new Scanner(System.in);
		
		while (true) {
			System.out.println("***	WoK GameCharGen Menu	***");
			System.out.println(" Create Wizard			WZ");
			System.out.println(" Create Fighter			FG");
			System.out.println(" Create Cleric			CL");
			System.out.println(" Lowest HP Character		LHC");
			System.out.println(" Sort Characters Asc.		SCA");
			System.out.println(" Sort Characters Dsc.		SCD");
			System.out.println(" Display Characters		DC");
			System.out.println(" Exit Program			EX");			
			System.out.print("	Enter Selection: ");
				String charChoice = menuInput.nextLine();
			
			if (charChoice.equalsIgnoreCase("WZ")){
				Wizard myWizard = new Wizard();
				myWizard.randGen(true);
				System.out.println("\n");
				myWizard.display();
				System.out.println("\n");
				myCharGen.addGameCharacter(myWizard);
			}
			else if (charChoice.equalsIgnoreCase("FG")){
				Fighter myFighter = new Fighter();
				myFighter.randGen(false);
				System.out.println("\n");
				myFighter.display();
				System.out.println("\n");
				myCharGen.addGameCharacter(myFighter);
			}
			else if (charChoice.equalsIgnoreCase("CL")){
				Cleric myCleric = new Cleric();
				myCleric.randGen(true);
				System.out.println("\n");
				myCleric.display();
				System.out.println("\n");
				myCharGen.addGameCharacter(myCleric);
			}
			else if (charChoice.equalsIgnoreCase("LHC")){
				try {
					System.out.println("Index of Lowest HP Character is: " + myCharGen.getLowestHPGameCharacter());	
				} 
				catch (Exception e) {
					System.out.println("------------------------------");					
					System.out.println("No characters have been saved!");
					System.out.println("------------------------------");					
				}
			}
			else if (charChoice.equalsIgnoreCase("SCA")){
				try {
					myCharGen.sortGameCharacterWisdom(true);	
					System.out.println("---------------------------------------------------");
					System.out.println("Characters have been organised in ascending order.");
					System.out.println("---------------------------------------------------");					
				} catch (Exception e) {
					System.out.println("------------------------------");					
					System.out.println("No characters have been saved!");
					System.out.println("------------------------------");										
				}
			}
			else if(charChoice.equalsIgnoreCase("SCD")){
				try {
					myCharGen.sortGameCharacterWisdom(false);
					System.out.println("---------------------------------------------------");
					System.out.println("Characters have been organised in descending order.");
					System.out.println("---------------------------------------------------");					
				} catch (Exception e) {
					System.out.println("------------------------------");					
					System.out.println("No characters have been saved!");
					System.out.println("------------------------------");
				}	
			}
			else if (charChoice.equalsIgnoreCase("EX")){
				break;
			}
			else if (charChoice.equalsIgnoreCase("DC")){
				System.out.println("-----------------------");
				System.out.println("ALL CREATED CHARACTERS: ");
				int x = myCharGen.getNumCharacters();
				for (int i=0; i<x; i++){
					myCharGen.gameCharacterAt(i).display();
					System.out.println("-----------------------");
				}
			}

			else {
				System.out.println("********************************");
				System.out.println(" " + charChoice + " is an unrecognised command!");
				System.out.println("********************************");
			}
		}
			
		menuInput.close();
		System.out.println("***************");
		System.out.println("Quitting now...");
		System.out.println("***************");
		System.exit(0);
	}

}
