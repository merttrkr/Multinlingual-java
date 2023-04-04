
public abstract class Language {
	private String name;
	private String[] unitsArray;
	private String[] leagueArray;
		
    public Language(String name, String[] unitsArray, String[] leagueArray) {
    	this.name = name;
        this.unitsArray = unitsArray;
        this.leagueArray = leagueArray;
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

	public String[] getUnitsArray() {
		return unitsArray;
	}

	public void setUnitsArray(String[] unitsArray) {
		this.unitsArray = unitsArray;
	}
	
}
