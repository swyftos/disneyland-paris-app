package com.urbanairship.android.layout.environment;

import androidx.annotation.RestrictTo;
import com.dlp.BluetoothManager;
import com.urbanairship.android.layout.reporting.LayoutData;
import com.urbanairship.json.JsonValue;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/environment/ThomasActionRunner;", "", "run", "", "actions", "", "", "Lcom/urbanairship/json/JsonValue;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/android/layout/reporting/LayoutData;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface ThomasActionRunner {
    void run(@NotNull Map<String, ? extends JsonValue> actions, @NotNull LayoutData state);
}
