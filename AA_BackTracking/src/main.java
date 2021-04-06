
import Juego.InterfazCartas;
import Juego.Juego;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandra G
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        InterfazCartas guiCartas = new InterfazCartas();
        Juego juego = new Juego();
        juego.guiCartas = guiCartas;
        guiCartas.juego = juego;
        guiCartas.setVisible(true);
        
        /*for (int i = 0; i < 300; i++) {
            int numero = (int) (Math.random() * 250);
            guiCartas.jSpinner1.setValue(numero);
            guiCartas.jButton1.doClick();
        }*/
    }
    
}
