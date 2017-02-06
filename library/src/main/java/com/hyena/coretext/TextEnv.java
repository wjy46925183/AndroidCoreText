/*
 * Copyright (C) 2017 The AndroidCoreText Project
 */

package com.hyena.coretext;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * Created by yangzc on 17/1/20.
 */
public class TextEnv {

    private int mVerticalSpacing;
    private int mPageWidth, mPageHeight;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private boolean mEditable = true;

    private TextEnv() {}

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Paint getPaint() {
        return paint;
    }

    public int getVerticalSpacing() {
        return mVerticalSpacing;
    }

    private void setVerticalSpacing(int spacing) {
        this.mVerticalSpacing = spacing;
    }

    private void setPageWidth(int width) {
        this.mPageWidth = width;
    }

    private void setPageHeight(int height) {
        this.mPageHeight = height;
    }

    public int getPageWidth() {
        return mPageWidth;
    }

    public int getPageHeight() {
        return mPageHeight;
    }

    private void setEditable(boolean editable) {
        this.mEditable = editable;
    }

    public boolean isEditable() {
        return mEditable;
    }

    public static class Builder {

        private int fontSize = 50;
        private int textColor = Color.BLACK;
        private Typeface typeface;
        private int verticalSpacing = 0;
        private int mPageWidth = 0;
        private int mPageHeight = 0;
        private boolean mEditable = true;

        public Builder() {}

        public Builder setFontSize(int fontSize) {
            this.fontSize = fontSize;
            return this;
        }

        public Builder setTextColor(int color) {
            this.textColor = color;
            return this;
        }

        public Builder setTypeFace(Typeface typeface) {
            this.typeface = typeface;
            return this;
        }

        public Builder setVerticalSpacing(int spacing) {
            this.verticalSpacing = spacing;
            return this;
        }

        public Builder setPageWidth(int width) {
            this.mPageWidth = width;
            return this;
        }

        public Builder setPageHeight(int height) {
            this.mPageHeight = height;
            return this;
        }

        public Builder setEditable(boolean editable) {
            this.mEditable = editable;
            return this;
        }

        public TextEnv build() {
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setColor(textColor);
            if (fontSize <= 0) {
                fontSize = 60;
            }
            paint.setTextSize(fontSize);
            if (typeface != null)
                paint.setTypeface(typeface);

            TextEnv textEnv = new TextEnv();
            textEnv.setPaint(paint);
            textEnv.setVerticalSpacing(verticalSpacing);
            textEnv.setPageWidth(mPageWidth);
            textEnv.setPageHeight(mPageHeight);
            textEnv.setEditable(mEditable);
            return textEnv;
        }
    }
}