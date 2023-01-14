package ec.eddie.puce;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class BingoUI extends JFrame {

    private ArrayList<Integer> bolaList; 
    private Tablero tablero;
    private JLabel lblNumeroSacado;
    private JButton btnSacarBola;

    public BingoUI() {
        setTitle("Bingo90");       
        setSize(833, 676);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        bolaList = new ArrayList<Integer>();
        for (int i = 1; i <= 90; i++) {
        	bolaList.add(i);
        }
        Collections.shuffle(bolaList);
        // se mezcla los números en la lista "bolaList"
        tablero = new Tablero();
        tablero.setBounds(75, 161, 556, 465);
        tablero.setSacados(bolaList);
        // se establece la lista "bolaList" como los números sacados en el objeto "tablero"
        getContentPane().add(tablero);

        lblNumeroSacado = new JLabel();
        lblNumeroSacado.setForeground(new Color(0, 0, 0));
        lblNumeroSacado.setFont(new Font("Unispace", Font.PLAIN, 64));
        lblNumeroSacado.setBounds(36, 32, 149, 118);
        getContentPane().add(lblNumeroSacado);
        // se agrega la etiqueta "lblNumeroSacado" al panel de contenido

        btnSacarBola = new JButton("Sacar bola");
        btnSacarBola.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnSacarBola.setBounds(642, 11, 149, 95);
        btnSacarBola.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (bolaList.size() > 0 && !tablero.tablaLlena()) {
                    int numero = bolaList.remove(0);
                    // se saca el primer número de la lista "bolaList"
                    lblNumeroSacado.setText(Integer.toString(numero));
                    tablero.marcarNumero(numero);
                 // se establece el número sacado en la etiqueta "lblNumeroSacado" y se marca en el objeto "tablero"
                } else {
                lblNumeroSacado.setText("No hay mas bolas");
                btnSacarBola.setEnabled(false);
                // si no quedan más números en la lista o el tablero está lleno, se desactiva el botón "btnSacarBola" y se muestra un mensaje de juego terminado en la etiqueta "lblNumeroSacado"
                }
                }
                });
                getContentPane().add(btnSacarBola);
                // se agrega el botón "btnSacarBola" al panel de contenido
                JButton btnReiniciar = new JButton("Reiniciar");
                btnReiniciar.setBounds(629, 117, 178, 30);
                btnReiniciar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        reiniciar();
                        // al presionar este botón, se ejecuta el método "reiniciar()"
                    }
                });
                getContentPane().add(btnReiniciar);
                // se agrega el botón "btnReiniciar" al panel de contenido

                JLabel lblNewLabel = new JLabel("Bingo2.0");
                lblNewLabel.setForeground(new Color(0, 255, 128));
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
                lblNewLabel.setBounds(233, 11, 269, 116);
                getContentPane().add(lblNewLabel);
                
            }

            public void reiniciar() {
                tablero.reiniciar();
                // se reinicia el objeto "tablero"
                Collections.shuffle(bolaList);
                tablero.setSacados(bolaList);
                // se mezcla los números en la lista "bolaList" y se establece como los números sacados en el objeto "tablero"
                lblNumeroSacado.setText("");
                btnSacarBola.setEnabled(true);
                // se vacía la etiqueta "lblNumeroSacado" y se activa el botón "btnSacarBola"
            }

            public static void main(String[] args) {
            	BingoUI bingo = new BingoUI();
            	bingo.setVisible(true);
            	// se crea un objeto de la clase "BingoUI" y se hace visible la ventana
            	}
            }