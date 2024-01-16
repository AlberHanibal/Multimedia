package colmenar.casas.alberto.appdibujo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class DibujosView extends View {

    Paint brocha1;
    Paint brocha2;

    public DibujosView(Context context) {

        super(context);
        brocha1 = new Paint();
        brocha1.setColor(0xFFFFFF00);
        brocha1.setStyle(Paint.Style.FILL);
        brocha2 = new Paint();
        brocha2.setColor(0xFF0000FF);
        brocha2.setStyle(Paint.Style.FILL);
    }

    public void onDraw(Canvas c) {
        float ancho = c.getWidth();
        float alto = c.getHeight();
        float incX = ancho / 10;
        Paint brocha = brocha1;
        for (int i = 0; i < 10; ++i) {
            c.drawRect(i * incX, 0, (i + 1) * incX, alto, brocha);
            brocha = (brocha == brocha1)?brocha2:brocha1;
        }
    }
}
