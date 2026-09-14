package com.facebook.react.views.debuggingoverlay;

import android.graphics.RectF;
import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UnexpectedNativeTypeException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.DebuggingOverlayManagerDelegate;
import com.facebook.react.viewmanagers.DebuggingOverlayManagerInterface;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = DebuggingOverlayManager.REACT_CLASS)
@Metadata(m1835d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0017B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m1836d2 = {"Lcom/facebook/react/views/debuggingoverlay/DebuggingOverlayManager;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Lcom/facebook/react/views/debuggingoverlay/DebuggingOverlay;", "Lcom/facebook/react/viewmanagers/DebuggingOverlayManagerInterface;", "<init>", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getDelegate", "receiveCommand", "", "view", "commandId", "", "args", "Lcom/facebook/react/bridge/ReadableArray;", "highlightTraceUpdates", "highlightElements", "clearElementsHighlights", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getName", "Companion", "ReactAndroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class DebuggingOverlayManager extends SimpleViewManager<DebuggingOverlay> implements DebuggingOverlayManagerInterface<DebuggingOverlay> {

    @NotNull
    public static final String REACT_CLASS = "DebuggingOverlay";

    @NotNull
    private final ViewManagerDelegate<DebuggingOverlay> delegate = new DebuggingOverlayManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    protected ViewManagerDelegate<DebuggingOverlay> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NotNull DebuggingOverlay view, @NotNull String commandId, @Nullable ReadableArray args) throws Exception {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        int iHashCode = commandId.hashCode();
        if (iHashCode != -1942063165) {
            if (iHashCode != 1326903961) {
                if (iHashCode == 1385348555 && commandId.equals("highlightElements")) {
                    highlightElements(view, args);
                    return;
                }
            } else if (commandId.equals("highlightTraceUpdates")) {
                highlightTraceUpdates(view, args);
                return;
            }
        } else if (commandId.equals("clearElementsHighlights")) {
            clearElementsHighlights(view);
            return;
        }
        ReactSoftExceptionLogger.logSoftException(REACT_CLASS, new ReactNoCrashSoftException("Received unexpected command in DebuggingOverlayManager"));
    }

    @Override // com.facebook.react.viewmanagers.DebuggingOverlayManagerInterface
    public void highlightTraceUpdates(@NotNull DebuggingOverlay view, @Nullable ReadableArray args) throws Exception {
        Intrinsics.checkNotNullParameter(view, "view");
        if (args != null) {
            boolean z = false;
            ReadableArray array = args.getArray(0);
            if (array == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            int size = array.size();
            int i = 0;
            boolean z2 = true;
            while (true) {
                if (i >= size) {
                    z = z2;
                    break;
                }
                ReadableMap map = array.getMap(i);
                if (map != null) {
                    ReadableMap map2 = map.getMap("rectangle");
                    if (map2 == null) {
                        ReactSoftExceptionLogger.logSoftException(REACT_CLASS, new ReactNoCrashSoftException("Unexpected payload for highlighting trace updates: rectangle field is null"));
                        break;
                    }
                    int i2 = map.getInt("id");
                    int i3 = map.getInt("color");
                    try {
                        float f = (float) map2.getDouble("x");
                        float f2 = (float) map2.getDouble("y");
                        float f3 = (float) (((double) f) + map2.getDouble("width"));
                        float f4 = (float) (((double) f2) + map2.getDouble("height"));
                        PixelUtil pixelUtil = PixelUtil.INSTANCE;
                        arrayList.add(new TraceUpdate(i2, new RectF(pixelUtil.dpToPx(f), pixelUtil.dpToPx(f2), pixelUtil.dpToPx(f3), pixelUtil.dpToPx(f4)), i3));
                    } catch (Exception e) {
                        if ((e instanceof NoSuchKeyException) || (e instanceof UnexpectedNativeTypeException)) {
                            ReactSoftExceptionLogger.logSoftException(REACT_CLASS, new ReactNoCrashSoftException("Unexpected payload for highlighting trace updates: rectangle field should have x, y, width, height fields"));
                            Unit unit = Unit.INSTANCE;
                            z2 = false;
                        } else {
                            throw e;
                        }
                    }
                }
                i++;
                z = false;
            }
            if (z) {
                view.setTraceUpdates(arrayList);
            }
        }
    }

    @Override // com.facebook.react.viewmanagers.DebuggingOverlayManagerInterface
    public void highlightElements(@NotNull DebuggingOverlay view, @Nullable ReadableArray args) throws Exception {
        ReadableArray array;
        Intrinsics.checkNotNullParameter(view, "view");
        if (args == null || (array = args.getArray(0)) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = array.size();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            ReadableMap map = array.getMap(i);
            if (map != null) {
                try {
                    float f = (float) map.getDouble("x");
                    float f2 = (float) map.getDouble("y");
                    float f3 = (float) (((double) f) + map.getDouble("width"));
                    float f4 = (float) (((double) f2) + map.getDouble("height"));
                    PixelUtil pixelUtil = PixelUtil.INSTANCE;
                    arrayList.add(new RectF(pixelUtil.dpToPx(f), pixelUtil.dpToPx(f2), pixelUtil.dpToPx(f3), pixelUtil.dpToPx(f4)));
                } catch (Exception e) {
                    if ((e instanceof NoSuchKeyException) || (e instanceof UnexpectedNativeTypeException)) {
                        ReactSoftExceptionLogger.logSoftException(REACT_CLASS, new ReactNoCrashSoftException("Unexpected payload for highlighting elements: every element should have x, y, width, height fields"));
                        Unit unit = Unit.INSTANCE;
                        z = false;
                    } else {
                        throw e;
                    }
                }
            }
        }
        if (z) {
            view.setHighlightedElementsRectangles(arrayList);
        }
    }

    @Override // com.facebook.react.viewmanagers.DebuggingOverlayManagerInterface
    public void clearElementsHighlights(@NotNull DebuggingOverlay view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.clearElementsHighlights();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public DebuggingOverlay createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new DebuggingOverlay(context);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }
}
