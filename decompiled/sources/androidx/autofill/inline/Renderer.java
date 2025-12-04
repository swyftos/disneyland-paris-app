package androidx.autofill.inline;

import android.app.PendingIntent;
import android.app.slice.Slice;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.autofill.inline.common.SlicedContent;
import androidx.autofill.inline.v1.InlineSuggestionUi;

@RequiresApi(api = 30)
/* loaded from: classes.dex */
public final class Renderer {
    @NonNull
    public static Bundle getSupportedInlineUiVersionsAsBundle() {
        Bundle bundle = new Bundle();
        VersionUtils.writeSupportedVersions(bundle);
        return bundle;
    }

    @Nullable
    public static View render(@NonNull Context context, @NonNull Slice slice, @NonNull Bundle bundle) {
        String version = SlicedContent.getVersion(slice);
        if (!VersionUtils.isVersionSupported(version)) {
            Log.w("Renderer", "Content version unsupported.");
            return null;
        }
        Bundle styleByVersion = VersionUtils.readStyleByVersion(bundle, version);
        if (styleByVersion == null) {
            Log.w("Renderer", "Cannot find a style with the same version as the slice.");
            return null;
        }
        version.hashCode();
        if (version.equals(UiVersions.INLINE_UI_VERSION_1)) {
            InlineSuggestionUi.Style styleFromBundle = InlineSuggestionUi.fromBundle(styleByVersion);
            InlineSuggestionUi.Content contentFromSlice = InlineSuggestionUi.fromSlice(slice);
            if (styleFromBundle == null || slice == null) {
                return null;
            }
            return InlineSuggestionUi.render(context, contentFromSlice, styleFromBundle);
        }
        Log.w("Renderer", "Renderer does not support the style/content version: " + version);
        return null;
    }

    @Nullable
    public static PendingIntent getAttributionIntent(@NonNull Slice slice) {
        String version = SlicedContent.getVersion(slice);
        if (!VersionUtils.isVersionSupported(version)) {
            Log.w("Renderer", "Content version unsupported.");
            return null;
        }
        version.hashCode();
        if (version.equals(UiVersions.INLINE_UI_VERSION_1)) {
            InlineSuggestionUi.Content contentFromSlice = InlineSuggestionUi.fromSlice(slice);
            if (contentFromSlice == null) {
                return null;
            }
            return InlineSuggestionUi.getAttributionIntent(contentFromSlice);
        }
        Log.w("Renderer", "Renderer does not support the content version: " + version);
        return null;
    }
}
