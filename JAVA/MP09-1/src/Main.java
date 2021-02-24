import java.awt.Point;
class Rectangle {
    static final int WIDTH = 50;
    static final int HEIGHT = 50;
    private Point upperLeft;
    private Point lowerRight;
    Rectangle(Point uL){
        this.upperLeft = uL;
        this.lowerRight = new Point(uL.x+WIDTH, uL.y+HEIGHT);
    }
    Rectangle(Point uL, Point lR){
        this.upperLeft = uL;
        this.lowerRight = lR;
    }
    void translate(int x, int y){ //이동 : upperleft / lowerRight
        upperLeft.translate(x,y);
        lowerRight.translate(x,y);
    }
    public String toString(){
        return "UL: java.awt.Point[x= " + upperLeft.x + ", y=" + upperLeft.y + "],"
                + "UL: java.awt.Point[x= " + lowerRight.x + ", y=" + lowerRight.y + "],";
    }
}

class Block1{
    private Rectangle[] rectangles;
    Block1(Point p){
    }
    Block1(int x, int y){
        rectangles = new Rectangle[4];
        rectangles[0] = new Rectangle(new Point(x,y));
        rectangles[1] = new Rectangle(new Point(x + Rectangle.WIDTH,y));
        rectangles[2] = new Rectangle(new Point(x,y + Rectangle.HEIGHT));
        rectangles[3] = new Rectangle(new Point(x+ Rectangle.WIDTH ,y + Rectangle.HEIGHT));
    }
    void translate(int x, int y){
        for(int i=0;i<4;i++)
            rectangles[i].translate(x,y);
    }
    public String toString(){
        return rectangles[0].toString()
                + '\n'
                + rectangles[1].toString()
                + '\n'
                + rectangles[2].toString()
                + '\n'
                + rectangles[3].toString();
    }
}

class Block2{
    private Rectangle[] rectangles;
    Block2(Point p){

    }
    Block2(int x, int y){
        rectangles = new Rectangle[4];
        rectangles[0] = new Rectangle(new Point(x,y));
        rectangles[1] = new Rectangle(new Point(x,y + Rectangle.HEIGHT));
        rectangles[2] = new Rectangle(new Point(x,y + Rectangle.HEIGHT * 2));
        rectangles[3] = new Rectangle(new Point(x,y + Rectangle.HEIGHT * 3));
    }
    void translate(int x, int y){
        for(int i=0;i<4;i++)
            rectangles[i].translate(x,y);
    }
    public String toString(){
        return rectangles[0].toString()
                + '\n'
                + rectangles[1].toString()
                + '\n'
                + rectangles[2].toString()
                + '\n'
                + rectangles[3].toString();
    }
}

class Block3{
    private Rectangle[] rectangles;
    Block3(Point p){

    }
    Block3(int x, int y){
        rectangles = new Rectangle[4];
        rectangles[0] = new Rectangle(new Point(x,y));
        rectangles[1] = new Rectangle(new Point(x,y + Rectangle.HEIGHT));
        rectangles[2] = new Rectangle(new Point(x + Rectangle.WIDTH,y + Rectangle.HEIGHT ));
        rectangles[3] = new Rectangle(new Point(x + Rectangle.WIDTH * 2,y + Rectangle.HEIGHT));
    }
    void translate(int x, int y){
        for(int i=0;i<4;i++)
            rectangles[i].translate(x,y);
    }
    public String toString(){
        return rectangles[0].toString()
                + '\n'
                + rectangles[1].toString()
                + '\n'
                + rectangles[2].toString()
                + '\n'
                + rectangles[3].toString();
    }
}


public class Main {
    public static void main(String[] args) {
        Block1 b = new Block1(10, 10);
        Rectangle r = new Rectangle(new Point(10, 10));
        Rectangle r2 = new Rectangle(new Point(20, 20),
                new Point(70, 70));
        System.out.println("r");
        System.out.println(r);
        System.out.println("r2");
        System.out.println(r2);

        System.out.println("b");
        System.out.println(b);
        b.translate(10, -10);
        System.out.println("b");
        System.out.println(b);
    }
}
