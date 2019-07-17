package UF;

import java.util.Arrays;

public class QuickUnionFixed {
    private int[] ids;
    private int[] sz;
    private int count;
    
    public QuickUnionFixed(int n){
        ids = new int[n];
        sz = new int[n];
        for( int i=0; i<n; i++) {
            ids[i] = i;
            sz[i] = 1;
        }
        count = n;
    }
    
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        
        if( i == j ) {
            System.out.println("("+p+","+q+") is ignored.");
            return;
        }
        
        if(sz[i] < sz[j]) {
            ids[i] = j;
            sz[j] += sz[i];
        }else {
            ids[j] = i;
            sz[i] += sz[j];
        }
         
        count--;
    }
    
    private int find(int p) {
        int curP = p;
        while( curP != ids[curP] ) curP = ids[curP];
        return curP;
    }
/*
ids
0 1 2 3 4 5 6 7 8 9
6 6 1 4 4 6 6 1 4 4

sz
0 1 2 3 4 5 6 7 8 9
1 6 1 1 4 1 3 1 1 1

1,44 33,1
2,43,88,1
1,66,55,1
1,99,44,3
1,22,11,1
48,94 -> pass
2,65,00,1
1,77,21,2
3,66,11,3
61,06 -> pass
66,76 -> pass
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
        QuickUnionFixed qu = new QuickUnionFixed(10);
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
