package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.urbanairship.android.layout.util.LayoutUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J0\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\u0018\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0014R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"LWrappingViewGroup;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "itemSpacing", "getItemSpacing", "()I", "setItemSpacing", "(I)V", "lineSpacing", "getLineSpacing", "setLineSpacing", "maxItemsPerLine", "getMaxItemsPerLine", "setMaxItemsPerLine", "minTappableHeight", "minTappableWidth", "layoutLine", "", "lineItems", "", "Landroid/view/View;", "parentWidth", "startY", "onLayout", "changed", "", CmcdData.Factory.STREAM_TYPE_LIVE, "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWrappingViewGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WrappingViewGroup.kt\nWrappingViewGroup\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,108:1\n1#2:109\n*E\n"})
/* loaded from: classes2.dex */
public final class WrappingViewGroup extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private int maxItemsPerLine;
    private final int minTappableHeight;
    private final int minTappableWidth;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WrappingViewGroup(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WrappingViewGroup(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ WrappingViewGroup(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WrappingViewGroup(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.maxItemsPerLine = Integer.MAX_VALUE;
        this.minTappableWidth = LayoutUtils.dpToPx(context, 44);
        this.minTappableHeight = LayoutUtils.dpToPx(context, 44);
    }

    public final int getItemSpacing() {
        return this.itemSpacing;
    }

    public final void setItemSpacing(int i) {
        this.itemSpacing = i;
    }

    public final int getLineSpacing() {
        return this.lineSpacing;
    }

    public final void setLineSpacing(int i) {
        this.lineSpacing = i;
    }

    public final int getMaxItemsPerLine() {
        return this.maxItemsPerLine;
    }

    public final void setMaxItemsPerLine(int i) {
        this.maxItemsPerLine = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r12, int r13) {
        /*
            r11 = this;
            int r12 = android.view.View.MeasureSpec.getSize(r12)
            int r0 = r11.getChildCount()
            r1 = 0
            r2 = r1
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
        Le:
            if (r2 >= r0) goto L5c
            android.view.View r7 = r11.getChildAt(r2)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r1)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r1)
            r7.measure(r8, r9)
            int r8 = r11.maxItemsPerLine
            if (r5 >= r8) goto L48
            int r8 = r7.getMeasuredWidth()
            int r8 = r8 + r6
            if (r5 <= 0) goto L2d
            int r9 = r11.itemSpacing
            goto L2e
        L2d:
            r9 = r1
        L2e:
            int r8 = r8 + r9
            if (r8 > r12) goto L48
            int r8 = r7.getMeasuredWidth()
            if (r5 <= 0) goto L3a
            int r9 = r11.itemSpacing
            goto L3b
        L3a:
            r9 = r1
        L3b:
            int r8 = r8 + r9
            int r6 = r6 + r8
            int r7 = r7.getMeasuredHeight()
            int r4 = java.lang.Math.max(r4, r7)
            int r5 = r5 + 1
            goto L59
        L48:
            int r5 = r11.lineSpacing
            int r4 = r4 + r5
            int r3 = r3 + r4
            int r4 = r7.getMeasuredWidth()
            int r5 = r7.getMeasuredHeight()
            r6 = 1
            r10 = r6
            r6 = r4
            r4 = r5
            r5 = r10
        L59:
            int r2 = r2 + 1
            goto Le
        L5c:
            int r3 = r3 + r4
            int r13 = android.view.View.resolveSize(r3, r13)
            r11.setMeasuredDimension(r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.WrappingViewGroup.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int measuredWidth = getMeasuredWidth();
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        int i = 0;
        int i2 = 0;
        int iMax = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int measuredWidth2 = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i + measuredWidth2 + (!arrayList.isEmpty() ? this.itemSpacing : 0) > measuredWidth) {
                layoutLine(arrayList, measuredWidth, i2);
                i2 += iMax + this.lineSpacing;
                arrayList.clear();
                i = 0;
                iMax = 0;
            }
            Intrinsics.checkNotNull(childAt);
            arrayList.add(childAt);
            i += measuredWidth2 + (arrayList.size() > 1 ? this.itemSpacing : 0);
            iMax = Math.max(iMax, measuredHeight);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        layoutLine(arrayList, measuredWidth, i2);
    }

    private final void layoutLine(List lineItems, int parentWidth, int startY) {
        int size = this.itemSpacing * (lineItems.size() - 1);
        Iterator it = lineItems.iterator();
        int measuredWidth = 0;
        while (it.hasNext()) {
            measuredWidth += ((View) it.next()).getMeasuredWidth();
        }
        int measuredWidth2 = (parentWidth - (measuredWidth + size)) / 2;
        Iterator it2 = lineItems.iterator();
        while (it2.hasNext()) {
            View view = (View) it2.next();
            view.layout(measuredWidth2, startY, view.getMeasuredWidth() + measuredWidth2, view.getMeasuredHeight() + startY);
            measuredWidth2 += view.getMeasuredWidth() + this.itemSpacing;
        }
    }
}
