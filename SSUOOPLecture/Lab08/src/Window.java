
import java.util.*;

abstract class Figure
{
    enum ColorType {r,g,b};
    ColorType c;
    Figure (ColorType c)
    {
        this.c = c;
    }
    void setColor (ColorType c)
    {
        this.c = c;
    }
    public abstract void move(int x , int y);
}

class Point extends Figure
{
    private int x, y;
    Point(ColorType c, int x, int y)
    {
        super(c);
        this.x = x;
        this.y = y;
    }
    public void move(int x , int y)
    {
        this.x += x;
        this.y += y;
    }
    public void printInfo()
    {
        System.out.println(x+","+y);
    }
}

class Circle extends Figure
{
    Point center;
    float radius;
    Circle(ColorType c, Point center, float radius)
    {
        super(c);
        this.center = center;
        this.radius = radius;
    }
    public void move(int x ,int y)
    {
        System.out.println("[원]");
        center.move(x,y);
      center.printInfo();
    }
}

class Square extends Figure
{
    Point upleft;
    int side;
    Square(ColorType c, Point upleft, int side)
    {
        super(c);
        this.upleft = upleft;
        this.side = side;
    }
    public void move(int x, int y)
    {
        System.out.println("[square]");
        upleft.move(x,y);
        upleft.printInfo();
    }
}

class Line extends Figure
{
    Point p1, p2;
    Line(ColorType c, Point p1, Point p2)
    {
        super(c);
        this.p1 = p1;
        this.p2 = p2;
    }
    public void move(int x, int y)
    {
        System.out.println("[선이동]");
        System.out.println("1번째 점");
        p1.move(x,y);
        p1.printInfo();
        System.out.println("2번째 점");
        p2.move(x,y);
        p2.printInfo();
    }
}


public class Window
{
    ArrayList<Figure> f = new ArrayList<Figure>();
    private int count=0;
    public void addFigure (Figure fig)
    {
        f.add(fig);
        count++;
        System.out.println("현재 도형의 개수:"+count);
    }
    public void moveAll(int xx, int yy)
    {
        for(Figure a: f)
        {
            a.move(xx,yy);
        }
    }
    public static void main (String args[])
    {
        Window w = new Window();
        Circle c1 = new Circle(Figure.ColorType.r, new Point(Figure.ColorType.r, 1,1), (float) 2 );
        w.addFigure(c1);
        Square s1 = new Square(Figure.ColorType.r, new Point(Figure.ColorType.r,1,1), 2);
        w.addFigure(s1);
        Line l1 = new Line(Figure.ColorType.r, new Point(Figure.ColorType.r,1,1), new Point(Figure.ColorType.r,2,2));
        w.addFigure(l1);
        w.moveAll(1,1);
    }
}
