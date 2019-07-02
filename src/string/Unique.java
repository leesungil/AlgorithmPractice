package string;

public class Unique {
    public static boolean isUnique(String str) {
        if( str.length() < 2) return true;
        for( int i=0; i < str.length()-1; i++)
            for( int j=i+1; j < str.length(); j++)
                if( str.charAt(i) == str.charAt(j) )
                    return false;
        return true;
    }
    
    public static boolean checkDup(String s) {
        if( s.length() >26 ) return false;
        //s = s.lowerCase();
        s = s.toLowerCase(); //wrong function name
        int checker=0; int m,t;
        for( char c : s.toCharArray() ) {
            m = c-'a';
            if( m> 26) return false;
            t = 1<<m;
            //if( checker&t > 0) return false;
            if( (checker&t) > 0) return false; //checker&t => (checker&t)  
            checker |= t;
        }
        return true;
    }
    
    public static void main(String[] args) {
        //System.out.println(isUnique("abbcdc"));
        System.out.println(checkDup("acc"));
    }

}
