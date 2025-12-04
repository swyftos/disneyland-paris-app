package com.facebook.fresco.ui.common;

import com.facebook.fresco.ui.common.ControllerListener2;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0016\u0018\u0000 \u0019*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J)\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00018\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u001a"}, d2 = {"Lcom/facebook/fresco/ui/common/BaseControllerListener2;", "INFO", "Lcom/facebook/fresco/ui/common/ControllerListener2;", "<init>", "()V", "onSubmit", "", "id", "", "callerContext", "", "extras", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "onFinalImageSet", "imageInfo", "extraData", "(Ljava/lang/String;Ljava/lang/Object;Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;)V", "onIntermediateImageSet", "(Ljava/lang/String;Ljava/lang/Object;)V", "onIntermediateImageFailed", "onFailure", "throwable", "", "onRelease", "onEmptyEvent", "Companion", "ui-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class BaseControllerListener2<INFO> implements ControllerListener2<INFO> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final ControllerListener2 NO_OP_LISTENER = new BaseControllerListener2();

    @JvmStatic
    @NotNull
    public static final <I> ControllerListener2<I> getNoOpListener() {
        return INSTANCE.getNoOpListener();
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onEmptyEvent(@Nullable Object callerContext) {
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onFailure(@NotNull String id, @Nullable Throwable throwable, @Nullable ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onFinalImageSet(@NotNull String id, @Nullable INFO imageInfo, @Nullable ControllerListener2.Extras extraData) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageFailed(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageSet(@NotNull String id, @Nullable INFO imageInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onRelease(@NotNull String id, @Nullable ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onSubmit(@NotNull String id, @Nullable Object callerContext, @Nullable ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0001\u0010\u0007H\u0007R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/fresco/ui/common/BaseControllerListener2$Companion;", "", "<init>", "()V", "NO_OP_LISTENER", "Lcom/facebook/fresco/ui/common/ControllerListener2;", "getNoOpListener", "I", "ui-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final <I> ControllerListener2<I> getNoOpListener() {
            ControllerListener2<I> controllerListener2 = BaseControllerListener2.NO_OP_LISTENER;
            Intrinsics.checkNotNull(controllerListener2, "null cannot be cast to non-null type com.facebook.fresco.ui.common.ControllerListener2<I of com.facebook.fresco.ui.common.BaseControllerListener2.Companion.getNoOpListener>");
            return controllerListener2;
        }
    }
}
