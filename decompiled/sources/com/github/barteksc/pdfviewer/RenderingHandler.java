package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import com.github.barteksc.pdfviewer.model.PagePart;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes3.dex */
class RenderingHandler extends Handler {
    private static final String TAG = "com.github.barteksc.pdfviewer.RenderingHandler";
    private PDFView pdfView;
    private RectF renderBounds;
    private Matrix renderMatrix;
    private Rect roundedRenderBounds;
    private boolean running;

    RenderingHandler(Looper looper, PDFView pDFView) {
        super(looper);
        this.renderBounds = new RectF();
        this.roundedRenderBounds = new Rect();
        this.renderMatrix = new Matrix();
        this.running = false;
        this.pdfView = pDFView;
    }

    void addRenderingTask(int i, float f, float f2, RectF rectF, boolean z, int i2, boolean z2, boolean z3) {
        sendMessage(obtainMessage(1, new RenderingTask(f, f2, rectF, i, z, i2, z2, z3)));
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            final PagePart pagePartProceed = proceed((RenderingTask) message.obj);
            if (pagePartProceed != null) {
                if (this.running) {
                    this.pdfView.post(new Runnable() { // from class: com.github.barteksc.pdfviewer.RenderingHandler.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RenderingHandler.this.pdfView.onBitmapRendered(pagePartProceed);
                        }
                    });
                } else {
                    pagePartProceed.getRenderedBitmap().recycle();
                }
            }
        } catch (PageRenderingException e) {
            this.pdfView.post(new Runnable() { // from class: com.github.barteksc.pdfviewer.RenderingHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    RenderingHandler.this.pdfView.onPageError(e);
                }
            });
        }
    }

    private PagePart proceed(RenderingTask renderingTask) {
        PdfFile pdfFile = this.pdfView.pdfFile;
        pdfFile.openPage(renderingTask.page);
        int iRound = Math.round(renderingTask.width);
        int iRound2 = Math.round(renderingTask.height);
        if (iRound != 0 && iRound2 != 0 && !pdfFile.pageHasError(renderingTask.page)) {
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iRound, iRound2, renderingTask.bestQuality ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                calculateBounds(iRound, iRound2, renderingTask.bounds);
                pdfFile.renderPageBitmap(bitmapCreateBitmap, renderingTask.page, this.roundedRenderBounds, renderingTask.annotationRendering);
                return new PagePart(renderingTask.page, bitmapCreateBitmap, renderingTask.bounds, renderingTask.thumbnail, renderingTask.cacheOrder);
            } catch (IllegalArgumentException e) {
                Log.e(TAG, "Cannot create bitmap", e);
            }
        }
        return null;
    }

    private void calculateBounds(int i, int i2, RectF rectF) {
        this.renderMatrix.reset();
        float f = i;
        float f2 = i2;
        this.renderMatrix.postTranslate((-rectF.left) * f, (-rectF.top) * f2);
        this.renderMatrix.postScale(1.0f / rectF.width(), 1.0f / rectF.height());
        this.renderBounds.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f, f2);
        this.renderMatrix.mapRect(this.renderBounds);
        this.renderBounds.round(this.roundedRenderBounds);
    }

    void stop() {
        this.running = false;
    }

    void start() {
        this.running = true;
    }

    private class RenderingTask {
        boolean annotationRendering;
        boolean bestQuality;
        RectF bounds;
        int cacheOrder;
        float height;
        int page;
        boolean thumbnail;
        float width;

        RenderingTask(float f, float f2, RectF rectF, int i, boolean z, int i2, boolean z2, boolean z3) {
            this.page = i;
            this.width = f;
            this.height = f2;
            this.bounds = rectF;
            this.thumbnail = z;
            this.cacheOrder = i2;
            this.bestQuality = z2;
            this.annotationRendering = z3;
        }
    }
}
