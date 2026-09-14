package com.swmansion.rnscreens.gamma.helpers;

import androidx.annotation.UiThread;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m1836d2 = {"Lcom/swmansion/rnscreens/gamma/helpers/NewArchAwareViewIdGenerator;", "Lcom/swmansion/rnscreens/gamma/helpers/ViewIdProviding;", "<init>", "()V", "nextId", "", "generateViewId", "progressViewId", "", "isValidReactRootTag", "", "tag", "react-native-screens_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@UiThread
@SourceDebugExtension({"SMAP\nViewIdHelpers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewIdHelpers.kt\ncom/swmansion/rnscreens/gamma/helpers/NewArchAwareViewIdGenerator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,59:1\n1#2:60\n*E\n"})
final class NewArchAwareViewIdGenerator implements ViewIdProviding {
    private int nextId = 3;

    @Override // com.swmansion.rnscreens.gamma.helpers.ViewIdProviding
    public int generateViewId() {
        int i = this.nextId;
        progressViewId();
        return i;
    }

    private final void progressViewId() {
        int i = this.nextId + 2;
        this.nextId = i;
        if (isValidReactRootTag(i)) {
            this.nextId += 2;
        }
    }

    private final boolean isValidReactRootTag(int tag) {
        return tag % 10 == 1;
    }
}
