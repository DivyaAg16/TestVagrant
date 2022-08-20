import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

public class ForeignPlayerCount {

	@Test
	public void countForeignPlayer() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		String path = System.getProperty("user.dir");
		FileReader reader = new FileReader(path + "/src/test/resources/TeamRCB.json");
		// Read JSON file
		JSONObject obj = (JSONObject) jsonParser.parse(reader);
		int foreigner = 0;
		JSONArray playersList = (JSONArray) obj.get("player");
		System.out.println("Players List-> " + playersList);
		for (int i = 0; i < playersList.size(); i++) {
			JSONObject player = (JSONObject) playersList.get(i);
			String country = (String) player.get("country");
			if (!country.equals("India")) {
				foreigner++;
			}
		}
			System.out.println("Foreigner in RCB is " + foreigner);
			Assert.assertEquals(4, foreigner);
	}

	@Test
	public void countWicketKeeper() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		String path = System.getProperty("user.dir");
		FileReader reader = new FileReader(path + "/src/test/resources/TeamRCB.json");
		// Read JSON file
		JSONObject obj = (JSONObject) jsonParser.parse(reader);
		int WicketKeeper = 0;
		JSONArray playersList = (JSONArray) obj.get("player");
		System.out.println("Players List-> " + playersList);
		for (int i = 0; i < playersList.size(); i++) {
			JSONObject player = (JSONObject) playersList.get(i);
			String role = (String) player.get("role");
			if (role.equals("Wicket-keeper")) {
				WicketKeeper++;
			}
		}
			System.out.println("WicketKeeper in RCB is " + WicketKeeper);
			Assert.assertEquals(WicketKeeper, 1);
		}
}
