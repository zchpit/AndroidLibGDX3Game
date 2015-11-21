package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Square extends Shape {
    String path2[]; //  tablica sciezek
    Texture text2[]; //  tablica tekstur
    int text2Number; // numer tekstury

    public Square(float x, float y, String path, Type type) {
        super(x, y, path, type);

        path2 = new String[4]; // 4 sciezki, bo 4 kolory kwadratow
        text2 = new Texture[4]; // 4 tesktury, bo 4 sciezki
        setPath2(); // ustawiamy sciezki
        setText2(); // ustawiamy tekstury
        text2Number = -1; // numer aktualnie uzywanej tekstury
    }
    private void setPath2()
    {
        path2[0] = "czerwonyKwadrat.png"; // nasze sciezki do plikow
        path2[1] = "niebieskiKwadrat.png";
        path2[2] = "zoltyKwadrat.png";
        path2[3] = "zielonyKwadrat.png";
    }
    private void setText2()
    {
        for(int i = 0; i != text2.length; i++)
        {
            text2[i] = new Texture(Gdx.files.internal(path2[i])); // tworzymy tekstury i dopasowujemy do nich sciezki
        }
    }
    public void changeColor()
    {
        if(touched()) { // jesli dotknieto obiektu
            text2Number++; // zwieksz numer uzywanej tesktury
            if(text2Number > 3) // jesli numer jest wiekszy od 3
            {
                text2Number = 0; // to cofnij do 0
            }
            sprite.setTexture(text2[text2Number]); // przypisz teskture do sprite
        }
    }

}
