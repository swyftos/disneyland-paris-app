package com.github.barteksc.pdfviewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SizeF;
import android.widget.RelativeLayout;
import androidx.core.internal.view.SupportMenu;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import com.github.barteksc.pdfviewer.link.DefaultLinkHandler;
import com.github.barteksc.pdfviewer.link.LinkHandler;
import com.github.barteksc.pdfviewer.listener.Callbacks;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnLongPressListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnPageScrollListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;
import com.github.barteksc.pdfviewer.model.PagePart;
import com.github.barteksc.pdfviewer.scroll.ScrollHandle;
import com.github.barteksc.pdfviewer.source.AssetSource;
import com.github.barteksc.pdfviewer.source.ByteArraySource;
import com.github.barteksc.pdfviewer.source.DocumentSource;
import com.github.barteksc.pdfviewer.source.FileSource;
import com.github.barteksc.pdfviewer.source.InputStreamSource;
import com.github.barteksc.pdfviewer.source.UriSource;
import com.github.barteksc.pdfviewer.util.Constants;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.github.barteksc.pdfviewer.util.MathUtils;
import com.github.barteksc.pdfviewer.util.SnapEdge;
import com.github.barteksc.pdfviewer.util.Util;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import io.legere.pdfiumandroid.PdfDocument;
import io.legere.pdfiumandroid.PdfiumCore;
import io.legere.pdfiumandroid.util.Config;
import io.legere.pdfiumandroid.util.Size;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PDFView extends RelativeLayout {
    public static final float DEFAULT_MAX_SCALE = 3.0f;
    public static final float DEFAULT_MID_SCALE = 1.75f;
    public static final float DEFAULT_MIN_SCALE = 1.0f;
    private static final String TAG = "PDFView";
    private AnimationManager animationManager;
    private boolean annotationRendering;
    private PaintFlagsDrawFilter antialiasFilter;
    private boolean autoSpacing;
    private boolean bestQuality;
    CacheManager cacheManager;
    Callbacks callbacks;
    private int currentPage;
    private float currentXOffset;
    private float currentYOffset;
    private Paint debugPaint;
    private DecodingAsyncTask decodingAsyncTask;
    private int defaultPage;
    private boolean doubletapEnabled;
    private DragPinchManager dragPinchManager;
    private boolean dualPageMode;
    private boolean enableAntialiasing;
    private boolean enableSwipe;
    private boolean fitEachPage;
    private boolean hasSize;
    private boolean isLandscapeOrientation;
    private boolean isScrollHandleInit;
    private float maxZoom;
    private float midZoom;
    private float minZoom;
    private boolean nightMode;
    private List onDrawPagesNums;
    private FitPolicy pageFitPolicy;
    private boolean pageFling;
    private boolean pageSnap;
    private PagesLoader pagesLoader;
    private Paint paint;
    PdfFile pdfFile;
    private PdfiumCore pdfiumCore;
    private boolean recycled;
    private boolean renderDuringScale;
    RenderingHandler renderingHandler;
    private HandlerThread renderingHandlerThread;
    private ScrollDir scrollDir;
    private ScrollHandle scrollHandle;
    private int spacingPx;
    private State state;
    private boolean swipeVertical;
    private Configurator waitingDocumentConfigurator;
    private float zoom;

    enum ScrollDir {
        NONE,
        START,
        END
    }

    private enum State {
        DEFAULT,
        LOADED,
        SHOWN,
        ERROR
    }

    ScrollHandle getScrollHandle() {
        return this.scrollHandle;
    }

    public PDFView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.minZoom = 1.0f;
        this.midZoom = 1.75f;
        this.maxZoom = 3.0f;
        this.scrollDir = ScrollDir.NONE;
        this.currentXOffset = BitmapDescriptorFactory.HUE_RED;
        this.currentYOffset = BitmapDescriptorFactory.HUE_RED;
        this.zoom = 1.0f;
        this.recycled = true;
        this.state = State.DEFAULT;
        this.callbacks = new Callbacks();
        this.pageFitPolicy = FitPolicy.WIDTH;
        this.fitEachPage = false;
        this.defaultPage = 0;
        this.dualPageMode = false;
        this.isLandscapeOrientation = false;
        this.swipeVertical = true;
        this.enableSwipe = true;
        this.doubletapEnabled = true;
        this.nightMode = false;
        this.pageSnap = true;
        this.isScrollHandleInit = false;
        this.bestQuality = false;
        this.annotationRendering = false;
        this.renderDuringScale = false;
        this.enableAntialiasing = true;
        this.antialiasFilter = new PaintFlagsDrawFilter(0, 3);
        this.spacingPx = 0;
        this.autoSpacing = false;
        this.pageFling = true;
        this.onDrawPagesNums = new ArrayList(10);
        this.hasSize = false;
        this.renderingHandlerThread = new HandlerThread("PDF renderer");
        if (isInEditMode()) {
            return;
        }
        this.cacheManager = new CacheManager();
        AnimationManager animationManager = new AnimationManager(this);
        this.animationManager = animationManager;
        this.dragPinchManager = new DragPinchManager(this, animationManager);
        this.pagesLoader = new PagesLoader(this);
        this.paint = new Paint();
        Paint paint = new Paint();
        this.debugPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.pdfiumCore = new PdfiumCore(context, new Config());
        setWillNotDraw(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void load(DocumentSource documentSource, String str) {
        load(documentSource, str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void load(DocumentSource documentSource, String str, int[] iArr) {
        if (!this.recycled) {
            throw new IllegalStateException("Don't call load on a PDF View without recycling it first.");
        }
        this.recycled = false;
        DecodingAsyncTask decodingAsyncTask = new DecodingAsyncTask(documentSource, str, iArr, this, this.pdfiumCore);
        this.decodingAsyncTask = decodingAsyncTask;
        decodingAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void jumpTo(int i, boolean z) {
        PdfFile pdfFile = this.pdfFile;
        if (pdfFile == null) {
            return;
        }
        int iDetermineValidPageNumberFrom = pdfFile.determineValidPageNumberFrom(i);
        float f = iDetermineValidPageNumberFrom == 0 ? BitmapDescriptorFactory.HUE_RED : -this.pdfFile.getPageOffset(iDetermineValidPageNumberFrom, this.zoom);
        if (this.swipeVertical) {
            if (z) {
                this.animationManager.startYAnimation(this.currentYOffset, f);
            } else {
                moveTo(this.currentXOffset, f);
            }
        } else if (z) {
            this.animationManager.startXAnimation(this.currentXOffset, f);
        } else {
            moveTo(f, this.currentYOffset);
        }
        showPage(iDetermineValidPageNumberFrom);
    }

    public void jumpTo(int i) {
        jumpTo(i, false);
    }

    void showPage(int i) {
        if (this.recycled) {
            return;
        }
        this.currentPage = this.pdfFile.determineValidPageNumberFrom(i);
        loadPages();
        if (this.scrollHandle != null && !documentFitsView()) {
            this.scrollHandle.setPageNum(this.currentPage + 1);
        }
        this.callbacks.callOnPageChange(this.currentPage, this.pdfFile.getPagesCount());
    }

    public float getPositionOffset() {
        float f;
        float docLen;
        int width;
        if (this.swipeVertical) {
            f = -this.currentYOffset;
            docLen = this.pdfFile.getDocLen(this.zoom);
            width = getHeight();
        } else {
            f = -this.currentXOffset;
            docLen = this.pdfFile.getDocLen(this.zoom);
            width = getWidth();
        }
        return MathUtils.limit(f / (docLen - width), BitmapDescriptorFactory.HUE_RED, 1.0f);
    }

    public void setPositionOffset(float f, boolean z) {
        if (this.swipeVertical) {
            moveTo(this.currentXOffset, ((-this.pdfFile.getDocLen(this.zoom)) + getHeight()) * f, z);
        } else {
            moveTo(((-this.pdfFile.getDocLen(this.zoom)) + getWidth()) * f, this.currentYOffset, z);
        }
        loadPageByOffset();
    }

    public void setPositionOffset(float f) {
        setPositionOffset(f, true);
    }

    public void stopFling() {
        this.animationManager.stopFling();
    }

    public int getPageCount() {
        PdfFile pdfFile = this.pdfFile;
        if (pdfFile == null) {
            return 0;
        }
        return pdfFile.getPagesCount();
    }

    public void setSwipeEnabled(boolean z) {
        this.enableSwipe = z;
    }

    public void setNightMode(boolean z) {
        this.nightMode = z;
        if (z) {
            this.paint.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{-1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 255.0f, BitmapDescriptorFactory.HUE_RED, -1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 255.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, -1.0f, BitmapDescriptorFactory.HUE_RED, 255.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED})));
        } else {
            this.paint.setColorFilter(null);
        }
    }

    void enableDoubletap(boolean z) {
        this.doubletapEnabled = z;
    }

    boolean isDoubletapEnabled() {
        return this.doubletapEnabled;
    }

    void onPageError(PageRenderingException pageRenderingException) {
        if (this.callbacks.callOnPageError(pageRenderingException.getPage(), pageRenderingException.getCause())) {
            return;
        }
        Log.e(TAG, "Cannot open page " + pageRenderingException.getPage(), pageRenderingException.getCause());
    }

    public void recycle() {
        this.waitingDocumentConfigurator = null;
        this.animationManager.stopAll();
        this.dragPinchManager.disable();
        RenderingHandler renderingHandler = this.renderingHandler;
        if (renderingHandler != null) {
            renderingHandler.stop();
            this.renderingHandler.removeMessages(1);
        }
        DecodingAsyncTask decodingAsyncTask = this.decodingAsyncTask;
        if (decodingAsyncTask != null) {
            decodingAsyncTask.cancel(true);
        }
        this.cacheManager.recycle();
        ScrollHandle scrollHandle = this.scrollHandle;
        if (scrollHandle != null && this.isScrollHandleInit) {
            scrollHandle.destroyLayout();
        }
        PdfFile pdfFile = this.pdfFile;
        if (pdfFile != null) {
            pdfFile.dispose();
            this.pdfFile = null;
        }
        this.renderingHandler = null;
        this.scrollHandle = null;
        this.isScrollHandleInit = false;
        this.currentYOffset = BitmapDescriptorFactory.HUE_RED;
        this.currentXOffset = BitmapDescriptorFactory.HUE_RED;
        this.zoom = 1.0f;
        this.recycled = true;
        this.callbacks = new Callbacks();
        this.state = State.DEFAULT;
    }

    public boolean isRecycled() {
        return this.recycled;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (isInEditMode()) {
            return;
        }
        this.animationManager.computeFling();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        recycle();
        HandlerThread handlerThread = this.renderingHandlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.renderingHandlerThread = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        float docLen;
        float maxPageHeight;
        this.hasSize = true;
        Configurator configurator = this.waitingDocumentConfigurator;
        if (configurator != null) {
            configurator.load();
        }
        if (isInEditMode() || this.state != State.SHOWN) {
            return;
        }
        float f = (-this.currentXOffset) + (i3 * 0.5f);
        float f2 = (-this.currentYOffset) + (i4 * 0.5f);
        if (this.swipeVertical) {
            docLen = f / this.pdfFile.getMaxPageWidth();
            maxPageHeight = this.pdfFile.getDocLen(this.zoom);
        } else {
            docLen = f / this.pdfFile.getDocLen(this.zoom);
            maxPageHeight = this.pdfFile.getMaxPageHeight();
        }
        float f3 = f2 / maxPageHeight;
        this.animationManager.stopAll();
        this.pdfFile.recalculatePageSizes(new Size(i, i2));
        if (this.swipeVertical) {
            this.currentXOffset = ((-docLen) * this.pdfFile.getMaxPageWidth()) + (i * 0.5f);
            this.currentYOffset = ((-f3) * this.pdfFile.getDocLen(this.zoom)) + (i2 * 0.5f);
        } else {
            this.currentXOffset = ((-docLen) * this.pdfFile.getDocLen(this.zoom)) + (i * 0.5f);
            this.currentYOffset = ((-f3) * this.pdfFile.getMaxPageHeight()) + (i2 * 0.5f);
        }
        moveTo(this.currentXOffset, this.currentYOffset);
        loadPageByOffset();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        PdfFile pdfFile = this.pdfFile;
        if (pdfFile == null) {
            return true;
        }
        if (this.swipeVertical) {
            if (i >= 0 || this.currentXOffset >= BitmapDescriptorFactory.HUE_RED) {
                return i > 0 && this.currentXOffset + toCurrentScale(pdfFile.getMaxPageWidth()) > ((float) getWidth());
            }
            return true;
        }
        if (i >= 0 || this.currentXOffset >= BitmapDescriptorFactory.HUE_RED) {
            return i > 0 && this.currentXOffset + pdfFile.getDocLen(this.zoom) > ((float) getWidth());
        }
        return true;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        PdfFile pdfFile = this.pdfFile;
        if (pdfFile == null) {
            return true;
        }
        if (this.swipeVertical) {
            if (i >= 0 || this.currentYOffset >= BitmapDescriptorFactory.HUE_RED) {
                return i > 0 && this.currentYOffset + pdfFile.getDocLen(this.zoom) > ((float) getHeight());
            }
            return true;
        }
        if (i >= 0 || this.currentYOffset >= BitmapDescriptorFactory.HUE_RED) {
            return i > 0 && this.currentYOffset + toCurrentScale(pdfFile.getMaxPageHeight()) > ((float) getHeight());
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            return;
        }
        if (this.enableAntialiasing) {
            canvas.setDrawFilter(this.antialiasFilter);
        }
        Drawable background = getBackground();
        if (background == null) {
            canvas.drawColor(this.nightMode ? -16777216 : -1);
        } else {
            background.draw(canvas);
        }
        if (!this.recycled && this.state == State.SHOWN) {
            float f = this.currentXOffset;
            float f2 = this.currentYOffset;
            canvas.translate(f, f2);
            Iterator it = this.cacheManager.getThumbnails().iterator();
            while (it.hasNext()) {
                drawPart(canvas, (PagePart) it.next());
            }
            for (PagePart pagePart : this.cacheManager.getPageParts()) {
                drawPart(canvas, pagePart);
                if (this.callbacks.getOnDrawAll() != null && !this.onDrawPagesNums.contains(Integer.valueOf(pagePart.getPage()))) {
                    this.onDrawPagesNums.add(Integer.valueOf(pagePart.getPage()));
                }
            }
            Iterator it2 = this.onDrawPagesNums.iterator();
            while (it2.hasNext()) {
                drawWithListener(canvas, ((Integer) it2.next()).intValue(), this.callbacks.getOnDrawAll());
            }
            this.onDrawPagesNums.clear();
            drawWithListener(canvas, this.currentPage, this.callbacks.getOnDraw());
            canvas.translate(-f, -f2);
        }
    }

    private void drawWithListener(Canvas canvas, int i, OnDrawListener onDrawListener) {
        float pageOffset;
        if (onDrawListener != null) {
            boolean z = this.swipeVertical;
            float pageOffset2 = BitmapDescriptorFactory.HUE_RED;
            if (z) {
                pageOffset = this.pdfFile.getPageOffset(i, this.zoom);
            } else {
                pageOffset2 = this.pdfFile.getPageOffset(i, this.zoom);
                pageOffset = 0.0f;
            }
            canvas.translate(pageOffset2, pageOffset);
            SizeF pageSize = this.pdfFile.getPageSize(i);
            onDrawListener.onLayerDrawn(canvas, toCurrentScale(pageSize.getWidth()), toCurrentScale(pageSize.getHeight()), i);
            canvas.translate(-pageOffset2, -pageOffset);
        }
    }

    private void drawPart(Canvas canvas, PagePart pagePart) {
        float pageOffset;
        float currentScale;
        RectF pageRelativeBounds = pagePart.getPageRelativeBounds();
        Bitmap renderedBitmap = pagePart.getRenderedBitmap();
        if (renderedBitmap.isRecycled()) {
            return;
        }
        SizeF pageSize = this.pdfFile.getPageSize(pagePart.getPage());
        if (this.swipeVertical) {
            currentScale = this.pdfFile.getPageOffset(pagePart.getPage(), this.zoom);
            pageOffset = toCurrentScale(this.pdfFile.getMaxPageWidth() - pageSize.getWidth()) / 2.0f;
        } else {
            pageOffset = this.pdfFile.getPageOffset(pagePart.getPage(), this.zoom);
            currentScale = toCurrentScale(this.pdfFile.getMaxPageHeight() - pageSize.getHeight()) / 2.0f;
        }
        canvas.translate(pageOffset, currentScale);
        Rect rect = new Rect(0, 0, renderedBitmap.getWidth(), renderedBitmap.getHeight());
        float currentScale2 = toCurrentScale(pageRelativeBounds.left * pageSize.getWidth());
        float currentScale3 = toCurrentScale(pageRelativeBounds.top * pageSize.getHeight());
        RectF rectF = new RectF((int) currentScale2, (int) currentScale3, (int) (currentScale2 + toCurrentScale(pageRelativeBounds.width() * pageSize.getWidth())), (int) (currentScale3 + toCurrentScale(pageRelativeBounds.height() * pageSize.getHeight())));
        float f = this.currentXOffset + pageOffset;
        float f2 = this.currentYOffset + currentScale;
        if (rectF.left + f >= getWidth() || f + rectF.right <= BitmapDescriptorFactory.HUE_RED || rectF.top + f2 >= getHeight() || f2 + rectF.bottom <= BitmapDescriptorFactory.HUE_RED) {
            canvas.translate(-pageOffset, -currentScale);
            return;
        }
        canvas.drawBitmap(renderedBitmap, rect, rectF, this.paint);
        if (Constants.DEBUG_MODE) {
            this.debugPaint.setColor(pagePart.getPage() % 2 == 0 ? SupportMenu.CATEGORY_MASK : -16776961);
            canvas.drawRect(rectF, this.debugPaint);
        }
        canvas.translate(-pageOffset, -currentScale);
    }

    public void loadPages() {
        RenderingHandler renderingHandler;
        if (this.pdfFile == null || (renderingHandler = this.renderingHandler) == null) {
            return;
        }
        renderingHandler.removeMessages(1);
        this.cacheManager.makeANewSet();
        this.pagesLoader.loadPages();
        redraw();
    }

    void loadComplete(PdfFile pdfFile) {
        this.state = State.LOADED;
        this.pdfFile = pdfFile;
        if (this.renderingHandlerThread == null) {
            this.renderingHandlerThread = new HandlerThread("PDF renderer");
        }
        if (!this.renderingHandlerThread.isAlive()) {
            this.renderingHandlerThread.start();
        }
        RenderingHandler renderingHandler = new RenderingHandler(this.renderingHandlerThread.getLooper(), this);
        this.renderingHandler = renderingHandler;
        renderingHandler.start();
        ScrollHandle scrollHandle = this.scrollHandle;
        if (scrollHandle != null) {
            scrollHandle.setupLayout(this);
            this.isScrollHandleInit = true;
        }
        this.dragPinchManager.enable();
        this.callbacks.callOnLoadComplete(pdfFile.getPagesCount());
        jumpTo(this.defaultPage, false);
    }

    void loadError(Throwable th) {
        this.state = State.ERROR;
        OnErrorListener onError = this.callbacks.getOnError();
        recycle();
        invalidate();
        if (onError != null) {
            onError.onError(th);
        } else {
            Log.e("PDFView", "load pdf error", th);
        }
    }

    void redraw() {
        invalidate();
    }

    public void onBitmapRendered(PagePart pagePart) {
        if (this.state == State.LOADED) {
            this.state = State.SHOWN;
            this.callbacks.callOnRender(this.pdfFile.getPagesCount());
        }
        if (pagePart.isThumbnail()) {
            this.cacheManager.cacheThumbnail(pagePart);
        } else {
            this.cacheManager.cachePart(pagePart);
        }
        redraw();
    }

    public void moveTo(float f, float f2) {
        moveTo(f, f2, true);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004c  */
    /* JADX WARN: Code duplicated, block: B:17:0x0054  */
    /* JADX WARN: Code duplicated, block: B:19:0x0058  */
    /* JADX WARN: Code duplicated, block: B:20:0x005a  */
    /* JADX WARN: Code duplicated, block: B:22:0x0065  */
    /* JADX WARN: Code duplicated, block: B:25:0x0072  */
    /* JADX WARN: Code duplicated, block: B:26:0x0078  */
    /* JADX WARN: Code duplicated, block: B:28:0x007c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0082  */
    /* JADX WARN: Code duplicated, block: B:42:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:46:0x00db  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:54:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:55:0x0101  */
    public void moveTo(float f, float f2, boolean z) {
        float height;
        float docLen;
        float f3;
        float width;
        float docLen2;
        float f4;
        if (this.swipeVertical) {
            float currentScale = toCurrentScale(this.pdfFile.getMaxPageWidth());
            if (currentScale < getWidth()) {
                width = getWidth() / 2;
                currentScale /= 2.0f;
            } else {
                if (f > BitmapDescriptorFactory.HUE_RED) {
                    f = 0.0f;
                } else if (f + currentScale < getWidth()) {
                    width = getWidth();
                }
                docLen2 = this.pdfFile.getDocLen(this.zoom);
                if (docLen2 < getHeight()) {
                    f2 = (getHeight() - docLen2) / 2.0f;
                } else if (f2 > BitmapDescriptorFactory.HUE_RED) {
                    f2 = 0.0f;
                } else if (f2 + docLen2 < getHeight()) {
                    f2 = (-docLen2) + getHeight();
                }
                f4 = this.currentYOffset;
                if (f2 < f4) {
                    this.scrollDir = ScrollDir.END;
                } else if (f2 > f4) {
                    this.scrollDir = ScrollDir.START;
                } else {
                    this.scrollDir = ScrollDir.NONE;
                }
            }
            f = width - currentScale;
            docLen2 = this.pdfFile.getDocLen(this.zoom);
            if (docLen2 < getHeight()) {
                f2 = (getHeight() - docLen2) / 2.0f;
            } else if (f2 > BitmapDescriptorFactory.HUE_RED) {
                f2 = 0.0f;
            } else if (f2 + docLen2 < getHeight()) {
                f2 = (-docLen2) + getHeight();
            }
            f4 = this.currentYOffset;
            if (f2 < f4) {
                this.scrollDir = ScrollDir.END;
            } else if (f2 > f4) {
                this.scrollDir = ScrollDir.START;
            } else {
                this.scrollDir = ScrollDir.NONE;
            }
        } else {
            float currentScale2 = toCurrentScale(this.pdfFile.getMaxPageHeight());
            if (currentScale2 < getHeight()) {
                height = getHeight() / 2;
                currentScale2 /= 2.0f;
            } else {
                if (f2 > BitmapDescriptorFactory.HUE_RED) {
                    f2 = 0.0f;
                } else if (f2 + currentScale2 < getHeight()) {
                    height = getHeight();
                }
                docLen = this.pdfFile.getDocLen(this.zoom);
                if (docLen < getWidth()) {
                    f = (getWidth() - docLen) / 2.0f;
                } else if (f > BitmapDescriptorFactory.HUE_RED) {
                    f = 0.0f;
                } else if (f + docLen < getWidth()) {
                    f = (-docLen) + getWidth();
                }
                f3 = this.currentXOffset;
                if (f < f3) {
                    this.scrollDir = ScrollDir.END;
                } else if (f > f3) {
                    this.scrollDir = ScrollDir.START;
                } else {
                    this.scrollDir = ScrollDir.NONE;
                }
            }
            f2 = height - currentScale2;
            docLen = this.pdfFile.getDocLen(this.zoom);
            if (docLen < getWidth()) {
                f = (getWidth() - docLen) / 2.0f;
            } else if (f > BitmapDescriptorFactory.HUE_RED) {
                f = 0.0f;
            } else if (f + docLen < getWidth()) {
                f = (-docLen) + getWidth();
            }
            f3 = this.currentXOffset;
            if (f < f3) {
                this.scrollDir = ScrollDir.END;
            } else if (f > f3) {
                this.scrollDir = ScrollDir.START;
            } else {
                this.scrollDir = ScrollDir.NONE;
            }
        }
        this.currentXOffset = f;
        this.currentYOffset = f2;
        float positionOffset = getPositionOffset();
        if (z && this.scrollHandle != null && !documentFitsView()) {
            this.scrollHandle.setScroll(positionOffset);
        }
        this.callbacks.callOnPageScroll(getCurrentPage(), positionOffset);
        redraw();
    }

    void loadPageByOffset() {
        float f;
        int width;
        if (this.pdfFile.getPagesCount() == 0) {
            return;
        }
        if (this.swipeVertical) {
            f = this.currentYOffset;
            width = getHeight();
        } else {
            f = this.currentXOffset;
            width = getWidth();
        }
        int pageAtOffset = this.pdfFile.getPageAtOffset(-(f - (width / 2.0f)), this.zoom);
        if (pageAtOffset >= 0 && pageAtOffset <= this.pdfFile.getPagesCount() - 1 && pageAtOffset != getCurrentPage()) {
            showPage(pageAtOffset);
        } else {
            loadPages();
        }
    }

    public void performPageSnap() {
        performPageSnap(true);
    }

    public void performPageSnap(boolean z) {
        PdfFile pdfFile;
        int iFindFocusPage;
        SnapEdge snapEdgeFindSnapEdge;
        if (!this.pageSnap || (pdfFile = this.pdfFile) == null || pdfFile.getPagesCount() == 0 || (snapEdgeFindSnapEdge = findSnapEdge((iFindFocusPage = findFocusPage(this.currentXOffset, this.currentYOffset)))) == SnapEdge.NONE) {
            return;
        }
        float fSnapOffsetForPage = snapOffsetForPage(iFindFocusPage, snapEdgeFindSnapEdge);
        if (this.swipeVertical) {
            if (z) {
                this.animationManager.startYAnimation(this.currentYOffset, -fSnapOffsetForPage);
                return;
            } else {
                moveTo(this.currentXOffset, -fSnapOffsetForPage);
                return;
            }
        }
        if (z) {
            this.animationManager.startXAnimation(this.currentXOffset, -fSnapOffsetForPage);
        } else {
            moveTo(-fSnapOffsetForPage, this.currentYOffset);
        }
    }

    SnapEdge findSnapEdge(int i) {
        if (!this.pageSnap || i < 0) {
            return SnapEdge.NONE;
        }
        float f = this.swipeVertical ? this.currentYOffset : this.currentXOffset;
        float f2 = -this.pdfFile.getPageOffset(i, this.zoom);
        int height = this.swipeVertical ? getHeight() : getWidth();
        float pageLength = this.pdfFile.getPageLength(i, this.zoom);
        float f3 = height;
        if (f3 >= pageLength) {
            return SnapEdge.CENTER;
        }
        if (f >= f2) {
            return SnapEdge.START;
        }
        if (f2 - pageLength > f - f3) {
            return SnapEdge.END;
        }
        return SnapEdge.NONE;
    }

    float snapOffsetForPage(int i, SnapEdge snapEdge) {
        float f;
        float pageOffset = this.pdfFile.getPageOffset(i, this.zoom);
        float height = this.swipeVertical ? getHeight() : getWidth();
        float pageLength = this.pdfFile.getPageLength(i, this.zoom);
        if (snapEdge == SnapEdge.CENTER) {
            f = pageOffset - (height / 2.0f);
            pageLength /= 2.0f;
        } else {
            if (snapEdge != SnapEdge.END) {
                return pageOffset;
            }
            f = pageOffset - height;
        }
        return f + pageLength;
    }

    int findFocusPage(float f, float f2) {
        boolean z = this.swipeVertical;
        if (z) {
            f = f2;
        }
        float height = z ? getHeight() : getWidth();
        if (f > -1.0f) {
            return 0;
        }
        if (f < (-this.pdfFile.getDocLen(this.zoom)) + height + 1.0f) {
            return this.pdfFile.getPagesCount() - 1;
        }
        return this.pdfFile.getPageAtOffset(-(f - (height / 2.0f)), this.zoom);
    }

    public boolean pageFillsScreen() {
        float f = -this.pdfFile.getPageOffset(this.currentPage, this.zoom);
        float pageLength = f - this.pdfFile.getPageLength(this.currentPage, this.zoom);
        if (isSwipeVertical()) {
            float f2 = this.currentYOffset;
            return f > f2 && pageLength < f2 - ((float) getHeight());
        }
        float f3 = this.currentXOffset;
        return f > f3 && pageLength < f3 - ((float) getWidth());
    }

    public void moveRelativeTo(float f, float f2) {
        moveTo(this.currentXOffset + f, this.currentYOffset + f2);
    }

    public void zoomTo(float f) {
        this.zoom = f;
    }

    public void zoomCenteredTo(float f, PointF pointF) {
        float f2 = f / this.zoom;
        zoomTo(f);
        float f3 = this.currentXOffset * f2;
        float f4 = this.currentYOffset * f2;
        float f5 = pointF.x;
        float f6 = pointF.y;
        moveTo(f3 + (f5 - (f5 * f2)), f4 + (f6 - (f2 * f6)));
    }

    public void zoomCenteredRelativeTo(float f, PointF pointF) {
        zoomCenteredTo(this.zoom * f, pointF);
    }

    public boolean documentFitsView() {
        float docLen = this.pdfFile.getDocLen(1.0f);
        if (this.swipeVertical) {
            return docLen < ((float) getHeight());
        }
        return docLen < ((float) getWidth());
    }

    public void fitToWidth(int i) {
        if (this.state != State.SHOWN) {
            Log.e(TAG, "Cannot fit, document not rendered yet");
        } else {
            zoomTo(getWidth() / this.pdfFile.getPageSize(i).getWidth());
            jumpTo(i);
        }
    }

    public SizeF getPageSize(int i) {
        PdfFile pdfFile = this.pdfFile;
        if (pdfFile == null) {
            return new SizeF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        }
        return pdfFile.getPageSize(i);
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public float getCurrentXOffset() {
        return this.currentXOffset;
    }

    public float getCurrentYOffset() {
        return this.currentYOffset;
    }

    public float toRealScale(float f) {
        return f / this.zoom;
    }

    public float toCurrentScale(float f) {
        return f * this.zoom;
    }

    public float getZoom() {
        return this.zoom;
    }

    public boolean isZooming() {
        return this.zoom != this.minZoom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultPage(int i) {
        this.defaultPage = i;
    }

    public void resetZoom() {
        zoomTo(this.minZoom);
    }

    public void resetZoomWithAnimation() {
        zoomWithAnimation(this.minZoom);
    }

    public void zoomWithAnimation(float f, float f2, float f3) {
        this.animationManager.startZoomAnimation(f, f2, this.zoom, f3);
    }

    public void zoomWithAnimation(float f) {
        this.animationManager.startZoomAnimation(getWidth() / 2, getHeight() / 2, this.zoom, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollHandle(ScrollHandle scrollHandle) {
        this.scrollHandle = scrollHandle;
    }

    public int getPageAtPositionOffset(float f) {
        PdfFile pdfFile = this.pdfFile;
        return pdfFile.getPageAtOffset(pdfFile.getDocLen(this.zoom) * f, this.zoom);
    }

    public float getMinZoom() {
        return this.minZoom;
    }

    public void setMinZoom(float f) {
        this.minZoom = f;
    }

    public float getMidZoom() {
        return this.midZoom;
    }

    public void setMidZoom(float f) {
        this.midZoom = f;
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public void setMaxZoom(float f) {
        this.maxZoom = f;
    }

    public void useBestQuality(boolean z) {
        this.bestQuality = z;
    }

    public boolean isBestQuality() {
        return this.bestQuality;
    }

    public boolean isOnDualPageMode() {
        return this.dualPageMode;
    }

    public boolean isOnLandscapeOrientation() {
        return this.isLandscapeOrientation;
    }

    public void setLandscapeOrientation(boolean z) {
        this.isLandscapeOrientation = z;
    }

    public void setDualPageMode(boolean z) {
        this.dualPageMode = z;
    }

    public boolean isSwipeVertical() {
        return this.swipeVertical;
    }

    public boolean isSwipeEnabled() {
        return this.enableSwipe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSwipeVertical(boolean z) {
        this.swipeVertical = z;
    }

    public void enableAnnotationRendering(boolean z) {
        this.annotationRendering = z;
    }

    public boolean isAnnotationRendering() {
        return this.annotationRendering;
    }

    public void enableRenderDuringScale(boolean z) {
        this.renderDuringScale = z;
    }

    public boolean isAntialiasing() {
        return this.enableAntialiasing;
    }

    public void enableAntialiasing(boolean z) {
        this.enableAntialiasing = z;
    }

    public int getSpacingPx() {
        return this.spacingPx;
    }

    public boolean isAutoSpacingEnabled() {
        return this.autoSpacing;
    }

    public void setPageFling(boolean z) {
        this.pageFling = z;
    }

    public boolean isPageFlingEnabled() {
        return this.pageFling;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpacing(int i) {
        this.spacingPx = Util.getDP(getContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAutoSpacing(boolean z) {
        this.autoSpacing = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageFitPolicy(FitPolicy fitPolicy) {
        this.pageFitPolicy = fitPolicy;
    }

    public FitPolicy getPageFitPolicy() {
        return this.pageFitPolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFitEachPage(boolean z) {
        this.fitEachPage = z;
    }

    public boolean isFitEachPage() {
        return this.fitEachPage;
    }

    public boolean isPageSnap() {
        return this.pageSnap;
    }

    public void setPageSnap(boolean z) {
        this.pageSnap = z;
    }

    public boolean doRenderDuringScale() {
        return this.renderDuringScale;
    }

    public PdfDocument.Meta getDocumentMeta() {
        PdfFile pdfFile = this.pdfFile;
        if (pdfFile == null) {
            return null;
        }
        return pdfFile.getMetaData();
    }

    public List<PdfDocument.Bookmark> getTableOfContents() {
        PdfFile pdfFile = this.pdfFile;
        if (pdfFile == null) {
            return Collections.emptyList();
        }
        return pdfFile.getBookmarks();
    }

    public List<PdfDocument.Link> getLinks(int i) {
        PdfFile pdfFile = this.pdfFile;
        if (pdfFile == null) {
            return Collections.emptyList();
        }
        return pdfFile.getPageLinks(i);
    }

    public Configurator fromAsset(String str) {
        return new Configurator(new AssetSource(str));
    }

    public Configurator fromFile(File file) {
        return new Configurator(new FileSource(file));
    }

    public Configurator fromUri(Uri uri) {
        return new Configurator(new UriSource(uri));
    }

    public Configurator fromBytes(byte[] bArr) {
        return new Configurator(new ByteArraySource(bArr));
    }

    public Configurator fromStream(InputStream inputStream) {
        return new Configurator(new InputStreamSource(inputStream));
    }

    public Configurator fromSource(DocumentSource documentSource) {
        return new Configurator(documentSource);
    }

    public class Configurator {
        private boolean annotationRendering;
        private boolean antialiasing;
        private boolean autoSpacing;
        private int defaultPage;
        private final DocumentSource documentSource;
        private boolean dualPageMode;
        private boolean enableDoubletap;
        private boolean enableSwipe;
        private boolean fitEachPage;
        private boolean landscapeOrientation;
        private LinkHandler linkHandler;
        private boolean nightMode;
        private OnDrawListener onDrawAllListener;
        private OnDrawListener onDrawListener;
        private OnErrorListener onErrorListener;
        private OnLoadCompleteListener onLoadCompleteListener;
        private OnLongPressListener onLongPressListener;
        private OnPageChangeListener onPageChangeListener;
        private OnPageErrorListener onPageErrorListener;
        private OnPageScrollListener onPageScrollListener;
        private OnRenderListener onRenderListener;
        private OnTapListener onTapListener;
        private FitPolicy pageFitPolicy;
        private boolean pageFling;
        private int[] pageNumbers;
        private boolean pageSnap;
        private String password;
        private ScrollHandle scrollHandle;
        private int spacing;
        private boolean swipeHorizontal;

        private Configurator(DocumentSource documentSource) {
            this.pageNumbers = null;
            this.enableSwipe = true;
            this.enableDoubletap = true;
            this.linkHandler = new DefaultLinkHandler(PDFView.this);
            this.defaultPage = 0;
            this.landscapeOrientation = false;
            this.dualPageMode = false;
            this.swipeHorizontal = false;
            this.annotationRendering = false;
            this.password = null;
            this.scrollHandle = null;
            this.antialiasing = true;
            this.spacing = 0;
            this.autoSpacing = false;
            this.pageFitPolicy = FitPolicy.WIDTH;
            this.fitEachPage = false;
            this.pageFling = false;
            this.pageSnap = false;
            this.nightMode = false;
            this.documentSource = documentSource;
        }

        public Configurator pages(int... iArr) {
            this.pageNumbers = iArr;
            return this;
        }

        public Configurator enableSwipe(boolean z) {
            this.enableSwipe = z;
            return this;
        }

        public Configurator enableDoubletap(boolean z) {
            this.enableDoubletap = z;
            return this;
        }

        public Configurator enableAnnotationRendering(boolean z) {
            this.annotationRendering = z;
            return this;
        }

        public Configurator onDraw(OnDrawListener onDrawListener) {
            this.onDrawListener = onDrawListener;
            return this;
        }

        public Configurator onDrawAll(OnDrawListener onDrawListener) {
            this.onDrawAllListener = onDrawListener;
            return this;
        }

        public Configurator onLoad(OnLoadCompleteListener onLoadCompleteListener) {
            this.onLoadCompleteListener = onLoadCompleteListener;
            return this;
        }

        public Configurator onPageScroll(OnPageScrollListener onPageScrollListener) {
            this.onPageScrollListener = onPageScrollListener;
            return this;
        }

        public Configurator onError(OnErrorListener onErrorListener) {
            this.onErrorListener = onErrorListener;
            return this;
        }

        public Configurator onPageError(OnPageErrorListener onPageErrorListener) {
            this.onPageErrorListener = onPageErrorListener;
            return this;
        }

        public Configurator onPageChange(OnPageChangeListener onPageChangeListener) {
            this.onPageChangeListener = onPageChangeListener;
            return this;
        }

        public Configurator onRender(OnRenderListener onRenderListener) {
            this.onRenderListener = onRenderListener;
            return this;
        }

        public Configurator onTap(OnTapListener onTapListener) {
            this.onTapListener = onTapListener;
            return this;
        }

        public Configurator onLongPress(OnLongPressListener onLongPressListener) {
            this.onLongPressListener = onLongPressListener;
            return this;
        }

        public Configurator linkHandler(LinkHandler linkHandler) {
            this.linkHandler = linkHandler;
            return this;
        }

        public Configurator defaultPage(int i) {
            this.defaultPage = i;
            return this;
        }

        public Configurator landscapeOrientation(boolean z) {
            this.landscapeOrientation = z;
            return this;
        }

        public Configurator dualPageMode(boolean z) {
            this.dualPageMode = z;
            return this;
        }

        public Configurator swipeHorizontal(boolean z) {
            this.swipeHorizontal = z;
            return this;
        }

        public Configurator password(String str) {
            this.password = str;
            return this;
        }

        public Configurator scrollHandle(ScrollHandle scrollHandle) {
            this.scrollHandle = scrollHandle;
            return this;
        }

        public Configurator enableAntialiasing(boolean z) {
            this.antialiasing = z;
            return this;
        }

        public Configurator spacing(int i) {
            this.spacing = i;
            return this;
        }

        public Configurator autoSpacing(boolean z) {
            this.autoSpacing = z;
            return this;
        }

        public Configurator pageFitPolicy(FitPolicy fitPolicy) {
            this.pageFitPolicy = fitPolicy;
            return this;
        }

        public Configurator fitEachPage(boolean z) {
            this.fitEachPage = z;
            return this;
        }

        public Configurator pageSnap(boolean z) {
            this.pageSnap = z;
            return this;
        }

        public Configurator pageFling(boolean z) {
            this.pageFling = z;
            return this;
        }

        public Configurator nightMode(boolean z) {
            this.nightMode = z;
            return this;
        }

        public Configurator disableLongpress() {
            PDFView.this.dragPinchManager.disableLongpress();
            return this;
        }

        public void load() {
            if (!PDFView.this.hasSize) {
                PDFView.this.waitingDocumentConfigurator = this;
                return;
            }
            PDFView.this.recycle();
            PDFView.this.callbacks.setOnLoadComplete(this.onLoadCompleteListener);
            PDFView.this.callbacks.setOnError(this.onErrorListener);
            PDFView.this.callbacks.setOnDraw(this.onDrawListener);
            PDFView.this.callbacks.setOnDrawAll(this.onDrawAllListener);
            PDFView.this.callbacks.setOnPageChange(this.onPageChangeListener);
            PDFView.this.callbacks.setOnPageScroll(this.onPageScrollListener);
            PDFView.this.callbacks.setOnRender(this.onRenderListener);
            PDFView.this.callbacks.setOnTap(this.onTapListener);
            PDFView.this.callbacks.setOnLongPress(this.onLongPressListener);
            PDFView.this.callbacks.setOnPageError(this.onPageErrorListener);
            PDFView.this.callbacks.setLinkHandler(this.linkHandler);
            PDFView.this.setSwipeEnabled(this.enableSwipe);
            PDFView.this.setNightMode(this.nightMode);
            PDFView.this.enableDoubletap(this.enableDoubletap);
            PDFView.this.setDefaultPage(this.defaultPage);
            PDFView.this.setLandscapeOrientation(this.landscapeOrientation);
            PDFView.this.setDualPageMode(this.dualPageMode);
            PDFView.this.setSwipeVertical(!this.swipeHorizontal);
            PDFView.this.enableAnnotationRendering(this.annotationRendering);
            PDFView.this.setScrollHandle(this.scrollHandle);
            PDFView.this.enableAntialiasing(this.antialiasing);
            PDFView.this.setSpacing(this.spacing);
            PDFView.this.setAutoSpacing(this.autoSpacing);
            PDFView.this.setPageFitPolicy(this.pageFitPolicy);
            PDFView.this.setFitEachPage(this.fitEachPage);
            PDFView.this.setPageSnap(this.pageSnap);
            PDFView.this.setPageFling(this.pageFling);
            int[] iArr = this.pageNumbers;
            if (iArr != null) {
                PDFView.this.load(this.documentSource, this.password, iArr);
            } else {
                PDFView.this.load(this.documentSource, this.password);
            }
        }
    }
}
