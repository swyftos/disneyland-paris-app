package com.contentsquare.android.error.analysis.apierror;

import com.contentsquare.android.core.communication.ScreenViewTracker;
import com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.contentsquare.android.error.analysis.util.JSONPath;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001(B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0003H\u0002J\u0006\u0010\u001c\u001a\u00020\u000eJ\b\u0010\u001d\u001a\u00020\u000eH\u0002J\u0006\u0010\u001e\u001a\u00020\u0016J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010 \u001a\u00020!J\u0014\u0010\"\u001a\u00020\u00162\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$J\u0006\u0010&\u001a\u00020\u0016J\u0006\u0010'\u001a\u00020\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/NetworkEventController;", "", "nativeNetworkEventProcessorV1", "Lcom/contentsquare/android/error/analysis/apierror/NetworkEventProcessor;", "nativeNetworkEventProcessorV2", "webViewNetworkEventProcessor", "networkEventCounter", "Lcom/contentsquare/android/error/analysis/apierror/NetworkEventCounter;", "libraryInterface", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "(Lcom/contentsquare/android/error/analysis/apierror/NetworkEventProcessor;Lcom/contentsquare/android/error/analysis/apierror/NetworkEventProcessor;Lcom/contentsquare/android/error/analysis/apierror/NetworkEventProcessor;Lcom/contentsquare/android/error/analysis/apierror/NetworkEventCounter;Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;Lcom/contentsquare/android/core/features/logging/Logger;)V", "isStarted", "", "screenViewTracker", "Lcom/contentsquare/android/core/communication/ScreenViewTracker;", "getScreenViewTracker", "()Lcom/contentsquare/android/core/communication/ScreenViewTracker;", "singleThreadedNetworkDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "checkForSendingBeforeFirstScreen", "", "dispatchNativeEvent", "rawEvent", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "dispatchWebViewEvent", "getNetworkEventProcessor", "isApiErrorEnabled", "isNetworkEventLimitReached", "onConfigurationChanged", "sendNetworkEvent", "context", "Lkotlin/coroutines/CoroutineContext;", "setUrlMaskingPatterns", "patterns", "", "", ViewProps.START, "stop", "Companion", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNetworkEventController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkEventController.kt\ncom/contentsquare/android/error/analysis/apierror/NetworkEventController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,161:1\n1360#2:162\n1446#2,2:163\n1549#2:165\n1620#2,3:166\n1448#2,3:169\n*S KotlinDebug\n*F\n+ 1 NetworkEventController.kt\ncom/contentsquare/android/error/analysis/apierror/NetworkEventController\n*L\n152#1:162\n152#1:163,2\n153#1:165\n153#1:166,3\n152#1:169,3\n*E\n"})
/* loaded from: classes2.dex */
public final class NetworkEventController {
    private static final long KEEP_ALIVE_SECONDS = 30;
    private static final int NUMBER_OF_THREADS = 1;
    private static final int QUEUE_SIZE = 20;
    private boolean isStarted;

    @NotNull
    private final ErrorAnalysisLibraryInterface libraryInterface;

    @NotNull
    private final Logger logger;

    @NotNull
    private final NetworkEventProcessor nativeNetworkEventProcessorV1;

    @NotNull
    private final NetworkEventProcessor nativeNetworkEventProcessorV2;

    @NotNull
    private final NetworkEventCounter networkEventCounter;

    @NotNull
    private final ExecutorCoroutineDispatcher singleThreadedNetworkDispatcher;

