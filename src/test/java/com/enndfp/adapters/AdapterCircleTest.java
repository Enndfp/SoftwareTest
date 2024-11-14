package com.enndfp.adapters;

import com.enndfp.vertex.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AdapterCircleTest类用于测试AdapterCircle类的功能，尤其是计算圆面积和是否能形成有效圆。
 *
 * @author 冯鹏
 * @version 1.0
 */
public class AdapterCircleTest {

    /**
     * 测试calcArea方法，当适配圆的半径为5时，预期返回圆的面积为78.5398。
     */
    @Test
    public void testCalcArea_TC13() {
        AdapterCircle adapterCircle = new AdapterCircle(new Vertex(0, 0), 5);
        double result = adapterCircle.calcArea();
        assertEquals(78.5398, result, 0.0001, "TC-13: 适配的圆面积计算失败");
        System.out.println("TC-13: 适配圆面积 = " + result + "，测试通过！");
    }

    /**
     * 测试canForm方法，当适配圆的半径为0时，预期返回false，表示不能形成有效圆。
     */
    @Test
    public void testCanForm_TC14() {
        AdapterCircle adapterCircle = new AdapterCircle(new Vertex(0, 0), 0);
        boolean result = adapterCircle.canForm();
        assertFalse(result, "TC-14: 半径为0的圆不能形成有效圆");
        System.out.println("TC-14: 半径为0，能否形成有效圆 = " + result + "，测试通过！");
    }

    /**
     * 测试canForm方法，当适配圆的半径为3时，预期返回true，表示能形成有效圆。
     */
    @Test
    public void testCanForm_TC15() {
        AdapterCircle adapterCircle = new AdapterCircle(new Vertex(0, 0), 3);
        boolean result = adapterCircle.canForm();
        assertTrue(result, "TC-15: 半径为3的圆应能形成有效圆");
        System.out.println("TC-15: 半径为3，能否形成有效圆 = " + result + "，测试通过！");
    }
}
