package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ManagerUser {

    List<User> userList = new ArrayList<>();


    public ManagerUser(List<User> userList) {
        this.userList = userList;
    }

    public int logginUser(List<User> userList,  int tokenUser){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int d = 0;
        String userName = "";
        String pass = "";
        userName = Validate.getString(br, "Enter user name? ");
        pass = Validate.getString(br,"Enter password? ");


        for (int i = 0; i <= userList.size() -1 ; i++){
            String na = userList.get(i).getName();
            String pa = userList.get(i).getPassword();
            if (na.equals(userName) && pa.equals(pass))
            {
                tokenUser = userList.get(i).getId();
                d++;

            }
            if(d==0)
            {
                System.out.println("Incorrect account or password");
            }else {
                System.out.println("Login successful.");
            }
        }
        return tokenUser;
    }

    public void show(){
        int d = 0;
        for (User user : userList) {
            System.out.println(user);
            d++;
        }
        if ( d != 0){
            System.out.println("oke");
        }
    }

    public  void addUser(){
        User user = new User();
        user.regesterUser(userList);
        userList.add(user);
        System.out.println("successful registration");
    }

    public void setPass(String email){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d = 0;
        System.out.println("Function set Passwpord.");
        for (int i = 0; i <= userList.size()-1; i++)
        {
            if ( userList.get(i).getEmail().equals(email));
            {
                userList.get(i).setPassword(Validate.getString(br, "Enter password? "));
                d++;
            }
    }
        if (d!=0)
            System.out.println("Set Password successful.");
        else {

        }
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }





}
