package com.enndfp.adapters;

import com.enndfp.shapes.Circle;
import com.enndfp.shapes.Polygon;
import com.enndfp.vertex.Vertex;

/**
 * AdapterCircle类是Circle的适配器，使其符合Polygon接口。
 * 使用适配器模式将Circle类适配为Polygon接口。
 * 提供绘制、验证形状有效性和计算面积的方法。
 *
 * @author 冯鹏
 * @version 1.0
 */
public class AdapterCircle implements Polygon {
    /**
     * Circle对象
     */
    private Circle circle;

    /**
     * 获取Circle对象
     *
     * @return 返回Circle对象
     */
    public Circle getCircle() {
        return circle;
    }

    /**
     * 构造一个适配器圆形
     *
     * @param center 圆形的中心
     * @param radius 圆形的半径
     */
    public AdapterCircle(Vertex center, float radius) {
        this.circle = new Circle(center, radius);
    }

    /**
     * 绘制适配的圆形，调用Circle的绘制方法。
     */
    @Override
    public void draw() {
        circle.drawCircle();
    }

    /**
     * 判断圆形是否可以构成有效的形状。
     *
     * @return 如果圆形有效则返回true；否则返回false
     */
    @Override
    public boolean canForm() {
        return circle != null && circle.areaCircle() > 0;
    }

    /**
     * 计算圆形的面积。
     *
     * @return 返回圆形的面积，类型为float
     */
    @Override
    public float calcArea() {
        return circle.areaCircle();
    }
}