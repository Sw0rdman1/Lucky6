/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.List;

/**
 *
 * @author Božidar
 */
public class Broj {
    
    private int broj;
    private boolean dupli;
    private int mesto;

    public Broj() {
    }

    public Broj(int broj, boolean dupli, int mesto) {
        this.broj = broj;
        this.dupli = dupli;
        this.mesto = mesto;
    }

    public int getMesto() {
        return mesto;
    }

    public void setMesto(int mesto) {
        this.mesto = mesto;
    }

    

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public boolean isDupli() {
        return dupli;
    }

    public void setDupli(boolean dupli) {
        this.dupli = dupli;
    }

    @Override
    public String toString() {
        return "( " + this.broj + " )  -  ";
    }
    
    
    
    
    
}
