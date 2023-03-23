package EightTilePuzzle.algorithms;

import com.sun.source.tree.WhileLoopTree;

import java.util.*;

public class Puzzle {
    private Node root;
    private List<Node> solution;
    private boolean isFound = false;
    private AlgorithmType type;
    int steps = 0;
    public Puzzle(String start) {
        this.root = new Node(start, null);
    }

    public void solve() {
        //if (type.equals(IDDS)) {
        //fix it for idds since rn it's dls - TO DO
        int maxDepth = 21111;
        int counter = 0;
       // while(!isFound){
            for (int i = 1; i <= maxDepth; i++){
                dfs(i, maxDepth);
                counter++;
                if (isFound){
                    break;
                }
         //   }
        }
        if (counter > maxDepth){
            System.out.println("Solution is NOT found");
        }
    }

    private void aStar(){

    }

    private void dfs(int depth, int maxDepth){
        Stack<Node> stack = new Stack<>();
        TreeMap<Integer, Node> reviewedTwo = new TreeMap<>();
        HashSet<Node> reviewed = new HashSet<>();
        root.setDepth(0);
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (reviewed.contains(current)) {
                continue;
            }
//            if (reviewedTwo.containsKey(current)){
//                int existing = reviewedTwo.;
//            }
            reviewed.add(current);
            steps += 1;
//            if (current.getDepth() <= depth){
//                continue;
//            }

            if (current.isGoal()) {
                writeDown(current);
                this.isFound = true;
                System.out.println(steps);
                return;
            }

            List<Node> children = current.getChildren();
                for (Node child : children) {
                    child.setDepth(current.getDepth() + 1);
                    if (child.getDepth() > depth) {
                        break;
                    }
                    stack.push(child);
//                    steps += 1;
                }
            }
    }


    public Node getRoot() {
        return this.root;
    }

    public List<Node> getSolution() {
        if (this.solution == null) {
            solve();
        }
        return this.solution;
    }

    private void writeDown(Node solved) {
        List<Node> solution = new ArrayList<>();

        Node current = solved;
        int counter = 0;
        while (current != null) {
            solution.add(0, current);
            //counter++;
            current = current.getParent();
        }

        this.solution = solution;
    }
}
