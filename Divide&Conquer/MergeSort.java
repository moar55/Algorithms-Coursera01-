import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		//Test here...
	}

	static int [] mergeSort(int [] input){
	    
	    if(input.length==1)
	    	return input;
	    
	    /* The else if part is to reduce the code by one recursive call */ 
	    // I don't think it would make much of a difference , but I didn't want to remove it after thinking of it :) 

	    else if(input.length==2){
	    	if(input[0]<=input[1])
	    		return input;
	    	else{
	    		int temp = input[0];
	    		input[0]=input[1];
	    		input[1]=temp;
	    		return input;
	    	}	
	    }

	    	    
	   return merge(mergeSort(Arrays.copyOfRange(input, 0, input.length/2)),mergeSort(Arrays.copyOfRange(input, input.length/2, input.length)));
	    
	}
	
	static int [] merge(int [] a, int [] b){
		int [] output = new int [a.length+b.length];
		int i= 0,j=0,w=0 ; 
		while(a.length!=i && b.length!=j){
			if(a[i]>=b[j]){
				output[w]=b[j];
				j++;
			}
			else{
				output[w]=a[i];
				i++;
			}
			w++;
		}
		if(i==a.length){
		return concatAtIndex(output,w,b,j);
		}
		else{

			return concatAtIndex(output,w,a,i);
		}
	}
	
	static int [] concatAtIndex(int [] output, int w, int [] a, int i){
			for (; i < a.length; i++,w++) {
				output[w]=a[i];
			}
			return output;
	}
	}

