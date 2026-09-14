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
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007B)\b\u0000\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\fJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\u0015J$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0015J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, m1836d2 = {"Lcom/urbanairship/channel/ChannelAuthTokenProvider;", "Lcom/urbanairship/http/AuthTokenProvider;", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "channelIDProvider", "Lkotlin/Function0;", "", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lkotlin/jvm/functions/Function0;)V", "apiClient", "Lcom/urbanairship/channel/ChannelAuthApiClient;", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/channel/ChannelAuthApiClient;Lcom/urbanairship/util/Clock;Lkotlin/jvm/functions/Function0;)V", "cachedAuth", "Lcom/urbanairship/util/CachedValue;", "Lcom/urbanairship/http/AuthToken;", "queue", "Lcom/urbanairship/util/SerialQueue;", "expireToken", "", "token", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchToken", "Lkotlin/Result;", "identifier", "fetchToken-gIAlu-s", "getCachedToken", "channelId", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
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
        if (authToken != null && Intrinsics.areEqual(channelId, authToken.getIdentifier()) && this.clock.currentTimeMillis() <= authToken.getExpirationDateMillis() - ((long) 30000)) {
            return authToken.getToken();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.urbanairship.http.AuthTokenProvider
    @Nullable
    /* JADX INFO: renamed from: fetchToken-gIAlu-s, reason: not valid java name */
    public Object mo5075fetchTokengIAlus(@NotNull String str, @NotNull Continuation<? super Result<String>> continuation) {
        ChannelAuthTokenProvider$fetchToken$1 channelAuthTokenProvider$fetchToken$1;
        if (continuation instanceof ChannelAuthTokenProvider$fetchToken$1) {
            channelAuthTokenProvider$fetchToken$1 = (ChannelAuthTokenProvider$fetchToken$1) continuation;
            int i = channelAuthTokenProvider$fetchToken$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                channelAuthTokenProvider$fetchToken$1.label = i - Integer.MIN_VALUE;
            } else {
                channelAuthTokenProvider$fetchToken$1 = new ChannelAuthTokenProvider$fetchToken$1(this, continuation);
            }
        } else {
            channelAuthTokenProvider$fetchToken$1 = new ChannelAuthTokenProvider$fetchToken$1(this, continuation);
        }
        Object objRun = channelAuthTokenProvider$fetchToken$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = channelAuthTokenProvider$fetchToken$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objRun);
            SerialQueue serialQueue = this.queue;
            ChannelAuthTokenProvider$fetchToken$2 channelAuthTokenProvider$fetchToken$2 = new ChannelAuthTokenProvider$fetchToken$2(this, str, null);
            channelAuthTokenProvider$fetchToken$1.label = 1;
            objRun = serialQueue.run(channelAuthTokenProvider$fetchToken$2, channelAuthTokenProvider$fetchToken$1);
            if (objRun == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objRun);
        }
        return ((Result) objRun).getValue();
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
