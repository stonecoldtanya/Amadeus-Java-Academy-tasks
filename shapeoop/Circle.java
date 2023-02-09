package shapeoop;

public class Circle extends Shape{
    private double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    double area() {
        return radius * radius * Math.PI;
    }

    @Override
    double circumference() {
        return 2 * radius * Math.PI;
    }

    @Override
    boolean contains(Point point) {
        return findPoint(center.getX(),center.getY(), radius, point.getX(), point.getY());
    }

    private boolean findPoint(double centerX, double centerY, double radius, double pointX, double pointY) {
        if ((pointX - centerX) * (pointX - centerX) + (pointY - centerY) * (pointY - centerY) <= radius * radius){
            return true;
        }else {
            return false;
        }
    }

    public Point getCenter() {
        return center;
    }

    private void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }

}