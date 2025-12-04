package com.urbanairship.android.layout.gestures;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.urbanairship.android.layout.gestures.PagerGestureEvent;
import com.urbanairship.android.layout.property.GestureDirection;
import com.urbanairship.android.layout.property.GestureLocation;
import com.urbanairship.android.layout.util.ViewExtensionsKt;
import com.urbanairship.android.layout.view.PagerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J*\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/android/layout/gestures/PagerGestureDetector;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "view", "Lcom/urbanairship/android/layout/view/PagerView;", "onGestureDetected", "Lkotlin/Function1;", "Lcom/urbanairship/android/layout/gestures/PagerGestureEvent;", "", "(Lcom/urbanairship/android/layout/view/PagerView;Lkotlin/jvm/functions/Function1;)V", "gestureDetector", "Landroid/view/GestureDetector;", "gestureMapper", "Lcom/urbanairship/android/layout/gestures/PagerGestureMapper;", "isLongPressing", "", "onDown", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "onSingleTapConfirmed", "onTouchEvent", "event", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPagerGestureDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerGestureDetector.kt\ncom/urbanairship/android/layout/gestures/PagerGestureDetector\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,83:1\n1549#2:84\n1620#2,3:85\n1855#2,2:88\n*S KotlinDebug\n*F\n+ 1 PagerGestureDetector.kt\ncom/urbanairship/android/layout/gestures/PagerGestureDetector\n*L\n44#1:84\n44#1:85,3\n45#1:88,2\n*E\n"})
/* loaded from: classes5.dex */
public final class PagerGestureDetector extends GestureDetector.SimpleOnGestureListener {
    private final GestureDetector gestureDetector;
    private PagerGestureMapper gestureMapper;
    private boolean isLongPressing;
    private final Function1 onGestureDetected;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        return true;
    }

    public PagerGestureDetector(@NotNull PagerView view, @NotNull Function1<? super PagerGestureEvent, Unit> onGestureDetected) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(onGestureDetected, "onGestureDetected");
        this.onGestureDetected = onGestureDetected;
        this.gestureMapper = new PagerGestureMapper(ViewExtensionsKt.getLocalBounds(view), ViewExtensionsKt.isLayoutRtl(view));
        this.gestureDetector = new GestureDetector(view.getContext(), this);
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.urbanairship.android.layout.gestures.PagerGestureDetector$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                PagerGestureDetector._init_$lambda$0(this.f$0, view2, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(PagerGestureDetector this$0, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PagerGestureMapper pagerGestureMapper = this$0.gestureMapper;
        Intrinsics.checkNotNull(view);
        pagerGestureMapper.onLayoutChanged(ViewExtensionsKt.getLocalBounds(view), ViewExtensionsKt.isLayoutRtl(view));
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        List<GestureLocation> listMapTap = this.gestureMapper.mapTap(e.getX(), e.getY());
        if (listMapTap == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listMapTap, 10));
        Iterator<T> it = listMapTap.iterator();
        while (it.hasNext()) {
            arrayList.add(new PagerGestureEvent.Tap((GestureLocation) it.next()));
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.onGestureDetected.invoke((PagerGestureEvent.Tap) it2.next());
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.isLongPressing = true;
        this.onGestureDetected.invoke(new PagerGestureEvent.Hold(PagerGestureEvent.Hold.Action.PRESS));
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(@Nullable MotionEvent e1, @NotNull MotionEvent e2, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(e2, "e2");
        GestureDirection gestureDirectionMapSwipe = this.gestureMapper.mapSwipe(e1, e2, velocityX, velocityY);
        if (gestureDirectionMapSwipe == null) {
            return true;
        }
        this.onGestureDetected.invoke(new PagerGestureEvent.Swipe(gestureDirectionMapSwipe));
        return true;
    }

    public final void onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.gestureDetector.onTouchEvent(event);
        if (this.isLongPressing && ViewExtensionsKt.isActionUp(event)) {
            this.isLongPressing = false;
            this.onGestureDetected.invoke(new PagerGestureEvent.Hold(PagerGestureEvent.Hold.Action.RELEASE));
        }
    }
}
