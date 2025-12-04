package com.contentsquare.proto.mobilestacktrace.v1;

import com.contentsquare.proto.mobilestacktrace.v1.EmptyThreadReportKt;
import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"emptyThreadReport", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$EmptyThreadReport;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/mobilestacktrace/v1/EmptyThreadReportKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeemptyThreadReport", "copy", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEmptyThreadReportKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EmptyThreadReportKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/EmptyThreadReportKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,39:1\n1#2:40\n*E\n"})
/* loaded from: classes3.dex */
public final class EmptyThreadReportKtKt {
    @JvmName(name = "-initializeemptyThreadReport")
    @NotNull
    /* renamed from: -initializeemptyThreadReport, reason: not valid java name */
    public static final MobileStacktrace.EmptyThreadReport m750initializeemptyThreadReport(Function1<? super EmptyThreadReportKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        EmptyThreadReportKt.Dsl.Companion companion = EmptyThreadReportKt.Dsl.INSTANCE;
        MobileStacktrace.EmptyThreadReport.Builder builderNewBuilder = MobileStacktrace.EmptyThreadReport.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        EmptyThreadReportKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.EmptyThreadReport copy(MobileStacktrace.EmptyThreadReport emptyThreadReport, Function1<? super EmptyThreadReportKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(emptyThreadReport, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        EmptyThreadReportKt.Dsl.Companion companion = EmptyThreadReportKt.Dsl.INSTANCE;
        MobileStacktrace.EmptyThreadReport.Builder builder = emptyThreadReport.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        EmptyThreadReportKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
