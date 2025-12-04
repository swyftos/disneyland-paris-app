package com.urbanairship.iam.legacy;

import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.iam.InAppMessage;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R.\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u00020\fX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R,\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0003j\u0004\u0018\u0001`\u0013X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR,\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u0017X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\n¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/iam/legacy/LegacyInAppMessagingInterface;", "", "customMessageConverter", "Lkotlin/Function1;", "Lcom/urbanairship/iam/legacy/LegacyInAppMessage;", "Lcom/urbanairship/automation/AutomationSchedule;", "Lcom/urbanairship/iam/legacy/MessageConvertor;", "getCustomMessageConverter", "()Lkotlin/jvm/functions/Function1;", "setCustomMessageConverter", "(Lkotlin/jvm/functions/Function1;)V", "displayAsapEnabled", "", "getDisplayAsapEnabled", "()Z", "setDisplayAsapEnabled", "(Z)V", "messageExtender", "Lcom/urbanairship/iam/InAppMessage;", "Lcom/urbanairship/iam/legacy/MessageExtender;", "getMessageExtender", "setMessageExtender", "scheduleExtender", "Lcom/urbanairship/iam/legacy/ScheduleExtender;", "getScheduleExtender", "setScheduleExtender", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface LegacyInAppMessagingInterface {
    @Nullable
    Function1<LegacyInAppMessage, AutomationSchedule> getCustomMessageConverter();

    boolean getDisplayAsapEnabled();

    @Nullable
    Function1<InAppMessage, InAppMessage> getMessageExtender();

    @Nullable
    Function1<AutomationSchedule, AutomationSchedule> getScheduleExtender();

    void setCustomMessageConverter(@Nullable Function1<? super LegacyInAppMessage, AutomationSchedule> function1);

    void setDisplayAsapEnabled(boolean z);

    void setMessageExtender(@Nullable Function1<? super InAppMessage, InAppMessage> function1);

    void setScheduleExtender(@Nullable Function1<? super AutomationSchedule, AutomationSchedule> function1);
}
