package quickSort;

import java.lang.reflect.Array;

import abstract_soritng.Sorting_Algorithms;

public class QuickSort extends Sorting_Algorithms{
	private int left = 0;
	private int right;
	private int divider;
	
	public QuickSort(){
		this(new int[100]);
		super.fillArrayRandom();
	}
	
	public QuickSort(int [] array){
		super(array);
		right = super.data.length -1;
	}
	
	public void quickSort(){
		helper(left, right);
	}

	private void helper(int l, int r) {
		if(l < r){
			setDivider(divide(l,r));	// sorts the left and right side of the pivot element
			helper(l,getDivider()-1);	// recursive call right list
			helper(getDivider()+1,r);	// recursive call left list 
		}
	}

	private int divide(int l, int r) {
			int i = l;			// index left side
			int j = r;		// index right side
			int pivot = super.data[r];
			
			while(i<j){
				// searches in left part of list for equal/bigger elements than pivot -> stop -> index with bigger element
				while(super.data[i] < pivot & i < r){
					i = i+1;
				}
				// searches in rigth part of list for lower elements than pivot -> index with lower element
				while(super.data[j] > pivot & j > l){
					j=j-1;
				}
				// change of elements in left/right lists
				if(i<j){
					int temp = super.data[i]; // tempory safe of element for change
					super.data[i] = super.data[j];
					super.data[j] = temp;
				}
			}
			// i is border of both parts of the list, left lower, rigth bigger than pivot 
			// setting new pivot element
			if(super.data[i] > pivot){
				int help = super.data[i];
				super.data[i] = pivot;
				pivot = help;
			}	
			// return index of pivot element
		return i;
	}

	public int getDivider() {
		return divider;
	}

	public void setDivider(int divider) {
		this.divider = divider;
	}
	
	
	
}	

