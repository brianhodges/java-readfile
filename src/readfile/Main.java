package readfile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
        String filename = "top3list.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String delim = "+";
        List<Team> teams = new ArrayList<Team>();
        
    	File file = new File(filename);
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
    	System.out.println();
    	System.out.println("Filename: " + filename);
    	System.out.println("Modified At: " + sdf.format(file.lastModified()));
		System.out.println();
    	
        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] team = line.split(cvsSplitBy);
                Team t = new Team(team[0], Integer.parseInt(team[1]));
                teams.add(t);
            }
        } catch (IOException e) {
			System.out.println(e);
		}
        
        for (int x = 0; x < teams.size(); x++) {
        	int ws = ("| Team: " + teams.get(x).name).length();
            String border = new String(new char[ws]).replace("\0", "-");
        	System.out.println(delim + border + delim);
        	System.out.println("| Team: " + teams.get(x).name + " |");
        	int sp = ws - ("| Super Bowl Wins: " + teams.get(x).super_bowl_wins).length();
            String end = new String(new char[sp]).replace("\0", " ");
        	System.out.println("| Super Bowl Wins: " + teams.get(x).super_bowl_wins + end + " |");
        	System.out.println(delim + border + delim);
        	System.out.println();
        }
	}

}
