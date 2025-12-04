package com.urbanairship.android.layout.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.urbanairship.android.layout.info.LocalizedContentDescription;
import com.urbanairship.util.UAStringUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0080\u0010\u001a&\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000¨\u0006\b"}, d2 = {"getActivity", "Landroid/app/Activity;", "Landroid/content/Context;", "resolveContentDescription", "", "contentDescription", "localizedContentDescription", "Lcom/urbanairship/android/layout/info/LocalizedContentDescription;", "urbanairship-layout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
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

    public static /* synthetic */ String resolveContentDescription$default(Context context, String str, LocalizedContentDescription localizedContentDescription, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            localizedContentDescription = null;
        }
        return resolveContentDescription(context, str, localizedContentDescription);
    }

    @Nullable
    public static final String resolveContentDescription(@NotNull Context context, @Nullable String str, @Nullable LocalizedContentDescription localizedContentDescription) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (str != null) {
            return str;
        }
        if (localizedContentDescription == null) {
            return null;
        }
        String ref = localizedContentDescription.getRef();
        if (ref != null && UAStringUtil.namedStringResource(context, ref, localizedContentDescription.getFallback()) != null) {
            return null;
        }
        localizedContentDescription.getFallback();
        return null;
    }
}
