package com.contentsquare.proto.srm.v1;

import com.contentsquare.proto.srm.v1.SrmPutV1;
import com.contentsquare.proto.srm.v1.StaticResourceKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"staticResource", "Lcom/contentsquare/proto/srm/v1/SrmPutV1$StaticResource;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/srm/v1/StaticResourceKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializestaticResource", "copy", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStaticResourceKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StaticResourceKt.kt\ncom/contentsquare/proto/srm/v1/StaticResourceKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
/* loaded from: classes3.dex */
public final class StaticResourceKtKt {
    @JvmName(name = "-initializestaticResource")
    @NotNull
    /* renamed from: -initializestaticResource, reason: not valid java name */
    public static final SrmPutV1.StaticResource m1815initializestaticResource(Function1<? super StaticResourceKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        StaticResourceKt.Dsl.Companion companion = StaticResourceKt.Dsl.INSTANCE;
        SrmPutV1.StaticResource.Builder builderNewBuilder = SrmPutV1.StaticResource.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        StaticResourceKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SrmPutV1.StaticResource copy(SrmPutV1.StaticResource staticResource, Function1<? super StaticResourceKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(staticResource, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        StaticResourceKt.Dsl.Companion companion = StaticResourceKt.Dsl.INSTANCE;
        SrmPutV1.StaticResource.Builder builder = staticResource.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        StaticResourceKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
