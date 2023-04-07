import java.util.Random;
public class Language {
	private String name;
	private Unit[] unitsArray;
	private int unitNumber;
	private League BronzeLeague;
	private League SilverLeague;
	private League GoldenLeague;
	private League SaphireLeague;
	private League RubyLeague;
	
	
	public Language(String name ) {// only name needed when generating this class.
    	this.name = name;
    	Random rand = new Random();
    	unitNumber = rand.nextInt(41) + 60; // generates a random number between 60 and 100
    	unitsArray = new Unit[unitNumber];
    	createUnits();      
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

	public Unit[] getUnitsArray() {
		return unitsArray;
	}
	
	public League getBronzeLeague() {
		return BronzeLeague;
	}

	public League getSilverLeague() {
		return SilverLeague;
	}

	public League getGoldenLeague() {
		return GoldenLeague;
	}

	public League getSaphireLeague() {
		return SaphireLeague;
	}

	public League getRubyLeague() {
		return RubyLeague;
	}

	public void createUnits() {       
	        for(int i= 0; i < unitNumber ; i ++) {
	        	Unit unit = new Unit(name);
	        	unitsArray[i] = unit;
	        }
	}
	
}
