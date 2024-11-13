package com.enndfp.shapes;

/**
 * Polygon接口定义了多边形的基本操作。
 * 包含绘制、验证形状有效性和计算面积的方法。
 * 由Triangle、Rectangle和AdapterCircle类实现。
 *
 * @author 冯鹏
 * @version 1.0
 */
public interface Polygon {
    /**
     * 绘制多边形的抽象方法。
     */
    void draw();

    /**
     * 判断顶点和其他参数是否可以构成有效的多边形。
     *
     * @return 如果可以构成有效的多边形，则返回true；否则返回false
     */
    boolean canForm();

    /**
     * 计算多边形的面积。
     *
     * @return 返回多边形的面积，类型为float
     */
    float calcArea();
}