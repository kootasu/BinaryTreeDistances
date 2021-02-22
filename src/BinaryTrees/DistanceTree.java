package BinaryTrees;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.io.IOException;
import java.util.ArrayList;

public class DistanceTree {

    DistanceNode root;

    /**
     * If current node is null, we have reached a leaf node and can insert new node here
     * If distance is lower than the current node's distance, we go to the left child
     * If distance is greater than the current node's distance, we go to the right child
     * Else, distance already exists
     * @param current
     * @param distance
     * @return
     */
    private DistanceNode addRecursive(DistanceNode current, int distance) {
        if (current == null){
            return new DistanceNode(distance);
        }
        if (distance < current.getDistance()){
            current.setLeft(addRecursive(current.getLeft(), distance));
        }
        else if (distance > current.getDistance()){
            current.setRight(addRecursive(current.getRight(), distance));
        }
        else {
            return current;
        }
        return current;
    }

    /**
     * Starts recursion from root node
     * @param distance
     */
    public void add(int distance) {
        root = addRecursive(root, distance);
    }

    public DistanceTree createTree() throws IOException {
        DistanceTree distanceTree = new DistanceTree();
        SheetReader sheetReader = new SheetReader();
        ArrayList<DistanceNode> distanceNodes = sheetReader.createDistanceNodes("DistancesInJylland-kopi.xls");
        for (DistanceNode distanceNode : distanceNodes) {
            distanceTree.add(distanceNode.getDistance());
        }
        return distanceTree;
    }


    private boolean containsNodeRecursive(DistanceNode current, int distance) {
        if (current == null) {
            return false;
        }
        if (distance == current.getDistance()) {
            return true;
        }
        return distance < current.getDistance()
                ? containsNodeRecursive(current.getLeft(), distance)
                : containsNodeRecursive(current.getRight(), distance);
    }

    public boolean containsNode(int distance) {
        return containsNodeRecursive(root, distance);
    }


    // TODO: Delete method

    /**
     * Visits the left subtree, then the root node, then the right subtree
     * @param distanceNode
     */
    public void traverseInOrder(DistanceNode distanceNode) {
        if (distanceNode != null) {
            traverseInOrder(distanceNode.getLeft());
            System.out.print(" " + distanceNode.getDistance());
            traverseInOrder(distanceNode.getRight());
        }
    }

    /**
     * Visits the root node, then the left subtree, then the right subtree
     * @param distanceNode
     */
    public void traversePreOrder(DistanceNode distanceNode) {
        if (distanceNode != null) {
            System.out.print(" " + distanceNode.getDistance());
            traversePreOrder(distanceNode.getLeft());
            traversePreOrder(distanceNode.getRight());
        }
    }

    /**
     * Visits the right subtree, then the root node, then the left subtree
     * @param distanceNode
     */
    public void traversePostOrder(DistanceNode distanceNode) {
        if (distanceNode != null) {
            traversePostOrder(distanceNode.getLeft());
            traversePostOrder(distanceNode.getRight());
            System.out.print(" " + distanceNode.getDistance());
        }
    }

}
