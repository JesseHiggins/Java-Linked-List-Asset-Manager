public class AssetListController {
    private final AssetListModel model;
    private final AssetListView view;

    public AssetListController(AssetListModel model, AssetListView view) {
        if (model == null || view == null) {
            throw new IllegalArgumentException("Model and View cannot be null");
        }
        this.model = model;
        this.view = view;
    }

    public void start() {
        view.append("\n|=======================================|\n");
        view.append("|Welcome to the Asset Management System!|\n");
        view.append("|=======================================|\n");
        while (true) {
            model.accrueAllAssets();
            updateView();
            try {
                String choice = view.getInput("Choose an option:\n" +
                        "1. Add Asset\n" +
                        "2. Remove Asset\n" +
                        "3. Change Asset\n" +
                        "4. Accrue One Year\n" +
                        "5. Filter Assets\n" +
                        "6. Exit\n" +
                        "Enter choice (1-6): ");

                switch (choice) {
                    case "1":
                        promptAddAsset();
                        break;
                    case "2":
                        int indexToRemove = Integer.parseInt(view.getInput("Enter index of asset to remove: "));
                        model.removeAsset(indexToRemove);
                        view.append("Asset removed successfully.\n");
                        break;
                    case "3":
                        promptChangeAsset();
                        break;
                    case "4":
                        model.changeAssetPeriods(1);
                        view.append("\n***All assets accrued successfully.***\n");
                        break;
                    case "5":
                        promptFilterAssets();
                        break;
                    case "6":
                        view.append("Exiting the Asset Management System. Goodbye!\n");
                        return;
                    default:
                        view.append("Invalid choice. Please try again.\n");
                }
            } catch (Exception e) {
                view.append("Error: " + e.getMessage() + "\n");
            }
        }
    }

    private void promptFilterAssets() {
        view.append("Filter assets by:\n");
        view.append("1. Type\n");
        view.append("2. Name\n");
        view.append("3. Value Range\n");

        String choice = view.getInput("Enter choice (1-3): ");
        switch (choice) {
            case "1":
                String typeStr = view.getInput("Enter asset type (STOCK, CASH, BOND): ");
                assetType type = assetType.valueOf(typeStr.toUpperCase());
                model.filterAssetsByType(type);
                view.append("Assets filtered by type successfully.\n");
                break;
            case "2":
                String name = view.getInput("Enter asset name to filter by: ");
                model.filterAssetsByName(name);
                view.append("Assets filtered by name successfully.\n");
                break;
            case "3":
                double minValue = Double.parseDouble(view.getInput("Enter minimum value: "));
                double maxValue = Double.parseDouble(view.getInput("Enter maximum value: "));
                model.filterAssetsByValue(minValue, maxValue);
                view.append("Assets filtered by value range successfully.\n");
                break;
            default:
                view.append("Invalid choice. Please try again.\n");
        }
    }

    private void updateView() {
        view.append("\nCurrent Assets:\n");
        if (model.length() == 0) {
            view.append("No assets available.\n\n");
            return;
        }
        view.append(model.toString()+ "\n");
        view.append("Total Asset Value: " + model.getTotalAssetValue() + "\n\n");
    }

    private void promptAddAsset() {
        view.append("What type of asset would you like to add?\n");
        view.append("1. Stock\n");
        view.append("2. Cash\n");
        view.append("3. Bond\n");

        String choice = view.getInput("Enter choice (1-3): ");
        switch (choice) {
            case "1":
                promptAddStock();
                break;
            case "2":
                promptAddCash();
                break;
            case "3":
                promptAddBond();
                break;
            default:
                view.append("Invalid choice. Please try again.\n");
        }

    }
    private void promptAddStock() { 
        String name = view.getInput("Enter asset name: ");
        double rate = Double.parseDouble(view.getInput("Enter interest rate (%): "));
        double period = Double.parseDouble(view.getInput("Enter period (years): "));
        double principal = Double.parseDouble(view.getInput("Enter principal amount: "));
        double price = Double.parseDouble(view.getInput("Enter stock price: "));

        Asset newAsset = new Stock(name, rate, period, principal, price);
        model.addAsset(newAsset);
        view.append("Stock added successfully.\n");
    }

    private void promptAddCash() {
        String name = view.getInput("Enter asset name: ");
        double rate = Double.parseDouble(view.getInput("Enter interest rate (%): "));
        double period = Double.parseDouble(view.getInput("Enter period (years): "));
        double principal = Double.parseDouble(view.getInput("Enter principal amount: "));

        Asset newAsset = new Cash(name, rate, period, principal, 0);
        model.addAsset(newAsset);
        view.append("Cash asset added successfully.\n");
    }

    private void promptAddBond() {
        String name = view.getInput("Enter asset name: ");
        double rate = Double.parseDouble(view.getInput("Enter interest rate (%): "));
        double period = Double.parseDouble(view.getInput("Enter period (years): "));
        double principal = Double.parseDouble(view.getInput("Enter principal amount: "));
        double faceValue = Double.parseDouble(view.getInput("Enter face value: "));
        double maturity = Double.parseDouble(view.getInput("Enter maturity (years): "));

        Asset newAsset = new Bond(name, rate, period, principal, faceValue, maturity);
        model.addAsset(newAsset);
        view.append("Bond added successfully.\n");
    }

    private void promptChangeAsset() {
        int index = Integer.parseInt(view.getInput("Enter index of asset to change: ")) - 1;
        view.append("What would you like to change?\n");
        view.append("1. Name\n");
        view.append("2. Principal\n");
        view.append("3. Rate\n");
        view.append("4. Period\n");

        String choice = view.getInput("Enter choice (1-4): ");
        switch (choice) {
            case "1":
                String newName = view.getInput("Enter new name: ");
                model.changeAssetName(index, newName);
                view.append("Asset name updated successfully.\n");
                break;
            case "2":
                double newPrincipal = Double.parseDouble(view.getInput("Enter new principal: "));
                model.changeAssetPrincipal(index, newPrincipal);
                view.append("Asset principal updated successfully.\n");
                break;
            case "3":
                double newRate = Double.parseDouble(view.getInput("Enter new rate: "));
                model.changeAssetRate(index, newRate);
                view.append("Asset rate updated successfully.\n");
                break;
            case "4":
                double newPeriod = Double.parseDouble(view.getInput("Enter new period: "));
                model.changeAssetPeriod(index, newPeriod);
                view.append("Asset period updated successfully.\n");
                break;
            default:
                view.append("Invalid choice. Please try again.\n");
        }
    }
}
