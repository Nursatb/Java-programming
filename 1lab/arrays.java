public class arrays {
	public static void main(String args[]) {
		int i,j,t;
		int[] z = new int[13];
		double [] x = new double [19];
		double [][]h = new double [13][19];
		
		for (i=0;i<13;++i) {
			t=i+5;
			z [i] = t;
			System.out.print(z[i]+"\n");
		}
		for (j=0;j<19;++j) {
			
			 x [j] =( Math.random()*14 - 3.0 );
			
			System.out.printf("%.4f ",x[j]);
		}
		for(i=0;i<13;++i) {
			for (j=0;j<19;++j) {
				
				if(z [i]==11)
					h[i][j]=Math.tan(Math.pow(( 2 *  Math.pow( ( x [ j ] * ( 2 - x [ j ] ) ), 3) ), 3) ); 
				else if(z [i]==5 | z [i]==7 | z [i]==8 | z [i]==10 | z [i]==13 | z [i]==17)
					h[i][j]=Math.tan( ( Math.log (Math.pow( (Math.abs( x [ j ] ) ), 0.5) ) ) ) ; 
				else 
					h[i][j]=Math.tan(Math.pow(Math.asin(Math.cos(x[j])),( Math.pow(x[j], 2)/32)));
				
				System.out.printf("%8.4f ",h[i][j]);
								}
				System.out.println();
						}
	}
}
//javac arrays