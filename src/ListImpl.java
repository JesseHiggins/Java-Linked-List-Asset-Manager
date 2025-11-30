import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This `ListImpl` class implements the linked list functionality using content node and empty node.
 * It attempts to maintain abstraction so that this implementation could be used for any generic object.
 * It includes methods for getData, count list, counting lists on predicate, getting content nodes, removing all tasks,
 * removing based on a predicate, filtering, modifying nodes, and tostring.
 * </p>
 * @author Jesse Higgins
 * @version 1.0
 * @since 2025-11-26
 */
public class ListImpl<T>{
    private Node<T> head;
    
    public ListImpl(){
        head = new EmptyNode<>();
    }

    public void addNode(T data){
        
       head = new ContentNode<>(head,data);
        
    }

    public void removeAllNodes() {
        this.head = head.removeAllNodes();
    }

    public void removeNode(int index){
        this.head = head.removeNode(index);
    }

    public void removeNodePredicate(Predicate<T> predicate){
        this.head = head.removeNodePredicate(predicate);
    }

    public int count(){
        return head.count();
    }

    public int countPredicate(Predicate<T> predicate){
        return head.countPredicate(predicate);
    }

    public Node<T> getContent(int index)
    {
        return head.getContent(index);
    }

    public String toStringPredicate(Predicate<T> predicate) {
        return head.toStringPredicate(predicate);
    }

    public String toString(){
        return head.toString();
    }

    public String toStringVertical(){
        return head.toStringVertical();
    }

    public void modifyNode(int index, Consumer<T> modifier) {
        head.modifyNode(index, modifier);
    }
    
}