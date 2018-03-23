package tres.en.raya;

import java.util.ArrayList;
import java.util.Scanner;

public class Sesion {

    //Atributos
    private Ranking ranking;
    private ArrayList<Partida> partidas;
    private Jugador jugador;
    private IA0 IA;

    //Constructor
    public Sesion() {
        this.partidas = new ArrayList();
        this.IA = new IA0();
        this.ranking = new Ranking();
    }

    //Métodos
    private void actualizarRanking(Partida p) {

        if (p.getTablero().comprobarEmpate()) {
            //Empate
            System.out.println("Has empatado!");
            this.ranking.addEmpate();
        } else {
            //Alguien gana 
            if (p.ganador()) {
                this.ranking.addVictoria(true);
                System.out.println("\nHas Ganado!\n");

            } else {
                this.ranking.addVictoria(false);
                System.out.println("\nHas perdido intentalo de nuevo!\n");

            }
        }
    }

    private void crearJugador() {
        System.out.println("Introduce tu nombre");

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        this.jugador = new Jugador(name);

    }

    private void crearPartida() {
        Partida p;

        int sorteo;
        sorteo = this.sorteo();

        if (sorteo == 0) {
            p = new Partida(this.jugador, this.IA);
        } else {
            p = new Partida(this.IA, this.jugador);
        }

        this.partidas.add(p);
        p.jugar();
        this.actualizarRanking(p);

    }

    private void menu() {
        boolean salir = false;

        while (salir == false) {

            System.out.println("1- Empezar partida");
            System.out.println("2- Mostrar ranking");
            System.out.println("3- Salir");
            Scanner sc = new Scanner(System.in);
            int navegar = sc.nextInt();
            switch (navegar) {

                case 1:
                    crearPartida();
                    break;
                case 2:
                    this.ranking.mostrarRanking();
                    break;
                case 3:
                    salir = true;
                    break;

            }
        }

    }

    private int sorteo() {
        int sorteo;
        sorteo = (int) (Math.random() * 2);
        if (sorteo == 0) {
            System.out.println("Empieza el Jugador");
        } else {
            System.out.println("Empieza la Máquina");
        }
        return sorteo;
    }

    public static void main(String[] args) {
        Sesion sesion;
        sesion = new Sesion();
        sesion.crearJugador();
        sesion.menu();
    }

}
