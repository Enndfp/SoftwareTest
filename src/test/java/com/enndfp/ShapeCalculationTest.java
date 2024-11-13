package com.enndfp;

import com.enndfp.vertex.Vertex;
import com.enndfp.shapes.Circle;
import com.enndfp.shapes.Rectangle;
import com.enndfp.shapes.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 数值计算方法单元测试。
 * 通过白盒测试和黑盒测试相结合的方式，覆盖基本路径和等价类。
 * 对各个类的数值计算方法进行功能测试。
 *
 * @author 冯鹏
 * @version 1.0
 */
public class ShapeCalculationTest {

    /**
     * 测试 Vertex 类的 calcDistance 方法。
     * 输入顶点 (0,0) 和 (3,4)，预期输出距离 5.0。
     */
    @Test
    public void testVertexCalcDistance() {
        Vertex v1 = new Vertex(0, 0);
        Vertex v2 = new Vertex(3, 4);
        float expectedDistance = 5.0f;
        assertEquals(expectedDistance, v1.calcDistance(v2), 0.0001, "两点之间的距离计算错误");
    }

    /**
     * 测试 Circle 类的 areaCircle 方法。
     * 输入半径 5，预期输出面积 78.5398。
     */
    @Test
    public void testCircleArea() {
        Circle circle = new Circle(new Vertex(0, 0), 5);
        float expectedArea = 78.5398f;
        assertEquals(expectedArea, circle.areaCircle(), 0.0001, "圆的面积计算错误");
    }

    /**
     * 测试 Rectangle 类的 calcArea 方法。
     * 输入顶点 (0,0), (4,0), (4,3), (0,3)，预期输出面积 12.0。
     */
    @Test
    public void testRectangleArea() {
        Rectangle rectangle = new Rectangle(new Vertex(0, 0), new Vertex(4, 0), new Vertex(4, 3), new Vertex(0, 3));
        float expectedArea = 12.0f;
        assertEquals(expectedArea, rectangle.calcArea(), 0.0001, "矩形的面积计算错误");
    }

    /**
     * 测试 Triangle 类的 calcArea 方法。
     * 输入顶点 (0,0), (3,0), (3,4)，预期输出面积 6.0。
     */
    @Test
    public void testTriangleArea() {
        Triangle triangle = new Triangle(new Vertex(0, 0), new Vertex(3, 0), new Vertex(3, 4));
        float expectedArea = 6.0f;
        assertEquals(expectedArea, triangle.calcArea(), 0.0001, "三角形的面积计算错误");
    }

    /**
     * 测试 Circle 类的 areaCircle 方法的边界值。
     * 输入半径 0，预期输出面积 0。
     */
    @Test
    public void testCircleAreaBoundary() {
        Circle circle = new Circle(new Vertex(0, 0), 0);
        float expectedArea = 0.0f;
        assertEquals(expectedArea, circle.areaCircle(), 0.0001, "半径为 0 的圆的面积计算错误");
    }

    /**
     * 测试 Triangle 类的 calcArea 方法的特殊值。
     * 输入共线的三点，预期输出面积 0。
     */
    @Test
    public void testTriangleAreaCollinear() {
        Triangle triangle = new Triangle(new Vertex(0, 0), new Vertex(2, 2), new Vertex(4, 4));
        float expectedArea = 0.0f;
        assertEquals(expectedArea, triangle.calcArea(), 0.0001, "三点共线时三角形面积应为 0");
    }
}
