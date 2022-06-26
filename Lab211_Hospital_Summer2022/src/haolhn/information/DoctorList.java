/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haolhn.information;


import java.util.ArrayList;


/**
 *
 * @author ngoc hao
 */
public class DoctorList extends ArrayList<Doctor> {

// find id in doctor
    public int findID(String id) {
        int index = -1;
        index = this.indexOf(new Doctor(id));
        return index;
    }

//show 1 value 
    public boolean showInfor(String id) {
        boolean check = false;
        if (this.isEmpty()) {
            check = true;
        } else {
            System.out.println("+--------------------+--------------------------+------------+---------------------------+--------------------+----------------+----------------+");
            System.out.println("+     ID DOCTOR      +            NAME          +     SEX    +           ADDRESS         +     DEPARTMENT ID  +    CREATEDATE  +    UPDATEDATE  + ");
            System.out.println("+--------------------+--------------------------+------------+---------------------------+--------------------+----------------+----------------+");
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).getDoctorID().equals(id)) {
                    this.get(i).showDoctor();
                }
            }
            System.out.println("+--------------------+--------------------------+------------+---------------------------+--------------------+----------------+----------------+");

        }
        return check;
    }

// showDoctor all value 
    public boolean showInfor() {
        boolean check = false;
        if (this.size() == 0) {
            check = true;
        } else {
            System.out.println("+--------------------+--------------------------+------------+---------------------------+--------------------+----------------+----------------+");
            System.out.println("+     ID DOCTOR      +            NAME          +     SEX    +           ADDRESS         +     DEPARTMENT ID  +    CREATEDATE  +    UPDATEDATE  + ");
            System.out.println("+--------------------+--------------------------+------------+---------------------------+--------------------+----------------+----------------+");
            for (int i = 0; i < this.size(); i++) {
                this.get(i).showDoctor();
            }
            System.out.println("+--------------------+--------------------------+------------+---------------------------+--------------------+----------------+----------------+");

        }
        return check;
    }

}
