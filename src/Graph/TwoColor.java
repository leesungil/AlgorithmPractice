package Graph;

public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;
    
    public TwoColor(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for( int s =0 ; s < G.V(); s++ ) {
            if( !marked[s] ) {
                dfs(G, s);
            }
        }
    }
    
    private void dfs(Graph G, int v) {
        marked[v] = true;
        
        for( int w : G.adj(v) ) {
            if( !marked[w] ) {
                color[w] = !color[v];
                dfs(G, w); 
            }else if(color[w] == color[v]) isTwoColorable = false;
        }
    }
    
    public boolean isBipartite() {
        return isTwoColorable;
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
        
        TwoColor tc = new TwoColor(bg);
        System.out.println("colorable : "+tc.isBipartite());
    }
}
