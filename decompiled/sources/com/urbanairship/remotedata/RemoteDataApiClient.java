package com.urbanairship.remotedata;

import android.net.Uri;
import ch.qos.logback.core.CoreConstants;
import com.allegion.accesssdk.BuildConfig;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.Request;
import com.urbanairship.http.RequestAuth;
import com.urbanairship.http.RequestResult;
import com.urbanairship.http.ResponseParser;
import com.urbanairship.http.SuspendingRequestSession;
import com.urbanairship.http.SuspendingRequestSessionKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001dB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JH\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00120\u0011H\u0080@¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/remotedata/RemoteDataApiClient;", "", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", BuildConfig.SESSION_KEY_REFERENCE, "Lcom/urbanairship/http/SuspendingRequestSession;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/http/SuspendingRequestSession;)V", "fetch", "Lcom/urbanairship/http/RequestResult;", "Lcom/urbanairship/remotedata/RemoteDataApiClient$Result;", "remoteDataUrl", "Landroid/net/Uri;", "auth", "Lcom/urbanairship/http/RequestAuth;", "lastModified", "", "remoteDataInfoFactory", "Lkotlin/Function1;", "Lcom/urbanairship/remotedata/RemoteDataInfo;", "fetch$urbanairship_core_release", "(Landroid/net/Uri;Lcom/urbanairship/http/RequestAuth;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parsePayload", "Lcom/urbanairship/remotedata/RemoteDataPayload;", "json", "Lcom/urbanairship/json/JsonValue;", "remoteDataInfo", "parseResponse", "", "responseBody", "Result", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRemoteDataApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteDataApiClient.kt\ncom/urbanairship/remotedata/RemoteDataApiClient\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,90:1\n44#2,15:91\n44#2,15:106\n79#2,16:121\n1549#3:137\n1620#3,3:138\n*S KotlinDebug\n*F\n+ 1 RemoteDataApiClient.kt\ncom/urbanairship/remotedata/RemoteDataApiClient\n*L\n66#1:91,15\n67#1:106,15\n74#1:121,16\n85#1:137\n85#1:138,3\n*E\n"})
/* loaded from: classes5.dex */
public final class RemoteDataApiClient {
    private final AirshipRuntimeConfig config;
    private final SuspendingRequestSession session;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RemoteDataApiClient(@NotNull AirshipRuntimeConfig config) {
        this(config, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(config, "config");
    }

    @JvmOverloads
    public RemoteDataApiClient(@NotNull AirshipRuntimeConfig config, @NotNull SuspendingRequestSession session) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(session, "session");
        this.config = config;
        this.session = session;
    }

