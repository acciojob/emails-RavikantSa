package com.driver;

public class Email {

    private String emailId;
    private String password;

    boolean upperC = false;
    boolean lowerC = false;
    boolean specialC = false;
    boolean numericC = false;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        if(getPassword().equals(oldPassword)) {

            // 1. It contains at least 8 characters
            if (newPassword.length() > 7)
            {
                int upper = 0, lower = 0, number = 0, special = 0;
                for (int i = 0; i < newPassword.length(); i++) {
                    char ch = newPassword.charAt(i);
                    if (ch >= 'A' && ch <= 'Z')
                        upper++;
                    else if (ch >= 'a' && ch <= 'z')
                        lower++;
                    else if (ch >= '0' && ch <= '9')
                        number++;
                    else
                        special++;
                }
                // 2. It contains at least one uppercase letter
                if (upper > 0){
                    upperC = true;
                }
                // 3. It contains at least one lowercase letter
                if (lower > 0){
                    lowerC = true;
                }
                // 4. It contains at least one digit
                if (number > 0) {
                    numericC = true;
                }
                // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
                if (special > 0){
                    specialC = true;
                }
                if(upperC && lowerC && numericC && specialC){
//                    System.out.println("Password changed successfully");
                }
                else {
//                    System.out.println("Try new Password");
                }

            }
            else{
//                System.out.println("Try using new  password");
            }

        }
        else{
//            System.out.println("Password Incorrect");
        }

    }
}
