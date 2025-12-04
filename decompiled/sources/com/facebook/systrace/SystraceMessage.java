package com.facebook.systrace;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/systrace/SystraceMessage;", "", "<init>", "()V", "INCLUDE_ARGS", "", "beginSection", "Lcom/facebook/systrace/SystraceMessage$Builder;", "tag", "", "sectionName", "", "endSection", "Builder", "StartSectionBuilder", "EndSectionBuilder", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SystraceMessage {

    @JvmField
    public static boolean INCLUDE_ARGS;

    @NotNull
    public static final SystraceMessage INSTANCE = new SystraceMessage();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0006\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H&J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000bH&J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/facebook/systrace/SystraceMessage$Builder;", "", "<init>", "()V", "flush", "", "arg", "key", "", "value", "", "", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class Builder {
        @NotNull
        public abstract Builder arg(@NotNull String key, double value);

        @NotNull
        public abstract Builder arg(@NotNull String key, int value);

        @NotNull
        public abstract Builder arg(@NotNull String key, long value);

        @NotNull
        public abstract Builder arg(@NotNull String key, @NotNull Object value);

        public abstract void flush();
    }

    private SystraceMessage() {
    }

    @JvmStatic
    @NotNull
    public static final Builder beginSection(long tag, @NotNull String sectionName) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        return new StartSectionBuilder(tag, sectionName);
    }

    @JvmStatic
    @NotNull
    public static final Builder endSection(long tag) {
        return new EndSectionBuilder(tag);
    }

    private static final class StartSectionBuilder extends Builder {
        private final List args;
        private final String sectionName;
        private final long tag;

        public StartSectionBuilder(long j, String sectionName) {
            Intrinsics.checkNotNullParameter(sectionName, "sectionName");
            this.tag = j;
            this.sectionName = sectionName;
            this.args = new ArrayList();
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public void flush() {
            String str;
            long j = this.tag;
            String str2 = this.sectionName;
            if (SystraceMessage.INCLUDE_ARGS && !this.args.isEmpty()) {
                str = " (" + String.join(", ", this.args) + ")";
            } else {
                str = "";
            }
            Systrace.beginSection(j, str2 + str);
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(String key, Object value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            addArg(key, value.toString());
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(String key, int i) {
            Intrinsics.checkNotNullParameter(key, "key");
            addArg(key, String.valueOf(i));
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(String key, long j) {
            Intrinsics.checkNotNullParameter(key, "key");
            addArg(key, String.valueOf(j));
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(String key, double d) {
            Intrinsics.checkNotNullParameter(key, "key");
            addArg(key, String.valueOf(d));
            return this;
        }

        private final void addArg(String str, String str2) {
            this.args.add(str + ": " + str2);
        }
    }

    private static final class EndSectionBuilder extends Builder {
        private final long tag;

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(String key, double d) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(String key, int i) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(String key, long j) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(String key, Object value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return this;
        }

        public EndSectionBuilder(long j) {
            this.tag = j;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public void flush() {
            Systrace.endSection(this.tag);
        }
    }
}
