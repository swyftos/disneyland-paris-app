package com.facebook.react.uimanager.util;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J\u001e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\tH\u0007J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\rH\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\rH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/facebook/react/uimanager/util/ReactFindViewUtil;", "", "<init>", "()V", "onViewFoundListeners", "", "Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;", "onMultipleViewsFoundListener", "", "Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnMultipleViewsFoundListener;", "", "", "findView", "Landroid/view/View;", "root", "nativeId", "", "onViewFoundListener", "addViewListener", "removeViewListener", "addViewsListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "ids", "removeViewsListener", "notifyViewRendered", "view", "getNativeId", "OnViewFoundListener", "OnMultipleViewsFoundListener", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nReactFindViewUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReactFindViewUtil.kt\ncom/facebook/react/uimanager/util/ReactFindViewUtil\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,130:1\n216#2,2:131\n*S KotlinDebug\n*F\n+ 1 ReactFindViewUtil.kt\ncom/facebook/react/uimanager/util/ReactFindViewUtil\n*L\n118#1:131,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ReactFindViewUtil {

    @NotNull
    public static final ReactFindViewUtil INSTANCE = new ReactFindViewUtil();

    @NotNull
    private static final List<OnViewFoundListener> onViewFoundListeners = new ArrayList();

    @NotNull
    private static final Map<OnMultipleViewsFoundListener, Set<String>> onMultipleViewsFoundListener = new HashMap();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnMultipleViewsFoundListener;", "", "onViewFound", "", "view", "Landroid/view/View;", "nativeId", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnMultipleViewsFoundListener {
        void onViewFound(@NotNull View view, @NotNull String nativeId);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/uimanager/util/ReactFindViewUtil$OnViewFoundListener;", "", "getNativeId", "", "onViewFound", "", "view", "Landroid/view/View;", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnViewFoundListener {
        @NotNull
        String getNativeId();

        void onViewFound(@NotNull View view);
    }

    private ReactFindViewUtil() {
    }

    @JvmStatic
    @Nullable
    public static final View findView(@NotNull View root, @NotNull String nativeId) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(nativeId, "nativeId");
        if (Intrinsics.areEqual(INSTANCE.getNativeId(root), nativeId)) {
            return root;
        }
        if (!(root instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) root;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
            View viewFindView = findView(childAt, nativeId);
            if (viewFindView != null) {
                return viewFindView;
            }
        }
        return null;
    }

    @JvmStatic
    public static final void findView(@NotNull View root, @NotNull OnViewFoundListener onViewFoundListener) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(onViewFoundListener, "onViewFoundListener");
        View viewFindView = findView(root, onViewFoundListener.getNativeId());
        if (viewFindView != null) {
            onViewFoundListener.onViewFound(viewFindView);
        }
        addViewListener(onViewFoundListener);
    }

    @JvmStatic
    public static final void addViewListener(@NotNull OnViewFoundListener onViewFoundListener) {
        Intrinsics.checkNotNullParameter(onViewFoundListener, "onViewFoundListener");
        onViewFoundListeners.add(onViewFoundListener);
    }

    @JvmStatic
    public static final void removeViewListener(@NotNull OnViewFoundListener onViewFoundListener) {
        Intrinsics.checkNotNullParameter(onViewFoundListener, "onViewFoundListener");
        onViewFoundListeners.remove(onViewFoundListener);
    }

    @JvmStatic
    public static final void addViewsListener(@NotNull OnMultipleViewsFoundListener listener, @NotNull Set<String> ids) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(ids, "ids");
        onMultipleViewsFoundListener.put(listener, ids);
    }

    @JvmStatic
    public static final void removeViewsListener(@NotNull OnMultipleViewsFoundListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        onMultipleViewsFoundListener.remove(listener);
    }

    @JvmStatic
    public static final void notifyViewRendered(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        String nativeId = INSTANCE.getNativeId(view);
        if (nativeId == null) {
            return;
        }
        Iterator<OnViewFoundListener> it = onViewFoundListeners.iterator();
        while (it.hasNext()) {
            OnViewFoundListener next = it.next();
            if (Intrinsics.areEqual(nativeId, next.getNativeId())) {
                next.onViewFound(view);
                it.remove();
            }
        }
        for (Map.Entry<OnMultipleViewsFoundListener, Set<String>> entry : onMultipleViewsFoundListener.entrySet()) {
            OnMultipleViewsFoundListener key = entry.getKey();
            if (entry.getValue().contains(nativeId)) {
                key.onViewFound(view, nativeId);
            }
        }
    }

    private final String getNativeId(View view) {
        Object tag = view.getTag(R.id.view_tag_native_id);
        if (tag instanceof String) {
            return (String) tag;
        }
        return null;
    }
}
