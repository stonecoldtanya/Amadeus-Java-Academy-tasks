package shapeoop;

public class Square extends Shape {
    private double size;

    public Square(Point center, double size) {
        super(center);
        this.size = size;
    }

    @Override
    double area() {
        return size * size;
    }

    @Override
    boolean contains(Point point) {
        return findPoint(size, center.getX(), center.getY(), point.getX(), point.getY());
    }

    boolean findPoint(double side, double centerX, double centerY, double pointX, double pointY) {
        if ((pointX > side / 2 + centerX) || (pointX < centerX - side / 2)) {
            return false;
        }
        return !(centerY + (side / 2) < pointY) && !(centerY - (side / 2) > pointY);
    }

    @Override
    double circumference() {
        return 4 * size;
    }

    @Override
    Point center() {
        return super.center();
    }

    public Square(Point center) {
        super(center);
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}