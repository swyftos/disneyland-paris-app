package com.urbanairship.cache;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.net.SyslogConstants;
import com.contentsquare.android.api.Currencies;
import com.google.firebase.messaging.Constants;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.cache.CacheDatabase;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.Clock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u0017J.\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0080@¢\u0006\u0004\b\u001b\u0010\u001cJ2\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u0016\u001a\u00020\t2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u0002H\u001e0 H\u0086@¢\u0006\u0002\u0010\"J+\u0010\u0012\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010%\u001a\u00020&H\u0086@ø\u0001\u0000¢\u0006\u0004\b'\u0010(R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"Lcom/urbanairship/cache/AirshipCache;", "", "context", "Landroid/content/Context;", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "isPersistent", "", "appVersion", "", "sdkVersion", "clock", "Lcom/urbanairship/util/Clock;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/urbanairship/config/AirshipRuntimeConfig;ZLjava/lang/String;Ljava/lang/String;Lcom/urbanairship/util/Clock;Lkotlinx/coroutines/CoroutineDispatcher;)V", "dbScope", "Lkotlinx/coroutines/CoroutineScope;", "store", "Lcom/urbanairship/cache/CacheDao;", "delete", "", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteExpired", "timestamp", "", "deleteExpired$urbanairship_core_release", "(Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCached", ExifInterface.GPS_DIRECTION_TRUE, "converter", "Lkotlin/Function1;", "Lcom/urbanairship/json/JsonValue;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "Lcom/urbanairship/json/JsonSerializable;", Constants.FirelogAnalytics.PARAM_TTL, "Lkotlin/time/Duration;", "store-exY8QGI", "(Lcom/urbanairship/json/JsonSerializable;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class AirshipCache {
    private final String appVersion;
    private final Clock clock;
    private final CoroutineScope dbScope;
    private final String sdkVersion;
    private final CacheDao store;

    /* renamed from: com.urbanairship.cache.AirshipCache$getCached$1, reason: invalid class name and case insensitive filesystem */
    static final class C10651 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10651(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AirshipCache.this.getCached(null, null, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AirshipCache(@NotNull Context context, @NotNull AirshipRuntimeConfig runtimeConfig) {
        this(context, runtimeConfig, false, null, null, null, null, Currencies.CAD, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AirshipCache(@NotNull Context context, @NotNull AirshipRuntimeConfig runtimeConfig, boolean z) {
        this(context, runtimeConfig, z, null, null, null, null, SyslogConstants.LOG_CLOCK, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AirshipCache(@NotNull Context context, @NotNull AirshipRuntimeConfig runtimeConfig, boolean z, @NotNull String appVersion) {
        this(context, runtimeConfig, z, appVersion, null, null, null, SyslogConstants.LOG_ALERT, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AirshipCache(@NotNull Context context, @NotNull AirshipRuntimeConfig runtimeConfig, boolean z, @NotNull String appVersion, @NotNull String sdkVersion) {
        this(context, runtimeConfig, z, appVersion, sdkVersion, null, null, 96, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AirshipCache(@NotNull Context context, @NotNull AirshipRuntimeConfig runtimeConfig, boolean z, @NotNull String appVersion, @NotNull String sdkVersion, @NotNull Clock clock) {
        this(context, runtimeConfig, z, appVersion, sdkVersion, clock, null, 64, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(clock, "clock");
    }

    @JvmOverloads
    public AirshipCache(@NotNull Context context, @NotNull AirshipRuntimeConfig runtimeConfig, boolean z, @NotNull String appVersion, @NotNull String sdkVersion, @NotNull Clock clock, @NotNull CoroutineDispatcher dispatcher) {
        CacheDao cacheDao;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.appVersion = appVersion;
        this.sdkVersion = sdkVersion;
        this.clock = clock;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.dbScope = CoroutineScope;
        if (z) {
            CacheDatabase.Companion companion = CacheDatabase.INSTANCE;
            String appKey = runtimeConfig.getConfigOptions().appKey;
            Intrinsics.checkNotNullExpressionValue(appKey, "appKey");
            cacheDao = companion.persistent(context, appKey).cacheDao();
        } else {
            cacheDao = CacheDatabase.INSTANCE.inMemory(context).cacheDao();
        }
        this.store = cacheDao;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AirshipCache(Context context, AirshipRuntimeConfig airshipRuntimeConfig, boolean z, String str, String str2, Clock clock, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str3;
        Clock clock2;
        boolean z2 = (i & 4) != 0 ? true : z;
        String strValueOf = (i & 8) != 0 ? String.valueOf(UAirship.getAppVersion()) : str;
        if ((i & 16) != 0) {
            String version = UAirship.getVersion();
            Intrinsics.checkNotNullExpressionValue(version, "getVersion(...)");
            str3 = version;
        } else {
            str3 = str2;
        }
        if ((i & 32) != 0) {
            Clock DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
            clock2 = DEFAULT_CLOCK;
        } else {
            clock2 = clock;
        }
        this(context, airshipRuntimeConfig, z2, strValueOf, str3, clock2, (i & 64) != 0 ? AirshipDispatchers.INSTANCE.getIO() : coroutineDispatcher);
    }

    /* renamed from: com.urbanairship.cache.AirshipCache$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AirshipCache.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AirshipCache airshipCache = AirshipCache.this;
                    this.label = 1;
                    if (AirshipCache.deleteExpired$urbanairship_core_release$default(airshipCache, null, null, 0L, this, 7, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception e) {
                UALog.e(e, new Function0() { // from class: com.urbanairship.cache.AirshipCache.1.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to clear expired cache items";
                    }
                });
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> java.lang.Object getCached(@org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.urbanairship.json.JsonValue, ? extends T> r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.urbanairship.cache.AirshipCache.C10651
            if (r0 == 0) goto L13
            r0 = r11
            com.urbanairship.cache.AirshipCache$getCached$1 r0 = (com.urbanairship.cache.AirshipCache.C10651) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.cache.AirshipCache$getCached$1 r0 = new com.urbanairship.cache.AirshipCache$getCached$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L48
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r11)
            goto La7
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            java.lang.Object r8 = r0.L$2
            r10 = r8
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r8 = r0.L$1
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r8 = r0.L$0
            com.urbanairship.cache.AirshipCache r8 = (com.urbanairship.cache.AirshipCache) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L5c
        L48:
            kotlin.ResultKt.throwOnFailure(r11)
            com.urbanairship.cache.CacheDao r11 = r8.store
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r4
            java.lang.Object r11 = r11.getEntryWithKey(r9, r0)
            if (r11 != r1) goto L5c
            return r1
        L5c:
            com.urbanairship.cache.CacheEntity r11 = (com.urbanairship.cache.CacheEntity) r11
            if (r11 != 0) goto L61
            return r5
        L61:
            java.lang.String r2 = r11.getAppVersion()
            java.lang.String r4 = r8.appVersion
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
            if (r2 == 0) goto L96
            java.lang.String r2 = r11.getSdkVersion()
            java.lang.String r4 = r8.sdkVersion
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
            if (r2 == 0) goto L96
            com.urbanairship.util.Clock r2 = r8.clock
            long r6 = r2.currentTimeMillis()
            boolean r2 = r11.isExpired(r6)
            if (r2 == 0) goto L86
            goto L96
        L86:
            com.urbanairship.json.JsonValue r8 = r11.getData()     // Catch: java.lang.Exception -> L8f
            java.lang.Object r5 = r10.invoke(r8)     // Catch: java.lang.Exception -> L8f
            goto L95
        L8f:
            r8 = move-exception
            com.urbanairship.cache.AirshipCache$getCached$2 r9 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.cache.AirshipCache.getCached.2
                static {
                    /*
                        com.urbanairship.cache.AirshipCache$getCached$2 r0 = new com.urbanairship.cache.AirshipCache$getCached$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.cache.AirshipCache$getCached$2) com.urbanairship.cache.AirshipCache.getCached.2.INSTANCE com.urbanairship.cache.AirshipCache$getCached$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.cache.AirshipCache.AnonymousClass2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.cache.AirshipCache.AnonymousClass2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.cache.AirshipCache.AnonymousClass2.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to restore data from cache"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.cache.AirshipCache.AnonymousClass2.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r8, r9)
        L95:
            return r5
        L96:
            com.urbanairship.cache.CacheDao r8 = r8.store
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r8 = r8.deleteItemWithKey(r9, r0)
            if (r8 != r1) goto La7
            return r1
        La7:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.cache.AirshipCache.getCached(java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Object delete(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        Object objDeleteItemWithKey = this.store.deleteItemWithKey(str, continuation);
        return objDeleteItemWithKey == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteItemWithKey : Unit.INSTANCE;
    }

    @Nullable
    /* renamed from: store-exY8QGI, reason: not valid java name */
    public final Object m2825storeexY8QGI(@NotNull JsonSerializable jsonSerializable, @NotNull String str, long j, @NotNull Continuation<? super Unit> continuation) {
        CacheDao cacheDao = this.store;
        String str2 = this.appVersion;
        String str3 = this.sdkVersion;
        JsonValue jsonValue = jsonSerializable.getJsonValue();
        long jCurrentTimeMillis = this.clock.currentTimeMillis() + Duration.m3485getInWholeMillisecondsimpl(j);
        Intrinsics.checkNotNull(jsonValue);
        Object objUpdateEntry = cacheDao.updateEntry(new CacheEntity(str, str2, str3, jCurrentTimeMillis, jsonValue), continuation);
        return objUpdateEntry == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateEntry : Unit.INSTANCE;
    }

    public static /* synthetic */ Object deleteExpired$urbanairship_core_release$default(AirshipCache airshipCache, String str, String str2, long j, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = airshipCache.appVersion;
        }
        String str3 = str;
        if ((i & 2) != 0) {
            str2 = airshipCache.sdkVersion;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            j = airshipCache.clock.currentTimeMillis();
        }
        return airshipCache.deleteExpired$urbanairship_core_release(str3, str4, j, continuation);
    }

    @Nullable
    public final Object deleteExpired$urbanairship_core_release(@NotNull String str, @NotNull String str2, long j, @NotNull Continuation<? super Unit> continuation) {
        Object objDeleteExpired = this.store.deleteExpired(str, str2, j, continuation);
        return objDeleteExpired == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteExpired : Unit.INSTANCE;
    }
}
