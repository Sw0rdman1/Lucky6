/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Niti;

/**
 *
 * @author Božidar
 */
public class NT1 extends Thread {

    NT1() {
        signal = true;
        start();
    }
    
    
    
    public static void main(String[] args) {
        
        NT1 prvaNit = new NT1();
        NT1 DrugaNit = new NT1();
        
        
        
    }
    
    
    boolean signal;
}
