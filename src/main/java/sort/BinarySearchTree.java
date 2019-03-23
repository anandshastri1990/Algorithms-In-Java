package sort;

class BinarySearchTree {

    int findDistance(int[] list, int node1, int node2) {
        if (invalidSearch(list, node1, node2)) {
            return -1;
        }

        if (node1 == node2) {
            return 0;
        }

        Node parentNode = getBinarySearchTree(list);

        int lowerKey = node1 < node2 ? node1 : node2;
        int upperKey = node1 < node2 ? node2 : node1;

        Node commonNode;
        if (lowerKey < parentNode.getValue() && upperKey > parentNode.getValue()) {
            commonNode = parentNode;
        } else {
            commonNode = findCommonNode(parentNode, lowerKey, upperKey);
        }

        return getDistanceBetweenNodes(commonNode, lowerKey) + getDistanceBetweenNodes(commonNode, upperKey);
    }

    private boolean invalidSearch(int[] list, int node1, int node2) {
        boolean matchFoundForKey1 = false;
        boolean matchFoundForKey2 = false;

        for (int i1 : list) {
            if (i1 == node1)
                matchFoundForKey1 = true;
            if (i1 == node2)
                matchFoundForKey2 = true;
        }

        return !(matchFoundForKey1 && matchFoundForKey2);
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

    int getDistanceBetweenNodes(Node startPoint, int key) {
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

    Node getBinarySearchTree(int[] list) {
        Node parentNode = new Node(list[0], null, null);
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

        return parentNode;
    }

    class Node {
        Integer value;
        Node leftNode;
        Node rightNode;

        Node(Integer value, Node leftNode, Node rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        Integer getValue() {
            return value;
        }

        Node getLeftNode() {
            return leftNode;
        }

        void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        Node getRightNode() {
            return rightNode;
        }

        void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
    }
}
