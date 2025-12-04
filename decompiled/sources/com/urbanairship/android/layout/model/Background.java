package com.urbanairship.android.layout.model;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.property.Border;
import com.urbanairship.android.layout.property.Color;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/android/layout/model/Background;", "", "color", "Lcom/urbanairship/android/layout/property/Color;", "border", "Lcom/urbanairship/android/layout/property/Border;", "(Lcom/urbanairship/android/layout/property/Color;Lcom/urbanairship/android/layout/property/Border;)V", "getBorder", "()Lcom/urbanairship/android/layout/property/Border;", "getColor", "()Lcom/urbanairship/android/layout/property/Color;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Background {
    private final Border border;
    private final Color color;

    public static /* synthetic */ Background copy$default(Background background, Color color, Border border, int i, Object obj) {
        if ((i & 1) != 0) {
            color = background.color;
        }
        if ((i & 2) != 0) {
            border = background.border;
        }
        return background.copy(color, border);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Border getBorder() {
        return this.border;
    }

    @NotNull
    public final Background copy(@Nullable Color color, @Nullable Border border) {
        return new Background(color, border);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Background)) {
            return false;
        }
        Background background = (Background) other;
        return Intrinsics.areEqual(this.color, background.color) && Intrinsics.areEqual(this.border, background.border);
    }

    public int hashCode() {
        Color color = this.color;
        int iHashCode = (color == null ? 0 : color.hashCode()) * 31;
        Border border = this.border;
        return iHashCode + (border != null ? border.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Background(color=" + this.color + ", border=" + this.border + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public Background(@Nullable Color color, @Nullable Border border) {
        this.color = color;
        this.border = border;
    }

    @Nullable
    public final Border getBorder() {
        return this.border;
    }

    @Nullable
    public final Color getColor() {
        return this.color;
    }
}
