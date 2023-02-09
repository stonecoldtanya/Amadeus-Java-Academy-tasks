package shapeoop;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(Point center, double height, double width) {
        super(center);
        this.height = height;
        this.width = width;
    }

    public Rectangle(Point center) {
        super(center);
    }

    @Override
    Point center() {
        return super.center();
    }

    @Override
    double area() {
        return width * height;
    }

    @Override
    boolean contains(Point point) {
        return findPoint(height, width, center.getX(), center.getY(), point.getX(), point.getY());
    }

    boolean findPoint(double sideA, double sideB, double centerX, double centerY, double pointX, double pointY) {
        if ((pointX > sideB / 2 + centerX) || (pointX < centerX - sideB / 2)) {
            return false;
        }
        return !(centerY + (sideA / 2) < pointY) && !(centerY - (sideA / 2) > pointY);
    }

    @Override
    double circumference() {
        return 2 * (height + width);
    }

    private void setCenter(Point center) {
        this.center = center;
    }


    public Point getCenter() {
        return center;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
