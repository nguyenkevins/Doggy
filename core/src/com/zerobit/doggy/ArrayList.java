/**
 *
 * ArrayList.java
 *
 * Description: This class is a parent class for both Stack.java and Queue.java.
 *              It uses the concept of linked list to be able to use methods
 *              which is insert, delete, remove, append, size, indexOf, size,
 *              equals, and isEmpty.
 *
 * @author Kevin Nguyen
 *
 * @version 1
 *
 */

package com.zerobit.doggy;

import java.util.Iterator;

public class ArrayList <T> implements Iterable<T> {

   /**
    *
    * Description: This class is an inner class called Node which is pretty much
    *              the backbone of list, stacks, and queues. It is pretty much
    *              a way to setup linked list for the rest of the code.
    *
    * @author Kevin Nguyen
    *
    * @version 1
    *
    */
   public class Node  {

      private T data;
      private Node next;

      /**
       *
       * Node constructor
       *
       * This constrctor sets up a default node, which is null for both data and
       * next (in charge of linking nodes together).
       *
       * @pre-condition: No pre-condition
       *
       * @post-condition: data and next becomes null
       *
       * @return: No return statement
       *
       */
      public Node(){
         this.data = null;
         this.next = null;
      }

      /**
       *
       * Node constructor
       *
       * This constrctor takes in newData and nextLink as a parameter and sets
       * it equal to data and next.
       *
       * @pre-condition: No pre-condition
       *
       * @post-condition: data and next becomes whatever the constructor took in
       *
       * @return: No return statement
       *
       */
      public Node(T newData, Node nextLink) {
         this.data = newData;
         this.next = nextLink;
      }
   }

   public Node head = null;

   /**
    *
    * List constructor
    *
    * This constrctor doesn't take in any value and automatically sets the head
    * value to null. Everytime you create a List object, there should not be any
    * nodes to start with.
    *
    * @pre-condition: No pre-condition
    *
    * @post-condition: head is null
    *
    * @return: No return statement
    *
    */
   public ArrayList() {
      this.head = null;
   }



   /**
    *
    * insert method
    *
    * This method is in charge of putting an object inside the list and put it
    * in an index. By doing so, it increase all the other value's index to the
    * right of inserted index by 1.
    *
    * @pre-condition: Object next and an int index must be valid
    *
    * @post-condition: Another value added to the list
    *
    * @return: No return statement
    *
    */
   public void insert(T next, int index) {
      try {
         if(next == null) {
            throw new LinkedListException("WARNING!!! Null data not accepted!");
         }
         int count = 0;
         if(index == 0) {
            Node newNode = new Node(next,this.head);
            this.head = newNode;
         } else if(index > 0) {
            Node cur = head;
            while(cur.next != null) {
               count++;
               cur = cur.next;
            }
            if(index == count+1) {
               cur.next = new Node(next,null);
            } else if(index < count+1) {
               Node cur2 = head;
               count = 0;
               while(count+1 != index) {
                  count++;
                  cur2 = cur2.next;
               }
               Node storeNext = cur2.next;
               cur2.next = new Node(next,cur2.next);
            } else {
               throw new LinkedListException("WARNING!!! Index too far out!");
            }
         }
         if(index < 0) { throw new LinkedListException("WARNING!!! Index too far out!"); }
      }
      catch(Exception e) {
         System.out.println(e.getMessage());
      }
   }

   /**
    *
    * remove method
    *
    * This method is in charge of removing a value at a certain index. The
    * list will also adjust its size by reducing by 1 after removing an index.
    *
    * @pre-condition: An appropriate index that is within the list range
    *
    * @post-condition: The index value will be null and will be removed while
    *                  shifting the list and connect the nodes
    *
    * @return: Returns an Object that was removed
    *
    */
   public T remove(int index) {
      int count = 1;
      Node prev = head;
      Node answer = null;
      if(index==0) {
         answer = prev;
         prev = prev.next;
         head = prev;
      } else if(index > 0) {
         while(count < index) {
            count++;
            prev = prev.next;
         }
         Node cur = prev.next;
         answer = cur;
         prev.next = cur.next;
         cur.next = null;
      } else {
         answer = new Node(null,null);
         System.out.println("WARNING!!! Removing error!");
      }
      return answer.data;
   }

