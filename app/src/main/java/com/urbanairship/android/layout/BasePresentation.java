package com.urbanairship.android.layout;

import androidx.annotation.NonNull;
import com.urbanairship.android.layout.property.PresentationType;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BasePresentation {
    private final PresentationType type;

    public BasePresentation(@NonNull PresentationType presentationType) {
        this.type = presentationType;
    }

    /* JADX INFO: renamed from: com.urbanairship.android.layout.BasePresentation$1 */
    static /* synthetic */ class C47051 {

        /* JADX INFO: renamed from: $SwitchMap$com$urbanairship$android$layout$property$PresentationType */
        static final /* synthetic */ int[] f3726x91f25e0b;

        static {
            int[] iArr = new int[PresentationType.values().length];
            f3726x91f25e0b = iArr;
            try {
                iArr[PresentationType.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3726x91f25e0b[PresentationType.MODAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3726x91f25e0b[PresentationType.EMBEDDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @NonNull
    public static BasePresentation fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        String strOptString = jsonMap.opt("type").optString();
        int i = C47051.f3726x91f25e0b[PresentationType.from(strOptString).ordinal()];
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
