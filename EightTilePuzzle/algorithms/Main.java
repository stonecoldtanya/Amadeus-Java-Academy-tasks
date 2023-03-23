package EightTilePuzzle.algorithms;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String start = "85732X416";

        Puzzle puzzle = new Puzzle(start);
        System.out.printf("The puzzle is [%s]", puzzle.getRoot().getState());
        System.out.println("");

        List<Node> solution = puzzle.getSolution();
        System.out.printf("The solution is in %d steps: ", solution.size());
        System.out.println(solution);
    }
}
