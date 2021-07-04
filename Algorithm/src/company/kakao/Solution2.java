package company.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution2 {
	
	public static void main(String[] args) {
		var items = new ArrayList<ArrayList<String>>();
//		[['p1', '1', '2'], ['p2', '2', '1']]
		items.add(new ArrayList<>());
		items.get(0).add("p1");
		items.get(0).add("1");
		items.get(0).add("2");
		items.add(new ArrayList<>());
		items.get(1).add("p2");
		items.get(1).add("2");
		items.get(1).add("1");
		System.out.println(solution(items, 0, 0, 1, 0));

		items = new ArrayList<ArrayList<String>>();
		items.add(new ArrayList<>());
		items.get(0).add("owjevtkuyv");
		items.get(0).add("58584272");
		items.get(0).add("62930912");
		items.add(new ArrayList<>());
		items.get(1).add("rpaqgbjxik");
		items.get(1).add("9425650");
		items.get(1).add("96088250");
		items.add(new ArrayList<>());
		items.get(2).add("dfbkasyqcn");
		items.get(2).add("37469674");
		items.get(2).add("46363902");
		items.add(new ArrayList<>());
		items.get(3).add("vjrrisdfxe");
		items.get(3).add("18666489");
		items.get(3).add("88046739");
		System.out.println(solution(items, 2, 1, 2, 0));
	}
	
	/*
     * Complete the 'solution' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_STRING_ARRAY items
     *  2. INTEGER orderBy
     *  3. INTEGER orderDirection
     *  4. INTEGER pageSize
     *  5. INTEGER pageNumber
     */

    public static List<String> solution(ArrayList<ArrayList<String>> items, int orderBy, int orderDirection, int pageSize, int pageNumber) {
    // Write your code here
    	List<String> result = new ArrayList<String>();
    	Item[] arrItem = new Item[items.size()];
    	List<Item> list = new ArrayList<>();
    	for(int i=0; i<items.size(); i++) {
    		Item cur = new Item(items.get(i).get(0), Integer.parseInt(items.get(i).get(1)), Integer.parseInt(items.get(i).get(2)));
    		arrItem[i] = cur;
    		list.add(cur);
    	}
    	
    	if(orderDirection == 0) {
    		if(orderBy == 0) {
    			Collections.sort(list, Comparator.comparing(i -> i.name));
        	}else if(orderBy == 1) {
        		Collections.sort(list, Comparator.comparing(i -> i.cate));
        	} else {
        		Collections.sort(list, Comparator.comparing(i -> i.price));
        	}
    	} else {
    		if(orderBy == 0) {
//    			Collections.sort(list, new Comparator<Item>() {
//    				@Override
//    				public int compare(Item o1, Item o2) {
//    					return -(o1.name.compareTo(o2.name));
//    				}
//    			});
    			Collections.sort(list, (o1, o2) -> -(o1.name.compareTo(o2.name)));
        	}else if(orderBy == 1) {
        		Collections.sort(list, new Comparator<Item>() {
        			@Override
        			public int compare(Item o1, Item o2) {
        				return o2.cate - o1.cate;
        			}
        		});
        	} else {
        		Collections.sort(list, new Comparator<Item>() {
        			@Override
        			public int compare(Item o1, Item o2) {
        				return o2.price - o1.price;
        			}
        		});
        	}
    		
    	}
    	int s = pageSize * pageNumber;
    	int e = s + pageSize;
    	if(e > items.size())
    		e = items.size();
    	if(s <= items.size() ) {
    		for(int i=s; i<e; i++) {
    			result.add(list.get(i).name);
    		}
    	}
    	
    	return result;
    }
    
    static class Item {
    	String name;
    	int cate;
    	int price;
		public Item(String name, int cate, int price) {
			this.name = name;
			this.cate = cate;
			this.price = price;
		}
		@Override
		public String toString() {
			return "[name=" + name + ", cate=" + cate + ", price=" + price + "]";
		}
		
    }

}
