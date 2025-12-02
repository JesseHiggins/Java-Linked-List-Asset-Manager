import java.util.function.Consumer;
import java.util.function.Predicate;
/**
 * This `Node` interface defines the methods needed by any node in a linked list implementation.
 * It includes methods for getData, count list, counting lists on predicate, getting content nodes, removing all tasks,
 * removing based on a predicate, filtering, modifying nodes, and tostring.
 * </p>
 * @author Jesse Higgins
 * @version 1.0
 * @since 2025-11-26
 */


public interface Node<T>{
    //returns the number of nodes in a list
    int count();

    int countPredicate(Predicate<T> predicate);

    //return the content of a node
    Node<T> getContent(int index);

    T getData();

    void setNext(Node<T> nextNode);

    Node<T> filter(Predicate<T> test);

    Node<T> removeAllNodes();

    Node<T> removeNode(int index);

    Node<T> removeNodeId(T data);

    Node<T> removeNodePredicate(Predicate<T> test);

    void modifyNode(int index, Consumer<T> modifier);

    String toStringPredicate(Predicate<T> predicate);

    String toStringVertical();

    Node<T> getNext();

}