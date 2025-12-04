package com.contentsquare.android.sdk;

import android.content.Context;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.FileStorageUtil;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.contentsquare.android.internal.core.telemetry.event.StatisticRecord;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTelemetryTimeStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelemetryTimeStorage.kt\ncom/contentsquare/android/internal/core/telemetry/storage/TelemetryTimeStorage\n+ 2 SerialFormat.kt\nkotlinx/serialization/SerialFormatKt\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,90:1\n113#2:91\n96#3:92\n215#4,2:93\n*S KotlinDebug\n*F\n+ 1 TelemetryTimeStorage.kt\ncom/contentsquare/android/internal/core/telemetry/storage/TelemetryTimeStorage\n*L\n35#1:91\n52#1:92\n82#1:93,2\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.t7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0817t7 implements InterfaceC0797r7<Map<String, ? extends StatisticRecord>> {

    @NotNull
    public final FileStorageUtil a;

    @NotNull
    public final Logger b;

    @NotNull
    public final LinkedHashMap c;

    @NotNull
    public final String d;

    @NotNull
    public final String e;

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.storage.TelemetryTimeStorage", f = "TelemetryTimeStorage.kt", i = {}, l = {63}, m = "fetch", n = {}, s = {})
    /* renamed from: com.contentsquare.android.sdk.t7$a */
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
            return C0817t7.this.a(this);
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.storage.TelemetryTimeStorage", f = "TelemetryTimeStorage.kt", i = {0, 0}, l = {31}, m = "store", n = {"this", "data"}, s = {"L$0", "L$1"})
    /* renamed from: com.contentsquare.android.sdk.t7$b */
    public static final class b extends ContinuationImpl {
        public C0817t7 a;
        public Map b;
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
            return C0817t7.this.a((Map<String, StatisticRecord>) null, this);
        }
    }

    public C0817t7(@NotNull Context applicationContext, @NotNull FileStorageUtil fileStorageUtil) {
        Intrinsics.checkNotNullParameter(fileStorageUtil, "fileStorageUtil");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.a = fileStorageUtil;
        this.b = new Logger("TelemetryTimeStorage");
        this.c = new LinkedHashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(applicationContext.getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("cs");
        sb.append(str);
        sb.append(JsonConfigFeatureFlagNames.TELEMETRY);
        String string = sb.toString();
        this.d = string;
        this.e = string + str + "time";
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC0797r7
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends com.contentsquare.android.internal.core.telemetry.event.StatisticRecord>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.contentsquare.android.sdk.C0817t7.a
            if (r0 == 0) goto L13
            r0 = r8
            com.contentsquare.android.sdk.t7$a r0 = (com.contentsquare.android.sdk.C0817t7.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.t7$a r0 = new com.contentsquare.android.sdk.t7$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)
            goto La0
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.LinkedHashMap r8 = r7.c     // Catch: java.lang.Exception -> L40
            boolean r8 = r8.isEmpty()     // Catch: java.lang.Exception -> L40
            if (r8 != 0) goto L42
            java.util.LinkedHashMap r7 = r7.c     // Catch: java.lang.Exception -> L40
            return r7
        L40:
            r8 = move-exception
            goto L90
        L42:
            com.contentsquare.android.core.utils.FileStorageUtil r8 = r7.a     // Catch: java.lang.Exception -> L40
            java.lang.String r2 = r7.e     // Catch: java.lang.Exception -> L40
            java.util.List r8 = r8.readFileContentByLine(r2)     // Catch: java.lang.Exception -> L40
            boolean r2 = r8.isEmpty()     // Catch: java.lang.Exception -> L40
            if (r2 != 0) goto L8b
            r2 = 0
            java.lang.Object r4 = r8.get(r2)     // Catch: java.lang.Exception -> L40
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L40
            java.lang.CharSequence r4 = kotlin.text.StringsKt.trim(r4)     // Catch: java.lang.Exception -> L40
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L40
            int r4 = r4.length()     // Catch: java.lang.Exception -> L40
            if (r4 <= 0) goto L8b
            kotlinx.serialization.json.Json$Default r4 = kotlinx.serialization.json.Json.INSTANCE     // Catch: java.lang.Exception -> L40
            java.lang.Object r8 = r8.get(r2)     // Catch: java.lang.Exception -> L40
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> L40
            r4.getSerializersModule()     // Catch: java.lang.Exception -> L40
            kotlinx.serialization.internal.LinkedHashMapSerializer r2 = new kotlinx.serialization.internal.LinkedHashMapSerializer     // Catch: java.lang.Exception -> L40
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.INSTANCE     // Catch: java.lang.Exception -> L40
            com.contentsquare.android.internal.core.telemetry.event.StatisticRecord$a r6 = com.contentsquare.android.internal.core.telemetry.event.StatisticRecord.Companion     // Catch: java.lang.Exception -> L40
            kotlinx.serialization.KSerializer r6 = r6.serializer()     // Catch: java.lang.Exception -> L40
            r2.<init>(r5, r6)     // Catch: java.lang.Exception -> L40
            java.lang.Object r8 = r4.decodeFromString(r2, r8)     // Catch: java.lang.Exception -> L40
            java.util.Map r8 = (java.util.Map) r8     // Catch: java.lang.Exception -> L40
            java.util.LinkedHashMap r2 = r7.c     // Catch: java.lang.Exception -> L40
            r2.putAll(r8)     // Catch: java.lang.Exception -> L40
            java.util.LinkedHashMap r7 = r7.c     // Catch: java.lang.Exception -> L40
            goto L8f
        L8b:
            java.util.Map r7 = kotlin.collections.MapsKt.emptyMap()     // Catch: java.lang.Exception -> L40
        L8f:
            return r7
        L90:
            com.contentsquare.android.core.features.logging.Logger r2 = r7.b
            java.lang.String r4 = "Failed to decode JSON from file"
            com.contentsquare.android.sdk.Q2.a(r2, r4, r8)
            r0.c = r3
            kotlin.Unit r7 = r7.clear()
            if (r7 != r1) goto La0
            return r1
        La0:
            java.util.Map r7 = kotlin.collections.MapsKt.emptyMap()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0817t7.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0797r7
    @Nullable
    public final Unit clear() {
        try {
            this.c.clear();
            this.a.deleteFileOrFolder(this.e);
        } catch (Exception e) {
            Q2.a(this.b, "Failed to delete file from path:" + this.e, e);
        }
        return Unit.INSTANCE;
    }

    public static void a(LinkedHashMap linkedHashMap, Map map) {
        Unit unit;
        for (Map.Entry entry : map.entrySet()) {
            StatisticRecord statisticRecord = (StatisticRecord) linkedHashMap.get(entry.getKey());
            if (statisticRecord != null) {
                Object key = entry.getKey();
                StatisticRecord.a aVar = StatisticRecord.Companion;
                StatisticRecord statisticRecord2 = (StatisticRecord) entry.getValue();
                aVar.getClass();
                linkedHashMap.put(key, StatisticRecord.a.a(statisticRecord2, statisticRecord));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC0797r7
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, com.contentsquare.android.internal.core.telemetry.event.StatisticRecord> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.contentsquare.android.sdk.C0817t7.b
            if (r0 == 0) goto L13
            r0 = r6
            com.contentsquare.android.sdk.t7$b r0 = (com.contentsquare.android.sdk.C0817t7.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.t7$b r0 = new com.contentsquare.android.sdk.t7$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.util.Map r5 = r0.b
            com.contentsquare.android.sdk.t7 r4 = r0.a
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L2d
            goto L58
        L2d:
            r5 = move-exception
            goto L89
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.isEmpty()     // Catch: java.lang.Exception -> L2d
            if (r6 == 0) goto L43
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L2d
            return r4
        L43:
            java.util.LinkedHashMap r6 = r4.c     // Catch: java.lang.Exception -> L2d
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Exception -> L2d
            if (r6 == 0) goto L58
            r0.a = r4     // Catch: java.lang.Exception -> L2d
            r0.b = r5     // Catch: java.lang.Exception -> L2d
            r0.e = r3     // Catch: java.lang.Exception -> L2d
            java.lang.Object r6 = r4.a(r0)     // Catch: java.lang.Exception -> L2d
            if (r6 != r1) goto L58
            return r1
        L58:
            java.util.LinkedHashMap r6 = r4.c     // Catch: java.lang.Exception -> L2d
            a(r6, r5)     // Catch: java.lang.Exception -> L2d
            com.contentsquare.android.core.utils.FileStorageUtil r5 = r4.a     // Catch: java.lang.Exception -> L2d
            java.lang.String r6 = r4.d     // Catch: java.lang.Exception -> L2d
            r5.mkdirs(r6)     // Catch: java.lang.Exception -> L2d
            kotlinx.serialization.json.Json$Default r5 = kotlinx.serialization.json.Json.INSTANCE     // Catch: java.lang.Exception -> L2d
            java.util.LinkedHashMap r6 = r4.c     // Catch: java.lang.Exception -> L2d
            r5.getSerializersModule()     // Catch: java.lang.Exception -> L2d
            kotlinx.serialization.internal.LinkedHashMapSerializer r0 = new kotlinx.serialization.internal.LinkedHashMapSerializer     // Catch: java.lang.Exception -> L2d
            kotlinx.serialization.internal.StringSerializer r1 = kotlinx.serialization.internal.StringSerializer.INSTANCE     // Catch: java.lang.Exception -> L2d
            com.contentsquare.android.internal.core.telemetry.event.StatisticRecord$a r2 = com.contentsquare.android.internal.core.telemetry.event.StatisticRecord.Companion     // Catch: java.lang.Exception -> L2d
            kotlinx.serialization.KSerializer r2 = r2.serializer()     // Catch: java.lang.Exception -> L2d
            r0.<init>(r1, r2)     // Catch: java.lang.Exception -> L2d
            java.lang.String r5 = r5.encodeToString(r0, r6)     // Catch: java.lang.Exception -> L2d
            com.contentsquare.android.core.utils.FileStorageUtil r6 = r4.a     // Catch: java.lang.Exception -> L2d
            java.lang.String r0 = r4.e     // Catch: java.lang.Exception -> L2d
            byte[] r5 = kotlin.text.StringsKt.encodeToByteArray(r5)     // Catch: java.lang.Exception -> L2d
            r1 = 0
            r6.writeBytesToFile(r0, r5, r1)     // Catch: java.lang.Exception -> L2d
            goto L90
        L89:
            com.contentsquare.android.core.features.logging.Logger r4 = r4.b
            java.lang.String r6 = "Failed to store Telemetry time event to file"
            com.contentsquare.android.sdk.Q2.a(r4, r6, r5)
        L90:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0817t7.a(java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
