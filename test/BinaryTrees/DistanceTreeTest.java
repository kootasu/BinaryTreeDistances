package BinaryTrees;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTreeTest {

    // TODO: Many different values
    @Test
    public void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() throws IOException {
        DistanceTree distanceTree = new DistanceTree();
        distanceTree = distanceTree.createTree();
        assertTrue(distanceTree.containsNode(204));
        assertTrue(distanceTree.containsNode(167));
    }

}