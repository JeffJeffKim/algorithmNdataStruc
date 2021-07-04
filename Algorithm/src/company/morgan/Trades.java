package company.morgan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Trades {
	
	private Long id;
	
	private String name;
//	private Trade trade;
	
	private Date date;
	
	private Instrument instrument; // multiple
	
	
	
	public List<Trades> main(String[] args) {
		
		
		/*
		 Map<Ins, List<
		 map<member, set<inst>>
		 */
		
//		Map<String, Set<String>> map;// instru, name
//		//O(1) - instruments search
//		//O(1) - search name
		

		
		// iterate
		Map<String, Set<String>> map1;// instru, name(trader)
//		//O(1) - instruments search
		// List : Bill & Steve
		
		
		// iterate
		Map<String, Set<String>> map;// name, instru
		//O(N) - N name count
		//O(1) 
		
		
		
		
		/*
		Trader : a, b, c
		Instru : x, y, z
		a ( x, y)
		b ( y, z)
		c ( x, z)
		
		1 - a, x
		2 - a, y
		3 - b, y
		4 - b, z
		*/
		
		
		
		
		
		
		List<Trades> trades = new ArrayList<>();
		return trades.stream()
			.filter(t -> t.name != "AAPL")
			.collect(Collectors.toList());
		
	}
	
	

}
