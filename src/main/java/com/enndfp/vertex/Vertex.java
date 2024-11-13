package com.enndfp.vertex;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vertex {
    private float x;
    private float y;

    public float calcDistance(Vertex other) {
        return (float) Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}