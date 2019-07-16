package Graph;
import java.util.*;

import lib.StdOut;

public class DepthFirstPath {
    private boolean[] marked;
    private int count;
    private int edgeTo[];
    private final int s;
    
    public DepthFirstPath(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s; 
        dfs(G,s);
    }
    
    private void dfs(Graph G, int v) {
        marked[v] = true;
        
        count++;
        for( int w : G.adj(v) ) {
            if( !marked[w] ) {
                edgeTo[w] = v;
                dfs(G, w); 
            }
        }
    }
    
    public boolean hasPathTo(int w) {
        return marked[w];
    }
    
    public int count() {
        return count;
    }
    
    public Iterable<Integer> pathTo(int v){
        if( !hasPathTo(v) ) return null;
        LinkedList<Integer> path = new LinkedList<>();
        for( int x=v; x != s; x= edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        
        return path;
    }
    
    public static void main(String[] args) {
        BasicGraph bg = new BasicGraph(13);
        bg.addEdge(0,5);
        bg.addEdge(4,3);
        bg.addEdge(0,1);
        bg.addEdge(9,12);
        bg.addEdge(6,4);
        bg.addEdge(5,4);
        bg.addEdge(0,2);
        bg.addEdge(11,12);
        bg.addEdge(9,10);
        bg.addEdge(0,6);
        bg.addEdge(7,8);
        bg.addEdge(9,11);
        bg.addEdge(5,3);
        
        int s = 0;
        
        DepthFirstPath search = new DepthFirstPath(bg, s);
        for( int v =0; v < bg.V(); v++) {
            StdOut.print(s + " to " + v + ": ");
            if( search.hasPathTo(v) ) {
                for( int x: search.pathTo(v) )
                    if( x == s ) StdOut.print(x);
                    else StdOut.print("-" + x);
            }
            StdOut.println();
        }
    }
}
