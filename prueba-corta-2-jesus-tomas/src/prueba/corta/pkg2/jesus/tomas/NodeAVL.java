package prueba.corta.pkg2.jesus.tomas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jrios
 */
public class NodeAVL {
    private NodeAVL left;
    private NodeAVL right;
    private int data;
    private int fe;
   
    
    /**
     * Este es el constructor de la clase NodeAVL
     * @param d int Número que se va a guardar en el nodo.
     */
    public NodeAVL(int d){
        this.data=d;
        this.fe=0;
        this.left=null;
        this.right=null;
        
    }
        

    /**
     * Este método devuelve el nodo posicionado a la izquierda.
     * @return left Nodo posicionado a la izquierda.
     */
    public NodeAVL getLeft() {
        return left;
    }

    /**
     * Este método le asigna un valor al nodo de la izquierda.
     * @param left NodeAVL Valor que se le quiere insertar al nodo de la izquierda
     */
    public void setLeft(NodeAVL left) {
        this.left = left;
    }

    /**
     * Este método devuelve el nodo posicionado a la derecha.
     * @return right Nodo posicionado a la derecha.
     */
    public NodeAVL getRight() {
        return right;
    }

    /**
     * Este método le asigna un valor al nodo de la derecha.
     * @param right NodeAVL Valor que se le quiere insertar al nodo de la derecha
     */
    public void setRight(NodeAVL right) {
        this.right = right;
    }

    /**
     * Este método devuelve el valor numérico del nodo.
     * @return int Valor numérico del nodo.
     */
    public int getData() {
        return data;
    }

    /**
     * Este método le asigna un valor numérico al nodo.
     * @param data int Valor numérico que se quiere asignar al nodo.
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * Este método devuelve un valor numérico que representa el peso del nodo.
     * @return int Número que representa el peso del nodo.
     */
    public int getFe() {
        return fe;
    }

    /**
     * Este método asigna el peso del nodo.
     * @param fe int Peso que se desea asignar al nodo.
     */
    public void setFe(int fe) {
        this.fe = fe;
    }
}
