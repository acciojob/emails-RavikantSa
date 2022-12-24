package com.driver;

import java.util.*;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    public Date date;
    public  String sender;
    public  String message;
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String).
    // It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);

        this.inboxCapacity = inboxCapacity;
    }
    Queue<String> inbox = new LinkedList<>();
    Queue<String> trash = new LinkedList<>();

    int  inBoxSize =0;



    public void receiveMail(Date date, String sender, String message){
       this.date = date;
       this.sender = sender;
       this.message = message;

        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        if( inBoxSize < inboxCapacity || getInboxSize() < getInboxCapacity()){
            inBoxSize++;
            inbox.add(message);
        }
        else{
          String mess =  inbox.peek();
            trash.add(mess);
            inbox.remove();
            inbox.add(message);
        }
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

        //------------------------------------------------

//        Queue<String> ref = new LinkedList<>();
//        int s = inbox.size();
//        int cnt = 0;
//
//        // Finding the value to be removed
//        while (!inbox.isEmpty() && !Objects.equals(inbox.peek(), message)) {
//            ref.add(inbox.peek());
//            inbox.remove();
//            cnt++;
//        }
//
//        // If element is not found
//        if (inbox.isEmpty()) {
//            while (!ref.isEmpty()) {
//                // Pushing all the elements back into q
//                inbox.add(ref.peek());
//                ref.remove();
//            }
//        }
//
//        // If element is found
//        else {
//           trash.add( inbox.remove());
//            while (!ref.isEmpty()) {
//                // Pushing all the elements back into q
//                inbox.add(ref.peek());
//                ref.remove();
//            }
//            int k = s - cnt - 1;
//            while (k-- >0) {
//                // Pushing elements from front of q to its back
//                String p = inbox.peek();
//                inbox.remove();
//                inbox.add(p);
//            }
//        }

//-----------------------------------------------
        trash.add(message);
        inbox.remove(message);
        inBoxSize--;
    }

    public String findLatestMessage(){
      String ans = "";
      if( !inbox.isEmpty()) {
          Stack<String> ref = new Stack<>();
          while (!inbox.isEmpty()) {
              ref.add(inbox.remove());
          }
          ans += ref.peek();
          while (!ref.isEmpty()) {
              inbox.add(ref.pop());
          }
          return ans;
      }
      else{
          return null;
      }

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if( inBoxSize>0){
            return inbox.peek();
        }
        else{
            return "null";
        }

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        return 2;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
//
        return inBoxSize ;
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        while (!trash.isEmpty()){
            trash.remove();
        }

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
            return inboxCapacity;
    }

}
