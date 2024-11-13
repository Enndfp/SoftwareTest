package com.enndfp.shapes;

import com.enndfp.vertex.Vertex;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Triangle implements Polygon {
    private Vertex v1, v2, v3;

    @Override
    public void draw() {
        System.out.println("绘制一个三角形，顶点分别为: (" + v1.getX() + ", " + v1.getY() + "), (" + v2.getX() + ", " + v2.getY() + "), (" + v3.getX() + ", " + v3.getY() + ")");
    }

    @Override
    public boolean canForm() {
        float d1 = v1.calcDistance(v2);
        float d2 = v2.calcDistance(v3);
        float d3 = v3.calcDistance(v1);
        return (d1 + d2 > d3) && (d2 + d3 > d1) && (d3 + d1 > d2);
    }

    @Override
    public float calcArea() {
        float d1 = v1.calcDistance(v2);
        float d2 = v2.calcDistance(v3);
        float d3 = v3.calcDistance(v1);
        float s = (d1 + d2 + d3) / 2;
        return (float) Math.sqrt(s * (s - d1) * (s - d2) * (s - d3));
    }
}