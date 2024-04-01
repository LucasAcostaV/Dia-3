import java.util.Scanner;

public class RelojDemo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Reloj reloj;

        do {
            System.out.printf("Ingrese el valor de la hora actual en segundos, desde la media noche: ");
            int horaEnSegundos = entrada.nextInt();
            reloj = new Reloj(horaEnSegundos);
        } while(reloj.getHoras() < 0 || reloj.getHoras() > 23 || reloj.getMinutos() < 0 || reloj.getMinutos() > 59 || reloj.getSegundos() < 0 || reloj.getSegundos() > 59);
        System.out.printf("\nLa hora es: "+reloj);

        for (int i=0; i<10; i++){
            reloj.tick();
            System.out.printf("\n"+reloj);
        }

        System.out.printf("\n");
        Reloj reloj2 = new Reloj(3,25,46);
        reloj.restaReloj(reloj2);

        System.out.printf("\nLa nueva hora es: "+reloj);

    }
}

