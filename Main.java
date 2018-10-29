

class BinaryTree<T extends Comparable<T>> {
    class Node {
        T data;
        Node left;
        Node right;

        Node() {
            data = null;
            left = null;
            right = null;
        }

        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }

    private Node root;

    //получение корня
    public BinaryTree(T data) {
        root = new Node(data);
    }

    public Node getBinaryTree() {
        return root;
    }

    //добавление узла
    private void addNode(Node newNode, Node root) {
        if (newNode.data.compareTo(root.data) >= 0) {
            if (root.right != null)
                addNode(newNode, root.right);
            else
                root.right = newNode;
        } else {
            if (root.left != null)
                addNode(newNode, root.left);
            else
                root.left = newNode;
        }
    }

    public void addNode(T data) {
        addNode(new Node(data), getBinaryTree());
    }

    private boolean search(Node current, T goal) {
        if (current == null) {
            System.out.println("Такой вершины нет");
            return false;

        } else {
            if (current.data.compareTo(goal) == 0) {
                System.out.println("Вершина " + goal + " найдена");
                return true;
            }
            if (current.data.compareTo(goal) > 0) {
                search(current.left, goal);
            }
            if (current.data.compareTo(goal) < 0) {
                search(current.right, goal);
            }
        }
        return false;

    }

    //поиск
    public boolean search(T goal) {
        return search(root, goal);
    }

    // Левый-корень-правый
    private void inOrderPrint(Node root) {
        if (root == null)
            return;
        inOrderPrint(root.left);
        System.out.print(root.data + " | ");
        inOrderPrint(root.right);
    }

    public void inOrderPrint() {
        inOrderPrint(root);
    }

    //Корень-левый-правый
    private void preOrderPrint(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " | ");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    public void preOrderPrint() {
        preOrderPrint(root);
    }

    //Левый-правый-корень
    private void postOrderPrint(Node root) {
        if (root == null)
            return;
        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.print(root.data + " | ");
    }

    public void postOrderPrint() {
        postOrderPrint(root);
    }

    private Node remove(Node t, T key) {
        if (t == null)
            return t;
        if (t.data.compareTo(key) > 0)
            remove(t.left, key);
        else if (t.data.compareTo(key) < 0)
            remove(t.right, key);
        else if (t.left != null && t.right != null) {
            Node m = t.right;
            while (m.left != null)
                m = m.left;
            t.data = m.data;
            if (t.right != null)
                t.right = m.right;
            t.right = remove(t.right, (T) t.data);
        } else if (t.left != null) {
            System.out.println(t.data);
            t.data = t.left.data;
            t.right = t.left.right;
            t.left = t.left.left;
            System.out.println(t.data);

        } else {
            t.data = t.right.data;
            t.left = t.right.left;
            t.right = t.right.right;
        }
        return t;
    }

    public Node remove(T key) {
        return remove(root, key);
    }
}

public class Main {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree(10);

        bt.addNode(2);
        bt.addNode(1);
        bt.addNode(11);
        bt.addNode(13);
        bt.addNode(3);
        bt.addNode(12);
        bt.addNode(14);

        System.out.println(":::::::::::ЦЛП:::::::::::");
        bt.preOrderPrint();
        System.out.println();
        System.out.println(":::::::::::ЛЦП:::::::::::");
        bt.inOrderPrint();
        System.out.println();
        System.out.println(":::::::::::ЛПЦ:::::::::::");
        bt.postOrderPrint();
        bt.search(42);
        bt.search(11);
        People p = new People("Дроздова");
        BinaryTree group = new BinaryTree(p);
        group.addNode((new People("Дубовик")));
        group.addNode((new People("Качицкая")));
        group.addNode((new People("Копочель")));
        group.addNode((new People("Князева")));
        System.out.println("По порядку");
        group.inOrderPrint();
        group.remove(new People("Качицкая"));
        System.out.println("По порядку");
        group.inOrderPrint();
        group.remove(new People("А такого человека нет"));
        System.out.println("По порядку");
        group.inOrderPrint();

    }
}

class People implements Comparable<People> {
    private String name;

    public People(String newname) {
        name = newname;
    }


    public String getName() {
        return name;
    }

    public int compareTo(People other) {
        return name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}