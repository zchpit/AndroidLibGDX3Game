package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public abstract class Shape {
    protected enum Type{Static, Dynamic, Kinematic} // 3 typy obiektow w box2d
    protected Sprite sprite; // nasz obrazek
    protected Texture texture; // teksura
    protected BodyDef bodyDef;
    protected Body body;

    public Shape(float x, float y, String path, Type type)
    {
        texture = new Texture(Gdx.files.internal(path));
        sprite = new Sprite(texture);
        sprite.setPosition(x * Box2dWorld.SCALE, y * Box2dWorld.SCALE);
        sprite.setSize(sprite.getWidth() * Box2dWorld.SCALE, sprite.getHeight() * Box2dWorld.SCALE);
        sprite.flip(false, true); // obracamy z powodu kamery

        bodyDef = new BodyDef();
        switch(type)
        {
            case Static:
                bodyDef.type = BodyDef.BodyType.StaticBody;
                break;
            case Dynamic:
                bodyDef.type = BodyDef.BodyType.DynamicBody;
                break;
            case Kinematic:
                bodyDef.type = BodyDef.BodyType.KinematicBody;
                break;
        }
        bodyDef.position.set(new Vector2(sprite.getX(), sprite.getY()));
        body = Box2dWorld.WORLD.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sprite.getWidth()/2, sprite.getHeight()/2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;

        body.createFixture(fixtureDef);
    }

    public boolean touched()
    {
        if(Gdx.input.justTouched()) // jesli dotknieto ekranu
        {
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0); // pobieramy x i y dotkniecia
            Graphics.camera.unproject(touchPos);
            if(sprite.getX() <= touchPos.x && sprite.getX() + sprite.getWidth() >= touchPos.x
                    && sprite.getY() <= touchPos.y && sprite.getY() + sprite.getHeight() >= touchPos.y) // nasz algorytm, ktora wykrywa, czy dotknieto obiektu
            {
                return true;
            }
        }
        return false;
    }

    public Body getBody()
    {
        return body;
    }

    public Sprite getSprite()
    {
        return sprite;
    }
}
