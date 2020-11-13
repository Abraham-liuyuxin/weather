package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise19<Item> {

    private class Node{
        Item item;
        Node next;
    }

    private int size;
    private Node first;

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void add(Item item){
        if (isEmpty()){
            first.item = item;
        } else{
            Node temp = new Node();
            temp.item = item;
            Node current = first;
            while (current.next != null){
                current = current.next;
            }//此时current为tail
            current.next = temp;
        }
        size++;
    }

    public Node findpre(Node temp){
        Node current = first;
        Node c_pre = first;
        while (current != temp){
            c_pre = current;
            current = current.next;
        }
        if(c_pre == first){
            throw new IllegalArgumentException();
        }
        return c_pre;
    }

    public Node find(Node temp){
        Node current = first;
        while (current != temp){
            current = current.next;
        }
        return current;
    }

    public void delete(Node temp){
        if(temp == first){
            temp.next = null;
            temp = null;
        }else {
            Node temp_pre = this.findpre(temp);
            temp_pre.next = temp.next;
            temp.next = null;
        }
        size--;
    }

    //1.3.20
    public void delete(int k){
        if(k > size){
            StdOut.println("不存在第k号元素，删除失败");
        } else {
            Node current = first;
            int count = 1;
            while (count < k){
                current = current.next;
                count++;
            }
            delete(current);
        }
    }

    //1.3.19
    public void deleteTail(){
        if(isEmpty()){
            StdOut.println("链表为空，无法删除尾结点");
        } else {
            Node current = first;
            while (current.next != null){
                current = current.next;
            }
            //现在current为tail
            delete(current);
        }
    }

    //1.3.21
    public boolean find(String key, Node list){
        if(list == null){
            throw new IllegalArgumentException();
        } else {
            if (list.item.equals(key)) return true;
        }
        Node current = list;
        while (current.next != null){
            current = current.next;
            if(current.item.equals(key)) return true;
        }
        return false;
    }

    //1.3.24
    public void removeAfter(Node temp){
        Node current = this.find(temp);
        if (temp == null || temp.next == null){
            StdOut.println("本结点或后续结点为空");
        } else {
            temp.next = temp.next.next;
        }
        size--;
    }

    //1.3.30-1
    public Node reverse(Node first){
        Node reverse = null;
        if (first == null) return null;
        if (first.next == null) return first;
        while (first.next != null){
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    //1.3.30-2
    public  Node recurse(Node first){
        if (first == null) return null;
        if (first.next == null) return first;
        Node second = first.next;
        Node rest = recurse(second);
        second.next = first;
        first.next = null;
        return rest;
    }
}
