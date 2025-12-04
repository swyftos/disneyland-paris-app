package com.contentsquare.android.sdk;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.FileStorageUtil;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.contentsquare.android.internal.core.logmonitor.processing.LogMessage;
import com.contentsquare.android.sdk.C0848x0;
import com.contentsquare.android.sdk.N2;
import com.contentsquare.android.sdk.O2;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class O2 {

    @NotNull
    public final HttpConnection a;

    @NotNull
    public final P2 b;

    @NotNull
    public final CoroutineScope c;

    @NotNull
    public final Logger d;

    @NotNull
    public final AtomicInteger e;

    @DebugMetadata(c = "com.contentsquare.android.internal.core.logmonitor.processing.LogProcessor$storeLog$1", f = "LogProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ LogMessage b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LogMessage logMessage, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = logMessage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return O2.this.new a(this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return O2.this.new a(this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            P2 p2 = O2.this.b;
            LogMessage logMessage = this.b;
            p2.getClass();
            Intrinsics.checkNotNullParameter(logMessage, "logMessage");
            try {
                StringBuilder sb = new StringBuilder();
                Json.Companion r3 = Json.INSTANCE;
                r3.getSerializersModule();
                sb.append(StringsKt.replace$default(r3.encodeToString(LogMessage.Companion.serializer(), logMessage), "\n", "", false, 4, (Object) null));
                sb.append('\n');
                String string = sb.toString();
                FileStorageUtil fileStorageUtil = p2.b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(p2.a.getFilesDir().getAbsolutePath());
                String str = File.separator;
                sb2.append(str);
                sb2.append("cs");
                sb2.append(str);
                sb2.append(p2.d);
                fileStorageUtil.mkdirs(sb2.toString());
                p2.b.writeStringToFile(p2.e, string, true);
                p2.c.d("Store log on disk. : " + string);
            } catch (Throwable th) {
                p2.c.e("Failed to save log to file at path: " + p2.e + " | error message: " + th.getMessage());
            }
            if (O2.this.e.incrementAndGet() >= 5) {
                O2 o2 = O2.this;
                o2.getClass();
                if (C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.LOG_MONITORING)) {
                    BuildersKt__Builders_commonKt.launch$default(o2.c, null, null, new N2(o2, null), 3, null);
                }
            }
            P2 p22 = O2.this.b;
            p22.getClass();
            long physicalSize = 0;
            try {
                if (p22.b.getFile(p22.e).exists()) {
                    physicalSize = p22.b.getPhysicalSize(p22.e);
                }
            } catch (Throwable th2) {
                p22.c.e("Failed to get lof file physical size: " + th2.getMessage());
            }
            if (physicalSize > 1048576) {
                O2.this.d.d("The log file storage has reached max size limit. Clear all logs.");
                O2.this.b.a();
            }
            return Unit.INSTANCE;
        }
    }

    @JvmOverloads
    public O2(@NotNull HttpConnection httpConnection, @NotNull P2 logStorage) {
        Intrinsics.checkNotNullParameter(httpConnection, "httpConnection");
        Intrinsics.checkNotNullParameter(logStorage, "logStorage");
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(executorServiceNewSingleThreadExecutor));
        LifecycleOwner lifeCycleOwner = ProcessLifecycleOwner.INSTANCE.get();
        Intrinsics.checkNotNullParameter(httpConnection, "httpConnection");
        Intrinsics.checkNotNullParameter(logStorage, "logStorage");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(lifeCycleOwner, "lifeCycleOwner");
        this.a = httpConnection;
        this.b = logStorage;
        this.c = coroutineScope;
        this.d = new Logger("LogProcessor");
        this.e = new AtomicInteger(0);
        lifeCycleOwner.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: com.contentsquare.android.internal.core.logmonitor.processing.LogProcessor$lifeCycleObserver$1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onStop(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                super.onStop(owner);
                O2 o2 = this.a;
                o2.getClass();
                if (C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.LOG_MONITORING)) {
                    BuildersKt__Builders_commonKt.launch$default(o2.c, null, null, new N2(o2, null), 3, null);
                }
            }
        });
    }

    public final void a(@NotNull LogMessage logMessage) {
        Intrinsics.checkNotNullParameter(logMessage, "logMessage");
        if (C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.LOG_MONITORING)) {
            BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new a(logMessage, null), 3, null);
        }
    }
}
