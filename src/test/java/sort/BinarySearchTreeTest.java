package sort;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;

    @Before
    public void setup() {
        binarySearchTree = new BinarySearchTree();
    }

    @Test
    public void findDistance_bothElementsOnSameSide() {
        int[] list = {5, 6, 3, 1, 2, 4};
        assertThat(binarySearchTree.findDistance(list, 2, 4)).isEqualTo(3);
    }

    @Test
    public void findDistance_elementsOnEitherSideOfParent() {
        int[] list = {5, 6, 3, 1, 2, 4};
        assertThat(binarySearchTree.findDistance(list, 2, 6)).isEqualTo(4);
    }

    @Test
    public void findDistance_secondElementMissing() {
        int[] list = {5, 6, 3, 1, 2, 4};
        assertThat(binarySearchTree.findDistance(list, 2, 60)).isEqualTo(-1);
    }

    @Test
    public void findDistance_firstElementMissing() {
        int[] list = {5, 6, 3, 1, 2, 4};
        assertThat(binarySearchTree.findDistance(list, 28, 6)).isEqualTo(-1);
    }

    @Test
    public void findDistance_bothElementMissing() {
        int[] list = {5, 6, 3, 1, 2, 4};
        assertThat(binarySearchTree.findDistance(list, 99, 30)).isEqualTo(-1);
    }

    @Test
    public void findDistance_bothElementsOnSameSideMultipleCommonNode() {
        int[] list = {5, 6, 3, 1, 2, 0, 4};
        assertThat(binarySearchTree.findDistance(list, 0, 2)).isEqualTo(2);
    }
}