package BinaryTrees;

public class CityNode {

    private String name;
    private int distance;
    private CityNode left;
    private CityNode right;

    public CityNode (String name, int distance){
        this.name = name;
        this.distance = distance;
        left = null;
        right = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public CityNode getLeft() {
        return left;
    }

    public void setLeft(CityNode left) {
        this.left = left;
    }

    public CityNode getRight() {
        return right;
    }

    public void setRight(CityNode right) {
        this.right = right;
    }
}
