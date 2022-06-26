/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haolhn.information;

/**
 *
 * @author ngoc hao
 */
public class Doctor {

    private String doctorID;
    private String name;
    private boolean sex;
    private String address;
    private String departmentID;
    private String createDate;
    private String lastUpdateDate;

    public Doctor() {
    }

    public Doctor(String doctorID) {
        this.doctorID = doctorID;
    }

    public Doctor(String doctorID, String name, boolean sex, String address, String departmentID, String createDate) {
        this.doctorID = doctorID;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.departmentID = departmentID;
        this.createDate = createDate;
    }

    public Doctor(String doctorID, String name, boolean sex, String address, String departmentID, String createDate, String lastUpdateDate) {
        this.doctorID = doctorID;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.departmentID = departmentID;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object obj) {
        return this.doctorID.equalsIgnoreCase(((Doctor) obj).getDoctorID());
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void checkGender(String changeGender) {
        if ("MALE".equals(changeGender)) {
            sex = true;
        } else if ("FEMALE".equals(changeGender)) {
            sex = false;
        }
    }

    public String checkGender() {
        String result = "";
        if (sex == true) {
            result = "MALE";
        } else {
            result = "FEMALE";
        }
        return result;
    }

    public void showDoctor() {
        System.out.printf("|%20s|%26s|%12s|%27s|%20s|%16s|%16s|\n", doctorID, name, checkGender(), address, departmentID, createDate, lastUpdateDate);
    }

    @Override
    public String toString() {
        return doctorID + "," + name + "," + checkGender() + "," + address + "," + departmentID + "," + createDate + "," + lastUpdateDate;
    }

}
