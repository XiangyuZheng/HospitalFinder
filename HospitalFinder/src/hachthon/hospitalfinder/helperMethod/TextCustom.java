package hachthon.hospitalfinder.helperMethod;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextCustom extends TextView {

	public TextCustom(Context context) {
        super(context);
    }

    public TextCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }

    public TextCustom(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        CustomFontHelper.setCustomFont(this, context, attrs);
    }
}