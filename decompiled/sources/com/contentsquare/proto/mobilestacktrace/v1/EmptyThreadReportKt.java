package com.contentsquare.proto.mobilestacktrace.v1;

import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/EmptyThreadReportKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EmptyThreadReportKt {

    @NotNull
    public static final EmptyThreadReportKt INSTANCE = new EmptyThreadReportKt();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/EmptyThreadReportKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$EmptyThreadReport$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$EmptyThreadReport$Builder;)V", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$EmptyThreadReport;", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final MobileStacktrace.EmptyThreadReport.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/EmptyThreadReportKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/EmptyThreadReportKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$EmptyThreadReport$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(MobileStacktrace.EmptyThreadReport.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Dsl(MobileStacktrace.EmptyThreadReport.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ MobileStacktrace.EmptyThreadReport _build() {
            MobileStacktrace.EmptyThreadReport emptyThreadReportBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(emptyThreadReportBuild, "_builder.build()");
            return emptyThreadReportBuild;
        }

        public /* synthetic */ Dsl(MobileStacktrace.EmptyThreadReport.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private EmptyThreadReportKt() {
    }
}
