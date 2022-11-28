package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String password;
    private String email;

    public User(){
    }

    public User(int id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public void regesterUser(List<User> userList){
        User user = new User();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        this.id = (userList.size() > 0) ? (userList.size() + 1) : 1;
        this.name = Validate.getString(br,"Enter user name?");
        this.password = Validate.getString(br,"Enter password?");
        this.email = Validate.getEmail(br,"Enter email?");

    }

    public void updateprofile(List<User> userList, int id){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d = 0;
        System.out.println("Update profile: ");
        for (int i = 0; i <= userList.size()-1; i++)
        {
            if (userList.get(i).getId() == id)
            {
                userList.get(i).setName(Validate.getString(br,"Enter user name? "));
                userList.get(i).setPassword(Validate.getString(br,"Enter password? "));
                userList.get(i).setEmail(Validate.getEmail(br,"Enter email? "));
                d++;
            }
            else {
                System.out.println("id not found");
            }

            if (d!=0)
                System.out.println("Update successful.");
        }

    }

    public boolean logOut(int x){
        boolean checkuser = true;
        if (x!=0)
            return  checkuser = false;
        return checkuser ;
    }

    @Override
    public String toString(){
        return "Wellcome: " + getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
