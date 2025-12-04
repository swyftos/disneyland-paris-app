package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.http.HttpResponse;
import com.contentsquare.android.core.utils.UriBuilder;
import com.contentsquare.android.internal.core.logmonitor.processing.LogMessage;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.internal.core.logmonitor.processing.LogProcessor$sendLogs$1", f = "LogProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nLogProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LogProcessor.kt\ncom/contentsquare/android/internal/core/logmonitor/processing/LogProcessor$sendLogs$1\n+ 2 SerialFormat.kt\nkotlinx/serialization/SerialFormatKt\n*L\n1#1,93:1\n113#2:94\n*S KotlinDebug\n*F\n+ 1 LogProcessor.kt\ncom/contentsquare/android/internal/core/logmonitor/processing/LogProcessor$sendLogs$1\n*L\n74#1:94\n*E\n"})
/* loaded from: classes2.dex */
public final class N2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ O2 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N2(O2 o2, Continuation<? super N2> continuation) {
        super(2, continuation);
        this.a = o2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new N2(this.a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new N2(this.a, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.ArrayList] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ?? EmptyList;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        P2 p2 = this.a.b;
        p2.getClass();
        try {
            List<String> fileContentByLine = p2.b.readFileContentByLine(p2.e);
            EmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fileContentByLine, 10));
            for (String str : fileContentByLine) {
                Json.Companion companion = Json.INSTANCE;
                companion.getSerializersModule();
                EmptyList.add((LogMessage) companion.decodeFromString(LogMessage.Companion.serializer(), str));
            }
        } catch (Throwable th) {
            p2.c.e("Failed to read log file at path: " + p2.e + " | error message: " + th.getMessage());
            EmptyList = CollectionsKt.emptyList();
        }
        if (!EmptyList.isEmpty()) {
            this.a.d.d("Sending " + EmptyList.size() + " log events");
            String strBuildLogMonitorUrl = UriBuilder.buildLogMonitorUrl("release");
            Json.Companion companion2 = Json.INSTANCE;
            companion2.getSerializersModule();
            HttpResponse httpResponsePerformPostWithJson$default = HttpConnection.performPostWithJson$default(this.a.a, strBuildLogMonitorUrl, companion2.encodeToString(new ArrayListSerializer(LogMessage.Companion.serializer()), EmptyList), null, 4, null);
            if (httpResponsePerformPostWithJson$default.success()) {
                this.a.d.d("Log events successfully sent.");
                this.a.b.a();
                this.a.e.set(0);
            } else {
                this.a.d.e("Could not send the logs. HTTP status:" + httpResponsePerformPostWithJson$default.getStatus() + " response:" + httpResponsePerformPostWithJson$default.getException());
            }
        }
        return Unit.INSTANCE;
    }
}
