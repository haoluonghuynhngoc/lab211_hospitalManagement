package haolhn.information;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import haolhn.utils.Utils;
import java.util.ArrayList;

/**
 *
 * @author ngoc hao
 */
public class Menu extends ArrayList<String> {

    public void addItem(String s) {
        this.add(s);
    }

    public void showMenu() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i));
        }
    }

    public boolean confirmYesNo(String welcome) {
        boolean result = false;
        result = Utils.confirmYesNo(welcome);
        return result;
    }

    public int getChoice(String welcome) {
        return Utils.getInt(welcome, 1, this.size());
    }
}
