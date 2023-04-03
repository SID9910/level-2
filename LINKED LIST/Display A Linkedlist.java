import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node next;
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;


    public void display(){
    if(size==0){
      return ;
    }
    for(Node temp =head ;temp!=null ;temp=temp.next){
      System.out.print(temp.data+ " ");
    }
    System.out.println();
    }
  }

  public static void main(String[] args) {

    LinkedList list = new LinkedList();
        list.display();
    
    }
  
}