package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.bottomsheet.SheetUtilsKt;
import com.swmansion.rnscreens.events.StackFinishTransitioningEvent;
import com.swmansion.rnscreens.stack.views.ChildrenDrawingOrderStrategy;
import com.swmansion.rnscreens.stack.views.ReverseFromIndex;
import com.swmansion.rnscreens.stack.views.ReverseOrder;
import com.swmansion.rnscreens.stack.views.ScreensCoordinatorLayout;
import com.swmansion.rnscreens.utils.FragmentTransactionKtKt;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.json.matchers.ArrayContainsMatcher;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 J2\u00020\u0001:\u0002IJB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\bJ\u0010\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020#H\u0014J\u0010\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\u0019H\u0016J\u0010\u0010/\u001a\u00020 2\u0006\u0010.\u001a\u00020\u0019H\u0016J\u0006\u00100\u001a\u00020 J\u000e\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\rJ\b\u00103\u001a\u00020 H\u0002J\u0010\u00104\u001a\u00020 2\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020 H\u0016J\u0012\u00108\u001a\u00020\u00152\b\u00109\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010:\u001a\u00020 H\u0016J\u0012\u0010;\u001a\u00020 2\b\u0010<\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010=\u001a\u00020 H\u0014J\b\u0010>\u001a\u00020 H\u0002J\u0010\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020AH\u0014J \u0010B\u001a\u00020\u00152\u0006\u0010@\u001a\u00020A2\u0006\u0010C\u001a\u00020\u00192\u0006\u0010D\u001a\u00020EH\u0014J\u0014\u0010F\u001a\u00020 2\n\u0010G\u001a\u00060\u0011R\u00020\u0000H\u0002J\f\u0010H\u001a\u00060\u0011R\u00020\u0000H\u0002R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0011R\u00020\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0011R\u00020\u00000\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u0004\u0018\u00010#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R!\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b*\u0010%¨\u0006K"}, m1836d2 = {"Lcom/swmansion/rnscreens/ScreenStack;", "Lcom/swmansion/rnscreens/ScreenContainer;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "stack", "Ljava/util/ArrayList;", "Lcom/swmansion/rnscreens/ScreenStackFragmentWrapper;", "Lkotlin/collections/ArrayList;", "dismissedWrappers", "", "preloadedWrappers", "", "Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "drawingOpPool", "", "Lcom/swmansion/rnscreens/ScreenStack$DrawingOp;", "drawingOps", "topScreenWrapper", "removalTransitionStarted", "", "childrenDrawingOrderStrategy", "Lcom/swmansion/rnscreens/stack/views/ChildrenDrawingOrderStrategy;", "disappearingTransitioningChildren", "Landroid/view/View;", "goingForward", "getGoingForward", "()Z", "setGoingForward", "(Z)V", "dismiss", "", "screenFragment", "topScreen", "Lcom/swmansion/rnscreens/Screen;", "getTopScreen", "()Lcom/swmansion/rnscreens/Screen;", "fragments", "getFragments", "()Ljava/util/ArrayList;", "rootScreen", "getRootScreen", "adapt", TCEventPropertiesNames.TCD_SCREEN, "startViewTransition", "view", "endViewTransition", "onViewAppearTransitionEnd", "getScreenIds", "", "dispatchOnFinishTransitioning", "removeScreenAt", ArrayContainsMatcher.INDEX_KEY, "", "removeAllScreens", "hasScreen", "screenFragmentWrapper", "onUpdate", "turnOffA11yUnderTransparentScreen", "visibleBottom", "notifyContainerUpdate", "drawAndRelease", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawChild", "child", "drawingTime", "", "performDraw", "op", "obtainDrawingOp", "DrawingOp", "Companion", "react-native-screens_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nScreenStack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenStack.kt\ncom/swmansion/rnscreens/ScreenStack\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,396:1\n295#2,2:397\n1557#2:400\n1628#2,3:401\n1863#2,2:410\n1#3:399\n1317#4,2:404\n1317#4,2:406\n1317#4,2:408\n*S KotlinDebug\n*F\n+ 1 ScreenStack.kt\ncom/swmansion/rnscreens/ScreenStack\n*L\n54#1:397,2\n98#1:400\n98#1:401,3\n312#1:410,2\n237#1:404,2\n244#1:406,2\n252#1:408,2\n*E\n"})
public final class ScreenStack extends ScreenContainer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "ScreenStack";

    @Nullable
    private ChildrenDrawingOrderStrategy childrenDrawingOrderStrategy;

    @NotNull
    private List<View> disappearingTransitioningChildren;

    @NotNull
    private final Set<ScreenStackFragmentWrapper> dismissedWrappers;

    @NotNull
    private final List<DrawingOp> drawingOpPool;

    @NotNull
    private List<DrawingOp> drawingOps;
    private boolean goingForward;

    @NotNull
    private List<? extends ScreenFragmentWrapper> preloadedWrappers;
    private boolean removalTransitionStarted;

    @NotNull
    private final ArrayList<ScreenStackFragmentWrapper> stack;

    @Nullable
    private ScreenStackFragmentWrapper topScreenWrapper;

    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Screen.StackPresentation.values().length];
            try {
                iArr[Screen.StackPresentation.FORM_SHEET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ScreenStack(@Nullable Context context) {
        super(context);
        this.stack = new ArrayList<>();
        this.dismissedWrappers = new HashSet();
        this.preloadedWrappers = new ArrayList();
        this.drawingOpPool = new ArrayList();
        this.drawingOps = new ArrayList();
        this.disappearingTransitioningChildren = new ArrayList();
    }

    public final boolean getGoingForward() {
        return this.goingForward;
    }

    public final void setGoingForward(boolean z) {
        this.goingForward = z;
    }

    public final void dismiss(@NotNull ScreenStackFragmentWrapper screenFragment) {
        Intrinsics.checkNotNullParameter(screenFragment, "screenFragment");
        this.dismissedWrappers.add(screenFragment);
        performUpdatesNow();
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    @Nullable
    public Screen getTopScreen() {
        ScreenStackFragmentWrapper screenStackFragmentWrapper = this.topScreenWrapper;
        if (screenStackFragmentWrapper != null) {
            return screenStackFragmentWrapper.getScreen();
        }
        return null;
    }

    @NotNull
    public final ArrayList<ScreenStackFragmentWrapper> getFragments() {
        return this.stack;
    }

    @NotNull
    public final Screen getRootScreen() {
        Object next;
        Screen screen;
        Iterator<T> it = this.screenWrappers.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (CollectionsKt.contains(this.dismissedWrappers, (ScreenFragmentWrapper) next));
        ScreenFragmentWrapper screenFragmentWrapper = (ScreenFragmentWrapper) next;
        if (screenFragmentWrapper == null || (screen = screenFragmentWrapper.getScreen()) == null) {
            throw new IllegalStateException("[RNScreens] Stack has no root screen set");
        }
        return screen;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.swmansion.rnscreens.ScreenContainer
    @NotNull
    public ScreenStackFragmentWrapper adapt(@NotNull Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (WhenMappings.$EnumSwitchMapping$0[screen.getStackPresentation().ordinal()] == 1) {
            return new ScreenStackFragment(screen);
        }
        return new ScreenStackFragment(screen);
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(@NotNull View view) {
        ChildrenDrawingOrderStrategy childrenDrawingOrderStrategy;
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof ScreensCoordinatorLayout)) {
            throw new IllegalStateException(("[RNScreens] Unexpected type of ScreenStack direct subview " + view.getClass()).toString());
        }
        super.startViewTransition(view);
        if (((ScreensCoordinatorLayout) view).getFragment().isRemoving()) {
            this.disappearingTransitioningChildren.add(view);
        }
        if (!this.disappearingTransitioningChildren.isEmpty() && (childrenDrawingOrderStrategy = this.childrenDrawingOrderStrategy) != null) {
            childrenDrawingOrderStrategy.enable();
        }
        this.removalTransitionStarted = true;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(@NotNull View view) {
        ChildrenDrawingOrderStrategy childrenDrawingOrderStrategy;
        Intrinsics.checkNotNullParameter(view, "view");
        super.endViewTransition(view);
        this.disappearingTransitioningChildren.remove(view);
        if (this.disappearingTransitioningChildren.isEmpty() && (childrenDrawingOrderStrategy = this.childrenDrawingOrderStrategy) != null) {
            childrenDrawingOrderStrategy.disable();
        }
        if (this.removalTransitionStarted) {
            this.removalTransitionStarted = false;
            dispatchOnFinishTransitioning();
        }
    }

    public final void onViewAppearTransitionEnd() {
        if (this.removalTransitionStarted) {
            return;
        }
        dispatchOnFinishTransitioning();
    }

    @NotNull
    public final List<String> getScreenIds() {
        ArrayList<ScreenFragmentWrapper> arrayList = this.screenWrappers;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ScreenFragmentWrapper) it.next()).getScreen().getScreenId());
        }
        return arrayList2;
    }

    private final void dispatchOnFinishTransitioning() {
        int surfaceId = UIManagerHelper.getSurfaceId(this);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new StackFinishTransitioningEvent(surfaceId, getId()));
        }
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public void removeScreenAt(int index) {
        Set<ScreenStackFragmentWrapper> set = this.dismissedWrappers;
        TypeIntrinsics.asMutableCollection(set).remove(getScreenFragmentWrapperAt(index));
        super.removeScreenAt(index);
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public void removeAllScreens() {
        this.dismissedWrappers.clear();
        super.removeAllScreens();
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    public boolean hasScreen(@Nullable ScreenFragmentWrapper screenFragmentWrapper) {
        return super.hasScreen(screenFragmentWrapper) && !CollectionsKt.contains(this.dismissedWrappers, screenFragmentWrapper);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.Object] */
    @Override // com.swmansion.rnscreens.ScreenContainer
    public void onUpdate() {
        T t;
        Screen.StackAnimation stackAnimation;
        boolean z;
        Screen screen;
        ScreenStackFragmentWrapper screenStackFragmentWrapper;
        int iCount;
        T t2;
        Screen screen2;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        this.childrenDrawingOrderStrategy = null;
        Sequence sequenceFilter = SequencesKt.filter(CollectionsKt.asSequence(CollectionsKt.asReversedMutable(this.screenWrappers)), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$3(this.f$0, (ScreenFragmentWrapper) obj));
            }
        });
        objectRef.element = SequencesKt.firstOrNull(sequenceFilter);
        ScreenFragmentWrapper screenFragmentWrapper = (ScreenFragmentWrapper) SequencesKt.firstOrNull(SequencesKt.dropWhile(sequenceFilter, new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$4((ScreenFragmentWrapper) obj));
            }
        }));
        if (screenFragmentWrapper == null || screenFragmentWrapper == objectRef.element) {
            t = screenFragmentWrapper;
            t = 0;
        }
        t = screenFragmentWrapper;
        objectRef2.element = t;
        boolean z2 = CollectionsKt.contains(this.stack, objectRef.element) && !CollectionsKt.contains(this.preloadedWrappers, objectRef.element);
        T t3 = objectRef.element;
        ScreenStackFragmentWrapper screenStackFragmentWrapper2 = this.topScreenWrapper;
        boolean z3 = t3 != screenStackFragmentWrapper2;
        if (t3 == 0 || z2) {
            if (t3 == 0 || screenStackFragmentWrapper2 == null || !z3) {
                stackAnimation = null;
                z = true;
            } else {
                stackAnimation = (screenStackFragmentWrapper2 == null || (screen = screenStackFragmentWrapper2.getScreen()) == null) ? null : screen.getStackAnimation();
                z = false;
            }
        } else if (screenStackFragmentWrapper2 != null) {
            z = (screenStackFragmentWrapper2 != null && this.screenWrappers.contains(screenStackFragmentWrapper2)) || (((ScreenFragmentWrapper) objectRef.element).getScreen().getReplaceAnimation() == Screen.ReplaceAnimation.PUSH);
            if (z) {
                screen2 = ((ScreenFragmentWrapper) objectRef.element).getScreen();
            } else {
                ScreenStackFragmentWrapper screenStackFragmentWrapper3 = this.topScreenWrapper;
                if (screenStackFragmentWrapper3 == null || (screen2 = screenStackFragmentWrapper3.getScreen()) == null) {
                    stackAnimation = null;
                }
            }
            stackAnimation = screen2.getStackAnimation();
        } else {
            stackAnimation = Screen.StackAnimation.NONE;
            this.goingForward = true;
            z = true;
        }
        this.goingForward = z;
        if (z && (t2 = objectRef.element) != 0 && INSTANCE.needsDrawReordering((ScreenFragmentWrapper) t2, stackAnimation) && objectRef2.element == 0) {
            this.childrenDrawingOrderStrategy = new ReverseOrder();
        } else if (objectRef.element != 0 && z2 && (screenStackFragmentWrapper = this.topScreenWrapper) != null && screenStackFragmentWrapper.isTranslucent() && !((ScreenFragmentWrapper) objectRef.element).isTranslucent() && (iCount = SequencesKt.count(SequencesKt.takeWhile(CollectionsKt.asSequence(CollectionsKt.asReversedMutable(this.stack)), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$7(objectRef, (ScreenStackFragmentWrapper) obj));
            }
        }))) > 1) {
            this.childrenDrawingOrderStrategy = new ReverseFromIndex(Math.max((CollectionsKt.getLastIndex(this.stack) - iCount) + 1, 0));
        }
        FragmentTransaction fragmentTransactionCreateTransaction = createTransaction();
        if (stackAnimation != null) {
            FragmentTransactionKtKt.setTweenAnimations(fragmentTransactionCreateTransaction, stackAnimation, z);
        }
        Iterator it = SequencesKt.filter(CollectionsKt.asSequence(this.stack), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$18$lambda$8(this.f$0, (ScreenStackFragmentWrapper) obj));
            }
        }).iterator();
        while (it.hasNext()) {
            fragmentTransactionCreateTransaction.remove(((ScreenStackFragmentWrapper) it.next()).getFragment());
        }
        Iterator it2 = SequencesKt.filter(SequencesKt.takeWhile(CollectionsKt.asSequence(this.screenWrappers), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$18$lambda$10(objectRef2, (ScreenFragmentWrapper) obj));
            }
        }), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$18$lambda$11(objectRef, this, (ScreenFragmentWrapper) obj));
            }
        }).iterator();
        while (it2.hasNext()) {
            fragmentTransactionCreateTransaction.remove(((ScreenFragmentWrapper) it2.next()).getFragment());
        }
        T t4 = objectRef2.element;
        if (t4 != 0 && !((ScreenFragmentWrapper) t4).getFragment().isAdded()) {
            final ScreenFragmentWrapper screenFragmentWrapper2 = (ScreenFragmentWrapper) objectRef.element;
            Iterator it3 = SequencesKt.dropWhile(CollectionsKt.asSequence(this.screenWrappers), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(ScreenStack.onUpdate$lambda$18$lambda$13(objectRef2, (ScreenFragmentWrapper) obj));
                }
            }).iterator();
            while (it3.hasNext()) {
                fragmentTransactionCreateTransaction.add(getId(), ((ScreenFragmentWrapper) it3.next()).getFragment()).runOnCommit(new Runnable() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScreenStack.onUpdate$lambda$18$lambda$15$lambda$14(screenFragmentWrapper2);
                    }
                });
            }
        } else {
            T t5 = objectRef.element;
            if (t5 != 0 && !((ScreenFragmentWrapper) t5).getFragment().isAdded()) {
                if (SheetUtilsKt.requiresEnterTransitionPostponing(((ScreenFragmentWrapper) objectRef.element).getScreen())) {
                    ((ScreenFragmentWrapper) objectRef.element).getFragment().postponeEnterTransition();
                }
                fragmentTransactionCreateTransaction.add(getId(), ((ScreenFragmentWrapper) objectRef.element).getFragment());
            }
        }
        T t6 = objectRef.element;
        this.topScreenWrapper = t6 instanceof ScreenStackFragmentWrapper ? (ScreenStackFragmentWrapper) t6 : null;
        this.stack.clear();
        CollectionsKt.addAll(this.stack, SequencesKt.map(CollectionsKt.asSequence(this.screenWrappers), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScreenStack.onUpdate$lambda$18$lambda$16((ScreenFragmentWrapper) obj);
            }
        }));
        this.preloadedWrappers = SequencesKt.toList(SequencesKt.filter(CollectionsKt.asSequence(this.screenWrappers), new Function1() { // from class: com.swmansion.rnscreens.ScreenStack$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ScreenStack.onUpdate$lambda$18$lambda$17((ScreenFragmentWrapper) obj));
            }
        }));
        turnOffA11yUnderTransparentScreen((ScreenFragmentWrapper) objectRef2.element);
        fragmentTransactionCreateTransaction.commitNowAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$3(ScreenStack screenStack, ScreenFragmentWrapper it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (CollectionsKt.contains(screenStack.dismissedWrappers, it) || it.getScreen().getActivityState() == Screen.ActivityState.INACTIVE) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$4(ScreenFragmentWrapper it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.isTranslucent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$7(Ref.ObjectRef objectRef, ScreenStackFragmentWrapper it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it != objectRef.element && it.isTranslucent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$18$lambda$8(ScreenStack screenStack, ScreenStackFragmentWrapper wrapper) {
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        return !screenStack.screenWrappers.contains(wrapper) || screenStack.dismissedWrappers.contains(wrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$18$lambda$10(Ref.ObjectRef objectRef, ScreenFragmentWrapper it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it != objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$18$lambda$11(Ref.ObjectRef objectRef, ScreenStack screenStack, ScreenFragmentWrapper it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !(it == objectRef.element || CollectionsKt.contains(screenStack.dismissedWrappers, it)) || it.getScreen().getActivityState() == Screen.ActivityState.INACTIVE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$18$lambda$13(Ref.ObjectRef objectRef, ScreenFragmentWrapper it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it != objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onUpdate$lambda$18$lambda$15$lambda$14(ScreenFragmentWrapper screenFragmentWrapper) {
        Screen screen;
        if (screenFragmentWrapper == null || (screen = screenFragmentWrapper.getScreen()) == null) {
            return;
        }
        screen.bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScreenStackFragmentWrapper onUpdate$lambda$18$lambda$16(ScreenFragmentWrapper it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (ScreenStackFragmentWrapper) it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onUpdate$lambda$18$lambda$17(ScreenFragmentWrapper it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getScreen().getActivityState() == Screen.ActivityState.INACTIVE;
    }

    private final void turnOffA11yUnderTransparentScreen(ScreenFragmentWrapper visibleBottom) {
        ScreenStackFragmentWrapper screenStackFragmentWrapper;
        if (this.screenWrappers.size() > 1 && visibleBottom != null && (screenStackFragmentWrapper = this.topScreenWrapper) != null && screenStackFragmentWrapper.isTranslucent()) {
            ArrayList<ScreenFragmentWrapper> arrayList = this.screenWrappers;
            for (ScreenFragmentWrapper screenFragmentWrapper : CollectionsKt.asReversed(CollectionsKt.slice((List) arrayList, RangesKt.until(0, arrayList.size() - 1)))) {
                screenFragmentWrapper.getScreen().changeAccessibilityMode(4);
                if (Intrinsics.areEqual(screenFragmentWrapper, visibleBottom)) {
                    break;
                }
            }
        }
        Screen topScreen = getTopScreen();
        if (topScreen != null) {
            topScreen.changeAccessibilityMode(0);
        }
    }

    @Override // com.swmansion.rnscreens.ScreenContainer
    protected void notifyContainerUpdate() {
        Iterator<T> it = this.stack.iterator();
        while (it.hasNext()) {
            ((ScreenStackFragmentWrapper) it.next()).onContainerUpdate();
        }
    }

    private final void drawAndRelease() {
        List<DrawingOp> list = this.drawingOps;
        this.drawingOps = new ArrayList();
        for (DrawingOp drawingOp : list) {
            drawingOp.draw();
            this.drawingOpPool.add(drawingOp);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        ChildrenDrawingOrderStrategy childrenDrawingOrderStrategy = this.childrenDrawingOrderStrategy;
        if (childrenDrawingOrderStrategy != null) {
            childrenDrawingOrderStrategy.apply(this.drawingOps);
        }
        drawAndRelease();
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(@NotNull Canvas canvas, @NotNull View child, long drawingTime) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(child, "child");
        List<DrawingOp> list = this.drawingOps;
        DrawingOp drawingOpObtainDrawingOp = obtainDrawingOp();
        drawingOpObtainDrawingOp.setCanvas(canvas);
        drawingOpObtainDrawingOp.setChild(child);
        drawingOpObtainDrawingOp.setDrawingTime(drawingTime);
        list.add(drawingOpObtainDrawingOp);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performDraw(DrawingOp op) {
        Canvas canvas = op.getCanvas();
        Intrinsics.checkNotNull(canvas);
        super.drawChild(canvas, op.getChild(), op.getDrawingTime());
    }

    private final DrawingOp obtainDrawingOp() {
        if (this.drawingOpPool.isEmpty()) {
            return new DrawingOp();
        }
        List<DrawingOp> list = this.drawingOpPool;
        return list.remove(CollectionsKt.getLastIndex(list));
    }

    @Metadata(m1835d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, m1836d2 = {"Lcom/swmansion/rnscreens/ScreenStack$DrawingOp;", "", "<init>", "(Lcom/swmansion/rnscreens/ScreenStack;)V", "canvas", "Landroid/graphics/Canvas;", "getCanvas", "()Landroid/graphics/Canvas;", "setCanvas", "(Landroid/graphics/Canvas;)V", "child", "Landroid/view/View;", "getChild", "()Landroid/view/View;", "setChild", "(Landroid/view/View;)V", "drawingTime", "", "getDrawingTime", "()J", "setDrawingTime", "(J)V", "draw", "", "react-native-screens_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public final class DrawingOp {

        @Nullable
        private Canvas canvas;

        @Nullable
        private View child;
        private long drawingTime;

        public DrawingOp() {
        }

        @Nullable
        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final void setCanvas(@Nullable Canvas canvas) {
            this.canvas = canvas;
        }

        @Nullable
        public final View getChild() {
            return this.child;
        }

        public final void setChild(@Nullable View view) {
            this.child = view;
        }

        public final long getDrawingTime() {
            return this.drawingTime;
        }

        public final void setDrawingTime(long j) {
            this.drawingTime = j;
        }

        public final void draw() {
            ScreenStack.this.performDraw(this);
            this.canvas = null;
            this.child = null;
            this.drawingTime = 0L;
        }
    }

    @Metadata(m1835d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m1836d2 = {"Lcom/swmansion/rnscreens/ScreenStack$Companion;", "", "<init>", "()V", "TAG", "", "needsDrawReordering", "", "fragmentWrapper", "Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "resolvedStackAnimation", "Lcom/swmansion/rnscreens/Screen$StackAnimation;", "react-native-screens_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean needsDrawReordering(ScreenFragmentWrapper fragmentWrapper, Screen.StackAnimation resolvedStackAnimation) {
            if (resolvedStackAnimation == null) {
                resolvedStackAnimation = fragmentWrapper.getScreen().getStackAnimation();
            }
            return (Build.VERSION.SDK_INT >= 33 || resolvedStackAnimation == Screen.StackAnimation.SLIDE_FROM_BOTTOM || resolvedStackAnimation == Screen.StackAnimation.FADE_FROM_BOTTOM || resolvedStackAnimation == Screen.StackAnimation.IOS_FROM_RIGHT || resolvedStackAnimation == Screen.StackAnimation.IOS_FROM_LEFT) && resolvedStackAnimation != Screen.StackAnimation.NONE;
        }
    }
}
