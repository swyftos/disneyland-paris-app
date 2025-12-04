package androidx.autofill.inline;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.autofill.inline.UiVersions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequiresApi(api = 30)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class VersionUtils {
    public static boolean isVersionSupported(@Nullable String str) {
        return UiVersions.getUiVersions().contains(str);
    }

    @NonNull
    public static List<String> getSupportedVersions(@NonNull Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        ArrayList<String> stringArrayList = bundle.getStringArrayList("androidx.autofill.inline.ui.version:key");
        if (stringArrayList != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (isVersionSupported(next)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public static void writeSupportedVersions(@NonNull Bundle bundle) {
        bundle.putStringArrayList("androidx.autofill.inline.ui.version:key", new ArrayList<>(UiVersions.getUiVersions()));
    }

    public static void writeStylesToBundle(@NonNull List<UiVersions.Style> list, @NonNull Bundle bundle) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (UiVersions.Style style : list) {
            String version = style.getVersion();
            arrayList.add(style.getVersion());
            bundle.putBundle(version, style.getBundle());
        }
        bundle.putStringArrayList("androidx.autofill.inline.ui.version:key", arrayList);
    }

    @Nullable
    public static Bundle readStyleByVersion(@NonNull Bundle bundle, @NonNull String str) {
        return bundle.getBundle(str);
    }
}
