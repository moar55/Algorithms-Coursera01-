import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		//Test here...
	}

	public static int [] mergeSort(int [] input){
	    
	    if(input.length==1)
	    	return input;
	    
	   return merge(mergeSort(Arrays.copyOfRange(input, 0, input.length/2)),
	   		mergeSort(Arrays.copyOfRange(input, input.length/2, input.length)));
	    
	}
	
	public static int [] merge(int [] a, int [] b){
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
	
	public static int [] concatAtIndex(int [] output, int w, int [] a, int i){
			for (; i < a.length; i++,w++) {
				output[w]=a[i];
			}
			return output;
	}
	}

