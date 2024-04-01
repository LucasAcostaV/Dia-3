public class Reloj {
    //Tres instancias de variables:para las horas (rango 0-23), minutos (rango 0-59) y los segundos (rango 0-59).
    int horas,minutos,segundos;

    //Constructor por defecto (sin parametros; inicializa la hora a las 12:00:00)
    public Reloj(){
        horas = 12;
        minutos= 00;
        segundos= 00;
    }

    //Constructor con 3 parametros: horas, minutos y segundos
    public Reloj(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos  = minutos;
        this.segundos = segundos;
    }

    // Constructor con 1 parametro: el valor del tiempo en segundos desde la medianoche (debe ser convertido en los valores horas, minutos y segundos)
    public Reloj(int segundos){
        horas = segundos / 3600;
        minutos = (segundos % 3600) / 60;
        this.segundos = (segundos % 3600) % 60 ;
    }

    //Metods getters y setters
    public void setReloj (int segundos){
        this.segundos = segundos;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    //Metodo tick(), este debe incrementar el tiempo de los segundos en 1.
    //Solo afecta a los segundos, cuando llegue a 59 el siguiente tick() debe inicializar en 0 los segundos nuevamente
    public void tick() {
        if (segundos == 59) {
            segundos = 0;
            minutos++;
        } else {
            segundos += 1;
        }
    }

    //Metodo addReloj() acepta un parametro del tipo Reloj. El metodo debe agregar la hora representada por el objeto en la clase actual.
    public void addReloj(Reloj reloj2){
        segundos += reloj2.segundos;
        minutos += reloj2.minutos;
        horas += reloj2.horas;

        if(segundos >= 60){
            minutos += segundos / 60;
            segundos %= 60;
        }

        if (minutos >= 60){
            horas += minutos / 60;
            minutos %= 60;
        }

        if (horas >= 24) {
            horas %= 24;
        }
    }

    //Metodo toString(). Debe retornar un String representando el objeto Reloj en el formato "[hh:mm:ss]", por ejemplo "[22:32:12]"*/

    public String toString(){
        return "["+horas+":"+minutos+":"+segundos+"]";
    }

    //Metodo tickDecrement(), este debe decrementar el tiempo de los segundos en 1*/
    public void tickDecrement() {
        if (segundos == 00) {
            segundos = 59;
        } else {
            segundos -= 1;
        }
    }

    //Metodo restaReloj() que toma un parametro tipo Reloj y returna la diferencia de tiempo representada en el objeto de reloj actual y el representado en el parametro.
    public void restaReloj(Reloj reloj2) {
        int diferenciaHoras;
        int diferenciaMinutos;
        int diferenciaSegundos;

        if (horas > reloj2.horas) {
            diferenciaHoras = horas - reloj2.horas;
            diferenciaMinutos = minutos - reloj2.minutos;
            diferenciaSegundos = segundos - reloj2.segundos;
        } else {
            diferenciaHoras = reloj2.horas - horas;
            diferenciaMinutos = reloj2.minutos - minutos;
            diferenciaSegundos = reloj2.segundos - segundos;
        }

        if (diferenciaSegundos < 0) {
            diferenciaSegundos += 60;
            diferenciaMinutos -= 1;
        }

        if (diferenciaMinutos < 0) {
            diferenciaMinutos += 60;
            diferenciaHoras -= 1;
        }

        // Asignar la nueva diferencia de tiempo al objeto de reloj actual
        horas = diferenciaHoras;
        minutos = diferenciaMinutos;
        segundos = diferenciaSegundos;
    }
}
