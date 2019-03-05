package Test;

import java.util.*;
import java.io.*;
import java.io.Reader;
import java.lang.*;

public class Project {
	public static void main(String args[]) throws Exception {
		File folder = new File("Filename");
		FileReader fr = new FileReader(folder);
		BufferedReader br = new BufferedReader(fr);
		Map<String, Integer> map = new HashMap<>();
		Map<Integer, String> finalmap = new HashMap<>();
		for (File f : folder.listFiles()) {
			String s = br.readLine();
			while (s == null) {
				if (s.startsWith("<")) {
					s.replace("<", "");
					s.replace(">", "");
					if (map.containsKey(s)) {
						map.put(s, map.get(s) + 1);
						s = br.readLine();
					} else {
						map.put(s, 1);
						s = br.readLine();
					}

				}

			}
		}

		for (int l : map.values()) {
			for (String key : map.keySet()) {
				finalmap.put(l, key);

			}
		}
		TreeMap<Integer, String> sorted = new TreeMap<>();
        sorted.putAll(finalmap);
        
        for(int i : sorted.keySet() ) {
        	System.out.println(i + " is the number of times " + sorted.get(i) + "repeated");
        }
	}
}
