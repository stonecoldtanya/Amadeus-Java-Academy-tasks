package EightTilePuzzle.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public final int DIMENSION = 3;
    public final String GOAL = "12345678X";
    private int depth;
    private String state;

    private final Node parent;
    private List<Node> children;

    public Node(String state, Node parent) {
        this.state = state;
        this.children = null;
        this.parent = parent;
        this.depth = depth;
    }

    public String getState() {
        return this.state;
    }

    public boolean isGoal() {
        return GOAL.equals(this.state);
    }

    public Node getParent() {
        return this.parent;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }

    private static String swap(String base, int firstPos, int secondPos) {
        char array[] = base.toCharArray();
        char temp = array[firstPos];
        array[firstPos] = array[secondPos];
        array[secondPos] = temp;
        return new String(array);
    }

    public List<Node> getChildren() {
        if (this.children == null) {

            List<Node> result = new ArrayList<Node>();
            int xPos = state.indexOf('X');

            // Move left
            if (xPos % DIMENSION != 0) {
                String childState = swap(state, xPos, xPos - 1);
                Node child = new Node(childState, this);
                result.add(child);
            }

            // Move right
            if (xPos % DIMENSION != (DIMENSION - 1)) {
                String childState = swap(state, xPos, xPos + 1);
                Node child = new Node(childState, this);
                result.add(child);
            }

            // Move up
            if (xPos / DIMENSION != 0) {
                String childState = swap(state, xPos, xPos - DIMENSION);
                Node child = new Node(childState, this);
                result.add(child);
            }

            // Move down
            if (xPos / DIMENSION != (DIMENSION - 1)) {
                String childState = swap(state, xPos, xPos + DIMENSION);
                Node child = new Node(childState, this);
                result.add(child);
            }
            this.children = result;
        }

        return this.children;
    }

    @Override
    public String toString() {
        return this.state;
    }

    @Override
    public int hashCode() {
        return this.state.hashCode();
    }


    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Node)) {
            return false;
        }

        Node otherNode = (Node) other;

        return this.state.equals(otherNode.state);
    }
}
