import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
public class ListImpl<T> implements Iterable<T> {
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

    public Node<T> getHead() {
        return this.head;
    }
    
    /**
     * Filter elements of a list based on a predicate.
     * @param test predicate to test elements
     * @return list of elements that satisfy the predicate
     */
    public ListImpl<T> filter(Predicate<T> test){
        ListImpl<T> filteredList = new ListImpl<>();
        
        for (T item : this) {
            if (test.test(item)) {
                filteredList.addNode(item);
            }
        }
        return filteredList;
    }

    /**
    * Apply a function to every element of a list.
    * Adapted to my project from a MIT opencourse example. 
    * https://web.mit.edu/6.005/www/fa14/classes/24-map-filter-reduce/
    * @param f function to apply
    * @param list list to iterate over
    * @return [f(list[0]), f(list[1]), ..., f(list[n-1])]
    */
    public <R> ListImpl<R> map(Function<T,R> f) {
        ListImpl<R> result = new ListImpl<>();

        for (T t : this) {
            result.addNode(f.apply(t));
        }
        return result;
    }

    /* Example snippet for fold operation in Java taken and adapted from:
    * https://codingtechroom.com/question/how-to-implement-list-fold-in-java#google_vignette
    * @param list List to fold
    * @param initial Initial value
    * @param folder Folding function
    * @return Result of folding operation
    */
    public <R> R fold(R initial, BiFunction<R, T, R> folder) {
        R result = initial;
        for (T item : this) {
            result = folder.apply(result, item);
        }
        return result;
    }

    // return Iterator instance
    public Iterator<T> iterator()
    {
        return new ListIterator<T>(this);
    }
    
    class ListIterator<U> implements Iterator<U> {
    Node<U> current;
    
        // initialize pointer to head of the list for iteration
        public ListIterator(ListImpl<U> list)
        {
            current = list.getHead();
        }
        
        // returns false if next element does not exist
        public boolean hasNext()
        {
            return current.getData() != null;
        }
        
        // return current data and update pointer
        public U next()
        {
            U data = current.getData();
            current = current.getNext();
            return data;
        }
        
        // implement if needed
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
    
}