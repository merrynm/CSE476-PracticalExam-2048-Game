package mardero6.msu.exammardero6;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;



/**
 * Custom view class for our 2048 game.
 */
public class GameView extends View{

    /**
     * The actual game
     */
    private Game game;

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    private MainActivity mainActivity;

    /**
     * Getter for the actual game
     */
    public Game getGame() {
        return game;
    }

    public GameView(Context context) {
        super(context);
        init(null, 0);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        game = new Game();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        game.draw(canvas);
        game.setGameView(this);
    }

}