   /**
    *
    * append method
    *
    * This method is in charge of putting an object at the end of the list and
    * put it. It is pretty much like the insert method except this method only
    * allows you to put it at the end of the list.
    *
    * @pre-condition: Object next must be valid
    *
    * @post-condition: Another value added to the end of the list
    *
    * @return: No return statement
    *
    */
   public void append(T next) {
      Node cur = head;
      if(cur != null) {
         while(cur.next != null) {
            cur = cur.next;
         }
         cur.next = new Node(next,null);
      } else if(cur == null) {
         Node newNode = new Node(next,null);
         head = newNode;
      }
   }

   /**
    *
    * delete method
    *
    * This method is in charge of removing a value at a certain index. The
    * list will also adjust its size by reducing by 1 after removing an index.
    * This method is pretty much like the remove method except this method does
    * not return a value.
    *
    * @pre-condition: An appropriate index that is within the list range
    *
    * @post-condition: The index value will be null and will be removed while
    *                  shifting the list and connect the nodes
    *
    * @return: No return statement
    *
    */
   public void delete(int index) {
      try {
         int count = 1;
         Node prev = head;
         if(index==0) {
            prev = prev.next;
            head = prev;
         } else if(index > 0) {
            while(count < index) {
               count++;
               prev = prev.next;
            }
            Node cur = prev.next;
            prev.next = cur.next;
            cur.next = null;
         } else {
            throw new LinkedListException("WARNING!!! Deleting error!");
         }


      }
      catch(Exception e) {
         System.out.println(e.getMessage());
      }
   }

   /**
    *
    * size method
    *
    * This method will show the size of the list.
    *
    * @pre-condition: No pre-condition
    *
    * @post-condition: No post-condition
    *
    * @return: Returns the size in numbers
    *
    */
   public int size() {
      int count = 0;
      Node cur = head;
      while(cur != null) {
         count++;
         cur = cur.next;
      }
      return count;
   }

   /**
    *
    * toString method
    *
    * This method is in charge of storing a phrase inside a String variable and
    * return it when used.
    *
    * @pre-condition: No pre-condition
    *
    * @post-condition: No post-condition
    *
    * @return: toString() will be able to return a String variable
    *
    */
   public String toString() {
      String phrase = "";
      Node cur = head;
      while(cur != null) {
         phrase += cur.data + " ";
         cur = cur.next;
      }
      return phrase;
   }

   /**
    *
    * isEmpty method
    *
    * This method will check if the list is empty and will return true or
    * false. It does it by checking the heads only.
    *
    * @pre-condition: No pre-condition
    *
    * @post-condition: No post-condition
    *
    * @return: Returns true or false depending whether or not the head is null
    *          or not
    *
    */
   public boolean isEmpty() {
      boolean check = false;
      Node cur = head;
      if(head == null) {
         check = true;
      }
      return check;
   }

   /**
    *
    * indexOf method
    *
    * This method will check the list and see if the certain Object could be
    * found. If so, the method will return the index value. If not, it will
    * return -1 (meaning no certain index found).
    *
    * @pre-condition: Object target must be valid
    *
    * @post-condition: No post-condition
    *
    * @return: Returns the index of the targeted value
    *          Returns -1 if no index found
    *
    */
   public int indexOf(T target) {
      int index = -1;
      int count = 0;
      Node cur = head;
      while(cur != null && index < 0) {
         if(cur.data == target) {
            index = count;
         }
         count++;
         cur = cur.next;
      }
      return index;
   }

   /**
    *
    * get method
    *
    * This method will give you an element depending on what index you being
    * called.
    *
    * @pre-condition: index must be within the size
    *
    * @post-condition: No post-condition
    *
    * @return: Returns the location of what index points at
    *
    */
   public T get(int index) {
      T result = null;
      try {
         int count = 0;
         Node cur = head;
         if(index < 0) { throw new LinkedListException("WARNING!!! Index too far out!"); }
         if(index > this.size()-1) { throw new LinkedListException("WARNING!!! Index too far out!"); }
         while(cur != null && count != index) {
            count++;
            cur = cur.next;
         }
         result = cur.data;
      }
      catch(Exception e) {
         result = null;
         System.out.println(e.getMessage());
      }
      return result;
   }

