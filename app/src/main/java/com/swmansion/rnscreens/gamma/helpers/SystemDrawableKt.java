package com.swmansion.rnscreens.gamma.helpers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.appcompat.content.res.AppCompatResources;
import com.swmansion.rnscreens.gamma.tabs.TabScreen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000¨\u0006\u0006"}, m1836d2 = {"getSystemDrawableResource", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "iconName", "", "react-native-screens_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class SystemDrawableKt {
    @Nullable
    public static final Drawable getSystemDrawableResource(@NotNull Context context, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (str == null) {
            return null;
        }
        int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        if (identifier > 0) {
            return AppCompatResources.getDrawable(context, identifier);
        }
        int identifier2 = context.getResources().getIdentifier(str, "drawable", "android");
        if (identifier2 > 0) {
            return AppCompatResources.getDrawable(context, identifier2);
        }
        Log.w(TabScreen.TAG, "TabScreen could not resolve drawable resource with the name " + str);
        return null;
    }
}
