package tres.en.raya;

public class Tablero {

    //Atributos
    private int tablero[][];

    //Constructor
    public Tablero() {

        this.tablero = new int[3][3];
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                tablero[fila][columna] = -1;
            }
        }
    }

    //Métodos
    public boolean casillaVacia(int fila, int columna) {
        if (this.tablero[fila][columna] != -1) {
            return false;
        }
        return true;
    }

    public boolean comprobarEmpate() {
        if(!this.comprobarLleno()){
            return false;
        }
        if (tablero[0][0] == tablero[0][1] && tablero[0][1] == tablero[0][2]) {
            return false;
        }
        if (tablero[1][0] == tablero[1][1] && tablero[1][1] == tablero[1][2]) {
            return false;
        }
        if (tablero[2][0] == tablero[2][1] && tablero[2][1] == tablero[2][2]) {
            return false;
        }
        if (tablero[0][0] == tablero[1][0] && tablero[1][0] == tablero[2][0]) {
            return false;
        }
        if (tablero[0][1] == tablero[1][1] && tablero[1][1] == tablero[2][1]) {
            return false;
        }
        if (tablero[0][2] == tablero[1][2] && tablero[1][2] == tablero[2][2]) {
            return false;
        }
        if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            return false;
        }
        if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            return false;
        }
        return true;
    }

    public int comprobarGanador() {
        if (tablero[0][0] == tablero[0][1] && tablero[0][1] == tablero[0][2] && tablero[0][1] != -1) {
            return tablero[0][0];
        }
        if (tablero[1][0] == tablero[1][1] && tablero[1][1] == tablero[1][2] && tablero[1][1] != -1) {
            return tablero[1][0];
        }
        if (tablero[2][0] == tablero[2][1] && tablero[2][1] == tablero[2][2] && tablero[2][1] != -1) {
            return tablero[2][0];
        }
        if (tablero[0][0] == tablero[1][0] && tablero[1][0] == tablero[2][0] && tablero[1][0] != -1) {
            return tablero[0][0];
        }
        if (tablero[0][1] == tablero[1][1] && tablero[1][1] == tablero[2][1] && tablero[1][1] != -1) {
            return tablero[0][1];
        }
        if (tablero[0][2] == tablero[1][2] && tablero[1][2] == tablero[2][2] && tablero[1][2] != -1) {
            return tablero[0][2];
        }
        if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[1][1] != -1) {
            return tablero[0][0];
        }
        if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0] && tablero[1][1] != -1) {
            return tablero[0][2];
        }

        return -1;
    }

    public boolean comprobarLleno() {
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                if (tablero[fila][columna] == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getcasilla(int columna, int fila) {
        return this.tablero[fila][columna];
    }

    public void mostrarTablero() {
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                if (this.tablero[fila][columna] != -1) {
                    if (this.tablero[fila][columna] == 0) {
                        System.out.print("[X]");
                    } else {
                        System.out.print("[O]");

                    }
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    public void mover(Movimiento mov) {

        if (mov.getBlancas()) {
            tablero[mov.getFila()][mov.getColumna()] = 0;

        } else {
            tablero[mov.getFila()][mov.getColumna()] = 1;
        }

    }

    public boolean validarMovimiento(Movimiento mov) {
        if (tablero[mov.getFila()][mov.getColumna()] != -1) {
            return false;

        }
        return true;
    }
}
