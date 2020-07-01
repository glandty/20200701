class Node {
    public int data;
    public Node prev;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class MyLinkedList {
    public Node head;
    public Node tail;//标志双向链表的尾巴

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }

    //查找是否包含关键字key
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null){
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //得到单链表的长度
    public int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //任意位置插入,第一个数据节点为0号下标
    private void checkIndex(int index) {
        if(index < 0 || index >size()) {
            throw new RuntimeException("index不合法");
        }
    }

    private Node searchIndex(int index) {
        Node cur = this.head;
        while(index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }
    public void addIndex(int index,int data) {
        checkIndex(index);
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == this.size()) {
            addLast(data);
            return;
        }
        Node cur = searchIndex(index);
        Node node = new Node(data);
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;
    }

    //删除第一次出现关键字为key的节点
    public int remove(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.data == key) {
                int oldData = cur.data;
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else {
                        this.tail = cur.prev;
                    }
                }
                return oldData;
            }
            cur = cur.next;
        }
        return -1;
    }

    //删除所有关键词为key的节点
    public void removeAll(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.data == key) {
                int oldData = cur.data;
                if(cur == this.head) {
                    this.head = this.head.next;
                    if(this.head != null) {
                        this.head.prev = null;
                    }
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else {
                        this.tail = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

   //清楚内存
    public void clear() {
        while(this.head != null) {
            Node cur = head.next;
            head.prev = null;
            head.next = null;
            head = cur;
        }
        this.tail = null;
    }

    //打印函数
    public void display() {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
