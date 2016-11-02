package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList{
    protected Node head;
    protected int listSize;
    protected Node cur;

    public ImmutableLinkedList(){
        listSize = 0;
        head = new Node(null);
    }

    @Override
    public ImmutableList add(Object newElement){
        return add(listSize, newElement);
    }

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

    @Override
    public Object get(int index) {return null;}

    @Override
    public ImmutableList remove(int index){return null;}

    @Override
    public ImmutableList set(int index, Object e) {return null;}

    




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

}
