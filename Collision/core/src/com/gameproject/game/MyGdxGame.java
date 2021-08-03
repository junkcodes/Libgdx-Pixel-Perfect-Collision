package  com.gameproject.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gameproject.game.States.GameStateManager;
import com.gameproject.game.States.PlayState;

import java.io.IOException;

public class MyGdxGame extends ApplicationAdapter {
	public static final int width = 840;
	public static final int height = 520;
	public static final String title = "Pixel Perfect Collision";
	private GameStateManager gsm;
	SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new PlayState(gsm));
    }

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}


}
