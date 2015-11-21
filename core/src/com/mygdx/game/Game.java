package com.mygdx.game;


public class Game {
    Box2dWorld box2dWorld; // nasz fizyczny swiat box2d
    ObjectManager objectManager; // nasz menadzer obiektow

    public Game()
    {
        box2dWorld = new Box2dWorld();
        objectManager= new ObjectManager();
    }

    private void drawObjects()
    {
        for(int i = 0; i != objectManager.getLine().size(); i++) {
            MyGdxGame.GRAPHICS.draw(objectManager.getLine().get(i));
        }
        for( int i = 0; i != objectManager.getSquare().size(); i++)
        {
            MyGdxGame.GRAPHICS.draw(objectManager.getSquare().get(i));
        }
    }

    public void update()
    {
        drawObjects(); // rysujemy wszystkie obiekty
        box2dWorld.update(); // aktualizujemy box2d
        objectManager.update(); // aktualizujemy menadzera
    }
}
