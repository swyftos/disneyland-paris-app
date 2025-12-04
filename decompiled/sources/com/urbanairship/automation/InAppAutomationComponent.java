package com.urbanairship.automation;

import android.content.Context;
import com.urbanairship.AirshipComponent;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UAirship;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/automation/InAppAutomationComponent;", "Lcom/urbanairship/AirshipComponent;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "automation", "Lcom/urbanairship/automation/InAppAutomation;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/automation/InAppAutomation;)V", "getAutomation$urbanairship_automation_release", "()Lcom/urbanairship/automation/InAppAutomation;", "onAirshipReady", "", "airship", "Lcom/urbanairship/UAirship;", "tearDown", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppAutomationComponent extends AirshipComponent {
    private final InAppAutomation automation;

    @NotNull
    /* renamed from: getAutomation$urbanairship_automation_release, reason: from getter */
    public final InAppAutomation getAutomation() {
        return this.automation;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppAutomationComponent(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull InAppAutomation automation) {
        super(context, dataStore);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(automation, "automation");
        this.automation = automation;
    }

    @Override // com.urbanairship.AirshipComponent
    protected void onAirshipReady(@NotNull UAirship airship) {
        Intrinsics.checkNotNullParameter(airship, "airship");
        super.onAirshipReady(airship);
        this.automation.airshipReady$urbanairship_automation_release();
    }

    @Override // com.urbanairship.AirshipComponent
    protected void tearDown() {
        super.tearDown();
        this.automation.tearDown$urbanairship_automation_release();
    }
}
