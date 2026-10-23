/**
 * SinglyLinkedList
 */
public class SinglyLinkedList implements LinkedList{

    public Node head,tail;
    private int size=0;

    public SinglyLinkedList(){
        head=tail=null;
    }
    public boolean isEmpty(){
        return(size==0);
    }
    public int size(){
        return size;
    }
    public void addFirst(Object inputData){
        Node baru = new Node(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else {
            baru.pointer = head;
            head = baru;
            size++;
        }
    }

    public void addLast(Object inputData){
        Node baru = new Node(inputData);
        if (isEmpty()){
            head = baru;
            tail = baru;
            size++;
        }
        else {
            tail.pointer = baru;
            tail = baru;
            size++;
        }
    }

    public void addAfter(int index,Object inputData){
        Node baru = new Node(inputData);
        Node C=head;
        for(int i=0;i<index;i++){
            C = C.pointer;
        }
        baru.pointer = C.pointer;
        C.pointer = baru;
    }

    public void deleteFirst(){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            head = head.pointer;
            size--;
        }
    }

    public void deleteLast(){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            Node temp = head;
            for(int i=1;i<size-1;i++){//berhenti di node sebelum tail
                temp = temp.pointer;
            }
            tail = temp;
            tail.pointer = null;
            size--;
        }
    }

    public void deleteAfter(int index){
        if(isEmpty()){
            System.err.println("Linked list kosong");
        }
        else if(size==1){//else if(head==tail)
            head = null;
            tail = null;
            size--;
        }
        else{
            Node temp = head;
            for(int i=0;i<index;i++){
                temp = temp.pointer;
            }
            temp.pointer = temp.pointer.pointer;
            size--;
        }
    }

    public void print(){
        Node currentNode = head;
        for(int i =0;i<size;i++){
            System.out.println(currentNode.data);
            currentNode = currentNode.pointer;
        }
    }
    @Override
    public Object get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.pointer;
        }
        return temp.data;
    }
    @Override
    public int indexOf(Object targetData) {
        Node temp = head;
        for(int i=0;i<size;i++){
            if(temp.data.equals(targetData)){
                return i;
            }
            temp = temp.pointer;
        }
        return -1;
    }
    @Override
    public void printReverse() {
        Object[] data = toArray();
        for(int i=data.length-1;i>=0;i--){
            System.out.println(data[i]);
        }
    }
    @Override
    public boolean remove(Object targetData) {
        int index = indexOf(targetData);
        if(index == -1){
            return false;
        }
        if(index == 0){
            deleteFirst();
        }
        else if(index == size-1){
            deleteLast();
        }
        else{
            deleteAfter(index-1);
        }
        return true;
    }
    @Override
    public Object[] toArray() {
        Object[] hasil = new Object[size];
        Node temp = head;
        for(int i=0;i<size;i++){
            hasil[i] = temp.data;
            temp = temp.pointer;
        }
        return hasil;
    }
}