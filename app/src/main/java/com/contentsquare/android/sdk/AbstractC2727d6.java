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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.d6 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2727d6 {

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.d6$a */
    public static final class a extends AbstractC2727d6 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final String f2499a;

        /* JADX INFO: renamed from: b */
        @NotNull
        public final ComposeLazyScroller f2500b;

        /* JADX INFO: renamed from: c */
        public final int f2501c;

        /* JADX INFO: renamed from: d */
        public final int f2502d;

        /* JADX INFO: renamed from: e */
        @NotNull
        public final Rect f2503e;

        /* JADX INFO: renamed from: f */
        @NotNull
        public final List<ViewNode> f2504f;

        /* JADX INFO: renamed from: g */
        @NotNull
        public final Rect f2505g;

        /* JADX INFO: renamed from: h */
        public final boolean f2506h;

        public a(@NotNull String snapshotId, @NotNull ComposeLazyScroller scroller, int i, int i2, @NotNull Rect scrollContainerRect, @NotNull List<ViewNode> itemsToProcess, @NotNull Rect pageRect, boolean z) {
            Intrinsics.checkNotNullParameter(snapshotId, "snapshotId");
            Intrinsics.checkNotNullParameter(scroller, "scroller");
            Intrinsics.checkNotNullParameter(scrollContainerRect, "scrollContainerRect");
            Intrinsics.checkNotNullParameter(itemsToProcess, "itemsToProcess");
            Intrinsics.checkNotNullParameter(pageRect, "pageRect");
            this.f2499a = snapshotId;
            this.f2500b = scroller;
            this.f2501c = i;
            this.f2502d = i2;
            this.f2503e = scrollContainerRect;
            this.f2504f = itemsToProcess;
            this.f2505g = pageRect;
            this.f2506h = z;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f2499a, aVar.f2499a) && Intrinsics.areEqual(this.f2500b, aVar.f2500b) && this.f2501c == aVar.f2501c && this.f2502d == aVar.f2502d && Intrinsics.areEqual(this.f2503e, aVar.f2503e) && Intrinsics.areEqual(this.f2504f, aVar.f2504f) && Intrinsics.areEqual(this.f2505g, aVar.f2505g) && this.f2506h == aVar.f2506h;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v15, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public final int hashCode() {
            int iHashCode = (this.f2505g.hashCode() + ((this.f2504f.hashCode() + ((this.f2503e.hashCode() + ((Integer.hashCode(this.f2502d) + ((Integer.hashCode(this.f2501c) + ((this.f2500b.hashCode() + (this.f2499a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            boolean z = this.f2506h;
            ?? r2 = z;
            if (z) {
                r2 = 1;
            }
            return iHashCode + r2;
        }

        @NotNull
        public final String toString() {
            return "ComposeLazy(snapshotId=" + this.f2499a + ", scroller=" + this.f2500b + ", itemCount=" + this.f2501c + ", processedItemCount=" + this.f2502d + ", scrollContainerRect=" + this.f2503e + ", itemsToProcess=" + this.f2504f + ", pageRect=" + this.f2505g + ", isLastPage=" + this.f2506h + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.d6$b */
    public static final class b extends AbstractC2727d6 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final String f2507a;

        /* JADX INFO: renamed from: b */
        public final int f2508b;

        /* JADX INFO: renamed from: c */
        @NotNull
        public final ComposePageScroller f2509c;

        public b(@NotNull String snapshotId, int i, @NotNull ComposePageScroller scroller) {
            Intrinsics.checkNotNullParameter(snapshotId, "snapshotId");
            Intrinsics.checkNotNullParameter(scroller, "scroller");
            this.f2507a = snapshotId;
            this.f2508b = i;
            this.f2509c = scroller;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.f2507a, bVar.f2507a) && this.f2508b == bVar.f2508b && Intrinsics.areEqual(this.f2509c, bVar.f2509c);
        }

        public final int hashCode() {
            return this.f2509c.hashCode() + ((Integer.hashCode(this.f2508b) + (this.f2507a.hashCode() * 31)) * 31);
        }

        @NotNull
        public final String toString() {
            return "ComposeScrollable(snapshotId=" + this.f2507a + ", snapshotIndex=" + this.f2508b + ", scroller=" + this.f2509c + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.d6$c */
    public static final class c extends AbstractC2727d6 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public static final c f2510a = new c();
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.d6$d */
    public static final class d extends AbstractC2727d6 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final String f2511a;

        /* JADX INFO: renamed from: b */
        @NotNull
        public final List<Rect> f2512b;

        /* JADX INFO: renamed from: c */
        @NotNull
        public final List<View> f2513c;

        /* JADX INFO: renamed from: d */
        @NotNull
        public final Rect f2514d;

        /* JADX INFO: renamed from: e */
        @NotNull
        public final List<Integer> f2515e;

        /* JADX INFO: renamed from: f */
        public final int f2516f;

        /* JADX INFO: renamed from: g */
        public final int f2517g;

        /* JADX INFO: renamed from: h */
        @NotNull
        public final AbstractC2916w5 f2518h;

        /* JADX INFO: renamed from: i */
        @NotNull
        public final Rect f2519i;

        public d(@NotNull String snapshotId, @NotNull ArrayList itemRectangles, @NotNull ArrayList itemViews, @NotNull Rect scrollContainerRect, @NotNull ArrayList snapshotIndices, int i, int i2, @NotNull AbstractC2916w5 config, @NotNull Rect pageRect) {
            Intrinsics.checkNotNullParameter(snapshotId, "snapshotId");
            Intrinsics.checkNotNullParameter(itemRectangles, "itemRectangles");
            Intrinsics.checkNotNullParameter(itemViews, "itemViews");
            Intrinsics.checkNotNullParameter(scrollContainerRect, "scrollContainerRect");
            Intrinsics.checkNotNullParameter(snapshotIndices, "snapshotIndices");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(pageRect, "pageRect");
            this.f2511a = snapshotId;
            this.f2512b = itemRectangles;
            this.f2513c = itemViews;
            this.f2514d = scrollContainerRect;
            this.f2515e = snapshotIndices;
            this.f2516f = i;
            this.f2517g = i2;
            this.f2518h = config;
            this.f2519i = pageRect;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return Intrinsics.areEqual(this.f2511a, dVar.f2511a) && Intrinsics.areEqual(this.f2512b, dVar.f2512b) && Intrinsics.areEqual(this.f2513c, dVar.f2513c) && Intrinsics.areEqual(this.f2514d, dVar.f2514d) && Intrinsics.areEqual(this.f2515e, dVar.f2515e) && this.f2516f == dVar.f2516f && this.f2517g == dVar.f2517g && Intrinsics.areEqual(this.f2518h, dVar.f2518h) && Intrinsics.areEqual(this.f2519i, dVar.f2519i);
        }

        public final int hashCode() {
            return this.f2519i.hashCode() + ((this.f2518h.hashCode() + ((Integer.hashCode(this.f2517g) + ((Integer.hashCode(this.f2516f) + ((this.f2515e.hashCode() + ((this.f2514d.hashCode() + ((this.f2513c.hashCode() + ((this.f2512b.hashCode() + (this.f2511a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        @NotNull
        public final String toString() {
            return "RecyclerView(snapshotId=" + this.f2511a + ", itemRectangles=" + this.f2512b + ", itemViews=" + this.f2513c + ", scrollContainerRect=" + this.f2514d + ", snapshotIndices=" + this.f2515e + ", numberOfSnapshots=" + this.f2516f + ", numberOfProcessedItems=" + this.f2517g + ", config=" + this.f2518h + ", pageRect=" + this.f2519i + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.d6$e */
    public static final class e extends AbstractC2727d6 {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final String f2520a;

        /* JADX INFO: renamed from: b */
        @NotNull
        public final Point f2521b;

        /* JADX INFO: renamed from: c */
        @NotNull
        public final Rect f2522c;

        /* JADX INFO: renamed from: d */
        public final int f2523d;

        /* JADX INFO: renamed from: e */
        public final int f2524e;

        /* JADX INFO: renamed from: f */
        @NotNull
        public final AbstractC2916w5 f2525f;

        public e(@NotNull String snapshotId, @NotNull Point coordinates, @NotNull Rect scrollContainerRect, int i, int i2, @NotNull AbstractC2916w5 config) {
            Intrinsics.checkNotNullParameter(snapshotId, "snapshotId");
            Intrinsics.checkNotNullParameter(coordinates, "coordinates");
            Intrinsics.checkNotNullParameter(scrollContainerRect, "scrollContainerRect");
            Intrinsics.checkNotNullParameter(config, "config");
            this.f2520a = snapshotId;
            this.f2521b = coordinates;
            this.f2522c = scrollContainerRect;
            this.f2523d = i;
            this.f2524e = i2;
            this.f2525f = config;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return Intrinsics.areEqual(this.f2520a, eVar.f2520a) && Intrinsics.areEqual(this.f2521b, eVar.f2521b) && Intrinsics.areEqual(this.f2522c, eVar.f2522c) && this.f2523d == eVar.f2523d && this.f2524e == eVar.f2524e && Intrinsics.areEqual(this.f2525f, eVar.f2525f);
        }

        public final int hashCode() {
            return this.f2525f.hashCode() + ((Integer.hashCode(this.f2524e) + ((Integer.hashCode(this.f2523d) + ((this.f2522c.hashCode() + ((this.f2521b.hashCode() + (this.f2520a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
        }

        @NotNull
        public final String toString() {
            return "ScrollView(snapshotId=" + this.f2520a + ", coordinates=" + this.f2521b + ", scrollContainerRect=" + this.f2522c + ", snapshotIndex=" + this.f2523d + ", numberOfSnapshots=" + this.f2524e + ", config=" + this.f2525f + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }
}
