public class LinkedBST<T extends Comparable<T>> {

    // compareTo(Comparable) = int -1 0 1
    // C++ strcmp
    private class Node {
        T data;
        Node leftChild;
        Node rightChild;

        public Node(T aData) {
            data = aData;
            leftChild = rightChild = null;
        }
    }

    private Node root; // head of the tree

    public LinkedBST() {
        root = null;

    }

    public void add(T aData)// Callable method
    {
        if (root == null) {
            root = new Node(aData);
        } else
            add(root, aData);
    }

    private Node add(Node aNode, T aData)// recursive method
    {
        if (aNode == null)// we found a leaf
            aNode = new Node(aData);
        else if (aData.compareTo(aNode.data) < 0)// Go Left
            aNode.leftChild = add(aNode.leftChild, aData);
        else if (aData.compareTo(aNode.data) > 0)// Go Right
            aNode.rightChild = add(aNode.rightChild, aData);
        return aNode;
    }

    public void printPreorder() {
        printPreorder(root);
    }

    private void printPreorder(Node aNode) {
        if (aNode == null)
            return;
        System.out.println(aNode.data);// Process
        printPreorder(aNode.leftChild);// LEFT
        printPreorder(aNode.rightChild);// RIGHT
    }

    public void printInorder() {
        printInorder(root);
    }

    private void printInorder(Node aNode) {
        if (aNode == null)
            return;
        printInorder(aNode.leftChild);// LEFT
        System.out.println(aNode.data);// Process
        printInorder(aNode.rightChild);// RIGHT
    }

    public boolean search(T aData) {
        return search(root, aData);
    }

    private boolean search(Node aNode, T aData) {
        if (aNode == null)// leaf
            return false;
        else if (aData.compareTo(aNode.data) < 0)// Left
            return search(aNode.leftChild, aData);
        else if (aData.compareTo(aNode.data) > 0)// Right
            return search(aNode.rightChild, aData);
        else
            return true;
    }

    public void remove(T aData) {
        root = remove(root, aData);
    }

    private Node remove(Node aNode, T aData) {
        // Search
        if (aNode == null)
            return null;// aData was not found
        else if (aData.compareTo(aNode.data) < 0)
            aNode.leftChild = remove(aNode.leftChild, aData);
        else if (aData.compareTo(aNode.data) > 0)
            aNode.rightChild = remove(aNode.rightChild, aData);
        else// We found it!!! Destroy it!
        { // Case 0. Case 1/2 of Case 1
            if (aNode.rightChild == null)
                return aNode.leftChild;
            else if (aNode.leftChild == null)// Other 1/2 of Case 1
                return aNode.rightChild;
            // If we reach here it's case 2
            // Find the min in the right sub tree
            Node temp = findMinInTree(aNode.rightChild);
            aNode.data = temp.data;
            aNode.rightChild = remove(aNode.rightChild, temp.data);// removes dup

        }
        return aNode;
    }

    private Node findMinInTree(Node aNode) {
        if (aNode == null)
            return null;
        else if (aNode.leftChild == null)
            return aNode;
        else
            return findMinInTree(aNode.leftChild);

    }
}
