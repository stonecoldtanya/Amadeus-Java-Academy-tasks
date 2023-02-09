package shapeoop;

import java.util.List;

public class App {
    public static void calculateAndCheckShapes(List<Shape> shapes, Point toCheck) {
        for (int i = 0; i < shapes.size(); i++){
            System.out.print(shapes.get(i).area() + " ");
            System.out.print(shapes.get(i).circumference());
            System.out.println();
        }
        if (Shape.allContain(shapes, toCheck)){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
