public class Circle extends Shape {
    Point center;
    int radius;

    Circle(Point p, int r){
        this.center = p;
        this.radius = r;
    }
    Circle(int x, int y, int r){
        this.center = new Point(x,y);
        this.radius = r;
    }
    @Override
    double getArea() {
        return radius * 2 * Math.PI;
    }
    @Override
    double getPerimeter() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle:" + '\n'
                + "center: " + center.toString() + '\n'
                + "radius: " + radius;
    }
}
