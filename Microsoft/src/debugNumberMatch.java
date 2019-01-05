
/**
 * 
 * @author DonYoo

https://www.careercup.com/forumpost?id=6220310781100032

3. The following program increases/decreases the value of A and B until A is equal to X and B is equal to Y. Find the bug:

 */

public class debugNumberMatch {

	public static void MakeTheNumbersMatch(int a, int b, int x, int y)
	{
		while(a!=x && b!=y)
		{
			if(a> x)
			{
				a--;
			}
			// should be less than
			else if(a < x)
			{
				a++;
			}
			if(b>y)
			{
				b--;
			}
			// should be less than
			else if(b < y)
			{
				b++;
			}
		}
	}
}
