package com.driver;

import java.util.*;




public class Gmail extends Email
{

    public class Body{
        Date date;
        String sender;
        String message;
        public Body(Date date, String sender, String message){
            this.date = date;
            this.sender = sender;
            this.message = message;
        }
    }

    int inboxCapacity; //maximum number of mails inbox can store
//    public Date date;
//    public  String sender;
//    public  String message;
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String).
    // It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)

    ArrayList<Body> Inbox = new ArrayList<>();
    ArrayList<Body> Trash = new ArrayList<>();
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);

        this.inboxCapacity = inboxCapacity;
    }
//    Queue<String> Inbox = new LinkedList<>();
//    Queue<String> Trash = new LinkedList<>();

    class Mail{
         Date date;
        String sender;
         String message;


        Mail(Date date, String sender, String message) {
            this.date = date;
            this.sender = sender;
            this.message = message;
        }
    }


    int  inBoxSize =0;

    public void receiveMail(Date date, String sender, String message){

        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        Body newMail = new Body(date, sender, message);

        if(Inbox.size() < inboxCapacity){
            Inbox.add(newMail);
        }
        else{
            Body oldMail = Inbox.get(0);
            Trash.add(oldMail);
            Inbox.remove(0);
            Inbox.add(newMail);
        }
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

        int index = -1;
        for(int i = 0; i < Inbox.size(); i++){
            Body temp = Inbox.get(i);
            if(temp.message.equals(message)){
                index = i;
                break;
            }
        }
        if(index != -1){
            Body moveToTrash = Inbox.get(index);
            Trash.add(moveToTrash);
            Inbox.remove(index);
        }
    }

    public String findLatestMessage(){
        if(Inbox.size() == 0){
            return null;
        }

        Body temp = Inbox.get(Inbox.size() - 1);
        String latestMessage = temp.message;

        return latestMessage;
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(Inbox.size() == 0){
            return null;
        }

        Body temp = Inbox.get(0);
        String oldestMessage = temp.message;

        return oldestMessage;

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count = 0;
        for(int i = 0; i < Inbox.size(); i++){
            Body temp = Inbox.get(i);
            Date actual = temp.date;
            if(actual.equals(start) || actual.equals(end)){
                count++;
            }
            else if(actual.after(start) && actual.before(end)){
                count++;
            }
        }
        return count;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
//
        return inBoxSize ;
    }

    public int getTrashSize(){

        return Trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        Trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
            return this.inboxCapacity;
    }

}
