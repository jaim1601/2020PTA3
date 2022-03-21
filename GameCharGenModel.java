import java.util.Arrays;

public class GameCharGenModel 
{
	static public int NUM_CHARS_BLOCK = 500;
	final public int STRENGTH=0; 
	final public int INTELLIGENCE=1; 
	final public int WISDOM=2;
	
	private int gameCharCount=0;
	private GameCharacter[] randomGameChars = new GameCharacter[NUM_CHARS_BLOCK];
	
	/**
	 * Returns the number of randomly-generated characters so far. 
	 * @return Number of randomly-generated characters.
	 */
	public int getNumCharacters()
	{
		return gameCharCount;
	}

	/**
	 * Adds a character to the array of characters
	 * @param c character to be added
	 */
	public void addGameCharacter(GameCharacter c)
	{
		if (gameCharCount>=randomGameChars.length)
		{
			GameCharacter[] newRandomChars = Arrays.copyOf(randomGameChars,randomGameChars.length+GameCharGenModel.NUM_CHARS_BLOCK);
			randomGameChars = newRandomChars;
		}
			
		randomGameChars[gameCharCount] = c;
		gameCharCount++;
		
	}
	
	/**
	 * Returns a character at a given index
	 * @param idx Provided index
	 * @return Character at a given index
	 */
	public GameCharacter gameCharacterAt(int idx)
	{
		if (idx<0 || idx>=randomGameChars.length)
			throw new IndexOutOfBoundsException();
		
		return randomGameChars[idx];
	}
	
	/**
	 * Finds a character with either maximum strength, intelligence or wisdom based on the parameter passed.
	 * @return Index of the character with lowest HP in the character array.
	 * @throws NoGameCharacterFoundException
	 */
	public int getLowestHPGameCharacter() throws NoGameCharacterFoundException
	{
		int lowest_HP = 100;
		int index_HP = 0;
		int char_HP = 0;
		if (randomGameChars[0].equals(null)){
			throw new NoGameCharacterFoundException();
		}
		else {
			for (int i=0; i<gameCharCount; i++){
				char_HP = randomGameChars[i].hitPoints;
				if (char_HP<lowest_HP){
					lowest_HP = char_HP;
					index_HP = i;
				}
			}
		}
		return index_HP;
	}
	
	
	public void sortGameCharacterWisdom(boolean ascending) throws NoGameCharacterFoundException
	{
		if (randomGameChars[0].equals(null)){
			throw new NoGameCharacterFoundException();
		}
		int char_wisdom;
		GameCharacter [] temp_char = new GameCharacter[gameCharCount];
		
		
		for (int i=0; i<gameCharCount; i++) {
			if (ascending == true) {
			char_wisdom = lowestGameCharWisdom();
			}
			else {
			char_wisdom = highestGameCharWisdom();
			}
			
			temp_char[i] = randomGameChars[char_wisdom];
			randomGameChars[char_wisdom] = null;
		}
		for (int j = 0; j<gameCharCount; j++) {
			randomGameChars[j] = temp_char[j];
		}
	}

	public int lowestGameCharWisdom()
	{
		int lowest_wisdom = 10000;
		int char_wisdom = 0;
		int low_char_index = -1;
		for (int i = 0; i<gameCharCount; i++) {
			if (randomGameChars[i] != null) {
				char_wisdom = randomGameChars[i].wisdom;
					if (char_wisdom<lowest_wisdom) {
					lowest_wisdom = char_wisdom;
					low_char_index = i;
					}
			} 
		}
		return low_char_index;
	}

	public int highestGameCharWisdom()
	{
		int highest_wisdom = -1;
		int char_wisdom = 0;
		int high_char_index = -1;
		for (int i = 0; i<gameCharCount; i++) {
			if (randomGameChars[i] != null) {
				char_wisdom = randomGameChars[i].wisdom;
					if (char_wisdom>highest_wisdom) {
					highest_wisdom = char_wisdom;
					high_char_index = i;
					}
			} 
		}
		return high_char_index;
	}

}
