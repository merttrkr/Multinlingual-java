
public class LeagueOperations {
	public League[] leaguePlacement(LanguageEnum languageName) {
		BronzeLeague bronzeLeague = new BronzeLeague(languageName.getName());
        SilverLeague silverLeague = new SilverLeague(languageName.getName());
        GoldenLeague goldenLeague = new GoldenLeague(languageName.getName());
        SaphireLeague saphireLeague = new SaphireLeague(languageName.getName());
        RubyLeague rubyLeague = new RubyLeague(languageName.getName());
        
        
        League[] leaguesArray = {bronzeLeague, silverLeague, goldenLeague, saphireLeague, rubyLeague};
        return leaguesArray;
	}
}
