package com.gameproject.game.States;

import java.util.Vector;

import static java.lang.Integer.max;


public class Collision {
    private static byte[][] mapfirst,mapsecond;
    private static Vector xfirstedge, yfirstedge, xsecondedge, ysecondedge;
    private static int exfirst,eyfirst, exsecond, eysecond, mxfirst,myfirst, mxsecond, mysecond;
    private static TextureCollisionData first, second;

    public static int PixelPerfectColl(TextureCollisionData texture1, int x1, int y1, TextureCollisionData texture2, int x2, int y2){
        first = texture1;
        second = texture2;
        mapfirst = first.getMap();
        mapsecond = second.getMap();
        xfirstedge = first.getEdgeX();
        yfirstedge = first.getEdgeY();
        xsecondedge = second.getEdgeX();
        ysecondedge = second.getEdgeY();
        exfirst = x1;
        eyfirst = y1;
        exsecond = x2;
        eysecond = y2;
        mxfirst = x1;
        myfirst = y1;
        mxsecond = x2;
        mysecond = y2;

        int sizefirst = xfirstedge.size(), sizesecond = xsecondedge.size(), iteration = max(sizefirst,sizesecond);
        for(int i=0; i < iteration ; i++) {
            if (i < sizefirst) {
                int xfirst = (Integer) xfirstedge.get(i) + exfirst, yfirst = (Integer) yfirstedge.get(i) + eyfirst;
                if (xfirst - mxsecond >= 0 && xfirst - mxsecond <= mapsecond.length - 1 && yfirst - mysecond >= 0 && yfirst - mysecond <= mapsecond[0].length - 1)
                    if (mapsecond[xfirst - mxsecond][yfirst - mysecond] == 1) return 1;
            }
            if(i < sizesecond){
                int xsecond = (Integer) xsecondedge.get(i) + exsecond, ysecond = (Integer) ysecondedge.get(i) + eysecond;
                if (xsecond - mxfirst >= 0 && xsecond - mxfirst <= mapfirst.length - 1 && ysecond - myfirst >= 0 && ysecond - myfirst <= mapfirst[0].length - 1)
                    if (mapfirst[xsecond - mxfirst][ysecond - myfirst] == 1) return 1;
            }
        }
        return 0;
    }
}
