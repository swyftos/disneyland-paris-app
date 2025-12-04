package com.urbanairship.android.framework.proxy.proxies;

import com.urbanairship.android.framework.proxy.PendingEmbedded;
import com.urbanairship.android.framework.proxy.events.EventEmitter;
import com.urbanairship.android.framework.proxy.events.PendingEmbeddedUpdated;
import com.urbanairship.automation.InAppAutomation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/InAppProxy;", "", "inAppProvider", "Lkotlin/Function0;", "Lcom/urbanairship/automation/InAppAutomation;", "(Lkotlin/jvm/functions/Function0;)V", "getDisplayInterval", "", "isPaused", "", "resendLastEmbeddedEvent", "", "setDisplayInterval", "milliseconds", "setPaused", "paused", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InAppProxy {
    private final Function0 inAppProvider;

    public InAppProxy(@NotNull Function0<InAppAutomation> inAppProvider) {
        Intrinsics.checkNotNullParameter(inAppProvider, "inAppProvider");
        this.inAppProvider = inAppProvider;
    }

    public final void setPaused(boolean paused) {
        ((InAppAutomation) this.inAppProvider.invoke()).setPaused(paused);
    }

    public final boolean isPaused() {
        return ((InAppAutomation) this.inAppProvider.invoke()).isPaused();
    }

    public final void setDisplayInterval(long milliseconds) {
        ((InAppAutomation) this.inAppProvider.invoke()).getInAppMessaging().setDisplayInterval(milliseconds);
    }

    public final long getDisplayInterval() {
        return ((InAppAutomation) this.inAppProvider.invoke()).getInAppMessaging().getDisplayInterval();
    }

    public final void resendLastEmbeddedEvent() {
        EventEmitter.INSTANCE.shared().addEvent(new PendingEmbeddedUpdated(PendingEmbedded.INSTANCE.getPending().getValue()), true);
    }
}
