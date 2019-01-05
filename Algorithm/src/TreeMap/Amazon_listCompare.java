package TreeMap;

import java.util.*;

/**
 * 
 * @author DonYoo
 * 
 * the input is the list of list that has coordination.
 * 
 * found out the diagonal of coordination from 0,0.
 * 
 * then find most shortest path number of deliveries.
 * 
 * if the diagonal is same, print both.
 *
 * input : [[3,6],[2,4],[5,3],[2,7],[1,8],[6,3]]
 * deliver = 2
 * destination = 6
 * 
 * output : [[1,2], [1,3]

					Access		search		insert		delete		space
BinarySearchTree	O(log n)	O(log n)	O(log n)	O(log n)	O(n)

binary search trees (BST), sometimes called ordered or sorted binary trees, 

 */

public class Amazon_listCompare {

	static List<List<Integer>> ClosestXdestinations(int numDestinations,
			List<List<Integer>> allLocations, int numDeliveries)
	{
		List<List<Integer>> result = new ArrayList<>();
		
		// map has unique key. it can only contain only one key.		
		TreeMap<Double, List<List<Integer>>> tree = new TreeMap<>();
		
		// get each list and put them in the map.
		for(int i=0; i<numDestinations; i++){
			List<Integer> current = allLocations.get(i);
			int x = current.get(0);
			int y = current.get(1);
			
			double diagonal = Math.sqrt( Math.pow(x, 2) + Math.pow(y, 2) );
			
			// if tree contain same key.
			if(tree.containsKey(diagonal)){
				// add another coordination in the list.
				List<List<Integer>> existCoordination = tree.get(diagonal);
				existCoordination.add(current);
				tree.replace(diagonal, existCoordination);
			}
			else{
				List<List<Integer>> newCoordination = new ArrayList<>();
				newCoordination.add(current);
				tree.put(diagonal, newCoordination);
			}
		}
		
		System.out.println(tree);
		
		while(numDeliveries > 0){
			// get first entry.
			List<List<Integer>> output = tree.pollFirstEntry().getValue();
			
			// go through first entry
			for(int i=0; i<output.size(); i++){
				result.add(output.get(i));
				numDeliveries--;
				
				// if drivers are out, done.
				if(numDeliveries == 0){
					break;
				}
			}
		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> input = new ArrayList<>();
		
		int numberOfDestination = 6;
		int numberOfDriver = 4;
		
		List<Integer> point1= new ArrayList<>();
		point1.add(3);
		point1.add(6);
		input.add(point1);
		List<Integer> point2= new ArrayList<>();
		point2.add(2);
		point2.add(4);
		input.add(point2);
		List<Integer> point3= new ArrayList<>();
		point3.add(5);
		point3.add(3);
		input.add(point3);
		List<Integer> point4= new ArrayList<>();
		point4.add(2);
		point4.add(7);
		input.add(point4);
		List<Integer> point5= new ArrayList<>();
		point5.add(1);
		point5.add(8);
		input.add(point5);
		List<Integer> point6= new ArrayList<>();
		point6.add(6);
		point6.add(3);
		input.add(point6);
		
		
		System.out.println("Destination : " + numberOfDestination + " Drivers : " + numberOfDriver + "\n");
		System.out.println(input);
		
		System.out.println(
				ClosestXdestinations(numberOfDestination, input, numberOfDriver)
				);
		
	}

}
