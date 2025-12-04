package com.urbanairship.android.layout.widget;

import android.view.View;
import com.urbanairship.android.layout.view.ButtonLayoutView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"findButtonLayoutParent", "Lcom/urbanairship/android/layout/view/ButtonLayoutView;", "Landroid/view/View;", "urbanairship-layout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TouchAwareWebViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final ButtonLayoutView findButtonLayoutParent(View view) {
        while (view != null) {
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
            if (view instanceof ButtonLayoutView) {
                return (ButtonLayoutView) view;
            }
        }
        return null;
    }
}
