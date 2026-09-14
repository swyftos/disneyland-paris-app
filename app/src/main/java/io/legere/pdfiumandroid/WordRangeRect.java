package io.legere.pdfiumandroid;

import android.graphics.RectF;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, m1836d2 = {"Lio/legere/pdfiumandroid/WordRangeRect;", "", "rangeStart", "", "rangeLength", "rect", "Landroid/graphics/RectF;", "<init>", "(IILandroid/graphics/RectF;)V", "getRangeStart", "()I", "getRangeLength", "getRect", "()Landroid/graphics/RectF;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "", "pdfiumandroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final /* data */ class WordRangeRect {
    private final int rangeLength;
    private final int rangeStart;

    @NotNull
    private final RectF rect;

    public static /* synthetic */ WordRangeRect copy$default(WordRangeRect wordRangeRect, int i, int i2, RectF rectF, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = wordRangeRect.rangeStart;
        }
        if ((i3 & 2) != 0) {
            i2 = wordRangeRect.rangeLength;
        }
        if ((i3 & 4) != 0) {
            rectF = wordRangeRect.rect;
        }
        return wordRangeRect.copy(i, i2, rectF);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getRangeStart() {
        return this.rangeStart;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getRangeLength() {
        return this.rangeLength;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final RectF getRect() {
        return this.rect;
    }

    @NotNull
    public final WordRangeRect copy(int rangeStart, int rangeLength, @NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return new WordRangeRect(rangeStart, rangeLength, rect);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WordRangeRect)) {
            return false;
        }
        WordRangeRect wordRangeRect = (WordRangeRect) other;
        return this.rangeStart == wordRangeRect.rangeStart && this.rangeLength == wordRangeRect.rangeLength && Intrinsics.areEqual(this.rect, wordRangeRect.rect);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.rangeStart) * 31) + Integer.hashCode(this.rangeLength)) * 31) + this.rect.hashCode();
    }

    @NotNull
    public String toString() {
        return "WordRangeRect(rangeStart=" + this.rangeStart + ", rangeLength=" + this.rangeLength + ", rect=" + this.rect + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public WordRangeRect(int i, int i2, @NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.rangeStart = i;
        this.rangeLength = i2;
        this.rect = rect;
    }

    public final int getRangeStart() {
        return this.rangeStart;
    }

    public final int getRangeLength() {
        return this.rangeLength;
    }

    @NotNull
    public final RectF getRect() {
        return this.rect;
    }
}
