package com.mrousavy.camera.react.extensions;

import android.view.View;
import android.view.ViewGroup;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m1836d2 = {"installHierarchyFitter", "", "Landroid/view/ViewGroup;", "react-native-vision-camera_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ViewGroup_installHierarchyFitterKt {
    public static final void installHierarchyFitter(@NotNull final ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        InstrumentationCallbacks.setOnHierarchyChangeListenerCalled(viewGroup, new ViewGroup.OnHierarchyChangeListener() { // from class: com.mrousavy.camera.react.extensions.ViewGroup_installHierarchyFitterKt.installHierarchyFitter.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View parent, View child) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View parent, View child) {
                if (parent != null) {
                    parent.measure(View.MeasureSpec.makeMeasureSpec(viewGroup.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(viewGroup.getMeasuredHeight(), 1073741824));
                }
                if (parent != null) {
                    parent.layout(0, 0, parent.getMeasuredWidth(), parent.getMeasuredHeight());
                }
            }
        });
    }
}
