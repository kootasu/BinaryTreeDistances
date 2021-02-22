package BinaryTrees;

import java.io.IOException;

public class Grow {

    public static void main(String[] args) throws IOException {

        // Binary tree – DistanceNode only has distance value
        System.out.println("\n************* Binary tree of nodes with only distances *************\n");

        DistanceTree distanceTree = new DistanceTree();
        distanceTree = distanceTree.createTree();

        System.out.println("In-order traversal:");
        distanceTree.traverseInOrder(distanceTree.root);
        System.out.println("\n");

        System.out.println("Pre-order traversal:");
        distanceTree.traversePreOrder(distanceTree.root);
        System.out.println("\n");

        System.out.println("Post-order traversal:");
        distanceTree.traversePostOrder(distanceTree.root);
        System.out.println("\n");

        // Binary tree with CityNodes containing both distances and names
        System.out.println("\n************* Binary tree of nodes with both distances and names *************\n");

        CityTree cityTree = new CityTree();
        cityTree = cityTree.createTree();

        System.out.println("In-order traversal:");
        cityTree.traverseInOrder(cityTree.root);
        System.out.println("\n");

        System.out.println("Pre-order traversal:");
        cityTree.traversePreOrder(cityTree.root);
        System.out.println("\n");

        System.out.println("Post-order traversal:");
        cityTree.traversePostOrder(cityTree.root);
        System.out.println("\n");
    }
}
