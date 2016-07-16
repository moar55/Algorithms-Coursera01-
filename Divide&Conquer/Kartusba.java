import java.util.Arrays;

public class Kartusba {
	public static void main(String[] args) {
		int output = karatsuba(22858585,158568568);
		System.out.println(output);
		
	}
	
	static int karatsuba(int x ,int y ){
		
		
		if(x/10==0 || y/10==0){
			return x*y;
		}
		
		String x1 = Integer.toString(x);
		String y1 = Integer.toString(y);
		
		int size =x1.length();
		int size1= y1.length();
		
		String a1 = x1.substring(0, size/2);
		String b1 = x1.substring(size/2,size);
		String c1 = y1.substring(0, size1/2);
		String d1 = y1.substring(size1/2,size1);
		
		
		int c =Integer.parseInt(c1) , a=Integer.parseInt(a1),d=Integer.parseInt(d1),b = Integer.parseInt(b1);
				
		int ac = karatsuba(a, c);
		int bd =karatsuba(b, d);
		
		int ad_bc = karatsuba(a+b, c+d)-bd-ac;
		
		return (int)Math.pow(10, size)*ac + (int)Math.pow(10, size/2)*ad_bc+bd;
	
				
	}
	

}
