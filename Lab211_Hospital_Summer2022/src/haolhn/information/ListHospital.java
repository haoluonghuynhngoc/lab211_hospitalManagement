/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haolhn.information;

import haolhn.utils.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author ngoc hao
 */
public class ListHospital implements I_List{

    DepartmentList dptList = new DepartmentList();
    DoctorList docList = new DoctorList();

    @Override
    public void showDoctor() {
        docList.showInfor();
    }

    @Override
    public void showDepartmentList() {
        dptList.showInfor();
    }

    @Override
    public void addDoctor() {
        boolean confirm = false;
        docList.showInfor();
        do {
            String idDoctor = Utils.getString("Input the ID Dortor :").toUpperCase();
            int index = docList.findID(idDoctor);
            boolean checkDulicate = false;
            if (index == -1) {
                String name = Utils.getString("Input Doctor name :");
                boolean sex = Utils.getGender("Input your gender (Y.Male/N.Female)");
                String address = Utils.getString("Input address :");
                String departmentID = null;
                do {
                    departmentID = Utils.getString("Input Department ID :").toUpperCase();
                    int indexCheck = dptList.findID(departmentID);
                    if (indexCheck > -1) {
                        checkDulicate = true;
                    } else {
                        System.out.println("\n\t cant not find the ID is " + departmentID + " in the Department !!!");
                    }
                } while (checkDulicate == false);
                String date = Utils.currentDate();
                docList.add(new Doctor(idDoctor, name, sex, address, departmentID, date));
                System.out.println("\tADD Dortor Successfully");
            } else {
                System.out.println("\tThe ID Doctor is dulicete !!! ");
            }
            confirm = Utils.confirmYesNo("\nDo you want to continue(Y/N) :");
        } while (confirm == true);
    }

    @Override
    public void addDepartment() {
        boolean confirm = false;
        dptList.showInfor();
        do {
            String departmentID = Utils.getString("Input the ID Department :").toUpperCase();
            int index = dptList.findID(departmentID);
            if (index == -1) {
                String name = Utils.getString("Input Department name :");
                String currentDate = Utils.currentDate();
                dptList.add(new Department(departmentID, name, currentDate));
                System.out.println("\tADD Department Successfully");
            } else {
                System.out.println("The ID Doctor is dulicete !!! ");
            }
            confirm = Utils.confirmYesNo("\nDo you want to continue(Y/N) :");
        } while (confirm == true);
    }

    @Override
    public void updateDoctor() {
        boolean confirm = false;
        do {
            docList.showInfor();
            String idDoctor = Utils.getString("Input the Id Doctor to update : ").toUpperCase();
            int index = docList.findID(idDoctor);
            boolean checkID = false;
            if (index > -1) {
                String newName = Utils.updateString("Update the name Doctor :", docList.get(index).getName());
                docList.get(index).setName(newName);
                boolean newSex = Utils.updateGender("Update gender (Y.Male/N.Female) :", docList.get(index).isSex());
                docList.get(index).isSex();
                String newAddress = Utils.updateString("Update Address :", docList.get(index).getAddress());
                docList.get(index).setAddress(newAddress);
                do { // check update exit ID department
                    String newDepartment = Utils.updateString("Update Department ID :", docList.get(index).getDepartmentID()).toUpperCase();
                    int checkDulicateDPM = dptList.findID(newDepartment);
                    if (checkDulicateDPM > -1) {
                        docList.get(index).setDepartmentID(newDepartment);
                        checkID = true;
                    } else {
                        System.out.println("\n cant not find the ID is " + newDepartment + " in the Department ");
                    }
                } while (checkID == false);
                String Updatedate = Utils.currentDate();
                docList.get(index).setLastUpdateDate(Updatedate);
                docList.showInfor(idDoctor);
            } else {
                System.out.println("Doctor does not exist !");
            }
            confirm = Utils.confirmYesNo("\nDo you want to continue (Y/N) :");
        } while (confirm == true);
    }

    @Override
    public void updateDepartment() {
        boolean confirm = false;
        do {
            dptList.showInfor();
            String idDepartment = Utils.getString("Input the Id Department to update : ").toUpperCase();
            int index = dptList.findID(idDepartment);
            if (index > -1) {
                String newName = Utils.updateString("Update the name Department :", dptList.get(index).getName());
                dptList.get(index).setName(newName);
                String Updatedate = Utils.currentDate();
                dptList.get(index).setLastUpdateDate(Updatedate);
                dptList.showInfor(idDepartment);
            } else {
                System.out.println("Doctor does not exist !");
            }
            confirm = Utils.confirmYesNo("\nDo you want to continue (Y/N) :");
        } while (confirm == true);
    }

    @Override
    public void deleteDoctor() {
        boolean confirm = false;
        do {
            docList.showInfor();
            String doctorID = Utils.getString("Input the ID Doctor to Delete : ").toUpperCase();
            int index = docList.findID(doctorID);
            if (index > -1) {
                boolean confirmDelete = Utils.confirmYesNo("Do you want to delete (Y/N) :");
                if (confirmDelete == true) {
                    docList.remove(docList.get(index));
                    System.out.println("Delete successfully");
                } else {
                    System.out.println("Cancel Delete successfully");
                }
            } else {
                System.out.println("Cant not find  ID Doctor = " + doctorID + " in the list !");
            }
            confirm = Utils.confirmYesNo("Do you want to continue(Y/N) :");
        } while (confirm == true);
    }

