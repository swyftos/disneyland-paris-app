package com.urbanairship.android.layout.property;

import androidx.annotation.ColorInt;
import androidx.core.graphics.ColorUtils;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/android/layout/property/HexColor;", "", "()V", "fromJson", "", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)Ljava/lang/Integer;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HexColor {

    @NotNull
    public static final HexColor INSTANCE = new HexColor();

    private HexColor() {
    }

    @JvmStatic
    @ColorInt
    @Nullable
    public static final Integer fromJson(@Nullable JsonMap json) {
        if (json == null || json.isEmpty()) {
            return null;
        }
        final String strOptString = json.opt("hex").optString();
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        float fCoerceIn = RangesKt.coerceIn(json.opt("alpha").getFloat(1.0f), BitmapDescriptorFactory.HUE_RED, 1.0f);
        if (strOptString.length() == 0) {
            UALog.w("Invalid Color json: %s", json.toString());
            return null;
        }
        try {
            int color = android.graphics.Color.parseColor(strOptString);
            if (fCoerceIn != 1.0f) {
                color = ColorUtils.setAlphaComponent(color, (int) (fCoerceIn * 255));
            }
            return Integer.valueOf(color);
        } catch (Exception e) {
            UALog.e(e, (Function0<String>) new Function0() { // from class: com.urbanairship.android.layout.property.HexColor.fromJson.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Invalid color " + strOptString + ' ';
                }
            });
            return null;
        }
    }
}
