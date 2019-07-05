package Graph;

public interface Graph {
    public int V();
    public int E();
    public void addEdge(int v, int w);
    public Iterable<Integer> adj(int v);
    
    public static int degree(BasicGraph g, int v) {
        int degree = 0;
        for( int w: g.adj(v) ) degree++;
        return degree;
    }
    
    public static int maxDegree(BasicGraph g) {
        int max = 0;
        for( int v=0; v < g.V() ; v++ ) {
            if( degree(g, v) > max ) {
                max = degree(g, v);
            }
        }
        return max;
    }
    
    public static double avarageDegree(BasicGraph g) {
        return 2.0*g.E()/g.V();
    }
    
    public static int numberOfSelfLoops(BasicGraph g) {
        int count = 0;
        for( int v=0; v < g.V(); v++) {
            for(int w : g.adj(v) ) {
                if( v == w ) count++;
            }
        }
        
        return count/2;
    }
}
