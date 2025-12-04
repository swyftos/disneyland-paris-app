package com.contentsquare.android.sdk;

import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.bouncycastle.asn1.eac.EACTags;
import org.bouncycastle.bcpg.PacketTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@SourceDebugExtension({"SMAP\nTimeAgent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeAgent.kt\ncom/contentsquare/android/internal/core/telemetry/agent/TimeAgent\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,87:1\n215#2,2:88\n215#2,2:90\n*S KotlinDebug\n*F\n+ 1 TimeAgent.kt\ncom/contentsquare/android/internal/core/telemetry/agent/TimeAgent\n*L\n63#1:88,2\n77#1:90,2\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.y7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0864y7 implements InterfaceC0628a7 {

    @NotNull
    public final A7 a;

    @NotNull
    public final C0817t7 b;

    @NotNull
    public final Logger c;

    @NotNull
    public final CoroutineScope d;
    public boolean e;

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.agent.TimeAgent", f = "TimeAgent.kt", i = {0, 0, 1, 1}, l = {60, PacketTags.EXPERIMENTAL_3}, m = "collect", n = {"this", "timeEventJson", "this", "timeEventJson"}, s = {"L$0", "L$1", "L$0", "L$1"})
    /* renamed from: com.contentsquare.android.sdk.y7$a */
    public static final class a extends ContinuationImpl {
        public C0864y7 a;
        public JSONObject b;
        public /* synthetic */ Object c;
        public int e;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return C0864y7.this.b(this);
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.agent.TimeAgent$reset$1", f = "TimeAgent.kt", i = {}, l = {EACTags.SEX}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.contentsquare.android.sdk.y7$b */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return C0864y7.this.new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return C0864y7.this.new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C0817t7 c0817t7 = C0864y7.this.b;
                this.a = 1;
                if (c0817t7.clear() == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.agent.TimeAgent", f = "TimeAgent.kt", i = {0}, l = {45}, m = "stop", n = {"this"}, s = {"L$0"})
    /* renamed from: com.contentsquare.android.sdk.y7$c */
    public static final class c extends ContinuationImpl {
        public C0864y7 a;
        public /* synthetic */ Object b;
        public int d;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return C0864y7.this.a(this);
        }
    }

    public C0864y7(A7 timeCollector, C0817t7 timeStorage) {
        CoroutineDispatcher dispatcher = Dispatchers.getIO();
        Intrinsics.checkNotNullParameter(timeCollector, "timeCollector");
        Intrinsics.checkNotNullParameter(timeStorage, "timeStorage");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.a = timeCollector;
        this.b = timeStorage;
        this.c = new Logger("TimeAgent");
        this.d = CoroutineScopeKt.CoroutineScope(dispatcher);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @NotNull
    public final int a() {
        return this.e ? 1 : 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super org.json.JSONObject> r9) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0864y7.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    public final void c() {
        this.a.c.clear();
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new b(null), 3, null);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    public final void start() {
        if (this.e || !C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.TELEMETRY_TIME)) {
            return;
        }
        this.e = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.contentsquare.android.sdk.C0864y7.c
            if (r0 == 0) goto L13
            r0 = r5
            com.contentsquare.android.sdk.y7$c r0 = (com.contentsquare.android.sdk.C0864y7.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.y7$c r0 = new com.contentsquare.android.sdk.y7$c
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            com.contentsquare.android.sdk.y7 r4 = r0.a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L45
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            boolean r5 = r4.e
            if (r5 == 0) goto L48
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = r4.c(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            r5 = 0
            r4.e = r5
        L48:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0864y7.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(kotlin.coroutines.Continuation<? super kotlin.Unit> r32) {
        /*
            Method dump skipped, instructions count: 1222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0864y7.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @NotNull
    public final EnumC0690h b() {
        return EnumC0690h.TIME;
    }
}