    @NotNull
    private final NetworkEventProcessor webViewNetworkEventProcessor;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.contentsquare.android.error.analysis.apierror.NetworkEventController$sendNetworkEvent$1", f = "NetworkEventController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.contentsquare.android.error.analysis.apierror.NetworkEventController$sendNetworkEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NetworkEvent $rawEvent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(NetworkEvent networkEvent, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$rawEvent = networkEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NetworkEventController.this.new AnonymousClass1(this.$rawEvent, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (NetworkEventController.this.isNetworkEventLimitReached()) {
                NetworkEventController.this.logger.i("Limit of 20 API errors per screenview has been reached for the current screenview. API Error collection is paused until next screenview");
            } else {
                String source = this.$rawEvent.getSource();
                if (Intrinsics.areEqual(source, "webview")) {
                    NetworkEventController.this.dispatchWebViewEvent(this.$rawEvent);
                } else if (Intrinsics.areEqual(source, "native")) {
                    NetworkEventController.this.dispatchNativeEvent(this.$rawEvent);
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public NetworkEventController(NetworkEventProcessor nativeNetworkEventProcessorV1, NetworkEventProcessor nativeNetworkEventProcessorV2, NetworkEventProcessor webViewNetworkEventProcessor, NetworkEventCounter networkEventCounter, ErrorAnalysisLibraryInterface libraryInterface, Logger logger) {
        Intrinsics.checkNotNullParameter(nativeNetworkEventProcessorV1, "nativeNetworkEventProcessorV1");
        Intrinsics.checkNotNullParameter(nativeNetworkEventProcessorV2, "nativeNetworkEventProcessorV2");
        Intrinsics.checkNotNullParameter(webViewNetworkEventProcessor, "webViewNetworkEventProcessor");
        Intrinsics.checkNotNullParameter(networkEventCounter, "networkEventCounter");
        Intrinsics.checkNotNullParameter(libraryInterface, "libraryInterface");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.nativeNetworkEventProcessorV1 = nativeNetworkEventProcessorV1;
        this.nativeNetworkEventProcessorV2 = nativeNetworkEventProcessorV2;
        this.webViewNetworkEventProcessor = webViewNetworkEventProcessor;
        this.networkEventCounter = networkEventCounter;
        this.libraryInterface = libraryInterface;
        this.logger = logger;
        this.singleThreadedNetworkDispatcher = ExecutorsKt.from((ExecutorService) new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), Executors.defaultThreadFactory(), new RejectedExecutionHandler() { // from class: com.contentsquare.android.error.analysis.apierror.NetworkEventController$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                NetworkEventController.singleThreadedNetworkDispatcher$lambda$0(this.f$0, runnable, threadPoolExecutor);
            }
        }));
    }

    private final void checkForSendingBeforeFirstScreen() {
        ScreenViewTracker screenViewTracker = getScreenViewTracker();
        if (screenViewTracker == null || !screenViewTracker.isSentBeforeFirstScreen()) {
            return;
        }
        this.logger.i("No screenview detected. API error is linked to screenviews. Please implement screenview tracking to enable it.");
        ErrorAnalysisLibraryInterface.DefaultImpls.storeLogEvent$default(this.libraryInterface, ErrorAnalysisLibraryInterface.LogLevel.WARN, "Event sent before 1st screen view: API Error", null, null, null, null, 60, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchNativeEvent(NetworkEvent rawEvent) {
        NetworkEvent networkEventProcessEvent;
        if (NetworkEventFilterKt.isAccepted(rawEvent) && isApiErrorEnabled() && (networkEventProcessEvent = getNetworkEventProcessor().processEvent(rawEvent)) != null) {
            checkForSendingBeforeFirstScreen();
            this.logger.d("API Error - " + networkEventProcessEvent.getStatusCode() + ' ' + networkEventProcessEvent.getHttpMethod() + ' ' + networkEventProcessEvent.getUrl());
            this.libraryInterface.sendNetworkMetricToSessionReplay(networkEventProcessEvent);
            this.libraryInterface.sendNetworkEventToAnalytics(networkEventProcessEvent);
            this.networkEventCounter.incrementCounter();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchWebViewEvent(NetworkEvent rawEvent) {
        NetworkEvent networkEventProcessEvent = this.webViewNetworkEventProcessor.processEvent(rawEvent);
        if (networkEventProcessEvent == null || !NetworkEventFilterKt.isAccepted(networkEventProcessEvent)) {
            return;
        }
        checkForSendingBeforeFirstScreen();
        this.libraryInterface.sendNetworkMetricToSessionReplay(networkEventProcessEvent);
        this.networkEventCounter.incrementCounter();
    }

    private final NetworkEventProcessor getNetworkEventProcessor() {
        JsonConfig.ProjectConfiguration projectConfig;
        Configuration configuration = this.libraryInterface.getConfiguration();
        return ((configuration == null || (projectConfig = configuration.getProjectConfig()) == null) ? null : projectConfig.getApiErrorsV2()) != null ? this.nativeNetworkEventProcessorV2 : this.nativeNetworkEventProcessorV1;
    }

    private final ScreenViewTracker getScreenViewTracker() {
        return this.libraryInterface.getScreenViewTracker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isNetworkEventLimitReached() {
        ScreenViewTracker screenViewTracker = getScreenViewTracker();
        if (screenViewTracker != null && screenViewTracker.isScreenNumberChanged()) {
            this.networkEventCounter.resetCounter();
            ScreenViewTracker screenViewTracker2 = getScreenViewTracker();
            if (screenViewTracker2 != null) {
                screenViewTracker2.updateLastScreenNumber();
            }
        }
        return this.networkEventCounter.isMaxNetworkEventLimitReached();
    }

    public static /* synthetic */ void sendNetworkEvent$default(NetworkEventController networkEventController, NetworkEvent networkEvent, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = networkEventController.singleThreadedNetworkDispatcher;
        }
        networkEventController.sendNetworkEvent(networkEvent, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void singleThreadedNetworkDispatcher$lambda$0(NetworkEventController this$0, Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ErrorAnalysisLibraryInterface.DefaultImpls.storeLogEvent$default(this$0.libraryInterface, ErrorAnalysisLibraryInterface.LogLevel.WARN, "Network event rejected due to queue being full", null, null, null, null, 60, null);
    }

    public final boolean isApiErrorEnabled() {
        return this.libraryInterface.isFeatureEnabled(JsonConfigFeatureFlagNames.API_ERRORS);
    }

    public final void onConfigurationChanged() {
        ArrayList arrayList;
        List<JsonConfig.ApiErrorsV2.CollectionRule> collectionRules;
        JsonConfig.ProjectConfiguration projectConfig;
        Configuration configuration = this.libraryInterface.getConfiguration();
        JsonConfig.ApiErrorsV2 apiErrorsV2 = (configuration == null || (projectConfig = configuration.getProjectConfig()) == null) ? null : projectConfig.getApiErrorsV2();
        if (apiErrorsV2 == null || (collectionRules = apiErrorsV2.getCollectionRules()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            Iterator<T> it = collectionRules.iterator();
            while (it.hasNext()) {
                List<JsonConfig.ApiErrorsV2.BodyAttributePath> bodyAttributePaths = ((JsonConfig.ApiErrorsV2.CollectionRule) it.next()).getBodyAttributePaths();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(bodyAttributePaths, 10));
                Iterator<T> it2 = bodyAttributePaths.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((JsonConfig.ApiErrorsV2.BodyAttributePath) it2.next()).getPath());
                }
                CollectionsKt.addAll(arrayList, arrayList2);
            }
        }
        JSONPath.buildCache$default(JSONPath.INSTANCE, arrayList, null, 2, null);
    }

    public final void sendNetworkEvent(NetworkEvent rawEvent, CoroutineContext context) {
        Intrinsics.checkNotNullParameter(rawEvent, "rawEvent");
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(context), null, null, new AnonymousClass1(rawEvent, null), 3, null);
    }

    public final void setUrlMaskingPatterns(List<String> patterns) {
        Intrinsics.checkNotNullParameter(patterns, "patterns");
        this.nativeNetworkEventProcessorV1.setUrlMaskingPatterns(patterns);
        this.nativeNetworkEventProcessorV2.setUrlMaskingPatterns(patterns);
    }

    public final void start() {
        if (this.isStarted) {
            return;
        }
        this.isStarted = true;
        this.logger.i("Api Error collection is enabled");
    }

    public final void stop() {
        if (this.isStarted) {
            this.isStarted = false;
            this.logger.i("Api Error collection is disabled");
        }
    }

    public /* synthetic */ NetworkEventController(NetworkEventProcessor networkEventProcessor, NetworkEventProcessor networkEventProcessor2, NetworkEventProcessor networkEventProcessor3, NetworkEventCounter networkEventCounter, ErrorAnalysisLibraryInterface errorAnalysisLibraryInterface, Logger logger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(networkEventProcessor, networkEventProcessor2, networkEventProcessor3, networkEventCounter, errorAnalysisLibraryInterface, (i & 32) != 0 ? new Logger("NetworkEventController") : logger);
    }
}
