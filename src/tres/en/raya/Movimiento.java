package tres.en.raya;

public class Movimiento {

    //Atributos
    private int columna;
    private int fila;
    private Jugador jugador;
    private boolean blancas;

    //Constructor
    public Movimiento() {
    }
    
    //Metodos
    public boolean getBlancas() {
        return this.blancas;
    }

    public int getColumna() {
        return this.columna;
    }

    public int getFila() {
        return this.fila;
    }

    public Jugador getJugador() {
        return this.jugador;
    }

    public void setBlancas(boolean blancas) {
        this.blancas = blancas;
    }

    public boolean setColumna(int col) {
        if (col < 0 || col > 2) {
            //Si la columna no es valida
            return false;
        }
        this.columna = col;
        return true;
    }

    public boolean setFila(int fil) {
        if (fil < 0 || fil > 2) {
            //Si la fila no es valida
            return false;
        }
        this.fila = fil;
        return true;
    }

    public void setJugador(Jugador jugador) {
        if (jugador != null) {
            this.jugador = jugador;
        }
    }
}
