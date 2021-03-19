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
     * Este método devuelve el peso del nodo.
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
    
    public void insert(int data){
        NodeAVL newNode = new NodeAVL(data);
        if (this.root == null) {
            this.root = newNode;

        } else {
            NodeAVL nodeFather = this.SearchFather(this.root, data);
            if (nodeFather == null) {
                System.out.println("El elemento ya existe");
            } else if (nodeFather.getData() > newNode.getData()) {
                nodeFather.setLeft(newNode);
                
            } else if (nodeFather.getData() < newNode.getData()) {
                nodeFather.setRight(newNode);
               
                
            }
        }
        balance(newNode);
    }
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
    public NodeAVL SearchFather(NodeAVL root, int data) {
        NodeAVL encontrado = null;
        if (data < root.getData()) {
            if (encontrado != null) {
                return encontrado;

            } else if (root.getLeft() != null) {
                encontrado = SearchFather(root.getLeft(), data);

            } else {
                return root;
            }
        } else if (data > root.getData()) {
            if (encontrado != null) {
                return encontrado;

            } else if (root.getRight() != null) {
                encontrado = SearchFather(root.getRight(), data);

            } else {
                return root;
            }
        }
        return encontrado;
    }
    public NodeAVL Max (NodeAVL node) 
    {
        if(node.getRight()==null)
        {
            return node;
        }else
        {
        return Max(node.getRight());
        }
    }
    
    public NodeAVL Delete(int valor, NodeAVL root)
    {
        NodeAVL aux= root;
        if(valor<root.getData())
        {
            root.setLeft(Delete(valor,root.getLeft()));
        }else
        {
            if(valor > root.getData())
            {
                root.setRight((Delete(valor,root.getRight())));
            }else
            {
                if(root.getLeft()!=null && root.getRight()!=null)
                {
                    NodeAVL temp= root;
                    NodeAVL maxLeft= Max(root.getLeft());
                    root.setData(maxLeft.getData());
                    temp.setLeft(Delete(maxLeft.getData(),temp.getLeft()));
                }else
                {
                    if (root.getLeft()!=null)
                    {
                        aux=root.getLeft();
                    }else
                    {
                        if(root.getRight()!=null)
                        {
                            aux=root.getRight();
                        }else
                        {
                            aux=null;
                        }
                    }
                }
            }
        }
        balance(aux);
        return aux;  
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
