package Divide_Conquer;

import java.util.Arrays;
public class Strassen_Matrix_Multiplication {
	
	public static void main(String[] args) {
		int [] [] a = {
						{1,2,3,4},
						{5,6,7,8},
						{9,10,11,12},
						{13,14,15,16}
		};
		
		
		int [] [] b = {
						{17,18,19,20},
						{21,22,23,24},
						{25,26,27,28},
						{29,30,31,32}
		};
		
//		int [] [] c= {{1,2},{3,4}};
//		int [] [] d = {{5,6},{7,8}};
		

		int [] [] output = strassen(a,b);
		
		for (int i = 0; i < output.length; i++) {
			System.out.println(Arrays.toString(output[i]));
		}
		
	}
	
	static int [] []  strassen(int [] []  x, int [] []  y){
		
		if(x.length==1){
			int [] [] output = new int [1][1];
			output[0][0]=x[0][0]*y[0][0];
			return output;
		}
			
		
		int [] []  xUpper= Arrays.copyOfRange(x,0,x.length/2);

		int [] [] xLower= Arrays.copyOfRange(x,x.length/2,x.length);
		
		
		
		int [] []  yUpper= Arrays.copyOfRange(y, 0, y.length/2);
		int [] [] yLower= Arrays.copyOfRange(y,y.length/2,y.length);
		
		int [][] a =  subArray(xUpper,0,xUpper[0].length/2); 
		int [] [] b = subArray(xUpper, xUpper[0].length/2, xUpper[0].length);
		
		int [][] c =  subArray(xLower,0,xLower[0].length/2); 
		int [] []d = subArray(xLower, xLower[0].length/2, xLower[0].length);
		
		int [][] e =  subArray(yUpper,0,yUpper[0].length/2);
		int [] []f = subArray(yUpper, yUpper[0].length/2, yUpper[0].length);
		
		int [][] g =  subArray(yLower,0,yLower[0].length/2);
		int [] []h = subArray(yLower, yLower[0].length/2, yLower[0].length);
		

		
		
		int [] [] p1= strassen(a,subtract(f, h));
		int [] [] p2 = strassen(add(a,b), h);
		int [] [] p3 = strassen(add(c,d), e);
		int [] [] p4 = strassen(d, subtract(g,e));
		int [] [] p5 = strassen(add(a,d), add(e,h));
		int [] [] p6 = strassen(subtract(b,d), add(g,h));
		int [] [] p7 = strassen(subtract(a,c), add(e,f));
		

		
		int [] [] outputUpper= concat(add(subtract(add(p5,p4),p2),p6), add(p1,p2));
		int [] [] outputLower = concat(add(p3,p4),subtract(subtract(add(p1,p5),p3), p7));
		
	
		
		int output2 [] [] = new int[x.length][x[0].length];
		System.arraycopy(outputUpper, 0, output2, 0, outputUpper.length);
		System.arraycopy(outputLower, 0, output2, output2.length/2, outputLower.length);
			
		return output2;

	}
	
	static int [] [] subArray(int [] [] x , int a , int b){
		int [] [] output = new int [x.length][x.length/2];
		
		for (int i = 0; i < x.length; i++) 
			output[i]=Arrays.copyOfRange(x[i],a, b);
		
		return output;
	}
	
	static int [] [] concat(int [] [] x ,int [] [] y){
		int [] [] output= new int [x.length][x.length+y.length];
		for (int i = 0; i < output.length; i++) {
			System.arraycopy(x[i], 0, output[i], 0, x[i].length);	
			System.arraycopy(y[i], 0, output[i], output[i].length/2, x[i].length);	
					
	}
	
		return output;
	}
	

	
	static int [] [] add(int [] [] x, int [] [] y){
		int [] [] output =new int [x.length][x[0].length];
		for (int i = 0; i < y.length; i++) {
			for (int j = 0; j < y.length; j++) {
				output[i][j]=x[i][j]+y[i][j];
			}
		}
		
		return output;
	}
	

	static int [] [] subtract(int [] [] x, int [] [] y){
		int [] [] output =new int [x.length][x[0].length];
		for (int i = 0; i < y.length; i++) {
			for (int j = 0; j < y.length; j++) {
				output[i][j]=x[i][j]-y[i][j];
			}
		}
		
		return output;
	}
	
	
	}

