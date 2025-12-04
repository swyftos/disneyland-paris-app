package com.urbanairship.iam.adapter;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.MainThread;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Predicate;
import com.urbanairship.android.layout.util.UrlInfo;
import com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001aB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/iam/adapter/DelegatingDisplayAdapter;", "Lcom/urbanairship/iam/adapter/DisplayAdapter;", "message", "Lcom/urbanairship/iam/InAppMessage;", "assets", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "delegate", "Lcom/urbanairship/iam/adapter/DelegatingDisplayAdapter$Delegate;", "networkMonitor", "Lcom/urbanairship/automation/utils/NetworkMonitor;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "(Lcom/urbanairship/iam/InAppMessage;Lcom/urbanairship/iam/assets/AirshipCachedAssets;Lcom/urbanairship/iam/adapter/DelegatingDisplayAdapter$Delegate;Lcom/urbanairship/automation/utils/NetworkMonitor;Lcom/urbanairship/app/ActivityMonitor;)V", "getDelegate", "()Lcom/urbanairship/iam/adapter/DelegatingDisplayAdapter$Delegate;", "isReady", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "display", "Lcom/urbanairship/iam/adapter/DisplayResult;", "context", "Landroid/content/Context;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "(Landroid/content/Context;Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Delegate", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDelegatingDisplayAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DelegatingDisplayAdapter.kt\ncom/urbanairship/iam/adapter/DelegatingDisplayAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,63:1\n1747#2,3:64\n*S KotlinDebug\n*F\n+ 1 DelegatingDisplayAdapter.kt\ncom/urbanairship/iam/adapter/DelegatingDisplayAdapter\n*L\n39#1:64,3\n*E\n"})
/* loaded from: classes5.dex */
public final class DelegatingDisplayAdapter implements DisplayAdapter {
    private final Delegate delegate;
    private final StateFlow isReady;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH§@¢\u0006\u0002\u0010\rR\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/iam/adapter/DelegatingDisplayAdapter$Delegate;", "", "activityPredicate", "Lcom/urbanairship/Predicate;", "Landroid/app/Activity;", "getActivityPredicate", "()Lcom/urbanairship/Predicate;", "display", "Lcom/urbanairship/iam/adapter/DisplayResult;", "context", "Landroid/content/Context;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "(Landroid/content/Context;Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Delegate {
        @MainThread
        @Nullable
        Object display(@NotNull Context context, @NotNull InAppMessageAnalyticsInterface inAppMessageAnalyticsInterface, @NotNull Continuation<? super DisplayResult> continuation);

