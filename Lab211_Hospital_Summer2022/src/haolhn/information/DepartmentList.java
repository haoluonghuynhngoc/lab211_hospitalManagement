/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haolhn.information;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ngoc hao
 */
public class DepartmentList extends ArrayList<Department> {

// find id in department
    public int findID(String id) {
        int index = -1;
        index = this.indexOf(new Department(id));
        return index;
    }
// show 1 value 

 public boolean showInfor(String id) {
        boolean check = false;
        if (this.size() == 0) {
            check = true;
        } else {
            System.out.println("+------------------------+------------------------+----------------+----------------+");
            System.out.println("+     ID DEPARTMENT      +           NAME         +   CREATE DATE  +   LAST DATE    +");
            System.out.println("+------------------------+------------------------+----------------+----------------+");
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).getDepartmentID().equals(id)) {
                    this.get(i).showDepartment();
                }
            }
            System.out.println("+------------------------+------------------------+----------------+----------------+");
        }
        return check;
    }

//show all value 
    public void showInfor() {
        if (this.size() == 0) {
            System.out.println("List is empty !");
        } else {
            System.out.println("+------------------------+------------------------+----------------+----------------+");
            System.out.println("+     ID DEPARTMENT      +           NAME         +   CREATE DATE  +   LAST DATE    +");
            System.out.println("+------------------------+------------------------+----------------+----------------+");
            for (int i = 0; i < this.size(); i++) {
                this.get(i).showDepartment();
            }
            System.out.println("+------------------------+------------------------+----------------+----------------+");
        }

    }





}
