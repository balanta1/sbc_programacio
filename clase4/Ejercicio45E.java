import java.util.Scanner;

public class Ejercicio45E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int distancia, tiempo;

        System.out.print("Ingrese la distancia: ");
        distancia = sc.nextInt();

        if (distancia > 20 && distancia < 35) {
            System.out.print("Ingrese el valor de tiempo: ");
            tiempo = sc.nextInt();
            System.out.println("El tiempo ingresado es: " + tiempo);
        } else {
            System.out.println("La distancia no está entre 20 y 35.");
        }

        sc.close();
    }
}    
