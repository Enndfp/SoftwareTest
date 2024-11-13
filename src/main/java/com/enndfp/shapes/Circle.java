package com.enndfp.shapes;

import com.enndfp.vertex.Vertex;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Circle类表示一个圆形，包含圆心顶点和半径。
 * 提供绘制圆和计算圆面积的方法。
 *
 * @author 冯鹏
 * @version 1.0
 */
@Data
@AllArgsConstructor
public class Circle {
    /**
     * 圆的中心点
     */
    private Vertex center;

    /**
     * 圆的半径
     */
    private float radius;

    /**
     * 绘制圆形的方法，打印圆的中心和半径信息。
     */
    public void drawCircle() {
        System.out.println("绘制一个半径为 " + radius + " 的圆形，中心位于 (" + center.getX() + ", " + center.getY() + ")");
    }

    /**
     * 计算圆的面积。
     * 计算公式：π * 半径^2。
     *
     * @return 返回圆的面积，类型为float
     */
    public float areaCircle() {
        return (float) (Math.PI * radius * radius);
    }
}