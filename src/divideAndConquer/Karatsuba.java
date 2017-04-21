package divideAndConquer;

import java.math.BigInteger;

public class Karatsuba {

	public static BigInteger karatsuba(BigInteger x, BigInteger y) {
		int N = x.bitLength();
		N = (N/2)+(N%2);
		if(N<=1) {
			return x.multiply(y);
		}
		else {
			BigInteger a = x.shiftRight(N);
			BigInteger b = x.subtract(a.shiftLeft(N));
			BigInteger c = y.shiftRight(N);
			BigInteger d = y.subtract(c.shiftLeft(N));
			BigInteger ac = karatsuba(a,c);
			BigInteger bd = karatsuba(b,d);
			BigInteger abcd = karatsuba(a.add(b), c.add(d));
			return ac.shiftLeft(2*N).add((abcd.subtract(ac).subtract(bd)).shiftLeft(N)).add(bd);
		}
	}
	
	public static void main(String[] args) {
		BigInteger x = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
		BigInteger y = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
		System.out.println(karatsuba(x,y));
		BigInteger x2 = new BigInteger("83456");
		BigInteger y2 = new BigInteger("93421");
		System.out.println();
		System.out.println(karatsuba(x2,y2));
	}
	
}
