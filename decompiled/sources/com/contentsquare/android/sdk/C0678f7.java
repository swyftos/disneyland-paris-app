package com.contentsquare.android.sdk;

import android.content.Context;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.FileStorageUtil;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTelemetryEventStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TelemetryEventStorage.kt\ncom/contentsquare/android/internal/core/telemetry/storage/TelemetryEventStorage\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SerialFormat.kt\nkotlinx/serialization/SerialFormatKt\n+ 4 Json.kt\nkotlinx/serialization/json/Json\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,98:1\n1855#2,2:99\n2634#2:103\n113#3:101\n96#4:102\n1#5:104\n*S KotlinDebug\n*F\n+ 1 TelemetryEventStorage.kt\ncom/contentsquare/android/internal/core/telemetry/storage/TelemetryEventStorage\n*L\n49#1:99,2\n74#1:103\n57#1:101\n74#1:102\n74#1:104\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.f7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0678f7 implements InterfaceC0797r7<List<? extends com.contentsquare.android.internal.core.telemetry.event.a>> {

    @NotNull
    public final FileStorageUtil a;

    @NotNull
    public final String b;

    @NotNull
    public final Logger c;

    @NotNull
    public final String d;

    @NotNull
    public final LinkedHashMap e;

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.storage.TelemetryEventStorage", f = "TelemetryEventStorage.kt", i = {}, l = {JpegTranscoderUtils.DEFAULT_JPEG_QUALITY}, m = "fetch", n = {}, s = {})
    /* renamed from: com.contentsquare.android.sdk.f7$a */
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
            return C0678f7.this.a(this);
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.storage.TelemetryEventStorage", f = "TelemetryEventStorage.kt", i = {0, 0}, l = {46}, m = "store", n = {"this", "data"}, s = {"L$0", "L$1"})
    /* renamed from: com.contentsquare.android.sdk.f7$b */
    public static final class b extends ContinuationImpl {
        public C0678f7 a;
        public List b;
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
            return C0678f7.this.a((List<? extends com.contentsquare.android.internal.core.telemetry.event.a>) null, this);
        }
    }

    public C0678f7(@NotNull FileStorageUtil fileStorageUtil, @NotNull Context context, @NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileStorageUtil, "fileStorageUtil");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.a = fileStorageUtil;
        this.b = fileName;
        this.c = new Logger("TelemetryEventStorage");
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("cs");
        sb.append(str);
        sb.append(JsonConfigFeatureFlagNames.TELEMETRY);
        this.d = sb.toString();
        this.e = new LinkedHashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC0797r7
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends com.contentsquare.android.internal.core.telemetry.event.a>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.contentsquare.android.sdk.C0678f7.a
            if (r0 == 0) goto L13
            r0 = r8
            com.contentsquare.android.sdk.f7$a r0 = (com.contentsquare.android.sdk.C0678f7.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.f7$a r0 = new com.contentsquare.android.sdk.f7$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)
            goto Lcb
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.LinkedHashMap r8 = r7.e     // Catch: java.lang.Exception -> L48
            boolean r8 = r8.isEmpty()     // Catch: java.lang.Exception -> L48
            if (r8 != 0) goto L4a
            java.util.LinkedHashMap r8 = r7.e     // Catch: java.lang.Exception -> L48
            java.util.Collection r8 = r8.values()     // Catch: java.lang.Exception -> L48
            java.util.List r7 = kotlin.collections.CollectionsKt.toList(r8)     // Catch: java.lang.Exception -> L48
            return r7
        L48:
            r8 = move-exception
            goto Lbb
        L4a:
            com.contentsquare.android.core.utils.FileStorageUtil r8 = r7.a     // Catch: java.lang.Exception -> L48
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L48
            r2.<init>()     // Catch: java.lang.Exception -> L48
            java.lang.String r4 = r7.d     // Catch: java.lang.Exception -> L48
            r2.append(r4)     // Catch: java.lang.Exception -> L48
            java.lang.String r4 = java.io.File.separator     // Catch: java.lang.Exception -> L48
            r2.append(r4)     // Catch: java.lang.Exception -> L48
            java.lang.String r4 = r7.b     // Catch: java.lang.Exception -> L48
            r2.append(r4)     // Catch: java.lang.Exception -> L48
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L48
            java.util.List r8 = r8.readFileContentByLine(r2)     // Catch: java.lang.Exception -> L48
            boolean r2 = r8.isEmpty()     // Catch: java.lang.Exception -> L48
            if (r2 != 0) goto Lb6
            r2 = 0
            java.lang.Object r8 = r8.get(r2)     // Catch: java.lang.Exception -> L48
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> L48
            java.lang.CharSequence r8 = kotlin.text.StringsKt.trim(r8)     // Catch: java.lang.Exception -> L48
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L48
            int r2 = r8.length()     // Catch: java.lang.Exception -> L48
            if (r2 <= 0) goto Lb6
            kotlinx.serialization.json.Json$Default r2 = kotlinx.serialization.json.Json.INSTANCE     // Catch: java.lang.Exception -> L48
            r2.getSerializersModule()     // Catch: java.lang.Exception -> L48
            kotlinx.serialization.internal.ArrayListSerializer r4 = new kotlinx.serialization.internal.ArrayListSerializer     // Catch: java.lang.Exception -> L48
            com.contentsquare.android.internal.core.telemetry.event.a$a r5 = com.contentsquare.android.internal.core.telemetry.event.a.Companion     // Catch: java.lang.Exception -> L48
            kotlinx.serialization.KSerializer r5 = r5.serializer()     // Catch: java.lang.Exception -> L48
            r4.<init>(r5)     // Catch: java.lang.Exception -> L48
            java.lang.Object r8 = r2.decodeFromString(r4, r8)     // Catch: java.lang.Exception -> L48
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch: java.lang.Exception -> L48
            java.util.Iterator r2 = r8.iterator()     // Catch: java.lang.Exception -> L48
        L9d:
            boolean r4 = r2.hasNext()     // Catch: java.lang.Exception -> L48
            if (r4 == 0) goto Lb3
            java.lang.Object r4 = r2.next()     // Catch: java.lang.Exception -> L48
            com.contentsquare.android.internal.core.telemetry.event.a r4 = (com.contentsquare.android.internal.core.telemetry.event.a) r4     // Catch: java.lang.Exception -> L48
            java.util.LinkedHashMap r5 = r7.e     // Catch: java.lang.Exception -> L48
            java.lang.String r6 = r4.getKey()     // Catch: java.lang.Exception -> L48
            r5.put(r6, r4)     // Catch: java.lang.Exception -> L48
            goto L9d
        Lb3:
            java.util.List r8 = (java.util.List) r8     // Catch: java.lang.Exception -> L48
            goto Lba
        Lb6:
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()     // Catch: java.lang.Exception -> L48
        Lba:
            return r8
        Lbb:
            com.contentsquare.android.core.features.logging.Logger r2 = r7.c
            java.lang.String r4 = "Failed to decode JSON from file"
            com.contentsquare.android.sdk.Q2.a(r2, r4, r8)
            r0.c = r3
            kotlin.Unit r7 = r7.clear()
            if (r7 != r1) goto Lcb
            return r1
        Lcb:
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0678f7.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0797r7
    @Nullable
    public final Unit clear() {
        try {
            this.e.clear();
            this.a.deleteFileOrFolder(this.d + File.separator + this.b);
        } catch (Exception e) {
            Logger logger = this.c;
            StringBuilder sb = new StringBuilder("Failed to delete file from path:");
            sb.append(this.d + File.separator + this.b);
            Q2.a(logger, sb.toString(), e);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC0797r7
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull java.util.List<? extends com.contentsquare.android.internal.core.telemetry.event.a> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.contentsquare.android.sdk.C0678f7.b
            if (r0 == 0) goto L13
            r0 = r6
            com.contentsquare.android.sdk.f7$b r0 = (com.contentsquare.android.sdk.C0678f7.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.f7$b r0 = new com.contentsquare.android.sdk.f7$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.util.List r5 = r0.b
            com.contentsquare.android.sdk.f7 r4 = r0.a
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L2d
            goto L59
        L2d:
            r5 = move-exception
            goto Le3
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.isEmpty()     // Catch: java.lang.Exception -> L2d
            if (r6 == 0) goto L44
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L2d
            return r4
        L44:
            java.util.LinkedHashMap r6 = r4.e     // Catch: java.lang.Exception -> L2d
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Exception -> L2d
            if (r6 == 0) goto L59
            r0.a = r4     // Catch: java.lang.Exception -> L2d
            r0.b = r5     // Catch: java.lang.Exception -> L2d
            r0.e = r3     // Catch: java.lang.Exception -> L2d
            java.lang.Object r6 = r4.a(r0)     // Catch: java.lang.Exception -> L2d
            if (r6 != r1) goto L59
            return r1
        L59:
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> L2d
        L5d:
            boolean r6 = r5.hasNext()     // Catch: java.lang.Exception -> L2d
            if (r6 == 0) goto L94
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Exception -> L2d
            com.contentsquare.android.internal.core.telemetry.event.a r6 = (com.contentsquare.android.internal.core.telemetry.event.a) r6     // Catch: java.lang.Exception -> L2d
            java.util.LinkedHashMap r0 = r4.e     // Catch: java.lang.Exception -> L2d
            java.lang.String r1 = r6.getKey()     // Catch: java.lang.Exception -> L2d
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> L2d
            com.contentsquare.android.internal.core.telemetry.event.a r0 = (com.contentsquare.android.internal.core.telemetry.event.a) r0     // Catch: java.lang.Exception -> L2d
            if (r0 == 0) goto L87
            java.util.LinkedHashMap r1 = r4.e     // Catch: java.lang.Exception -> L2d
            java.lang.String r2 = r6.getKey()     // Catch: java.lang.Exception -> L2d
            com.contentsquare.android.internal.core.telemetry.event.a r0 = r0.a(r6)     // Catch: java.lang.Exception -> L2d
            r1.put(r2, r0)     // Catch: java.lang.Exception -> L2d
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L2d
            goto L88
        L87:
            r0 = 0
        L88:
            if (r0 != 0) goto L5d
            java.util.LinkedHashMap r0 = r4.e     // Catch: java.lang.Exception -> L2d
            java.lang.String r1 = r6.getKey()     // Catch: java.lang.Exception -> L2d
            r0.put(r1, r6)     // Catch: java.lang.Exception -> L2d
            goto L5d
        L94:
            com.contentsquare.android.core.utils.FileStorageUtil r5 = r4.a     // Catch: java.lang.Exception -> L2d
            java.lang.String r6 = r4.d     // Catch: java.lang.Exception -> L2d
            r5.mkdirs(r6)     // Catch: java.lang.Exception -> L2d
            kotlinx.serialization.json.Json$Default r5 = kotlinx.serialization.json.Json.INSTANCE     // Catch: java.lang.Exception -> L2d
            java.util.LinkedHashMap r6 = r4.e     // Catch: java.lang.Exception -> L2d
            java.util.Collection r6 = r6.values()     // Catch: java.lang.Exception -> L2d
            java.util.List r6 = kotlin.collections.CollectionsKt.toList(r6)     // Catch: java.lang.Exception -> L2d
            r5.getSerializersModule()     // Catch: java.lang.Exception -> L2d
            kotlinx.serialization.internal.ArrayListSerializer r0 = new kotlinx.serialization.internal.ArrayListSerializer     // Catch: java.lang.Exception -> L2d
            com.contentsquare.android.internal.core.telemetry.event.a$a r1 = com.contentsquare.android.internal.core.telemetry.event.a.Companion     // Catch: java.lang.Exception -> L2d
            kotlinx.serialization.KSerializer r1 = r1.serializer()     // Catch: java.lang.Exception -> L2d
            r0.<init>(r1)     // Catch: java.lang.Exception -> L2d
            java.lang.String r5 = r5.encodeToString(r0, r6)     // Catch: java.lang.Exception -> L2d
            com.contentsquare.android.core.utils.FileStorageUtil r6 = r4.a     // Catch: java.lang.Exception -> L2d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2d
            r0.<init>()     // Catch: java.lang.Exception -> L2d
            java.lang.String r1 = r4.d     // Catch: java.lang.Exception -> L2d
            r0.append(r1)     // Catch: java.lang.Exception -> L2d
            java.lang.String r1 = java.io.File.separator     // Catch: java.lang.Exception -> L2d
            r0.append(r1)     // Catch: java.lang.Exception -> L2d
            java.lang.String r1 = r4.b     // Catch: java.lang.Exception -> L2d
            r0.append(r1)     // Catch: java.lang.Exception -> L2d
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L2d
            java.nio.charset.Charset r1 = kotlin.text.Charsets.UTF_8     // Catch: java.lang.Exception -> L2d
            byte[] r5 = r5.getBytes(r1)     // Catch: java.lang.Exception -> L2d
            java.lang.String r1 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)     // Catch: java.lang.Exception -> L2d
            r1 = 0
            r6.writeBytesToFile(r0, r5, r1)     // Catch: java.lang.Exception -> L2d
            goto Lea
        Le3:
            com.contentsquare.android.core.features.logging.Logger r4 = r4.c
            java.lang.String r6 = "Failed to store Telemetry event to file"
            com.contentsquare.android.sdk.Q2.a(r4, r6, r5)
        Lea:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0678f7.a(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
