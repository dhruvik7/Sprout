import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner; 

public class AnalyzeData {
	public HashMap<String, ArrayList<String>> hm;
	public HashMap<String, String> names;
	
	public AnalyzeData(File file) throws FileNotFoundException { 
	    Scanner sc = new Scanner(file); 
	    hm = new HashMap<String, ArrayList<String>>();
	    names = new HashMap<String, String>();
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
	}
	
	public void changeName() {
		names.put("ophiopogon jaburan", "Black grass");
		names.put("sinapis arvensis", "Charlock");
		names.put("galium aparine", "Cleavers");
		names.put("stellaria media", "Common chickweed");
		names.put("triticum aestivum", "Common wheat");
		names.put("chenopodium album", "Fat hen");
		names.put("apera spica-venti", "Loose silky-bent");
		names.put("zea mays", "Maize");
		names.put("tripleurospermum", "Scentless mayweed");
		names.put("capsella bursa-pastoris", "Shepherds purse");
		names.put("geranium pusillum", "Small-flowered cransebill");
		names.put("beta vulgaris", "Sugar beet");
	}
	public String toImage(String s) {
		String my_new_str = s.replaceAll(" ", "_") + ".jpg";
		return my_new_str;
	}
	public String[] topResults(String state) {
		String priorities = "ophiopogon jaburan,sinapis arvensis,galium aparine,stellaria media,triticum aestivum,chenopodium album,apera spica-venti,zea mays,tripleurospermum,capsella bursa-pastoris,geranium pusillum,beta vulgaris";
		String[] values = priorities.split(",");
		String[] out = new String[5];
		changeName();
		//System.out.println(hm.get(state).toArray()); // method 1
		if (hm.containsKey(state)) {
			ArrayList<String> results = hm.get(state);
			int counter = 0;
			for(int i = 0; i < values.length; i++) {
				if (hm.containsKey(state) && hm.get(state).contains(values[i])) {
					if (counter <= 4) {
						if (names.containsKey(values[i])) {
							out[counter] = names.get(values[i]);
						} else {
							out[counter] = values[i];
						}
					}
					counter++;
				}
			}
			for(int j = 4; j > counter; j--) {
				int random = (int)(Math.random() * results.size());
				while(results.get(random) == null) {
					random = (int)(Math.random() * results.size());
				}
				out[j] = results.get(random);
			}
		}
		return out;
	}
}