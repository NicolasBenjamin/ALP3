package mergeSort;

import abstract_soritng.Sorting_Algorithms;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays; 

public class MergeSort extends Sorting_Algorithms {	
	public MergeSort(){
		this(new int[100]);
		super.fillArrayRandom();
	}
	
	public MergeSort(int []arrayList) {
		super(arrayList);
	}
	
	public void mergeSort(){
		super.data = helper(super.data);
	}
	
	private int[] helper(int [] data) {		
		if(data.length <= 1){
			return data;
		}else{
			int middle = (int) (data.length / 2);
			
			createLeft(data,0,middle);				// splits the lists into half everytime its called -> end: list with one element
			createRight(data,middle,data.length);
				
			// calls the function to build the result list 
			// with recursive call of the splitted lists, so that at first the lists are splitted into list with one element and the merge function
			// combines every single list into the big result list 
			return merge(helper(createLeft(data,0,middle)), helper(createRight(data,middle,data.length)));
		}
		
	}
	private static int[] merge(int[] left, int[] right) {
		int [] accuList = new int[left.length+right.length];		// creates the result list
		int indexleft = 0;		// saving the current indexes for navigating in the lists 
		int indexright =0;
		int indexaccu = 0;
		
		// case that two not empty lists have to be combined 
		while(indexleft < left.length && indexright < right.length){
			if(left[indexleft] <= right[indexright]){		// comparing first elements of the two lists
				accuList[indexaccu] = left[indexleft];		// saving into result list
				indexleft = indexleft +1;					// decrease index for comparing next left element with first right
			}else{
				accuList[indexaccu] = right[indexright];	
				indexright = indexright +1;					// decrease index for comparing next right with first left
			}
			indexaccu = indexaccu +1;						// go to next index in resultlist and compare again or leave loop
		}
		
		// cases that one list is empty
		while( indexleft < left.length){
			accuList[indexaccu] = left[indexleft];
			indexleft = indexleft + 1;
			indexaccu = indexaccu +1; 
		}
		while(indexright < right.length){
			accuList[indexaccu] = right[indexright];
			indexright = indexright +1;
			indexaccu = indexaccu + 1;
		}
		
		return accuList;
	}

	// funcitons for creating left and right part of the list 
	private int[] createLeft(int[]list,int start,int end){
		int [] left = new int[end];
		for(int i=start;i<=left.length-1;i++){
			left[i] = list[i];
		}
		return left;
	}
	
	private int[] createRight(int[]list,int start,int end){
		int [] right = new int[end - start];
		for(int i=start;i<= end-1;i++){
			right[i-start] = list[i];
		}
		return right;
	}
}
