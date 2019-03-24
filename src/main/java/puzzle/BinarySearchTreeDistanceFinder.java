package puzzle;

import util.*;

class BinarySearchTreeDistanceFinder {

    int findDistance(int[] list, int key1, int key2) {
        BinarySearchTree bst = new BinarySearchTree(list);

        if (!bst.contains(key1)) {
            return -1;
        }

        if (!bst.contains(key2)) {
            return -1;
        }

        if (key1 == key2) {
            return 0;
        }

        int lowerKey = key1 < key2 ? key1 : key2;
        int upperKey = key1 < key2 ? key2 : key1;

        Node commonNode;
        if (lowerKey < bst.getParentNode().getValue() && upperKey > bst.getParentNode().getValue()) {
            commonNode = bst.getParentNode();
        } else {
            commonNode = findCommonNode(bst.getParentNode(), lowerKey, upperKey);
        }

        return getDistanceBetweenNodes(commonNode, lowerKey) + getDistanceBetweenNodes(commonNode, upperKey);
    }

    private Node findCommonNode(Node parentNode, int key1, int key2) {
        Node pointer = parentNode;
        while (pointer != null) {
            if (pointer.getValue() > key1) {
                pointer = pointer.getLeftNode();
            } else {
                pointer = pointer.getRightNode();
            }

            if (pointer.getValue() > key1 && pointer.getValue() < key2) {
                return pointer;
            }
        }

        return null;
    }

    private int getDistanceBetweenNodes(Node startPoint, int key) {
        int distance = 0;
        Node pointer = startPoint;
        while (pointer != null && pointer.getValue() != key) {
            distance++;
            if (pointer.getValue() < key) {
                pointer = pointer.getRightNode();
            } else if (pointer.getValue() > key) {
                pointer = pointer.getLeftNode();
            }
        }

        return distance;
    }

}
