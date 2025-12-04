package com.contentsquare.android.sdk;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.communication.compose.ComposeLazyScroller;
import com.contentsquare.android.core.communication.compose.ComposePageScroller;
import com.contentsquare.android.core.communication.compose.ViewNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.d6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0657d6 {

    /* renamed from: com.contentsquare.android.sdk.d6$a */
    public static final class a extends AbstractC0657d6 {

        @NotNull
        public final String a;

        @NotNull
        public final ComposeLazyScroller b;
        public final int c;
        public final int d;

        @NotNull
        public final Rect e;

        @NotNull
        public final List<ViewNode> f;

        @NotNull
        public final Rect g;
        public final boolean h;

        public a(@NotNull String snapshotId, @NotNull ComposeLazyScroller scroller, int i, int i2, @NotNull Rect scrollContainerRect, @NotNull List<ViewNode> itemsToProcess, @NotNull Rect pageRect, boolean z) {
            Intrinsics.checkNotNullParameter(snapshotId, "snapshotId");
            Intrinsics.checkNotNullParameter(scroller, "scroller");
            Intrinsics.checkNotNullParameter(scrollContainerRect, "scrollContainerRect");
            Intrinsics.checkNotNullParameter(itemsToProcess, "itemsToProcess");
            Intrinsics.checkNotNullParameter(pageRect, "pageRect");
            this.a = snapshotId;
            this.b = scroller;
            this.c = i;
            this.d = i2;
            this.e = scrollContainerRect;
            this.f = itemsToProcess;
            this.g = pageRect;
            this.h = z;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && this.c == aVar.c && this.d == aVar.d && Intrinsics.areEqual(this.e, aVar.e) && Intrinsics.areEqual(this.f, aVar.f) && Intrinsics.areEqual(this.g, aVar.g) && this.h == aVar.h;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int iHashCode = (this.g.hashCode() + ((this.f.hashCode() + ((this.e.hashCode() + ((Integer.hashCode(this.d) + ((Integer.hashCode(this.c) + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            boolean z = this.h;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        @NotNull
        public final String toString() {
            return "ComposeLazy(snapshotId=" + this.a + ", scroller=" + this.b + ", itemCount=" + this.c + ", processedItemCount=" + this.d + ", scrollContainerRect=" + this.e + ", itemsToProcess=" + this.f + ", pageRect=" + this.g + ", isLastPage=" + this.h + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* renamed from: com.contentsquare.android.sdk.d6$b */
    public static final class b extends AbstractC0657d6 {

        @NotNull
        public final String a;
        public final int b;

        @NotNull
        public final ComposePageScroller c;

        public b(@NotNull String snapshotId, int i, @NotNull ComposePageScroller scroller) {
            Intrinsics.checkNotNullParameter(snapshotId, "snapshotId");
            Intrinsics.checkNotNullParameter(scroller, "scroller");
            this.a = snapshotId;
            this.b = i;
            this.c = scroller;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.a, bVar.a) && this.b == bVar.b && Intrinsics.areEqual(this.c, bVar.c);
        }

        public final int hashCode() {
            return this.c.hashCode() + ((Integer.hashCode(this.b) + (this.a.hashCode() * 31)) * 31);
        }

        @NotNull
        public final String toString() {
            return "ComposeScrollable(snapshotId=" + this.a + ", snapshotIndex=" + this.b + ", scroller=" + this.c + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* renamed from: com.contentsquare.android.sdk.d6$c */
    public static final class c extends AbstractC0657d6 {

        @NotNull
        public static final c a = new c();
    }

    /* renamed from: com.contentsquare.android.sdk.d6$d */
    public static final class d extends AbstractC0657d6 {

        @NotNull
        public final String a;

        @NotNull
        public final List<Rect> b;

        @NotNull
        public final List<View> c;

        @NotNull
        public final Rect d;

        @NotNull
        public final List<Integer> e;
        public final int f;
        public final int g;

        @NotNull
        public final AbstractC0844w5 h;

        @NotNull
        public final Rect i;

        public d(@NotNull String snapshotId, @NotNull ArrayList itemRectangles, @NotNull ArrayList itemViews, @NotNull Rect scrollContainerRect, @NotNull ArrayList snapshotIndices, int i, int i2, @NotNull AbstractC0844w5 config, @NotNull Rect pageRect) {
            Intrinsics.checkNotNullParameter(snapshotId, "snapshotId");
            Intrinsics.checkNotNullParameter(itemRectangles, "itemRectangles");
            Intrinsics.checkNotNullParameter(itemViews, "itemViews");
            Intrinsics.checkNotNullParameter(scrollContainerRect, "scrollContainerRect");
            Intrinsics.checkNotNullParameter(snapshotIndices, "snapshotIndices");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(pageRect, "pageRect");
            this.a = snapshotId;
            this.b = itemRectangles;
            this.c = itemViews;
            this.d = scrollContainerRect;
            this.e = snapshotIndices;
            this.f = i;
            this.g = i2;
            this.h = config;
            this.i = pageRect;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return Intrinsics.areEqual(this.a, dVar.a) && Intrinsics.areEqual(this.b, dVar.b) && Intrinsics.areEqual(this.c, dVar.c) && Intrinsics.areEqual(this.d, dVar.d) && Intrinsics.areEqual(this.e, dVar.e) && this.f == dVar.f && this.g == dVar.g && Intrinsics.areEqual(this.h, dVar.h) && Intrinsics.areEqual(this.i, dVar.i);
        }

        public final int hashCode() {
            return this.i.hashCode() + ((this.h.hashCode() + ((Integer.hashCode(this.g) + ((Integer.hashCode(this.f) + ((this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        @NotNull
        public final String toString() {
            return "RecyclerView(snapshotId=" + this.a + ", itemRectangles=" + this.b + ", itemViews=" + this.c + ", scrollContainerRect=" + this.d + ", snapshotIndices=" + this.e + ", numberOfSnapshots=" + this.f + ", numberOfProcessedItems=" + this.g + ", config=" + this.h + ", pageRect=" + this.i + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* renamed from: com.contentsquare.android.sdk.d6$e */
    public static final class e extends AbstractC0657d6 {

        @NotNull
        public final String a;

        @NotNull
        public final Point b;

        @NotNull
        public final Rect c;
        public final int d;
        public final int e;

        @NotNull
        public final AbstractC0844w5 f;

        public e(@NotNull String snapshotId, @NotNull Point coordinates, @NotNull Rect scrollContainerRect, int i, int i2, @NotNull AbstractC0844w5 config) {
            Intrinsics.checkNotNullParameter(snapshotId, "snapshotId");
            Intrinsics.checkNotNullParameter(coordinates, "coordinates");
            Intrinsics.checkNotNullParameter(scrollContainerRect, "scrollContainerRect");
            Intrinsics.checkNotNullParameter(config, "config");
            this.a = snapshotId;
            this.b = coordinates;
            this.c = scrollContainerRect;
            this.d = i;
            this.e = i2;
            this.f = config;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return Intrinsics.areEqual(this.a, eVar.a) && Intrinsics.areEqual(this.b, eVar.b) && Intrinsics.areEqual(this.c, eVar.c) && this.d == eVar.d && this.e == eVar.e && Intrinsics.areEqual(this.f, eVar.f);
        }

        public final int hashCode() {
            return this.f.hashCode() + ((Integer.hashCode(this.e) + ((Integer.hashCode(this.d) + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
        }

        @NotNull
        public final String toString() {
            return "ScrollView(snapshotId=" + this.a + ", coordinates=" + this.b + ", scrollContainerRect=" + this.c + ", snapshotIndex=" + this.d + ", numberOfSnapshots=" + this.e + ", config=" + this.f + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }
}
