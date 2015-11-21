package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	public static Graphics GRAPHICS; // nasza grafika
	Game game; // nasza gra

	@Override
	public void create ()
	{
		GRAPHICS = new Graphics();
		game = new Game();
	}

	@Override
	public void render ()
	{
		GRAPHICS.update(); // aktualizujemy grafike
		game.update(); // aktualizujemy gre
	}
}
