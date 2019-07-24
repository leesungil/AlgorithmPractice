package dp;

public class Maze {
    public static boolean traverse(int x, int y, final int gX, final int gY, int[][] maze,boolean[][] checked) {
        if( x == gX && y == gY) { 
            System.out.print("("+x+","+y+")"); 
            return true; 
        }
        
        if( x >= maze[0].length 
                || x < 0 
                || y >= maze.length 
                || y < 0 
                || checked[y][x] 
                || maze[y][x] == 0) return false;

        checked[y][x] = true;
        
        if( traverse(x+1, y, gX, gY,maze,checked ) ) {
            System.out.print("("+x+","+y+")"); 
            return true;
        }
        if( traverse(x-1, y, gX, gY,maze,checked ) ) {
            System.out.print("("+x+","+y+")"); 
            return true;
        }
        if( traverse(x, y+1, gX, gY,maze,checked ) ) {
            System.out.print("("+x+","+y+")"); 
            return true;
        }
        if( traverse(x, y-1, gX, gY,maze,checked ) ) {
            System.out.print("("+x+","+y+")"); 
            return true;
        }
        
        return false;
    }
    public static void main(String[] args) {
        int[][] maze = {
                {0,0,1,0},
                {0,1,1,1},
                {0,1,0,0},
                {1,1,1,1}
        };
        boolean[][] checked = new boolean[4][4]; 
        boolean r = traverse(2,0,3,3,maze,checked);
        System.out.println(r);
    }
}
