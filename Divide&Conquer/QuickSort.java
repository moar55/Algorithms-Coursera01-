package Divide_Conquer;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		int [] a = {3,5,1,2,4,12312,4,5,19,123,4,1,987,7};
		myQuickSort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
	
	static void  myQuickSort(int [] a,int x,int y){
		
		if(x>=y || x>=a.length ){
			return;
		}
		
		
		if(x+1==y){
			
			if(a[x]>a[y])
				swap(a,x,y);
						
		return;
	}
	
		int last_less = partitioning(a, x, y);
		
		
		myQuickSort(a,x,last_less-1);
		myQuickSort(a, last_less+1, y);
		
		}
	
	
	static int partitioning(int [] a, int x, int y){
		int p = choosePivot(x, y);

		boolean bigger = false;
		
		swap(a,x,p);
		
		int i = x+1,j=x+1;
		
		for (; j <=y; j++) {
			
			 	 
			if(a[j]<=a[x]) {
				if(bigger)
				swap(a,j,i);
				
				i++;
			}
			
			else 
				bigger=true;
						
		}
		
		
		int last_less=(!bigger || a[i]>a[x])?i-1:i;

		
		swap(a, x, last_less);
		
		return last_less;
		
	}
	
	static int choosePivot(int x,int y){
		Random rand = new Random();
		return rand.nextInt(y-x+1)+x;

	}
		
	
	
	
	static void swap(int [] a ,int i ,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}

}
