/**
*
* Queue.java
*
* Description: This class is a child class coming from the List.java class.
*              It uses the concept of linked list to be able to use methods
*              which is enqueue, dequeue, size, indexOf, size,
*              equals, and isEmpty. 
*
* @author Kevin Nguyen
*
* @version 1
*
*/

package com.zerobit.doggy;

public class Queue extends ArrayList {

   /**
    *
    * insert method
    *
    * This method should not be working and should throw an exception.
    *
    * @pre-condition: No pre-condition
    *
    * @post-condition: No post-condition
    *
    * @return: No return statement
    *
    */
	public void insert(Object next, int index) {
		try {
			throw new LinkedListException("WARNING!!! Cannot use insert!");
		} catch (LinkedListException e) {
			System.out.println(e.getMessage());
		}
	}

   /**
    *
    * append method
    *
    * This method should not be working and should throw an exception.
    *
    * @pre-condition: No pre-condition
    *
    * @post-condition: No post-condition
    *
    * @return: No return statement
    *
    */   
	public void append(Object next) {
		try {
			throw new LinkedListException("WARNING!!! Cannot use append!");
		} catch (LinkedListException e) {
			System.out.println(e.getMessage());
		}
	}
   
   /**
    *
    * remove method
    *
    * This method should not be working and should throw an exception.
    *
    * @pre-condition: No pre-condition
    *
    * @post-condition: No post-condition
    *
    * @return: Returns null
    *
    */
	public Object remove(int index) {
		try {
			throw new LinkedListException("WARNING!!! Cannot use remove!");
		} catch (LinkedListException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
   
   /**
    *
    * delete method
    *
    * This method should not be working and should throw an exception.
    *
    * @pre-condition: No pre-condition
    *
    * @post-condition: No post-condition
    *
    * @return: No return statement
    *
    */
	public void delete(int index) {
		try {
			throw new LinkedListException("WARNING!!! Cannot use delete!");
		} catch (LinkedListException e) {
			System.out.println(e.getMessage());
		}
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
    * enqueue method
    *
    * This method is in charge of putting an object inside the list and put it
    * in at the 0th index.
    *
    * @pre-condition: Object next should be valid
    *
    * @post-condition: List gained an object
    *
    * @return: No return statement
    *
    */  
   public void enqueue(Object next) {
      super.insert(next,0);
   }   
   
   /**
    *
    * pop method
    *
    * This method is in charge of removing an object inside the list.
    * It should remove the last index only.
    *
    * @pre-condition: At least 1 index in the list
    *
    * @post-condition: No post-condition
    *
    * @return: Returns an Object that was removed from the list
    *
    */  
	public Object dequeue() {
		try {
			if (this.isEmpty() == true) {
				throw new LinkedListException("WARNING!!! Queue is empty! Can't dequeue!");
			}
			return super.remove(super.size() - 1);
		} catch (LinkedListException e) {
			System.out.println(e.getMessage());
			return null;
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
      Queue emptyTest = new Queue();
      Queue queueTest = new Queue();
      Queue equalTest = new Queue();
      
      System.out.println("Is emptyTest empty? " + emptyTest.isEmpty());
      queueTest.enqueue("@");
      queueTest.enqueue("@");     
      queueTest.enqueue("N");
      queueTest.enqueue("I");
      queueTest.enqueue("V");
      queueTest.enqueue("E");
      queueTest.enqueue("K");
      System.out.println("Result of queueTest: " + queueTest.toString());
      System.out.println(queueTest.dequeue());
      System.out.println(queueTest.dequeue());
      System.out.println("Result of queueTest: " + queueTest.toString());
      System.out.println("Size of queueTest: " + queueTest.size());
      System.out.println("Is queueTest empty? " + queueTest.isEmpty());
      System.out.println("Index of V in queueTest? " + queueTest.indexOf("V"));
      equalTest.enqueue("N");
      equalTest.enqueue("I");
      equalTest.enqueue("V");
      equalTest.enqueue("E");
      equalTest.enqueue("K");
      System.out.println("queueTest equal to equalTest? " + queueTest.equals(equalTest)); 
      equalTest.dequeue();
      System.out.println("queueTest equal to equalTest? " + queueTest.equals(equalTest));  
      System.out.println(queueTest.dequeue());
      System.out.println(queueTest.dequeue());
      System.out.println(queueTest.dequeue());
      System.out.println(queueTest.dequeue());
      System.out.println(queueTest.dequeue());  
      System.out.println(queueTest.dequeue());
      queueTest.enqueue(null);
      queueTest.insert("A",0);
   } 
}