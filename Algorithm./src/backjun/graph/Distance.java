package backjun.graph;

public class Distance implements Comparable<Distance>{
	int idx, dist;
	
	public Distance(int idx, int dist) {
		this.idx = idx;
		this.dist = dist;
	}

	@Override
	public int compareTo(Distance d) {
		// TODO Auto-generated method stub
		if(dist == d.dist)	return Integer.compare(idx, d.idx);
		return Integer.compareUnsigned(d.dist, dist);
	}
	
}