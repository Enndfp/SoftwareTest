package com.enndfp.shapes;

import com.enndfp.vertex.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TriangleTest类用于测试Triangle类的功能，特别是计算三角形的面积。
 * 包含对calcArea方法的不同测试用例。
 *
 * @author 冯鹏
 * @version 1.0
 */
public class TriangleTest {

    /**
     * 测试calcArea方法，当输入为常规三角形的顶点(0, 0), (3, 0), (3, 4)时，
     * 预期返回面积为6.0。
     */
    @Test
    public void testCalcArea_TC10() {
        Triangle triangle = new Triangle(new Vertex(0, 0), new Vertex(3, 0), new Vertex(3, 4));
        double result = triangle.calcArea();
        assertEquals(6.0, result, 0.0001, "TC-10: 三角形面积计算失败");
        System.out.println("TC-10: 三角形面积 = " + result + "，测试通过！");
    }

    /**
     * 测试calcArea方法，当输入为三个共线的点(0, 0), (2, 2), (4, 4)时，
     * 预期返回面积为0.0。
     */
    @Test
    public void testCalcArea_TC11() {
        Triangle triangle = new Triangle(new Vertex(0, 0), new Vertex(2, 2), new Vertex(4, 4));
        double result = triangle.calcArea();
        assertEquals(0.0, result, 0.0001, "TC-11: 共线三角形面积计算失败");
        System.out.println("TC-11: 共线三角形面积 = " + result + "，测试通过！");
    }

    /**
     * 测试calcArea方法，当输入为一个较大的三角形，顶点为(0, 0), (0, 5), (5, 0)时，
     * 预期返回面积为12.5。
     */
    @Test
    public void testCalcArea_TC12() {
        Triangle triangle = new Triangle(new Vertex(0, 0), new Vertex(0, 5), new Vertex(5, 0));
        double result = triangle.calcArea();
        assertEquals(12.5, result, 0.0001, "TC-12: 大三角形面积计算失败");
        System.out.println("TC-12: 大三角形面积 = " + result + "，测试通过！");
    }
}
