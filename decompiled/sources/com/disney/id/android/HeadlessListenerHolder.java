package com.disney.id.android;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\ba\u0018\u00002\u00020\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\u0012\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/disney/id/android/HeadlessListenerHolder;", "", "headlessListener", "Lcom/disney/id/android/OneIDHeadlessListener;", "getHeadlessListener$annotations", "()V", "getHeadlessListener", "()Lcom/disney/id/android/OneIDHeadlessListener;", "setHeadlessListener", "(Lcom/disney/id/android/OneIDHeadlessListener;)V", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface HeadlessListenerHolder {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getHeadlessListener$annotations() {
        }
    }

    @Nullable
    OneIDHeadlessListener getHeadlessListener();

    void setHeadlessListener(@Nullable OneIDHeadlessListener oneIDHeadlessListener);
}
