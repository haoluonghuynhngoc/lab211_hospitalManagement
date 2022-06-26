/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haolhn.information;

import java.io.IOException;

/**
 *
 * @author ngoc hao
 */
public interface I_List {

    public void showDoctor();

    public void showDepartmentList();

    public void addDoctor();

    public void addDepartment();

    public void updateDoctor();

    public void updateDepartment();

    public void deleteDoctor();

    public void deleteDepartment();

    public void searchNameDoctor();

    public void searchIDDepartment();

    public boolean writeDepartmentIO() throws IOException;

    public boolean writeDoctorIO() throws IOException;

    public void readDepartmentIO() throws IOException;

    public void readDoctorIO() throws IOException;

}
