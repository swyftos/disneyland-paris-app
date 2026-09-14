package com.urbanairship.remotedata;

import androidx.annotation.VisibleForTesting;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.dlp.BluetoothManager;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UALog;
import com.urbanairship.http.RequestResult;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.Clock;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u0000 G2\u00020\u0001:\u0003GHIB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010(\u001a\u00020)H\u0004J.\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H§@¢\u0006\u0002\u00103J\u0016\u00104\u001a\u00020\t2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J \u00105\u001a\u00020\t2\u0006\u00106\u001a\u0002022\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H'J\u0010\u00107\u001a\u00020)2\u0006\u00108\u001a\u00020\u000fH\u0002J\u000e\u00109\u001a\u00020\t2\u0006\u00106\u001a\u000202J\"\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00110>H\u0086@¢\u0006\u0002\u0010?J&\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00112\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0086@¢\u0006\u0002\u0010CJ*\u0010D\u001a\u00020\u000f2\b\u0010E\u001a\u0004\u0018\u00010\u00172\u0006\u0010B\u001a\u00020\u00112\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u001e\u0010D\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u00112\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u00178B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006J"}, m1836d2 = {"Lcom/urbanairship/remotedata/RemoteDataProvider;", "", "source", "Lcom/urbanairship/remotedata/RemoteDataSource;", "remoteDataStore", "Lcom/urbanairship/remotedata/RemoteDataStore;", "preferenceDataStore", "Lcom/urbanairship/PreferenceDataStore;", "defaultEnabled", "", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/remotedata/RemoteDataSource;Lcom/urbanairship/remotedata/RemoteDataStore;Lcom/urbanairship/PreferenceDataStore;ZLcom/urbanairship/util/Clock;)V", "_statusUpdates", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/urbanairship/remotedata/RemoteData$Status;", "enabledKey", "", "value", "isEnabled", "()Z", "setEnabled", "(Z)V", "Lcom/urbanairship/remotedata/RemoteDataProvider$LastRefreshState;", "lastRefreshState", "getLastRefreshState", "()Lcom/urbanairship/remotedata/RemoteDataProvider$LastRefreshState;", "setLastRefreshState", "(Lcom/urbanairship/remotedata/RemoteDataProvider$LastRefreshState;)V", "lastRefreshStateKey", "lastRefreshStateLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getSource", "()Lcom/urbanairship/remotedata/RemoteDataSource;", "setSource", "(Lcom/urbanairship/remotedata/RemoteDataSource;)V", "statusUpdates", "Lkotlinx/coroutines/flow/StateFlow;", "getStatusUpdates", "()Lkotlinx/coroutines/flow/StateFlow;", "clearLastRefreshState", "", "fetchRemoteData", "Lcom/urbanairship/http/RequestResult;", "Lcom/urbanairship/remotedata/RemoteDataApiClient$Result;", Constants.LOCALE, "Ljava/util/Locale;", "randomValue", "", "lastRemoteDataInfo", "Lcom/urbanairship/remotedata/RemoteDataInfo;", "(Ljava/util/Locale;ILcom/urbanairship/remotedata/RemoteDataInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCurrent", "isRemoteDataInfoUpToDate", "remoteDataInfo", "notifyNewStatus", BluetoothManager.BLE_STATUS_PARAM, "notifyOutdated", "payloads", "", "Lcom/urbanairship/remotedata/RemoteDataPayload;", "type", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refresh", "Lcom/urbanairship/remotedata/RemoteDataProvider$RefreshResult;", "changeToken", "(Ljava/lang/String;Ljava/util/Locale;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "status", "refreshState", "token", "Companion", "LastRefreshState", "RefreshResult", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nRemoteDataProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteDataProvider.kt\ncom/urbanairship/remotedata/RemoteDataProvider\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,235:1\n18#2,8:236\n230#3,5:244\n*S KotlinDebug\n*F\n+ 1 RemoteDataProvider.kt\ncom/urbanairship/remotedata/RemoteDataProvider\n*L\n52#1:236,8\n176#1:244,5\n*E\n"})
public abstract class RemoteDataProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long MAX_STALE_TIME_MS = TimeUnit.DAYS.toMillis(3);
    private final MutableStateFlow _statusUpdates;
    private final Clock clock;
    private final boolean defaultEnabled;
    private final String enabledKey;
    private final String lastRefreshStateKey;
    private final ReentrantLock lastRefreshStateLock;
    private final PreferenceDataStore preferenceDataStore;
    private final RemoteDataStore remoteDataStore;
    private RemoteDataSource source;
    private final StateFlow statusUpdates;

    @Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1836d2 = {"Lcom/urbanairship/remotedata/RemoteDataProvider$RefreshResult;", "", "(Ljava/lang/String;I)V", "SKIPPED", "NEW_DATA", "FAILED", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public enum RefreshResult {
        SKIPPED,
        NEW_DATA,
        FAILED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        @NotNull
        public static EnumEntries<RefreshResult> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.remotedata.RemoteDataProvider$refresh$1 */
    static final class C58671 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C58671(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteDataProvider.this.refresh(null, null, 0, this);
        }
    }

    @VisibleForTesting
    @Nullable
    public abstract Object fetchRemoteData(@NotNull Locale locale, int i, @Nullable RemoteDataInfo remoteDataInfo, @NotNull Continuation<? super RequestResult<RemoteDataApiClient.Result>> continuation);

    @VisibleForTesting
    public abstract boolean isRemoteDataInfoUpToDate(@NotNull RemoteDataInfo remoteDataInfo, @NotNull Locale locale, int randomValue);

    public RemoteDataProvider(@NotNull RemoteDataSource source, @NotNull RemoteDataStore remoteDataStore, @NotNull PreferenceDataStore preferenceDataStore, boolean z, @NotNull Clock clock) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(remoteDataStore, "remoteDataStore");
        Intrinsics.checkNotNullParameter(preferenceDataStore, "preferenceDataStore");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.source = source;
        this.remoteDataStore = remoteDataStore;
        this.preferenceDataStore = preferenceDataStore;
        this.defaultEnabled = z;
        this.clock = clock;
        this.enabledKey = "RemoteDataProvider." + this.source.name() + "_enabled";
        this.lastRefreshStateKey = "RemoteDataProvider." + this.source.name() + "_refresh_state";
        this.lastRefreshStateLock = new ReentrantLock();
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(RemoteData.Status.OUT_OF_DATE);
        this._statusUpdates = MutableStateFlow;
        this.statusUpdates = FlowKt.asStateFlow(MutableStateFlow);
    }

    @NotNull
    public final RemoteDataSource getSource() {
        return this.source;
    }

    public final void setSource(@NotNull RemoteDataSource remoteDataSource) {
        Intrinsics.checkNotNullParameter(remoteDataSource, "<set-?>");
        this.source = remoteDataSource;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ RemoteDataProvider(RemoteDataSource remoteDataSource, RemoteDataStore remoteDataStore, PreferenceDataStore preferenceDataStore, boolean z, Clock DEFAULT_CLOCK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z2 = (i & 8) != 0 ? true : z;
        if ((i & 16) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(remoteDataSource, remoteDataStore, preferenceDataStore, z2, DEFAULT_CLOCK);
    }

    public final boolean isEnabled() {
        return this.preferenceDataStore.getBoolean(this.enabledKey, this.defaultEnabled);
    }

    public final void setEnabled(boolean z) {
        this.preferenceDataStore.put(this.enabledKey, z);
    }

    @NotNull
    public final StateFlow<RemoteData.Status> getStatusUpdates() {
        return this.statusUpdates;
    }

    private final LastRefreshState getLastRefreshState() {
        LastRefreshState lastRefreshState;
        ReentrantLock reentrantLock = this.lastRefreshStateLock;
        reentrantLock.lock();
        try {
            JsonValue jsonValue = this.preferenceDataStore.getJsonValue(this.lastRefreshStateKey);
            try {
                Intrinsics.checkNotNull(jsonValue);
                lastRefreshState = new LastRefreshState(jsonValue);
            } catch (JsonException unused) {
                lastRefreshState = null;
            }
            return lastRefreshState;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void setLastRefreshState(LastRefreshState lastRefreshState) {
        ReentrantLock reentrantLock = this.lastRefreshStateLock;
        reentrantLock.lock();
        try {
            this.preferenceDataStore.put(this.lastRefreshStateKey, lastRefreshState);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.remotedata.RemoteDataProvider$payloads$2 */
    static final class C58662 extends SuspendLambda implements Function2 {
        final /* synthetic */ List $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C58662(List list, Continuation continuation) {
            super(2, continuation);
            this.$type = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return RemoteDataProvider.this.new C58662(this.$type, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C58662) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (RemoteDataProvider.this.isEnabled()) {
                Set payloads = RemoteDataProvider.this.remoteDataStore.getPayloads(this.$type);
                Intrinsics.checkNotNull(payloads);
                return payloads;
            }
            return SetsKt.emptySet();
        }
    }

    @Nullable
    public final Object payloads(@NotNull List<String> list, @NotNull Continuation<? super Set<RemoteDataPayload>> continuation) {
        return BuildersKt.withContext(AirshipDispatchers.INSTANCE.getIO(), new C58662(list, null), continuation);
    }

    protected final void clearLastRefreshState() {
        setLastRefreshState(null);
    }

    public final boolean isCurrent(@NotNull Locale locale, int randomValue) {
        LastRefreshState lastRefreshState;
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (isEnabled() && (lastRefreshState = getLastRefreshState()) != null) {
            return isRemoteDataInfoUpToDate(lastRefreshState.getRemoteDataInfo(), locale, randomValue);
        }
        return false;
    }

    public final boolean notifyOutdated(@NotNull RemoteDataInfo remoteDataInfo) {
        boolean z;
        Intrinsics.checkNotNullParameter(remoteDataInfo, "remoteDataInfo");
        ReentrantLock reentrantLock = this.lastRefreshStateLock;
        reentrantLock.lock();
        try {
            LastRefreshState lastRefreshState = getLastRefreshState();
            if (Intrinsics.areEqual(lastRefreshState != null ? lastRefreshState.getRemoteDataInfo() : null, remoteDataInfo)) {
                setLastRefreshState(null);
                z = true;
            } else {
                z = false;
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object refresh(@NotNull String str, @NotNull Locale locale, int i, @NotNull Continuation<? super RefreshResult> continuation) {
        C58671 c58671;
        LastRefreshState lastRefreshState;
        Object objFetchRemoteData;
        if (continuation instanceof C58671) {
            c58671 = (C58671) continuation;
            int i2 = c58671.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c58671.label = i2 - Integer.MIN_VALUE;
            } else {
                c58671 = new C58671(continuation);
            }
        } else {
            c58671 = new C58671(continuation);
        }
        Object obj = c58671.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c58671.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!isEnabled()) {
                if (this.remoteDataStore.deletePayloads() > 0) {
                    return RefreshResult.NEW_DATA;
                }
                return RefreshResult.SKIPPED;
            }
            lastRefreshState = getLastRefreshState();
            RemoteData.Status status = status(lastRefreshState, str, locale, i);
            notifyNewStatus(status);
            if (status == RemoteData.Status.UP_TO_DATE) {
                return RefreshResult.SKIPPED;
            }
            RemoteDataInfo remoteDataInfo = lastRefreshState != null ? lastRefreshState.getRemoteDataInfo() : null;
            c58671.L$0 = this;
            c58671.L$1 = str;
            c58671.L$2 = lastRefreshState;
            c58671.label = 1;
            objFetchRemoteData = fetchRemoteData(locale, i, remoteDataInfo, c58671);
            if (objFetchRemoteData == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LastRefreshState lastRefreshState2 = (LastRefreshState) c58671.L$2;
            str = (String) c58671.L$1;
            RemoteDataProvider remoteDataProvider = (RemoteDataProvider) c58671.L$0;
            ResultKt.throwOnFailure(obj);
            lastRefreshState = lastRefreshState2;
            this = remoteDataProvider;
            objFetchRemoteData = obj;
        }
        RequestResult requestResult = (RequestResult) objFetchRemoteData;
        if (requestResult.getException() != null) {
            return RefreshResult.FAILED;
        }
        if (requestResult.isSuccessful() && requestResult.getValue() != null) {
            this.remoteDataStore.deletePayloads();
            this.remoteDataStore.savePayloads(((RemoteDataApiClient.Result) requestResult.getValue()).getPayloads());
            this.setLastRefreshState(new LastRefreshState(str, ((RemoteDataApiClient.Result) requestResult.getValue()).getRemoteDataInfo(), this.clock.currentTimeMillis()));
            return RefreshResult.NEW_DATA;
        }
        Integer status2 = requestResult.getStatus();
        if (status2 == null || status2.intValue() != 304) {
            return RefreshResult.FAILED;
        }
        if (lastRefreshState == null) {
            UALog.e$default(null, new Function0() { // from class: com.urbanairship.remotedata.RemoteDataProvider.refresh.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Received a 304 without a previous refresh state";
                }
            }, 1, null);
            return RefreshResult.FAILED;
        }
        this.setLastRefreshState(new LastRefreshState(str, lastRefreshState.getRemoteDataInfo(), this.clock.currentTimeMillis()));
        return RefreshResult.SKIPPED;
    }

    @NotNull
    public final RemoteData.Status status(@NotNull String token, @NotNull Locale locale, int randomValue) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(locale, "locale");
        RemoteData.Status status = status(getLastRefreshState(), token, locale, randomValue);
        notifyNewStatus(status);
        return status;
    }

    private final void notifyNewStatus(RemoteData.Status state) {
        Object value;
        MutableStateFlow mutableStateFlow = this._statusUpdates;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, state));
    }

    private final RemoteData.Status status(LastRefreshState refreshState, String changeToken, Locale locale, int randomValue) {
        if (!isEnabled()) {
            return RemoteData.Status.OUT_OF_DATE;
        }
        if (refreshState == null) {
            return RemoteData.Status.OUT_OF_DATE;
        }
        if (this.clock.currentTimeMillis() >= refreshState.getTimeMillis() + MAX_STALE_TIME_MS) {
            return RemoteData.Status.OUT_OF_DATE;
        }
        if (!isRemoteDataInfoUpToDate(refreshState.getRemoteDataInfo(), locale, randomValue)) {
            return RemoteData.Status.OUT_OF_DATE;
        }
        if (!Intrinsics.areEqual(refreshState.getChangeToken(), changeToken)) {
            return RemoteData.Status.STALE;
        }
        return RemoteData.Status.UP_TO_DATE;
    }

    private static final class LastRefreshState implements JsonSerializable {
        private final String changeToken;
        private final RemoteDataInfo remoteDataInfo;
        private final long timeMillis;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LastRefreshState)) {
                return false;
            }
            LastRefreshState lastRefreshState = (LastRefreshState) obj;
            return Intrinsics.areEqual(this.changeToken, lastRefreshState.changeToken) && Intrinsics.areEqual(this.remoteDataInfo, lastRefreshState.remoteDataInfo) && this.timeMillis == lastRefreshState.timeMillis;
        }

        public int hashCode() {
            return (((this.changeToken.hashCode() * 31) + this.remoteDataInfo.hashCode()) * 31) + Long.hashCode(this.timeMillis);
        }

        public String toString() {
            return "LastRefreshState(changeToken=" + this.changeToken + ", remoteDataInfo=" + this.remoteDataInfo + ", timeMillis=" + this.timeMillis + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public LastRefreshState(String changeToken, RemoteDataInfo remoteDataInfo, long j) {
            Intrinsics.checkNotNullParameter(changeToken, "changeToken");
            Intrinsics.checkNotNullParameter(remoteDataInfo, "remoteDataInfo");
            this.changeToken = changeToken;
            this.remoteDataInfo = remoteDataInfo;
            this.timeMillis = j;
        }

        public final String getChangeToken() {
            return this.changeToken;
        }

        public final RemoteDataInfo getRemoteDataInfo() {
            return this.remoteDataInfo;
        }

        public final long getTimeMillis() {
            return this.timeMillis;
        }

        public LastRefreshState(JsonValue json) throws JsonException {
            String strOptString;
            Long lValueOf;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonMap jsonMapRequireMap = json.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue = jsonMapRequireMap.get("changeToken");
            if (jsonValue == null) {
                throw new JsonException("Missing required field: 'changeToken" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'changeToken" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue2 = jsonValue.getJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue2;
            }
            JsonValue jsonValueRequire = json.requireMap().require("remoteDataInfo");
            Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
            RemoteDataInfo remoteDataInfo = new RemoteDataInfo(jsonValueRequire);
            JsonMap jsonMapRequireMap2 = json.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap2, "requireMap(...)");
            JsonValue jsonValue3 = jsonMapRequireMap2.get("timeMilliseconds");
            if (jsonValue3 == null) {
                lValueOf = null;
            } else {
                Intrinsics.checkNotNull(jsonValue3);
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    lValueOf = (Long) jsonValue3.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    lValueOf = (Long) Boolean.valueOf(jsonValue3.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    lValueOf = Long.valueOf(jsonValue3.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    lValueOf = (Long) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    lValueOf = (Long) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    lValueOf = (Long) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    lValueOf = (Long) Integer.valueOf(jsonValue3.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    lValueOf = (Long) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    lValueOf = (Long) jsonValue3.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    lValueOf = (Long) jsonValue3.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'timeMilliseconds" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    lValueOf = (Long) jsonValue3.getJsonValue();
                }
            }
            this(strOptString, remoteDataInfo, lValueOf != null ? lValueOf.longValue() : 0L);
        }

        @Override // com.urbanairship.json.JsonSerializable
        /* JADX INFO: renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("changeToken", this.changeToken), TuplesKt.m1842to("remoteDataInfo", this.remoteDataInfo), TuplesKt.m1842to("timeMilliseconds", Long.valueOf(this.timeMillis))).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(m1835d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/remotedata/RemoteDataProvider$Companion;", "", "()V", "MAX_STALE_TIME_MS", "", "getMAX_STALE_TIME_MS", "()J", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getMAX_STALE_TIME_MS() {
            return RemoteDataProvider.MAX_STALE_TIME_MS;
        }
    }
}
