package bubbleSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import abstract_soritng.Sorting_Algorithms;

public class BubbleSort extends Sorting_Algorithms{
	
	private boolean swaped; 
	private int arraySize;
	private double runtime;
	
	
	public BubbleSort(){
		this(new int[100]);
		super.fillArrayRandom();
	}
	
	public BubbleSort(int [] list){
		super(list);
	}
		
	public void bubblesort (){
		setSwaped(true);			// safe status if swaped or not 
		int n = super.getSize();		
		while(isSwaped() == true){
			setSwaped(false);	
			for(int i=0; i < n-1; i++){		// check every element 
				if(super.data[i] > super.data[i+1]){	// swap element if true
					int temp = super.data[i];
					super.data[i] = super.data[i+1];		// swaping
					super.data[i+1] = temp;
					setSwaped(true);		// set swaped true
				}
			}
			n = n-1;		// increase n for while loop
		}		
	}

	public void setList(int arraySize){
		
	}
	
	public int getArraySize() {
		return arraySize;
	}

	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}

	public boolean isSwaped() {
		return swaped;
	}

	public void setSwaped(boolean swap) {
		this.swaped = swap;
	}

	public double getRuntime() {
		return runtime;
	}

	public void setRuntime(double runtime) {
		this.runtime = runtime;
	}
	
	
}


