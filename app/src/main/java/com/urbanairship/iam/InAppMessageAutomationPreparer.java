package com.urbanairship.iam;

import android.content.Context;
import com.urbanairship.UALog;
import com.urbanairship.android.layout.util.UrlInfo;
import com.urbanairship.automation.engine.AutomationPreparerDelegate;
import com.urbanairship.automation.engine.PreparedScheduleInfo;
import com.urbanairship.experiment.ExperimentResult;
import com.urbanairship.iam.actions.InAppActionRunner;
import com.urbanairship.iam.actions.InAppActionRunnerFactory;
import com.urbanairship.iam.adapter.CustomDisplayAdapter;
import com.urbanairship.iam.adapter.CustomDisplayAdapterType;
import com.urbanairship.iam.adapter.DisplayAdapter;
import com.urbanairship.iam.adapter.DisplayAdapterFactory;
import com.urbanairship.iam.analytics.InAppMessageAnalyticsFactory;
import com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface;
import com.urbanairship.iam.assets.AirshipCachedAssets;
import com.urbanairship.iam.assets.AssetCacheManager;
import com.urbanairship.iam.coordinator.DisplayCoordinator;
import com.urbanairship.iam.coordinator.DisplayCoordinatorManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J,\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\"2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'J4\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\"2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.J0\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u0002012 \u00102\u001a\u001c\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)\u0012\u0006\u0012\u0004\u0018\u00010503R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00066"}, m1836d2 = {"Lcom/urbanairship/iam/InAppMessageAutomationPreparer;", "Lcom/urbanairship/automation/engine/AutomationPreparerDelegate;", "Lcom/urbanairship/iam/InAppMessage;", "Lcom/urbanairship/iam/PreparedInAppMessageData;", "assetsManager", "Lcom/urbanairship/iam/assets/AssetCacheManager;", "displayCoordinatorManager", "Lcom/urbanairship/iam/coordinator/DisplayCoordinatorManager;", "displayAdapterFactory", "Lcom/urbanairship/iam/adapter/DisplayAdapterFactory;", "analyticsFactory", "Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsFactory;", "actionRunnerFactory", "Lcom/urbanairship/iam/actions/InAppActionRunnerFactory;", "(Lcom/urbanairship/iam/assets/AssetCacheManager;Lcom/urbanairship/iam/coordinator/DisplayCoordinatorManager;Lcom/urbanairship/iam/adapter/DisplayAdapterFactory;Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsFactory;Lcom/urbanairship/iam/actions/InAppActionRunnerFactory;)V", "value", "", "displayInterval", "getDisplayInterval", "()J", "setDisplayInterval", "(J)V", "Lcom/urbanairship/iam/InAppMessageContentExtender;", "messageContentExtender", "getMessageContentExtender", "()Lcom/urbanairship/iam/InAppMessageContentExtender;", "setMessageContentExtender", "(Lcom/urbanairship/iam/InAppMessageContentExtender;)V", "cancelled", "", "scheduleID", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepare", "Lkotlin/Result;", "data", "preparedScheduleInfo", "Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "prepare-0E7RQCE", "(Lcom/urbanairship/iam/InAppMessage;Lcom/urbanairship/automation/engine/PreparedScheduleInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareAssets", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "message", "skip", "", "prepareAssets-BWLJW6A", "(Lcom/urbanairship/iam/InAppMessage;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAdapterFactoryBlock", "type", "Lcom/urbanairship/iam/adapter/CustomDisplayAdapterType;", "factoryBlock", "Lkotlin/Function3;", "Landroid/content/Context;", "Lcom/urbanairship/iam/adapter/CustomDisplayAdapter;", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nInAppMessageAutomationPreparer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppMessageAutomationPreparer.kt\ncom/urbanairship/iam/InAppMessageAutomationPreparer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,103:1\n1#2:104\n1#2:115\n1603#3,9:105\n1855#3:114\n1856#3:116\n1612#3:117\n*S KotlinDebug\n*F\n+ 1 InAppMessageAutomationPreparer.kt\ncom/urbanairship/iam/InAppMessageAutomationPreparer\n*L\n91#1:115\n91#1:105,9\n91#1:114\n91#1:116\n91#1:117\n*E\n"})
public final class InAppMessageAutomationPreparer implements AutomationPreparerDelegate<InAppMessage, PreparedInAppMessageData> {
    private final InAppActionRunnerFactory actionRunnerFactory;
    private final InAppMessageAnalyticsFactory analyticsFactory;
    private final AssetCacheManager assetsManager;
    private final DisplayAdapterFactory displayAdapterFactory;
    private final DisplayCoordinatorManager displayCoordinatorManager;

    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
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
    /* JADX INFO: renamed from: prepare-0E7RQCE */
    public /* bridge */ /* synthetic */ Object mo5033prepare0E7RQCE(InAppMessage inAppMessage, PreparedScheduleInfo preparedScheduleInfo, Continuation<? super Result<? extends PreparedInAppMessageData>> continuation) {
        return m5117prepare0E7RQCE(inAppMessage, preparedScheduleInfo, (Continuation<? super Result<PreparedInAppMessageData>>) continuation);
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

    /* JADX WARN: Code duplicated, block: B:36:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:38:0x00de  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    /* JADX INFO: renamed from: prepare-0E7RQCE, reason: avoid collision after fix types in other method and not valid java name */
    public Object m5117prepare0E7RQCE(@NotNull InAppMessage inAppMessage, @NotNull final PreparedScheduleInfo preparedScheduleInfo, @NotNull Continuation<? super Result<PreparedInAppMessageData>> continuation) {
        InAppMessageAutomationPreparer$prepare$1 inAppMessageAutomationPreparer$prepare$1;
        Object objM5116prepareAssetsBWLJW6A;
        ExperimentResult experimentResult$urbanairship_automation_release;
        InAppMessage inAppMessage2;
        AirshipCachedAssets airshipCachedAssets;
        DisplayCoordinator displayCoordinator;
        InAppMessageAutomationPreparer inAppMessageAutomationPreparer;
        InAppMessageAnalyticsInterface inAppMessageAnalyticsInterface;
        InAppActionRunner inAppActionRunnerMakeRunner$urbanairship_automation_release;
        Object objM5118makeAdapterBWLJW6A;
        Throwable thM5280exceptionOrNullimpl;
        if (continuation instanceof InAppMessageAutomationPreparer$prepare$1) {
            inAppMessageAutomationPreparer$prepare$1 = (InAppMessageAutomationPreparer$prepare$1) continuation;
            int i = inAppMessageAutomationPreparer$prepare$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                inAppMessageAutomationPreparer$prepare$1.label = i - Integer.MIN_VALUE;
            } else {
                inAppMessageAutomationPreparer$prepare$1 = new InAppMessageAutomationPreparer$prepare$1(this, continuation);
            }
        } else {
            inAppMessageAutomationPreparer$prepare$1 = new InAppMessageAutomationPreparer$prepare$1(this, continuation);
        }
        Object obj = inAppMessageAutomationPreparer$prepare$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = inAppMessageAutomationPreparer$prepare$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                preparedScheduleInfo = (PreparedScheduleInfo) inAppMessageAutomationPreparer$prepare$1.L$2;
                inAppMessage = (InAppMessage) inAppMessageAutomationPreparer$prepare$1.L$1;
                this = (InAppMessageAutomationPreparer) inAppMessageAutomationPreparer$prepare$1.L$0;
                ResultKt.throwOnFailure(obj);
                objM5116prepareAssetsBWLJW6A = ((Result) obj).getValue();
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                DisplayCoordinator displayCoordinator2 = (DisplayCoordinator) inAppMessageAutomationPreparer$prepare$1.L$4;
                airshipCachedAssets = (AirshipCachedAssets) inAppMessageAutomationPreparer$prepare$1.L$3;
                preparedScheduleInfo = (PreparedScheduleInfo) inAppMessageAutomationPreparer$prepare$1.L$2;
                InAppMessage inAppMessage3 = (InAppMessage) inAppMessageAutomationPreparer$prepare$1.L$1;
                inAppMessageAutomationPreparer = (InAppMessageAutomationPreparer) inAppMessageAutomationPreparer$prepare$1.L$0;
                ResultKt.throwOnFailure(obj);
                displayCoordinator = displayCoordinator2;
                inAppMessage2 = inAppMessage3;
            }
            inAppMessageAnalyticsInterface = (InAppMessageAnalyticsInterface) obj;
            inAppActionRunnerMakeRunner$urbanairship_automation_release = inAppMessageAutomationPreparer.actionRunnerFactory.makeRunner$urbanairship_automation_release(inAppMessage2, inAppMessageAnalyticsInterface);
            objM5118makeAdapterBWLJW6A = inAppMessageAutomationPreparer.displayAdapterFactory.m5118makeAdapterBWLJW6A(inAppMessage2, preparedScheduleInfo.getPriority$urbanairship_automation_release(), airshipCachedAssets, inAppActionRunnerMakeRunner$urbanairship_automation_release);
            thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(objM5118makeAdapterBWLJW6A);
            if (thM5280exceptionOrNullimpl == null) {
                UALog.m1757w(thM5280exceptionOrNullimpl, (Function0<String>) new Function0() { // from class: com.urbanairship.iam.InAppMessageAutomationPreparer$prepare$adapter$1$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to resolve adapter " + preparedScheduleInfo.getScheduleId$urbanairship_automation_release();
                    }
                });
                return Result.m5277constructorimpl(ResultKt.createFailure(thM5280exceptionOrNullimpl));
            }
            return Result.m5277constructorimpl(new PreparedInAppMessageData(inAppMessage2, (DisplayAdapter) objM5118makeAdapterBWLJW6A, displayCoordinator, inAppMessageAnalyticsInterface, inAppActionRunnerMakeRunner$urbanairship_automation_release));
        }
        ResultKt.throwOnFailure(obj);
        String scheduleId$urbanairship_automation_release = preparedScheduleInfo.getScheduleId$urbanairship_automation_release();
        boolean z = !preparedScheduleInfo.getAdditionalAudienceCheckResult$urbanairship_automation_release() || ((experimentResult$urbanairship_automation_release = preparedScheduleInfo.getExperimentResult$urbanairship_automation_release()) != null && experimentResult$urbanairship_automation_release.getIsMatching());
        inAppMessageAutomationPreparer$prepare$1.L$0 = this;
        inAppMessageAutomationPreparer$prepare$1.L$1 = inAppMessage;
        inAppMessageAutomationPreparer$prepare$1.L$2 = preparedScheduleInfo;
        inAppMessageAutomationPreparer$prepare$1.label = 1;
        objM5116prepareAssetsBWLJW6A = m5116prepareAssetsBWLJW6A(inAppMessage, scheduleId$urbanairship_automation_release, z, inAppMessageAutomationPreparer$prepare$1);
        if (objM5116prepareAssetsBWLJW6A == coroutine_suspended) {
            return coroutine_suspended;
        }
        Throwable thM5280exceptionOrNullimpl2 = Result.m5280exceptionOrNullimpl(objM5116prepareAssetsBWLJW6A);
        if (thM5280exceptionOrNullimpl2 != null) {
            return Result.m5277constructorimpl(ResultKt.createFailure(thM5280exceptionOrNullimpl2));
        }
        AirshipCachedAssets airshipCachedAssets2 = (AirshipCachedAssets) objM5116prepareAssetsBWLJW6A;
        DisplayCoordinator displayCoordinator3 = this.displayCoordinatorManager.displayCoordinator(inAppMessage);
        InAppMessageAnalyticsFactory inAppMessageAnalyticsFactory = this.analyticsFactory;
        inAppMessageAutomationPreparer$prepare$1.L$0 = this;
        inAppMessageAutomationPreparer$prepare$1.L$1 = inAppMessage;
        inAppMessageAutomationPreparer$prepare$1.L$2 = preparedScheduleInfo;
        inAppMessageAutomationPreparer$prepare$1.L$3 = airshipCachedAssets2;
        inAppMessageAutomationPreparer$prepare$1.L$4 = displayCoordinator3;
        inAppMessageAutomationPreparer$prepare$1.label = 2;
        Object objMakeAnalytics = inAppMessageAnalyticsFactory.makeAnalytics(inAppMessage, preparedScheduleInfo, inAppMessageAutomationPreparer$prepare$1);
        if (objMakeAnalytics == coroutine_suspended) {
            return coroutine_suspended;
        }
        inAppMessage2 = inAppMessage;
        airshipCachedAssets = airshipCachedAssets2;
        obj = objMakeAnalytics;
        displayCoordinator = displayCoordinator3;
        inAppMessageAutomationPreparer = this;
        inAppMessageAnalyticsInterface = (InAppMessageAnalyticsInterface) obj;
        inAppActionRunnerMakeRunner$urbanairship_automation_release = inAppMessageAutomationPreparer.actionRunnerFactory.makeRunner$urbanairship_automation_release(inAppMessage2, inAppMessageAnalyticsInterface);
        objM5118makeAdapterBWLJW6A = inAppMessageAutomationPreparer.displayAdapterFactory.m5118makeAdapterBWLJW6A(inAppMessage2, preparedScheduleInfo.getPriority$urbanairship_automation_release(), airshipCachedAssets, inAppActionRunnerMakeRunner$urbanairship_automation_release);
        thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(objM5118makeAdapterBWLJW6A);
        if (thM5280exceptionOrNullimpl == null) {
            UALog.m1757w(thM5280exceptionOrNullimpl, (Function0<String>) new Function0() { // from class: com.urbanairship.iam.InAppMessageAutomationPreparer$prepare$adapter$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to resolve adapter " + preparedScheduleInfo.getScheduleId$urbanairship_automation_release();
                }
            });
            return Result.m5277constructorimpl(ResultKt.createFailure(thM5280exceptionOrNullimpl));
        }
        return Result.m5277constructorimpl(new PreparedInAppMessageData(inAppMessage2, (DisplayAdapter) objM5118makeAdapterBWLJW6A, displayCoordinator, inAppMessageAnalyticsInterface, inAppActionRunnerMakeRunner$urbanairship_automation_release));
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
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: prepareAssets-BWLJW6A, reason: not valid java name */
    public final Object m5116prepareAssetsBWLJW6A(InAppMessage inAppMessage, final String str, boolean z, Continuation continuation) {
        InAppMessageAutomationPreparer$prepareAssets$1 inAppMessageAutomationPreparer$prepareAssets$1;
        if (continuation instanceof InAppMessageAutomationPreparer$prepareAssets$1) {
            inAppMessageAutomationPreparer$prepareAssets$1 = (InAppMessageAutomationPreparer$prepareAssets$1) continuation;
            int i = inAppMessageAutomationPreparer$prepareAssets$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                inAppMessageAutomationPreparer$prepareAssets$1.label = i - Integer.MIN_VALUE;
            } else {
                inAppMessageAutomationPreparer$prepareAssets$1 = new InAppMessageAutomationPreparer$prepareAssets$1(this, continuation);
            }
        } else {
            inAppMessageAutomationPreparer$prepareAssets$1 = new InAppMessageAutomationPreparer$prepareAssets$1(this, continuation);
        }
        Object obj = inAppMessageAutomationPreparer$prepareAssets$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = inAppMessageAutomationPreparer$prepareAssets$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                return ((Result) obj).getValue();
            }
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        if (z) {
            AssetCacheManager assetCacheManager = this.assetsManager;
            List<String> listEmptyList = CollectionsKt.emptyList();
            inAppMessageAutomationPreparer$prepareAssets$1.label = 1;
            Object objM5133cacheAsset0E7RQCE = assetCacheManager.m5133cacheAsset0E7RQCE(str, listEmptyList, inAppMessageAutomationPreparer$prepareAssets$1);
            return objM5133cacheAsset0E7RQCE == coroutine_suspended ? coroutine_suspended : objM5133cacheAsset0E7RQCE;
        }
        List<UrlInfo> urlInfos = InAppMessageKt.getUrlInfos(inAppMessage);
        final ArrayList arrayList = new ArrayList();
        Iterator<T> it = urlInfos.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            UrlInfo urlInfo = (UrlInfo) it.next();
            String url = WhenMappings.$EnumSwitchMapping$0[urlInfo.getType().ordinal()] == 1 ? urlInfo.getUrl() : null;
            if (url != null) {
                arrayList.add(url);
            }
        }
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.iam.InAppMessageAutomationPreparer$prepareAssets$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Preparing assets " + str + ": " + arrayList;
            }
        }, 1, null);
        AssetCacheManager assetCacheManager2 = this.assetsManager;
        inAppMessageAutomationPreparer$prepareAssets$1.label = 2;
        Object objM5133cacheAsset0E7RQCE2 = assetCacheManager2.m5133cacheAsset0E7RQCE(str, arrayList, inAppMessageAutomationPreparer$prepareAssets$1);
        return objM5133cacheAsset0E7RQCE2 == coroutine_suspended ? coroutine_suspended : objM5133cacheAsset0E7RQCE2;
    }
}
