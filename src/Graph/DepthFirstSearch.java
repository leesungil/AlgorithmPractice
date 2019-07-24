package Graph;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    
    public DepthFirstSearch(Graph G, int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }
    
    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for( int w : G.adj(v) ) {
            if( !marked[w] ) dfs(G, w);
        }
    }
    
    public boolean marked(int w) {
        return marked[w];
    }
    
    public int count() {
        return count;
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
        
        DepthFirstSearch dfs = new DepthFirstSearch(bg, 0);
        System.out.println("dfs.count : "+dfs.count());
    }
}
