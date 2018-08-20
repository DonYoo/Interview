package Recursion;

public class fibonacci {

	static int[] dp;
	
	// dynamic programming
	// memorization
	// time : O(n)
	// space : O(n)
	// top down
	public static int fibanachi(int n){
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		// if there is data exit, just return
		if(dp[n] != -1){
			return dp[n];
		}
		// if dp is empty, calculate and put them in the array
		dp[n] = (fibanachi(n-1) + fibanachi(n-2));
		return dp[n];
	}
	

	// using for loop
	// bottom up
	public static int bottom_up(int n){
		// base line
		dp[0] = 0;
		dp[1] = 1;
		
		// process
		for(int i=2; i<=n; i++){
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		int n = 10;
		dp = new int[n+1];
		
		for(int i=0; i<n+1; i++){
			dp[i]=-1;
		}
		System.out.println(fibanachi(n));
		System.out.println(bottom_up(n));
	}

}
