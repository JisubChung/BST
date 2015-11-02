package homework2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		BST bst = new BST();
		int[] intList = {1,2,3,4,5,6};
		int[] intPerm = {0,0,0,0,0,0};
		int[] average = {0,0};
	
		ArrayList<int[]> permutations = new ArrayList<int[]>();
		permuter(intList,permutations);
	}
	
	//intList = integers to be permuted
	//permutations = all the possible permutations of intList
	//intPerm = a temp int[] that holds for perumtations
	//prefix = where to start on intPerm
	public void permuter(int[] intList, ArrayList<int[]> permutations) {
		int[] intPerm = new int[intList.length];
		for (int i = 0; i < intPerm.length; i++) {
			intPerm[i] = 0;
		}
		permuter(0, intPerm, intList, permutations);
	}
	
	private void permuter(int prefix, int[] intPerm, int[] intList, ArrayList<int[]> permutations) {
		if(intList[intList.length-1] == 0) {
			permutations.add(intPerm);
			for(int i = 0; i < intPerm.length; i++) {
				System.out.print(" " + intPerm[i]);
			}
		}
		else {
			for(int i = 0; i < intList.length; i++) {
				if(intList[i] != 0) {
					intPerm[prefix] = intList[i];
					int[] intList2 = intList;
					intList2[i] = 0;
					permuter(prefix+1, intPerm, intList2, permutations);
				}
			}
		}
	}
	
	public void reset(int[] intList) {
		for(int i = 0; i < intList.length; i++) {
			intList[i] = i+1;
		}
	}
	
	public void treeInserter(BST tree, int[] intPerm) {
		for (int i = 0; i < intPerm.length; i++) {
			tree.insert(tree, intPerm[i]);
		}
	}
	
	
}