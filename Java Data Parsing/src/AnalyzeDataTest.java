import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner; 

public class AnalyzeDataTest {

	public static void main(String[] args) throws FileNotFoundException {
		// pass the path to the file as a parameter 
	    File file = new File("C:\\Users\\FredQ\\Documents\\plantLocations.txt"); 
	    AnalyzeData ad = new AnalyzeData(file);
	    //System.out.println(Arrays.toString(ad.topResults("wa")));
	    //System.out.println(Arrays.toString(ad.topResults("lb")));
	    File statesFile = new File("C:\\Users\\FredQ\\Documents\\states.txt"); 
	    Scanner sc = new Scanner(statesFile); 
	    String[] allFull = new String[50];
	    String[] allAbbrev = new String[50];
	    int counter = 0;
	    while (sc.hasNextLine()) { 
	    	String inString = sc.nextLine();
	    	String[] values = inString.split(",");
	    	allFull[counter] = "\"" + values[0] + "\"";
	    	allAbbrev[counter] = values[1].toLowerCase();
	    	counter++;
	    }
	    for (int i = 0; i < allFull.length; i++) {
	    	//System.out.println(allFull[i] + Arrays.toString(ad.topResults(allAbbrev[i])));
	    }
	    //System.out.println("\"" + Arrays.toString(allFull) + "\"");
	    //System.out.println(Arrays.toString(allAbbrev));
	    for (int k = 0; k < allFull.length; k++) {
	    	//System.out.println(Arrays.toString(ad.topResults(allAbbrev[k])));
	    	String[] associated = ad.topResults(allAbbrev[k]);
	    	System.out.println(allFull[k] + Arrays.toString(associated));
	    }
	    
	}
}
/*
public static void main(String[] args) throws FileNotFoundException {
	// pass the path to the file as a parameter 
    File file = new File("C:\\Users\\FredQ\\Documents\\plantLocations.txt"); 
    Scanner sc = new Scanner(file); 
    HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
    while (sc.hasNextLine()) { 
    	String inString = sc.nextLine();
    	//System.out.println(inString);
    	String[] values = inString.split(",");
    	String plantName = values[0];
    	String[] states = Arrays.copyOfRange(values, 1, values.length);
    	for (String s: states) {
    		if (!hm.containsKey(s)) {
    			//System.out.println(1);
    			ArrayList<String> newList = new ArrayList<String>();
    			newList.add(plantName);
    			hm.put(s, newList);
    		}
    		else {
    			ArrayList<String> a = hm.get(s);
    			a.add(plantName);
    			hm.put(s, a);
    		}
    		
    	}
    	
  }	
    System.out.println("Enter a state: ");
    Scanner ui = new Scanner(System.in);
    String i = ui.next();
    ArrayList<String> test = hm.get("fl");
    for(int j = 0; j < 10; j++) {
    	System.out.println(test.get(j));
	}

}*/