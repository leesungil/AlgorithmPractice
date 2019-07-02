package hash_table;
import java.util.*;

public class HashTable<K,V> {
    private class Node<K,V>{
        K key; 
        V val;
        Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }
    
    //private List<Node<K,V>>[] arr = new List<Node<K,V>>[10];
    private List<List<Node<K,V>>> arr = new ArrayList<>(); //Array is only for generic type
    
    HashTable(){ // need to initialize arraylist or it will get error
        for( int i=0; i< 10 ; i++) {
            arr.add(null);
        }
    }
    
    public void put(K k, V v) {
        Node<K,V> n = new Node<>(k,v);
        int hc = k.hashCode()%10;
        if( arr.get(hc) == null ) { //arr[hc] = new LinkedList<Node>();
            arr.remove(hc);//because just adding new value will push other values back.
            arr.add(hc,new LinkedList<Node<K,V>>()); // array cannot be used here
        }
        //arr[hc].add(n);
        arr.get(hc).add(n); // array cannot be used here
    }
    
    public V get(K k) {
        int hc = k.hashCode()%10;
        //if( arr[hc] == null ) return null;
        if( arr.get(hc) == null ) return null;
        //for( Node c: arr[hc]) {
        for( Node<K,V> c: arr.get(hc) ) {
            if( c.key == k ) return c.val;
        }
        
        return null;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HashTable<Integer, String> ht = new HashTable<>();
        ht.put(3, "abc");
        ht.put(2, "ab");
        ht.put(4, "abcd");
        ht.put(7, "abcdefg");
        ht.put(17, "hijklmn");
        ht.put(27, "opqrstu");
        ht.put(5, "abcde");
        
        System.out.println(ht.get(7));
        System.out.println(ht.get(17));
        System.out.println(ht.get(27));
    }

}
