package UF;

import java.util.Arrays;

public class QuickUnion {
    private int[] ids;
    private int count;
    
    public QuickUnion(int n){
        ids = new int[n];
        for( int i=0; i<n; i++) {
            ids[i] = i;
        }
        count = n;
    }
    
    public void union(int p, int q) {
        int idP = find(p);
        int idQ = find(q);
        
        if( idP == idQ ) {
            System.out.println("("+p+","+q+") is ignored.");
            return;
        }
        
        ids[idP] = idQ; //the root of p has to be filled with the root of q 
        count--;
    }
    
    private int find(int p) {
        int curP = p;
        while( curP != ids[curP] ) curP = ids[curP];
        return curP;
    }
/*
0 1 2 3 4 5 6 7 8 9
1 1 1 8 3 0 5 1 8 8
44 33
33,88
66,55
99,48
22,11
-88,98
55,00
77,21
06,11
1,0
6,7
*/
    public boolean connected(int p, int q) {
        if( find(p) == find(q) ) {
            return true;
        }
        
        return false;
    }
    
    public int count() {
        return count;
    }
    
    @Override
    public String toString() {
        return Arrays.toString(ids);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        QuickUnion qu = new QuickUnion(10);
        qu.union(4,3);
        qu.union(3,8);
        qu.union(6,5);
        qu.union(9,4);
        qu.union(2,1);
        qu.union(8,9);
        qu.union(5,0);
        qu.union(7,2);
        qu.union(6,1);
        qu.union(1,0);
        qu.union(6,7);
        
        System.out.println("The number of components in the set is "+qu.count());
        System.out.println(qu);
    }
}
