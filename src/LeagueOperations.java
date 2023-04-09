import java.util.ArrayList;

public class LeagueOperations implements ILeagueOperations{
    public League[] leaguePlacement(LanguageEnum languageName, ArrayList<User> userList) {
        // Create instances of each league
        BronzeLeague bronzeLeague = new BronzeLeague(languageName.getName());
        SilverLeague silverLeague = new SilverLeague(languageName.getName());
        GoldenLeague goldenLeague = new GoldenLeague(languageName.getName());
        SaphireLeague saphireLeague = new SaphireLeague(languageName.getName());
        RubyLeague rubyLeague = new RubyLeague(languageName.getName());

        // Set the leaderboards for each league
        bronzeLeague.setLeaderBoard(userList);
        ArrayList<User> promotedToSilver = bronzeLeague.promoteToNextLeague();
        silverLeague.setLeaderBoard(promotedToSilver);
        ArrayList<User> promotedToGolden = silverLeague.promoteToNextLeague();
        goldenLeague.setLeaderBoard(promotedToGolden);
        ArrayList<User> promotedToSaphire = goldenLeague.promoteToNextLeague();
        saphireLeague.setLeaderBoard(promotedToSaphire);
        ArrayList<User> promotedToRuby = saphireLeague.promoteToNextLeague();
        rubyLeague.setLeaderBoard(promotedToRuby);
        
        // Put each league into an array and return it
        League[] leaguesArray = {bronzeLeague, silverLeague, goldenLeague, saphireLeague, rubyLeague};
        return leaguesArray;
    }
}