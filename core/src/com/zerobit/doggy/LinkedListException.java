/**
*
* LinkedListException.java
*
* Description: This is a file that extends from the class Exception. This
*              allows you to create a custom exceptions. In this class, there 
*              is 2 different ways of getting the message. 1 way is to call the
*              constructor with no arguement which gives you a fixed message.
*              Another way is to call the contructor that has the String as
*              an arguement and will use the String as the message for the
*              exception.
*              
* @author Kevin Nguyen
*
* @version 1
*
*/

package com.zerobit.doggy;

public class LinkedListException extends Exception {

   /**
    *
    * LinkedListException constructor
    *
    * This constructor has no arguement in the parameter, so it wil print out
    * a fixed exception message.
    *
    * @pre-condition: No pre-condition
    *
    * @post-condition: No post-condition
    *
    * @return: No return statement
    *
    */  
   public LinkedListException() {
      super();
      System.out.println("LinkedListException error!");
   }
   
   /**
    *
    * LinkedListException constructor
    *
    * This constructor has an arguement in the parameter, so it wil print out
    * a the arguement String value as the exception message.
    *
    * @pre-condition: No pre-condition
    *
    * @post-condition: No post-condition
    *
    * @return: No return statement
    *
    */ 
   public LinkedListException(String message) {
      super(message);
   }
}