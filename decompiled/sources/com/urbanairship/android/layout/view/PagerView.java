package com.urbanairship.android.layout.view;

import android.content.Context;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.gestures.PagerGestureDetector;
import com.urbanairship.android.layout.gestures.PagerGestureEvent;
import com.urbanairship.android.layout.info.AccessibilityAction;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.PagerModel;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.ViewExtensionsKt;
import com.urbanairship.android.layout.view.PagerView;
import com.urbanairship.android.layout.widget.PagerRecyclerView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0019\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002:;B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020*H\u0014J\b\u0010+\u001a\u00020*H\u0014J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020$H\u0016J\u0018\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020&2\u0006\u0010.\u001a\u000201H\u0016J*\u00102\u001a\u00020*2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u0001042\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020*07J\u0014\u00108\u001a\u00020-*\u00020$2\u0006\u0010!\u001a\u000209H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/urbanairship/android/layout/view/PagerView;", "Landroid/widget/FrameLayout;", "Lcom/urbanairship/android/layout/view/BaseView;", "Landroid/view/KeyEvent$Callback;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/PagerModel;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/PagerModel;Lcom/urbanairship/android/layout/environment/ViewEnvironment;)V", "accessibilityListener", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "gestureDetector", "Lcom/urbanairship/android/layout/gestures/PagerGestureDetector;", "value", "Lcom/urbanairship/android/layout/view/PagerView$OnPagerGestureListener;", "gestureListener", "getGestureListener", "()Lcom/urbanairship/android/layout/view/PagerView$OnPagerGestureListener;", "setGestureListener", "(Lcom/urbanairship/android/layout/view/PagerView$OnPagerGestureListener;)V", "getModel", "()Lcom/urbanairship/android/layout/model/PagerModel;", "modelListener", "com/urbanairship/android/layout/view/PagerView$modelListener$1", "Lcom/urbanairship/android/layout/view/PagerView$modelListener$1;", "scrollListener", "Lcom/urbanairship/android/layout/view/PagerView$OnScrollListener;", "getScrollListener", "()Lcom/urbanairship/android/layout/view/PagerView$OnScrollListener;", "setScrollListener", "(Lcom/urbanairship/android/layout/view/PagerView$OnScrollListener;)V", "view", "Lcom/urbanairship/android/layout/widget/PagerRecyclerView;", "generateMotionEvent", "Landroid/view/MotionEvent;", "action", "", "xCoordinate", "", "onAttachedToWindow", "", "onDetachedFromWindow", "onInterceptTouchEvent", "", "event", "onKeyDown", "keyCode", "Landroid/view/KeyEvent;", "setAccessibilityActions", "actions", "", "Lcom/urbanairship/android/layout/info/AccessibilityAction;", "onActionPerformed", "Lkotlin/Function1;", "isWithinClickableDescendantOf", "Landroid/view/View;", "OnPagerGestureListener", "OnScrollListener", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPagerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerView.kt\ncom/urbanairship/android/layout/view/PagerView\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,217:1\n179#2,2:218\n*S KotlinDebug\n*F\n+ 1 PagerView.kt\ncom/urbanairship/android/layout/view/PagerView\n*L\n182#1:218,2\n*E\n"})
/* loaded from: classes5.dex */
public final class PagerView extends FrameLayout implements BaseView, KeyEvent.Callback {
    private AccessibilityManager.TouchExplorationStateChangeListener accessibilityListener;
    private PagerGestureDetector gestureDetector;
    private OnPagerGestureListener gestureListener;
    private final PagerModel model;
    private final PagerView$modelListener$1 modelListener;
    private OnScrollListener scrollListener;
    private final PagerRecyclerView view;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/view/PagerView$OnPagerGestureListener;", "", "onGesture", "", "event", "Lcom/urbanairship/android/layout/gestures/PagerGestureEvent;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnPagerGestureListener {
        void onGesture(@NotNull PagerGestureEvent event);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/view/PagerView$OnScrollListener;", "", "onScrollTo", "", ViewProps.POSITION, "", "isInternalScroll", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnScrollListener {
        void onScrollTo(int position, boolean isInternalScroll);
    }

