package com.urbanairship.iam;

import android.content.Context;
import com.urbanairship.iam.adapter.CustomDisplayAdapter;
import com.urbanairship.iam.adapter.CustomDisplayAdapterType;
import com.urbanairship.iam.assets.AirshipCachedAssets;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0014\u001a\u00020\u0015H&J2\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182 \u0010\u0019\u001a\u001c\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001aH&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/iam/InAppMessagingInterface;", "", "displayDelegate", "Lcom/urbanairship/iam/InAppMessageDisplayDelegate;", "getDisplayDelegate", "()Lcom/urbanairship/iam/InAppMessageDisplayDelegate;", "setDisplayDelegate", "(Lcom/urbanairship/iam/InAppMessageDisplayDelegate;)V", "displayInterval", "", "getDisplayInterval", "()J", "setDisplayInterval", "(J)V", "messageContentExtender", "Lcom/urbanairship/iam/InAppMessageContentExtender;", "getMessageContentExtender", "()Lcom/urbanairship/iam/InAppMessageContentExtender;", "setMessageContentExtender", "(Lcom/urbanairship/iam/InAppMessageContentExtender;)V", "notifyDisplayConditionsChanged", "", "setAdapterFactoryBlock", "type", "Lcom/urbanairship/iam/adapter/CustomDisplayAdapterType;", "factoryBlock", "Lkotlin/Function3;", "Landroid/content/Context;", "Lcom/urbanairship/iam/InAppMessage;", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "Lcom/urbanairship/iam/adapter/CustomDisplayAdapter;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface InAppMessagingInterface {
    @Nullable
    InAppMessageDisplayDelegate getDisplayDelegate();

    long getDisplayInterval();

    @Nullable
    InAppMessageContentExtender getMessageContentExtender();

    void notifyDisplayConditionsChanged();

    void setAdapterFactoryBlock(@NotNull CustomDisplayAdapterType type, @NotNull Function3<? super Context, ? super InAppMessage, ? super AirshipCachedAssets, ? extends CustomDisplayAdapter> factoryBlock);

    void setDisplayDelegate(@Nullable InAppMessageDisplayDelegate inAppMessageDisplayDelegate);

    void setDisplayInterval(long j);

    void setMessageContentExtender(@Nullable InAppMessageContentExtender inAppMessageContentExtender);
}
