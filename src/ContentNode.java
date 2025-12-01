import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This `ContentNode` class extends the node interface for functionality as a data node in linked list.
 * It includes methods for getData, count list, counting lists on predicate, getting content nodes, removing all tasks,
 * removing based on a predicate, filtering, modifying nodes, and tostring.
 * </p>
 * @author Jesse Higgins
 * @version 1.0
 * @since 2025-11-26
 */
public class ContentNode<T> implements Node<T>{

    //initialized generic variable T and node generic node<T> so that linked list works with any type of object passed.
    public T data;
    public Node<T> nextNode;

    /**
     * Constructs content node with generic data T and defines nextNode for linked list.
     *
     * @param data Generic parameter for any data type.
     * @param nextNode generic next node data.
     */
    public ContentNode(Node<T> nextNode, T data){
        this.nextNode = nextNode; 
        this.data = data;
    }

    public Node<T> getNext(){
        return this.nextNode;
    }

    /**
     * Returns data from node.
     *
     * @return T generic return of data from node.
     */
    public T getData(){return data;}

    /**
     * Count nodes in linked list.
     *
     * @return int
     *
     */
    public int count(){ 
        return 1 + nextNode.count();
    }

    public int countPredicate(Predicate<T> predicate) {
        if (predicate.test(this.data)) {
            return 1 + nextNode.countPredicate(predicate);
        } else {
            return nextNode.countPredicate(predicate);
        }
    }

    /**
     * Returns node given index for list starting at 0.
     *
     * @param index index from 0 to length of list.
     * @return Node generic node
     */
    public Node<T> getContent(int index){

        if (index == 0) {
            return this;
        }
        else
        {
            --index;
            return nextNode.getContent(index);
        }
    }

    /**
     * Returns node given index for list starting at 0.
     *
     * @return Node generic node
     */
    public Node<T> removeAllNodes(){
        Node<T> empytnode = nextNode.removeAllNodes();
        this.data = null;
        this.nextNode = null;
        return empytnode;
    }

    /**
     * Removes node given index for list starting at 0.
     *
     * @param index index from 0 to length of list.
     */
    public Node<T> removeNode(int index){

        if (index < 0 || index >= count()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return this.nextNode;
        }

        this.nextNode = this.nextNode.removeNode(index-1);
        return this;
    }

    /**
     * Removes node given data generic.
     *
     */
    public Node<T> removeNodeId(T data){

        if (data == null) {
            throw new NullPointerException();
        }

        if (data.equals(this.data)) {
            return this.nextNode;
        }

        this.nextNode = this.nextNode.removeNodeId(data);
        return this;
    }

    /**
     * Removes node given predicate test.
     *
     */
    public Node<T> removeNodePredicate(Predicate<T> predicate){
        if (predicate.test(this.data)) {
            return this.nextNode.removeNodePredicate(predicate);
        }
        this.nextNode = this.nextNode.removeNodePredicate(predicate);
        return this;
    }

    /**
     * Filters linked list given predicate test and returns filtered head node.
     *
     * @return Node
     */
    public Node<T> filter(Predicate<T> test){
        
        if (test.test(data)){
            return new ContentNode<>(nextNode.filter(test), data);
        }else{
            return nextNode.filter(test);
        }
    }

    /**
     * returns string of data
     *
     * @return String
     */
    public String toString(){
        return data + " -> " + nextNode.toString();
    }

    /**
     * returns string of data
     *
     * @return String
     */
    public String toStringVertical() {
        return data + "\n" + nextNode.toStringVertical();
    }

    public String toStringPredicate(Predicate<T> predicate){
        if (predicate.test(this.data)) {
            return data + "\n" + nextNode.toStringPredicate(predicate);
        } else  {
            return nextNode.toStringPredicate(predicate);
        }
    }

    /**
     * Modifies node given index and consumer modifier.
     * Consumer predicate used to pass object parameters to the node modifier in generic.
     *
     *
     * @param index index from 0 to length of list.
     */
    public void modifyNode(int index, Consumer<T> modifier){
        if (index < 0 || index >= count()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            modifier.accept(this.data);
        } else {
            nextNode.modifyNode(index - 1, modifier);
        }
    }
    
}