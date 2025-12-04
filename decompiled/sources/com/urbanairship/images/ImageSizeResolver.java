package com.urbanairship.images;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0007¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/images/ImageSizeResolver;", "", "resolveHeight", "", "context", "Landroid/content/Context;", "measuredWidth", "(Landroid/content/Context;Ljava/lang/Integer;)Ljava/lang/Integer;", "resolveWidth", "measuredHeight", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ImageSizeResolver {
    @Nullable
    Integer resolveHeight(@NotNull Context context, @Nullable Integer measuredWidth);

    @Nullable
    Integer resolveWidth(@NotNull Context context, @Nullable Integer measuredHeight);
}
