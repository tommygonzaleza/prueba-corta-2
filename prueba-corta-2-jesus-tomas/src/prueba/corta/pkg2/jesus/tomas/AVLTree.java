package prueba.corta.pkg2.jesus.tomas;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jrios
 */
public class AVLTree {

    private NodeAVL root;

    // Constructor de la clase AVLTree
    public AVLTree() {
        this.root = null;

    }

    /**
     * Este método devuelve el nodo de la raíz.
     * @return NodeAVL Devuelve el nodo de la raíz.
     */
    public NodeAVL getRoot() {
        return root;
    }

    /**
     * Este método le asigna una raíz al arbol.
     * @param root Nodo de raíz que se ve a asignar al arbol.
     */
    public void setRoot(NodeAVL root) {
        this.root = root;
    }

    /**
     * Este método busca un nodo en el arbol.
     * @param d Número del nodo que se desea buscar.
     * @param root Nodo de la raíz.
     * @return NodeAVL Devuelve el nodo en el que se ubica el número que se esta buscando.
     */
    public NodeAVL search(int d, NodeAVL root) {
        if (this.root == null) {
            return null;
        } else if (root.getData() == d) {
            return root;
        } else if (root.getData() < d) {
            return search(d, root.getRight());
        } else {
            return search(d, root.getLeft());
        }
    }
    
    
    

    /**
     * Este método devuelve el peso del nodo(Altura).
     * @param x Nodo del que se quiere obtener su peso.
     * @return int Número con el valor del peso.
     */
    public int GetFE(NodeAVL x) {
        if (x == null) {
            return -1;
        } else {
            return x.getFe();
        }
    }

    /**
     * Este método devuelve un número que contiene el mayor entre dos números.
     * @param x Número que se va a comparar.
     * @param d Número que se va a comparar.
     * @return int El número mayor entre los dos.
     */
    public int Max(int x, int d) {
        if (x > d) {
            return x;
        } else if (x < d) {
            return d;
        }else{
            return x;
        }
    }
    
    /**
     * Este método rota un nodo a la izquierda de forma simple.
     * @param c Nodo que se va a rotar.
     * @return NodeAVL El nodo rotado.
     */
    public NodeAVL LeftRotation(NodeAVL c) {
        NodeAVL aux = c.getLeft();
        c.setLeft(aux.getRight());
        aux.setRight(c);
        c.setFe(Max(GetFE(c.getLeft()),GetFE(c.getRight()))+1);
        aux.setFe(Max(GetFE(aux.getLeft()),GetFE(aux.getRight()))+1);
        return aux;
    }
    
    /**
     * Este método rota un nodo a la derecha de forma simple.
     * @param c Nodo que se va a rotar.
     * @return NodeAVL El nodo rotado.
     */
    public NodeAVL RightRotation(NodeAVL c) {
        NodeAVL aux = c.getRight();
        c.setRight(aux.getLeft());
        aux.setLeft(c);
        c.setFe(Max(GetFE(c.getLeft()),GetFE(c.getRight()))+1);
        aux.setFe(Max(GetFE(aux.getLeft()),GetFE(aux.getRight()))+1);
        return aux;
    }
    
    /**
     * Este método rota un nodo a la izquierda de forma doble.
     * @param c Nodo que se va a rotar.
     * @return NodeAVL El nodo rotado.
     */
    public NodeAVL LeftRotation1(NodeAVL c){
        NodeAVL aux;
        c.setLeft(RightRotation(c.getLeft()));
        aux= LeftRotation(c);
        return aux;
    }
    
    /**
     * Este método rota un nodo a la derecha de forma doble.
     * @param c Nodo que se va a rotar.
     * @return NodeAVL El nodo rotado.
     */
    public NodeAVL RightRotation1(NodeAVL c){
        NodeAVL aux;
        c.setRight(LeftRotation(c.getRight()));
        aux= RightRotation(c);
        return aux;
    }
    
    /**
     * Este método inserta un nuevo nodo en el arbol.
     * @param data Número que se le va a asignar al nodo que se insertará en el arbol. 
     */
    private NodeAVL Auxinsert(NodeAVL x, int data) {
        NodeAVL nuevo= new NodeAVL(data);
        if (x == null){
            return nuevo;
        } 
            
        
        if (data < x.getData()) {
            x.setLeft(Auxinsert(x.getLeft(),data)); 
        }
        else if (data > x.getData()) {
            x.setRight(Auxinsert(x.getRight(),data)); 
        }
        else {
            JOptionPane.showMessageDialog(null,"El elemento ya se encuentra");
        }
        x.setFe(1 + Math.max(GetFE(x.getLeft()), GetFE(x.getRight()))); 
        return balance(x);
    }
    public void insert(int data) {
        root = Auxinsert(root, data);
    }
    
