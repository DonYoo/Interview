package Tree;

import java.util.*;

class Tree{
	int data;
	Tree left,right;
	Tree(int d){
		data=d;
		left=null;
		right=null;
	}
}

class afa
{
	public static int subPathsSum(Tree root, LinkedList<Integer> stack, int[] sum){
		if(root == null){
			return 0;
		}
		// push the data.
		stack.addFirst(root.data);

		int left = subPathsSum(root.left, stack, sum);

		// if left node is 0, current node is the edge.
		if(left == 0){
			// calculate
			int size = stack.size();

			for(int i=0; i<size; i++){
				double test = stack.get(i) * Math.pow(10,i);
				//System.out.println(test);
				sum[0] += test;
			}
		}
		int right = subPathsSum(root.right, stack, sum);

		// remove after 
		stack.removeFirst();
		return sum[0];
	}

	public static int treePathsSum(Tree root)
	{
		LinkedList <Integer> stack = new LinkedList<>();
		int [] sum = new int[1];

		return subPathsSum(root, stack, sum);
	}
}

public class treePathsSum {
	public static void insert(Tree root,int n1,int n2,char lr){
		if(root==null)
			return;
		if(root.data==n1){
			switch(lr){
			case 'L':root.left=new Tree(n2);
			break;
			case 'R':root.right=new Tree(n2);
			break;
			}
		}
		else{
			insert(root.left,n1,n2,lr);
			insert(root.right,n1,n2,lr);
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Tree root=null;
			if(n==0){
				System.out.println("0");
				continue;
			}
			if(n==1){
				System.out.println(sc.nextInt());
				continue;
			}
			else{
				while(n-->0){
					int n1=sc.nextInt();
					int n2=sc.nextInt();
					char lr=sc.next().charAt(0);
					if(root==null){
						root=new Tree(n1);
						switch(lr){
						case 'L':root.left=new Tree(n2);
						break;
						case 'R':root.right=new Tree(n2);
						break;
						}
					}
					else{
						insert(root,n1,n2,lr);
					}
				}
			}
			//				inorder(root);
			afa g=new afa();
			System.out.println(g.treePathsSum(root));
		}
	}
}
