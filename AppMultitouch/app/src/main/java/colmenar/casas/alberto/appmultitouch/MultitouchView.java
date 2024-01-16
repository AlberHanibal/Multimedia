package colmenar.casas.alberto.appmultitouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

public class MultitouchView extends View {
    private Paint[] brochas;
    private PointF[] dedos;
    private int numDedos = 0;

    public MultitouchView(Context context) {
        super(context);
        brochas = new Paint[10];
        dedos = new PointF[10];
        int r = 0;
        int g = 0xFF;
        int b = 0;
        for (int i = 0; i < 10; i++) {
            dedos[i] = new PointF();
            brochas[i] = new Paint();
            brochas[i].setColor(0xFF000000 + (r << 16) + (g >> 8 ) + b);
            brochas[i].setStyle(Paint.Style.FILL);
            r += 20;
            g -= 20;
            b += 20;
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            numDedos = 0;
        } else {
            numDedos = event.getPointerCount();
            if (numDedos > 10) {
                numDedos = 10;
            }
            for (int i = 0; i < numDedos; ++i) {
                dedos[i].x = event.getX(i);
                dedos[i].y = event.getY(i);
            }
        }
        invalidate();
        return true;
    }

    public void onDraw(Canvas c) {
        c.drawColor(0xFFFFFFFF);
        for (int i = 0; i < numDedos; i++) {
            c.drawCircle(dedos[i].x, dedos[i].y, 70, brochas[i]);
        }
    }
}
