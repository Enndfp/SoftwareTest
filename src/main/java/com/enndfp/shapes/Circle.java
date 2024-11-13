package com.enndfp.shapes;

import com.enndfp.vertex.Vertex;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Circle {

    private Vertex center;
    private float radius;

    public void drawCircle() {
        System.out.println("绘制一个半径为 " + radius + " 的圆形，中心位于 (" + center.getX() + ", " + center.getY() + ")");
    }

    public float areaCircle() {
        return (float) (Math.PI * radius * radius);
    }
}