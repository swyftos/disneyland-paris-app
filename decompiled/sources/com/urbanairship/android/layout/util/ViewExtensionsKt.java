package com.urbanairship.android.layout.util;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.net.MailTo;
import androidx.core.text.TextUtilsCompat;
import androidx.core.text.method.LinkMovementMethodCompat;
import androidx.core.view.ViewGroupKt;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.UAirship;
import com.urbanairship.android.layout.gestures.PagerGestureEvent;
import com.urbanairship.android.layout.util.ViewExtensionsKt;
import com.urbanairship.android.layout.view.PagerView;
import com.urbanairship.android.layout.view.ScoreView;
import com.urbanairship.android.layout.widget.CheckableView;
import com.urbanairship.android.layout.widget.CheckableViewAdapter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\b\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012*\u0006\u0012\u0002\b\u00030\u0013H\u0000\u001a%\u0010\u0014\u001a\u00020\u0010*\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012*\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0000\u001a*\u0010\u001d\u001a\u0004\u0018\u00010\t*\u00020\u00052\u0006\u0010\u001e\u001a\u00020\t2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040 H\u0000\u001aP\u0010!\u001a\u00020\u0010*\u00020\u00152\u0006\u0010\"\u001a\u00020\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020$0 H\u0002¢\u0006\u0002\u0010(\u001a%\u0010)\u001a\u00020\u0010*\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u0019\u001a&\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012*\u00020+2\b\b\u0002\u0010,\u001a\u00020-H\u0000ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a\u0012\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0012*\u000202H\u0000\u001a\u0012\u00103\u001a\b\u0012\u0004\u0012\u0002040\u0012*\u000202H\u0000\u001a\u0012\u00105\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012*\u000206H\u0000\u001a1\u00107\u001a\u00020\u0010*\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\b\u0002\u0010\u0016\u001a\u00020\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0002\u0010;\u001a&\u0010<\u001a\b\u0012\u0004\u0012\u00020$0\u0012*\u00020+2\b\b\u0002\u0010=\u001a\u00020-H\u0000ø\u0001\u0000¢\u0006\u0004\b>\u0010/\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006\"\u0018\u0010\b\u001a\u00020\u0004*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006?"}, d2 = {"emailPattern", "Lkotlin/text/Regex;", "urlPattern", "isActionDown", "", "Landroid/view/MotionEvent;", "(Landroid/view/MotionEvent;)Z", "isActionUp", "isLayoutRtl", "Landroid/view/View;", "(Landroid/view/View;)Z", "localBounds", "Landroid/graphics/RectF;", "getLocalBounds", "(Landroid/view/View;)Landroid/graphics/RectF;", "checkMainThread", "", "checkedChanges", "Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/android/layout/widget/CheckableView;", "convertUrlSpans", "Landroid/text/Spannable;", "underline", "color", "", "(Landroid/text/Spannable;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "debouncedClicks", "debounceMillis", "", "findTargetDescendant", "view", ViewProps.FILTER, "Lkotlin/Function1;", "forEachMatching", "regex", "linkFactory", "", "Lkotlin/ParameterName;", "name", "url", "(Landroid/text/Spannable;Lkotlin/text/Regex;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "linkifyText", "onEditing", "Landroid/widget/EditText;", "idleDelay", "Lkotlin/time/Duration;", "onEditing-HG0u8IE", "(Landroid/widget/EditText;J)Lkotlinx/coroutines/flow/Flow;", "pagerGestures", "Lcom/urbanairship/android/layout/gestures/PagerGestureEvent;", "Lcom/urbanairship/android/layout/view/PagerView;", "pagerScrolls", "Lcom/urbanairship/android/layout/util/PagerScrollEvent;", "scoreChanges", "Lcom/urbanairship/android/layout/view/ScoreView;", "setHtml", "Landroid/widget/TextView;", "html", "Landroid/text/Spanned;", "(Landroid/widget/TextView;Landroid/text/Spanned;ZLjava/lang/Integer;)V", "textChanges", "debounceDuration", "textChanges-HG0u8IE", "urbanairship-layout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewExtensions.kt\ncom/urbanairship/android/layout/util/ViewExtensionsKt\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 SpannableString.kt\nandroidx/core/text/SpannableStringKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n614#2:311\n179#2,2:312\n1313#2,2:318\n29#3:314\n26#4:315\n13309#5,2:316\n1#6:320\n*S KotlinDebug\n*F\n+ 1 ViewExtensions.kt\ncom/urbanairship/android/layout/util/ViewExtensionsKt\n*L\n223#1:311\n224#1:312,2\n275#1:318,2\n244#1:314\n253#1:315\n254#1:316,2\n*E\n"})
/* loaded from: classes5.dex */
public final class ViewExtensionsKt {
    private static final Regex emailPattern;
    private static final Regex urlPattern;

