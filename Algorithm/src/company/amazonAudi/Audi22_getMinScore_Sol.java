package company.amazonAudi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Audi22_getMinScore_Sol {
	public static int result1 = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
//        List<Integer> list1 = Arrays.asList(1, 2, 2, 3, 4, 5);
//        List<Integer> list2 = Arrays.asList(2, 4, 5, 5, 5, 6);
//		System.out.println(getMinScore(6, list1, list2));
        List<Integer> list1 = Arrays.asList(1, 2, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(2, 4, 5, 5, 5, 6);
        System.out.println(getMinScore(6, list1, list2));
		
	}
	
	public static int getMinScore(int productsNodes, List<Integer> productsFrom, List<Integer> productsTo) {
        int result = Integer.MAX_VALUE;
        List<ArrayList<Integer>> listRelation = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<productsNodes; i++) {
        	listRelation.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<productsFrom.size(); i++) {
        	listRelation.get(productsFrom.get(i)-1).add(productsTo.get(i)-1);
        	listRelation.get(productsTo.get(i)-1).add(productsFrom.get(i)-1);
        }
        
        
        // first..
        for(int i=0; i<listRelation.size(); i++) {
        	
        	// second
        	for(int j=0; j<listRelation.get(i).size(); j++) {
        		int secElem = listRelation.get(i).get(j);
        		
        		// third
        		for(int k=0; k<listRelation.get(secElem).size(); k++) {
        			int third = listRelation.get(secElem).get(k);
        			
        			if(listRelation.get(third).contains(i)) {
        				List<Integer> trio = new ArrayList<Integer>();
        				trio.add(i);
        				trio.add(secElem);
        				trio.add(third);
        				
        				int count = cntTrio(trio, listRelation);
        				if(result > count)
        					result = count;
        			}
        		}// third
        		
        	}// second
        	
        }// first..
        
        if(result == Integer.MAX_VALUE)
        	result = -1;
        return result;
    }
	
	static int cntTrio(List<Integer> trio, List<ArrayList<Integer>> listRelation) {
		int result = 0;
		
		int first = trio.get(0);
		int second = trio.get(1);
		int third = trio.get(2);
		
		for(int cur : listRelation.get(first)) {
			if(cur != second && cur != third)
				result++;
		}
		
		for(int cur : listRelation.get(second)) {
			if(cur != first && cur != third)
				result++;
		}
		
		for(int cur : listRelation.get(third)) {
			if(cur != second && cur != first)
				result++;
		}
		
		return result;
	}
	
	
	

}

/*
Question 2 - Social Media Connections
Social media connections can serve as a means of recognizing relationships among a group of people.
These relationships can be represented as an undirected graph where edges join related people.
A group of n social media friends is uniquely numbered from 1 to friend_nodes.
The group of friends is expressed as a graph with friend_edges undirected edges,
where each pair of best_friends is directly connected by an edge.
A trio is defined as a group of three best friends.
The friendship score for a person in a trio is defined as the number of best friends
that person has outside of the trio.
The friendship sum for a trio is the sum of trio's friendship scores.

Given friendship connection data, create an undirected graph and determine the minimum friendship sum
for all trios of best friends in the group.
If no such trio exists, return -1

Example Input -
friend_nodes = 6
friend_edges = 6
friends_from = [1, 2, 2, 3, 4, 5]
friends_to = [2, 4, 5, 5, 5, 6]

Example Output -
3

Explanation -
If cycle is present, count the no of vertices
that are not part of the cycle and connected to any of the vertices of the cycle
Trio formed is among {2, 4, 5}
Friends of 2 other than 4,5 are {1} => total count = 1
Friends of 4 other than 2,5 are {} => total count = 0
Friends of 5 other than 2,4 are {3, 6} => total count = 2
Sum of total count = 3
 */

/*
public int getMinScore( int products_nodes, int products_edges,int[] products_from,int[] products_to) {
        HashMap<Integer, Set<Integer>> graph = new HashMap();
        int minProductSum = Integer.MAX_VALUE;
        for(int i = 0; i < products_edges; i++){
            int from = products_from[i];
            int to = products_to[i];
            graph.computeIfAbsent(from, k -> new HashSet<Integer>()).add(to);
            graph.computeIfAbsent(to, k -> new HashSet<Integer>()).add(from);
        }

        for(int node : graph.keySet()){
            Set<Integer> neis = graph.get(node);
            if(neis.size() < 2) continue;
            for(int nei1 : neis){
                Set<Integer> nei2s = graph.get(nei1);
                Set<Integer> nei3s = findSharedNeighbors(neis, nei2s);
                for(int nei3 : nei3s){
                    int productSum = neis.size() + nei2s.size() + graph.get(nei3).size() - 6;
                    minProductSum = Math.min(minProductSum, productSum);
                }
            }
        }

        return minProductSum == Integer.MAX_VALUE? -1 : minProductSum;

    }

    public Set<Integer> findSharedNeighbors(Set<Integer> l1, Set<Integer> l2){
        Set<Integer> res = new HashSet();
        for(int node : l1){
            if(l2.contains(node)){
                res.add(node);
            }
        }

        return res;
    }
 */

/*
public int getMinimumLocationSum(int location_nodes, int location_edges, int[] from, int[] to) {
		Map<Integer, List<Integer>> adjMap = new HashMap<>();
		Set<int[]> visited = new HashSet<>();
		int min_location_sum = -1;
		for (int i = 1; i <= location_nodes; i++) {
			adjMap.put(i, new ArrayList<>());
		}
		for (int i = 0; i < location_edges; i++) {
			adjMap.get(from[i]).add(to[i]);
			adjMap.get(to[i]).add(from[i]);
		}
		System.out.println(adjMap);
		//Start with a node
		for (Integer node : adjMap.keySet()) {
			//Find the neighbors of that node
			List<Integer> neighbors = adjMap.get(node);
			//For each of the neighbors...
			for (Integer neighbor : neighbors) {
				//Find the neighbors of the neighbor
				List<Integer> neighbor_neighbors = adjMap.get(neighbor);
				//Get the shared neighbors which are trios
				Set<Integer> shared_neighbors = neighbor_neighbors.stream().distinct().filter(neighbors::contains).collect(Collectors.toSet());
				if (!shared_neighbors.isEmpty()) {
					for (Integer shared_neighbor : shared_neighbors) {
						int[] trio = new int[3];
						trio[0] = node;
						trio[1] = neighbor;
						trio[2] = shared_neighbor;
						Arrays.sort(trio);
						if (!visited.contains(trio)) {
							visited.add(trio);
							int degree = neighbors.size() + neighbor_neighbors.size() + adjMap.get(shared_neighbor).size();
							int location_sum = degree - 6;  // Degree minus 6!
							if (min_location_sum == -1) {
								min_location_sum = location_sum;
							} else {
								min_location_sum = Math.min(min_location_sum, location_sum);
							}
						}
					}
				}
			}
		}
		return min_location_sum;
	}
 */