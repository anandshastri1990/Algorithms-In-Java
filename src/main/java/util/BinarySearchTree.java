package util;

public class BinarySearchTree {

    private Node parentNode;

    public BinarySearchTree(int[] list) {
        this.parentNode = new Node(list[0], null, null);
        for (int i = 1; i < list.length; i++) {
            Node pointer = parentNode;

            while (pointer.getValue() != null) {
                if (pointer.getValue() > list[i]) {
                    if (pointer.getLeftNode() == null) {
                        pointer.setLeftNode(new Node(list[i], null, null));
                        break;
                    } else {
                        pointer = pointer.getLeftNode();
                    }
                } else {
                    if (pointer.getRightNode() == null) {
                        pointer.setRightNode(new Node(list[i], null, null));
                        break;
                    } else {
                        pointer = pointer.getRightNode();
                    }
                }
            }
        }
    }

    public BinarySearchTree() {
        this.parentNode = new Node(null, null, null);
    }

    public Node getParentNode() {
        return parentNode;
    }

    public boolean contains(int key) {
        return findRecursively(this.parentNode, key);
    }

    public Node add(int key) {
        Node pointer = this.parentNode;

        if (pointer.getValue() == null) {
            pointer.setValue(key);

            return pointer;
        }
        while (true) {
            if (key < pointer.getValue()) {
                if (pointer.getLeftNode() == null) {
                    break;
                } else {
                    pointer = pointer.getLeftNode();
                }
            } else if ( key > pointer.getValue()) {
                if (pointer.getRightNode() == null) {
                    break;
                } else {
                    pointer = pointer.getRightNode();
                }
            } else {
                break;
            }
        }

        if (key < pointer.getValue()) {
            pointer.setLeftNode(new Node(key, null, null));
        } else if (key > pointer.getValue()) {
            pointer.setRightNode(new Node(key, null, null));
        }

        return pointer;
    }

    private boolean findRecursively(Node pointer, int key) {
        if (pointer == null) {
            return false;
        }

        if (pointer.getValue() == key) {
            return true;
        }

        if (key < pointer.getValue()) {
            return findRecursively(pointer.getLeftNode(), key);
        } else {
            return findRecursively(pointer.getRightNode(), key);
        }
    }
}
