package com.disney.id.android;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/disney/id/android/OneIDHeadlessListenerHolder;", "Lcom/disney/id/android/HeadlessListenerHolder;", "()V", "headlessListener", "Lcom/disney/id/android/OneIDHeadlessListener;", "getHeadlessListener", "()Lcom/disney/id/android/OneIDHeadlessListener;", "setHeadlessListener", "(Lcom/disney/id/android/OneIDHeadlessListener;)V", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OneIDHeadlessListenerHolder implements HeadlessListenerHolder {
    private OneIDHeadlessListener headlessListener;

    @Override // com.disney.id.android.HeadlessListenerHolder
    @Nullable
    public OneIDHeadlessListener getHeadlessListener() {
        return this.headlessListener;
    }

    @Override // com.disney.id.android.HeadlessListenerHolder
    public void setHeadlessListener(@Nullable OneIDHeadlessListener oneIDHeadlessListener) {
        this.headlessListener = oneIDHeadlessListener;
    }
}
