package ProgrammersTest;

public class Main4 {

	/**
	 * 못 풀었다
	 */
	public static void main(String[] args) {
		String answer = "SELECT A.ID, A.NAME" + "FROM SUBWAY_STATIONS A"
				+ "WHERE A.ID NOT IN (SELECT B.STATION_ID FROM LINE_ROUTES B WHERE B.LINE_COLOR = \"GREEN\" OR B.LINE_COLOR = \"RED\")"
				+ "ORDER BY A.ID;";
	}
}