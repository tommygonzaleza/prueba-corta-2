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
   
    
    
    public NodeAVL(int d){
        this.data=d;
        this.fe=0;
        this.left=null;
        this.right=null;
        
    }
        

    /**
     * @return the left
     */
    public NodeAVL getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(NodeAVL left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public NodeAVL getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(NodeAVL right) {
        this.right = right;
    }

    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return the fe
     */
    public int getFe() {
        return fe;
    }

    /**
     * @param fe the fe to set
     */
    public void setFe(int fe) {
        this.fe = fe;
    }
}
