package BinaryTrees;

public class DistanceNode {

    private int distance;
    private DistanceNode left;
    private DistanceNode right;

    public DistanceNode(int distance){
        this.distance = distance;
        left = null;
        right = null;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public DistanceNode getLeft() {
        return left;
    }

    public void setLeft(DistanceNode left) {
        this.left = left;
    }

    public DistanceNode getRight() {
        return right;
    }

    public void setRight(DistanceNode right) {
        this.right = right;
    }
}
