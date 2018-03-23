package tres.en.raya;

public class Ranking {

    //atributos
    int victoria;
    int jugadas;
    int empate;
    int derrota;

    //constructor
    public Ranking() {
        this.victoria = 0;
        this.jugadas = 0;
        this.empate = 0;
        this.derrota = 0;
    }

    //metodos
    public void addEmpate() {
        this.jugadas++;
        this.empate++;
    }

    public void addVictoria(boolean victoriaJugador) {
        this.jugadas++;
        if (victoriaJugador == true) {
            this.victoria++;
        } else {
            this.derrota++;
        }
    }

    public void mostrarRanking() {
        System.out.println("Has ganado " + victoria + " partida/s");
        System.out.println("Has perdido " + derrota + " partida/s");
        System.out.println("Has empatado " + empate + " partida/s");
        System.out.println("Has jugado un  total de " + jugadas + " partida/s");

    }
}
