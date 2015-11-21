package com.mygdx.game;

import java.util.Random;
import java.util.Vector;

/**
 * Created by xyz on 11.11.15.
 */
public class ObjectManager {
    Vector<Line>line; // nasz vector linii
    Vector<Square>square; // nasz vector kwadratow
    float t_FromCreatingObject = 0; // czas od ostatniego stworzenia obiektu
    float t_WhenObjectIsCreated = 1.0f; // czas kiedy obiekt ma byc tworzony
    Random rand; // klasa odpowiedzialna za losowanie

    public ObjectManager()
    {
        line = new Vector<Line>();
        square = new Vector<Square>();
        rand = new Random();
        createObjects(); // tworzymy obiekty na ekranie
    }
    private void createObjects()
    {
        for(int i =0 ; i != 4 ; i++)
        {
            String path = "";
            int x = 0,y = 0;
            int objectSize = 50;
            switch(i)
            {
                case 0:
                    path = "zielonaLinia.png";
                    x = 0;
                    y = 0;
                    break;
                case 1:
                    path = "zoltaLinia.png";
                    x = 0;
                    y = 1200 - objectSize;
                    break;
                case 2:
                    path = "czerwonaLinia.png";
                    x = 1920 - objectSize;
                    y = 0;
                    break;
                case 3:
                    path = "niebieskaLinia.png";
                    x = 0;
                    y = 0;
                    break;
            }
            line.add(new Line(x,y,path, Shape.Type.Static));
        }
    }
    public void update()
    {
        //
    }

    public Vector<Line> getLine()
    {
        return line;
    }
    public Vector<Square> getSquare()
    {
        return square;
    }
}