   /**
    *
    * equals method
    *
    * This method will check this object's list with another object's list
    * and returns a boolean value whether or not the 2 list are equal or not.
    *
    * @pre-condition: Object other must be valid
    *
    * @post-condition: No post-condition
    *
    * @return: Returns a boolean value whether or not the 2 objects are equal
    *          to each other
    *
    */
   public boolean equals(Object other) {
      boolean check = true;
      ArrayList compare = (ArrayList)other;
      if(this.size() == compare.size()) {
         Node cur = head;
         Node curCompare = compare.head;
         while(cur != null) {
            if(cur.data != curCompare.data) {
               check = false;
            }
            cur = cur.next;
            curCompare = curCompare.next;
         }
      } else {
         check = false;
      }
      return check;
   }

   /**
    *
    * peek method
    *
    * This method will peek!
    *
    * @pre-condition: None
    *
    * @post-condition: None
    *
    * @return: Returns an Object that is recently stacked
    *
    */
   public T peek() {
      return head.data;
   }

   /**
    *
    * Description: Iterator is used for taking any kind of type (<T>) and
    *              make a new class called ListIterator.
    *
    * @author Kevin Nguyen
    *
    * @version 1
    *
    */
   public Iterator<T> iterator() {
      return new ListIterator();
   }

   /**
    *
    * Description: This class implements from Iterator<T>. By doing so, this
    *              class must have some of the required methods. This class
    *              currently holds hasNext() and next().
    *
    * @author Kevin Nguyen
    *
    * @version 1
    *
    */
   class ListIterator implements Iterator<T> {
      Node cur = null;

      /**
       *
       * hasNext() method
       *
       * This method checks if there is more node to come.
       *
       * @pre-condition: No pre-condition
       *
       * @post-condition: No post-condition
       *
       * @return: Returns true or false whether or not it has a next node
       *
       */
      public boolean hasNext() {
         if(cur == null && head != null) {
            return true;
         } else if(cur != null) {
            return cur.next != null;
         }
         return false;
      }

      /**
       *
       * next() method
       *
       * This method returns the next data.
       *
       * @pre-condition: No pre-condition
       *
       * @post-condition: No post-condition
       *
       * @return: Returns an object that is next in the node
       *
       */
      public T next() {
         if(cur == null && head != null) {
            cur = head;
            return head.data;
         } else if(cur != null) {
            cur = cur.next;
            T element = cur.data;

            return element;
         }
         return null;
         //throw new LinkedListException("WARNING!!! Error!");
      }

   }


   /**
    *
    * main method
    *
    * This main method will test out every method in the List class to make
    * sure they are working properly and test every class invariant and such.
    *
    * @pre-condition: No pre-condition
    *
    * @post-condition: No post-condition
    *
    * @return: No return statement
    *
    */
   public static void main(String[] args) {

      ArrayList empty = new ArrayList();
      ArrayList one = new ArrayList();
      ArrayList multiple = new ArrayList();
      ArrayList qq = new ArrayList();

      multiple.insert("K",0);
      multiple.insert("@",0);
      multiple.insert("E",2);
      multiple.insert("I",3);
      multiple.insert("V",3);
      multiple.insert("@",5);
      multiple.insert("N",5);
      multiple.insert("Q",10);

      System.out.println(multiple.remove(0));
      System.out.println(multiple.remove(5));
      System.out.println(multiple.remove(-7));

      multiple.append(" ");
      multiple.append("N");
      multiple.append("G");
      multiple.append("U");
      multiple.append("Y");
      multiple.append("E");
      multiple.append("N");

      multiple.delete(11);
      multiple.delete(10);
      multiple.delete(9);
      multiple.delete(8);
      multiple.delete(7);
      multiple.delete(-666);

      System.out.println(multiple.size());
      System.out.println(multiple.isEmpty());
      System.out.println(empty.isEmpty());
      System.out.println(empty.toString());
      System.out.println(one.toString());
      System.out.println(multiple.toString());
      System.out.println(multiple.indexOf("Q"));
      System.out.println(multiple.equals(qq));

      System.out.println(multiple.get(0));
      System.out.println(multiple.get(2));

   }
}