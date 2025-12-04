package com.urbanairship.android.layout;

import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.info.ViewInfo;
import com.urbanairship.android.layout.model.BaseModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/ModelFactory;", "", "create", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/model/AnyModel;", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/android/layout/info/ViewInfo;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ModelFactory {
    @NotNull
    BaseModel<?, ?, ?> create(@NotNull ViewInfo info, @NotNull ModelEnvironment environment) throws ModelFactoryException;
}
