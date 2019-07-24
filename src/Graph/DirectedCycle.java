package Graph;

import java.util.*;

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private LinkedList<Integer> cycle;
    private boolean[] onStack;
    
    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for( int v=0; v < G.V(); v++) {
            if( !marked[v] ) dfs(G,v);
        }
    }
    
    public void dfs(Digraph G, int v) {
        marked[v] = true;
        onStack[v] = true;
        for( int w : G.adj(v) ) {
            if( this.hasCycle() ) return;
            else if( !marked[w] ) {
                edgeTo[w] = v;
                dfs(G, w);
            }else if( onStack[w] ) {
                cycle = new LinkedList<>();
                for( int x=v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }
    
    public boolean hasCycle() {
        return cycle != null;
    }
    
    public Iterable<Integer> cycle(){
        return cycle;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
