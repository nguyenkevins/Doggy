/**
*
* Stack.java
*
* Description: This class is a child class coming from the List.java class.
*              It uses the concept of linked list to be able to use methods
*              which is push, pop, size, indexOf, size,
*              equals, and isEmpty. 
*
* @author Kevin Nguyen
*
* @version 1
*
*/

package com.zerobit.doggy;

public class Stack <T> extends ArrayList {

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
    * push method
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
   public void push(Object next) {
      super.insert(next,0);
   }

   /**
    *
    * pop method
    *
    * This method is in charge of removing an object inside the list.
    * It should remove the 0th index only.
    *
    * @pre-condition: At least 1 index in the list
    *
    * @post-condition: The list will get popped
    *
    * @return: Returns an Object that was popped
    *
    */   
   public Object pop() {
      try {
         if (this.isEmpty() == true) {
            throw new LinkedListException("WARNING!!! Stack is empty! Can't pop!");
         }
         return super.remove(0);
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
      Stack emptyTest = new Stack();
      Stack stackTest = new Stack();
      Stack equalTest = new Stack();
      
      System.out.println("Is emptyTest empty? " + emptyTest.isEmpty());
      stackTest.push("N");
      stackTest.push("I");
      stackTest.push("V");
      stackTest.push("E");
      stackTest.push("K");
      stackTest.push("@");
      stackTest.push("@");
      System.out.println("Result of stackTest: " + stackTest.toString());
      System.out.println(stackTest.pop());
      System.out.println(stackTest.pop());
      System.out.println("Result of stackTest: " + stackTest.toString());
      System.out.println("Size of stackTest: " + stackTest.size());
      System.out.println("Is stackTest empty? " + stackTest.isEmpty());
      System.out.println("Index of V in stackTest? " + stackTest.indexOf("V"));
      equalTest.push("N");
      equalTest.push("I");
      equalTest.push("V");
      equalTest.push("E");
      equalTest.push("K");
      System.out.println("stackTest equal to equalTest? " + stackTest.equals(equalTest)); 
      equalTest.pop();
      System.out.println("stackTest equal to equalTest? " + stackTest.equals(equalTest));  
      System.out.println(stackTest.pop());
      System.out.println(stackTest.pop());
      System.out.println(stackTest.pop());
      System.out.println(stackTest.pop());
      System.out.println(stackTest.pop());  
      System.out.println(stackTest.pop());
      stackTest.push(null);
      stackTest.insert("A",0);
      stackTest.push("@");
      stackTest.push("KEVIN");
      System.out.println(stackTest.peek());
   }
}