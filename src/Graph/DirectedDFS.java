package Graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DirectedDFS {
    private boolean[] marked;
    
    DirectedDFS(Digraph G, int s){
        marked = new boolean[G.E()];
        dfs(G, s);
    }
    
    private void dfs(Digraph G, int s) {
        if( marked[s] ) return;
        marked[s] = true;
        
        for(int w : G.adj(s) ) {
            dfs(G, w);
        }
    }
    
    public boolean marked(int V) {
        return marked[V];
    }
    
    public static void main(String[] args) {
        Digraph dg ;
        try( BufferedReader br = new BufferedReader(new FileReader(new File("src/Graph/tinyDG.txt")))){
            int V = new Integer(br.readLine());
            int E = new Integer(br.readLine());
            dg = new Digraph(V);
            for(int i=0; i<E; i++) {
                String[] s = br.readLine().split(" ");
                dg.addEdge(new Integer(s[0]), new Integer(s[1]));
            }
            DirectedDFS dfs = new DirectedDFS(dg,2);
            
            for( int v=0; v<dg.V(); v++) {
                if( dfs.marked(v) ) System.out.print(v + " ");
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
