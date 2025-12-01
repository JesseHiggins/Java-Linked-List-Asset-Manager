
public class Main {
    public static void main(String[] args) {
        ListImpl<Integer> list = new ListImpl<>();

        list.addNode(5);
        list.addNode(10);
        list.addNode(15);

        System.out.println("Original List:");
        System.out.println(list.toStringVertical());
        

        for (Integer value : list) {
            System.out.println("Value: " + value);
        }

    
    }
}
