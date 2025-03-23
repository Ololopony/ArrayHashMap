public class App {
    public static void main(String[] args) throws Exception {
        MyArrayList<Integer> ints = new MyArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);
        ints.add(6);
        ints.add(4, 8);
        ints.add(4, 8);
        System.out.println(ints.toString());
    }
}
