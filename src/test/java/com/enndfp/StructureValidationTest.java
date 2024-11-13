package com.enndfp;

import com.enndfp.vertex.Vertex;
import com.enndfp.shapes.Circle;
import com.enndfp.shapes.Polygon;
import com.enndfp.shapes.Rectangle;
import com.enndfp.shapes.Triangle;
import com.enndfp.adapters.AdapterCircle;
import lombok.var;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 结构验证测试类。
 * 通过反射机制验证类的继承、实现和方法重写情况。
 *
 * @author 冯鹏
 * @version 1.0
 */
public class StructureValidationTest {

    /**
     * 测试类是否存在。
     */
    @Test
    public void testClassExistence() {
        try {
            Class.forName("com.enndfp.vertex.Vertex");
            Class.forName("com.enndfp.shapes.Circle");
            Class.forName("com.enndfp.shapes.Polygon");
            Class.forName("com.enndfp.shapes.Rectangle");
            Class.forName("com.enndfp.shapes.Triangle");
            Class.forName("com.enndfp.adapters.AdapterCircle");
        } catch (ClassNotFoundException e) {
            assertTrue(false, "指定类不存在：" + e.getMessage());
        }
    }

    /**
     * 测试 Polygon 接口的实现。
     */
    @Test
    public void testPolygonInterfaceImplementation() {
        assertTrue(Polygon.class.isAssignableFrom(Rectangle.class), "Rectangle 应实现 Polygon 接口");
        assertTrue(Polygon.class.isAssignableFrom(Triangle.class), "Triangle 应实现 Polygon 接口");
        assertTrue(Polygon.class.isAssignableFrom(AdapterCircle.class), "AdapterCircle 应实现 Polygon 接口");
    }

    /**
     * 测试类之间的继承和组合关系。
     */
    @Test
    public void testInheritanceAndComposition() {
        // AdapterCircle 应该包含 Circle 类型的成员变量
        boolean hasCircleField = false;
        for (var field : AdapterCircle.class.getDeclaredFields()) {
            if (field.getType() == Circle.class) {
                hasCircleField = true;
                break;
            }
        }
        assertTrue(hasCircleField, "AdapterCircle 应包含 Circle 类型的成员变量以组合 Circle 类");

        // AdapterCircle 应实现 Polygon 接口
        assertTrue(Polygon.class.isAssignableFrom(AdapterCircle.class), "AdapterCircle 应实现 Polygon 接口");
    }

    /**
     * 测试 Polygon 接口中的方法是否被正确重写。
     */
    @Test
    public void testMethodOverrideInPolygon() {
        checkMethodOverride(Rectangle.class, "draw");
        checkMethodOverride(Rectangle.class, "canForm");
        checkMethodOverride(Rectangle.class, "calcArea");

        checkMethodOverride(Triangle.class, "draw");
        checkMethodOverride(Triangle.class, "canForm");
        checkMethodOverride(Triangle.class, "calcArea");

        checkMethodOverride(AdapterCircle.class, "draw");
        checkMethodOverride(AdapterCircle.class, "canForm");
        checkMethodOverride(AdapterCircle.class, "calcArea");
    }

    /**
     * 测试各类的构造器定义。
     */
    @Test
    public void testConstructorDefinition() {
        checkConstructor(Vertex.class, float.class, float.class);
        checkConstructor(Circle.class, Vertex.class, float.class);
        checkConstructor(Rectangle.class, Vertex.class, Vertex.class, Vertex.class, Vertex.class);
        checkConstructor(Triangle.class, Vertex.class, Vertex.class, Vertex.class);
        checkConstructor(AdapterCircle.class, Vertex.class, float.class);
    }

    /**
     * 辅助方法：检查是否重写了指定方法。
     *
     * @param clazz      检查的类
     * @param methodName 方法名
     */
    private void checkMethodOverride(Class<?> clazz, String methodName) {
        try {
            Method method = clazz.getMethod(methodName);
            assertTrue(Modifier.isPublic(method.getModifiers()), clazz.getSimpleName() + " 类的 " + methodName + " 方法应为 public");
        } catch (NoSuchMethodException e) {
            assertTrue(false, clazz.getSimpleName() + " 应重写 Polygon 接口的 " + methodName + " 方法");
        }
    }

    /**
     * 辅助方法：检查类是否定义了指定构造器。
     *
     * @param clazz          检查的类
     * @param parameterTypes 构造器参数类型
     */
    private void checkConstructor(Class<?> clazz, Class<?>... parameterTypes) {
        try {
            Constructor<?> constructor = clazz.getConstructor(parameterTypes);
            assertTrue(Modifier.isPublic(constructor.getModifiers()), clazz.getSimpleName() + " 的构造器应为 public");
        } catch (NoSuchMethodException e) {
            assertTrue(false, clazz.getSimpleName() + " 应定义指定的构造器");
        }
    }
}
