package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;

/* loaded from: classes5.dex */
public abstract class ToggleStyle {
    private final ToggleType type;

    ToggleStyle(ToggleType toggleType) {
        this.type = toggleType;
    }

    /* renamed from: com.urbanairship.android.layout.property.ToggleStyle$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$urbanairship$android$layout$property$ToggleType;

        static {
            int[] iArr = new int[ToggleType.values().length];
            $SwitchMap$com$urbanairship$android$layout$property$ToggleType = iArr;
            try {
                iArr[ToggleType.SWITCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$ToggleType[ToggleType.CHECKBOX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @NonNull
    public static ToggleStyle fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        String strOptString = jsonMap.opt("type").optString();
        int i = AnonymousClass1.$SwitchMap$com$urbanairship$android$layout$property$ToggleType[ToggleType.from(strOptString).ordinal()];
        if (i == 1) {
            return SwitchStyle.fromJson(jsonMap);
        }
        if (i == 2) {
            return CheckboxStyle.fromJson(jsonMap);
        }
        throw new JsonException("Failed to parse ToggleStyle! Unknown type: " + strOptString);
    }

    @NonNull
    public ToggleType getType() {
        return this.type;
    }
}
