package com.contentsquare.android.sdk;

import android.content.Context;
import android.content.Intent;
import com.contentsquare.android.api.Currencies;
import com.contentsquare.android.core.features.logging.DebugLogWriter;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.contentsquare.android.sdk.V5;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipOutputStream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.SettingsViewModel$createEmailIntent$1", f = "SettingsViewModel.kt", i = {}, l = {Currencies.MVR}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class X5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Y5 c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ Function1<Intent, Unit> e;

    @DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.SettingsViewModel$createEmailIntent$1$1", f = "SettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function1<Intent, Unit> a;
        public final /* synthetic */ Intent b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(V5.a aVar, Intent intent, Continuation continuation) {
            super(2, continuation);
            this.a = aVar;
            this.b = intent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a((V5.a) this.a, this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Function1<Intent, Unit> function1 = this.a;
            return new a((V5.a) function1, this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            this.a.invoke(this.b);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X5(String str, Y5 y5, Context context, V5.a aVar, Continuation continuation) {
        super(2, continuation);
        this.b = str;
        this.c = y5;
        this.d = context;
        this.e = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new X5(this.b, this.c, this.d, (V5.a) this.e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((X5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DebugLogWriter debugLogWriter = Logger.INSTANCE.getDebugLogWriter();
            if (debugLogWriter != null) {
                debugLogWriter.forceFlush();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.b);
            String str = File.separator;
            sb.append(str);
            sb.append("cs");
            String string = sb.toString();
            File file = new File(string, DebugLogWriter.DEBUG_FOLDER);
            File file2 = new File(string, JsonConfigFeatureFlagNames.TELEMETRY);
            File file3 = new File(string + str + "cs_debug_logs.zip");
            Y5 y5 = this.c;
            List<File> listListOf = CollectionsKt.listOf((Object[]) new File[]{file, file2});
            y5.getClass();
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file3)));
            try {
                for (File file4 : listListOf) {
                    String name = file4.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "folder.name");
                    Y5.a(file4, name, zipOutputStream);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(zipOutputStream, null);
                Intent intentA = Y5.a(this.c, this.d, file3);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                a aVar = new a((V5.a) this.e, intentA, null);
                this.a = 1;
                if (BuildersKt.withContext(main, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } finally {
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
