package com.enndfp.vertex;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Vertex类用于表示一个二维平面上的顶点，包含x和y坐标。
 * 提供计算当前顶点与其他顶点之间距离的方法。
 *
 * @author 冯鹏
 * @version 1.0
 */
@Data
@AllArgsConstructor
public class Vertex {
    /**
     * x坐标
     */
    private float x;

    /**
     * y坐标
     */
    private float y;

    /**
     * 计算当前顶点与另一个顶点之间的距离。
     * 使用距离公式：sqrt((x2 - x1)^2 + (y2 - y1)^2)。
     *
     * @param other 另一个顶点
     * @return 返回两个顶点之间的距离，类型为float
     */
    public float calcDistance(Vertex other) {
        return (float) Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}