package string;

public class URLify {
    public static String urlify(String str) {
        char[] s = str.toCharArray();
        int last = s.length -1;
        for( int i=s.length -1; i >= 0 ; i-- )
            //if( s[i] != ' ') break;
            if( !Character.isWhitespace(s[i]) ) break;
            else last--;
        int numWhite = 0;
        for( int i=0; i <=last ; i++)
            //if( s[i] == ' ' )numWhite++;
            if( Character.isWhitespace(s[i]) )numWhite++;
        int i=last;
        int j=i + numWhite*2;
        if( s.length-1 < j ) return str;
        while( i>=0 && i<= j) {
            //if( s[i] != ' ' ) s[j] = s[i];
            if( !Character.isWhitespace(s[i]) ) s[j] = s[i];
            else {
                s[j] = '0'; j--;
                s[j] = '2'; j--;
                s[j] = '%';
            }
            i--; j--;
        }
        return new String(s);
    }
    
    public static void main(String[] args) {
        System.out.println(urlify("Mr John Smith    "));
    }
}
