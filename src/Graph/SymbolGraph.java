package Graph;

import java.util.*;
import java.io.*;

public class SymbolGraph {
    private Map<String, Integer> st;
    private String[] keys;
    private BasicGraph G;
    
    public SymbolGraph(String stream, String sp) {
        st = new HashMap<>();
        File file = new File(stream);
        try( BufferedReader br = new BufferedReader(new FileReader(file)) ){
            //br.lines().map(s->s.split(sp).stream())
            br.lines()
                .flatMap(s->Arrays.asList(s.split(sp)).stream())
                .filter(k->!st.containsKey(k))
                .forEach(k->st.put((String)k, st.size()));
            //String s=br.readLine();
            //while(br) {
                //Arrays.asList(s.split(sp)).stream().filter(k->!st.containsKey(k)).forEach(k->st.put((String)k, st.size()));
                //s=br.readLine();
            //}
        }catch(IOException e) {
            e.printStackTrace();
        }
        keys = new String[st.size()];
        st.forEach((k,v)->{
            keys[v] = k;
        });
        G = new BasicGraph(st.size());
        try( BufferedReader br = new BufferedReader(new FileReader(file)) ){
            br.lines()
            .forEach(s->{
                String[] a = s.split(sp);
                int idx = st.get(a[0]);
                for( int i =1 ; i<a.length ; i++) {
                    G.addEdge(idx, st.get(a[i]));
                }
            });
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean contains(String s) {
        return st.containsKey(s);
    }
    
    public int index(String s) {
        return st.get(s);
    }
    
    public String name(int V) {
        return keys[V];
    }
    
    public BasicGraph G() {
        return G;
    }
    
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph("src/Graph/movies.txt","/");
        TwoColor tc = new TwoColor(sg.G());
        
        SymbolGraph routes = new SymbolGraph("src/Graph/routes.txt"," ");
    }
}
