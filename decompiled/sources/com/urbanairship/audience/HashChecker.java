package com.urbanairship.audience;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.joran.action.Action;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.audience.AirshipDeviceAudienceResult;
import com.urbanairship.cache.AirshipCache;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
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

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J.\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0012J \u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J(\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0019J&\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/audience/HashChecker;", "", "cache", "Lcom/urbanairship/cache/AirshipCache;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/cache/AirshipCache;Lkotlinx/coroutines/CoroutineDispatcher;)V", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "cacheResult", "", "selector", "Lcom/urbanairship/audience/AudienceHashSelector;", "result", "Lcom/urbanairship/audience/AirshipDeviceAudienceResult;", "contactId", "", "channelId", "(Lcom/urbanairship/audience/AudienceHashSelector;Lcom/urbanairship/audience/AirshipDeviceAudienceResult;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "evaluate", "hashSelector", "deviceInfoProvider", "Lcom/urbanairship/audience/DeviceInfoProvider;", "(Lcom/urbanairship/audience/AudienceHashSelector;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedResult", "(Lcom/urbanairship/audience/AudienceHashSelector;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveResult", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nHashCheker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HashCheker.kt\ncom/urbanairship/audience/HashChecker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n1#2:111\n*E\n"})
/* loaded from: classes5.dex */
public final class HashChecker {
    private static final Companion Companion = new Companion(null);
    private final AirshipCache cache;
    private final CoroutineScope scope;

    /* renamed from: com.urbanairship.audience.HashChecker$resolveResult$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
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
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object resolveResult(com.urbanairship.audience.AudienceHashSelector r5, java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.urbanairship.audience.HashChecker.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.urbanairship.audience.HashChecker$resolveResult$1 r0 = (com.urbanairship.audience.HashChecker.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.audience.HashChecker$resolveResult$1 r0 = new com.urbanairship.audience.HashChecker$resolveResult$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r4 = r0.L$2
            r7 = r4
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r4 = r0.L$1
            r6 = r4
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r4 = r0.L$0
            r5 = r4
            com.urbanairship.audience.AudienceHashSelector r5 = (com.urbanairship.audience.AudienceHashSelector) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L52
        L38:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L40:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r8 = r4.getCachedResult(r5, r6, r7, r0)
            if (r8 != r1) goto L52
            return r1
        L52:
            com.urbanairship.audience.AirshipDeviceAudienceResult r8 = (com.urbanairship.audience.AirshipDeviceAudienceResult) r8
            if (r8 == 0) goto L57
            return r8
        L57:
            boolean r4 = r5.evaluate$urbanairship_core_release(r7, r6)
            com.urbanairship.audience.AudienceSticky r5 = r5.getSticky()
            if (r5 == 0) goto L6c
            com.urbanairship.json.JsonValue r5 = r5.getReportingMetadata()
            if (r5 == 0) goto L6c
            java.util.List r5 = kotlin.collections.CollectionsKt.listOf(r5)
            goto L6d
        L6c:
            r5 = 0
        L6d:
            com.urbanairship.audience.AirshipDeviceAudienceResult r6 = new com.urbanairship.audience.AirshipDeviceAudienceResult
            r6.<init>(r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.audience.HashChecker.resolveResult(com.urbanairship.audience.AudienceHashSelector, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getCachedResult(AudienceHashSelector audienceHashSelector, String str, String str2, Continuation continuation) {
        AudienceSticky sticky$urbanairship_core_release = audienceHashSelector.getSticky();
        if (sticky$urbanairship_core_release == null) {
            return null;
        }
        return this.cache.getCached(Companion.makeCacheKey(sticky$urbanairship_core_release.getId(), str, str2), new AnonymousClass2(AirshipDeviceAudienceResult.INSTANCE), continuation);
    }

    /* renamed from: com.urbanairship.audience.HashChecker$getCachedResult$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1 {
        AnonymousClass2(Object obj) {
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
        Object objM2825storeexY8QGI = this.cache.m2825storeexY8QGI(airshipDeviceAudienceResult, Companion.makeCacheKey(sticky$urbanairship_core_release.getId(), str, str2), sticky$urbanairship_core_release.m2766getLastAccessTtlUwyO8pc(), continuation);
        return objM2825storeexY8QGI == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2825storeexY8QGI : Unit.INSTANCE;
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
