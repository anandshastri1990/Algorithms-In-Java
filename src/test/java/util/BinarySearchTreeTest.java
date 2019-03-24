package util;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;

    @Before
    public void setup() {
        int[] list = {5, 6, 3, 1, 2, 4};
        binarySearchTree = new BinarySearchTree(list);
    }

    @Test
    public void getParentNode_returnParentNode() {
        assertThat(binarySearchTree.getParentNode().getValue()).isEqualTo(5);
        assertThat(binarySearchTree.getParentNode().getLeftNode().getValue()).isEqualTo(3);
        assertThat(binarySearchTree.getParentNode().getRightNode().getValue()).isEqualTo(6);
    }

    @Test
    public void contains_returnsTrueIfElementPresent() {
        assertThat(binarySearchTree.contains(4)).isEqualTo(true);
    }

    @Test
    public void contains_returnsFalseIfElementNotPresent() {
        assertThat(binarySearchTree.contains(99)).isEqualTo(false);
    }

    @Test
    public void add_returnsNewlyAddedNode() {
        binarySearchTree.add(0);

        assertThat(binarySearchTree.contains(0)).isEqualTo(true);
    }
}