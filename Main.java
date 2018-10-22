/*
Binary Tree Implementation In Java
 */
class Node<T extends  Number>{
    public T data;
    public Node<T> left;
    public Node<T> right;

    //Initializing the Node
    Node(T data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
    //Node Creation
    Node(T data,Node<T> left,Node<T> right){
        this.data=data;
        this.left=left;
        this.right=right;
    }
}
class BinaryTree<T extends Number>{
    Node<T> root;

    //Getting the Root Node
    public BinaryTree(T data){
        root= new Node<T>(data);
    }
    //Returning the Root Node
    public Node getBinaryTree(){
        return root;
    }
    //Adding New Nodes
    public void addNode(Node newNode, Node root){
        if(newNode.data.doubleValue()>root.data.doubleValue()){
            if(root.right!=null)
                addNode(newNode,root.right);
            else
                root.right=newNode;
        }
        else{
            if(root.left!=null)
                addNode(newNode,root.left);
            else
                root.left=newNode;
        }
    }
    public void Search(Node current, T goal)
    {
        if(current==null)
        {
            System.out.println("Такой вершины нет");
        }
        else {
            if (current.data.doubleValue()<goal.doubleValue()) {
                System.out.println("Найдена");
            }
            if (current.data.doubleValue() < goal.doubleValue()) {
                Search(current.left, goal);
            }
            if (current.data.doubleValue() > goal.doubleValue()) {
                Search(current.right, goal);
            }
        }

    }
    // In Order Traversal
    public void inOrderPrint(Node root){
        if(root==null)
            return;
        inOrderPrint(root.left);
        System.out.print(root.data+" | ");
        inOrderPrint(root.right);
    }
    //Pre Order Traversal
    public void preOrderPrint(Node root){
        if(root==null)
            return;
        System.out.print(root.data+" | ");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }
    //Post Order Traversal
    public void postOrderPrint(Node root){
        if(root==null)
            return;
        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.print(root.data+" | ");
    }
}
public class Main{
    public static void main(String[] args){

        //Root Node
        BinaryTree bt = new BinaryTree<Integer>(10);

        bt.addNode(new Node(2),bt.getBinaryTree());
        bt.addNode(new Node(1),bt.getBinaryTree());
        bt.addNode(new Node(11),bt.getBinaryTree());
        bt.addNode(new Node(13),bt.getBinaryTree());
        bt.addNode(new Node(3),bt.getBinaryTree());
        bt.addNode(new Node(12),bt.getBinaryTree());
        bt.addNode(new Node(14),bt.getBinaryTree());

        System.out.println(":::::::::::Pre Order Traversal:::::::::::");
        bt.preOrderPrint(bt.getBinaryTree());

        System.out.println();
        System.out.println(":::::::::::In Order Traversal:::::::::::");
        bt.inOrderPrint(bt.getBinaryTree());

        System.out.println();
        System.out.println(":::::::::::Post Order Traversal:::::::::::");
        bt.postOrderPrint(bt.getBinaryTree());
        bt.Search(bt.root, 42);
        bt.Search(bt.root, 11);
    }
}