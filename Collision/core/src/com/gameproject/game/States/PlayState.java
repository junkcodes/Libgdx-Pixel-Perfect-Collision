package com.gameproject.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayState extends State {
    private Texture texture1, texture2;
    private int x=700,y=200,c=0;
    private TextureCollisionData textureCollisionData1, textureCollisionData2;

    public PlayState(GameStateManager gsm){
        super(gsm);
        texture1 = new Texture("creeper.png");
        texture2 = new Texture("star.png");

        textureCollisionData1 = new TextureCollisionData(texture1, 500, 500); // Just don't pass height and width if you don't want to resize the texture while rendering
        textureCollisionData2 = new TextureCollisionData(texture2,texture2.getWidth()/5,texture2.getHeight()/5); // Just don't pass height and width if you don't want to resize the texture while rendering
    }

    @Override
    public void handleInput(){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x++;
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) x--;
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) y++;
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) y--;
    }

    @Override
    public void update(float dt){
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(0, 0,0 , 1);
        sb.begin();
        sb.draw(texture1,100,10,500,500);
        sb.draw(texture2,x,y,texture2.getWidth()/5,texture2.getHeight()/5);
        if(Collision.PixelPerfectColl(textureCollisionData1, 100, 10, textureCollisionData2, x, y) == 1){ // PixelPerfectColl(TextureColl obj1, positionX1, positionY1, TextureColl obj2, positionX2, positionY2)
            c++;
            System.out.println("Collision   "+c);
        }
        sb.end();
    }
    @Override
    public void dispose(){
    }
}
