/*
Binary Tree Implementation In Java
 */
class Node<T extends  Comparable<T>>{
    T data;
    Node<T> left;
    Node<T> right;

    //Initializing the Node
    Node()
    {
        data=null;
        left=null;
        right=null;
    }
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
class BinaryTree<T extends Comparable<T>>{
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
        if(newNode.data.compareTo(root.data)>0){
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
    public Node search(Node current, T goal)
    {
        if(current==null)
        {
            System.out.println("Такой вершины нет");
            return null;

        }
        else {
            if (current.data.compareTo(goal)==0) {
                System.out.println("Вершина "+goal+" найдена");
                return current;
            }
            if (current.data.compareTo(goal)>0)  {
                search(current.left, goal);
            }
            if (current.data.compareTo(goal)<0)  {
                search(current.right, goal);
            }
        }
        return null;

    }
    // In Order Traversal
    public void inOrderPrint(Node root){
        if(root==null)
            return;
        inOrderPrint(root.left);

        System.out.print(root.data+" | ");
        if(root.right!=null)
        {
            System.out.println("Справа:"+root.right.data);
        }
        if(root.left!=null)
        {
            System.out.println("Слева:"+root.left.data);
        }
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
    public Node remove(Node t, T key) {
        System.out.println(t.data);
        if (t == null)
            return t;
        if (t.data.compareTo(key)>0)
            remove(t.left, key);
        else if (t.data.compareTo(key)<0)
            remove(t.right, key);
        else if (t.left != null && t.right != null) {
            Node<T> m =t.right;
            while (m.left != null)
                m = m.left;
            t.data=m.data;
            if(t.right!=null)
            t.right=m.right;
            t.right=remove(t.right, (T)t.data);
        } else if (t.left != null) {
            System.out.println(t.data);
            t.data=t.left.data;
            t.right=t.left.right;
            t.left=t.left.left;
            System.out.println(t.data);

        } else  {
            t.data=t.right.data;
            t.left=t.right.left;
            t.right=t.right.right;

        }
        return t;
    }
}
public class Main{
    public static void main(String[] args){

        //Root Node
        BinaryTree bt = new BinaryTree(10);

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
        bt.search(bt.root, 42);
        bt.search(bt.root, 11);
        People p=new People("Дроздова");
        BinaryTree group=new BinaryTree(p);
        group.addNode(new Node(new People("Дубовик")),group.getBinaryTree());
        group.addNode(new Node(new People("Качицкая")),group.getBinaryTree());
        group.addNode(new Node(new People("Копочель")),group.getBinaryTree());
        group.addNode(new Node(new People("Князева")),group.getBinaryTree());
        group.inOrderPrint(group.getBinaryTree());
        group.remove(group.getBinaryTree(), new People("Качицкая"));
        group.inOrderPrint(group.getBinaryTree());

    }
}
class People implements Comparable<People>
{
    private String name;
    public People(String n)
    {
       name=n;
    }


    public String getName()
    {
        return name;
    }
    public int compareTo(People x)
    {
        return name.compareTo(x.getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}