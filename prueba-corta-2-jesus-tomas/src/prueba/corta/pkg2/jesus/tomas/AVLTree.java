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

    public AVLTree() {
        this.root = null;

    }

    /**
     * @return the root
     */
    public NodeAVL getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(NodeAVL root) {
        this.root = root;
    }

    //Buscar
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

    public int GetFE(NodeAVL x) {
        if (x == null) {
            return -1;
        } else {
            return x.getFe();
        }
    }

    public int Max(int x, int d) {
        if (x > d) {
            return x;
        } else if (x < d) {
            return d;
        }else{
            return x;
        }
    }
    // Rotacion simple izquierda
    public NodeAVL LeftRotation(NodeAVL c) {
        NodeAVL aux = c.getLeft();
        c.setLeft(aux.getRight());
        aux.setRight(c);
        c.setFe(Max(GetFE(c.getLeft()),GetFE(c.getRight()))+1);
        aux.setFe(Max(GetFE(aux.getLeft()),GetFE(aux.getRight()))+1);
        return aux;
    }
    // Rotacion simple derecha
    public NodeAVL RightRotation(NodeAVL c) {
        NodeAVL aux = c.getRight();
        c.setRight(aux.getLeft());
        aux.setLeft(c);
        c.setFe(Max(GetFE(c.getLeft()),GetFE(c.getRight()))+1);
        aux.setFe(Max(GetFE(aux.getLeft()),GetFE(aux.getRight()))+1);
        return aux;
    }
    // Rotacion doble izquierda
    public NodeAVL LeftRotation1(NodeAVL c){
        NodeAVL aux;
        c.setLeft(RightRotation(c.getLeft()));
        aux= LeftRotation(c);
        return aux;
    }
    // Rotacion doble derecha
    public NodeAVL RightRotation1(NodeAVL c){
        NodeAVL aux;
        c.setRight(LeftRotation(c.getRight()));
        aux= RightRotation(c);
        return aux;
    }
    //Metodo para insertar AVL
    public NodeAVL insertAux(NodeAVL newNode, NodeAVL subTree){
        NodeAVL newFather=subTree;
        if(newNode.getData()<subTree.getData()){
            if (subTree.getLeft()==null) {
                subTree.setLeft(newNode);
            }else{
                subTree.setLeft(insertAux(newNode,subTree.getLeft()));
                if((GetFE(subTree.getLeft())-GetFE(subTree.getRight()))==2){
                    if (newNode.getData()<subTree.getLeft().getData()) {
                        newFather = LeftRotation(subTree);
                    }else{
                        newFather =LeftRotation1(subTree);
                    }
                }
            }
        }else if (newNode.getData()>subTree.getData()) {
            if (subTree.getRight()==null) {
                subTree.setRight(newNode);
            }else{
                subTree.setRight(insertAux(newNode,subTree.getRight()));
                if((GetFE(subTree.getRight())-GetFE(subTree.getLeft()))==2){
                    if (newNode.getData()>subTree.getRight().getData()) {
                        newFather = RightRotation(subTree);
                    }else{
                        newFather =RightRotation1(subTree);
                    }
                }
            }
            
        }else{
            System.out.println("Nodo Duplicado");
        }
        // Actualizar altura
        if (subTree.getLeft()==null && subTree.getRight()!=null) {
            subTree.setFe(subTree.getRight().getFe()+1);
        }else if(subTree.getRight()==null && subTree.getLeft()!=null){
            subTree.setFe(subTree.getLeft().getFe()+1);
        }else{
            subTree.setFe(Max(GetFE(subTree.getLeft()),GetFE(subTree.getRight()))+1);
        }
        return newFather;
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
    
    public void printPreorder(NodeAVL root) {
        System.out.println(root.getData());
        if (root.getLeft() != null) {
            printPreorder(root.getLeft());
        }
        if (root.getRight() != null) {
            printPreorder(root.getRight());

        }
    }

    public void printPostorder(NodeAVL root) {

        if (root.getLeft() != null) {
            printPostorder(root.getLeft());
        }

        if (root.getRight() != null) {
            printPostorder(root.getRight());

        }
        System.out.println(root.getData());
    }

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
