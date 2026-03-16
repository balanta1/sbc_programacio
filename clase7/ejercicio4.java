package clase7;

import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int suma = 0;
        int numero;
        System.out.println("ingrese un numero (0 para terminar)");

        numero = sc.nextInt();
        numero = 0;
        suma = suma + numero;
        System.out.println("ingrese otro numero (0 para terminar)");
        sc.close();
    }
}
