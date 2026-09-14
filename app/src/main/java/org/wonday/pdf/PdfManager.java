package org.wonday.pdf;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.autofill.HintConstants;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNPDFPdfViewManagerDelegate;
import com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface;

/* JADX INFO: loaded from: classes7.dex */
@ReactModule(name = PdfManager.REACT_CLASS)
public class PdfManager extends SimpleViewManager<PdfView> implements RNPDFPdfViewManagerInterface<PdfView> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String REACT_CLASS = "RNPDFPdfView";
    private Context context;
    private final ViewManagerDelegate<PdfView> mDelegate = new RNPDFPdfViewManagerDelegate(this);
    private PdfView pdfView;

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(PdfView pdfView) {
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    public void setShowsHorizontalScrollIndicator(PdfView pdfView, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    public void setShowsVerticalScrollIndicator(PdfView pdfView, boolean z) {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    protected ViewManagerDelegate<PdfView> getDelegate() {
        return this.mDelegate;
    }

    public PdfManager() {
    }

    public PdfManager(ReactApplicationContext reactApplicationContext) {
        this.context = reactApplicationContext;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public PdfView createViewInstance(ThemedReactContext themedReactContext) {
        PdfView pdfView = new PdfView(themedReactContext, null);
        this.pdfView = pdfView;
        return pdfView;
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    @ReactProp(name = "path")
    public void setPath(PdfView pdfView, String str) {
        pdfView.setPath(str);
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    @ReactProp(name = "page")
    public void setPage(PdfView pdfView, int i) {
        pdfView.setPage(i);
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    @ReactProp(name = "scale")
    public void setScale(PdfView pdfView, float f) {
        pdfView.setScale(f);
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    @ReactProp(name = "minScale")
    public void setMinScale(PdfView pdfView, float f) {
        pdfView.setMinScale(f);
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    @ReactProp(name = "maxScale")
    public void setMaxScale(PdfView pdfView, float f) {
        pdfView.setMaxScale(f);
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    @ReactProp(name = "horizontal")
    public void setHorizontal(PdfView pdfView, boolean z) {
        pdfView.setHorizontal(z);
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    @ReactProp(name = "enableRTL")
    public void setEnableRTL(PdfView pdfView, boolean z) {
        this.pdfView.setEnableRTL(z);
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    @ReactProp(name = "scrollEnabled")
    public void setScrollEnabled(PdfView pdfView, boolean z) {
        this.pdfView.setScrollEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    @ReactProp(name = "spacing")
    public void setSpacing(PdfView pdfView, int i) {
        pdfView.setSpacing(i);
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    @ReactProp(name = HintConstants.AUTOFILL_HINT_PASSWORD)
    public void setPassword(PdfView pdfView, String str) {
        pdfView.setPassword(str);
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    @ReactProp(name = "enableAntialiasing")
    public void setEnableAntialiasing(PdfView pdfView, boolean z) {
        pdfView.setEnableAntialiasing(z);
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    @ReactProp(name = "enableAnnotationRendering")
    public void setEnableAnnotationRendering(PdfView pdfView, boolean z) {
        pdfView.setEnableAnnotationRendering(z);
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    @ReactProp(name = "enableDoubleTapZoom")
    public void setEnableDoubleTapZoom(PdfView pdfView, boolean z) {
        pdfView.setEnableDoubleTapZoom(z);
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    @ReactProp(name = "enablePaging")
    public void setEnablePaging(PdfView pdfView, boolean z) {
        pdfView.setEnablePaging(z);
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    @ReactProp(name = "fitPolicy")
    public void setFitPolicy(PdfView pdfView, int i) {
        pdfView.setFitPolicy(i);
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    @ReactProp(name = "singlePage")
    public void setSinglePage(PdfView pdfView, boolean z) {
        pdfView.setSinglePage(z);
    }

    @Override // com.facebook.react.viewmanagers.RNPDFPdfViewManagerInterface
    public void setNativePage(PdfView pdfView, int i) {
        this.pdfView.setPage(i);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NonNull PdfView pdfView, String str, @Nullable ReadableArray readableArray) {
        Assertions.assertNotNull(pdfView);
        if ("setNativePage".equals(str)) {
            Assertions.assertNotNull(readableArray);
            setNativePage(pdfView, readableArray.getInt(0));
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(PdfView pdfView) {
        super.onAfterUpdateTransaction(pdfView);
        pdfView.drawPdf();
    }
}
