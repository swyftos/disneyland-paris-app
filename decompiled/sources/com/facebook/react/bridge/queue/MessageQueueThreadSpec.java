package com.facebook.react.bridge.queue;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;", "", "threadType", "Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;", "name", "", "stackSize", "", "<init>", "(Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;Ljava/lang/String;J)V", "getThreadType", "()Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;", "getName", "()Ljava/lang/String;", "getStackSize", "()J", "ThreadType", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MessageQueueThreadSpec {
    public static final long DEFAULT_STACK_SIZE_BYTES = 0;

    @NotNull
    private final String name;
    private final long stackSize;

    @NotNull
    private final ThreadType threadType;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final MessageQueueThreadSpec MAIN_UI_SPEC = new MessageQueueThreadSpec(ThreadType.MAIN_UI, "main_ui", 0, 4, null);

    public /* synthetic */ MessageQueueThreadSpec(ThreadType threadType, String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(threadType, str, j);
    }

    @JvmStatic
    @NotNull
    public static final MessageQueueThreadSpec mainThreadSpec() {
        return INSTANCE.mainThreadSpec();
    }

    @JvmStatic
    @NotNull
    public static final MessageQueueThreadSpec newBackgroundThreadSpec(@NotNull String str) {
        return INSTANCE.newBackgroundThreadSpec(str);
    }

    @JvmStatic
    @NotNull
    public static final MessageQueueThreadSpec newBackgroundThreadSpec(@NotNull String str, long j) {
        return INSTANCE.newBackgroundThreadSpec(str, j);
    }

    @JvmStatic
    @NotNull
    public static final MessageQueueThreadSpec newUIBackgroundTreadSpec(@NotNull String str) {
        return INSTANCE.newUIBackgroundTreadSpec(str);
    }

    private MessageQueueThreadSpec(ThreadType threadType, String str, long j) {
        this.threadType = threadType;
        this.name = str;
        this.stackSize = j;
    }

    /* synthetic */ MessageQueueThreadSpec(ThreadType threadType, String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(threadType, str, (i & 4) != 0 ? 0L : j);
    }

    @NotNull
    public final ThreadType getThreadType() {
        return this.threadType;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final long getStackSize() {
        return this.stackSize;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$ThreadType;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_UI", "NEW_BACKGROUND", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ThreadType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ThreadType[] $VALUES;
        public static final ThreadType MAIN_UI = new ThreadType("MAIN_UI", 0);
        public static final ThreadType NEW_BACKGROUND = new ThreadType("NEW_BACKGROUND", 1);

        private static final /* synthetic */ ThreadType[] $values() {
            return new ThreadType[]{MAIN_UI, NEW_BACKGROUND};
        }

        @NotNull
        public static EnumEntries<ThreadType> getEntries() {
            return $ENTRIES;
        }

        private ThreadType(String str, int i) {
        }

        static {
            ThreadType[] threadTypeArr$values = $values();
            $VALUES = threadTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(threadTypeArr$values);
        }

        public static ThreadType valueOf(String str) {
            return (ThreadType) Enum.valueOf(ThreadType.class, str);
        }

        public static ThreadType[] values() {
            return (ThreadType[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007H\u0007J\b\u0010\r\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec$Companion;", "", "<init>", "()V", "MAIN_UI_SPEC", "Lcom/facebook/react/bridge/queue/MessageQueueThreadSpec;", "DEFAULT_STACK_SIZE_BYTES", "", "newUIBackgroundTreadSpec", "name", "", "newBackgroundThreadSpec", "stackSize", "mainThreadSpec", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final MessageQueueThreadSpec newUIBackgroundTreadSpec(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, name, 0L, 4, null);
        }

        @JvmStatic
        @NotNull
        public final MessageQueueThreadSpec newBackgroundThreadSpec(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, name, 0L, 4, null);
        }

        @JvmStatic
        @NotNull
        public final MessageQueueThreadSpec newBackgroundThreadSpec(@NotNull String name, long stackSize) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, name, stackSize, null);
        }

        @JvmStatic
        @NotNull
        public final MessageQueueThreadSpec mainThreadSpec() {
            return MessageQueueThreadSpec.MAIN_UI_SPEC;
        }
    }
}
