package com.urbanairship.android.layout;

import androidx.annotation.NonNull;
import com.urbanairship.android.layout.property.PresentationType;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;

/* loaded from: classes5.dex */
public abstract class BasePresentation {
    private final PresentationType type;

    public BasePresentation(@NonNull PresentationType presentationType) {
        this.type = presentationType;
    }

    /* renamed from: com.urbanairship.android.layout.BasePresentation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$urbanairship$android$layout$property$PresentationType;

        static {
            int[] iArr = new int[PresentationType.values().length];
            $SwitchMap$com$urbanairship$android$layout$property$PresentationType = iArr;
            try {
                iArr[PresentationType.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$PresentationType[PresentationType.MODAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$PresentationType[PresentationType.EMBEDDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @NonNull
    public static BasePresentation fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        String strOptString = jsonMap.opt("type").optString();
        int i = AnonymousClass1.$SwitchMap$com$urbanairship$android$layout$property$PresentationType[PresentationType.from(strOptString).ordinal()];
        if (i == 1) {
            return BannerPresentation.fromJson(jsonMap);
        }
        if (i == 2) {
            return ModalPresentation.fromJson(jsonMap);
        }
        if (i == 3) {
            return EmbeddedPresentation.fromJson(jsonMap);
        }
        throw new JsonException("Failed to parse presentation! Unknown type: " + strOptString);
    }

    @NonNull
    public PresentationType getType() {
        return this.type;
    }
}