    /* renamed from: textChanges-HG0u8IE$default, reason: not valid java name */
    public static /* synthetic */ Flow m2745textChangesHG0u8IE$default(EditText editText, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            j = DurationKt.toDuration(0.1d, DurationUnit.SECONDS);
        }
        return m2744textChangesHG0u8IE(editText, j);
    }

    @NotNull
    /* renamed from: textChanges-HG0u8IE, reason: not valid java name */
    public static final Flow<String> m2744textChangesHG0u8IE(@NotNull EditText textChanges, long j) {
        Intrinsics.checkNotNullParameter(textChanges, "$this$textChanges");
        return FlowKt.conflate(FlowKt.m3657debounceHG0u8IE(FlowKt.distinctUntilChanged(FlowKt.onStart(FlowKt.callbackFlow(new ViewExtensionsKt$textChanges$1(textChanges, null)), new ViewExtensionsKt$textChanges$2(textChanges, null))), j));
    }

    /* renamed from: onEditing-HG0u8IE$default, reason: not valid java name */
    public static /* synthetic */ Flow m2743onEditingHG0u8IE$default(EditText editText, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            j = DurationKt.toDuration(1, DurationUnit.SECONDS);
        }
        return m2742onEditingHG0u8IE(editText, j);
    }

    @NotNull
    /* renamed from: onEditing-HG0u8IE, reason: not valid java name */
    public static final Flow<Boolean> m2742onEditingHG0u8IE(@NotNull EditText onEditing, long j) {
        Intrinsics.checkNotNullParameter(onEditing, "$this$onEditing");
        return FlowKt.conflate(FlowKt.distinctUntilChanged(FlowKt.onStart(FlowKt.callbackFlow(new ViewExtensionsKt$onEditing$1(onEditing, j, null)), new ViewExtensionsKt$onEditing$2(null))));
    }

    /* renamed from: com.urbanairship.android.layout.util.ViewExtensionsKt$debouncedClicks$1, reason: invalid class name and case insensitive filesystem */
    static final class C09621 extends SuspendLambda implements Function2 {
        final /* synthetic */ View $this_debouncedClicks;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09621(View view, Continuation continuation) {
            super(2, continuation);
            this.$this_debouncedClicks = view;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C09621 c09621 = new C09621(this.$this_debouncedClicks, continuation);
            c09621.L$0 = obj;
            return c09621;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope producerScope, Continuation continuation) {
            return ((C09621) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                ViewExtensionsKt.checkMainThread();
                InstrumentationCallbacks.setOnClickListenerCalled(this.$this_debouncedClicks, new View.OnClickListener() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt$debouncedClicks$1$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ViewExtensionsKt.C09621.invokeSuspend$lambda$0(producerScope, view);
                    }
                });
                final View view = this.$this_debouncedClicks;
                Function0 function0 = new Function0() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt.debouncedClicks.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2747invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2747invoke() {
                        InstrumentationCallbacks.setOnClickListenerCalled(view, null);
                    }
                };
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(ProducerScope producerScope, View view) {
            producerScope.mo3620trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    public static /* synthetic */ Flow debouncedClicks$default(View view, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 100;
        }
        return debouncedClicks(view, j);
    }

    @NotNull
    public static final Flow<Unit> debouncedClicks(@NotNull View view, long j) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return FlowKt.conflate(FlowKt.debounce(FlowKt.callbackFlow(new C09621(view, null)), j));
    }

    /* renamed from: com.urbanairship.android.layout.util.ViewExtensionsKt$checkedChanges$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ CheckableView $this_checkedChanges;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CheckableView checkableView, Continuation continuation) {
            super(2, continuation);
            this.$this_checkedChanges = checkableView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_checkedChanges, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope producerScope, Continuation continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                ViewExtensionsKt.checkMainThread();
                this.$this_checkedChanges.setCheckedChangeListener(new CheckableViewAdapter.OnCheckedChangeListener() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt$checkedChanges$1$$ExternalSyntheticLambda0
                    @Override // com.urbanairship.android.layout.widget.CheckableViewAdapter.OnCheckedChangeListener
                    public final void onCheckedChange(View view, boolean z) {
                        ViewExtensionsKt.AnonymousClass1.invokeSuspend$lambda$0(producerScope, view, z);
                    }
                });
                final CheckableView checkableView = this.$this_checkedChanges;
                Function0 function0 = new Function0() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt.checkedChanges.1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2746invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2746invoke() {
                        checkableView.setCheckedChangeListener(null);
                    }
                };
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(ProducerScope producerScope, View view, boolean z) {
            producerScope.mo3620trySendJP2dKIU(Boolean.valueOf(z));
        }
    }

    @NotNull
    public static final Flow<Boolean> checkedChanges(@NotNull CheckableView<?> checkableView) {
        Intrinsics.checkNotNullParameter(checkableView, "<this>");
        return FlowKt.conflate(FlowKt.onStart(FlowKt.callbackFlow(new AnonymousClass1(checkableView, null)), new AnonymousClass2(checkableView, null)));
    }

    /* renamed from: com.urbanairship.android.layout.util.ViewExtensionsKt$checkedChanges$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ CheckableView $this_checkedChanges;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(CheckableView checkableView, Continuation continuation) {
            super(2, continuation);
            this.$this_checkedChanges = checkableView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_checkedChanges, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
            return ((AnonymousClass2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Boolean boolBoxBoolean = Boxing.boxBoolean(this.$this_checkedChanges.getCheckableView().isChecked());
                this.label = 1;
                if (flowCollector.emit(boolBoxBoolean, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.urbanairship.android.layout.util.ViewExtensionsKt$scoreChanges$1, reason: invalid class name and case insensitive filesystem */
    static final class C09661 extends SuspendLambda implements Function2 {
        final /* synthetic */ ScoreView $this_scoreChanges;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09661(ScoreView scoreView, Continuation continuation) {
            super(2, continuation);
            this.$this_scoreChanges = scoreView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C09661 c09661 = new C09661(this.$this_scoreChanges, continuation);
            c09661.L$0 = obj;
            return c09661;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope producerScope, Continuation continuation) {
            return ((C09661) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                ViewExtensionsKt.checkMainThread();
                this.$this_scoreChanges.setScoreSelectedListener(new ScoreView.OnScoreSelectedListener() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt$scoreChanges$1$$ExternalSyntheticLambda0
                    @Override // com.urbanairship.android.layout.view.ScoreView.OnScoreSelectedListener
                    public final void onScoreSelected(int i2) {
                        ViewExtensionsKt.C09661.invokeSuspend$lambda$0(producerScope, i2);
                    }
                });
                final ScoreView scoreView = this.$this_scoreChanges;
                Function0 function0 = new Function0() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt.scoreChanges.1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2752invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2752invoke() {
                        scoreView.setScoreSelectedListener(null);
                    }
                };
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(ProducerScope producerScope, int i) {
            producerScope.mo3620trySendJP2dKIU(Integer.valueOf(i));
        }
    }

    @NotNull
    public static final Flow<Integer> scoreChanges(@NotNull ScoreView scoreView) {
        Intrinsics.checkNotNullParameter(scoreView, "<this>");
        return FlowKt.conflate(FlowKt.callbackFlow(new C09661(scoreView, null)));
    }

    /* renamed from: com.urbanairship.android.layout.util.ViewExtensionsKt$pagerScrolls$1, reason: invalid class name and case insensitive filesystem */
    static final class C09651 extends SuspendLambda implements Function2 {
        final /* synthetic */ PagerView $this_pagerScrolls;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09651(PagerView pagerView, Continuation continuation) {
            super(2, continuation);
            this.$this_pagerScrolls = pagerView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C09651 c09651 = new C09651(this.$this_pagerScrolls, continuation);
            c09651.L$0 = obj;
            return c09651;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope producerScope, Continuation continuation) {
            return ((C09651) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                ViewExtensionsKt.checkMainThread();
                this.$this_pagerScrolls.setScrollListener(new PagerView.OnScrollListener() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt$pagerScrolls$1$$ExternalSyntheticLambda0
                    @Override // com.urbanairship.android.layout.view.PagerView.OnScrollListener
                    public final void onScrollTo(int i2, boolean z) {
                        ViewExtensionsKt.C09651.invokeSuspend$lambda$0(producerScope, i2, z);
                    }
                });
                final PagerView pagerView = this.$this_pagerScrolls;
                Function0 function0 = new Function0() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt.pagerScrolls.1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2751invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2751invoke() {
                        pagerView.setScrollListener(null);
                    }
                };
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(ProducerScope producerScope, int i, boolean z) {
            producerScope.mo3620trySendJP2dKIU(new PagerScrollEvent(i, z));
        }
    }

    @NotNull
    public static final Flow<PagerScrollEvent> pagerScrolls(@NotNull PagerView pagerView) {
        Intrinsics.checkNotNullParameter(pagerView, "<this>");
        return FlowKt.conflate(FlowKt.callbackFlow(new C09651(pagerView, null)));
    }

    /* renamed from: com.urbanairship.android.layout.util.ViewExtensionsKt$pagerGestures$1, reason: invalid class name and case insensitive filesystem */
    static final class C09641 extends SuspendLambda implements Function2 {
        final /* synthetic */ PagerView $this_pagerGestures;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09641(PagerView pagerView, Continuation continuation) {
            super(2, continuation);
            this.$this_pagerGestures = pagerView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C09641 c09641 = new C09641(this.$this_pagerGestures, continuation);
            c09641.L$0 = obj;
            return c09641;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope producerScope, Continuation continuation) {
            return ((C09641) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                ViewExtensionsKt.checkMainThread();
                this.$this_pagerGestures.setGestureListener(new PagerView.OnPagerGestureListener() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt$pagerGestures$1$listener$1
                    @Override // com.urbanairship.android.layout.view.PagerView.OnPagerGestureListener
                    public void onGesture(@NotNull PagerGestureEvent event) {
                        Intrinsics.checkNotNullParameter(event, "event");
                        producerScope.mo3620trySendJP2dKIU(event);
                    }
                });
                final PagerView pagerView = this.$this_pagerGestures;
                Function0 function0 = new Function0() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt.pagerGestures.1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2750invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2750invoke() {
                        pagerView.setGestureListener(null);
                    }
                };
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final Flow<PagerGestureEvent> pagerGestures(@NotNull PagerView pagerView) {
        Intrinsics.checkNotNullParameter(pagerView, "<this>");
        return FlowKt.conflate(FlowKt.callbackFlow(new C09641(pagerView, null)));
    }

    public static final boolean isActionUp(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "<this>");
        return (motionEvent.getAction() & 255) == 1;
    }

    public static final boolean isActionDown(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "<this>");
        return (motionEvent.getAction() & 255) == 0;
    }

    @NotNull
    public static final RectF getLocalBounds(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, view.getWidth(), view.getHeight());
    }

    public static final boolean isLayoutRtl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return TextUtilsCompat.getLayoutDirectionFromLocale(UAirship.shared().getLocale()) == 1;
    }

    private static final boolean findTargetDescendant$isTouchWithin(MotionEvent motionEvent, View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    @Nullable
    public static final View findTargetDescendant(@NotNull MotionEvent motionEvent, @NotNull View view, @NotNull final Function1<? super View, Boolean> filter) {
        Intrinsics.checkNotNullParameter(motionEvent, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(filter, "filter");
        Object obj = null;
        if (!(view instanceof ViewGroup)) {
            if (filter.invoke(view).booleanValue() && findTargetDescendant$isTouchWithin(motionEvent, view)) {
                return view;
            }
            return null;
        }
        Iterator it = SequencesKt.sortedWith(SequencesKt.filter(ViewGroupKt.getDescendants((ViewGroup) view), new Function1() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt.findTargetDescendant.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(View it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                return (Boolean) filter.invoke(it2);
            }
        }), new Comparator() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt$findTargetDescendant$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Float.valueOf(((View) t2).getZ()), Float.valueOf(((View) t).getZ()));
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (findTargetDescendant$isTouchWithin(motionEvent, (View) next)) {
                obj = next;
                break;
            }
        }
        return (View) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkMainThread() {
        if (!Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            throw new IllegalStateException("Must be called from main thread!");
        }
    }

    public static /* synthetic */ void setHtml$default(TextView textView, Spanned spanned, boolean z, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        setHtml(textView, spanned, z, num);
    }

    public static final void setHtml(@NotNull TextView textView, @Nullable Spanned spanned, boolean z, @Nullable Integer num) {
        SpannableString spannableStringValueOf;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setMovementMethod(LinkMovementMethodCompat.getInstance());
        if (spanned == null || spanned.length() == 0) {
            spannableStringValueOf = null;
        } else {
            spannableStringValueOf = SpannableString.valueOf(spanned);
            convertUrlSpans(spannableStringValueOf, Boolean.valueOf(z), num);
            linkifyText(spannableStringValueOf, Boolean.valueOf(z), num);
        }
        textView.setText(spannableStringValueOf);
    }

    private static final void convertUrlSpans(Spannable spannable, Boolean bool, Integer num) {
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        if (uRLSpanArr == null) {
            uRLSpanArr = new URLSpan[0];
        }
        for (URLSpan uRLSpan : uRLSpanArr) {
            String url = uRLSpan.getURL();
            Intrinsics.checkNotNullExpressionValue(url, "getURL(...)");
            spannable.setSpan(new LinkSpan(url, bool, num), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), spannable.getSpanFlags(uRLSpan));
            spannable.removeSpan(uRLSpan);
        }
    }

    private static final void linkifyText(Spannable spannable, Boolean bool, Integer num) {
        forEachMatching(spannable, emailPattern, bool, num, new Function1() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt$linkifyText$1$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String email) {
                Intrinsics.checkNotNullParameter(email, "email");
                return MailTo.MAILTO_SCHEME + email;
            }
        });
        forEachMatching(spannable, urlPattern, bool, num, new Function1() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt$linkifyText$1$2
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                if (StringsKt.startsWith$default(url, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(url, "https://", false, 2, (Object) null)) {
                    return url;
                }
                return "https://" + url;
            }
        });
    }

    private static final void forEachMatching(Spannable spannable, Regex regex, Boolean bool, Integer num, Function1 function1) {
        for (MatchResult matchResult : Regex.findAll$default(regex, spannable, 0, 2, null)) {
            int first = matchResult.getRange().getFirst();
            int last = matchResult.getRange().getLast() + 1;
            Object[] spans = spannable.getSpans(first, last, ClickableSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
            if (spans.length == 0) {
                spannable.setSpan(new LinkSpan((String) function1.invoke(StringsKt.trim(matchResult.getValue()).toString()), bool, num), first, last, 0);
            }
        }
    }

    static {
        Pattern EMAIL_ADDRESS = Patterns.EMAIL_ADDRESS;
        Intrinsics.checkNotNullExpressionValue(EMAIL_ADDRESS, "EMAIL_ADDRESS");
        emailPattern = new Regex(EMAIL_ADDRESS);
        Pattern WEB_URL = Patterns.WEB_URL;
        Intrinsics.checkNotNullExpressionValue(WEB_URL, "WEB_URL");
        urlPattern = new Regex(WEB_URL);
    }
}
