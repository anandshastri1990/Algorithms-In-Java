package search;

import org.junit.Before;
import org.junit.Test;
import util.BinarySearchTree;
import util.Node;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BreadthFirstSearchTest {

    private BinarySearchTree binarySearchTree;

    private BreadthFirstSearch breadthFirstSearch;

    @Before
    public void setup() {
        breadthFirstSearch = new BreadthFirstSearch();
        int[] list = {5, 6, 3, 1, 2, 0, 4};
        binarySearchTree = new BinarySearchTree(list);
    }

    @Test
    public void getNode_returnsNode() {
        Node output = breadthFirstSearch.getNode(binarySearchTree, 1);
        assertThat(output.getValue()).isEqualTo(1);
        assertThat(output.getLeftNode().getValue()).isEqualTo(0);
        assertThat(output.getRightNode().getValue()).isEqualTo(2);
    }

    @Test
    public void getNode_forBstCreatedUsingAdd() {
        BinarySearchTree bt = new BinarySearchTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        assertThat(breadthFirstSearch.getNode(bt, 9).getValue()).isEqualTo(9);
    }



}