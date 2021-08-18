public class LinkedListDeque<T> {
    private node sentinal;
    private int size;

    public LinkedListDeque() {
        sentinal = new node(63, null, null);
        size = 0;
        sentinal.next=sentinal;
        sentinal.prev=sentinal;
    }

    public void addFirst(T item) {
        size += 1;
        node first = new node(item, sentinal, null);
        node p = sentinal;
        if (p.next == p) {
            p.next = first;
            p.prev = first;
            first.next = p;
        } else {
            first.next = p.next;
            p.next = first;

        }
    }

    public void addLast(T item) {
        size += 1;
        node last = new node(item, null, sentinal);
        node p = sentinal;
        if (p.next == p) {
            p.next = last;
            p.prev = last;
            last.prev = p;
        } else {
            last.prev = p.prev;
            p.prev = last;
        }
    }

    public boolean isEmpty() {
        return sentinal.next == sentinal;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        node p = sentinal;
        while (p.next != sentinal) {
            System.out.println(sentinal.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        node p = sentinal;
        if (!isEmpty()) {

            node temp = p.next;
            p.next = temp.next;
            temp.next.prev = p;
            return (T)temp.item;


        }
        return null;
    }

    public T removeLast(){
        node p = sentinal;
        if(!isEmpty()){
            node temp=p.prev;
            temp.prev.next=p;
            p.prev=temp.prev;
            return (T)temp.item;
        }
        return null;
    }

    public T getRecursive(int index){
        if(index==0){
            return (T)sentinal.next.item;
        }
        return (T) sentinal.get(index);
    }


}



