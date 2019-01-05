package BFS;

import java.util.*;

/**
 * 
 * @author DonYoo

BFS
Breadth first search
find the shortest path on 2D map.

0 = can't go
1 = road

9 = destination

[1, 1, 1]
[0, 0, 1]
[1, 9, 0]

 */


// make a class for coordination.
// track the x, y and step

class coordination{
	int x;
	int y;
	
	int step;
	
	public coordination(int x, int y, int step){
		this.x = x;
		this.y = y;
		this.step = step;
	}	
}


public class Amazon_finalDestination {

	// return the 0, 1, or 9. the road status.
	static int checkRoad(coordination coord, List<List<Integer>> area){
		return area.get(coord.x).get(coord.y);
	}
	
	static int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
	{
		coordination start = new coordination(0,0,0);
		
		// queue for tracking the all possible path.
		Queue <coordination> que = new LinkedList<>();
		
		que.add(start);
		
		System.out.println("tracking the path");
		while(!que.isEmpty()){
			coordination current = que.poll();
			int x = current.x;
			int y = current.y;

			System.out.println(x +" " + y);
			
			int road = checkRoad(current, area);
			
			// check if its destination.
			if(road == 9){
				return current.step;
			}
			
			// check if its road or not
			if(road == 1){
				// check 4 ways
				// left 
				if(y-1 >= 0){
					coordination left = new coordination(x, y-1, current.step+1);
					if(checkRoad(left, area) != 0){
						que.add(left);
					}
				}
				// right
				if(y+1 < numColumns){
					coordination right = new coordination(x, y+1, current.step+1);
					if(checkRoad(right, area) != 0){
						que.add(right);
					}
				}
				// up
				if(x-1 >= 0){
					coordination down = new coordination(x-1, y, current.step+1);
					if(checkRoad(down, area) != 0){
						que.add(down);
					}
				}
				// down
				if(x+1 < numRows){
					coordination up = new coordination(x+1, y, current.step+1);
					if(checkRoad(up, area) != 0){
						que.add(up);
					}
				}
			}
			// important.
			// marked that visited.
			area.get(x).set(y, 0);
		}
		return 0;
	}
	
	
	public static void main (String[] args)
	{
		List<List<Integer>> area = new LinkedList<>();

		List<Integer> test1 = new LinkedList<>();
		test1.add(1);
		test1.add(1);
		test1.add(1);

		List<Integer> test2 = new LinkedList<>();
		test2.add(1);
		test2.add(0);
		test2.add(1);
		
		List<Integer> test3 = new LinkedList<>();
		test3.add(1);
		test3.add(9);
		test3.add(1);

		area.add(test1);
		area.add(test2);
		area.add(test3);
		
		for(int i=0; i<area.size(); i++){
			System.out.println(area.get(i));
		}
		System.out.println();
		System.out.println("shortest path " + minimumDistance(area.size(), area.get(0).size(), area));
	}

}
