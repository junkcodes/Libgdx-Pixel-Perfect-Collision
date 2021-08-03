package com.gameproject.game.States;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

import java.util.Vector;

public class TextureCollisionData {
    private Color color,colorf,colorb,coloru,colord;
    private Pixmap pixmap, pixmaptmp;
    private int x,y;
    private byte[][] map;
    private Vector xedge, yedge;

    public TextureCollisionData(Texture texture){
        color = new Color();
        colorf = new Color();
        colorb = new Color();
        coloru = new Color();
        colord = new Color();
        texture.getTextureData().prepare();
        pixmap = texture.getTextureData().consumePixmap();
        x = pixmap.getWidth();
        y = pixmap.getHeight();
        map = new byte[x+1][y+1];
        xedge = new Vector();
        yedge = new Vector();
        for(int i=0; i <= x; i++){
            for(int j=0; j <= y; j++){
                Color.rgba8888ToColor(color, pixmap.getPixel(i,j));
                if(color.a * 255f != 0){
                    map[i][y-j] = 1;
                    Color.rgba8888ToColor(colorf, pixmap.getPixel(i+1,j));
                    Color.rgba8888ToColor(colorb, pixmap.getPixel(i-1,j));
                    Color.rgba8888ToColor(coloru, pixmap.getPixel(i,j-1));
                    Color.rgba8888ToColor(colord, pixmap.getPixel(i,j+1));
                    if(colorf.a * 255f == 0 || colorb.a * 255f == 0 || coloru.a * 255f == 0 || colord.a * 255f == 0){
                        xedge.add(i);
                        yedge.add(y-j);
                    }
                }
            }
        }
    }

    public TextureCollisionData(Texture texture, int width, int height){
        color = new Color();
        colorf = new Color();
        colorb = new Color();
        coloru = new Color();
        colord = new Color();
        texture.getTextureData().prepare();
        pixmaptmp = texture.getTextureData().consumePixmap();
        pixmap = new Pixmap(width, height, pixmaptmp.getFormat());
        pixmap.drawPixmap(pixmaptmp, 0, 0, pixmaptmp.getWidth(), pixmaptmp.getHeight(), 0, 0, pixmap.getWidth(), pixmap.getHeight());
        x = pixmap.getWidth();
        y = pixmap.getHeight();
        map = new byte[x+1][y+1];
        xedge = new Vector();
        yedge = new Vector();
        for(int i=0; i <= x; i++){
            for(int j=0; j <= y; j++){
                Color.rgba8888ToColor(color, pixmap.getPixel(i,j));
                if(color.a * 255f != 0){
                    map[i][y-j] = 1;
                    Color.rgba8888ToColor(colorf, pixmap.getPixel(i+1,j));
                    Color.rgba8888ToColor(colorb, pixmap.getPixel(i-1,j));
                    Color.rgba8888ToColor(coloru, pixmap.getPixel(i,j-1));
                    Color.rgba8888ToColor(colord, pixmap.getPixel(i,j+1));
                    if(colorf.a * 255f == 0 || colorb.a * 255f == 0 || coloru.a * 255f == 0 || colord.a * 255f == 0){
                        xedge.add(i);
                        yedge.add(y-j);
                    }
                }
            }
        }
    }

    public byte[][] getMap(){
        return map;
    }
    public Vector getEdgeX(){
        return xedge;
    }
    public Vector getEdgeY(){
        return yedge;
    }


}
