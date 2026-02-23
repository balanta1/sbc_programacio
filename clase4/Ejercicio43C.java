import java.util.Scanner;

public class Ejercicio43C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("numero");
        int numero = sc.nextInt();
        int totalpositivos = sc.nextInt();
        int totalnegativos = sc.nextInt();
        if (numero >=0){
            totalpositivos = totalpositivos + numero;
            System.out.println("la suma de los pos es:" + totalpositivos);
        }else{
            totalnegativos = totalnegativos + numero;
            System.out.println("la suma de los neg es:" + totalnegativos);
        }
        sc.close();
    }
}
