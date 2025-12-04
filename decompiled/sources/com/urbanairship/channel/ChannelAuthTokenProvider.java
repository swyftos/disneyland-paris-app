package com.urbanairship.channel;

import androidx.annotation.RestrictTo;
import androidx.core.util.Predicate;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.AuthToken;
import com.urbanairship.http.AuthTokenProvider;
import com.urbanairship.util.CachedValue;
import com.urbanairship.util.Clock;
import com.urbanairship.util.SerialQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007B)\b\u0000\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\fJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\u0015J$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0015J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/channel/ChannelAuthTokenProvider;", "Lcom/urbanairship/http/AuthTokenProvider;", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "channelIDProvider", "Lkotlin/Function0;", "", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lkotlin/jvm/functions/Function0;)V", "apiClient", "Lcom/urbanairship/channel/ChannelAuthApiClient;", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/channel/ChannelAuthApiClient;Lcom/urbanairship/util/Clock;Lkotlin/jvm/functions/Function0;)V", "cachedAuth", "Lcom/urbanairship/util/CachedValue;", "Lcom/urbanairship/http/AuthToken;", "queue", "Lcom/urbanairship/util/SerialQueue;", "expireToken", "", "token", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchToken", "Lkotlin/Result;", "identifier", "fetchToken-gIAlu-s", "getCachedToken", "channelId", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class ChannelAuthTokenProvider implements AuthTokenProvider {
    private final ChannelAuthApiClient apiClient;
    private CachedValue cachedAuth;
    private final Function0 channelIDProvider;
    private final Clock clock;
    private SerialQueue queue;

    public ChannelAuthTokenProvider(@NotNull ChannelAuthApiClient apiClient, @NotNull Clock clock, @NotNull Function0<String> channelIDProvider) {
        Intrinsics.checkNotNullParameter(apiClient, "apiClient");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(channelIDProvider, "channelIDProvider");
        this.apiClient = apiClient;
        this.clock = clock;
        this.channelIDProvider = channelIDProvider;
        this.cachedAuth = new CachedValue(clock);
        this.queue = new SerialQueue();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ChannelAuthTokenProvider(ChannelAuthApiClient channelAuthApiClient, Clock DEFAULT_CLOCK, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(channelAuthApiClient, DEFAULT_CLOCK, function0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ChannelAuthTokenProvider(@NotNull AirshipRuntimeConfig runtimeConfig, @NotNull Function0<String> channelIDProvider) {
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(channelIDProvider, "channelIDProvider");
        DefaultConstructorMarker defaultConstructorMarker = null;
        byte b = 0 == true ? 1 : 0;
        this(new ChannelAuthApiClient(runtimeConfig, null, null, 6, defaultConstructorMarker), b, channelIDProvider, 2, defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCachedToken(String channelId) {
        AuthToken authToken = (AuthToken) this.cachedAuth.get();
        if (authToken != null && Intrinsics.areEqual(channelId, authToken.getIdentifier()) && this.clock.currentTimeMillis() <= authToken.getExpirationDateMillis() - 30000) {
            return authToken.getToken();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbanairship.http.AuthTokenProvider
    @org.jetbrains.annotations.Nullable
    /* renamed from: fetchToken-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo2833fetchTokengIAlus(@org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.urbanairship.channel.ChannelAuthTokenProvider$fetchToken$1
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.channel.ChannelAuthTokenProvider$fetchToken$1 r0 = (com.urbanairship.channel.ChannelAuthTokenProvider$fetchToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.channel.ChannelAuthTokenProvider$fetchToken$1 r0 = new com.urbanairship.channel.ChannelAuthTokenProvider$fetchToken$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            com.urbanairship.util.SerialQueue r7 = r5.queue
            com.urbanairship.channel.ChannelAuthTokenProvider$fetchToken$2 r2 = new com.urbanairship.channel.ChannelAuthTokenProvider$fetchToken$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.label = r3
            java.lang.Object r7 = r7.run(r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.getValue()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.ChannelAuthTokenProvider.mo2833fetchTokengIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.urbanairship.http.AuthTokenProvider
    @Nullable
    public Object expireToken(@NotNull final String str, @NotNull Continuation<? super Unit> continuation) {
        this.cachedAuth.expireIf(new Predicate() { // from class: com.urbanairship.channel.ChannelAuthTokenProvider$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return ChannelAuthTokenProvider.expireToken$lambda$0(str, (AuthToken) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean expireToken$lambda$0(String token, AuthToken authToken) {
        Intrinsics.checkNotNullParameter(token, "$token");
        return Intrinsics.areEqual(token, authToken.getToken());
    }
}
