package com.facebook.react.bridge.queue;

import com.facebook.react.bridge.queue.MessageQueueThreadSpec;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0002\n\u000bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;", "", "nativeModulesQueueThreadSpec", "Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;", "jSQueueThreadSpec", "<init>", "(Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;)V", "getNativeModulesQueueThreadSpec", "()Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;", "getJSQueueThreadSpec", "Builder", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReactQueueConfigurationSpec {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final MessageQueueThreadSpec jSQueueThreadSpec;

    @NotNull
    private final MessageQueueThreadSpec nativeModulesQueueThreadSpec;

    @JvmStatic
    @NotNull
    public static final ReactQueueConfigurationSpec createDefault() {
        return INSTANCE.createDefault();
    }

    public ReactQueueConfigurationSpec(@NotNull MessageQueueThreadSpec nativeModulesQueueThreadSpec, @NotNull MessageQueueThreadSpec jSQueueThreadSpec) {
        Intrinsics.checkNotNullParameter(nativeModulesQueueThreadSpec, "nativeModulesQueueThreadSpec");
        Intrinsics.checkNotNullParameter(jSQueueThreadSpec, "jSQueueThreadSpec");
        this.nativeModulesQueueThreadSpec = nativeModulesQueueThreadSpec;
        this.jSQueueThreadSpec = jSQueueThreadSpec;
    }

    @NotNull
    public final MessageQueueThreadSpec getNativeModulesQueueThreadSpec() {
        return this.nativeModulesQueueThreadSpec;
    }

    @NotNull
    public final MessageQueueThreadSpec getJSQueueThreadSpec() {
        return this.jSQueueThreadSpec;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$Builder;", "", "<init>", "()V", "nativeModulesQueueSpec", "Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;", "jsQueueSpec", "setNativeModulesQueueThreadSpec", "spec", "setJSQueueThreadSpec", "build", "Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nReactQueueConfigurationSpec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReactQueueConfigurationSpec.kt\ncom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,52:1\n1#2:53\n*E\n"})
    public static final class Builder {

        @Nullable
        private MessageQueueThreadSpec jsQueueSpec;

        @Nullable
        private MessageQueueThreadSpec nativeModulesQueueSpec;

        @NotNull
        public final Builder setNativeModulesQueueThreadSpec(@Nullable MessageQueueThreadSpec spec) {
            if (this.nativeModulesQueueSpec != null) {
                throw new IllegalStateException("Setting native modules queue spec multiple times!");
            }
            this.nativeModulesQueueSpec = spec;
            return this;
        }

        @NotNull
        public final Builder setJSQueueThreadSpec(@Nullable MessageQueueThreadSpec spec) {
            if (this.jsQueueSpec != null) {
                throw new IllegalStateException("Setting JS queue multiple times!");
            }
            this.jsQueueSpec = spec;
            return this;
        }

        @NotNull
        public final ReactQueueConfigurationSpec build() {
            MessageQueueThreadSpec messageQueueThreadSpec = this.nativeModulesQueueSpec;
            if (messageQueueThreadSpec == null) {
                throw new IllegalStateException("Required value was null.");
            }
            MessageQueueThreadSpec messageQueueThreadSpec2 = this.jsQueueSpec;
            if (messageQueueThreadSpec2 != null) {
                return new ReactQueueConfigurationSpec(messageQueueThreadSpec, messageQueueThreadSpec2);
            }
            throw new IllegalStateException("Required value was null.");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$Companion;", "", "<init>", "()V", "builder", "Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec$Builder;", "createDefault", "Lcom/facebook/react/bridge/queue/ReactQueueConfigurationSpec;", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Builder builder() {
            return new Builder();
        }

        @JvmStatic
        @NotNull
        public final ReactQueueConfigurationSpec createDefault() {
            MessageQueueThreadSpec.Companion companion = MessageQueueThreadSpec.INSTANCE;
            return new ReactQueueConfigurationSpec(companion.newBackgroundThreadSpec("native_modules"), companion.newBackgroundThreadSpec("js"));
        }
    }
}
