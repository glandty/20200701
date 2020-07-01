public class TestDemo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.addLast(4);
        myLinkedList.addLast(5);
        myLinkedList.addLast(2);
        myLinkedList.display();
        //System.out.println(myLinkedList.contains(4));
        //System.out.println(myLinkedList.size());
//        myLinkedList.addIndex(0,8);
//        myLinkedList.addIndex(7,99);
//        myLinkedList.addIndex(4,199);
//        myLinkedList.display();
        //myLinkedList.remove(6);
        myLinkedList.removeAll(2);
        myLinkedList.display();
    }
}
