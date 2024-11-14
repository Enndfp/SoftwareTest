package com.enndfp.shapes;

import com.enndfp.vertex.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * RectangleTest类用于测试Rectangle类的功能，特别是计算矩形的面积。
 * 包含对calcArea方法的不同测试用例。
 *
 * @author 冯鹏
 * @version 1.0
 */
public class RectangleTest {

    /**
     * 测试calcArea方法，使用一个标准的矩形，其顶点为(0, 0), (4, 0), (4, 3), (0, 3)。
     * 预期返回矩形的面积为12.0。
     */
    @Test
    public void testCalcArea_TC07() {
        Rectangle rectangle = new Rectangle(new Vertex(0, 0), new Vertex(4, 0), new Vertex(4, 3), new Vertex(0, 3));
        double result = rectangle.calcArea();
        assertEquals(12.0, result, 0.0001, "TC-07: 矩形面积计算失败");
        System.out.println("TC-07: 矩形面积 = " + result + "，测试通过！");
    }

    /**
     * 测试calcArea方法，当矩形退化为一个点时（所有顶点重合），
     * 预期返回面积为0.0。
     */
    @Test
    public void testCalcArea_TC08() {
        Rectangle rectangle = new Rectangle(new Vertex(0, 0), new Vertex(0, 0), new Vertex(0, 0), new Vertex(0, 0));
        double result = rectangle.calcArea();
        assertEquals(0.0, result, 0.0001, "TC-08: 退化为点的矩形面积计算失败");
        System.out.println("TC-08: 退化为点的矩形面积 = " + result + "，测试通过！");
    }

    /**
     * 测试calcArea方法，当矩形的长宽不相等时，计算面积。
     * 输入为矩形的顶点(0, 0), (4, 0), (4, 3), (0, 3)，
     * 预期面积为12.0。
     */
    @Test
    public void testCalcArea_TC09() {
        Rectangle rectangle = new Rectangle(new Vertex(0, 0), new Vertex(4, 0), new Vertex(4, 3), new Vertex(0, 3));
        double result = rectangle.calcArea();
        assertEquals(12.0, result, 0.0001, "TC-09: 长宽不同的矩形面积计算失败");
        System.out.println("TC-09: 矩形面积 = " + result + "，测试通过！");
    }
}
