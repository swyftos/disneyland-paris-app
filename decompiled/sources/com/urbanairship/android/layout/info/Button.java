package com.urbanairship.android.layout.info;

import com.urbanairship.android.layout.property.ButtonClickBehaviorType;
import com.urbanairship.android.layout.property.TapEffect;
import com.urbanairship.json.JsonValue;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003R \u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/info/Button;", "Lcom/urbanairship/android/layout/info/View;", "Lcom/urbanairship/android/layout/info/Accessible;", "Lcom/urbanairship/android/layout/info/Identifiable;", "actions", "", "", "Lcom/urbanairship/json/JsonValue;", "getActions", "()Ljava/util/Map;", "clickBehaviors", "", "Lcom/urbanairship/android/layout/property/ButtonClickBehaviorType;", "getClickBehaviors", "()Ljava/util/List;", "reportingMetadata", "getReportingMetadata", "()Lcom/urbanairship/json/JsonValue;", "tapEffect", "Lcom/urbanairship/android/layout/property/TapEffect;", "getTapEffect", "()Lcom/urbanairship/android/layout/property/TapEffect;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface Button extends View, Accessible, Identifiable {
    @Nullable
    Map<String, JsonValue> getActions();

    @NotNull
    List<ButtonClickBehaviorType> getClickBehaviors();

    @Nullable
    JsonValue getReportingMetadata();

    @NotNull
    TapEffect getTapEffect();
}
