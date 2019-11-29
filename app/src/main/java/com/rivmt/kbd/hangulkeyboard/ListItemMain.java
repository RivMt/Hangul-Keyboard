package com.rivmt.kbd.hangulkeyboard;

import android.graphics.drawable.Drawable;

public class ListItemMain {
    private Drawable iconDrawable;
    private String str;

    public void setIcon(Drawable icon) {
        iconDrawable = icon;
    }

    public void setText(String txt) {
        str = txt;
    }

    public Drawable getIcon() {
        return this.iconDrawable;
    }

    public String getText() {
        return this.str;
    }
}
