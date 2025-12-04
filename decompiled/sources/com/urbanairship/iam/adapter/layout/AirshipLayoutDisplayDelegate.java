package com.urbanairship.iam.adapter.layout;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Size;
import com.google.firebase.messaging.Constants;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Predicate;
import com.urbanairship.android.layout.Thomas;
import com.urbanairship.android.layout.display.DisplayException;
import com.urbanairship.android.layout.display.DisplayRequest;
import com.urbanairship.android.layout.util.CachedImage;
import com.urbanairship.android.layout.util.Factory;
import com.urbanairship.android.layout.util.ImageCache;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.embedded.EmbeddedViewManager;
import com.urbanairship.iam.InAppMessageWebViewClient;
import com.urbanairship.iam.actions.InAppActionRunner;
import com.urbanairship.iam.adapter.DelegatingDisplayAdapter;
import com.urbanairship.iam.adapter.DisplayResult;
import com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface;
import com.urbanairship.iam.assets.AirshipCachedAssets;
import com.urbanairship.iam.content.InAppMessageDisplayContent;
import com.urbanairship.javascript.NativeBridge;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.webkit.AirshipWebViewClient;
import java.net.MalformedURLException;
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

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/iam/adapter/layout/AirshipLayoutDisplayDelegate;", "Lcom/urbanairship/iam/adapter/DelegatingDisplayAdapter$Delegate;", "displayContent", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$AirshipLayoutContent;", "assets", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", Constants.FirelogAnalytics.PARAM_PRIORITY, "", "messageExtras", "Lcom/urbanairship/json/JsonMap;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "actionRunner", "Lcom/urbanairship/iam/actions/InAppActionRunner;", "(Lcom/urbanairship/iam/content/InAppMessageDisplayContent$AirshipLayoutContent;Lcom/urbanairship/iam/assets/AirshipCachedAssets;ILcom/urbanairship/json/JsonMap;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/iam/actions/InAppActionRunner;)V", "activityPredicate", "Lcom/urbanairship/Predicate;", "Landroid/app/Activity;", "getActivityPredicate", "()Lcom/urbanairship/Predicate;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Lcom/urbanairship/iam/adapter/DisplayResult;", "display", "context", "Landroid/content/Context;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "(Landroid/content/Context;Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AirshipLayoutDisplayDelegate implements DelegatingDisplayAdapter.Delegate {
    private final InAppActionRunner actionRunner;
    private final ActivityMonitor activityMonitor;
    private final Predicate activityPredicate;
    private final AirshipCachedAssets assets;
    private CancellableContinuation continuation;
    private final InAppMessageDisplayContent.AirshipLayoutContent displayContent;
    private final JsonMap messageExtras;
    private final int priority;

    public AirshipLayoutDisplayDelegate(@NotNull InAppMessageDisplayContent.AirshipLayoutContent displayContent, @Nullable AirshipCachedAssets airshipCachedAssets, int i, @Nullable JsonMap jsonMap, @NotNull ActivityMonitor activityMonitor, @NotNull InAppActionRunner actionRunner) {
        Intrinsics.checkNotNullParameter(displayContent, "displayContent");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
        this.displayContent = displayContent;
        this.assets = airshipCachedAssets;
        this.priority = i;
        this.messageExtras = jsonMap;
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
    public Object display(@NotNull Context context, @NotNull InAppMessageAnalyticsInterface inAppMessageAnalyticsInterface, @NotNull Continuation<? super DisplayResult> continuation) throws MalformedURLException, DisplayException {
        LayoutListener layoutListener = new LayoutListener(inAppMessageAnalyticsInterface, new Function1() { // from class: com.urbanairship.iam.adapter.layout.AirshipLayoutDisplayDelegate$display$displayListener$1
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
        });
        JsonMap jsonMapEmptyJsonMap = this.messageExtras;
        if (jsonMapEmptyJsonMap == null) {
            jsonMapEmptyJsonMap = JsonExtensionsKt.emptyJsonMap();
        }
        JsonMap jsonMap = jsonMapEmptyJsonMap;
        Thomas thomas = Thomas.INSTANCE;
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new AnonymousClass2(Thomas.prepareDisplay(this.displayContent.getLayout().getLayoutInfo(), this.priority, jsonMap, this.activityMonitor, layoutListener, this.actionRunner, new ImageCache() { // from class: com.urbanairship.iam.adapter.layout.AirshipLayoutDisplayDelegate$$ExternalSyntheticLambda1
            @Override // com.urbanairship.android.layout.util.ImageCache
            public final CachedImage get(String str) {
                return AirshipLayoutDisplayDelegate.display$lambda$2(this.f$0, str);
            }
        }, new Factory() { // from class: com.urbanairship.iam.adapter.layout.AirshipLayoutDisplayDelegate$$ExternalSyntheticLambda0
            @Override // com.urbanairship.android.layout.util.Factory
            public final Object create() {
                return AirshipLayoutDisplayDelegate.display$lambda$0(this.f$0);
            }
        }, EmbeddedViewManager.INSTANCE), context, layoutListener, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AirshipWebViewClient display$lambda$0(AirshipLayoutDisplayDelegate this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return new InAppMessageWebViewClient(new NativeBridge(this$0.actionRunner), this$0.messageExtras);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CachedImage display$lambda$2(AirshipLayoutDisplayDelegate this$0, String url) {
        Uri uriCacheUri;
        String path;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "url");
        AirshipCachedAssets airshipCachedAssets = this$0.assets;
        Size size = null;
        if (airshipCachedAssets == null || (uriCacheUri = airshipCachedAssets.cacheUri(url)) == null || (path = uriCacheUri.getPath()) == null) {
            return null;
        }
        Size mediaSize = this$0.assets.getMediaSize(url);
        if (mediaSize.getWidth() > 0 && mediaSize.getHeight() > 0) {
            size = mediaSize;
        }
        return new CachedImage(path, size);
    }

    /* renamed from: com.urbanairship.iam.adapter.layout.AirshipLayoutDisplayDelegate$display$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ Context $context;
        final /* synthetic */ LayoutListener $displayListener;
        final /* synthetic */ DisplayRequest $request;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DisplayRequest displayRequest, Context context, LayoutListener layoutListener, Continuation continuation) {
            super(2, continuation);
            this.$request = displayRequest;
            this.$context = context;
            this.$displayListener = layoutListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AirshipLayoutDisplayDelegate.this.new AnonymousClass2(this.$request, this.$context, this.$displayListener, continuation);
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
                AirshipLayoutDisplayDelegate airshipLayoutDisplayDelegate = AirshipLayoutDisplayDelegate.this;
                DisplayRequest displayRequest = this.$request;
                Context context = this.$context;
                LayoutListener layoutListener = this.$displayListener;
                this.L$0 = airshipLayoutDisplayDelegate;
                this.L$1 = displayRequest;
                this.L$2 = context;
                this.L$3 = layoutListener;
                this.label = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
                cancellableContinuationImpl.initCancellability();
                airshipLayoutDisplayDelegate.continuation = cancellableContinuationImpl;
                displayRequest.display(context);
                layoutListener.onVisibilityChanged(true, airshipLayoutDisplayDelegate.activityMonitor.getIsAppForegrounded());
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
