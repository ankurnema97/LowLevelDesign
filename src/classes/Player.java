package classes;

public class Player {

	private String name;
	PlayingOptions playingoptions;
	
	public Player(String name, PlayingOptions playingoptions) {
		this.name=name;
		this.playingoptions=playingoptions;
	}
	
	public String getName() {
		return name;
	}
}
