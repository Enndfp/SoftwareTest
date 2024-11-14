package com.enndfp.shapes;

import com.enndfp.vertex.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * CircleTest类用于测试Circle类的功能，特别是计算圆的面积。
 * 包含对areaCircle方法的不同测试用例。
 *
 * @author 冯鹏
 * @version 1.0
 */
public class CircleTest {

    /**
     * 测试areaCircle方法，当半径为5时，预期返回圆的面积为78.5398。
     */
    @Test
    public void testAreaCircle_TC04() {
        Circle circle = new Circle(new Vertex(0, 0), 5);
        double result = circle.areaCircle();
        assertEquals(78.5398, result, 0.0001, "TC-04: 圆的面积计算失败");
        System.out.println("TC-04: 半径5的圆的面积 = " + result + "，测试通过！");
    }

    /**
     * 测试areaCircle方法，当半径为0时，预期返回圆的面积为0.0。
     * 测试边界值情况。
     */
    @Test
    public void testAreaCircle_TC05() {
        Circle circle = new Circle(new Vertex(0, 0), 0);
        double result = circle.areaCircle();
        assertEquals(0.0, result, 0.0001, "TC-05: 半径为0的圆的面积计算失败");
        System.out.println("TC-05: 半径0的圆的面积 = " + result + "，测试通过！");
    }

    /**
     * 测试areaCircle方法，当半径为10时，预期返回圆的面积为314.1593。
     * 测试大半径圆的面积计算。
     */
    @Test
    public void testAreaCircle_TC06() {
        Circle circle = new Circle(new Vertex(0, 0), 10);
        double result = circle.areaCircle();
        assertEquals(314.1593, result, 0.0001, "TC-06: 大半径圆的面积计算失败");
        System.out.println("TC-06: 半径10的圆的面积 = " + result + "，测试通过！");
    }
}