    @NotNull
    public final PagerModel getModel() {
        return this.model;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.urbanairship.android.layout.model.BaseModel$Listener, com.urbanairship.android.layout.view.PagerView$modelListener$1] */
    public PagerView(@NotNull Context context, @NotNull PagerModel model, @NotNull ViewEnvironment viewEnvironment) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        this.model = model;
        PagerRecyclerView pagerRecyclerView = new PagerRecyclerView(context, model, viewEnvironment);
        this.view = pagerRecyclerView;
        ?? r2 = new PagerModel.Listener() { // from class: com.urbanairship.android.layout.view.PagerView$modelListener$1
            @Override // com.urbanairship.android.layout.model.PagerModel.Listener
            public void scrollTo(int position) {
                if (position != -1) {
                    this.this$0.view.scrollTo(position);
                }
            }

            @Override // com.urbanairship.android.layout.model.PagerModel.Listener
            public void onDataUpdated() {
                this.this$0.view.refresh();
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                this.this$0.setVisibility(visible ? 0 : 8);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                this.this$0.setEnabled(enabled);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background) {
                Intrinsics.checkNotNullParameter(background, "new");
                LayoutUtils.updateBackground(this.this$0, old, background);
            }
        };
        this.modelListener = r2;
        setFocusable(true);
        setFocusedByDefault(true);
        addView(pagerRecyclerView, -1, -1);
        model.setListener$urbanairship_layout_release(r2);
        pagerRecyclerView.setPagerScrollListener(new OnScrollListener() { // from class: com.urbanairship.android.layout.view.PagerView$$ExternalSyntheticLambda1
            @Override // com.urbanairship.android.layout.view.PagerView.OnScrollListener
            public final void onScrollTo(int i, boolean z) {
                PagerView._init_$lambda$0(this.f$0, i, z);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.urbanairship.android.layout.view.PagerView$$ExternalSyntheticLambda2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return PagerView._init_$lambda$1(this.f$0, view, windowInsetsCompat);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/urbanairship/android/layout/view/PagerView$setAccessibilityActions$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPagerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerView.kt\ncom/urbanairship/android/layout/view/PagerView$setAccessibilityActions$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,217:1\n1855#2,2:218\n*S KotlinDebug\n*F\n+ 1 PagerView.kt\ncom/urbanairship/android/layout/view/PagerView$setAccessibilityActions$1\n*L\n54#1:218,2\n*E\n"})
    /* renamed from: com.urbanairship.android.layout.view.PagerView$setAccessibilityActions$1, reason: invalid class name and case insensitive filesystem */
    public static final class C09721 extends AccessibilityDelegateCompat {
        final /* synthetic */ List $actions;
        final /* synthetic */ Function1 $onActionPerformed;
        final /* synthetic */ PagerView this$0;

        C09721(List list, PagerView pagerView, Function1 function1) {
            this.$actions = list;
            this.this$0 = pagerView;
            this.$onActionPerformed = function1;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
        @Override // androidx.core.view.AccessibilityDelegateCompat
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onInitializeAccessibilityNodeInfo(@org.jetbrains.annotations.NotNull android.view.View r7, @org.jetbrains.annotations.NotNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat r8) {
            /*
                r6 = this;
                java.lang.String r0 = "host"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                java.lang.String r0 = "info"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                super.onInitializeAccessibilityNodeInfo(r7, r8)
                java.util.List r8 = r6.$actions
                if (r8 == 0) goto L63
                com.urbanairship.android.layout.view.PagerView r0 = r6.this$0
                kotlin.jvm.functions.Function1 r6 = r6.$onActionPerformed
                java.util.Iterator r8 = r8.iterator()
            L19:
                boolean r1 = r8.hasNext()
                if (r1 == 0) goto L63
                java.lang.Object r1 = r8.next()
                com.urbanairship.android.layout.info.AccessibilityAction r1 = (com.urbanairship.android.layout.info.AccessibilityAction) r1
                com.urbanairship.android.layout.info.LocalizedContentDescription r2 = r1.getLocalizedContentDescription()
                java.lang.String r3 = "Unknown"
                if (r2 == 0) goto L4d
                java.lang.String r2 = r2.getRef()
                if (r2 == 0) goto L4d
                android.content.Context r4 = r0.getContext()
                com.urbanairship.android.layout.info.LocalizedContentDescription r5 = r1.getLocalizedContentDescription()
                if (r5 == 0) goto L43
                java.lang.String r5 = r5.getFallback()
                if (r5 != 0) goto L44
            L43:
                r5 = r3
            L44:
                java.lang.String r2 = com.urbanairship.util.UAStringUtil.namedStringResource(r4, r2, r5)
                if (r2 != 0) goto L4b
                goto L4d
            L4b:
                r3 = r2
                goto L57
            L4d:
                com.urbanairship.android.layout.info.LocalizedContentDescription r2 = r1.getLocalizedContentDescription()
                if (r2 == 0) goto L57
                java.lang.String r3 = r2.getFallback()
            L57:
                kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
                com.urbanairship.android.layout.view.PagerView$setAccessibilityActions$1$$ExternalSyntheticLambda0 r2 = new com.urbanairship.android.layout.view.PagerView$setAccessibilityActions$1$$ExternalSyntheticLambda0
                r2.<init>()
                androidx.core.view.ViewCompat.addAccessibilityAction(r7, r3, r2)
                goto L19
            L63:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.view.PagerView.C09721.onInitializeAccessibilityNodeInfo(android.view.View, androidx.core.view.accessibility.AccessibilityNodeInfoCompat):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean onInitializeAccessibilityNodeInfo$lambda$2$lambda$1(Function1 onActionPerformed, AccessibilityAction action, View view, AccessibilityViewCommand.CommandArguments commandArguments) {
            Intrinsics.checkNotNullParameter(onActionPerformed, "$onActionPerformed");
            Intrinsics.checkNotNullParameter(action, "$action");
            Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
            onActionPerformed.invoke(action);
            return true;
        }
    }

    public final void setAccessibilityActions(@Nullable List<AccessibilityAction> actions, @NotNull Function1<? super AccessibilityAction, Unit> onActionPerformed) {
        Intrinsics.checkNotNullParameter(onActionPerformed, "onActionPerformed");
        ViewCompat.setAccessibilityDelegate(this, new C09721(actions, this, onActionPerformed));
    }

    @Nullable
    public final OnScrollListener getScrollListener() {
        return this.scrollListener;
    }

    public final void setScrollListener(@Nullable OnScrollListener onScrollListener) {
        this.scrollListener = onScrollListener;
    }

    @Nullable
    public final OnPagerGestureListener getGestureListener() {
        return this.gestureListener;
    }

    public final void setGestureListener(@Nullable OnPagerGestureListener onPagerGestureListener) {
        PagerGestureDetector pagerGestureDetector;
        this.gestureListener = onPagerGestureListener;
        if (onPagerGestureListener != null) {
            pagerGestureDetector = this.gestureDetector;
            if (pagerGestureDetector == null) {
                pagerGestureDetector = new PagerGestureDetector(this, new Function1() { // from class: com.urbanairship.android.layout.view.PagerView$gestureListener$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((PagerGestureEvent) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PagerGestureEvent it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        PagerView.OnPagerGestureListener gestureListener = this.this$0.getGestureListener();
                        if (gestureListener != null) {
                            gestureListener.onGesture(it);
                        }
                    }
                });
            }
        } else {
            pagerGestureDetector = null;
        }
        this.gestureDetector = pagerGestureDetector;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(PagerView this$0, int i, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnScrollListener onScrollListener = this$0.scrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollTo(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat _init_$lambda$1(PagerView this$0, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        return ViewCompat.dispatchApplyWindowInsets(this$0.view, insets);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode == 21) {
            PagerGestureDetector pagerGestureDetector = this.gestureDetector;
            if (pagerGestureDetector == null) {
                return true;
            }
            pagerGestureDetector.onTouchEvent(generateMotionEvent(0, 45.0f));
            pagerGestureDetector.onTouchEvent(generateMotionEvent(1, 45.0f));
            return true;
        }
        if (keyCode == 22) {
            PagerGestureDetector pagerGestureDetector2 = this.gestureDetector;
            if (pagerGestureDetector2 == null) {
                return true;
            }
            pagerGestureDetector2.onTouchEvent(generateMotionEvent(0, 975.0f));
            pagerGestureDetector2.onTouchEvent(generateMotionEvent(1, 975.0f));
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        PagerGestureDetector pagerGestureDetector = this.gestureDetector;
        if (pagerGestureDetector != null && !isWithinClickableDescendantOf(event, this.view)) {
            pagerGestureDetector.onTouchEvent(event);
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.accessibilityListener == null) {
            Object systemService = getContext().getSystemService("accessibility");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
            AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.urbanairship.android.layout.view.PagerView$$ExternalSyntheticLambda0
                @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
                public final void onTouchExplorationStateChanged(boolean z) {
                    PagerView.onAttachedToWindow$lambda$7(this.f$0, z);
                }
            };
            this.accessibilityListener = touchExplorationStateChangeListener;
            ((AccessibilityManager) systemService).addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAttachedToWindow$lambda$7(PagerView this$0, boolean z) {
        View next;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            Iterator<View> it = ViewGroupKt.getDescendants(this$0.view).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (next.isImportantForAccessibility()) {
                        break;
                    }
                }
            }
            final View view = next;
            if (view != null) {
                view.postDelayed(new Runnable() { // from class: com.urbanairship.android.layout.view.PagerView$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.performAccessibilityAction(64, null);
                    }
                }, 1000L);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.accessibilityListener;
        if (touchExplorationStateChangeListener != null) {
            Object systemService = getContext().getSystemService("accessibility");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
            ((AccessibilityManager) systemService).removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
        this.accessibilityListener = null;
    }

    private final MotionEvent generateMotionEvent(int action, float xCoordinate) {
        MotionEvent motionEventObtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), action, xCoordinate, 1500.0f, 0);
        Intrinsics.checkNotNullExpressionValue(motionEventObtain, "obtain(...)");
        return motionEventObtain;
    }

    private final boolean isWithinClickableDescendantOf(MotionEvent motionEvent, View view) {
        return ViewExtensionsKt.findTargetDescendant(motionEvent, view, new Function1() { // from class: com.urbanairship.android.layout.view.PagerView.isWithinClickableDescendantOf.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.isClickable() && ((it instanceof MediaView) || (it instanceof WebViewView)));
            }
        }) != null;
    }
}
