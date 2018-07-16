import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Pairs {
	
	private int x, y;

    // Input (a|b)	
	public Pairs(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static void main(String[] args) {
	     Scanner in = new Scanner(System.in);
	     LinkedList<Pairs> l = new LinkedList<Pairs>(); // list of inputs
         // using a hash map inside a hash map for quicker search
	     Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
	     Map <Integer,Integer> temp;
	     while (in.hasNext()) {
	    	 // Seperate first from second part
	    	 String[] p = in.next().split("\\|");
	    	 int a = Integer.parseInt(p[0]);
	    	 int b = Integer.parseInt(p[1]);
             // get inner map if exists, else create it
	    	 if (map.containsKey(a)) temp = map.get(a);
	    	 else temp = new HashMap<Integer,Integer>();
            // don't want duplicate entries in the inner map	    	 
            if (!temp.containsKey(b)) {
	    		 temp.put(b, temp.size());
	    		 map.put(a, temp);
	    	 }
	    	 l.add(new Pairs(a,b));
	     }
	     in.close();
	     for (Pairs h:l) { // for each element in the list of inputs
	    	 temp = map.get(h.x);
	    	 System.out.println(h.x + "|" + h.y + "[" + (temp.get(h.y)+1) + " of " + temp.size() + "]"); // print the proper message
	     }
	}
}
