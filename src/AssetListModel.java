/**
 * This `AssetListModel` class uses a ListImpl object with nodes and asset as data in nodes to implement a specific asset model.
 * It includes methods for constructors, get asset, add asset, remove asset, change asset variables, remove specific assets, and tostring.
 * </p>
 * @author Jesse Higgins
 * @version 1.0
 * @since 2025-11-26
 */
public class AssetListModel {

    private ListImpl<Asset> assetList;

    public AssetListModel() {
        this.assetList = new ListImpl<>();
    }

    public Accrueable getAsset(int index) {
       return assetList.getContent(index).getData();
    }

    public void addAsset(Asset asset) {
        assetList.addNodeAtEnd(asset);
    }

    public void removeAsset(int index) {
        if (index < 0 || index >= assetList.count()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index + " for asset list of size " + assetList.count());
        }
        assetList.removeNode(index);
    }

    public void accrueAllAssets() {
        for (Accrueable asset : assetList) {
            asset.accrue();
        }
    }

    public void changeAssetPeriods(double newPeriod) {
        assetList.forEach(asset -> asset.setPeriod(asset.getPeriod() + newPeriod));
    }

    public int length() {
        return assetList.count();
    }

    public void filterAssetsByType(assetType type) {
        assetList = assetList.filter(asset -> asset.getType() == type);
    }

    public void filterAssetsByName(String name) {
        assetList = assetList.filter(asset -> asset.getName().equals(name));
    }

    public void filterAssetsByValue(double minValue, double maxValue) {
        assetList = assetList.filter(asset -> asset.getValue() >= minValue && asset.getValue() <= maxValue);
    }

    public double getTotalAssetValue() {
        return assetList.fold(0.0, (acc, asset) -> acc + asset.getValue());
    }

    public void changeAssetName(int index, String newName) {
        assetList.modifyNode(index, asset -> asset.setName(newName));
    }

    public void changeAssetPrincipal(int index, double newPrincipal) {
        assetList.modifyNode(index, asset -> asset.setPrincipal(newPrincipal));
    }

    public void changeAssetRate(int index, double newRate) {
        assetList.modifyNode(index, asset -> asset.setRate(newRate));
    }

    public void changeAssetPeriod(int index, double newPeriod) {
        assetList.modifyNode(index, asset -> asset.setPeriod(newPeriod));
    }

    public void changePeriod(int index, double period) {
        assetList.modifyNode(index, asset -> asset.setPeriod(period));
    }

    @Override
    public String toString() {
        return assetList.toStringIndex();
    }

}
