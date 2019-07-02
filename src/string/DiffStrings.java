package string;

public class DiffStrings {
    public static boolean comp(String s1, String s2) {
        int diff = s1.length() - s2.length();
        if( diff == 0 ) return compS(s1, s2);
        else if(diff == 1 ) return compD(s1, s2);
        else if( diff == -1 ) return compD(s1, s2);
        return false;
    }
    
    private static boolean compS(String s1, String s2) {
        boolean diff = false;
        for( int i =0; i<s1.length(); i++) {
            if( s1.charAt(i) != s2.charAt(i) ) {
                if( diff ) return false;
                else diff = true;
            }
        }
        return true;
    }
    
    private static boolean compD(String s1, String s2) {
        int i=0;
        boolean diff = false;
        for( int j=0; j< s2.length(); j++) {
            if( s1.charAt(i) != s2.charAt(j)) {
                if( diff ) return false;
                else {
                    diff = true;
                    j--;
                }
            }
            i++;
        }
        return true; // missed
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(comp("pale","ple"));
        System.out.println(comp("pales","pale"));
        System.out.println(comp("pale","bale"));
        System.out.println(comp("pale","bake"));
    }

}
