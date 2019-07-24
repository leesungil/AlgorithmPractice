package Graph;
//Connected Component
import java.util.*;

public class CC {
    private boolean[] marked;
    private int[] id;
    private int idnum;
    
    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        idnum = 0;
        
        dfs(G, 0, idnum);
        
        for( int i=0; i < G.V(); i++) {
            if( !marked[i] ) {
                dfs(G, i, ++idnum);
            }
        }
    }
    
    private void dfs(Graph G, int v, int idnum) {
        marked[v] = true;
        id[v] = idnum;
        
        for( int w: G.adj(v)) {
            if( !marked[w] ) {
                dfs(G, w, idnum);
            }
        }
    }
    
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }
    
    public int count() {
        return idnum+1;
    }
    
    public int id(int v) {
        return id[v];
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
        
        CC cc = new CC(bg);
        
        int M = cc.count();
        
        System.out.println(M + " components");
        
        LinkedList<Integer>[] components;
        components = new LinkedList[M];
        
        for( int i = 0; i < M ; i++) {
            components[i] = new LinkedList<Integer>();
        }
        
        for( int v = 0; v < bg.V(); v++) {
            components[cc.id(v)].offer(v);
        }
        for( int i=0; i<M; i++) {
            for( int v: components[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
