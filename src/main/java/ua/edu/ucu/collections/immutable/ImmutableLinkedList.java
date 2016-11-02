package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList{
    protected Node head;
    protected int listSize;
    protected Node cur;
    protected ImmutableLinkedList newList;
    protected Node nodeLink;

    public ImmutableLinkedList(){
        listSize = 0;
        head = new Node(null);
    }

    @Override
    public ImmutableList add(Object newElement){
        return add(listSize, newElement);
    }

    // ----------------------------------------------------------------------
    @Override
    public ImmutableList add(int index, Object nw){
        return null;
    }

    @Override
    public ImmutableList addAll(Object[] lst){
        return addAll(listSize, lst);
    }

    @Override
    public ImmutableList addAll(int startIndex, Object[] lst){return null;}


    // --------------------------------------------------------------------------
    @Override
    public Object get(int index) {
        checkingIndex(index);
        visitingNodes(index + 1);
        return cur;
    }

    @Override
    public ImmutableList remove(int index){
        checkingIndex(index);
        visitingNodes(index + 1);
        cur = cur.getNext();
        visitingNodes(listSize-1);    //just moving to the last node in list
        newList.listSize = listSize - 1;
        return newList;
    }


    public void visitingNodes(int index){
        checkingIndex(index);

        newList = new ImmutableLinkedList();
        cur = head;
        int position = 0;
        nodeLink = newList.head;

        while (cur.getNext() != null && position != index){
            Node tempo = cur.getNext();
            cur = tempo;
            Node linkNode = new Node(tempo.getData(), tempo.getNext());
            nodeLink.setData(linkNode.data);
            nodeLink = nodeLink.getNext();
            position ++;
        }
    }

    @Override
    public ImmutableList set(int index, Object e) {
        visitingNodes(index + 1);
        Node tmp = new Node(e);
        nodeLink.setData(tmp.getData());
        visitingNodes(listSize);    //just moving to the last node in list
        newList.listSize = listSize;
        return newList;
    }

    @Override
    public ImmutableList clear(){
        newList = new ImmutableLinkedList();
        return newList;
    }

    @Override
    public int size(){
        return listSize;
    }

    @Override
    public int indexOf(Object e) {
        cur = head;
        int pos = 0;
        Node tmp = new Node(e);
        while (cur.getNext() != null) {
            if (cur.getData() == tmp.getData()) {
                return pos - 1;
            }
            pos++;
            cur = cur.getNext();
        }
        return -1;
    }

    @Override
    public  boolean isEmpty(){
        return (listSize==0);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public String toString() {

        String str = "List: ";
        Node cur = head;
        while (cur.getNext() != null) {
            cur = cur.getNext();
            str += cur.data;
            str += ' ';
        }
        return str;
    }

    public void checkingIndex(int i) {
        if (i > listSize) {
            throw new IndexOutOfBoundsException();
        }
    }
}
