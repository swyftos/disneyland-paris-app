package com.facebook.react.bridge.queue;

import android.os.Looper;
import com.facebook.react.bridge.queue.MessageQueueThreadImpl;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;", "Lcom/facebook/react/bridge/queue/ReactQueueConfiguration;", "uiQueueThread", "Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;", "nativeModulesQueueThread", "jsQueueThread", "<init>", "(Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;Lcom/facebook/react/bridge/queue/MessageQueueThreadImpl;)V", "getUIQueueThread", "Lcom/facebook/react/bridge/queue/MessageQueueThread;", "getNativeModulesQueueThread", "getJSQueueThread", "destroy", "", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReactQueueConfigurationImpl implements ReactQueueConfiguration {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final MessageQueueThreadImpl jsQueueThread;

    @NotNull
    private final MessageQueueThreadImpl nativeModulesQueueThread;

    @NotNull
    private final MessageQueueThreadImpl uiQueueThread;

    public /* synthetic */ ReactQueueConfigurationImpl(MessageQueueThreadImpl messageQueueThreadImpl, MessageQueueThreadImpl messageQueueThreadImpl2, MessageQueueThreadImpl messageQueueThreadImpl3, DefaultConstructorMarker defaultConstructorMarker) {
        this(messageQueueThreadImpl, messageQueueThreadImpl2, messageQueueThreadImpl3);
    }

    @JvmStatic
    @NotNull
    public static final ReactQueueConfigurationImpl create(@NotNull ReactQueueConfigurationSpec reactQueueConfigurationSpec, @NotNull QueueThreadExceptionHandler queueThreadExceptionHandler) {
        return INSTANCE.create(reactQueueConfigurationSpec, queueThreadExceptionHandler);
    }

    private ReactQueueConfigurationImpl(MessageQueueThreadImpl messageQueueThreadImpl, MessageQueueThreadImpl messageQueueThreadImpl2, MessageQueueThreadImpl messageQueueThreadImpl3) {
        this.uiQueueThread = messageQueueThreadImpl;
        this.nativeModulesQueueThread = messageQueueThreadImpl2;
        this.jsQueueThread = messageQueueThreadImpl3;
    }

    @Override // com.facebook.react.bridge.queue.ReactQueueConfiguration
    @NotNull
    public MessageQueueThread getUIQueueThread() {
        return this.uiQueueThread;
    }

    @Override // com.facebook.react.bridge.queue.ReactQueueConfiguration
    @NotNull
    public MessageQueueThread getNativeModulesQueueThread() {
        return this.nativeModulesQueueThread;
    }

    @Override // com.facebook.react.bridge.queue.ReactQueueConfiguration
    @NotNull
    public MessageQueueThread getJSQueueThread() {
        return this.jsQueueThread;
    }

    @Override // com.facebook.react.bridge.queue.ReactQueueConfiguration
    public void destroy() throws InterruptedException, RuntimeException {
        if (!Intrinsics.areEqual(this.nativeModulesQueueThread.getLooper(), Looper.getMainLooper())) {
            this.nativeModulesQueueThread.quitSynchronous();
        }
        if (Intrinsics.areEqual(this.jsQueueThread.getLooper(), Looper.getMainLooper())) {
            return;
        }
        this.jsQueueThread.quitSynchronous();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl$Companion;", "", "<init>", "()V", "create", "Lcom/facebook/react/bridge/queue/ReactQueueConfigurationImpl;", "spec", "Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;", "exceptionHandler", "Lcom/facebook/react/bridge/queue/QueueThreadExceptionHandler;", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final ReactQueueConfigurationImpl create(@NotNull ReactQueueConfigurationSpec spec, @NotNull QueueThreadExceptionHandler exceptionHandler) throws RuntimeException {
            Intrinsics.checkNotNullParameter(spec, "spec");
            Intrinsics.checkNotNullParameter(exceptionHandler, "exceptionHandler");
            MessageQueueThreadImpl.Companion companion = MessageQueueThreadImpl.INSTANCE;
            return new ReactQueueConfigurationImpl(companion.create(MessageQueueThreadSpec.INSTANCE.mainThreadSpec(), exceptionHandler), companion.create(spec.getNativeModulesQueueThreadSpec(), exceptionHandler), companion.create(spec.getJSQueueThreadSpec(), exceptionHandler), null);
        }
    }
}
