package com.urbanairship.iam.adapter.modal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Predicate;
import com.urbanairship.actions.ActionRunner;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.iam.InAppMessageActivity;
import com.urbanairship.iam.adapter.DelegatingDisplayAdapter;
import com.urbanairship.iam.adapter.DisplayResult;
import com.urbanairship.iam.adapter.InAppDisplayArgs;
import com.urbanairship.iam.adapter.InAppDisplayArgsLoader;
import com.urbanairship.iam.adapter.InAppMessageDisplayListener;
import com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface;
import com.urbanairship.iam.assets.AirshipCachedAssets;
import com.urbanairship.iam.content.InAppMessageDisplayContent;
import com.urbanairship.util.timer.ActiveTimer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/iam/adapter/modal/ModalDisplayDelegate;", "Lcom/urbanairship/iam/adapter/DelegatingDisplayAdapter$Delegate;", "displayContent", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$ModalContent;", "assets", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "actionRunner", "Lcom/urbanairship/actions/ActionRunner;", "(Lcom/urbanairship/iam/content/InAppMessageDisplayContent$ModalContent;Lcom/urbanairship/iam/assets/AirshipCachedAssets;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/actions/ActionRunner;)V", "activityPredicate", "Lcom/urbanairship/Predicate;", "Landroid/app/Activity;", "getActivityPredicate", "()Lcom/urbanairship/Predicate;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Lcom/urbanairship/iam/adapter/DisplayResult;", "display", "context", "Landroid/content/Context;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "(Landroid/content/Context;Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModalDisplayDelegate implements DelegatingDisplayAdapter.Delegate {
    private final ActionRunner actionRunner;
    private final ActivityMonitor activityMonitor;
    private final Predicate activityPredicate;
    private final AirshipCachedAssets assets;
    private CancellableContinuation continuation;
    private final InAppMessageDisplayContent.ModalContent displayContent;

    public ModalDisplayDelegate(@NotNull InAppMessageDisplayContent.ModalContent displayContent, @Nullable AirshipCachedAssets airshipCachedAssets, @NotNull ActivityMonitor activityMonitor, @NotNull ActionRunner actionRunner) {
        Intrinsics.checkNotNullParameter(displayContent, "displayContent");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
        this.displayContent = displayContent;
        this.assets = airshipCachedAssets;
        this.activityMonitor = activityMonitor;
        this.actionRunner = actionRunner;
    }

    @Override // com.urbanairship.iam.adapter.DelegatingDisplayAdapter.Delegate
    @Nullable
    public Predicate<Activity> getActivityPredicate() {
        return this.activityPredicate;
    }

    @Override // com.urbanairship.iam.adapter.DelegatingDisplayAdapter.Delegate
    @Nullable
    public Object display(@NotNull Context context, @NotNull InAppMessageAnalyticsInterface inAppMessageAnalyticsInterface, @NotNull Continuation<? super DisplayResult> continuation) {
        Intent intentPutExtra = new Intent(context, (Class<?>) ModalActivity.class).setFlags(268435456).putExtra(InAppMessageActivity.EXTRA_DISPLAY_ARGS_LOADER, InAppDisplayArgsLoader.INSTANCE.newLoader(new InAppDisplayArgs(this.displayContent, this.assets, new InAppMessageDisplayListener(inAppMessageAnalyticsInterface, new ActiveTimer(this.activityMonitor, null, 2, null), new Function1() { // from class: com.urbanairship.iam.adapter.modal.ModalDisplayDelegate$display$displayListener$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DisplayResult) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(DisplayResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuation cancellableContinuation = this.this$0.continuation;
                if (cancellableContinuation != null) {
                    cancellableContinuation.resumeWith(Result.m2968constructorimpl(it));
                }
            }
        }), null, this.actionRunner, 8, null)));
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        return BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(context, intentPutExtra, null), continuation);
    }

    /* renamed from: com.urbanairship.iam.adapter.modal.ModalDisplayDelegate$display$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ Context $context;
        final /* synthetic */ Intent $intent;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, Intent intent, Continuation continuation) {
            super(2, continuation);
            this.$context = context;
            this.$intent = intent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ModalDisplayDelegate.this.new AnonymousClass2(this.$context, this.$intent, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ModalDisplayDelegate modalDisplayDelegate = ModalDisplayDelegate.this;
                Context context = this.$context;
                Intent intent = this.$intent;
                this.L$0 = modalDisplayDelegate;
                this.L$1 = context;
                this.L$2 = intent;
                this.label = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
                cancellableContinuationImpl.initCancellability();
                modalDisplayDelegate.continuation = cancellableContinuationImpl;
                context.startActivity(intent);
                obj = cancellableContinuationImpl.getResult();
                if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }
}
