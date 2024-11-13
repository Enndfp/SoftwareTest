package com.enndfp.shapes;

import com.enndfp.vertex.Vertex;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Rectangle implements Polygon {
    private Vertex v1, v2, v3, v4; // 矩形的四个顶点

    @Override
    public void draw() {
        System.out.println("绘制一个矩形，顶点分别为: (" + v1.getX() + ", " + v1.getY() + "), (" + v2.getX() + ", " + v2.getY() + "), (" + v3.getX() + ", " + v3.getY() + "), (" + v4.getX() + ", " + v4.getY() + ")");
    }

    @Override
    public boolean canForm() {
        float d1 = v1.calcDistance(v2);
        float d2 = v2.calcDistance(v3);
        float d3 = v3.calcDistance(v4);
        float d4 = v4.calcDistance(v1);
        return d1 == d3 && d2 == d4;
    }

    @Override
    public float calcArea() {
        float length = v1.calcDistance(v2);
        float width = v2.calcDistance(v3);
        return length * width;
    }
}