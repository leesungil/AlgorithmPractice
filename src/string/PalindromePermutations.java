package string;

public class PalindromePermutations {
	public static boolean pp(String s) {
		//add
		s = s.toLowerCase();
		int[] c = new int[128];
		char[] sa = s.toCharArray();
		for( char cc : sa ) {
			//if( cc != ' ' )c[cc]++;
			//modify to use white space check funtion 
			if( !Character.isWhitespace(cc) ) c[cc]++;
		}
			
		int noo = 0;
		for( int i: c)
			if( i%2 != 0 )noo++;
		if( noo > 1 ) return false;
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(pp("Tact Coa"));
	}
}