    /**
     * Este método balancea el arbol.
     * @param a Nodo que se va a rotar para balancear el arbol.
     * @return NodeAVL Nodo que se va a rotar para balancear el arbol.
     */
    public NodeAVL balance(NodeAVL a){
        if (a==null) {
            return a;
        }
        if (GetFE(a.getLeft())-GetFE(a.getRight())>1) {
            if (GetFE(a.getLeft().getLeft())>= GetFE(a.getLeft().getRight())) {
                a=LeftRotation(a);
            }else{
                a=LeftRotation1(a);
            }
        }else{
            if (GetFE(a.getRight())-GetFE(a.getLeft())>1) {
                if (GetFE(a.getRight().getRight())>= GetFE(a.getRight().getLeft())){
                    a=RightRotation(a);
                }else{
                    a=RightRotation1(a);
                }
                
            }
        }
        a.setFe(Math.max(GetFE(a.getLeft()),GetFE(a.getRight()))+1);
        return a;
    }
   
    
    /**
     * Este método devuelve el nodo que tenga el valor numérico más bajo.
     * @param node Nodo que se va a comparar.
     * @return NodeAVL El nodo con valor numérico más bajo del arbol.
     */
    public NodeAVL Min(NodeAVL n) {
        if (n.getLeft() == null) {
            return n;
        } else {
            return Min(n.getLeft());
        }
    }
    /**
     * Este metodo elimina el nodo minimo del arbol
     * @param x la raiz del arbol
     * @return balance(x) retorna x balanceada
     */
    public NodeAVL deleteMin(NodeAVL x) {
        if (x.getLeft() == null) return x.getRight();
        x.setLeft(deleteMin(x.getLeft()));
        
        x.setFe(1 + Math.max(GetFE(x.getLeft()), GetFE(x.getRight()))); 
        return balance(x);
    }
    /**
     * Este método es un auxiliar de eliminar, que elimina y balancea el arbol.
     * @param val Número que representa el valor del nodo que se desea eliminar.
     * @param x  raiz de subarbol.
     * @return balance(x) la funcion balance de x.
     */
    
    public NodeAVL auxdelete(NodeAVL x, int val) {
        if (x==null) {
            
        }
        else if (val < x.getData()) {
            x.setLeft(auxdelete(x.getLeft(), val)); 
        }
        else if (val > x.getData()) {
            x.setRight(auxdelete(x.getRight(), val)); 
        }
        else {
            if (x.getLeft() == null) {
                return x.getRight();
            }
            else if (x.getRight() == null) {
                return x.getLeft();
            }
            else {
                NodeAVL y = x;
                x =Min(y.getRight());
                x.setRight(deleteMin(y.getRight())); 
                x.setLeft(y.getLeft()); 
            }
        }
        
        x.setFe(1 + Math.max(GetFE(x.getLeft()), GetFE(x.getRight()))); 
        return balance(x);
    }  
    /**
     * Esta funcion llama a la funcion aux delete.
     * @param val valor que se desea eliminar 
     */
    public void delete(int val) {
        root = auxdelete(root, val);
    }
    
    /**
     * Este método imprime en la consola el arbol en preorden.
     * @param root Nodo que representa la raiz del arbol.
     */
    public void printPreorder(NodeAVL root) {
        System.out.println(root.getData());
        if (root.getLeft() != null) {
            printPreorder(root.getLeft());
        }
        if (root.getRight() != null) {
            printPreorder(root.getRight());

        }
    }

    /**
     * Este método imprime en la consola el arbol en postorden.
     * @param root Nodo que representa la raiz del arbol.
     */
    public void printPostorder(NodeAVL root) {

        if (root.getLeft() != null) {
            printPostorder(root.getLeft());
        }

        if (root.getRight() != null) {
            printPostorder(root.getRight());

        }
        System.out.println(root.getData());
    }

    /**
     * Este método imprime en la consola el arbol en  inorden.
     * @param root Nodo que representa la raiz del arbol.
     */
    public void printInorder(NodeAVL root) {

        if (root.getLeft() != null) {
            printInorder(root.getLeft());

        }
        System.out.println(root.getData());
        if (root.getRight() != null) {
            printInorder(root.getRight());

        }
    }
}
