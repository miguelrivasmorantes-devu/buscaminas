package rivasMiguel;
import java.util.Scanner;

public class Acciones {

    public char pedirAccion() {
        Scanner sc = new Scanner(System.in);

        System.out.println("[D]espejar o [M]arcar mina?");
        char accion = sc.next().toUpperCase().charAt(0);

        return accion;
    }

    public int[] pedirCoordenadas() {
        Scanner sc = new Scanner(System.in);
        int[] coordenadas = new int[2];

        System.out.println("Elija coordenada:");
        System.out.print("> Fila: ");
        coordenadas[0] = sc.nextInt();
        System.out.print("> Columna: ");
        coordenadas[1] = sc.nextInt();

        return coordenadas;
    }

    public void actualizarTablero(Tablero tablero, char accion, int fila, int columna) {
        if (accion == 'D') {
            int contadorMinas = contarMinasAdyacentes(tablero, fila, columna);
            tablero.tablero[fila][columna] = (char) ('0' + contadorMinas);
        } 
        else if (accion == 'M') {
            tablero.tablero[fila][columna] = 'M';
        }
    }

    private int contarMinasAdyacentes(Tablero tablero, int fila, int columna) {
        int contadorMinas = 0;

        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                for (int[] mina : tablero.minas) {
                    if (mina[0] == i && mina[1] == j) {
                        contadorMinas++;
                    }
                }
            }
        }

        return contadorMinas;
    }
}
