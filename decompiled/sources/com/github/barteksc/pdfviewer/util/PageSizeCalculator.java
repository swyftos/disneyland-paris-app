package com.github.barteksc.pdfviewer.util;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;

/* loaded from: classes3.dex */
public class PageSizeCalculator {
    private boolean fitEachPage;
    private FitPolicy fitPolicy;
    private float heightRatio;
    private SizeF optimalMaxHeightPageSize;
    private SizeF optimalMaxWidthPageSize;
    private final Size originalMaxHeightPageSize;
    private final Size originalMaxWidthPageSize;
    private final Size viewSize;
    private float widthRatio;

    public PageSizeCalculator(FitPolicy fitPolicy, Size size, Size size2, Size size3, boolean z) {
        this.fitPolicy = fitPolicy;
        this.originalMaxWidthPageSize = size;
        this.originalMaxHeightPageSize = size2;
        this.viewSize = size3;
        this.fitEachPage = z;
        calculateMaxPages();
    }

    public SizeF calculate(Size size) {
        if (size.getWidth() <= 0 || size.getHeight() <= 0) {
            return new SizeF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        }
        float width = this.fitEachPage ? this.viewSize.getWidth() : size.getWidth() * this.widthRatio;
        float height = this.fitEachPage ? this.viewSize.getHeight() : size.getHeight() * this.heightRatio;
        int i = AnonymousClass1.$SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy[this.fitPolicy.ordinal()];
        if (i == 1) {
            return fitHeight(size, height);
        }
        if (i == 2) {
            return fitBoth(size, width, height);
        }
        return fitWidth(size, width);
    }

    /* renamed from: com.github.barteksc.pdfviewer.util.PageSizeCalculator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy;

        static {
            int[] iArr = new int[FitPolicy.values().length];
            $SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy = iArr;
            try {
                iArr[FitPolicy.HEIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy[FitPolicy.BOTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public SizeF getOptimalMaxWidthPageSize() {
        return this.optimalMaxWidthPageSize;
    }

    public SizeF getOptimalMaxHeightPageSize() {
        return this.optimalMaxHeightPageSize;
    }

    private void calculateMaxPages() {
        int i = AnonymousClass1.$SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy[this.fitPolicy.ordinal()];
        if (i == 1) {
            SizeF sizeFFitHeight = fitHeight(this.originalMaxHeightPageSize, this.viewSize.getHeight());
            this.optimalMaxHeightPageSize = sizeFFitHeight;
            this.heightRatio = sizeFFitHeight.getHeight() / this.originalMaxHeightPageSize.getHeight();
            this.optimalMaxWidthPageSize = fitHeight(this.originalMaxWidthPageSize, r0.getHeight() * this.heightRatio);
            return;
        }
        if (i == 2) {
            float width = fitBoth(this.originalMaxWidthPageSize, this.viewSize.getWidth(), this.viewSize.getHeight()).getWidth() / this.originalMaxWidthPageSize.getWidth();
            SizeF sizeFFitBoth = fitBoth(this.originalMaxHeightPageSize, r1.getWidth() * width, this.viewSize.getHeight());
            this.optimalMaxHeightPageSize = sizeFFitBoth;
            this.heightRatio = sizeFFitBoth.getHeight() / this.originalMaxHeightPageSize.getHeight();
            SizeF sizeFFitBoth2 = fitBoth(this.originalMaxWidthPageSize, this.viewSize.getWidth(), this.originalMaxWidthPageSize.getHeight() * this.heightRatio);
            this.optimalMaxWidthPageSize = sizeFFitBoth2;
            this.widthRatio = sizeFFitBoth2.getWidth() / this.originalMaxWidthPageSize.getWidth();
            return;
        }
        SizeF sizeFFitWidth = fitWidth(this.originalMaxWidthPageSize, this.viewSize.getWidth());
        this.optimalMaxWidthPageSize = sizeFFitWidth;
        this.widthRatio = sizeFFitWidth.getWidth() / this.originalMaxWidthPageSize.getWidth();
        this.optimalMaxHeightPageSize = fitWidth(this.originalMaxHeightPageSize, r0.getWidth() * this.widthRatio);
    }

    private SizeF fitWidth(Size size, float f) {
        return new SizeF(f, (float) Math.floor(f / (size.getWidth() / size.getHeight())));
    }

    private SizeF fitHeight(Size size, float f) {
        return new SizeF((float) Math.floor(f / (size.getHeight() / size.getWidth())), f);
    }

    private SizeF fitBoth(Size size, float f, float f2) {
        float width = size.getWidth() / size.getHeight();
        float fFloor = (float) Math.floor(f / width);
        if (fFloor > f2) {
            f = (float) Math.floor(width * f2);
        } else {
            f2 = fFloor;
        }
        return new SizeF(f, f2);
    }
}
