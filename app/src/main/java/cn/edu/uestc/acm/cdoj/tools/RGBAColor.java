package cn.edu.uestc.acm.cdoj.tools;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;

/**
 * Created by Great on 2016/10/8.
 */

public class RGBAColor {
    public int R = 0;
    public int G = 0;
    public int B = 0;
    private Integer A;

    public RGBAColor(int R, int G, int B) {
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public RGBAColor(int R, int G, int B, int A) {
        this.R = R;
        this.G = G;
        this.B = B;
        this.A = A;
    }

    public Integer getA() {
        return A;
    }

    public float[] getColorMatrix(boolean asSkew) {
        if (asSkew) {
            if (A == null) {
                return new float[]{
                        1, 0, 0, 0, R,
                        0, 1, 0, 0, G,
                        0, 0, 1, 0, B,
                        0, 0, 0, 1, 0};
            }
            return new float[]{
                    1, 0, 0, 0, R,
                    0, 1, 0, 0, G,
                    0, 0, 1, 0, B,
                    0, 0, 0, 1, A};
        }
        if (A == null) {
            return new float[]{
                    0, 0, 0, 0, R,
                    0, 0, 0, 0, G,
                    0, 0, 0, 0, B,
                    0, 0, 0, 1, 0};
        }
        return new float[]{
                0, 0, 0, 0, R,
                0, 0, 0, 0, G,
                0, 0, 0, 0, B,
                0, 0, 0, 0, A};
    }

    public static float[] getColorMatrix(int R, int G, int B, boolean asSkew) {
        if (asSkew) {
            return new float[]{
                    1, 0, 0, 0, R,
                    0, 1, 0, 0, G,
                    0, 0, 1, 0, B,
                    0, 0, 0, 1, 0};
        }
        return new float[]{
                0, 0, 0, 0, R,
                0, 0, 0, 0, G,
                0, 0, 0, 0, B,
                0, 0, 0, 1, 0};
    }

    public static float[] getColorMatrix(int R, int G, int B, int A, boolean asSkew) {
        if (asSkew) {
            return new float[]{
                    1, 0, 0, 0, R,
                    0, 1, 0, 0, G,
                    0, 0, 1, 0, B,
                    0, 0, 0, 1, A};
        }
        return new float[]{
                0, 0, 0, 0, R,
                0, 0, 0, 0, G,
                0, 0, 0, 0, B,
                0, 0, 0, 0, A};
    }

    public static float[] getColorMatrixWithAlpha(Context context, @ColorRes int colorResource, boolean asSkew, int alpha) {
        int[] RGBA = getRGBAFromColorResource(context, colorResource);
        if (asSkew) {
            return new float[]{
                    1, 0, 0, 0, RGBA[0],
                    0, 1, 0, 0, RGBA[1],
                    0, 0, 1, 0, RGBA[2],
                    0, 0, 0, 0, alpha};
        }
        return new float[]{
                0, 0, 0, 0, RGBA[0],
                0, 0, 0, 0, RGBA[1],
                0, 0, 0, 0, RGBA[2],
                0, 0, 0, 0, alpha};
    }

        public static float[] getColorMatrix(Context context, @ColorRes int colorResource, boolean includeAlpha) {
        return getColorMatrix(context, colorResource, false, includeAlpha);
    }

    public static float[] getColorMatrix(Context context, @ColorRes int colorResource, boolean asSkew, boolean includeAlpha) {
        int color = ContextCompat.getColor(context, colorResource);
        int A = (color & 0xff000000) >>> 24;
        int R = (color & 0x00ff0000) >>> 16;
        int G = (color & 0x0000ff00) >>> 8;
        int B = (color & 0x000000ff);
        if (includeAlpha) {
            if (asSkew) {
                return new float[]{
                        1, 0, 0, 0, R,
                        0, 1, 0, 0, G,
                        0, 0, 1, 0, B,
                        0, 0, 0, 1, A};
            }
            return new float[]{
                    0, 0, 0, 0, R,
                    0, 0, 0, 0, G,
                    0, 0, 0, 0, B,
                    0, 0, 0, 0, A};
        } else {
            if (asSkew) {
                return new float[]{
                        1, 0, 0, 0, R,
                        0, 1, 0, 0, G,
                        0, 0, 1, 0, B,
                        0, 0, 0, 1, 0};
            }
            return new float[]{
                    0, 0, 0, 0, R,
                    0, 0, 0, 0, G,
                    0, 0, 0, 0, B,
                    0, 0, 0, 1, 0};
        }
    }

    public static float[] getColorMatrixWithPercentAlpha(Context context, @ColorRes int colorResource, float percent, boolean asSkew) {
        int[] RGBA = getRGBAFromColorResource(context, colorResource);
        if (asSkew) {
            return new float[]{
                    1, 0, 0, 0, RGBA[0],
                    0, 1, 0, 0, RGBA[1],
                    0, 0, 1, 0, RGBA[2],
                    0, 0, 0, percent, 0};
        }
        return new float[]{
                0, 0, 0, 0, RGBA[0],
                0, 0, 0, 0, RGBA[1],
                0, 0, 0, 0, RGBA[2],
                0, 0, 0, percent, 0};
    }

    public static float[] getColorMatrixWithPercentAlpha(int R, int G, int B, float percent, boolean asSkew) {
        if (asSkew) {
            return new float[]{
                    1, 0, 0, 0, R,
                    0, 1, 0, 0, G,
                    0, 0, 1, 0, B,
                    0, 0, 0, percent, 0};
        }
        return new float[]{
                0, 0, 0, 0, R,
                0, 0, 0, 0, G,
                0, 0, 0, 0, B,
                0, 0, 0, percent, 0};
    }

    private static int[] getRGBAFromColorResource(Context context, @ColorRes int colorResource){
        int color = ContextCompat.getColor(context, colorResource);
        int A = (color & 0xff000000) >>> 24;
        int R = (color & 0x00ff0000) >>> 16;
        int G = (color & 0x0000ff00) >>> 8;
        int B = (color & 0x000000ff);
        return new int[]{R, G, B, A};
    }
}
