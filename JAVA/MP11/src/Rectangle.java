public class Rectangle extends Shape {
    Point p1;
    Point p2;

    Rectangle(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    Rectangle(int x1, int y1, int x2, int y2){
        p1 = new Point(x1,y1);
        p2 = new Point(x2,y2);
    }
    @Override
    double getArea() {
        double area;
        area = Math.abs(p1.getX() - p2.getX()) * Math.abs(p1.getY() - p2.getY());
        return area;
    }
    @Override
    double getPerimeter() {
        double perimeter;
        perimeter = (Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY())) * 2;
        return perimeter;
    }

    @Override
    public String toString() {
        return "Rectangle :" + '\n'
                + "p1 : " + p1.toString() + '\n'
                + "p2 : " + p2.toString();
     }
 }
