package com.enndfp.shapes;

import com.enndfp.vertex.Vertex;

/**
 * Rectangle类表示一个矩形，实现了Polygon接口。
 * 包含绘制矩形、验证矩形有效性和计算面积的方法。
 *
 * @author 冯鹏
 * @version 1.0
 */
public class Rectangle implements Polygon {
    /**
     * 矩形的四个顶点
     */
    private Vertex v1, v2, v3, v4;

    /**
     * 构造一个矩形。
     *
     * @param v1 矩形的第一个顶点
     * @param v2 矩形的第二个顶点
     * @param v3 矩形的第三个顶点
     * @param v4 矩形的第四个顶点
     */
    public Rectangle(Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
    }

    /**
     * 绘制矩形，打印矩形的顶点信息。
     */
    @Override
    public void draw() {
        System.out.println("绘制一个矩形，顶点分别为: (" + v1.getX() + ", " + v1.getY() + "), (" + v2.getX() + ", " + v2.getY() + "), (" + v3.getX() + ", " + v3.getY() + "), (" + v4.getX() + ", " + v4.getY() + ")");
    }

    /**
     * 判断顶点是否可以构成一个有效的矩形。
     * 通过判断对边的距离是否相等来验证矩形的有效性。
     *
     * @return 如果可以构成有效的矩形则返回true；否则返回false
     */
    @Override
    public boolean canForm() {
        float d1 = v1.calcDistance(v2);
        float d2 = v2.calcDistance(v3);
        float d3 = v3.calcDistance(v4);
        float d4 = v4.calcDistance(v1);
        return d1 == d3 && d2 == d4;
    }

    /**
     * 计算矩形的面积。
     * 计算公式：长 * 宽。
     *
     * @return 返回矩形的面积，类型为float
     */
    @Override
    public float calcArea() {
        float length = v1.calcDistance(v2);
        float width = v2.calcDistance(v3);
        return length * width;
    }
}