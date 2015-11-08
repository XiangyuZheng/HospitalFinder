package hachthon.hospitalfinder.helperMethod;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class ButtonCustom extends Button {

	public ButtonCustom(Context context) {
        super(context);
    }

    public ButtonCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }

    public ButtonCustom(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }
}