        @Nullable
        Predicate<Activity> getActivityPredicate();
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UrlInfo.UrlType.values().length];
            try {
                iArr[UrlInfo.UrlType.WEB_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UrlInfo.UrlType.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UrlInfo.UrlType.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DelegatingDisplayAdapter(@org.jetbrains.annotations.NotNull com.urbanairship.iam.InAppMessage r6, @org.jetbrains.annotations.NotNull com.urbanairship.iam.assets.AirshipCachedAssets r7, @org.jetbrains.annotations.NotNull com.urbanairship.iam.adapter.DelegatingDisplayAdapter.Delegate r8, @org.jetbrains.annotations.NotNull final com.urbanairship.automation.utils.NetworkMonitor r9, @org.jetbrains.annotations.NotNull final com.urbanairship.app.ActivityMonitor r10) {
        /*
            r5 = this;
            java.lang.String r0 = "message"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "assets"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "delegate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "networkMonitor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "activityMonitor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r5.<init>()
            r5.delegate = r8
            java.util.List r6 = com.urbanairship.iam.InAppMessageKt.getUrlInfos(r6)
            r8 = 0
            if (r6 == 0) goto L2c
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L2c
            goto L93
        L2c:
            java.util.Iterator r6 = r6.iterator()
        L30:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L93
            java.lang.Object r0 = r6.next()
            com.urbanairship.android.layout.util.UrlInfo r0 = (com.urbanairship.android.layout.util.UrlInfo) r0
            com.urbanairship.android.layout.util.UrlInfo$UrlType r1 = r0.getType()
            int[] r2 = com.urbanairship.iam.adapter.DelegatingDisplayAdapter.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
            java.lang.String r2 = "getRequiresNetwork(...)"
            r3 = 1
            if (r1 == r3) goto L85
            r4 = 2
            if (r1 == r4) goto L65
            r4 = 3
            if (r1 != r4) goto L5f
            java.lang.Boolean r0 = r0.getRequiresNetwork()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            boolean r0 = r0.booleanValue()
            goto L90
        L5f:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L65:
            java.lang.Boolean r1 = r0.getRequiresNetwork()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L83
            java.lang.String r0 = r0.getUrl()
            java.lang.String r1 = "getUrl(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r0 = r7.isCached(r0)
            if (r0 != 0) goto L83
            r0 = r3
            goto L90
        L83:
            r0 = r8
            goto L90
        L85:
            java.lang.Boolean r0 = r0.getRequiresNetwork()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            boolean r0 = r0.booleanValue()
        L90:
            if (r0 == 0) goto L30
            r8 = r3
        L93:
            com.urbanairship.util.DerivedStateFlow r6 = new com.urbanairship.util.DerivedStateFlow
            com.urbanairship.iam.adapter.DelegatingDisplayAdapter$1 r7 = new com.urbanairship.iam.adapter.DelegatingDisplayAdapter$1
            r7.<init>()
            kotlinx.coroutines.flow.StateFlow r9 = r9.isConnected()
            com.urbanairship.iam.adapter.DelegatingDisplayAdapter$Delegate r0 = r5.delegate
            com.urbanairship.Predicate r0 = r0.getActivityPredicate()
            kotlinx.coroutines.flow.Flow r10 = com.urbanairship.iam.InAppActivityMonitorKt.resumedActivitiesUpdates(r10, r0)
            com.urbanairship.iam.adapter.DelegatingDisplayAdapter$2 r0 = new com.urbanairship.iam.adapter.DelegatingDisplayAdapter$2
            r1 = 0
            r0.<init>(r8, r1)
            kotlinx.coroutines.flow.Flow r8 = kotlinx.coroutines.flow.FlowKt.combine(r9, r10, r0)
            r6.<init>(r7, r8)
            r5.isReady = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.adapter.DelegatingDisplayAdapter.<init>(com.urbanairship.iam.InAppMessage, com.urbanairship.iam.assets.AirshipCachedAssets, com.urbanairship.iam.adapter.DelegatingDisplayAdapter$Delegate, com.urbanairship.automation.utils.NetworkMonitor, com.urbanairship.app.ActivityMonitor):void");
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    @Override // com.urbanairship.iam.adapter.DisplayAdapter
    @NotNull
    public StateFlow<Boolean> isReady() {
        return this.isReady;
    }

    /* renamed from: com.urbanairship.iam.adapter.DelegatingDisplayAdapter$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function3 {
        final /* synthetic */ boolean $needsNetwork;
        /* synthetic */ boolean Z$0;
        /* synthetic */ boolean Z$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(boolean z, Continuation continuation) {
            super(3, continuation);
            this.$needsNetwork = z;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Continuation) obj3);
        }

        public final Object invoke(boolean z, boolean z2, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$needsNetwork, continuation);
            anonymousClass2.Z$0 = z;
            anonymousClass2.Z$1 = z2;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean((!this.$needsNetwork || this.Z$0) && this.Z$1);
        }
    }

    @Override // com.urbanairship.iam.adapter.DisplayAdapter
    @Nullable
    public Object display(@NotNull Context context, @NotNull InAppMessageAnalyticsInterface inAppMessageAnalyticsInterface, @NotNull Continuation<? super DisplayResult> continuation) {
        return this.delegate.display(context, inAppMessageAnalyticsInterface, continuation);
    }
}
