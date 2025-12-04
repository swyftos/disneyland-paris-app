package com.urbanairship.deferred;

import android.net.Uri;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.audience.AudienceOverridesProvider;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.SuspendingRequestSessionKt;
import com.urbanairship.json.JsonValue;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OpenForTesting
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0012J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0012JN\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0018\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u0002H\u00190!2\u0006\u0010#\u001a\u00020$H\u0092@¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\fH\u0012J6\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0018\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u0002H\u00190!H\u0096@¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/urbanairship/deferred/DeferredResolver;", "", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "audienceOverridesProvider", "Lcom/urbanairship/audience/AudienceOverridesProvider;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/audience/AudienceOverridesProvider;)V", "apiClient", "Lcom/urbanairship/deferred/DeferredApiClient;", "(Lcom/urbanairship/audience/AudienceOverridesProvider;Lcom/urbanairship/deferred/DeferredApiClient;)V", "locationMap", "", "Landroid/net/Uri;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "outdatedUrls", "", "addOutdatedUrl", "", "url", "addUrlMapping", "from", TypedValues.TransitionType.S_TO, "doResolve", "Lcom/urbanairship/deferred/DeferredResult;", ExifInterface.GPS_DIRECTION_TRUE, "request", "Lcom/urbanairship/deferred/DeferredRequest;", "stateOverrides", "Lcom/urbanairship/deferred/StateOverrides;", "audienceOverrides", "Lcom/urbanairship/audience/AudienceOverrides$Channel;", "resultParser", "Lkotlin/Function1;", "Lcom/urbanairship/json/JsonValue;", "allowRetry", "", "(Lcom/urbanairship/deferred/DeferredRequest;Lcom/urbanairship/deferred/StateOverrides;Lcom/urbanairship/audience/AudienceOverrides$Channel;Lkotlin/jvm/functions/Function1;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUrlOutDated", "resolve", "parser", "(Lcom/urbanairship/deferred/DeferredRequest;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveUrlMapping", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class DeferredResolver {
    private final DeferredApiClient apiClient;
    private final AudienceOverridesProvider audienceOverridesProvider;
    private final Map locationMap;
    private final ReentrantLock lock;
    private final Set outdatedUrls;

    /* renamed from: com.urbanairship.deferred.DeferredResolver$doResolve$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeferredResolver.this.doResolve(null, null, null, null, false, this);
        }
    }

    /* renamed from: com.urbanairship.deferred.DeferredResolver$resolve$1, reason: invalid class name and case insensitive filesystem */
    static final class C11171 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C11171(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeferredResolver.resolve$suspendImpl(DeferredResolver.this, null, null, this);
        }
    }

    @Nullable
    public <T> Object resolve(@NotNull DeferredRequest deferredRequest, @NotNull Function1<? super JsonValue, ? extends T> function1, @NotNull Continuation<? super DeferredResult<T>> continuation) {
        return resolve$suspendImpl(this, deferredRequest, function1, continuation);
    }

    public DeferredResolver(@NotNull AudienceOverridesProvider audienceOverridesProvider, @NotNull DeferredApiClient apiClient) {
        Intrinsics.checkNotNullParameter(audienceOverridesProvider, "audienceOverridesProvider");
        Intrinsics.checkNotNullParameter(apiClient, "apiClient");
        this.audienceOverridesProvider = audienceOverridesProvider;
        this.apiClient = apiClient;
        this.lock = new ReentrantLock();
        this.locationMap = new LinkedHashMap();
        this.outdatedUrls = new LinkedHashSet();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeferredResolver(@NotNull AirshipRuntimeConfig config, @NotNull AudienceOverridesProvider audienceOverridesProvider) {
        this(audienceOverridesProvider, new DeferredApiClient(config, SuspendingRequestSessionKt.toSuspendingRequestSession(config.getRequestSession())));
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(audienceOverridesProvider, "audienceOverridesProvider");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object resolve$suspendImpl(com.urbanairship.deferred.DeferredResolver r8, com.urbanairship.deferred.DeferredRequest r9, kotlin.jvm.functions.Function1 r10, kotlin.coroutines.Continuation r11) {
        /*
            boolean r0 = r11 instanceof com.urbanairship.deferred.DeferredResolver.C11171
            if (r0 == 0) goto L14
            r0 = r11
            com.urbanairship.deferred.DeferredResolver$resolve$1 r0 = (com.urbanairship.deferred.DeferredResolver.C11171) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            com.urbanairship.deferred.DeferredResolver$resolve$1 r0 = new com.urbanairship.deferred.DeferredResolver$resolve$1
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L4d
            if (r1 == r3) goto L36
            if (r1 != r2) goto L2e
            kotlin.ResultKt.throwOnFailure(r11)
            goto L8b
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            java.lang.Object r8 = r7.L$3
            com.urbanairship.deferred.StateOverrides r8 = (com.urbanairship.deferred.StateOverrides) r8
            java.lang.Object r9 = r7.L$2
            com.urbanairship.deferred.DeferredRequest r9 = (com.urbanairship.deferred.DeferredRequest) r9
            java.lang.Object r10 = r7.L$1
            com.urbanairship.deferred.DeferredResolver r10 = (com.urbanairship.deferred.DeferredResolver) r10
            java.lang.Object r1 = r7.L$0
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            kotlin.ResultKt.throwOnFailure(r11)
            r3 = r8
            r5 = r1
            r1 = r10
            goto L74
        L4d:
            kotlin.ResultKt.throwOnFailure(r11)
            com.urbanairship.deferred.StateOverrides r11 = new com.urbanairship.deferred.StateOverrides
            r11.<init>(r9)
            com.urbanairship.audience.AudienceOverridesProvider r1 = r8.audienceOverridesProvider
            java.lang.String r4 = r9.getChannelId()
            java.lang.String r5 = r9.getContactId()
            r7.L$0 = r10
            r7.L$1 = r8
            r7.L$2 = r9
            r7.L$3 = r11
            r7.label = r3
            java.lang.Object r1 = r1.channelOverrides$urbanairship_core_release(r4, r5, r7)
            if (r1 != r0) goto L70
            return r0
        L70:
            r5 = r10
            r3 = r11
            r11 = r1
            r1 = r8
        L74:
            r4 = r11
            com.urbanairship.audience.AudienceOverrides$Channel r4 = (com.urbanairship.audience.AudienceOverrides.Channel) r4
            r8 = 0
            r7.L$0 = r8
            r7.L$1 = r8
            r7.L$2 = r8
            r7.L$3 = r8
            r7.label = r2
            r6 = 1
            r2 = r9
            java.lang.Object r11 = r1.doResolve(r2, r3, r4, r5, r6, r7)
            if (r11 != r0) goto L8b
            return r0
        L8b:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.deferred.DeferredResolver.resolve$suspendImpl(com.urbanairship.deferred.DeferredResolver, com.urbanairship.deferred.DeferredRequest, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doResolve(com.urbanairship.deferred.DeferredRequest r17, com.urbanairship.deferred.StateOverrides r18, com.urbanairship.audience.AudienceOverrides.Channel r19, kotlin.jvm.functions.Function1 r20, boolean r21, kotlin.coroutines.Continuation r22) {
        /*
            Method dump skipped, instructions count: 571
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.deferred.DeferredResolver.doResolve(com.urbanairship.deferred.DeferredRequest, com.urbanairship.deferred.StateOverrides, com.urbanairship.audience.AudienceOverrides$Channel, kotlin.jvm.functions.Function1, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private boolean isUrlOutDated(Uri url) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.outdatedUrls.contains(url);
        } finally {
            reentrantLock.unlock();
        }
    }

    private void addOutdatedUrl(Uri url) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.outdatedUrls.add(url);
        } finally {
            reentrantLock.unlock();
        }
    }

    private void addUrlMapping(Uri from, Uri to) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.locationMap.put(from, to);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    private Uri resolveUrlMapping(Uri url) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Uri uri = (Uri) this.locationMap.get(url);
            if (uri != null) {
                url = uri;
            }
            return url;
        } finally {
            reentrantLock.unlock();
        }
    }
}
