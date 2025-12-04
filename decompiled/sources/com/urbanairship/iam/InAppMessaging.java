package com.urbanairship.iam;

import android.content.Context;
import com.urbanairship.iam.adapter.CustomDisplayAdapter;
import com.urbanairship.iam.adapter.CustomDisplayAdapterType;
import com.urbanairship.iam.assets.AirshipCachedAssets;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0016J2\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2 \u0010\u001f\u001a\u001c\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010$0 H\u0016R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/urbanairship/iam/InAppMessaging;", "Lcom/urbanairship/iam/InAppMessagingInterface;", "executor", "Lcom/urbanairship/iam/InAppMessageAutomationExecutor;", "preparer", "Lcom/urbanairship/iam/InAppMessageAutomationPreparer;", "(Lcom/urbanairship/iam/InAppMessageAutomationExecutor;Lcom/urbanairship/iam/InAppMessageAutomationPreparer;)V", "value", "Lcom/urbanairship/iam/InAppMessageDisplayDelegate;", "displayDelegate", "getDisplayDelegate", "()Lcom/urbanairship/iam/InAppMessageDisplayDelegate;", "setDisplayDelegate", "(Lcom/urbanairship/iam/InAppMessageDisplayDelegate;)V", "", "displayInterval", "getDisplayInterval", "()J", "setDisplayInterval", "(J)V", "Lcom/urbanairship/iam/InAppMessageContentExtender;", "messageContentExtender", "getMessageContentExtender", "()Lcom/urbanairship/iam/InAppMessageContentExtender;", "setMessageContentExtender", "(Lcom/urbanairship/iam/InAppMessageContentExtender;)V", "notifyDisplayConditionsChanged", "", "setAdapterFactoryBlock", "type", "Lcom/urbanairship/iam/adapter/CustomDisplayAdapterType;", "factoryBlock", "Lkotlin/Function3;", "Landroid/content/Context;", "Lcom/urbanairship/iam/InAppMessage;", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "Lcom/urbanairship/iam/adapter/CustomDisplayAdapter;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppMessaging implements InAppMessagingInterface {
    private final InAppMessageAutomationExecutor executor;
    private final InAppMessageAutomationPreparer preparer;

    public InAppMessaging(@NotNull InAppMessageAutomationExecutor executor, @NotNull InAppMessageAutomationPreparer preparer) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(preparer, "preparer");
        this.executor = executor;
        this.preparer = preparer;
    }

    @Override // com.urbanairship.iam.InAppMessagingInterface
    public long getDisplayInterval() {
        return this.preparer.getDisplayInterval();
    }

    @Override // com.urbanairship.iam.InAppMessagingInterface
    public void setDisplayInterval(long j) {
        this.preparer.setDisplayInterval(j);
    }

    @Override // com.urbanairship.iam.InAppMessagingInterface
    @Nullable
    public InAppMessageDisplayDelegate getDisplayDelegate() {
        return this.executor.getDisplayDelegate();
    }

    @Override // com.urbanairship.iam.InAppMessagingInterface
    public void setDisplayDelegate(@Nullable InAppMessageDisplayDelegate inAppMessageDisplayDelegate) {
        this.executor.setDisplayDelegate(inAppMessageDisplayDelegate);
    }

    @Override // com.urbanairship.iam.InAppMessagingInterface
    @Nullable
    public InAppMessageContentExtender getMessageContentExtender() {
        return this.preparer.getMessageContentExtender();
    }

    @Override // com.urbanairship.iam.InAppMessagingInterface
    public void setMessageContentExtender(@Nullable InAppMessageContentExtender inAppMessageContentExtender) {
        this.preparer.setMessageContentExtender(inAppMessageContentExtender);
    }

    @Override // com.urbanairship.iam.InAppMessagingInterface
    public void setAdapterFactoryBlock(@NotNull CustomDisplayAdapterType type, @NotNull Function3<? super Context, ? super InAppMessage, ? super AirshipCachedAssets, ? extends CustomDisplayAdapter> factoryBlock) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(factoryBlock, "factoryBlock");
        this.preparer.setAdapterFactoryBlock(type, factoryBlock);
    }

    @Override // com.urbanairship.iam.InAppMessagingInterface
    public void notifyDisplayConditionsChanged() {
        this.executor.notifyDisplayConditionsChanged();
    }
}
