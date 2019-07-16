package UF;

public class QuickFind {
    private int[] ids;
    private int count;
    
    public QuickFind(int n){
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
        
        for( int i=0; i<ids.length ; i++ ) {
            if( ids[i] == idP) {
                ids[i] = idQ;
            }
        }
        count--;
    }
    
    private int find(int p) {
        return ids[p];
    }
    
    public boolean connected(int p, int q) {
        if( find(p) == find(q) ) {
            return true;
        }
        
        return false;
    }
    
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        QuickFind qf = new QuickFind(10);
        qf.union(4,3);
        qf.union(3,8);
        qf.union(6,5);
        qf.union(9,4);
        qf.union(2,1);
        qf.union(8,9);
        qf.union(5,0);
        qf.union(7,2);
        qf.union(6,1);
        qf.union(1,0);
        qf.union(6,7);
        
        System.out.println("The number of components in the set is "+qf.count());
    }

}
