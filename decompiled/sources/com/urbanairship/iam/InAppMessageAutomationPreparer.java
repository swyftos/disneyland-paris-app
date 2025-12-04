package com.urbanairship.iam;

import android.content.Context;
import com.urbanairship.UALog;
import com.urbanairship.android.layout.util.UrlInfo;
import com.urbanairship.automation.engine.AutomationPreparerDelegate;
import com.urbanairship.automation.engine.PreparedScheduleInfo;
import com.urbanairship.iam.actions.InAppActionRunnerFactory;
import com.urbanairship.iam.adapter.CustomDisplayAdapter;
import com.urbanairship.iam.adapter.CustomDisplayAdapterType;
import com.urbanairship.iam.adapter.DisplayAdapterFactory;
import com.urbanairship.iam.analytics.InAppMessageAnalyticsFactory;
import com.urbanairship.iam.assets.AirshipCachedAssets;
import com.urbanairship.iam.assets.AssetCacheManager;
import com.urbanairship.iam.coordinator.DisplayCoordinatorManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J,\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\"2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'J4\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\"2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.J0\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u0002012 \u00102\u001a\u001c\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)\u0012\u0006\u0012\u0004\u0018\u00010503R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Lcom/urbanairship/iam/InAppMessageAutomationPreparer;", "Lcom/urbanairship/automation/engine/AutomationPreparerDelegate;", "Lcom/urbanairship/iam/InAppMessage;", "Lcom/urbanairship/iam/PreparedInAppMessageData;", "assetsManager", "Lcom/urbanairship/iam/assets/AssetCacheManager;", "displayCoordinatorManager", "Lcom/urbanairship/iam/coordinator/DisplayCoordinatorManager;", "displayAdapterFactory", "Lcom/urbanairship/iam/adapter/DisplayAdapterFactory;", "analyticsFactory", "Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsFactory;", "actionRunnerFactory", "Lcom/urbanairship/iam/actions/InAppActionRunnerFactory;", "(Lcom/urbanairship/iam/assets/AssetCacheManager;Lcom/urbanairship/iam/coordinator/DisplayCoordinatorManager;Lcom/urbanairship/iam/adapter/DisplayAdapterFactory;Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsFactory;Lcom/urbanairship/iam/actions/InAppActionRunnerFactory;)V", "value", "", "displayInterval", "getDisplayInterval", "()J", "setDisplayInterval", "(J)V", "Lcom/urbanairship/iam/InAppMessageContentExtender;", "messageContentExtender", "getMessageContentExtender", "()Lcom/urbanairship/iam/InAppMessageContentExtender;", "setMessageContentExtender", "(Lcom/urbanairship/iam/InAppMessageContentExtender;)V", "cancelled", "", "scheduleID", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepare", "Lkotlin/Result;", "data", "preparedScheduleInfo", "Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "prepare-0E7RQCE", "(Lcom/urbanairship/iam/InAppMessage;Lcom/urbanairship/automation/engine/PreparedScheduleInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareAssets", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "message", "skip", "", "prepareAssets-BWLJW6A", "(Lcom/urbanairship/iam/InAppMessage;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAdapterFactoryBlock", "type", "Lcom/urbanairship/iam/adapter/CustomDisplayAdapterType;", "factoryBlock", "Lkotlin/Function3;", "Landroid/content/Context;", "Lcom/urbanairship/iam/adapter/CustomDisplayAdapter;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInAppMessageAutomationPreparer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppMessageAutomationPreparer.kt\ncom/urbanairship/iam/InAppMessageAutomationPreparer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,103:1\n1#2:104\n1#2:115\n1603#3,9:105\n1855#3:114\n1856#3:116\n1612#3:117\n*S KotlinDebug\n*F\n+ 1 InAppMessageAutomationPreparer.kt\ncom/urbanairship/iam/InAppMessageAutomationPreparer\n*L\n91#1:115\n91#1:105,9\n91#1:114\n91#1:116\n91#1:117\n*E\n"})
/* loaded from: classes5.dex */
public final class InAppMessageAutomationPreparer implements AutomationPreparerDelegate<InAppMessage, PreparedInAppMessageData> {
    private final InAppActionRunnerFactory actionRunnerFactory;
    private final InAppMessageAnalyticsFactory analyticsFactory;
    private final AssetCacheManager assetsManager;
    private final DisplayAdapterFactory displayAdapterFactory;
    private final DisplayCoordinatorManager displayCoordinatorManager;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UrlInfo.UrlType.values().length];
            try {
                iArr[UrlInfo.UrlType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public InAppMessageAutomationPreparer(@NotNull AssetCacheManager assetsManager, @NotNull DisplayCoordinatorManager displayCoordinatorManager, @NotNull DisplayAdapterFactory displayAdapterFactory, @NotNull InAppMessageAnalyticsFactory analyticsFactory, @NotNull InAppActionRunnerFactory actionRunnerFactory) {
        Intrinsics.checkNotNullParameter(assetsManager, "assetsManager");
        Intrinsics.checkNotNullParameter(displayCoordinatorManager, "displayCoordinatorManager");
        Intrinsics.checkNotNullParameter(displayAdapterFactory, "displayAdapterFactory");
        Intrinsics.checkNotNullParameter(analyticsFactory, "analyticsFactory");
        Intrinsics.checkNotNullParameter(actionRunnerFactory, "actionRunnerFactory");
        this.assetsManager = assetsManager;
        this.displayCoordinatorManager = displayCoordinatorManager;
        this.displayAdapterFactory = displayAdapterFactory;
        this.analyticsFactory = analyticsFactory;
        this.actionRunnerFactory = actionRunnerFactory;
    }

    @Override // com.urbanairship.automation.engine.AutomationPreparerDelegate
    /* renamed from: prepare-0E7RQCE */
    public /* bridge */ /* synthetic */ Object mo2791prepare0E7RQCE(InAppMessage inAppMessage, PreparedScheduleInfo preparedScheduleInfo, Continuation<? super Result<? extends PreparedInAppMessageData>> continuation) {
        return m2875prepare0E7RQCE(inAppMessage, preparedScheduleInfo, (Continuation<? super Result<PreparedInAppMessageData>>) continuation);
    }

    public /* synthetic */ InAppMessageAutomationPreparer(AssetCacheManager assetCacheManager, DisplayCoordinatorManager displayCoordinatorManager, DisplayAdapterFactory displayAdapterFactory, InAppMessageAnalyticsFactory inAppMessageAnalyticsFactory, InAppActionRunnerFactory inAppActionRunnerFactory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(assetCacheManager, displayCoordinatorManager, displayAdapterFactory, inAppMessageAnalyticsFactory, (i & 16) != 0 ? new InAppActionRunnerFactory() : inAppActionRunnerFactory);
    }

    @Nullable
    public final InAppMessageContentExtender getMessageContentExtender() {
        InAppMessageContentExtender messageContentExtender;
        synchronized (this.displayAdapterFactory) {
            messageContentExtender = this.displayAdapterFactory.getMessageContentExtender();
        }
        return messageContentExtender;
    }

    public final void setMessageContentExtender(@Nullable InAppMessageContentExtender inAppMessageContentExtender) {
        synchronized (this.displayAdapterFactory) {
            this.displayAdapterFactory.setMessageContentExtender(inAppMessageContentExtender);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final long getDisplayInterval() {
        long displayInterval;
        synchronized (this.displayCoordinatorManager) {
            displayInterval = this.displayCoordinatorManager.getDisplayInterval();
        }
        return displayInterval;
    }

    public final void setDisplayInterval(long j) {
        synchronized (this.displayCoordinatorManager) {
            this.displayCoordinatorManager.setDisplayInterval(j);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: prepare-0E7RQCE, reason: avoid collision after fix types in other method and not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object m2875prepare0E7RQCE(@org.jetbrains.annotations.NotNull com.urbanairship.iam.InAppMessage r10, @org.jetbrains.annotations.NotNull final com.urbanairship.automation.engine.PreparedScheduleInfo r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<com.urbanairship.iam.PreparedInAppMessageData>> r12) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.InAppMessageAutomationPreparer.m2875prepare0E7RQCE(com.urbanairship.iam.InAppMessage, com.urbanairship.automation.engine.PreparedScheduleInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.urbanairship.automation.engine.AutomationPreparerDelegate
    @Nullable
    public Object cancelled(@NotNull final String str, @NotNull Continuation<? super Unit> continuation) {
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.iam.InAppMessageAutomationPreparer.cancelled.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Execution cancelled " + str;
            }
        }, 1, null);
        Object objClearCache = this.assetsManager.clearCache(str, continuation);
        return objClearCache == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objClearCache : Unit.INSTANCE;
    }

    public final void setAdapterFactoryBlock(@NotNull CustomDisplayAdapterType type, @NotNull Function3<? super Context, ? super InAppMessage, ? super AirshipCachedAssets, ? extends CustomDisplayAdapter> factoryBlock) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(factoryBlock, "factoryBlock");
        this.displayAdapterFactory.setAdapterFactoryBlock(type, factoryBlock);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: prepareAssets-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2874prepareAssetsBWLJW6A(com.urbanairship.iam.InAppMessage r8, final java.lang.String r9, boolean r10, kotlin.coroutines.Continuation r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.urbanairship.iam.InAppMessageAutomationPreparer$prepareAssets$1
            if (r0 == 0) goto L13
            r0 = r11
            com.urbanairship.iam.InAppMessageAutomationPreparer$prepareAssets$1 r0 = (com.urbanairship.iam.InAppMessageAutomationPreparer$prepareAssets$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.iam.InAppMessageAutomationPreparer$prepareAssets$1 r0 = new com.urbanairship.iam.InAppMessageAutomationPreparer$prepareAssets$1
            r0.<init>(r7, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.Result r11 = (kotlin.Result) r11
            java.lang.Object r7 = r11.getValue()
            goto L9e
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.Result r11 = (kotlin.Result) r11
            java.lang.Object r7 = r11.getValue()
            goto L58
        L44:
            kotlin.ResultKt.throwOnFailure(r11)
            if (r10 == 0) goto L59
            com.urbanairship.iam.assets.AssetCacheManager r7 = r7.assetsManager
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
            r0.label = r4
            java.lang.Object r7 = r7.m2891cacheAsset0E7RQCE(r9, r8, r0)
            if (r7 != r1) goto L58
            return r1
        L58:
            return r7
        L59:
            java.util.List r8 = com.urbanairship.iam.InAppMessageKt.getUrlInfos(r8)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Iterator r8 = r8.iterator()
        L66:
            boolean r11 = r8.hasNext()
            r2 = 0
            if (r11 == 0) goto L8b
            java.lang.Object r11 = r8.next()
            com.urbanairship.android.layout.util.UrlInfo r11 = (com.urbanairship.android.layout.util.UrlInfo) r11
            com.urbanairship.android.layout.util.UrlInfo$UrlType r5 = r11.getType()
            int[] r6 = com.urbanairship.iam.InAppMessageAutomationPreparer.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r5 = r6[r5]
            if (r5 != r4) goto L85
            java.lang.String r2 = r11.getUrl()
        L85:
            if (r2 == 0) goto L66
            r10.add(r2)
            goto L66
        L8b:
            com.urbanairship.iam.InAppMessageAutomationPreparer$prepareAssets$2 r8 = new com.urbanairship.iam.InAppMessageAutomationPreparer$prepareAssets$2
            r8.<init>()
            com.urbanairship.UALog.v$default(r2, r8, r4, r2)
            com.urbanairship.iam.assets.AssetCacheManager r7 = r7.assetsManager
            r0.label = r3
            java.lang.Object r7 = r7.m2891cacheAsset0E7RQCE(r9, r10, r0)
            if (r7 != r1) goto L9e
            return r1
        L9e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.InAppMessageAutomationPreparer.m2874prepareAssetsBWLJW6A(com.urbanairship.iam.InAppMessage, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
