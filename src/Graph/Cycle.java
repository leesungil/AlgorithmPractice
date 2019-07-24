package Graph;

import java.util.LinkedList;

import lib.StdOut;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;
    
    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for( int s =0 ; s < G.V(); s++ ) {
            if( !marked[s] ) {
                dfs(G, s, s);
            }
        }
    }
    
    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        
        for( int w : G.adj(v) ) {
            System.out.println(""+v+" => "+w+"(w="+u+")");
            if( !marked[w] ) {
                dfs(G, w, v); 
            }else if( w != u) {
                System.out.println("("+w+"!="+u+") hasCycle");
                hasCycle = true;
            }else if( w == u ) {
                System.out.println("("+w+"!="+u+") not a cycle");
            }
        }
    }
    
    public boolean hasCycle() {
        return hasCycle;
    }
    
    public static void main(String[] args) {
        /*
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
        */
        BasicGraph bg = new BasicGraph(5);
        bg.addEdge(0, 1);
        bg.addEdge(1, 2);
        bg.addEdge(2, 3);
        bg.addEdge(3, 4);
        bg.addEdge(4, 0);
        
        
        Cycle cycle = new Cycle(bg);
        System.out.println("hasCycle : "+cycle.hasCycle());
    }
}
