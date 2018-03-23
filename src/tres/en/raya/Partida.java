package tres.en.raya;

public class Partida {

    //Atributos
    private Jugador jugadores[];
    private Tablero tablero;
    private int turnoActual;
    private int victoriaJugador = -1;

    //Constructor
    public Partida(Jugador Blancas, Jugador Negras) {
        this.jugadores = new Jugador[2];
        this.jugadores[0] = Blancas;
        this.jugadores[1] = Negras;

        this.jugadores[0].setBlancas(true);
        this.jugadores[1].setBlancas(false);

        this.tablero = new Tablero();
        this.victoriaJugador = -1;

        //Pasamos el tablero a la IA
        if (jugadores[0] instanceof IA0) {
            ((IA0) jugadores[0]).setTablero(this.tablero);
        } else {
            ((IA0) jugadores[1]).setTablero(this.tablero);
        }

    }

    //Metodos
    public boolean ganador() {
        if (victoriaJugador != -1) {
            System.out.print("\nCasilla no válida");
            if (jugadores[victoriaJugador] instanceof IA0) {
                return false;
            } else {
                return true;
            }
        }
        if (jugadores[tablero.comprobarGanador()] instanceof IA0) {
            return false;
        }
        return true;

    }

    public Tablero getTablero() {
        return tablero;
    }

    public void jugar() {
        Movimiento m;
        int turnoJugador;

        for (this.turnoActual = 0; !tablero.comprobarLleno() && tablero.comprobarGanador() == -1; this.turnoActual++) {

            turnoJugador = this.turnoActual % 2;

            if (turnoJugador == 0) {
                System.out.println("\nTurno de las blancas");
            } else {
                System.out.println("\nTurno de las negras");
            }

            m = jugadores[turnoJugador].mover();

            if (!tablero.casillaVacia(m.getFila(), m.getColumna())) {
                victoriaJugador = Math.abs(turnoJugador - 1);
                break;
            }
            tablero.mover(m);
            this.tablero.mostrarTablero();
        }
    }

}
