package com.contentsquare.proto.replayproperties.v1;

import com.contentsquare.proto.replayproperties.v1.ReplayPropertiesKt;
import com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"replayProperties", "Lcom/contentsquare/proto/replayproperties/v1/ReplayPropertiesV1$ReplayProperties;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/replayproperties/v1/ReplayPropertiesKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializereplayProperties", "copy", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nReplayPropertiesKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReplayPropertiesKt.kt\ncom/contentsquare/proto/replayproperties/v1/ReplayPropertiesKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,182:1\n1#2:183\n*E\n"})
/* loaded from: classes3.dex */
public final class ReplayPropertiesKtKt {
    @JvmName(name = "-initializereplayProperties")
    @NotNull
    /* renamed from: -initializereplayProperties, reason: not valid java name */
    public static final ReplayPropertiesV1.ReplayProperties m1262initializereplayProperties(Function1<? super ReplayPropertiesKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ReplayPropertiesKt.Dsl.Companion companion = ReplayPropertiesKt.Dsl.INSTANCE;
        ReplayPropertiesV1.ReplayProperties.Builder builderNewBuilder = ReplayPropertiesV1.ReplayProperties.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ReplayPropertiesKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final ReplayPropertiesV1.ReplayProperties copy(ReplayPropertiesV1.ReplayProperties replayProperties, Function1<? super ReplayPropertiesKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(replayProperties, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ReplayPropertiesKt.Dsl.Companion companion = ReplayPropertiesKt.Dsl.INSTANCE;
        ReplayPropertiesV1.ReplayProperties.Builder builder = replayProperties.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        ReplayPropertiesKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