    public /* synthetic */ RemoteDataApiClient(AirshipRuntimeConfig airshipRuntimeConfig, SuspendingRequestSession suspendingRequestSession, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(airshipRuntimeConfig, (i & 2) != 0 ? SuspendingRequestSessionKt.toSuspendingRequestSession(airshipRuntimeConfig.getRequestSession()) : suspendingRequestSession);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/remotedata/RemoteDataApiClient$Result;", "", "remoteDataInfo", "Lcom/urbanairship/remotedata/RemoteDataInfo;", "payloads", "", "Lcom/urbanairship/remotedata/RemoteDataPayload;", "(Lcom/urbanairship/remotedata/RemoteDataInfo;Ljava/util/Set;)V", "getPayloads", "()Ljava/util/Set;", "getRemoteDataInfo", "()Lcom/urbanairship/remotedata/RemoteDataInfo;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Result {
        private final Set payloads;
        private final RemoteDataInfo remoteDataInfo;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Result copy$default(Result result, RemoteDataInfo remoteDataInfo, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                remoteDataInfo = result.remoteDataInfo;
            }
            if ((i & 2) != 0) {
                set = result.payloads;
            }
            return result.copy(remoteDataInfo, set);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final RemoteDataInfo getRemoteDataInfo() {
            return this.remoteDataInfo;
        }

        @NotNull
        public final Set<RemoteDataPayload> component2() {
            return this.payloads;
        }

        @NotNull
        public final Result copy(@NotNull RemoteDataInfo remoteDataInfo, @NotNull Set<RemoteDataPayload> payloads) {
            Intrinsics.checkNotNullParameter(remoteDataInfo, "remoteDataInfo");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            return new Result(remoteDataInfo, payloads);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return Intrinsics.areEqual(this.remoteDataInfo, result.remoteDataInfo) && Intrinsics.areEqual(this.payloads, result.payloads);
        }

        public int hashCode() {
            return (this.remoteDataInfo.hashCode() * 31) + this.payloads.hashCode();
        }

        @NotNull
        public String toString() {
            return "Result(remoteDataInfo=" + this.remoteDataInfo + ", payloads=" + this.payloads + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Result(@NotNull RemoteDataInfo remoteDataInfo, @NotNull Set<RemoteDataPayload> payloads) {
            Intrinsics.checkNotNullParameter(remoteDataInfo, "remoteDataInfo");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            this.remoteDataInfo = remoteDataInfo;
            this.payloads = payloads;
        }

        @NotNull
        public final RemoteDataInfo getRemoteDataInfo() {
            return this.remoteDataInfo;
        }

        @NotNull
        public final Set<RemoteDataPayload> getPayloads() {
            return this.payloads;
        }
    }

    @Nullable
    public final Object fetch$urbanairship_core_release(@Nullable Uri uri, @NotNull RequestAuth requestAuth, @Nullable String str, @NotNull final Function1<? super String, RemoteDataInfo> function1, @NotNull Continuation<? super RequestResult<Result>> continuation) {
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("X-UA-Appkey", this.config.getConfigOptions().appKey));
        if (str != null) {
            mapMutableMapOf.put("If-Modified-Since", str);
        }
        return this.session.execute(new Request(uri, "GET", requestAuth, null, mapMutableMapOf, false, 32, null), new ResponseParser() { // from class: com.urbanairship.remotedata.RemoteDataApiClient$$ExternalSyntheticLambda0
            @Override // com.urbanairship.http.ResponseParser
            public final Object parseResponse(int i, Map map, String str2) {
                return RemoteDataApiClient.fetch$lambda$1(function1, this, i, map, str2);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Result fetch$lambda$1(Function1 remoteDataInfoFactory, RemoteDataApiClient this$0, int i, Map responseHeaders, String str) {
        Intrinsics.checkNotNullParameter(remoteDataInfoFactory, "$remoteDataInfoFactory");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        if (i != 200) {
            return null;
        }
        RemoteDataInfo remoteDataInfo = (RemoteDataInfo) remoteDataInfoFactory.invoke(responseHeaders.get("Last-Modified"));
        return new Result(remoteDataInfo, this$0.parseResponse(str, remoteDataInfo));
    }

    /* JADX WARN: Removed duplicated region for block: B:191:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0167  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.urbanairship.remotedata.RemoteDataPayload parsePayload(com.urbanairship.json.JsonValue r25, com.urbanairship.remotedata.RemoteDataInfo r26) throws com.urbanairship.json.JsonException {
        /*
            Method dump skipped, instructions count: 1228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.remotedata.RemoteDataApiClient.parsePayload(com.urbanairship.json.JsonValue, com.urbanairship.remotedata.RemoteDataInfo):com.urbanairship.remotedata.RemoteDataPayload");
    }

    private final Set parseResponse(String responseBody, RemoteDataInfo remoteDataInfo) {
        if (responseBody == null) {
            return SetsKt.emptySet();
        }
        JsonList jsonListOptList = JsonValue.parseString(responseBody).optMap().opt("payloads").optList();
        Intrinsics.checkNotNullExpressionValue(jsonListOptList, "optList(...)");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptList, 10));
        for (JsonValue jsonValue : jsonListOptList) {
            Intrinsics.checkNotNull(jsonValue);
            arrayList.add(parsePayload(jsonValue, remoteDataInfo));
        }
        return CollectionsKt.toSet(arrayList);
    }
}
