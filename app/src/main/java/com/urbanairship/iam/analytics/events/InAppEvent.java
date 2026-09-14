package com.urbanairship.iam.analytics.events;

import androidx.annotation.RestrictTo;
import com.urbanairship.analytics.EventType;
import com.urbanairship.json.JsonSerializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/iam/analytics/events/InAppEvent;", "", "data", "Lcom/urbanairship/json/JsonSerializable;", "getData", "()Lcom/urbanairship/json/JsonSerializable;", "eventType", "Lcom/urbanairship/analytics/EventType;", "getEventType", "()Lcom/urbanairship/analytics/EventType;", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface InAppEvent {
    @Nullable
    JsonSerializable getData();

    @NotNull
    EventType getEventType();
}
