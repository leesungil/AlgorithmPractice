package string;

public class IsPermutation {
    public static boolean isP(String s1, String s2) {
        //int c = new int[26];
        //int[] c = new int[26]; //int => int[]
        int[] c = new int[128]; // 26 => 128 because 128 standard ascii will be used
        //if( s1.length != s2.length ) return false;
        if( s1.length() != s2.length() ) return false; //length => length()
        //for( int i=0; i< s1.length ; i++)
        for( int i=0; i< s1.length() ; i++) { //need a block, length => length() 
            //c['a'-s1.charAt(i)]++;
            //c[s1.charAt(i)-'a']++; //'a' is smaller so nagative result came out
            c[s1.charAt(i)]++; // assume character is in the range of the standard ascii
            //c['a'-s2.charAt(i)]--; 
            //c[s2.charAt(i)-'a']--; //'a' is smaller so nagative result came out
            c[s2.charAt(i)]--; // assume character is in the range of the standard ascii
        }
        //for( int i=0; i<26; i++)
        for( int i=0; i<c.length; i++) //26 => c.length
            if( c[i] != 0 )
                return false;
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //System.out.println(isP("abcde","edcab"));
        int saveBit = 0;
        saveBit|=(1<<4);
        saveBit|=(1<<3);
        saveBit|=(1<<8);
        System.out.println(Integer.toBinaryString(saveBit));
        
        int masked = saveBit&1<<0;
        System.out.println(masked > 0);
        masked = saveBit&1<<1;
        System.out.println(masked > 0);
        masked = saveBit&1<<2;
        System.out.println(masked > 0);
        masked = saveBit&1<<3;
        System.out.println(masked > 0);
        masked = saveBit&1<<4;
        System.out.println(masked > 0);
        masked = saveBit&1<<5;
        System.out.println(masked > 0);
        masked = saveBit&1<<6;
        System.out.println(masked > 0);
        masked = saveBit&1<<7;
        System.out.println(masked > 0);
        masked = saveBit&1<<8;
        System.out.println(masked > 0);
    }

}
