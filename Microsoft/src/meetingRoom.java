
import java.util.*;

/**
 * 
 * @author DonYoo

http://blog.gainlo.co/index.php/2016/07/12/meeting-room-scheduling-problem/

Given a list of meeting times, checks if any of them overlaps. 

The follow-up question is to return the minimum number of rooms required to accommodate all the meetings.

Let’s start with an example. Suppose we use interval (start, end) to denote the start and end time of the meeting, 

we have the following meeting times: (1, 4), (5, 6), (8, 9), (2, 6).

In the above example, apparently we should return true for the first question since (1, 4) and (2, 6) have overlaps.

For the follow-up question, we need at least 2 meeting rooms so that (1, 4), (5, 6) will be put in one room and (2, 6), (8, 9) will be in the other.

The meeting room scheduling problem was asked by Facebook very recently and there are quite a few similar problems.

 *
 */


/*
 *  process time for sort O(NlogN)
 *  space O(n)
 */


/*
 * Comparator

Comparator interface is used to order the objects of user-defined classes. A comparator object is capable of comparing two objects of two different classes. Following function compare obj1 with obj2

compare List<Integer>
 */
class doncomp implements Comparator<List<Integer>> {
	
	// if result is negative, the second value is bigger
	// if positive, the first value is bigger
	
	@Override
	public int compare(List<Integer> o1, List<Integer> o2){
		for( int i=0; i<Math.min(o1.size(), o2.size()); i++){
			int c = o1.get(i).compareTo(o2.get(i));
			
			// if o1 and o2 is not same number
			if( c !=0 ){
				return c;
			}
		}
		// if they are same char, compare the length of the number.
		return Integer.compare(o1.size(), o2.size());
	}
	
}

public class meetingRoom {
	
	public static int findRoomNo(List<List<Integer>> input){

		ArrayList<Integer> time = new ArrayList<>();
		
		// get first end time and put it in the array.
		time.add(input.get(0).get(1));
		
		// go through the list and compare the start and end time of each.
		
		for(int i=1; i<input.size(); i++){
			int start = input.get(i).get(0);
			int end = input.get(i).get(1);
			
			boolean change = false;
			
			// go through time array and check the end time collapse with next start time
			for(int j=0; j<time.size(); j++){
				// doesn't collapse with next time
				if(time.get(j) <= start){
					time.set(j, end);
					change = true;
					break;
				}
			}
			
			// if end time collapse with every start time, add new room.
			if(change ==false){
				time.add(end);
			}
		}

		return time.size();
	}
	
	public static void main(String[] args) {
		
		List<List<Integer>> input = new ArrayList<>();
		
		List<Integer> words1 = new ArrayList<>();
		words1.add(1);
		words1.add(4);
		
		List<Integer> words2 = new ArrayList<>();
		words2.add(5);
		words2.add(6);
		
		List<Integer> words3 = new ArrayList<>();
		words3.add(6);
		words3.add(9);
		
		List<Integer> words4 = new ArrayList<>();
		words4.add(2);
		words4.add(6);
		
		input.add(words1);
		input.add(words2);
		input.add(words3);
		input.add(words4);
		
		System.out.println("original input:\t" + input);
		
		// sort the list first. O(nlogn) collections.sort
		Collections.sort(input, new doncomp());
		
		System.out.println("sorted input:\t" + input);
		
		System.out.println(findRoomNo(input));	
	}
}