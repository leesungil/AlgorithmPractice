package Graph;

import java.util.*;
import java.io.*;

public class Digraph {
    private LinkedList<Integer>[] adj;
    private final int V;
    private int E;
    
    
    Digraph(int V){
        this.V = V;
        adj = new LinkedList[V];
        for( int i=0; i<V; i++) {
            adj[i] = new LinkedList<>();
        }
        E = 0;
    }
    
    //Digraph(String filename){
        
    //}
    
    public int V() {
        return V;
    }
    
    public int E() {
        return E;
    }
    
    public void addEdge(int v, int w) {
        adj[v].push(w);
        E++;
    }
    
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    
    public Digraph reverse() {
        Digraph d = new Digraph(V);
        for( int i=0; i< V; i++) {
            for(int j: adj[i]) {
                d.addEdge(j, i);
            }
        }
        return d;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Digraph dg ;
        try( BufferedReader br = new BufferedReader(new FileReader(new File("src/Graph/tinyDG.txt")))){
            int V = new Integer(br.readLine());
            int E = new Integer(br.readLine());
            dg = new Digraph(V);
            for(int i=0; i<E; i++) {
                String[] s = br.readLine().split(" ");
                dg.addEdge(new Integer(s[0]), new Integer(s[1]));
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

}
