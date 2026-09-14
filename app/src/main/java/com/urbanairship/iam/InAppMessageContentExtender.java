package com.urbanairship.iam;

import com.facebook.react.animated.InterpolationAnimatedNode;
import com.urbanairship.iam.content.InAppMessageDisplayContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006À\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/iam/InAppMessageContentExtender;", "", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_EXTEND, "Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "message", "Lcom/urbanairship/iam/InAppMessage;", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface InAppMessageContentExtender {

    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        @NotNull
        public static InAppMessageDisplayContent extend(@NotNull InAppMessageContentExtender inAppMessageContentExtender, @NotNull InAppMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return InAppMessageContentExtender.super.extend(message);
        }
    }

    @NotNull
    default InAppMessageDisplayContent extend(@NotNull InAppMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return message.getDisplayContent();
    }
}
