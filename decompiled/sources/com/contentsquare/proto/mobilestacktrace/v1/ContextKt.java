package com.contentsquare.proto.mobilestacktrace.v1;

import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ContextKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ContextKt {

    @NotNull
    public static final ContextKt INSTANCE = new ContextKt();

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u001eJ\u0006\u0010\"\u001a\u00020\u001eJ\u0006\u0010#\u001a\u00020$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR$\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011¨\u0006&"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ContextKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Context$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Context$Builder;)V", "value", "", "errorSource", "getErrorSource", "()Ljava/lang/String;", "setErrorSource", "(Ljava/lang/String;)V", "", "projectId", "getProjectId", "()I", "setProjectId", "(I)V", "sessionNumber", "getSessionNumber", "setSessionNumber", "userId", "getUserId", "setUserId", "viewNumber", "getViewNumber", "setViewNumber", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Context;", "clearErrorSource", "", "clearProjectId", "clearSessionNumber", "clearUserId", "clearViewNumber", "hasErrorSource", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final MobileStacktrace.Context.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ContextKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/ContextKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Context$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(MobileStacktrace.Context.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Dsl(MobileStacktrace.Context.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ MobileStacktrace.Context _build() {
            MobileStacktrace.Context contextBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(contextBuild, "_builder.build()");
            return contextBuild;
        }

        public final void clearErrorSource() {
            this._builder.clearErrorSource();
        }

        public final void clearProjectId() {
            this._builder.clearProjectId();
        }

        public final void clearSessionNumber() {
            this._builder.clearSessionNumber();
        }

        public final void clearUserId() {
            this._builder.clearUserId();
        }

        public final void clearViewNumber() {
            this._builder.clearViewNumber();
        }

        @JvmName(name = "getErrorSource")
        @NotNull
        public final String getErrorSource() {
            String errorSource = this._builder.getErrorSource();
            Intrinsics.checkNotNullExpressionValue(errorSource, "_builder.getErrorSource()");
            return errorSource;
        }

        @JvmName(name = "getProjectId")
        public final int getProjectId() {
            return this._builder.getProjectId();
        }

        @JvmName(name = "getSessionNumber")
        public final int getSessionNumber() {
            return this._builder.getSessionNumber();
        }

        @JvmName(name = "getUserId")
        @NotNull
        public final String getUserId() {
            String userId = this._builder.getUserId();
            Intrinsics.checkNotNullExpressionValue(userId, "_builder.getUserId()");
            return userId;
        }

        @JvmName(name = "getViewNumber")
        public final int getViewNumber() {
            return this._builder.getViewNumber();
        }

        public final boolean hasErrorSource() {
            return this._builder.hasErrorSource();
        }

        @JvmName(name = "setErrorSource")
        public final void setErrorSource(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setErrorSource(value);
        }

        @JvmName(name = "setProjectId")
        public final void setProjectId(int i) {
            this._builder.setProjectId(i);
        }

        @JvmName(name = "setSessionNumber")
        public final void setSessionNumber(int i) {
            this._builder.setSessionNumber(i);
        }

        @JvmName(name = "setUserId")
        public final void setUserId(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setUserId(value);
        }

        @JvmName(name = "setViewNumber")
        public final void setViewNumber(int i) {
            this._builder.setViewNumber(i);
        }

        public /* synthetic */ Dsl(MobileStacktrace.Context.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private ContextKt() {
    }
}
