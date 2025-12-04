package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0002J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0017J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020 H\u0017R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/th3rdwave/safeareacontext/SafeAreaViewShadowNode;", "Lcom/facebook/react/uimanager/LayoutShadowNode;", "<init>", "()V", "mLocalData", "Lcom/th3rdwave/safeareacontext/SafeAreaViewLocalData;", "mPaddings", "", "mMargins", "mNeedsUpdate", "", "updateInsets", "", "getEdgeValue", "", "edgeMode", "Lcom/th3rdwave/safeareacontext/SafeAreaViewEdgeModes;", "insetValue", "edgeValue", "resetInsets", "mode", "Lcom/th3rdwave/safeareacontext/SafeAreaViewMode;", "onBeforeLayout", "nativeViewHierarchyOptimizer", "Lcom/facebook/react/uimanager/NativeViewHierarchyOptimizer;", "setLocalData", "data", "", "setPaddings", "index", "", ViewProps.PADDING, "Lcom/facebook/react/bridge/Dynamic;", "setMargins", ViewProps.MARGIN, "react-native-safe-area-context_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SafeAreaViewShadowNode extends LayoutShadowNode {

    @Nullable
    private SafeAreaViewLocalData mLocalData;

    @NotNull
    private final float[] mMargins;
    private boolean mNeedsUpdate;

    @NotNull
    private final float[] mPaddings;

    public SafeAreaViewShadowNode() {
        int[] iArr = ViewProps.PADDING_MARGIN_SPACING_TYPES;
        this.mPaddings = new float[iArr.length];
        this.mMargins = new float[iArr.length];
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            this.mPaddings[i] = Float.NaN;
            this.mMargins[i] = Float.NaN;
        }
    }

    private final void updateInsets() {
        SafeAreaViewLocalData safeAreaViewLocalData = this.mLocalData;
        if (safeAreaViewLocalData == null) {
            return;
        }
        SafeAreaViewMode mode = safeAreaViewLocalData.getMode();
        SafeAreaViewMode safeAreaViewMode = SafeAreaViewMode.PADDING;
        float[] fArr = mode == safeAreaViewMode ? this.mPaddings : this.mMargins;
        float f = fArr[8];
        if (Float.isNaN(f)) {
            f = BitmapDescriptorFactory.HUE_RED;
        }
        float f2 = f;
        float f3 = f2;
        float f4 = f3;
        float f5 = fArr[7];
        if (!Float.isNaN(f5)) {
            f = f5;
            f3 = f;
        }
        float f6 = fArr[6];
        if (!Float.isNaN(f6)) {
            f2 = f6;
            f4 = f2;
        }
        float f7 = fArr[1];
        if (!Float.isNaN(f7)) {
            f = f7;
        }
        float f8 = fArr[2];
        if (!Float.isNaN(f8)) {
            f2 = f8;
        }
        float f9 = fArr[3];
        if (!Float.isNaN(f9)) {
            f3 = f9;
        }
        float f10 = fArr[0];
        if (!Float.isNaN(f10)) {
            f4 = f10;
        }
        float pixelFromDIP = PixelUtil.toPixelFromDIP(f);
        float pixelFromDIP2 = PixelUtil.toPixelFromDIP(f2);
        float pixelFromDIP3 = PixelUtil.toPixelFromDIP(f3);
        float pixelFromDIP4 = PixelUtil.toPixelFromDIP(f4);
        SafeAreaViewEdges edges = safeAreaViewLocalData.getEdges();
        EdgeInsets insets = safeAreaViewLocalData.getInsets();
        if (safeAreaViewLocalData.getMode() == safeAreaViewMode) {
            super.setPadding(1, getEdgeValue(edges.getTop(), insets.getTop(), pixelFromDIP));
            super.setPadding(2, getEdgeValue(edges.getRight(), insets.getRight(), pixelFromDIP2));
            super.setPadding(3, getEdgeValue(edges.getBottom(), insets.getBottom(), pixelFromDIP3));
            super.setPadding(0, getEdgeValue(edges.getLeft(), insets.getLeft(), pixelFromDIP4));
            return;
        }
        super.setMargin(1, getEdgeValue(edges.getTop(), insets.getTop(), pixelFromDIP));
        super.setMargin(2, getEdgeValue(edges.getRight(), insets.getRight(), pixelFromDIP2));
        super.setMargin(3, getEdgeValue(edges.getBottom(), insets.getBottom(), pixelFromDIP3));
        super.setMargin(0, getEdgeValue(edges.getLeft(), insets.getLeft(), pixelFromDIP4));
    }

    private final float getEdgeValue(SafeAreaViewEdgeModes edgeMode, float insetValue, float edgeValue) {
        return edgeMode == SafeAreaViewEdgeModes.OFF ? edgeValue : edgeMode == SafeAreaViewEdgeModes.MAXIMUM ? Math.max(insetValue, edgeValue) : insetValue + edgeValue;
    }

    private final void resetInsets(SafeAreaViewMode mode) {
        if (mode == SafeAreaViewMode.PADDING) {
            super.setPadding(1, this.mPaddings[1]);
            super.setPadding(2, this.mPaddings[2]);
            super.setPadding(3, this.mPaddings[3]);
            super.setPadding(0, this.mPaddings[0]);
        } else {
            super.setMargin(1, this.mMargins[1]);
            super.setMargin(2, this.mMargins[2]);
            super.setMargin(3, this.mMargins[3]);
            super.setMargin(0, this.mMargins[0]);
        }
        markUpdated();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public void onBeforeLayout(@NotNull NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        Intrinsics.checkNotNullParameter(nativeViewHierarchyOptimizer, "nativeViewHierarchyOptimizer");
        if (this.mNeedsUpdate) {
            this.mNeedsUpdate = false;
            updateInsets();
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public void setLocalData(@NotNull Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof SafeAreaViewLocalData) {
            SafeAreaViewLocalData safeAreaViewLocalData = this.mLocalData;
            if (safeAreaViewLocalData != null && safeAreaViewLocalData.getMode() != ((SafeAreaViewLocalData) data).getMode()) {
                resetInsets(safeAreaViewLocalData.getMode());
            }
            this.mLocalData = (SafeAreaViewLocalData) data;
            this.mNeedsUpdate = false;
            updateInsets();
        }
    }

    @Override // com.facebook.react.uimanager.LayoutShadowNode
    @ReactPropGroup(names = {ViewProps.PADDING, ViewProps.PADDING_VERTICAL, ViewProps.PADDING_HORIZONTAL, ViewProps.PADDING_START, ViewProps.PADDING_END, ViewProps.PADDING_TOP, ViewProps.PADDING_BOTTOM, ViewProps.PADDING_LEFT, ViewProps.PADDING_RIGHT})
    public void setPaddings(int index, @NotNull Dynamic padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        this.mPaddings[ViewProps.PADDING_MARGIN_SPACING_TYPES[index]] = padding.getType() == ReadableType.Number ? (float) padding.asDouble() : Float.NaN;
        super.setPaddings(index, padding);
        this.mNeedsUpdate = true;
    }

    @Override // com.facebook.react.uimanager.LayoutShadowNode
    @ReactPropGroup(names = {ViewProps.MARGIN, ViewProps.MARGIN_VERTICAL, ViewProps.MARGIN_HORIZONTAL, ViewProps.MARGIN_START, ViewProps.MARGIN_END, ViewProps.MARGIN_TOP, ViewProps.MARGIN_BOTTOM, ViewProps.MARGIN_LEFT, ViewProps.MARGIN_RIGHT})
    public void setMargins(int index, @NotNull Dynamic margin) {
        Intrinsics.checkNotNullParameter(margin, "margin");
        this.mMargins[ViewProps.PADDING_MARGIN_SPACING_TYPES[index]] = margin.getType() == ReadableType.Number ? (float) margin.asDouble() : Float.NaN;
        super.setMargins(index, margin);
        this.mNeedsUpdate = true;
    }
}
