package Graph;

public class DegreesOfSeparation {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SymbolGraph sg = new SymbolGraph("src/Graph/routes.txt", " ");
        Graph G = sg.G();
        String source = "JFK";
        if( !sg.contains(source) ) {
            System.out.println(source+" is not in Database.");
        }
        
        int s = sg.index(source);
        BreathFirstPaths bfs = new BreathFirstPaths(G,s);
        
        //String sink = "LAS";
        String sink = "DFW";
        if( sg.contains(sink) ) {
            int t = sg.index(sink);
            if( bfs.hasPathTo(t) ) {
                for( int v : bfs.pathTo(t))
                    System.out.println("    "+sg.name(v));
            }else {
                System.out.println("not connected");
            }
        }else {
            System.out.println("not in database");
        }
    }
}
