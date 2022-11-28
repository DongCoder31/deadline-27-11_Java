package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    public static String getString(BufferedReader br, String promt)  {
        String st = "";
        boolean checkString = false;
        do {
            try {
                System.out.print(promt);
                st = br.readLine().trim();
                checkString = true;
            } catch (IOException f) {
                System.out.println(f.getMessage());
            }
        } while (!checkString);;
        return st;
    }
    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public static String getEmail(BufferedReader br, String promt)  {
        String st = "";
        boolean checkEmail = false;
        String EMAIL_PATTERN =
                "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        do{
            try {
                System.out.print(promt);
                st = br.readLine().trim();
                if(patternMatches(st,EMAIL_PATTERN)){
                    checkEmail = true;
                }else {
                    System.out.println("Invalid email.");
                }
            } catch (IOException f) {
                System.out.println(f.getMessage());
            }

        }while (!checkEmail);
        return st;
    }

    public static String getPhone(Scanner scanner, String promt){
        String st ="";
        boolean checkPhone = false;
        do {
            System.out.printf(promt);
            st = scanner.next().trim();
            if (st.length() == 10) {
                try {
                    for (int i = 0; i < st.length(); i++) {
                        Integer.parseInt(st.charAt(i) + "");
                    }
                    checkPhone = true;
                } catch (InputMismatchException e) {
                    System.out.println("Errorr. Invalib number. Try again.");
                    scanner.nextLine();
                }

            }else {
                System.out.println("Err. Phone number must be 10 digits.Try again.");
            }
            }
            while (!checkPhone);
        return st;
    }

        public static int getInt(BufferedReader br, String promt){
        int value = 0;
        boolean checkValue = false;
        do{
            try {
                System.out.print(promt);
                value = Integer.parseInt(br.readLine().trim());
                checkValue = true;
            }catch (IOException e) {
                System.out.println(e.getMessage());

            }catch (RuntimeException e){
                System.out.println("Invalib number . Try again.");
            }
        }while (!checkValue);
        return value;
    }

    public static float getFloat(Scanner scanner, String promt){
        float value = 0.0f;
        boolean checkValue = false;
        do{
            try {
                System.out.print(promt);
                value = scanner.nextFloat();
                checkValue = true;
            }catch (InputMismatchException e){
                System.out.println("Errorr. Invalib number. Try again.");
                scanner.nextLine();
            }
        }while (!checkValue);
        return value;
    }

    public static double getDouble(Scanner scanner, String promt){
        double value = 0.0;
        boolean checkValue = false;
        do{
            try {
                System.out.print(promt);
                value = scanner.nextDouble();
                checkValue = true;
            }catch (InputMismatchException e){
                System.out.println("Errorr. Invalib number. Try again.");
                scanner.nextLine();
            }
        }while (!checkValue);
        return value;
    }

    public static boolean isValidDay(String dateStr) {
         String dateFormat = "dd/MM/yyyy";
        DateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static String getDay(Scanner scanner, String promt){
        String st = null;
        String st1;
        boolean checkDay = false;
        Date date = new Date();
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        st1 = sdf.format(date);

        do {
            System.out.println(promt);
            st = scanner.next();
            Date dt1 = new Date(st);
            Date dt2 = new Date(st1);
            boolean x = dt1.before(dt2);
            try {
                sdf.parse(st);
                if (isValidDay(st)){
                    if(x){
                        checkDay = true;
                    }else {
                        System.out.println("Days beyond the future.");
                    }
                }else{
                    System.out.println("Invalid Day.");
                }
            } catch (ParseException e) {
                System.out.println("Invalib day");
            }
        }while (!checkDay);
        return st;
    }
}
