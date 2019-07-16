package Graph;
import java.util.*;

public class BreathFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;
    
    public BreathFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G,s);
    }
    
    private void bfs(Graph G, int s) {
        LinkedList<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.offer(s);
        
        while( !queue.isEmpty() ) {
            int v = queue.poll();
            for( int w : G.adj(v) ) {
                if( !marked[w] ) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.offer(w);
                }
            }
        }
    }
    
    public boolean hasPathTo(int v) {
        return marked[v];
    }
    
    public Iterable<Integer> pathTo(int v){
        LinkedList<Integer> stack = new LinkedList<>();
        for(int w = v; w != s; w=edgeTo[w]) {
            stack.push(w);
        }
        stack.push(s);
        return stack;
    }
    
    public static void main(String[] args) {
        BasicGraph bg = new BasicGraph(6);
        bg.addEdge(0,5);
        bg.addEdge(2,4);
        bg.addEdge(2,3);
        bg.addEdge(1,2);
        bg.addEdge(0,1);
        bg.addEdge(3,4);
        bg.addEdge(3,5);
        bg.addEdge(0,2);
        
        int s = 0;
        BreathFirstPaths bfp = new BreathFirstPaths(bg,s); 
        
        for(int w = 0 ; w < bg.V(); w++) {
            System.out.print("0 to "+w+": ");
            if( bfp.hasPathTo(w) ) {
                for(int v : bfp.pathTo(w) ) {
                    if( v == s ) System.out.print( v );
                    else System.out.print( "-"+v );
                }
            }
            System.out.println();
        }
    }
}
