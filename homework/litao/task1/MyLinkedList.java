package undo.task1;

public class MyLinkedList<T> implements MyList<T> {
    private int size;
    Node head=new Node();
    Node tail=head;

    @Override
    public int size() {
        return size;
    }
    //
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void add(T element) {
        Node tmp=new Node();
        tmp.setElement(element);
        tail.setNext(tmp);
        tmp.setPre(tail);
        tail=tmp;
        size++;
    }

    @Override
    public T get(int index) {
        getCheckForIndex(index);
        Node<T> tmp=getNode(index);
        return tmp.getElement();
    }

    private Node<T> getNode(int index) {
        Node temp=head;
        if(index<size/2){
            for(int i=0;i<=index;i++)
                temp = temp.getNext();
        }
        else{
            temp=tail;
            for(int i=size-1;i>index;i--)
                temp=temp.getPre();
        }
        return temp;
    }

    private void getCheckForIndex(int index) {
        if(index<0||index>=size)
            throw new IllegalArgumentException("Illegal index"+index);
    }

    @Override
    public T set(int index, T element) {
        getCheckForIndex(index);
        Node<T> tmp=getNode(index);
        T ele=tmp.element;
        tmp.setElement(element);
        return ele;
    }

    @Override
    public T remove(int index) {
        getCheckForIndex(index);
        //delete the tail
        Node<T> temp=null;
        if(index==size-1){
            temp = tail;
            tail = tail.getPre();
            tail.setNext(null);
            temp.setPre(null);
        }
        else{
            Node previous;
            temp=getNode(index);
            previous = temp.getPre();
            previous.setNext(temp.getNext());
            temp.getNext().setPre(previous);
            temp.setNext(null);
            temp.setPre(null);
        }
        size--;
        return temp.getElement();
    }

    @Override
    public void clear() {
        head=tail;
        tail.setNext(null);
        tail.setPre(null);
        size=0;
    }

    class Node<T>{
        private T element;
        private Node<T> pre;
        private Node<T> next;

        public Node(){
        }

        public void setElement(T element) {
            this.element = element;
        }

        public void setPre(Node<T> pre) {
            this.pre = pre;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getPre() {
            return pre;
        }

        public Node<T> getNext() {
            return next;
        }
    }
}
