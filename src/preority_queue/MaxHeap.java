package preority_queue;
import java.util.*;

public class MaxHeap {
    private ArrayList<Integer> arr = new ArrayList<>();
    private int last = -1;
    
    public void insert(int n) throws Exception{
        this.last++;
        this.arr.add(n);
        int c=this.last;
        int p=((this.last-1)/2);
        while( c> p && p>=0 ) {
            if( this.arr.get(c) > this.arr.get(p) ) {
                this.swap(c, p);
                c=p;
                p = ((c-1)/2);
            }else break;
        }
    }
    
    private void swap( int i, int j) throws Exception{
        if( this.arr.size() -1 < i || this.arr.size()-1 < j) {
            throw new Exception();
        }
        int t = this.arr.get(i);
        int t2 = this.arr.get(j);// store second item too. because a whole index will be moved. 
        //this.arr.add(i, this.arr.get(j));
        this.arr.remove(i); //add() is not replacing but appending a new value on that position.
        //this.arr.add(i, this.arr.get(j)); //remove and add is a right process.
        this.arr.add(i, t2); //can't get from a last index because this.arr.remove(i); decrease one length.   
        //this.arr.add(j, t);
        this.arr.remove(j);
        this.arr.add(j, t);//remove and add is a right process.
    }
    
    @Override
    public String toString() {
        //return arr.toString();
        StringBuilder sb = new StringBuilder(); // real data is until last index.
        for( int i=0 ; i <= this.last ; i++) {
            sb.append(arr.get(i)+",");
        }
        return sb.toString();
    }
    
    /*
     * 
     * [30, 10, 13, 8, 9, 4, 10]
     * ret : 30
     * last : 6
     * swap (0, 6)
     * i 0 j 6
     * t 30
     */
    
    public int pop() throws Exception {
        if( this.isEmpty() ) throw new Exception();
        int ret = this.arr.get(0);
        if( this.last > 0 ) {
            this.swap(0, this.last);
        }
        this.last--;
        if( this.last < 0) return ret;
        int c= 0;
        int l = (c*2) + 1;
        int r = (c+1) * 2;
        while( l <= this.last || r <= this.last) {
            int comp = 0;
            if( l <= this.last && r <= this.last ) {
                if( this.arr.get(l) > this.arr.get(r) ) {
                    comp = l;
                }else {
                    comp = r;
                }
            }else if( l <= this.last ) comp = l;
            else if( r <= this.last ) comp = r;
            
            if( comp > 0 ) {
                if( this.arr.get(c) < this.arr.get(comp) ) {
                    this.swap(c,  comp);
                    c = comp;
                    l = (c*2) + 1;
                    r = (c+1) * 2;
                }else break;
            }else break;
        }
        return ret;
    }
    
    private boolean isEmpty() {
        if( this.last < 0 ) return true;
        return false;
    }
    
    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap();
        try {
            mh.insert(10);
            mh.insert(9);
            mh.insert(4);
            mh.insert(8);
            mh.insert(30);
            mh.insert(10);
            mh.insert(13);
            System.out.println(mh);
            System.out.println( mh.pop() );
            System.out.println( mh.pop() );
            System.out.println( mh.pop() );
            System.out.println( mh.pop() );
            System.out.println( mh.pop() );
            System.out.println( mh.pop() );
            System.out.println( mh.pop() );
            System.out.println(mh);
            
            //System.out.println( mh.pop() );
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        //System.out.println(mh);
    }
}
