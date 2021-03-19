/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.corta.pkg2.jesus.tomas;

/**
 *
 * @author Tomas
 */
public class Controller {
    private Canvas canvas;
    private AVLTree arbol;
    
    public Controller(Canvas canvas, AVLTree arbol){
        this.canvas = canvas;
        this.arbol = arbol;
    }
    
    public void iniciar(){
        canvas.setArbol(arbol);
    }
}
