package ua.edu.ucu.collections.immutable;

/**
 * Created by Mariya on 02.11.2016.
 */
public class Node {
    Object data;
    Node next;

    public Node(Object new_data){
        this.data = new_data;
        next = null;
    }
    public void setNext(Node otherNode){
        this.next = otherNode;
    }

    public Node getNext() {
        return next;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public Object getData(){
        return data;
    }
}
