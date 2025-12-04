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

@ReactModule(name = DebuggingOverlayManager.REACT_CLASS)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0017B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\rH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/react/views/debuggingoverlay/DebuggingOverlayManager;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Lcom/facebook/react/views/debuggingoverlay/DebuggingOverlay;", "Lcom/facebook/react/viewmanagers/DebuggingOverlayManagerInterface;", "<init>", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getDelegate", "receiveCommand", "", "view", "commandId", "", "args", "Lcom/facebook/react/bridge/ReadableArray;", "highlightTraceUpdates", "highlightElements", "clearElementsHighlights", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getName", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00aa, code lost:
    
        if (r3 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ac, code lost:
    
        r20.setTraceUpdates(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00af, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
    
        return;
     */
    @Override // com.facebook.react.viewmanagers.DebuggingOverlayManagerInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void highlightTraceUpdates(@org.jetbrains.annotations.NotNull com.facebook.react.views.debuggingoverlay.DebuggingOverlay r20, @org.jetbrains.annotations.Nullable com.facebook.react.bridge.ReadableArray r21) throws java.lang.Exception {
        /*
            r19 = this;
            r1 = r20
            r0 = r21
            java.lang.String r3 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            if (r0 == 0) goto Laf
            r3 = 0
            com.facebook.react.bridge.ReadableArray r4 = r0.getArray(r3)
            if (r4 != 0) goto L14
            goto Laf
        L14:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            int r6 = r4.size()
            r7 = r3
            r0 = 1
        L1f:
            if (r7 >= r6) goto La9
            com.facebook.react.bridge.ReadableMap r8 = r4.getMap(r7)
            if (r8 != 0) goto L28
            goto L8a
        L28:
            java.lang.String r9 = "rectangle"
            com.facebook.react.bridge.ReadableMap r9 = r8.getMap(r9)
            java.lang.String r10 = "DebuggingOverlay"
            if (r9 != 0) goto L3d
            com.facebook.react.bridge.ReactNoCrashSoftException r0 = new com.facebook.react.bridge.ReactNoCrashSoftException
            java.lang.String r2 = "Unexpected payload for highlighting trace updates: rectangle field is null"
            r0.<init>(r2)
            com.facebook.react.bridge.ReactSoftExceptionLogger.logSoftException(r10, r0)
            goto Laa
        L3d:
            java.lang.String r11 = "id"
            int r11 = r8.getInt(r11)
            java.lang.String r12 = "color"
            int r8 = r8.getInt(r12)
            java.lang.String r12 = "x"
            double r12 = r9.getDouble(r12)     // Catch: java.lang.Exception -> L8c
            float r12 = (float) r12     // Catch: java.lang.Exception -> L8c
            java.lang.String r13 = "y"
            double r13 = r9.getDouble(r13)     // Catch: java.lang.Exception -> L8c
            float r13 = (float) r13     // Catch: java.lang.Exception -> L8c
            double r14 = (double) r12     // Catch: java.lang.Exception -> L8c
            java.lang.String r3 = "width"
            double r16 = r9.getDouble(r3)     // Catch: java.lang.Exception -> L8c
            double r14 = r14 + r16
            float r3 = (float) r14     // Catch: java.lang.Exception -> L8c
            double r14 = (double) r13     // Catch: java.lang.Exception -> L8c
            java.lang.String r2 = "height"
            double r17 = r9.getDouble(r2)     // Catch: java.lang.Exception -> L8c
            double r14 = r14 + r17
            float r2 = (float) r14     // Catch: java.lang.Exception -> L8c
            android.graphics.RectF r9 = new android.graphics.RectF     // Catch: java.lang.Exception -> L8c
            com.facebook.react.uimanager.PixelUtil r14 = com.facebook.react.uimanager.PixelUtil.INSTANCE     // Catch: java.lang.Exception -> L8c
            float r12 = r14.dpToPx(r12)     // Catch: java.lang.Exception -> L8c
            float r13 = r14.dpToPx(r13)     // Catch: java.lang.Exception -> L8c
            float r3 = r14.dpToPx(r3)     // Catch: java.lang.Exception -> L8c
            float r2 = r14.dpToPx(r2)     // Catch: java.lang.Exception -> L8c
            r9.<init>(r12, r13, r3, r2)     // Catch: java.lang.Exception -> L8c
            com.facebook.react.views.debuggingoverlay.TraceUpdate r2 = new com.facebook.react.views.debuggingoverlay.TraceUpdate     // Catch: java.lang.Exception -> L8c
            r2.<init>(r11, r9, r8)     // Catch: java.lang.Exception -> L8c
            r5.add(r2)     // Catch: java.lang.Exception -> L8c
        L8a:
            r2 = 1
            goto La5
        L8c:
            r0 = move-exception
            boolean r2 = r0 instanceof com.facebook.react.bridge.NoSuchKeyException
            if (r2 != 0) goto L97
            boolean r2 = r0 instanceof com.facebook.react.bridge.UnexpectedNativeTypeException
            if (r2 == 0) goto L96
            goto L97
        L96:
            throw r0
        L97:
            com.facebook.react.bridge.ReactNoCrashSoftException r0 = new com.facebook.react.bridge.ReactNoCrashSoftException
            java.lang.String r2 = "Unexpected payload for highlighting trace updates: rectangle field should have x, y, width, height fields"
            r0.<init>(r2)
            com.facebook.react.bridge.ReactSoftExceptionLogger.logSoftException(r10, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r0 = 0
            goto L8a
        La5:
            int r7 = r7 + r2
            r3 = 0
            goto L1f
        La9:
            r3 = r0
        Laa:
            if (r3 == 0) goto Laf
            r1.setTraceUpdates(r5)
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.debuggingoverlay.DebuggingOverlayManager.highlightTraceUpdates(com.facebook.react.views.debuggingoverlay.DebuggingOverlay, com.facebook.react.bridge.ReadableArray):void");
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
                    float f3 = (float) (f + map.getDouble("width"));
                    float f4 = (float) (f2 + map.getDouble("height"));
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
