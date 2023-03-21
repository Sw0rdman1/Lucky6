/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Božidar
 */
public class LuckySix {
    
    List<Broj> izvuceniBrojevi = new LinkedList<>();
    
    public List<Broj> getIzvuceniBrojevi() {
        return izvuceniBrojevi;
    }

    public void setIzvuceniBrojevi(List<Broj> brojeviIzvuceni) {
        this.izvuceniBrojevi = izvuceniBrojevi;
    }

    
    
    public LuckySix() {
    }

    public LuckySix(List<Broj> izvuceniBrojevi) {
        this.izvuceniBrojevi = izvuceniBrojevi;
    }
    
    
    public int simulirajIzvlacenje(int[] uplaceniBrojevi, int uplaceniIznos) throws InterruptedException {
        int dobitak = 0;
        
        Random random = new Random();
        
        int prviDupli = random.nextInt(29) + 6;
        int drugiDupli = random.nextInt(29) + 6;
        
        while (prviDupli == drugiDupli) {
            drugiDupli = random.nextInt(29) + 6;
        }
        
        int broj = random.nextInt(48) + 1;
            Broj prvaLoptica = new Broj();
            prvaLoptica.setBroj(broj);
            prvaLoptica.setMesto(1);
        
            System.out.print(prvaLoptica);

            
        for (int i = 2; i <= 35; i++) {
            
            
            while (true) {
                broj = random.nextInt(48) + 1;
                int flag = 0;
                
                for (int j = 0; j < izvuceniBrojevi.size(); j++) {
                    if (broj==izvuceniBrojevi.get(j).getBroj()) {
                       flag ++;
                    }
                }
                if (flag == 0) {
                    break;
                }
            }
            
            Broj loptica = new Broj();
            loptica.setBroj(broj);
            loptica.setMesto(i);
            
            if (i == prviDupli || i == drugiDupli) {
                loptica.setDupli(true);
                System.out.print("$");
            } else {
                loptica.setDupli(false);
            }
            
            izvuceniBrojevi.add(loptica);
            System.out.print(loptica);
            
            if (i%7==0) {
                System.out.println();
            }
            
        }
        
        int brojac = 0;
        boolean prvaDupla = false;
        boolean drugaDupla = false;
        
        for (Broj broj1 : izvuceniBrojevi) {
            if (brojac == 6) {
                break;
            }
            int najveceMesto = 0;
            
            for (int i = 0; i < uplaceniBrojevi.length; i++) {
            if (brojac == 6) {
                break;
            }
                if (broj1.getBroj()==uplaceniBrojevi[i]) {
                    brojac++;
                    if (broj1.getMesto() > najveceMesto) {
                        najveceMesto = broj1.getMesto();
                    }
                
                    if (broj1.isDupli()) {
                        prvaDupla = true;
                    }
                    if (prvaDupla && broj1.isDupli()) {
                        drugaDupla = true;
                    }
                }
                
                
                
                if (brojac == 6) {
                    
                    System.out.println("Kvota je:  " + (pronadjiKvotu(najveceMesto)));
                    
                    dobitak = uplaceniIznos * pronadjiKvotu(najveceMesto);
                    if (drugaDupla) {
                        dobitak = dobitak * 3;
                    } else if(prvaDupla) {
                        dobitak = dobitak *2;
                    }
                
                }
                
            }
            
        }
        
        System.out.println(brojac);

        System.out.println("Vas dobitak iznosi:  " + dobitak);

        
        return dobitak;
    }
    
    private int pronadjiKvotu(int mesto) {
        int kvota = 0;
        switch(mesto) {
            
            case 6:
                kvota = 10000;
            break;
            
            case 7:
                kvota = 7500;
            break;
            
            case 8:
                kvota = 5000;
            break;
            
            case 9:
                kvota = 2500;
            break;
            
            case 10:
                kvota = 1000;
            break;
            
            case 11:
                kvota = 500;
            break;
            
            case 12:
                kvota = 300;
            break;
            
            case 13:
                kvota = 200;
            break;
            
            case 14:
                kvota = 150;
            break;
            
            case 15:
                kvota = 100;
            break;
            
            case 16:
                kvota = 90;
            break;
            
            case 17:
                kvota = 80;
            break;
            
            case 18:
                kvota = 70;
            break;
            
            case 19:
                kvota = 60;
            break;
            
            case 20:
                kvota = 50;
            break;
            
            case 21:
                kvota = 40;
            break;
            
            case 22:
                kvota = 30;
            break;
            
            case 23:
                kvota = 25;
            break;
            
            case 24:
                kvota = 20;
            break;
            
            case 25:
                kvota = 15;
            break;
            
            case 26:
                kvota = 10;
            break;
            
            case 27:
                kvota = 9;
            break;
            
            case 28:
                kvota = 8;
            break;
            
            case 29:
                kvota = 7;
            break;
            
            case 30:
                kvota = 6;
            break;
                
            case 31:
                kvota = 5;
            break;
            
            case 32:
                kvota = 4;
            break;
            
            case 33:
                kvota = 3;
            break;
            
            case 34:
                kvota = 2;
            break;
            
            case 35:
                kvota = 1;
            break;
            
            
            
            
}
        
        
        return kvota;
    }
    
    
    
    public static void main(String[] args) throws InterruptedException {
       
        LuckySix ls = new LuckySix();
        
        int[] uplaceniBrojevi = new int[] {2,9,16,30,35,47};
        int ukupanDobitak = 0;
        
        for (int i = 0; i < 100; i++) {
            int dobitak = ls.simulirajIzvlacenje(uplaceniBrojevi, 100);
            ukupanDobitak = ukupanDobitak + dobitak;
        }
        
        System.out.println("Ukupan donitak je:  " + ukupanDobitak);
    }
    
    
    
    
}
