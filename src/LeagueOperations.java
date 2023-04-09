import java.util.ArrayList;

public class LeagueOperations {
	public League[] leaguePlacement(LanguageEnum languageName, ArrayList<User> userList) {
		BronzeLeague bronzeLeague = new BronzeLeague(languageName.getName());
        SilverLeague silverLeague = new SilverLeague(languageName.getName());
        GoldenLeague goldenLeague = new GoldenLeague(languageName.getName());
        SaphireLeague saphireLeague = new SaphireLeague(languageName.getName());
        RubyLeague rubyLeague = new RubyLeague(languageName.getName());
        
        bronzeLeague.setLeaderBoard(userList);
        
        ArrayList<User> promotedToSilver = bronzeLeague.promoteToSilver();
        silverLeague.setLeaderBoard(promotedToSilver);
        
        ArrayList<User> promotedToGolden = silverLeague.promoteToGolden();
        goldenLeague.setLeaderBoard(promotedToGolden);
        
        ArrayList<User> promotedToSaphire = goldenLeague.promoteToSaphire();
        saphireLeague.setLeaderBoard(promotedToSaphire);
        
        ArrayList<User> promotedToRuby = saphireLeague.promoteToSaphire();
        rubyLeague.setLeaderBoard(promotedToRuby);
        
        /*for(User user : saphireLeague.getLeaderBoard()) {
        	System.out.println("Saphire: "+ user.getUsername());
        }
              
        for(User user : rubyLeague.getLeaderBoard()) {
        	System.out.println("Ruby: "+ user.getUsername());
        }*/

        
        League[] leaguesArray = {bronzeLeague, silverLeague, goldenLeague, saphireLeague, rubyLeague};
        return leaguesArray;
	}
}
