/**
 * This `ToDoList` class uses a ListImpl object with nodes and tasks as data in nodes to implement a specific todolist.
 * It includes methods for constructors, get task, add task, remove tasks, change task variables, remove specific tasks, and tostring.
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
        assetList.removeNode(index);
    }

    public void accrueAllAssets() {
        for (Accrueable asset : assetList) {
            asset.accrue();
        }
    }

    public void changeAssetPeriods(double newPeriod) {
        assetList.forEach(asset -> asset.setPeriod(newPeriod));
    }

    public int countAssets() {
        return assetList.count();
    }

    @Override
    public String toString() {
        return assetList.toStringIndex();
    }


    // public void removeTaskId(int id) {toDoList.removeNodePredicate(task -> task.getId() == id);}

//     public void removeTask(int index) {
//         toDoList.removeNode(index);
//     }

//     public void removeAllTasks() {
//         toDoList.removeAllNodes();
//     }

    public void changePeriod(int index, double period) {
        assetList.modifyNode(index, asset -> asset.setPeriod(period));
    }

//     public void changePriority(int index, Priority priority) {
//         toDoList.modifyNode(index, task -> task.setPriority(priority));
//     }

//     public void setCompleted(int index, boolean completed) {
//         toDoList.modifyNode(index, task -> task.setCompleted(completed));
//     }

//     public int countTasks() {
//         return toDoList.count();
//     }

//     public int countCompletedTasks() {
//         return toDoList.countPredicate(task -> task.isCompleted().equals(true));
//     }

//     public int countExpiredTasks() {
//         return toDoList.countPredicate(task -> task.isExpired().equals(true));
//     }


//    public String toStringPriority(Priority priority) {
//        return toDoList.toStringPredicate(task -> task.getPriority().equals(priority));
//    }

//    public String toStringExpiredTasks() {
//        return toDoList.toStringPredicate(task -> task.isExpired().equals(true));
//    }

//    public void removeCompletedTasks() {
//        toDoList.removeNodePredicate(task -> task.isCompleted().equals(true));
//    }

//    public void removeExpiredTasks() {
//         toDoList.removeNodePredicate(task -> task.isExpired().equals(true));
//    }

//    public void removePriorityTasks(Priority priority) {
//         toDoList.removeNodePredicate(task -> task.getPriority().equals(priority));
//    }

//    public String toString() {
//         return toDoList.toStringVertical();
//    }
}
