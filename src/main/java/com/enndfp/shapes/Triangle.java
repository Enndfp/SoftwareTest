package com.enndfp.shapes;

import com.enndfp.vertex.Vertex;
import lombok.AllArgsConstructor;

/**
 * Triangle类表示一个三角形，实现了Polygon接口。
 * 包含绘制三角形、验证三角形有效性和计算面积的方法。
 *
 * @author 冯鹏
 * @version 1.0
 */
@AllArgsConstructor
public class Triangle implements Polygon {
    /**
     * 三角形的三个顶点
     */
    private Vertex v1, v2, v3;

    /**
     * 绘制三角形，打印三角形的顶点信息。
     */
    @Override
    public void draw() {
        System.out.println("绘制一个三角形，顶点分别为: (" + v1.getX() + ", " + v1.getY() + "), (" + v2.getX() + ", " + v2.getY() + "), (" + v3.getX() + ", " + v3.getY() + ")");
    }

    /**
     * 判断顶点是否可以构成一个有效的三角形。
     * 通过三边长度判断，三角形任意两边之和需大于第三边。
     *
     * @return 如果可以构成有效的三角形则返回true；否则返回false
     */
    @Override
    public boolean canForm() {
        float d1 = v1.calcDistance(v2);
        float d2 = v2.calcDistance(v3);
        float d3 = v3.calcDistance(v1);
        return (d1 + d2 > d3) && (d2 + d3 > d1) && (d3 + d1 > d2);
    }

    /**
     * 计算三角形的面积。
     * 使用海伦公式：sqrt(s * (s - a) * (s - b) * (s - c))，其中s为半周长。
     *
     * @return 返回三角形的面积，类型为float
     */
    @Override
    public float calcArea() {
        float d1 = v1.calcDistance(v2);
        float d2 = v2.calcDistance(v3);
        float d3 = v3.calcDistance(v1);
        float s = (d1 + d2 + d3) / 2;
        return (float) Math.sqrt(s * (s - d1) * (s - d2) * (s - d3));
    }
}