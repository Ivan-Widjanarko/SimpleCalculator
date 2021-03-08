
/**
 * Program kalkulator sederhana dengan 2 fitur, yaitu :
 * 1. Input Statis
 * 2. Input Dinamis (Input dari User)
 *
 * @author Ivan Widjanarko
 * @version 08-03-2021
 */

import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

public class SimpleCalc
{   
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {}
    }

    public static void menu(int temp)
    {
        if (temp == 0)
        {
            Scanner input = new Scanner(System.in);
            int getUserChoice = 0;
            clearScreen();
            try {
                System.out.println("Selamat Datang di Kalkulator Sederhana\n" +
                    "\nMenu :\n" +
                        "\t1. Input Statis\n" +
                        "\t2. Input Dinamis\n" +
                        "\t3. Keluar\n\n" +
                    "Pilihan Anda : ");
                
                getUserChoice = input.nextInt();
            }
            
            catch (InputMismatchException j) {
                System.out.println("\nTolong Hanya Masukkan Angka 1, 2, atau 3\n" + "\nSilahkan Coba Lagi");
                try{Thread.sleep(3000);}
                catch(InterruptedException i){}
                menu(temp);
            }
            switch (getUserChoice) {
                case 1 :
                    inputStatic();
                    break;
                case 2 :
                    inputDynamic();
                    break;
                case 3 :
                    exitProgram();
                    break;
                default :
                    System.out.println("\nTolong Hanya Masukkan Angka 1, 2, atau 3\n" + "\nSilahkan Coba Lagi");
                    try{Thread.sleep(3000);}
                    catch(InterruptedException i){}
                    menu(temp);
            
            }
        }
        
        else
        {
            Scanner input = new Scanner(System.in);
            int getUserChoice = 0;
            try {
                System.out.println(
                    "\nMenu :\n" +
                        "\t1. Ulang\n" +
                        "\t2. Ke Menu\n" +
                        "\t3. Keluar\n\n" +
                    "Pilihan Anda : ");
                
                getUserChoice = input.nextInt();
            }
            catch (InputMismatchException j) {
                System.out.println("\nTolong Hanya Masukkan Angka 1, 2, atau 3\n" + "\nSilahkan Coba Lagi");
                try{Thread.sleep(3000);}
                catch(InterruptedException i){}
                menu(temp);
            }
            if (temp == 1)
            {
                switch (getUserChoice) {
                    case 1 :
                        inputStatic();
                        break;
                    case 2 :
                        menu(0);
                        break;
                    case 3 :
                        exitProgram();
                        break;
                    default :
                        System.out.println("\nTolong Hanya Masukkan Angka 1, 2, atau 3\n" + "\nSilahkan Coba Lagi");
                        try{Thread.sleep(3000);}
                        catch(InterruptedException i){}
                        menu(temp);
                
                }
            }
            
            else
            {
                switch (getUserChoice) {
                    case 1 :
                        inputDynamic();
                        break;
                    case 2 :
                        menu(0);
                        break;
                    case 3 :
                        exitProgram();
                        break;
                    default :
                        System.out.println("\nTolong Hanya Masukkan Angka 1, 2, atau 3\n" + "\nSilahkan Coba Lagi");
                        try{Thread.sleep(3000);}
                        catch(InterruptedException i){}
                        menu(temp);
                
                }
            }
        }
    }
    
    public static void inputStatic()
    {
        double a, b, c, d, e, f;
        int temp;
        a = 10.00;
        b = 5.00;
        c = a + b;
        d = a - b;
        e = a * b;
        f = a / b;
        temp = 1;
        
        clearScreen();
        
        System.out.println("Kalkulator dengan Input Statis\n\n");
        System.out.println("Isi variable a adalah " + String.format("%.2f", a) + "\n");
        System.out.println("Isi variable b adalah " + String.format("%.2f", b) + "\n");
        System.out.println("Hasil penjumlahan variable a dan b = " + String.format("%.2f", c) + "\n");
        System.out.println("Hasil pengurangan variable a dan b = " + String.format("%.2f", d) + "\n");
        System.out.println("Hasil perkalian variable a dan b = " + String.format("%.2f", e) + "\n");
        System.out.println("Hasil pembagian variable a dan b = " + String.format("%.2f", f) + "\n\n");
        
        System.out.println("Harap Tunggu Beberapa Saat");
        try{Thread.sleep(3000);}
        catch(InterruptedException i){}
        menu(temp);
    }
    
    public static void inputDynamic()
    {
        Scanner input = new Scanner(System.in);
        double a, b, answer;
        char operator;
        int temp;
        a = 0.00;
        b = 0.00;
        answer = 0.00;
        temp = 2;
        
        clearScreen();
        
        try {
            System.out.println("Kalkulator dengan Input Dinamis\n");
            System.out.println("\nMasukkan Angka Pertama : ");
            a = input.nextDouble();
        }
        catch (InputMismatchException j) {
            System.out.println("\nTolong Hanya Masukkan Angka\n" + "\nSilahkan Coba Lagi");
            try{Thread.sleep(3000);}
            catch(InterruptedException i){}
            inputDynamic();
        }
        
        try {
            System.out.println("\nMasukkan Angka Kedua : ");
            b = input.nextDouble();
        }
        catch (InputMismatchException j) {
            System.out.println("\nTolong Hanya Masukkan Angka\n" + "\nSilahkan Coba Lagi");
            try{Thread.sleep(3000);}
            catch(InterruptedException i){}
            inputDynamic();
        }
        System.out.println("\nMasukkan Simbol Operasi : ");
            operator = input.next().charAt(0);
        
        switch(operator) {
            case '+' :
                answer = a + b;
                System.out.println("\nHasil Operasi : " + String.format("%.2f", answer));
                break;
            case '-' :
                answer = a - b;
                System.out.println("\nHasil Operasi : " + String.format("%.2f", answer));
                break;
            case '*' :
                answer = a * b;
                System.out.println("\nHasil Operasi : " + String.format("%.2f", answer));
                break;
            case '/' :
                answer = a / b;
                System.out.println("\nHasil Operasi : " + String.format("%.2f", answer));
                break;
            default :
                System.out.println("\nTolong Hanya Masukkan +, -, * atau /\n" + "\nSilahkan Coba Lagi");
                    try{Thread.sleep(3000);}
                    catch(InterruptedException i){}
                    inputDynamic();
                
        }
        
        System.out.println("Harap Tunggu Beberapa Saat");
        try{Thread.sleep(3000);}
        catch(InterruptedException i){}
        menu(temp);
    }
    
    public static void exitProgram()
    {
        clearScreen();
        
        System.out.println("Terima Kasih Sudah Menggunakan Kalkulator Ini\n" +
            "Sampai Jumpa Lagi\n\n" +
            "Ivan Widjanarko\n" +
            "1806148706\n" +
            "OOP - 01");
            
        System.exit(0);
    }
    
    /**
     * Constructor for objects of class SimpleCalc
     */
    public static void main(String[] args)
    {
        int temp;
        temp = 0;
        menu(temp);
    }
}
