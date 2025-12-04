package com.contentsquare.android.core.features.logging;

import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.contentsquare.android.core.utils.ExtensionsKt;
import com.contentsquare.android.core.utils.FileStorageUtil;
import com.contentsquare.android.core.utils.SystemInstantiable;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ*\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0018J\u0016\u0010\u001f\u001a\u00020\u00182\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0 H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00128\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/contentsquare/android/core/features/logging/DebugLogWriter;", "", "fileStorageUtil", "Lcom/contentsquare/android/core/utils/FileStorageUtil;", "systemInstantiable", "Lcom/contentsquare/android/core/utils/SystemInstantiable;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "logBatchSize", "", "storedLinesLimit", "appFilesDir", "", "(Lcom/contentsquare/android/core/utils/FileStorageUtil;Lcom/contentsquare/android/core/utils/SystemInstantiable;Lkotlinx/coroutines/CoroutineScope;IILjava/lang/String;)V", "filePath", "formatter", "Ljava/text/SimpleDateFormat;", "logs", "", "getLogs$core_release$annotations", "()V", "getLogs$core_release", "()Ljava/util/List;", "add", "", "level", "tag", NotificationCompat.CATEGORY_MESSAGE, "tr", "", "forceFlush", "writeToDisk", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DebugLogWriter {

    @NotNull
    public static final String DEBUG_FOLDER = "debug-logs";

    @NotNull
    public static final String FILE_NAME = "cs-debug-logs.log";
    private static final int LOG_BATCH_SIZE = 200;
    private static final int STORED_LINES_LIMIT = 10000;

    @NotNull
    private final CoroutineScope coroutineScope;

    @NotNull
    private String filePath;

    @NotNull
    private final FileStorageUtil fileStorageUtil;

    @NotNull
    private final SimpleDateFormat formatter;
    private final int logBatchSize;

    @NotNull
    private final List<String> logs;
    private final int storedLinesLimit;

    @NotNull
    private final SystemInstantiable systemInstantiable;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.contentsquare.android.core.features.logging.DebugLogWriter$add$1", f = "DebugLogWriter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.contentsquare.android.core.features.logging.DebugLogWriter$add$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $immutableLogs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List<String> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$immutableLogs = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DebugLogWriter.this.new AnonymousClass1(this.$immutableLogs, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            DebugLogWriter.this.writeToDisk(this.$immutableLogs);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public DebugLogWriter(FileStorageUtil fileStorageUtil, SystemInstantiable systemInstantiable, CoroutineScope coroutineScope, int i, int i2, String appFilesDir) {
        Intrinsics.checkNotNullParameter(fileStorageUtil, "fileStorageUtil");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(appFilesDir, "appFilesDir");
        this.fileStorageUtil = fileStorageUtil;
        this.systemInstantiable = systemInstantiable;
        this.coroutineScope = coroutineScope;
        this.logBatchSize = i;
        this.storedLinesLimit = i2;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        this.formatter = simpleDateFormat;
        this.logs = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append(appFilesDir);
        String str = File.separator;
        sb.append(str);
        sb.append("cs");
        sb.append(str);
        sb.append(DEBUG_FOLDER);
        String string = sb.toString();
        fileStorageUtil.mkdirs(string);
        this.filePath = string + str + FILE_NAME;
        new Logger("DebugLogStorage").i("A DebugLogStorage has been created. Debug logs will be stored to disk and can be send to Contentsquare through CS InApp menu.");
    }

    public static /* synthetic */ void add$default(DebugLogWriter debugLogWriter, String str, String str2, String str3, Throwable th, int i, Object obj) {
        if ((i & 8) != 0) {
            th = null;
        }
        debugLogWriter.add(str, str2, str3, th);
    }

    @VisibleForTesting
    public static /* synthetic */ void getLogs$core_release$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeToDisk(List<String> logs) {
        this.fileStorageUtil.writeStringToFile(this.filePath, CollectionsKt.joinToString$default(logs, "\n", "\n", null, 0, null, null, 60, null), true);
        int size = this.fileStorageUtil.readFileContentByLine(this.filePath).size() - this.storedLinesLimit;
        if (size > 0) {
            this.fileStorageUtil.writeStringToFile(this.filePath, CollectionsKt.joinToString$default(CollectionsKt.drop(this.fileStorageUtil.readFileContentByLine(this.filePath), size), "\n", null, null, 0, null, null, 62, null), false);
        }
    }

    public final synchronized void add(String level, String tag, String msg, Throwable tr) {
        String strConvertStackTraceToString$default;
        try {
            Intrinsics.checkNotNullParameter(level, "level");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            String str = this.formatter.format(new Date(this.systemInstantiable.currentTimeMillis()));
            Intrinsics.checkNotNullExpressionValue(str, "formatter.format(Date(sy…ble.currentTimeMillis()))");
            List<String> list = this.logs;
            StringBuilder sb = new StringBuilder("[");
            sb.append(str);
            sb.append("] ");
            sb.append(level);
            sb.append(' ');
            sb.append(tag);
            sb.append(" [");
            sb.append(Thread.currentThread().getName());
            sb.append("]: ");
            sb.append(msg);
            if (tr == null || (strConvertStackTraceToString$default = ExtensionsKt.convertStackTraceToString$default(tr, 0, 1, null)) == null) {
                strConvertStackTraceToString$default = "";
            }
            sb.append(strConvertStackTraceToString$default);
            list.add(sb.toString());
            if (this.logs.size() > this.logBatchSize) {
                List list2 = CollectionsKt.toList(this.logs);
                this.logs.clear();
                BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(list2, null), 3, null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void forceFlush() {
        List list = CollectionsKt.toList(this.logs);
        this.logs.clear();
        this.fileStorageUtil.writeStringToFile(this.filePath, CollectionsKt.joinToString$default(list, "\n", "\n", null, 0, null, null, 60, null), true);
    }

    @NotNull
    public final List<String> getLogs$core_release() {
        return this.logs;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DebugLogWriter(FileStorageUtil fileStorageUtil, SystemInstantiable systemInstantiable, CoroutineScope coroutineScope, int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        FileStorageUtil fileStorageUtil2 = (i3 & 1) != 0 ? new FileStorageUtil() : fileStorageUtil;
        SystemInstantiable systemInstantiable2 = (i3 & 2) != 0 ? new SystemInstantiable() : systemInstantiable;
        if ((i3 & 4) != 0) {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
            coroutineScope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(executorServiceNewSingleThreadExecutor));
        }
        this(fileStorageUtil2, systemInstantiable2, coroutineScope, (i3 & 8) != 0 ? 200 : i, (i3 & 16) != 0 ? 10000 : i2, str);
    }
}
