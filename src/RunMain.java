import model.ManagerUser;
import model.User;
import model.Validate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RunMain {
    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ManagerUser mn = new ManagerUser(userList);

        int tokenUser = 0;
        boolean checkUser = false;
        int choice1;
        int choice2;
        int choice3;
        int d = 0;
        String em = "";
        String next = "";

        User user = new User();
        do {
            System.out.println("inviting you to choose\n (0). Register User? \n (1). Login User?\n");
            choice1 = Validate.getInt(br, "choice:");

            if (choice1 == 0) {
                mn.addUser();
            }else
            {
                tokenUser =    mn.logginUser(userList,tokenUser);
                if (tokenUser==0)
                    d++;
            }
            if(d!=0){
                System.out.println("inviting you to choose\n (0). Set Password? \n (1). Exit?\n");
                choice3 = Validate.getInt(br, "choice: ");
                switch (choice3){
                    case 0:
                        em = Validate.getEmail(br, "Enter email? ");
                        mn.setPass(em);
                        break;
                    case 1:
                        break;
                }
            }
            do {
                next = Validate.getString(br,"Enter a next  Choice(Y/N)?:");
                next = next.toLowerCase();
             } 
            while (!((next.equals("y")) || (next.equals("n"))));
        } while (next.equals("y"));

      if (tokenUser != 0)
      {
          do {
              checkUser = true;
              if(d == 0)
                  user.toString();
              System.out.println("inviting you to choose\n (0). Update profile?  \n (1). Logout\n");
              choice2 = Validate.getInt(br, "choice:");

              if (choice2 == 0)
                  user.updateprofile(userList, tokenUser);
              else
               checkUser =  user.logOut(tokenUser);

              d++;
          }while (checkUser!=false);
      }

       if (checkUser == false)
           System.out.println("the program has exited");

    }
}
