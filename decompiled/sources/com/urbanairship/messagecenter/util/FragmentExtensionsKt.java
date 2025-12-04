package com.urbanairship.messagecenter.util;

import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"setImportantForAccessibility", "", "Landroidx/fragment/app/Fragment;", "important", "", "urbanairship-message-center_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FragmentExtensionsKt {
    public static final void setImportantForAccessibility(@NotNull Fragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        View view = fragment.getView();
        if (view == null) {
            return;
        }
        view.setImportantForAccessibility(z ? 1 : 4);
    }
}
