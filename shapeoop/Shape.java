package shapeoop;

import java.util.List;

public abstract class Shape{
    public Point center;
    //u can make a constructor in an abstract class but cannot compile it - can be used for ur subclasses

    public Shape(Point center) {
        this.center = center;
    }

    Point center() {
        return this.center;
    }

    double area() {
        return 0;
    }

    boolean contains(Point point) {
        return false;
    }

    double circumference(){
        return 0;
    }

    static boolean allContain(List<Shape> shapes, Point point){
        int counter = 0;

        for (int i = 0; i < shapes.size(); i++){
            if (shapes.get(i).contains(point)){
                counter++;
            }
        }

        if (counter == shapes.size()){
            return true;
        }
        else {
            return false;
        }
    }

    public Point getCenter() {
        return center;
    }
}