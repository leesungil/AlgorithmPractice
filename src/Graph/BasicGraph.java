package Graph;

import java.io.InputStream;
import java.util.*;

public class BasicGraph implements Graph{
    private final int V;
    private int E;
    private LinkedList<Integer>[] adj;
    
    public BasicGraph(int V){
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Integer>[])new LinkedList[V];
        for( int v=0; v < V; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }
    
    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for( int v=0; v < V ; v++ ) {
            s += v + ": ";
            for( int w : this.adj(v) )
                s += w + " ";
            s += "\n";
        }
        return s;
    }
    
    @Override
    public int V() {
        // TODO Auto-generated method stub
        return V;
    }

    @Override
    public int E() {
        // TODO Auto-generated method stub
        return E;
    }

    @Override
    public void addEdge(int v, int w) {
        // TODO Auto-generated method stub
        adj[v].push(w);
        adj[w].push(v);
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        // TODO Auto-generated method stub
        return adj[v];
    }
    
    public static void main(String[] str) {
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
        
        System.out.println(bg);
        
        for( int i=0; i < bg.V() ; i++ ) {
            System.out.println("degree of the vertex "+i+" : "+Graph.degree(bg, i));
        }
        
        System.out.println("Max degree : "+Graph.maxDegree(bg));
        System.out.println("Average degree : "+Graph.avarageDegree(bg));
        System.out.println("Number of self-loop : "+Graph.numberOfSelfLoops(bg));
    }
}
