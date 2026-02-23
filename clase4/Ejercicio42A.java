import java.util.Scanner;

public class Ejercicio42A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // pedir el punto de ebullicion del agua del usuario
        System.out.println("Punto de ebullicion");
        int temperatura = sc.nextInt();
        //condicional
        if (temperatura == 100) {
             System.out.println("por encima del punto de ebullicion del agua");
        } else {
            System.out.println("por debajo del punto de ebullicion del agua");
        }
        sc.close();
    }
}
