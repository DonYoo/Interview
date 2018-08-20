package HashTables;
import java.util.Scanner;
import java.util.*;

/**
 * 
 * @author DonYoo

LRU = least recently used

map and queue.

map : time (1) space (n)
queue : time(n) space(n)

https://practice.geeksforgeeks.org/problems/lru-cache/1

The task is to design and implement methods of an LRU cache. The class has two methods get and set which are defined as follows.
get(x)   : Gets the value of the key x if the key exists in the cache otherwise returns -1
set(x,y) : inserts the value if the key x is not already present. If the cache reaches its capacity it should invalidate the least recently used item before inserting the new item.
In the constructor of the class the size of the cache should be intitialized.
 
Input:
The first line of input contain an integer T denoting the no of test cases. Then T test case follow. Each test case contains 3 lines. The first line of input contains an integer N denoting the capacity of the cache and then in the next line is an integer Q denoting the no of queries Then Q queries follow. A Query can be of two types
1. SET x y : sets the value of the key x with value y
2. GET x : gets the key of x if present else returns -1.

Output:
For each test case in a new line output will be space separated values of the query.

Constraints:
1<=T<=100
1<=N<=10
1<=Q<=100

Example(To be used only for expected output):
Input
2
2
2
SET 1 2 GET 1
2
7
SET 1 2 SET 2 3 SET 1 5 SET 4 5 SET 6 7 GET 4 GET 1

Output
2
5 -1

 */

class LRU_Cache
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
				LRUCache g = new LRUCache(n);
			int q = sc.nextInt();
			
			while(q>0)
			{
			
				String c = sc.next();
			//	System.out.println(c);
				if(c.equals("GET"))
				{
					int x = sc.nextInt();
					System.out.print(g.get(x)+" ");
				}
				if(c.equals("SET"))
				{
					int x = sc.nextInt();
					int y  = sc.nextInt();
					g.set(x,y);
				}
			
			q--;
			//System.out.println();
			}
		t--;
		System.out.println();
		}
		
		sc.close();
	}
}


class LRUCache {

    /*Initialize an LRU cache with size N */
	
	static LinkedList<Integer> cache;
	static Map<Integer, Integer> map;
	static int size;
	
    public LRUCache(int N) {
    	cache = new LinkedList<Integer>();
    	map = new HashMap<>();
    	size = N;
    }
    
    
    /*Returns the value of the key x if 
     present else returns -1 
     
     When get function is called.
	Whenever get function is called, Don't forget to update the Queue.

     */
    public void update(int x){
    	int index = cache.indexOf(x);
		cache.remove(index);
		cache.addLast(x);
    }
    
    public int get(int x) {
    	if(map.get(x) != null){
    		update(x);
    		return map.get(x);
    	}
		return -1;
    }
    
    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {

    	// if key is already exist
    	if(map.containsKey(x)){
    		map.replace(x, y);
    		update(x);
    	}
    	// if the cache is bigger than capacity.
    	else if(cache.size() >= size){
			int remove = cache.removeFirst();
			cache.addLast(x);
			map.remove(remove);
			map.put(x, y);
        }
    	else{
    		cache.addLast(x);
    		map.put(x, y);
    	}
    }
}
