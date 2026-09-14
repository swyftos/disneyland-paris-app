package com.urbanairship.audience;

import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.cache.AirshipCache;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J.\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0012J \u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J(\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0019J&\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m1836d2 = {"Lcom/urbanairship/audience/HashChecker;", "", "cache", "Lcom/urbanairship/cache/AirshipCache;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/cache/AirshipCache;Lkotlinx/coroutines/CoroutineDispatcher;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "cacheResult", "", "selector", "Lcom/urbanairship/audience/AudienceHashSelector;", "result", "Lcom/urbanairship/audience/AirshipDeviceAudienceResult;", "contactId", "", "channelId", "(Lcom/urbanairship/audience/AudienceHashSelector;Lcom/urbanairship/audience/AirshipDeviceAudienceResult;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "evaluate", "hashSelector", "deviceInfoProvider", "Lcom/urbanairship/audience/DeviceInfoProvider;", "(Lcom/urbanairship/audience/AudienceHashSelector;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedResult", "(Lcom/urbanairship/audience/AudienceHashSelector;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveResult", "Companion", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nHashCheker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HashCheker.kt\ncom/urbanairship/audience/HashChecker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n1#2:111\n*E\n"})
public final class HashChecker {
    private static final Companion Companion = new Companion(null);
    private final AirshipCache cache;
    private final CoroutineScope scope;

    /* JADX INFO: renamed from: com.urbanairship.audience.HashChecker$resolveResult$1 */
    static final class C49661 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C49661(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HashChecker.this.resolveResult(null, null, null, this);
        }
    }

    public HashChecker(@NotNull AirshipCache cache, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.cache = cache;
        this.scope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    public /* synthetic */ HashChecker(AirshipCache airshipCache, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(airshipCache, (i & 2) != 0 ? AirshipDispatchers.INSTANCE.newSerialDispatcher() : coroutineDispatcher);
    }

    @Nullable
    public final Object evaluate(@Nullable AudienceHashSelector audienceHashSelector, @NotNull DeviceInfoProvider deviceInfoProvider, @NotNull Continuation<? super AirshipDeviceAudienceResult> continuation) {
        if (audienceHashSelector == null) {
            return AirshipDeviceAudienceResult.INSTANCE.getMatch();
        }
        return BuildersKt__Builders_commonKt.async$default(this.scope, null, null, new HashChecker$evaluate$operation$1(deviceInfoProvider, this, audienceHashSelector, null), 3, null).await(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object resolveResult(AudienceHashSelector audienceHashSelector, String str, String str2, Continuation continuation) {
        C49661 c49661;
        JsonValue reportingMetadata;
        if (continuation instanceof C49661) {
            c49661 = (C49661) continuation;
            int i = c49661.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c49661.label = i - Integer.MIN_VALUE;
            } else {
                c49661 = new C49661(continuation);
            }
        } else {
            c49661 = new C49661(continuation);
        }
        Object cachedResult = c49661.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c49661.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(cachedResult);
            c49661.L$0 = audienceHashSelector;
            c49661.L$1 = str;
            c49661.L$2 = str2;
            c49661.label = 1;
            cachedResult = getCachedResult(audienceHashSelector, str, str2, c49661);
            if (cachedResult == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) c49661.L$2;
            str = (String) c49661.L$1;
            audienceHashSelector = (AudienceHashSelector) c49661.L$0;
            ResultKt.throwOnFailure(cachedResult);
        }
        AirshipDeviceAudienceResult airshipDeviceAudienceResult = (AirshipDeviceAudienceResult) cachedResult;
        if (airshipDeviceAudienceResult != null) {
            return airshipDeviceAudienceResult;
        }
        boolean zEvaluate$urbanairship_core_release = audienceHashSelector.evaluate$urbanairship_core_release(str2, str);
        AudienceSticky sticky$urbanairship_core_release = audienceHashSelector.getSticky();
        return new AirshipDeviceAudienceResult(zEvaluate$urbanairship_core_release, (sticky$urbanairship_core_release == null || (reportingMetadata = sticky$urbanairship_core_release.getReportingMetadata()) == null) ? null : CollectionsKt.listOf(reportingMetadata));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getCachedResult(AudienceHashSelector audienceHashSelector, String str, String str2, Continuation continuation) {
        AudienceSticky sticky$urbanairship_core_release = audienceHashSelector.getSticky();
        if (sticky$urbanairship_core_release == null) {
            return null;
        }
        return this.cache.getCached(Companion.makeCacheKey(sticky$urbanairship_core_release.getId(), str, str2), new C49652(AirshipDeviceAudienceResult.INSTANCE), continuation);
    }

    /* JADX INFO: renamed from: com.urbanairship.audience.HashChecker$getCachedResult$2 */
    /* synthetic */ class C49652 extends FunctionReferenceImpl implements Function1 {
        C49652(Object obj) {
            super(1, obj, AirshipDeviceAudienceResult.Companion.class, "fromJson", "fromJson(Lcom/urbanairship/json/JsonValue;)Lcom/urbanairship/audience/AirshipDeviceAudienceResult;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final AirshipDeviceAudienceResult invoke(JsonValue p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((AirshipDeviceAudienceResult.Companion) this.receiver).fromJson(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object cacheResult(AudienceHashSelector audienceHashSelector, AirshipDeviceAudienceResult airshipDeviceAudienceResult, String str, String str2, Continuation continuation) {
        AudienceSticky sticky$urbanairship_core_release = audienceHashSelector.getSticky();
        if (sticky$urbanairship_core_release == null) {
            return Unit.INSTANCE;
        }
        Object objM5067storeexY8QGI = this.cache.m5067storeexY8QGI(airshipDeviceAudienceResult, Companion.makeCacheKey(sticky$urbanairship_core_release.getId(), str, str2), sticky$urbanairship_core_release.m5008getLastAccessTtlUwyO8pc(), continuation);
        return objM5067storeexY8QGI == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM5067storeexY8QGI : Unit.INSTANCE;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String makeCacheKey(String id, String contactId, String channelId) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(contactId, "contactId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{"StickyHash", contactId, channelId, id}), ":", null, null, 0, null, null, 62, null);
        }
    }
}
