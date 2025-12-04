package com.bumptech.glide.integration.webp;

/* loaded from: classes2.dex */
public class WebpFrameInfo {
    public final boolean blendPreviousFrame;
    public final boolean disposeBackgroundColor;
    public final int duration;
    public final int frameNumber;
    public final int height;
    public final int width;
    public final int xOffset;
    public final int yOffset;

    WebpFrameInfo(int i, WebpFrame webpFrame) {
        this.frameNumber = i;
        this.xOffset = webpFrame.getXOffest();
        this.yOffset = webpFrame.getYOffest();
        this.width = webpFrame.getWidth();
        this.height = webpFrame.getHeight();
        this.duration = webpFrame.getDurationMs();
        this.blendPreviousFrame = webpFrame.isBlendWithPreviousFrame();
        this.disposeBackgroundColor = webpFrame.shouldDisposeToBackgroundColor();
    }

    public String toString() {
        return "frameNumber=" + this.frameNumber + ", xOffset=" + this.xOffset + ", yOffset=" + this.yOffset + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", blendPreviousFrame=" + this.blendPreviousFrame + ", disposeBackgroundColor=" + this.disposeBackgroundColor;
    }
}
