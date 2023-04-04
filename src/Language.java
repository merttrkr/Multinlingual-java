import java.util.Random;
public abstract class Language {
	private String name;
	private Unit[] unitsArray;
	private String[] leagueArray;
	private int unitNumber;

    public Language(String name ) {// only name needed when generating this class.
    	this.name = name;
        
    }
    public int getUnitNumber() {
		return unitNumber;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getLeagueArray() {
		return leagueArray;
	}

	public void setLeagueArray(String[] leagueArray) {
		this.leagueArray = leagueArray;
	}

	public Unit[] getUnitsArray() {
		return unitsArray;
	}
	
	public void createUnits() {
		Random rand = new Random();
        int numUnits = rand.nextInt(41) + 60; // generates a random number between 60 and 100
        this.unitNumber = numUnits;
        
        for(int i= 0; i < numUnits ; i ++) {
        	Unit unit = new Unit();
        	this.unitsArray[i] = unit;
        }

	}
	
}
