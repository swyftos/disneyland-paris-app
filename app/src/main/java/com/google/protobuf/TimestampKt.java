package com.google.protobuf;

import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m1836d2 = {"Lcom/google/protobuf/TimestampKt;", "", "()V", "Dsl", "java_kotlin-lite-well_known_protos_kotlin_lite"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
public final class TimestampKt {

    @NotNull
    public static final TimestampKt INSTANCE = new TimestampKt();

    @Metadata(m1835d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, m1836d2 = {"Lcom/google/protobuf/TimestampKt$Dsl;", "", "_builder", "Lcom/google/protobuf/Timestamp$Builder;", "(Lcom/google/protobuf/Timestamp$Builder;)V", "value", "", "nanos", "getNanos", "()I", "setNanos", "(I)V", "", "seconds", "getSeconds", "()J", "setSeconds", "(J)V", "_build", "Lcom/google/protobuf/Timestamp;", "clearNanos", "", "clearSeconds", "Companion", "java_kotlin-lite-well_known_protos_kotlin_lite"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final Timestamp.Builder _builder;

        public /* synthetic */ Dsl(Timestamp.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        private Dsl(Timestamp.Builder builder) {
            this._builder = builder;
        }

        @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, m1836d2 = {"Lcom/google/protobuf/TimestampKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/TimestampKt$Dsl;", "builder", "Lcom/google/protobuf/Timestamp$Builder;", "java_kotlin-lite-well_known_protos_kotlin_lite"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(Timestamp.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        @PublishedApi
        public final /* synthetic */ Timestamp _build() {
            Timestamp timestampBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(timestampBuild, "_builder.build()");
            return timestampBuild;
        }

        @JvmName(name = "getSeconds")
        public final long getSeconds() {
            return this._builder.getSeconds();
        }

        @JvmName(name = "setSeconds")
        public final void setSeconds(long j) {
            this._builder.setSeconds(j);
        }

        public final void clearSeconds() {
            this._builder.clearSeconds();
        }

        @JvmName(name = "getNanos")
        public final int getNanos() {
            return this._builder.getNanos();
        }

        @JvmName(name = "setNanos")
        public final void setNanos(int i) {
            this._builder.setNanos(i);
        }

        public final void clearNanos() {
            this._builder.clearNanos();
        }
    }

    private TimestampKt() {
    }
}
