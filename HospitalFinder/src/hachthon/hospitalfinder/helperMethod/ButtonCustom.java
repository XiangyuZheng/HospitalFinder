package hachthon.hospitalfinder.helperMethod;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

public class ButtonCustom extends Button {

    Typeface TypefaceAvenir = FontCache.get("fonts/avenir-light.ttf", getContext());

    /**
     * @param context
     */
    public ButtonCustom(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public ButtonCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ButtonCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}