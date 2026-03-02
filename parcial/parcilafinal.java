import java.util.Scanner;

public class parcilafinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int CLAVE=1234;
        int SALDOINICIAL =800000;
        int claveUsuario=1234,retiro=0,nuevoSaldo;

        System.out.println("Digite la clave de Usuario");
        claveUsuario = sc.nextInt();

        if (CLAVE == claveUsuario){
            System.out.println("Bienvenido automatico de la uniajc");
            System.out.println("Digite la cantidad a digiatar");
            retiro = sc.nextInt();
        }
        System.out.println("retiro");
        if (retiro>200000){
            retiro = retiro + 2000;}

            if (retiro <= SALDOINICIAL){
                nuevoSaldo = SALDOINICIAL-retiro;
            System.out.println("su saldo actual es:" +nuevoSaldo);
             System.out.println("Muchas gracias!!!!");
        }else{
            System.out.println("el valor solicitado mas el costo de la transaccion es mayor al saldo");
            retiro = sc.nextInt();
        }
            if (retiro <= SALDOINICIAL){
                nuevoSaldo = SALDOINICIAL-retiro;
                System.out.println("su saldo actual es:" +nuevoSaldo+"Muchas gracias!!!!");
            }else{
                System.out.println("El valor solicitado es mayor el saldo actual");
                retiro= sc.nextInt();
                
        }if(CLAVE == claveUsuario) {
            System.out.println("su clave es correcta");
            claveUsuario =sc.nextInt();
        }else{
            System.out.println("su clave es no correcta");
            claveUsuario =sc.nextInt();
        }  
    sc.close();
    }
}



    






    
