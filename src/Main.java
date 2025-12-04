import java.io.Reader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // ListImpl<Integer> list = new ListImpl<>();
        // ListImpl<Integer> filteredlist;
        // ListImpl<Integer> mappedlist;
        // Integer foldedlistresult;

        // list.addNodeAtEnd(5);
        // list.addNodeAtEnd(10);
        // list.addNodeAtEnd(15);

        // System.out.println("Original List:");
        // System.out.println(list.toStringVertical());
        

        // for (Integer value : list) {
        //     System.out.println("Value: " + value);
        // }

        // filteredlist = list.filter(value -> value > 7);
        // System.out.println("\nFiltered List (values > 7):");
        // System.out.println(filteredlist.toStringVertical());

        // mappedlist = list.map(value -> value * 2);
        // System.out.println("\nMapped List (values * 2):");
        // System.out.println(mappedlist.toStringVertical());

        // foldedlistresult = list.fold(0, (acc, value) -> acc + value);
        // System.out.println("\nFolded List (sum of values):");
        // System.out.println(foldedlistresult);

        // Bond bond = new Bond("Gov Bond", 0, 5.0, 2.0, 950, 1000, 10 );
        // bond.accrue();
        // System.out.println("\nBond after accruing:");
        // System.out.println(bond.toString());
        // bond.setPeriod(10.0);
        // bond.accrue();
        // System.out.println("\nBond after maturity period:");
        // System.out.println(bond.toString());

        // AssetListModel assetList = new AssetListModel();
        // Bond bond1 = new Bond("Corp Bond", 4.0, 1.0, 900, 1000, 5 );
        // Stock stock1 = new Stock("Tech Stock", 10000, 8.0, 1.0, 1000 );
        // Cash cash1 = new Cash("Savings", 3.0, 1.0, 5000, 0 );
        // assetList.addAsset(bond1);
        // assetList.addAsset(stock1);
        // assetList.addAsset(cash1);

        // System.out.println("\nAsset List before accruing:");
        // System.out.println(assetList);

        // System.out.println("\nAccruing all assets after 1 period...");
        // assetList.changeAssetPeriods(1);
        // assetList.accrueAllAssets();
        AssetListModel model = new AssetListModel();
        AssetListView view = new AssetListView(System.out, new InputStreamReader(System.in));

        AssetListController controller = new AssetListController(model, view);

        controller.start();

    }
}
