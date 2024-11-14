package com.enndfp.vertex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * VertexTest类用于测试Vertex类中与顶点相关的功能，特别是计算两个顶点之间的距离。
 * 包含对calcDistance方法的不同测试用例。
 *
 * @author 冯鹏
 * @version 1.0
 */
public class VertexTest {

    /**
     * 测试calcDistance方法，当输入为两个典型的直角三角形的顶点时（(0,0) 和 (3,4)），
     * 预期返回值为5.0（直角三角形的斜边）。
     */
    @Test
    public void testCalcDistance_TC01() {
        Vertex v1 = new Vertex(0, 0);
        Vertex v2 = new Vertex(3, 4);
        double result = v1.calcDistance(v2);
        assertEquals(5.0, result, 0.0001, "TC-01: 计算两个 Vertex 对象之间的距离失败");
        System.out.println("TC-01: calcDistance(0, 0) 和 (3, 4) = " + result + "，测试通过！");
    }

    /**
     * 测试calcDistance方法，当输入为两个完全重合的点时（(1,1) 和 (1,1)），
     * 预期返回值为0.0。
     */
    @Test
    public void testCalcDistance_TC02() {
        Vertex v1 = new Vertex(1, 1);
        Vertex v2 = new Vertex(1, 1);
        double result = v1.calcDistance(v2);
        assertEquals(0.0, result, 0.0001, "TC-02: 两点重合，距离计算失败");
        System.out.println("TC-02: calcDistance(1, 1) 和 (1, 1) = " + result + "，测试通过！");
    }

    /**
     * 测试calcDistance方法，当输入为负坐标的两个点时（(-1,-1) 和 (1,1)），
     * 预期返回值为2.8284，计算结果为两点间的欧几里得距离。
     */
    @Test
    public void testCalcDistance_TC03() {
        Vertex v1 = new Vertex(-1, -1);
        Vertex v2 = new Vertex(1, 1);
        double result = v1.calcDistance(v2);
        assertEquals(2.8284, result, 0.0001, "TC-03: 负坐标的距离计算失败");
        System.out.println("TC-03: calcDistance(-1, -1) 和 (1, 1) = " + result + "，测试通过！");
    }
}
