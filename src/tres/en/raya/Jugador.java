package tres.en.raya;

import java.util.Scanner;

public class Jugador {
    
    //Atributos
    private String nombre;
    private boolean blancas;

    //Constructor
    public Jugador(String nombre) {

        this.nombre = nombre;
    }
    
    //Métodos
    public boolean getBlancas() {

        return this.blancas;
    }

    public Movimiento mover() {

        int columna;
        int fila;
        Movimiento mov;
        mov = new Movimiento();

        Scanner sc = new Scanner(System.in);

        mov.setJugador(this);
        mov.setBlancas(this.blancas);

        //Pedir fila por consola
        System.out.println("Introduce fila del 0 al 2");
        fila = sc.nextInt();       
        while (!mov.setFila(fila)) {
            System.out.println("Fila no válida");
            fila = sc.nextInt();
        }

        //Pedir columna por consola
        System.out.println("Introduce columna del 0 al 2");
        columna = sc.nextInt();
        while (!mov.setColumna(columna)) {
            System.out.println("Columna no valida");
            columna = sc.nextInt();
        }
        return mov;
    }

    public void setBlancas(boolean blancas) {
        this.blancas = blancas;
    }
}