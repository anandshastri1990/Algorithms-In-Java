package search;

import util.BinarySearchTree;
import util.Node;

import java.util.ArrayList;

public class BreadthFirstSearch {

    private static int iterations;

    public Node getNode(BinarySearchTree binarySearchTree, int key) {

        iterations = 0;

        if (!binarySearchTree.contains(key)) {
            return null;
        }

        Node pointer = binarySearchTree.getParentNode();

        printTraversalOrder(pointer);

        Node output;
        output = performBfs(pointer, key);
        System.out.println("Bfs Pre-Order:  total number of iterations = " +iterations);

        return output;
    }

    private void printTraversalOrder(Node pointer) {
        iterations = 0;
        System.out.println("*********************** \nlevel-order\n----------- ");
        ArrayList<Node> nodeArrayList = new ArrayList<>();
        nodeArrayList.add(pointer);
        while(!nodeArrayList.isEmpty()) {
            iterations++;

            Node node = nodeArrayList.get(0);

            System.out.println(node.getValue() +" (iteration count = " + iterations +" )");

            nodeArrayList.remove(node);

            if (node.getLeftNode() != null) {
                nodeArrayList.add(node.getLeftNode());
            }

            if (node.getRightNode() != null) {
                nodeArrayList.add(node.getRightNode());
            }
        }
        System.out.println("\n \n");
    }

    private Node performBfs(Node pointer, int key) {
        iterations = 0;
        ArrayList<Node> nodeArrayList = new ArrayList<>();
        nodeArrayList.add(pointer);
        while(!nodeArrayList.isEmpty()) {
            iterations++;

            Node node = nodeArrayList.get(0);

            if (node.getValue() == key) {
                return node;
            }

            nodeArrayList.remove(node);

            if (node.getLeftNode() != null) {
                nodeArrayList.add(node.getLeftNode());
            }

            if (node.getRightNode() != null) {
                nodeArrayList.add(node.getRightNode());
            }
        }

        return null;
    }

}
