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
public class Department {

    private String departmentID;
    private String name;
    private String createDate;
    private String lastUpdateDate;

    public Department() {
    }

    public Department(String departmentID) {
        this.departmentID = departmentID;
    }

    public Department(String departmentID, String name, String createDate) {
        this.departmentID = departmentID;
        this.name = name;
        this.createDate = createDate;
    }

    public Department(String departmentID, String name, String createDate, String lastUpdateDate) {
        this.departmentID = departmentID;
        this.name = name;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object obj) {
        return this.departmentID.equalsIgnoreCase(((Department)obj).getDepartmentID());
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void showDepartment() {
        System.out.printf("|%24s|%24s|%16s|%16s|\n", departmentID, name, createDate, lastUpdateDate);
    }

    @Override
    public String toString() {
        return departmentID + "," + name + "," + createDate + "," + lastUpdateDate;
    }

}
