import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {

        AssetListModel model = new AssetListModel();
        AssetListView view = new AssetListView(System.out, new InputStreamReader(System.in));

        AssetListController controller = new AssetListController(model, view);

        controller.start();

    }
}
