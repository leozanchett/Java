package classes;

// Classe publica com campos imutáveis expostos
public class Time {
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOURS = 60;
    // Valor permanece com a ultima alteração feita mesmo quando é instanciado uma nova classe.
    private static int conta = 0;

    public final int hour;
    public final int minute;


    public Time(int hour, int minute) {
        if(hour < 0 || hour >= HOURS_PER_DAY){
            throw new IllegalArgumentException("Hour :" + hour);
        }
        if(minute < 0 || minute >= MINUTES_PER_HOURS){
            throw new IllegalArgumentException("Min :" + minute);
        }
        this.hour = hour;
        this.minute = minute;
    }

    public void Conta(){
        conta++;
        System.out.println(conta);
    }
}
