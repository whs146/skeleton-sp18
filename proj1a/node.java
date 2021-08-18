public class node<T> {
    protected T item;
    protected node next;
    protected node prev;

    public node(T item,node prev,node next){
       item=item;
       next=next;
       prev=prev;
    }

    public T get(int x){
        node t=this;
        int s=0;
        while(s!=x){
            t=t.next;
            s+=1;
        }
        return (T)t.next.item;
    }

    public T getItem(int x){
        node t=this;
        if(x==0){
            return (T)t.next.item;
        }
        return (T)t.next.getItem(x-1);
    }
}
