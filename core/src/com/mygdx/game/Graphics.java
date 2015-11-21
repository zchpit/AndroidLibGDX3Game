package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Graphics {
    SpriteBatch batch; // miejsce na ktorym rysujemy
    public static OrthographicCamera camera;

    public Graphics()
    {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(1920f,1200f); // rozmiar naszego ekranu
        camera.setToOrtho(true,19.2f,12.0f); // skalujemy nasz ekran, specjalne wielkosci dla box2d
        batch.setProjectionMatrix(camera.combined); // do batcha dopasowujemy kamere
    }

    public void draw(Shape o)
    {
        /* najpierw stworzymy klase obiektu, a potem to umiescimy
        batch.begin(); // poczatek rysowania
        o.getSprite().setPosition(o.getBody().getPosition().x, o.getBody().getPosition().y); // ustawiamy pozycje do rysowania
        o.getSprite().draw(batch); // rysuj
        batch.end(); // koniec rysowania
        */
    }

    public void update()
    {
        Gdx.gl.glClearColor(1, 1, 1, 1); // rysowanie calego ekranu na bialo
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT); // czyszczenie buforu
        camera.update(); // aktualizowanie kamery
    }

}
