package mardero6.msu.exammardero6;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class Tile {
    /**
     * x location.
     * We use relative x locations in the range 0-1 for the center
     * of the puzzle piece.
     */
    private final int x;

    /**
     * y location
     */
    private final int y;

    /**
     * Paint for filling the area the puzzle is in
     */
    private final Paint fillPaint;

    /**
     * Number value displayed on the tile
     */
    private final int numVal;

    /**
     * Get the tile's number value
     */
    int getNumVal() {
        return numVal;
    }

    Tile(int numVal, int x, int y) {
        this.numVal = numVal;
        this.x = x;
        this.y = y;

        fillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        SetColor();

    }

    void draw(Canvas canvas, int marginX, int marginY, int gameSize)
    {
        if (numVal != 0)
        {
            int tileSize = gameSize / 4;
            int xLoc = marginX + tileSize * x;
            int yLoc = marginY + tileSize * y;

            Paint paint = new Paint();
            paint.setColor(Color.DKGRAY);
            paint.setTextSize(65);

            String num = Integer.toString(numVal);

            canvas.save();

            canvas.drawRect(xLoc, yLoc, xLoc + tileSize, yLoc + tileSize, fillPaint);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(num, xLoc+tileSize/2 - 10, yLoc+tileSize/2 + 20, paint);

            Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            linePaint.setColor(Color.DKGRAY);
            linePaint.setStrokeWidth(1);
            canvas.drawLine (xLoc + tileSize, yLoc + tileSize,
                    xLoc + tileSize, yLoc, linePaint);
            canvas.drawLine (xLoc + tileSize, yLoc + tileSize, xLoc,
                    yLoc + tileSize, linePaint);
            canvas.drawLine (xLoc, yLoc, xLoc + tileSize, yLoc, linePaint);
            canvas.drawLine (xLoc, yLoc, xLoc, yLoc + tileSize, linePaint);

            canvas.restore();
        }
    }

    private void SetColor()
    {
        if (numVal == 2) {
            fillPaint.setColor(0xFFB28AC0);
        } else if (numVal == 4) {
            fillPaint.setColor(0xFF8282E6);
        } else if (numVal == 8) {
            fillPaint.setColor(0xFF29297C);
        } else if (numVal == 16) {
            fillPaint.setColor(0xFF8CE06F);
        } else if (numVal == 32) {
            fillPaint.setColor(0xFFE0A46F);
        } else if (numVal == 64) {
            fillPaint.setColor(0xFFEEE382);
        } else if (numVal == 128) {
            fillPaint.setColor(0xFF82EED5);
        } else if (numVal == 256){
            fillPaint.setColor(0xFFC96FAA);
        } else if (numVal == 512) {
            fillPaint.setColor(0xFFEB5496);
        } else if (numVal == 1024) {
            fillPaint.setColor(0xFF7FAF95);
        } else if (numVal == 2048) {
            fillPaint.setColor(0xFF6B5457);
        }
    }
}
