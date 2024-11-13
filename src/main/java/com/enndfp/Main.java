package com.enndfp;

import com.enndfp.adapters.AdapterCircle;
import com.enndfp.shapes.Polygon;
import com.enndfp.shapes.Rectangle;
import com.enndfp.shapes.Triangle;
import com.enndfp.vertex.Vertex;

/**
 * Main类是程序的入口，包含一个多边形数组成员变量。
 * 负责初始化多边形数组并在main方法中进行测试。
 *
 * @author 冯鹏
 * @version 1.0
 */
public class Main {
    /**
     * 多边形数组，包含不同类型的多边形对象
     */
    private Polygon[] polygons;

    /**
     * main方法，程序的入口
     * 初始化多边形数组并测试其功能
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建Main实例，并初始化多边形数组
        Main mainApp = new Main();
        mainApp.polygons = new Polygon[3];

        // 初始化多边形数组中的元素
        mainApp.polygons[0] = new Triangle(new Vertex(0, 0), new Vertex(3, 0), new Vertex(3, 4));
        mainApp.polygons[1] = new Rectangle(new Vertex(0, 0), new Vertex(4, 0), new Vertex(4, 3), new Vertex(0, 3));
        mainApp.polygons[2] = new AdapterCircle(new Vertex(0, 0), 5);

        // 遍历多边形数组并调用各多边形的方法
        for (Polygon polygon : mainApp.polygons) {
            polygon.draw();
            if (polygon.canForm()) {
                System.out.println("面积: " + polygon.calcArea());
            } else {
                System.out.println("无法构成有效的形状。");
            }
        }
    }
}