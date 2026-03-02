import java.util.Scanner;

public class Ejercicio44D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x, y, z, p;

        System.out.print("Ingrese el valor de x: ");
        x = sc.nextInt();

        System.out.print("Ingrese el valor de y: ");
        y = sc.nextInt();

        System.out.print("Ingrese el valor de z: ");
        z = sc.nextInt();

        // Condicional del punto d
        if (x > y && z < 20) {
            System.out.print("Ingrese el valor de p: ");
            p = sc.nextInt();
            System.out.println("El valor de p es: " + p);
        } else {
            System.out.println("No se cumple la condición, no se lee p.");
        }

        sc.close();
    }
}
