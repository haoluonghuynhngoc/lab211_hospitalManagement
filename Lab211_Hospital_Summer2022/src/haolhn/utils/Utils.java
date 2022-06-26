/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haolhn.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author ngoc hao
 */
public class Utils {

    public static String currentDate() {
        String result = "";
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        result = dateFormat.format(date);
        return result;
    }

    public static boolean updateGender(String wellcome, boolean oldData) {
        boolean result = false;
        boolean check = true;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(wellcome);
            String tmp = sc.nextLine();
            if ("y".equalsIgnoreCase(tmp)) {
                result = true;
                check = false;
            } else if ("n".equalsIgnoreCase(tmp)) {
                result = false;
                check = false;
            } else if ("".equalsIgnoreCase(tmp)) {
                result = oldData;
                check = false;
            } else {
                System.out.println("Must input Y/N");
            }
        } while (check);
        return result;
    }

    public static boolean getGender(String wellcome) {
        boolean result = false;
        boolean check = true;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(wellcome);
            String confirm = sc.nextLine();
            if ("y".equalsIgnoreCase(confirm)) {
                result = true;
                check = false;
            } else if ("n".equalsIgnoreCase(confirm)) {
                result = false;
                check = false;
            } else {
                System.out.println("Must input Y/N");

            }
        } while (check);
        return result;
    }



    public static String update(String wellcome, String oldData) {
        String result = "";
        Scanner sc = new Scanner(System.in);
        System.out.println(wellcome);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        } else {
            result = oldData;
        }
        return result;
    }



    public static String getString(String wellcome) {
        boolean check = true;
        String result = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(wellcome);
            result = sc.nextLine();
            if (!result.isEmpty()) {
                check = false;
            } else {
                System.out.println("Must input text !");
            }
        } while (check);
        return result;
    }

    public static String updateString(String wellcome, String oldData) {
        String result = "";
        Scanner sc = new Scanner(System.in);
        System.out.println(wellcome);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        } else {
            result = oldData;
        }
        return result;
    }


    public static int getInt(String wellcome, int min, int max) {
        boolean check = true;
        int number = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println(wellcome);
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println(" Must input number !");
            }
        } while (check || number > max || number < min);

        return number;
    }

    public static int updateInt(String wellcome, int min, int max, int oldData) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println(wellcome);
                String tmp = sc.nextLine();
                if (!tmp.isEmpty()) {
                    number = Integer.parseInt(tmp);
                    check = false;
                } else {
                    number = oldData;
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Must input number !");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static boolean confirmYesNo(String wellcome) {
        boolean result = false;
        String confirm = Utils.getString(wellcome);
        if ("Y".equalsIgnoreCase(confirm)) {
            result = true;
        }
        return result;
    }



}