    @Override
    public void deleteDepartment() {
        boolean confirm = false;
        do {
            dptList.showInfor();
            String departmentId = Utils.getString("Input the ID Department to Delete : ").toUpperCase();
            int index = dptList.findID(departmentId);
            if (index > -1) {
                boolean confirmDelete = Utils.confirmYesNo("Do you want to delete (Y/N) :");
                if (confirmDelete == true) {
                    dptList.remove(dptList.get(index));
                    System.out.println("Delete successfully ");
                } else {
                    System.out.println("Cancel Delete successfully");
                }
            } else {
                System.out.println("Cant not find  ID Department = " + departmentId + " in the list !");
            }
            confirm = Utils.confirmYesNo("\nDo you want to continue(Y/N) :");
        } while (confirm == true);
    }

    @Override
    public void searchNameDoctor() {
        String name = Utils.getString("Input the name Doctor you want to Search :");      
        if (docList.isEmpty()) {
            System.out.println("List is Empty !");
        } else {
            System.out.println("+--------------------+--------------------------+------------+---------------------------+--------------------+----------------+----------------+");
            System.out.println("+     ID DOCTOR      +            NAME          +     SEX    +           ADDRESS         +     DEPARTMENT ID  +    CREATEDATE  +    UPDATEDATE  +");
            System.out.println("+--------------------+--------------------------+------------+---------------------------+--------------------+----------------+----------------+");
            for (int i = 0; i < docList.size(); i++) {
                if (docList.get(i).getName().contains(name)) {
                    docList.get(i).showDoctor();
                }
            }
            System.out.println("+--------------------+--------------------------+------------+---------------------------+--------------------+----------------+----------------+");
        }
    }

    @Override
    public void searchIDDepartment() {
        String id = Utils.getString("Input the ID you want to search :").toUpperCase();
        int index = dptList.findID(id);
        if (index == -1) {
            System.out.println("List is Empty ");
        } else {
//            System.out.println("+------------------------+------------------------+----------------+----------------+");
//            System.out.println("+     ID DEPARTMENT      +           NAME         +   CREATE DATE  +   LAST DATE    +");
//            System.out.println("+------------------------+------------------------+----------------+----------------+");
//            dptList.get(index).showDepartment();
//            System.out.println("+------------------------+------------------------+----------------+----------------+");
            
            dptList.showInfor(dptList.get(index).getDepartmentID());
        }
    }

//write department to file Department.dat
    @Override
    public boolean writeDepartmentIO() throws IOException {
        File file = new File("Department.dat");
        FileWriter fw = null;
        boolean check = false;
        if (!file.exists()) {
            file.createNewFile();
        }
        fw = new FileWriter(file);
        if (dptList.size() == 0) {
            check = true;
        } else {
            for (int i = 0; i < dptList.size(); i++) {
                fw.write(dptList.get(i).toString() + "\n");
            }
        }
        fw.close();
        return check;
    }

// write doctor to file Doctor.dat
    @Override
    public boolean writeDoctorIO() throws IOException {
        File file = new File("Doctor.dat");
        boolean check = false;
        FileWriter fw = null;
        if (!file.exists()) {
            file.createNewFile();
        }
        fw = new FileWriter(file);
        if (docList.size() == 0) {
            check = true;
        } else {
            for (int i = 0; i < docList.size(); i++) {
                fw.write(docList.get(i).toString() + "\n");
            }
        }
        fw.close();
        return check;
    }

//read department form file Department.dat
    @Override
    public void readDepartmentIO() throws IOException {
        File file = new File("Department.dat");
        BufferedReader br = null;
        String line = "";
        Department department = null;
        if (!file.exists()) {
            file.createNewFile();
        }
        br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null) {
            department = new Department();
            StringTokenizer stk = new StringTokenizer(line, ",", false);
            while (stk.hasMoreElements()) {
                department.setDepartmentID(stk.nextToken());
                department.setName(stk.nextToken());
                department.setCreateDate(stk.nextToken());
                department.setLastUpdateDate(stk.nextToken());
            }
            dptList.add(department);
        }
    }

// read doctor from file Doctor.dat
    @Override
    public void readDoctorIO() throws IOException {
        File file = new File("Doctor.dat");
        String line = "";
        boolean check = false;
        BufferedReader br = null;
        Doctor doctor = null;
        if (!file.exists()) {
            file.createNewFile();
        }
        br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null) {
            doctor = new Doctor();
            StringTokenizer stk = new StringTokenizer(line, ",", false);
            while (stk.hasMoreElements()) {
                doctor.setDoctorID(stk.nextToken());
                doctor.setName(stk.nextToken());
                doctor.checkGender(stk.nextToken());
                doctor.setAddress(stk.nextToken());
                doctor.setDepartmentID(stk.nextToken());
                doctor.setCreateDate(stk.nextToken());
                doctor.setLastUpdateDate(stk.nextToken());
            }
            docList.add(doctor);
        }
        br.close();

    }
}
