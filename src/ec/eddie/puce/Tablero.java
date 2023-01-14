package ec.eddie.puce;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class Tablero extends JPanel {

    private JToggleButton[][] botones; //matriz de botones para dibujar el tablero
    private ArrayList<Integer> sacados; //Lista para almacenar los números sacados

    public Tablero() {
        setLayout(new GridLayout(9, 10)); //Establece el layout en una grilla de 9x10
        botones = new JToggleButton[9][10]; //inicializa la matriz de botones

        for (int i = 0; i < 9; i++) { //ciclo para recorrer las filas
            for (int j = 0; j < 10; j++) { //ciclo para recorrer las columnas
                int numero = i * 10 + j + 1; //calcula el número correspondiente
                botones[i][j] = new JToggleButton(Integer.toString(numero)); //crea un nuevo botón con el número correspondiente
                botones[i][j].setEnabled(false); //deshabilita el boton
                add(botones[i][j]); //añade el boton al panel
            }
        }
    }

    public void setSacados(ArrayList<Integer> sacados) {
        this.sacados = sacados; //guarda la lista de números sacados
    }

    public void marcarNumero(int numero) {
        int i = (numero - 1) / 10; //calcula la fila en la matriz de botones
        int j = (numero - 1) % 10; //calcula la columna en la matriz de botones
        botones[i][j].setBackground(Color.BLUE); //cambia el color del boton marcado
        botones[i][j].setEnabled(false); //deshabilita el boton
        sacados.add(numero); //añade el número a la lista de números sacados
    }
    public void reiniciar() {
    	for (int i = 0; i < 9; i++) { //ciclo para recorrer las filas
            for (int j = 0; j < 10; j++) { //ciclo para recorrer las columnas
                botones[i][j].setBackground(null); //reestablece el color del boton
                botones[i][j].setEnabled(true); //habilita el boton
            }
        }
        sacados.clear(); //vacía la lista de números sacados
    }

    public boolean tablaLlena() {
        for (int i = 0; i < botones.length; i++) { //ciclo para recorrer las filas
            for (int j = 0; j < botones[i].length; j++) { //ciclo para recorrer las columnas
                if (!botones[i][j].getBackground().equals(Color.BLUE)) { //si el boton no esta marcado
                    return false; //retorna falso
                }
            }
        }
        return true; //retorna verdadero si todos los botones estan marcados
    }

    }
    
    