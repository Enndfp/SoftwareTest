package com.enndfp;

import com.enndfp.adapters.AdapterCircle;
import com.enndfp.shapes.Circle;
import com.enndfp.shapes.Polygon;
import com.enndfp.shapes.Rectangle;
import com.enndfp.shapes.Triangle;
import com.enndfp.vertex.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 结构性测试类，包含对项目中各个类、接口、方法和构造器的检查。
 *
 * @author 冯鹏
 * @version 1.0
 */
public class StructuralTest {

    /**
     * SC-01: 测试类的存在性，确保Vertex、Circle、Rectangle、Triangle、AdapterCircle
     * 等类的定义符合类图要求。
     */
    @Test
    public void testClassExistence_SC01() {
        try {
            // 通过反射检查每个类是否存在
            Class.forName("com.enndfp.vertex.Vertex");
            Class.forName("com.enndfp.shapes.Circle");
            Class.forName("com.enndfp.shapes.Rectangle");
            Class.forName("com.enndfp.shapes.Triangle");
            Class.forName("com.enndfp.adapters.AdapterCircle");

            System.out.println("SC-01: 所有类存在，符合类图定义。");
        } catch (ClassNotFoundException e) {
            fail("SC-01: 某些类不存在，未能通过检查：" + e.getMessage());
        }
    }

    /**
     * SC-02: 测试接口实现，确保Triangle、Rectangle和AdapterCircle类都实现了Polygon接口。
     */
    @Test
    public void testInterfaceImplementation_SC02() {
        // 检查Triangle类是否实现了Polygon接口
        assertTrue(Triangle.class.getInterfaces().length > 0 &&
                        Polygon.class.equals(Triangle.class.getInterfaces()[0]),
                "SC-02: Triangle类没有实现Polygon接口");

        // 检查Rectangle类是否实现了Polygon接口
        assertTrue(Rectangle.class.getInterfaces().length > 0 &&
                        Polygon.class.equals(Rectangle.class.getInterfaces()[0]),
                "SC-02: Rectangle类没有实现Polygon接口");

        // 检查AdapterCircle类是否实现了Polygon接口
        assertTrue(AdapterCircle.class.getInterfaces().length > 0 &&
                        Polygon.class.equals(AdapterCircle.class.getInterfaces()[0]),
                "SC-02: AdapterCircle类没有实现Polygon接口");

        System.out.println("SC-02: Triangle、Rectangle、AdapterCircle类实现了Polygon接口，符合接口定义。");
    }

    /**
     * SC-03: 测试AdapterCircle类的组合关系，确保AdapterCircle类内部包含Circle对象。
     */
    @Test
    public void testCompositionRelationship_SC03() {
        AdapterCircle adapterCircle = new AdapterCircle(new Vertex(0, 0), 5);
        // 检查AdapterCircle是否包含Circle对象
        assertNotNull(adapterCircle.getCircle(), "SC-03: AdapterCircle没有正确包含Circle对象");
        System.out.println("SC-03: AdapterCircle类正确包含Circle类实例，符合组合关系。");
    }

    /**
     * SC-04: 测试方法重写，确保draw、canForm、calcArea方法的签名符合接口的要求。
     */
    @Test
    public void testMethodOverriding_SC04() {
        try {
            // 检查Triangle类是否重写了Polygon接口的draw方法
            assertTrue(Triangle.class.getMethod("draw") != null, "SC-04: Triangle类未重写draw方法");

            // 检查Rectangle类是否重写了Polygon接口的draw方法
            assertTrue(Rectangle.class.getMethod("draw") != null, "SC-04: Rectangle类未重写draw方法");

            // 检查AdapterCircle类是否重写了Polygon接口的draw方法
            assertTrue(AdapterCircle.class.getMethod("draw") != null, "SC-04: AdapterCircle类未重写draw方法");

            // 检查canForm方法是否正确存在于AdapterCircle类
            assertTrue(AdapterCircle.class.getMethod("canForm") != null, "SC-04: AdapterCircle类未重写canForm方法");

            // 检查calcArea方法是否正确存在于所有类中
            assertTrue(Triangle.class.getMethod("calcArea") != null, "SC-04: Triangle类未重写calcArea方法");
            assertTrue(Rectangle.class.getMethod("calcArea") != null, "SC-04: Rectangle类未重写calcArea方法");
            assertTrue(AdapterCircle.class.getMethod("calcArea") != null, "SC-04: AdapterCircle类未重写calcArea方法");

            System.out.println("SC-04: 所有方法正确重写，符合接口方法要求。");
        } catch (NoSuchMethodException e) {
            fail("SC-04: 方法重写检查失败，未能找到方法：" + e.getMessage());
        }
    }

    /**
     * SC-05: 测试构造器，确保每个类的构造器正确定义。
     */
    @Test
    public void testConstructorDefinition_SC05() {
        try {
            // 检查Vertex类的构造器是否存在并正确定义
            assertNotNull(Vertex.class.getConstructor(float.class, float.class), "SC-05: Vertex类构造器定义错误");

            // 检查Circle类的构造器是否存在并正确定义
            assertNotNull(Circle.class.getConstructor(Vertex.class, float.class), "SC-05: Circle类构造器定义错误");

            // 检查Rectangle类的构造器是否存在并正确定义
            assertNotNull(Rectangle.class.getConstructor(Vertex.class, Vertex.class, Vertex.class, Vertex.class), "SC-05: Rectangle类构造器定义错误");

            // 检查Triangle类的构造器是否存在并正确定义
            assertNotNull(Triangle.class.getConstructor(Vertex.class, Vertex.class, Vertex.class), "SC-05: Triangle类构造器定义错误");

            // 检查AdapterCircle类的构造器是否存在并正确定义
            assertNotNull(AdapterCircle.class.getConstructor(Vertex.class, float.class), "SC-05: AdapterCircle类构造器定义错误");

            System.out.println("SC-05: 所有类的构造器定义正确，符合类图需求。");
        } catch (NoSuchMethodException e) {
            fail("SC-05: 构造器检查失败，未能找到构造器：" + e.getMessage());
        }
    }
}
