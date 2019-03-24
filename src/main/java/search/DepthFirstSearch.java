package search;

import util.BinarySearchTree;
import util.Node;
import util.Stack;

import java.util.ArrayList;

public class DepthFirstSearch {

    private static int iterations;

    public Node getNode(BinarySearchTree binarySearchTree, int key) {

        iterations = 0;

        if (!binarySearchTree.contains(key)) {
            return null;
        }

        Node pointer = binarySearchTree.getParentNode();

        printTraversalOrder(pointer);

        Node output;

        output = performDfsPreOrder(pointer, key);
        System.out.println("Dfs Pre-Order:  total number of iterations = " +iterations);

        return output;
    }

    private Node performDfsPreOrder(Node pointer, int key) {
        iterations = 0;

        Stack stack = new Stack();
        ArrayList<Node> visited = new ArrayList<>();
        stack.push(pointer);

        while(!stack.empty()) {
            iterations++;

            Node node = (Node) stack.peek();

            if (node.getValue() == key) {
                return node;
            }

            if (node.getLeftNode() != null && !visited.contains(node.getLeftNode())) {
                stack.push(node.getLeftNode());
                visited.add(node.getLeftNode());
            } else if (node.getRightNode() != null && !visited.contains(node.getRightNode())) {
                stack.push(node.getRightNode());
                visited.add(node.getRightNode());
            } else {
                stack.pop();
            }
        }

        return null;
    }

    private void traverseInPreOrder(Node node) {
        iterations++;
        if (node == null) {
            return;
        }

        System.out.println(node.getValue() +" (iteration count = " + iterations +" )");
        traverseInPreOrder(node.getLeftNode());
        traverseInPreOrder(node.getRightNode());
    }

    private void traverseInOrder(Node node) {
        iterations++;
        if (node == null) {
            return;
        }

        traverseInOrder(node.getLeftNode());
        System.out.println(node.getValue() +" (iteration count = " + iterations +" )");
        traverseInOrder(node.getRightNode());
    }

    private void traverseInPostOrder(Node node) {
        iterations++;

        if (node == null) {
            return;
        }

        traverseInPostOrder(node.getLeftNode());
        traverseInPostOrder(node.getRightNode());
        System.out.println(node.getValue() +" (iteration count = " + iterations +" )");
    }

    private void printTraversalOrder(Node pointer) {
        iterations = 0;
        System.out.println("*********************** \nIn Order\n----------- ");
        traverseInOrder(pointer);
        System.out.println("\n \n");

        iterations = 0;
        System.out.println("*********************** \nPre Order\n----------- ");
        traverseInPreOrder(pointer);
        System.out.println("\n \n");

        iterations = 0;
        System.out.println("*********************** \nPost Order\n----------- ");
        traverseInPostOrder(pointer);
        System.out.println("\n \n");
    }
}
