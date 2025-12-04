package com.contentsquare.android.error.analysis.crash;

import androidx.annotation.WorkerThread;
import com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface;
import com.contentsquare.android.core.communication.error.analysis.CrashWrapped;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0003J\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\fH\u0003J\u0006\u0010\u0015\u001a\u00020\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/contentsquare/android/error/analysis/crash/CrashEventReporter;", "", "libraryInterface", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;", "dataUploader", "Lcom/contentsquare/android/error/analysis/crash/CrashDataUploader;", "backgroundDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;Lcom/contentsquare/android/error/analysis/crash/CrashDataUploader;Lkotlinx/coroutines/CoroutineDispatcher;)V", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "deleteCrashFiles", "", "deletePendingCrashEvents", "processCrashFile", "it", "", "saveCrashEvent", "crashWrapped", "Lcom/contentsquare/android/core/communication/error/analysis/CrashWrapped;", "sendCrashFiles", "sendPendingCrashEvents", "Companion", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCrashEventReporter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrashEventReporter.kt\ncom/contentsquare/android/error/analysis/crash/CrashEventReporter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,83:1\n1855#2,2:84\n1855#2,2:86\n*S KotlinDebug\n*F\n+ 1 CrashEventReporter.kt\ncom/contentsquare/android/error/analysis/crash/CrashEventReporter\n*L\n47#1:84,2\n57#1:86,2\n*E\n"})
/* loaded from: classes2.dex */
public final class CrashEventReporter {

    @NotNull
    public static final String CRASH_PATH = "/mobile/v1/crashes";

    @NotNull
    private final CoroutineDispatcher backgroundDispatcher;

    @NotNull
    private final CrashDataUploader dataUploader;

    @NotNull
    private final ErrorAnalysisLibraryInterface libraryInterface;

    @NotNull
    private final Logger logger;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.contentsquare.android.error.analysis.crash.CrashEventReporter$deletePendingCrashEvents$1", f = "CrashEventReporter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.contentsquare.android.error.analysis.crash.CrashEventReporter$deletePendingCrashEvents$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CrashEventReporter.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CrashEventReporter.this.deleteCrashFiles();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.contentsquare.android.error.analysis.crash.CrashEventReporter$sendPendingCrashEvents$1", f = "CrashEventReporter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.contentsquare.android.error.analysis.crash.CrashEventReporter$sendPendingCrashEvents$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C06181(Continuation<? super C06181> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CrashEventReporter.this.new C06181(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CrashEventReporter.this.sendCrashFiles();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public CrashEventReporter(ErrorAnalysisLibraryInterface libraryInterface, CrashDataUploader dataUploader, CoroutineDispatcher backgroundDispatcher) {
        Intrinsics.checkNotNullParameter(libraryInterface, "libraryInterface");
        Intrinsics.checkNotNullParameter(dataUploader, "dataUploader");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        this.libraryInterface = libraryInterface;
        this.dataUploader = dataUploader;
        this.backgroundDispatcher = backgroundDispatcher;
        this.logger = new Logger("CrashEventReporter");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final synchronized void deleteCrashFiles() {
        try {
            Iterator<T> it = this.libraryInterface.getPendingCrashFiles().iterator();
            while (it.hasNext()) {
                new File((String) it.next()).delete();
            }
        } catch (IOException e) {
            this.logger.e(e, "Failed to delete crash file");
        }
    }

    private final void processCrashFile(String it) {
        JsonConfig.ProjectConfiguration projectConfig;
        File file = new File(it);
        byte[] bytes = FilesKt.readBytes(file);
        if (bytes.length == 0) {
            return;
        }
        Configuration configuration = this.libraryInterface.getConfiguration();
        if (this.dataUploader.sendToBackend(((configuration == null || (projectConfig = configuration.getProjectConfig()) == null) ? null : projectConfig.getEndpoint()) + CRASH_PATH, bytes, this.libraryInterface.isLogVisualizerEnabled())) {
            this.libraryInterface.logCrash(bytes);
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final synchronized void sendCrashFiles() {
        try {
            Iterator<T> it = this.libraryInterface.getPendingCrashFiles().iterator();
            while (it.hasNext()) {
                processCrashFile((String) it.next());
            }
        } catch (IOException e) {
            this.logger.e(e, "Failed to send crash file");
        }
    }

    public final void deletePendingCrashEvents() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.backgroundDispatcher), null, null, new AnonymousClass1(null), 3, null);
    }

    public final void saveCrashEvent(CrashWrapped crashWrapped) {
        Intrinsics.checkNotNullParameter(crashWrapped, "crashWrapped");
        this.libraryInterface.sendCrashToSessionReplay(crashWrapped);
        this.libraryInterface.saveCrashToDisk(crashWrapped);
    }

    public final void sendPendingCrashEvents() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.backgroundDispatcher), null, null, new C06181(null), 3, null);
    }

    public /* synthetic */ CrashEventReporter(ErrorAnalysisLibraryInterface errorAnalysisLibraryInterface, CrashDataUploader crashDataUploader, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(errorAnalysisLibraryInterface, crashDataUploader, (i & 4) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}
