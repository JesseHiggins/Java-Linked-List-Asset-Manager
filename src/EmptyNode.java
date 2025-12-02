import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This `EmptyNode` class extends the node interface for functionality as an empty node in linked list.
 * It usually returns null in order to indicate end of list and end of recursion.
 * It includes methods for getData, count list, counting lists on predicate, getting content nodes, removing all tasks,
 * removing based on a predicate, filtering, modifying nodes, and tostring.
 * </p>
 * @author Jesse Higgins
 * @version 1.0
 * @since 2025-11-26
 */
public class EmptyNode<T> implements Node<T>{

    public int count(){
        return 0;
    }

    public int countPredicate(Predicate<T> predicate){ return 0; }
    
    public T getData(){return null;}

    public void setNext(Node<T> nextNode){}
    
    public Node<T> getContent(int index){
        return null;
    }

    public Node<T> removeAllNodes(){return this;}

    public Node<T> removeNode(int index){return this;}

    public Node<T> removeNodeId(T data){return this;}

    public Node<T> removeNodePredicate(Predicate<T> predicate){ return this;}
    
    public Node<T> filter(Predicate<T> test){
        return new EmptyNode<>();
    }
    
    public String toString(){
        return "";
    }

    public String toStringVertical(){return "";}

    public String toStringPredicate(Predicate<T> predicate){ return ""; }

    public void modifyNode(int index, Consumer<T> modifier){}

    public Node<T> getNext(){
        return null;
    }
    
}