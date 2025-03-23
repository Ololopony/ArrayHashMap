public class App {
    public static void main(String[] args) throws Exception {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.put(1, "A");
        myHashMap.put(2, "B");
        myHashMap.put(3, "C");
        myHashMap.put(4, "D");
        myHashMap.put(5,  "E");
        myHashMap.put(6, "F");
    
        System.out.println(myHashMap);
    }
}
