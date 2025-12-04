package com.urbanairship.messagecenter.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0080\u0010¨\u0006\u0003"}, d2 = {"getActivity", "Landroid/app/Activity;", "Landroid/content/Context;", "urbanairship-message-center_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContextExtensionsKt {
    @Nullable
    public static final Activity getActivity(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        do {
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                return activity;
            }
            ContextWrapper contextWrapper = context instanceof ContextWrapper ? (ContextWrapper) context : null;
            if (contextWrapper == null) {
                return null;
            }
            context = contextWrapper.getBaseContext();
        } while (context != null);
        return null;
    }
}
