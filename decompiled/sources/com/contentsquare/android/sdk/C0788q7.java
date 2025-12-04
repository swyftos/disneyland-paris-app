package com.contentsquare.android.sdk;

import android.content.Context;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.FileStorageUtil;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.contentsquare.android.internal.core.telemetry.event.StatisticRecord;
import com.contentsquare.android.sdk.O3;
import java.io.File;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTelemetryStatisticsStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelemetryStatisticsStorage.kt\ncom/contentsquare/android/internal/core/telemetry/storage/TelemetryStatisticsStorage\n+ 2 SerialFormat.kt\nkotlinx/serialization/SerialFormatKt\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,93:1\n113#2:94\n96#3:95\n*S KotlinDebug\n*F\n+ 1 TelemetryStatisticsStorage.kt\ncom/contentsquare/android/internal/core/telemetry/storage/TelemetryStatisticsStorage\n*L\n53#1:94\n70#1:95\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.q7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0788q7 implements InterfaceC0797r7<StatisticRecord> {

    @NotNull
    public final FileStorageUtil a;

    @NotNull
    public final String b;

    @NotNull
    public final Logger c;

    @NotNull
    public final String d;

    @Nullable
    public StatisticRecord e;

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.storage.TelemetryStatisticsStorage", f = "TelemetryStatisticsStorage.kt", i = {}, l = {80}, m = "fetch", n = {}, s = {})
    /* renamed from: com.contentsquare.android.sdk.q7$a */
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return C0788q7.this.a(this);
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.storage.TelemetryStatisticsStorage", f = "TelemetryStatisticsStorage.kt", i = {0, 0}, l = {45}, m = "store", n = {"this", "data"}, s = {"L$0", "L$1"})
    /* renamed from: com.contentsquare.android.sdk.q7$b */
    public static final class b extends ContinuationImpl {
        public C0788q7 a;
        public StatisticRecord b;
        public /* synthetic */ Object c;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return C0788q7.this.a((StatisticRecord) null, this);
        }
    }

    public C0788q7(@NotNull FileStorageUtil fileStorageUtil, @NotNull Context applicationContext, @NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileStorageUtil, "fileStorageUtil");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.a = fileStorageUtil;
        this.b = fileName;
        this.c = new Logger("TelemetryStatisticsStorage");
        StringBuilder sb = new StringBuilder();
        sb.append(applicationContext.getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("cs");
        sb.append(str);
        sb.append(JsonConfigFeatureFlagNames.TELEMETRY);
        this.d = sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC0797r7
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.contentsquare.android.internal.core.telemetry.event.StatisticRecord> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.contentsquare.android.sdk.C0788q7.a
            if (r0 == 0) goto L13
            r0 = r7
            com.contentsquare.android.sdk.q7$a r0 = (com.contentsquare.android.sdk.C0788q7.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.q7$a r0 = new com.contentsquare.android.sdk.q7$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L33
            if (r2 != r4) goto L2b
            kotlin.ResultKt.throwOnFailure(r7)
            goto La6
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            com.contentsquare.android.internal.core.telemetry.event.StatisticRecord r7 = r6.e     // Catch: java.lang.Exception -> L93
            if (r7 == 0) goto L3b
            return r7
        L3b:
            com.contentsquare.android.core.utils.FileStorageUtil r7 = r6.a     // Catch: java.lang.Exception -> L93
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L93
            r2.<init>()     // Catch: java.lang.Exception -> L93
            java.lang.String r5 = r6.d     // Catch: java.lang.Exception -> L93
            r2.append(r5)     // Catch: java.lang.Exception -> L93
            java.lang.String r5 = java.io.File.separator     // Catch: java.lang.Exception -> L93
            r2.append(r5)     // Catch: java.lang.Exception -> L93
            java.lang.String r5 = r6.b     // Catch: java.lang.Exception -> L93
            r2.append(r5)     // Catch: java.lang.Exception -> L93
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L93
            java.util.List r7 = r7.readFileContentByLine(r2)     // Catch: java.lang.Exception -> L93
            boolean r2 = r7.isEmpty()     // Catch: java.lang.Exception -> L93
            if (r2 != 0) goto L95
            r2 = 0
            java.lang.Object r5 = r7.get(r2)     // Catch: java.lang.Exception -> L93
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L93
            java.lang.CharSequence r5 = kotlin.text.StringsKt.trim(r5)     // Catch: java.lang.Exception -> L93
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L93
            int r5 = r5.length()     // Catch: java.lang.Exception -> L93
            if (r5 <= 0) goto L95
            kotlinx.serialization.json.Json$Default r5 = kotlinx.serialization.json.Json.INSTANCE     // Catch: java.lang.Exception -> L93
            java.lang.Object r7 = r7.get(r2)     // Catch: java.lang.Exception -> L93
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Exception -> L93
            r5.getSerializersModule()     // Catch: java.lang.Exception -> L93
            com.contentsquare.android.internal.core.telemetry.event.StatisticRecord$a r2 = com.contentsquare.android.internal.core.telemetry.event.StatisticRecord.Companion     // Catch: java.lang.Exception -> L93
            kotlinx.serialization.KSerializer r2 = r2.serializer()     // Catch: java.lang.Exception -> L93
            kotlinx.serialization.KSerializer r2 = kotlinx.serialization.builtins.BuiltinSerializersKt.getNullable(r2)     // Catch: java.lang.Exception -> L93
            java.lang.Object r7 = r5.decodeFromString(r2, r7)     // Catch: java.lang.Exception -> L93
            com.contentsquare.android.internal.core.telemetry.event.StatisticRecord r7 = (com.contentsquare.android.internal.core.telemetry.event.StatisticRecord) r7     // Catch: java.lang.Exception -> L93
            r6.e = r7     // Catch: java.lang.Exception -> L93
            r3 = r7
            goto L95
        L93:
            r7 = move-exception
            goto L96
        L95:
            return r3
        L96:
            com.contentsquare.android.core.features.logging.Logger r2 = r6.c
            java.lang.String r5 = "Failed to decode JSON from file"
            com.contentsquare.android.sdk.Q2.a(r2, r5, r7)
            r0.c = r4
            kotlin.Unit r6 = r6.clear()
            if (r6 != r1) goto La6
            return r1
        La6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0788q7.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0797r7
    @Nullable
    public final Unit clear() {
        try {
            this.e = null;
            this.a.deleteFileOrFolder(this.d + File.separator + this.b);
        } catch (Exception e) {
            Logger logger = this.c;
            StringBuilder sb = new StringBuilder("Failed to delete file from path:");
            sb.append(this.d + File.separator + this.b);
            Q2.a(logger, sb.toString(), e);
        }
        return Unit.INSTANCE;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0797r7
    public final /* bridge */ /* synthetic */ Object a(StatisticRecord statisticRecord, O3.e eVar) {
        return a(statisticRecord, (Continuation<? super Unit>) eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.Nullable com.contentsquare.android.internal.core.telemetry.event.StatisticRecord r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.contentsquare.android.sdk.C0788q7.b
            if (r0 == 0) goto L13
            r0 = r6
            com.contentsquare.android.sdk.q7$b r0 = (com.contentsquare.android.sdk.C0788q7.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.q7$b r0 = new com.contentsquare.android.sdk.q7$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            com.contentsquare.android.internal.core.telemetry.event.StatisticRecord r5 = r0.b
            com.contentsquare.android.sdk.q7 r4 = r0.a
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L2d
            goto L51
        L2d:
            r5 = move-exception
            goto La7
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            kotlin.ResultKt.throwOnFailure(r6)
            if (r5 != 0) goto L40
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L2d
            return r4
        L40:
            com.contentsquare.android.internal.core.telemetry.event.StatisticRecord r6 = r4.e     // Catch: java.lang.Exception -> L2d
            if (r6 != 0) goto L51
            r0.a = r4     // Catch: java.lang.Exception -> L2d
            r0.b = r5     // Catch: java.lang.Exception -> L2d
            r0.e = r3     // Catch: java.lang.Exception -> L2d
            java.lang.Object r6 = r4.a(r0)     // Catch: java.lang.Exception -> L2d
            if (r6 != r1) goto L51
            return r1
        L51:
            com.contentsquare.android.internal.core.telemetry.event.StatisticRecord$a r6 = com.contentsquare.android.internal.core.telemetry.event.StatisticRecord.Companion     // Catch: java.lang.Exception -> L2d
            com.contentsquare.android.internal.core.telemetry.event.StatisticRecord r0 = r4.e     // Catch: java.lang.Exception -> L2d
            r6.getClass()     // Catch: java.lang.Exception -> L2d
            com.contentsquare.android.internal.core.telemetry.event.StatisticRecord r5 = com.contentsquare.android.internal.core.telemetry.event.StatisticRecord.a.a(r5, r0)     // Catch: java.lang.Exception -> L2d
            com.contentsquare.android.internal.core.telemetry.event.StatisticRecord r0 = r4.e     // Catch: java.lang.Exception -> L2d
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)     // Catch: java.lang.Exception -> L2d
            if (r0 == 0) goto L67
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L2d
            return r4
        L67:
            com.contentsquare.android.core.utils.FileStorageUtil r0 = r4.a     // Catch: java.lang.Exception -> L2d
            java.lang.String r1 = r4.d     // Catch: java.lang.Exception -> L2d
            r0.mkdirs(r1)     // Catch: java.lang.Exception -> L2d
            com.contentsquare.android.core.utils.FileStorageUtil r0 = r4.a     // Catch: java.lang.Exception -> L2d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2d
            r1.<init>()     // Catch: java.lang.Exception -> L2d
            java.lang.String r2 = r4.d     // Catch: java.lang.Exception -> L2d
            r1.append(r2)     // Catch: java.lang.Exception -> L2d
            java.lang.String r2 = java.io.File.separator     // Catch: java.lang.Exception -> L2d
            r1.append(r2)     // Catch: java.lang.Exception -> L2d
            java.lang.String r2 = r4.b     // Catch: java.lang.Exception -> L2d
            r1.append(r2)     // Catch: java.lang.Exception -> L2d
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L2d
            kotlinx.serialization.json.Json$Default r2 = kotlinx.serialization.json.Json.INSTANCE     // Catch: java.lang.Exception -> L2d
            r2.getSerializersModule()     // Catch: java.lang.Exception -> L2d
            kotlinx.serialization.KSerializer r6 = r6.serializer()     // Catch: java.lang.Exception -> L2d
            java.lang.String r6 = r2.encodeToString(r6, r5)     // Catch: java.lang.Exception -> L2d
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8     // Catch: java.lang.Exception -> L2d
            byte[] r6 = r6.getBytes(r2)     // Catch: java.lang.Exception -> L2d
            java.lang.String r2 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)     // Catch: java.lang.Exception -> L2d
            r2 = 0
            r0.writeBytesToFile(r1, r6, r2)     // Catch: java.lang.Exception -> L2d
            r4.e = r5     // Catch: java.lang.Exception -> L2d
            goto Lae
        La7:
            com.contentsquare.android.core.features.logging.Logger r4 = r4.c
            java.lang.String r6 = "Failed to store Telemetry statistics event to file"
            com.contentsquare.android.sdk.Q2.a(r4, r6, r5)
        Lae:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0788q7.a(com.contentsquare.android.internal.core.telemetry.event.StatisticRecord, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
