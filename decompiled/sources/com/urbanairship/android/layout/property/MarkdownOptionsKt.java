package com.urbanairship.android.layout.property;

import android.content.Context;
import androidx.annotation.ColorInt;
import com.urbanairship.android.layout.property.MarkdownAppearance;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\"\u001a\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u001a\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003¨\u0006\u000b"}, d2 = {"isEnabled", "", "Lcom/urbanairship/android/layout/property/MarkdownOptions;", "(Lcom/urbanairship/android/layout/property/MarkdownOptions;)Z", "underlineLinks", "getUnderlineLinks", "resolvedLinkColor", "", "context", "Landroid/content/Context;", "(Lcom/urbanairship/android/layout/property/MarkdownOptions;Landroid/content/Context;)Ljava/lang/Integer;", "urbanairship-layout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MarkdownOptionsKt {
    public static final boolean isEnabled(@Nullable MarkdownOptions markdownOptions) {
        Boolean disabled;
        return markdownOptions == null || (disabled = markdownOptions.getDisabled()) == null || !disabled.booleanValue();
    }

    @ColorInt
    @Nullable
    public static final Integer resolvedLinkColor(@Nullable MarkdownOptions markdownOptions, @NotNull Context context) {
        MarkdownAppearance appearance;
        MarkdownAppearance.LinkAppearance links;
        Color color;
        Intrinsics.checkNotNullParameter(context, "context");
        if (markdownOptions == null || (appearance = markdownOptions.getAppearance()) == null || (links = appearance.getLinks()) == null || (color = links.getColor()) == null) {
            return null;
        }
        return Integer.valueOf(color.resolve(context));
    }

    public static final boolean getUnderlineLinks(@Nullable MarkdownOptions markdownOptions) {
        MarkdownAppearance appearance;
        MarkdownAppearance.LinkAppearance links;
        List<TextStyle> styles;
        if (markdownOptions == null || (appearance = markdownOptions.getAppearance()) == null || (links = appearance.getLinks()) == null || (styles = links.getStyles()) == null) {
            return false;
        }
        return styles.contains(TextStyle.UNDERLINE);
    }
}
