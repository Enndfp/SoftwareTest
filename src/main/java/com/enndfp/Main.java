package com.enndfp;

import com.enndfp.adapters.AdapterCircle;
import com.enndfp.shapes.Polygon;
import com.enndfp.shapes.Rectangle;
import com.enndfp.shapes.Triangle;
import com.enndfp.vertex.Vertex;

public class Main {
    private Polygon[] polygons;

    public static void main(String[] args) {
        Main mainApp = new Main();
        mainApp.polygons = new Polygon[3];

        mainApp.polygons[0] = new Triangle(new Vertex(0, 0), new Vertex(3, 0), new Vertex(3, 4));
        mainApp.polygons[1] = new Rectangle(new Vertex(0, 0), new Vertex(4, 0), new Vertex(4, 3), new Vertex(0, 3));
        mainApp.polygons[2] = new AdapterCircle(new Vertex(0, 0), 5);

        for (Polygon polygon : mainApp.polygons) {
            polygon.draw();
            if (polygon.canForm()) {
                System.out.println("面积: " + polygon.calcArea());
            } else {
                System.out.println("无法构成有效的形状。");
            }
        }
    }
}