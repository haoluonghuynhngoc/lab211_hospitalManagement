/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haolhn.management;

import haolhn.information.DepartmentList;
import haolhn.information.DoctorList;
import haolhn.information.ListHospital;
import haolhn.information.Menu;
import java.io.IOException;

/**
 *
 * @author ngoc hao
 */
public class HospitalManagement {

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        ListHospital list = new ListHospital();
        boolean confirm = false;
        list.readDepartmentIO();
        list.readDoctorIO();

        menu.add("\n=======================MENU==============================\n");
        menu.add("1.Show information");
        menu.add("2.Add information");
        menu.add("3.Update information");
        menu.add("4.Delete information");
        menu.add("5.Search information");
        menu.add("6.Store data to file ");
        menu.add("7.QUIT ");
        menu.add("\n=====================END MENU============================\n");
        do {
            menu.showMenu();
            int choice = menu.getChoice("Input your choice 1-6 :");
            switch (choice) {
                case 1:
                    list.showDepartmentList();
                    list.showDoctor();
                    break;
                case 2:
                    Menu menuCase2 = new Menu();
                    boolean confirmCase2 = false;
                    int number2 = 0;
                    menuCase2.add("\n==============ADD LIST==================\n");
                    menuCase2.add("1.Add new Doctor :");
                    menuCase2.add("2.Add new Department :");
                    menuCase2.add("3.Quit :");
                    menuCase2.add("\n==============END ADD==================\n");
                    do {
                        menuCase2.showMenu();
                        number2 = menuCase2.getChoice("Input your choice 1 <--> 3\n");
                        switch (number2) {
                            case 1:
                                list.addDoctor();
                                break;
                            case 2:
                                list.addDepartment();
                                break;
                            case 3:
                                confirmCase2 = menuCase2.confirmYesNo("\nDo you want to Quit(Y/N) :");
                                break;
                        }
                    } while (confirmCase2 == false);
                    break;
                case 3:
                    Menu menuCase3 = new Menu();
                    boolean confirmCase3 = false;
                    int number3 = 0;
                    menuCase3.add("\n==============UPDATE LIST==================\n");
                    menuCase3.add("1.Update Doctor :");
                    menuCase3.add("2.Update Department :");
                    menuCase3.add("3.Quit :");
                    menuCase3.add("\n==============END UPDATE==================\n");
                    do {
                        menuCase3.showMenu();
                        number3 = menuCase3.getChoice("Input your choice 1 <--> 3\n");
                        switch (number3) {
                            case 1:
                                list.updateDoctor();
                                break;
                            case 2:
                                list.updateDepartment();
                                break;
                            case 3:
                                confirmCase3 = menuCase3.confirmYesNo("\nDo you want to Quit(Y/N) :");
                                break;
                        }
                    } while (confirmCase3 == false);
                    break;
                case 4:
                    Menu menuCase4 = new Menu();
                    boolean confirmCase4 = false;
                    int number4 = 0;
                    menuCase4.add("\n==============DELETE LIST==================\n");
                    menuCase4.add("1.Delete Doctor :");
                    menuCase4.add("2.Delete Department :");
                    menuCase4.add("3.Quit :");
                    menuCase4.add("\n==============END DELETE==================\n");
                    do {
                        menuCase4.showMenu();
                        number4 = menuCase4.getChoice("Input your choice 1 <--> 3\n");
                        switch (number4) {
                            case 1:
                                list.deleteDoctor();
                                break;
                            case 2:
                                list.deleteDepartment();
                                break;
                            case 3:
                                confirmCase4 = menuCase4.confirmYesNo("\nDo you want to Quit(Y/N) :");
                                break;
                        }
                    } while (confirmCase4 == false);
                    break;
                case 5:
                    Menu menuCase5 = new Menu();
                    boolean confirmCase5 = false;
                    int number5 = 0;
                    menuCase5.add("\n==============SEARCH LIST==================\n");
                    menuCase5.add("1.Search Doctor by Name :");
                    menuCase5.add("2.Search Department by ID :");
                    menuCase5.add("3.Quit :");
                    menuCase5.add("\n==============END SEARCH==================\n");
                    do {
                        menuCase5.showMenu();
                        number5 = menuCase5.getChoice("Input your choice 1 <--> 3\n");
                        switch (number5) {
                            case 1:
                                list.searchNameDoctor();
                                break;
                            case 2:
                                list.searchIDDepartment();
                                break;
                            case 3:
                                confirmCase5 = menuCase5.confirmYesNo("\nDo you want to Quit(Y/N) :");
                                break;
                        }
                    } while (confirmCase5 == false);
                    break;
                case 6:
                    boolean WriteDepartment = list.writeDepartmentIO();
                    boolean WriteDoctor = list.writeDoctorIO();
                    if (WriteDepartment == true && WriteDoctor == true) {
                        System.out.println("Cant not store Department or Doctor to file ");
                    } else {
                        System.out.println("Store Department and Doctor to file successfully");
                    }

                    break;
                case 7:
                    confirm = menu.confirmYesNo("Do you want to Quit (Y/N) :");
                    break;
            }
        } while (confirm == false);
    }

}
