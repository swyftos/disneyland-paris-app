package com.contentsquare.android.sdk;

import com.contentsquare.android.core.CoreModule;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nAppLifeCycleAgent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppLifeCycleAgent.kt\ncom/contentsquare/android/internal/core/telemetry/agent/AppLifeCycleAgent\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,91:1\n1#2:92\n1855#3,2:93\n*S KotlinDebug\n*F\n+ 1 AppLifeCycleAgent.kt\ncom/contentsquare/android/internal/core/telemetry/agent/AppLifeCycleAgent\n*L\n56#1:93,2\n*E\n"})
/* loaded from: classes2.dex */
public final class D implements InterfaceC0628a7 {

    @NotNull
    public final F a;

    @NotNull
    public final C0678f7 b;

    @NotNull
    public final CoroutineScope c;
    public boolean d;

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.agent.AppLifeCycleAgent", f = "AppLifeCycleAgent.kt", i = {0}, l = {EACTags.SEX, 55}, m = "collect", n = {"this"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {
        public D a;
        public /* synthetic */ Object b;
        public int d;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return D.this.b(this);
        }
    }

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.agent.AppLifeCycleAgent$reset$1", f = "AppLifeCycleAgent.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return D.this.new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return D.this.new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C0678f7 c0678f7 = D.this.b;
                this.a = 1;
                if (c0678f7.clear() == coroutine_suspended) {
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

    @DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.agent.AppLifeCycleAgent", f = "AppLifeCycleAgent.kt", i = {0}, l = {EACTags.CERTIFICATION_AUTHORITY_PUBLIC_KEY}, m = "stop", n = {"this"}, s = {"L$0"})
    public static final class c extends ContinuationImpl {
        public D a;
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
            return D.this.a(this);
        }
    }

    public D(F appEventCollector, C0678f7 eventStorage) {
        CoroutineDispatcher dispatcher = Dispatchers.getIO();
        Intrinsics.checkNotNullParameter(appEventCollector, "appEventCollector");
        Intrinsics.checkNotNullParameter(eventStorage, "eventStorage");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.a = appEventCollector;
        this.b = eventStorage;
        this.c = CoroutineScopeKt.CoroutineScope(dispatcher);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @NotNull
    public final int a() {
        return this.d ? 1 : 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006b A[LOOP:0: B:25:0x0065->B:27:0x006b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super org.json.JSONObject> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.contentsquare.android.sdk.D.a
            if (r0 == 0) goto L13
            r0 = r6
            com.contentsquare.android.sdk.D$a r0 = (com.contentsquare.android.sdk.D.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.D$a r0 = new com.contentsquare.android.sdk.D$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5a
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            com.contentsquare.android.sdk.D r5 = r0.a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4c
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.d
            if (r6 == 0) goto L4c
            r0.a = r5
            r0.d = r4
            java.lang.Object r6 = r5.a(r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            com.contentsquare.android.sdk.f7 r5 = r5.b
            r6 = 0
            r0.a = r6
            r0.d = r3
            java.lang.Object r6 = r5.a(r0)
            if (r6 != r1) goto L5a
            return r1
        L5a:
            java.util.List r6 = (java.util.List) r6
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            java.util.Iterator r6 = r6.iterator()
        L65:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L75
            java.lang.Object r0 = r6.next()
            com.contentsquare.android.internal.core.telemetry.event.a r0 = (com.contentsquare.android.internal.core.telemetry.event.a) r0
            r0.a(r5)
            goto L65
        L75:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.D.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    public final void c() {
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new b(null), 3, null);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    public final void start() {
        if (this.d || !C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.TELEMETRY_LIFECYCLE)) {
            return;
        }
        this.d = true;
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
            boolean r0 = r5 instanceof com.contentsquare.android.sdk.D.c
            if (r0 == 0) goto L13
            r0 = r5
            com.contentsquare.android.sdk.D$c r0 = (com.contentsquare.android.sdk.D.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.contentsquare.android.sdk.D$c r0 = new com.contentsquare.android.sdk.D$c
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            com.contentsquare.android.sdk.D r4 = r0.a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L68
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            boolean r5 = r4.d
            if (r5 == 0) goto L6b
            com.contentsquare.android.sdk.F r5 = r4.a
            java.util.LinkedHashMap r2 = r5.b
            java.util.Collection r2 = r2.values()
            java.util.List r2 = kotlin.collections.CollectionsKt.toList(r2)
            java.util.LinkedHashMap r5 = r5.b
            r5.clear()
            r0.a = r4
            r0.d = r3
            boolean r5 = r2.isEmpty()
            if (r5 == 0) goto L56
            goto L63
        L56:
            com.contentsquare.android.sdk.f7 r5 = r4.b
            java.lang.Object r5 = r5.a(r2, r0)
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r5 != r0) goto L63
            goto L65
        L63:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
        L65:
            if (r5 != r1) goto L68
            return r1
        L68:
            r5 = 0
            r4.d = r5
        L6b:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.D.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0628a7
    @NotNull
    public final EnumC0690h b() {
        return EnumC0690h.APP_EVENT;
    }
}
