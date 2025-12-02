
public class Main {
    public static void main(String[] args) {
        ListImpl<Integer> list = new ListImpl<>();
        ListImpl<Integer> filteredlist;
        ListImpl<Integer> mappedlist;
        Integer foldedlistresult;

        list.addNodeAtEnd(5);
        list.addNodeAtEnd(10);
        list.addNodeAtEnd(15);

        System.out.println("Original List:");
        System.out.println(list.toStringVertical());
        

        for (Integer value : list) {
            System.out.println("Value: " + value);
        }

        filteredlist = list.filter(value -> value > 7);
        System.out.println("\nFiltered List (values > 7):");
        System.out.println(filteredlist.toStringVertical());

        mappedlist = list.map(value -> value * 2);
        System.out.println("\nMapped List (values * 2):");
        System.out.println(mappedlist.toStringVertical());

        foldedlistresult = list.fold(0, (acc, value) -> acc + value);
        System.out.println("\nFolded List (sum of values):");
        System.out.println(foldedlistresult);
    }
}
