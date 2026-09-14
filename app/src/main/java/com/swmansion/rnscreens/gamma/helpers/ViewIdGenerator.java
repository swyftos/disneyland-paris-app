package com.swmansion.rnscreens.gamma.helpers;

import androidx.annotation.UiThread;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m1836d2 = {"Lcom/swmansion/rnscreens/gamma/helpers/ViewIdGenerator;", "Lcom/swmansion/rnscreens/gamma/helpers/ViewIdProviding;", "<init>", "()V", "externalGenerator", "getExternalGenerator", "()Lcom/swmansion/rnscreens/gamma/helpers/ViewIdProviding;", "setExternalGenerator", "(Lcom/swmansion/rnscreens/gamma/helpers/ViewIdProviding;)V", "defaultGenerator", "generateViewId", "", "react-native-screens_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@UiThread
@SourceDebugExtension({"SMAP\nViewIdHelpers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewIdHelpers.kt\ncom/swmansion/rnscreens/gamma/helpers/ViewIdGenerator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,59:1\n1#2:60\n*E\n"})
public final class ViewIdGenerator implements ViewIdProviding {

    @NotNull
    public static final ViewIdGenerator INSTANCE = new ViewIdGenerator();

    @NotNull
    private static final ViewIdProviding defaultGenerator = new NewArchAwareViewIdGenerator();

    @Nullable
    private static ViewIdProviding externalGenerator;

    private ViewIdGenerator() {
    }

    @Nullable
    public final ViewIdProviding getExternalGenerator() {
        return externalGenerator;
    }

    public final void setExternalGenerator(@Nullable ViewIdProviding viewIdProviding) {
        externalGenerator = viewIdProviding;
    }

    @Override // com.swmansion.rnscreens.gamma.helpers.ViewIdProviding
    public int generateViewId() {
        ViewIdProviding viewIdProviding = externalGenerator;
        return viewIdProviding != null ? viewIdProviding.generateViewId() : defaultGenerator.generateViewId();
    }
}
