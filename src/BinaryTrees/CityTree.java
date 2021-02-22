package BinaryTrees;

import java.io.IOException;
import java.util.ArrayList;

public class CityTree {

    CityNode root;

    /**
     * If current node is null, we have reached a leaf node and can insert new node here
     * If value is lower than the current node's value, we go to the left child
     * If value is greater than the current node's value, we go to the right child
     * Else, value already exists
     * @param current
     * @param cityNode
     * @return
     */
    private CityNode addRecursive(CityNode current, CityNode cityNode) {
        if (current == null){
            return new CityNode(cityNode.getName(), cityNode.getDistance());
        }
        if (cityNode.getDistance() < current.getDistance()){
            current.setLeft(addRecursive(current.getLeft(), cityNode));
        }
        else if (cityNode.getDistance() > current.getDistance()){
            current.setRight(addRecursive(current.getRight(), cityNode));
        }
        else {
            return current;
        }
        return current;
    }

    /**
     * Starts recursion from root node
     * @param cityNode
     */
    public void add(CityNode cityNode) {
        root = addRecursive(root, cityNode);
    }

    public CityTree createTree() throws IOException {
        CityTree cityTree = new CityTree();
        SheetReader sheetReader = new SheetReader();
        ArrayList<CityNode> cityNodes = sheetReader.createCityNodes("DistancesInJylland-kopi.xls");
        for (CityNode cityNode : cityNodes) {
            cityTree.add(cityNode);
        }
        return cityTree;
    }

    private boolean containsNodeRecursive(CityNode current, int distance) {
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

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    // TODO: Delete method

    /**
     * Visits the left subtree, then the root node, then the right subtree
     * @param cityNode
     */
    public void traverseInOrder(CityNode cityNode) {
        if (cityNode != null) {
            traverseInOrder(cityNode.getLeft());
            System.out.println(cityNode.getName() + ", " + cityNode.getDistance());
            traverseInOrder(cityNode.getRight());
        }
    }

    /**
     * Visits the root node, then the left subtree, then the right subtree
     * @param cityNode
     */
    public void traversePreOrder(CityNode cityNode) {
        if (cityNode != null) {
            System.out.println(cityNode.getName() + ", " + cityNode.getDistance());
            traversePreOrder(cityNode.getLeft());
            traversePreOrder(cityNode.getRight());
        }
    }

    /**
     * Visits the right subtree, then the root node, then the left subtree
     * @param cityNode
     */
    public void traversePostOrder(CityNode cityNode) {
        if (cityNode != null) {
            System.out.println(cityNode.getName() + ", " + cityNode.getDistance());
            traversePostOrder(cityNode.getRight());
            traversePreOrder(cityNode.getLeft());
        }
    }

}
