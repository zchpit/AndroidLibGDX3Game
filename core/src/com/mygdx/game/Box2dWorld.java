package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;


public class Box2dWorld {
    public static final float SCALE = 0.01f; // box2d wymaga innych jednostek
    public static World WORLD;

    public Box2dWorld()
    {
        WORLD = new World(new Vector2(0, 9.8f), true);
    }

    public void update()
    {
        WORLD.step(1/60f, 8, 3);
    }
}
