package com.enndfp.adapters;

import com.enndfp.shapes.Circle;
import com.enndfp.shapes.Polygon;
import com.enndfp.vertex.Vertex;

public class AdapterCircle implements Polygon {
    private Circle circle;

    public AdapterCircle(Vertex center, float radius) {
        this.circle = new Circle(center, radius);
    }

    @Override
    public void draw() {
        circle.drawCircle();
    }

    @Override
    public boolean canForm() {
        return circle != null && circle.areaCircle() > 0;
    }

    @Override
    public float calcArea() {
        return circle.areaCircle();
    }
}