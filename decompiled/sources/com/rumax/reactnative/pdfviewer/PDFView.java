package com.rumax.reactnative.pdfviewer;

import android.util.Base64;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageScrollListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.rumax.reactnative.pdfviewer.AsyncDownload;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class PDFView extends com.github.barteksc.pdfviewer.PDFView implements OnErrorListener, OnPageChangeListener, OnPageScrollListener, OnLoadCompleteListener {
    public static final String EVENT_ON_ERROR = "onError";
    public static final String EVENT_ON_LOAD = "onLoad";
    public static final String EVENT_ON_PAGE_CHANGED = "onPageChanged";
    public static final String EVENT_ON_SCROLLED = "onScrolled";
    private PDFView.Configurator configurator;
    private ThemedReactContext context;
    private AsyncDownload downloadTask;
    private File downloadedFile;
    private boolean enableAnnotations;
    private int fadeInDuration;
    private float lastPositionOffset;
    private String resource;
    private String resourceType;
    private boolean sourceChanged;
    private ReadableMap urlProps;

    public PDFView(ThemedReactContext themedReactContext) {
        super(themedReactContext, null);
        this.downloadTask = null;
        this.resourceType = null;
        this.configurator = null;
        this.sourceChanged = true;
        this.fadeInDuration = 0;
        this.enableAnnotations = false;
        this.lastPositionOffset = BitmapDescriptorFactory.HUE_RED;
        this.context = themedReactContext;
    }

    @Override // com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
    public void loadComplete(int i) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(BitmapDescriptorFactory.HUE_RED, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(this.fadeInDuration);
        setAlpha(1.0f);
        startAnimation(alphaAnimation);
        reactNativeMessageEvent(EVENT_ON_LOAD, null);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setClipToOutline(true);
    }

    @Override // com.github.barteksc.pdfviewer.listener.OnErrorListener
    public void onError(Throwable th) {
        reactNativeMessageEvent(EVENT_ON_ERROR, "error: " + th.getMessage());
    }

    @Override // com.github.barteksc.pdfviewer.listener.OnPageChangeListener
    public void onPageChanged(int i, int i2) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("page", i);
        writableMapCreateMap.putInt("pageCount", i2);
        reactNativeEvent(EVENT_ON_PAGE_CHANGED, writableMapCreateMap);
    }

    @Override // com.github.barteksc.pdfviewer.listener.OnPageScrollListener
    public void onPageScrolled(int i, float f) {
        if (this.lastPositionOffset != f) {
            if (f == BitmapDescriptorFactory.HUE_RED || f == 1.0f) {
                this.lastPositionOffset = f;
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putDouble(TypedValues.CycleType.S_WAVE_OFFSET, f);
                reactNativeEvent(EVENT_ON_SCROLLED, writableMapCreateMap);
            }
        }
    }

    private void reactNativeMessageEvent(String str, String str2) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("message", str2);
        reactNativeEvent(str, writableMapCreateMap);
    }

    private void reactNativeEvent(String str, WritableMap writableMap) {
        ((RCTEventEmitter) ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), str, writableMap);
    }

    private void setupAndLoad() {
        this.lastPositionOffset = BitmapDescriptorFactory.HUE_RED;
        setAlpha(BitmapDescriptorFactory.HUE_RED);
        this.configurator.defaultPage(0).swipeHorizontal(false).onLoad(this).onError(this).onPageChange(this).onPageScroll(this).spacing(10).enableAnnotationRendering(this.enableAnnotations).load();
        this.sourceChanged = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderFromFile(String str) throws IOException {
        InputStream inputStreamOpen;
        try {
            if (str.startsWith("/")) {
                inputStreamOpen = new FileInputStream(new File(str));
            } else {
                inputStreamOpen = this.context.getAssets().open(str, 3);
            }
            this.configurator = fromStream(inputStreamOpen);
            setupAndLoad();
        } catch (IOException e) {
            onError(e);
        }
    }

    private void renderFromBase64() {
        try {
            this.configurator = fromBytes(Base64.decode(this.resource, 0));
            setupAndLoad();
        } catch (IllegalArgumentException unused) {
            onError(new IOException(Errors.E_INVALID_BASE64.getCode()));
        }
    }

    private void renderFromUrl() {
        try {
            this.downloadedFile = File.createTempFile("pdfDocument", "pdf", this.context.getCacheDir());
            AsyncDownload asyncDownload = new AsyncDownload(this.context, this.resource, this.downloadedFile, this.urlProps, new AsyncDownload.TaskCompleted() { // from class: com.rumax.reactnative.pdfviewer.PDFView.1
                @Override // com.rumax.reactnative.pdfviewer.AsyncDownload.TaskCompleted
                public void onComplete(Exception exc) throws IOException {
                    if (exc == null) {
                        PDFView pDFView = PDFView.this;
                        pDFView.renderFromFile(pDFView.downloadedFile.getAbsolutePath());
                    } else {
                        PDFView.this.cleanDownloadedFile();
                        PDFView.this.onError(exc);
                    }
                }
            });
            this.downloadTask = asyncDownload;
            asyncDownload.execute(new Void[0]);
        } catch (IOException e) {
            onError(e);
        }
    }

    public void render() throws IOException {
        cleanup();
        if (this.resource == null) {
            onError(new IOException(Errors.E_NO_RESOURCE.getCode()));
        }
        String str = this.resourceType;
        if (str == null) {
            onError(new IOException(Errors.E_NO_RESOURCE_TYPE.getCode()));
            return;
        }
        if (this.sourceChanged) {
            str.hashCode();
            switch (str) {
                case "base64":
                    renderFromBase64();
                    break;
                case "url":
                    renderFromUrl();
                    break;
                case "file":
                    renderFromFile(this.resource);
                    break;
                default:
                    onError(new IOException(Errors.E_INVALID_RESOURCE_TYPE.getCode() + this.resourceType));
                    break;
            }
        }
    }

    private void cleanup() {
        AsyncDownload asyncDownload = this.downloadTask;
        if (asyncDownload != null) {
            asyncDownload.cancel(true);
        }
        cleanDownloadedFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanDownloadedFile() {
        File file = this.downloadedFile;
        if (file != null) {
            if (!file.delete()) {
                onError(new IOException(Errors.E_DELETE_FILE.getCode()));
            }
            this.downloadedFile = null;
        }
    }

    private static boolean isDifferent(String str, String str2) {
        if (str == null || str2 == null) {
            return true;
        }
        return !str.equals(str2);
    }

    public void setResource(String str) {
        if (isDifferent(str, this.resource)) {
            this.sourceChanged = true;
        }
        this.resource = str;
    }

    public void setResourceType(String str) {
        if (isDifferent(str, this.resourceType)) {
            this.sourceChanged = true;
        }
        this.resourceType = str;
    }

    public void onDrop() {
        cleanup();
        this.sourceChanged = true;
    }

    public void setUrlProps(ReadableMap readableMap) {
        this.urlProps = readableMap;
    }

    public void setFadeInDuration(int i) {
        this.fadeInDuration = i;
    }

    public void setEnableAnnotations(boolean z) {
        this.enableAnnotations = z;
    }

    public void reload() throws IOException {
        this.sourceChanged = true;
        render();
    }
}
