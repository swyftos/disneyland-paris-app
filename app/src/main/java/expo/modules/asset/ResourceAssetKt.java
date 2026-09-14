package expo.modules.asset;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import expo.modules.core.errors.InvalidArgumentException;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a\u001f\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b\u001a\u001f\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1836d2 = {"ANDROID_EMBEDDED_URL_BASE_RESOURCE", "", "openAssetResourceStream", "Ljava/io/InputStream;", "context", "Landroid/content/Context;", "assetName", "openAndroidResStream", "resourceFilePath", "findResourceId", "", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "findResourceIdForAndroidResPath", "expo-asset_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nResourceAsset.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResourceAsset.kt\nexpo/modules/asset/ResourceAssetKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,62:1\n1#2:63\n29#3:64\n*S KotlinDebug\n*F\n+ 1 ResourceAsset.kt\nexpo/modules/asset/ResourceAssetKt\n*L\n43#1:64\n*E\n"})
public final class ResourceAssetKt {

    @NotNull
    public static final String ANDROID_EMBEDDED_URL_BASE_RESOURCE = "file:///android_res/";

    @NotNull
    public static final InputStream openAssetResourceStream(@NotNull Context context, @NotNull String assetName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Integer numFindResourceId = findResourceId(context, assetName);
        if (numFindResourceId == null) {
            throw new Resources.NotFoundException(assetName);
        }
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(numFindResourceId.intValue());
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
        return inputStreamOpenRawResource;
    }

    @NotNull
    public static final InputStream openAndroidResStream(@NotNull Context context, @NotNull String resourceFilePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resourceFilePath, "resourceFilePath");
        Integer numFindResourceIdForAndroidResPath = findResourceIdForAndroidResPath(context, resourceFilePath);
        if (numFindResourceIdForAndroidResPath == null) {
            throw new Resources.NotFoundException(resourceFilePath);
        }
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(numFindResourceIdForAndroidResPath.intValue());
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
        return inputStreamOpenRawResource;
    }

    private static final Integer findResourceId(Context context, String str) {
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        Integer numValueOf = Integer.valueOf(resources.getIdentifier(str, "raw", packageName));
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf;
        }
        Integer numValueOf2 = Integer.valueOf(resources.getIdentifier(str, "drawable", packageName));
        if (numValueOf2.intValue() != 0) {
            return numValueOf2;
        }
        return null;
    }

    private static final Integer findResourceIdForAndroidResPath(Context context, String str) {
        if (!StringsKt.startsWith$default(str, ANDROID_EMBEDDED_URL_BASE_RESOURCE, false, 2, (Object) null)) {
            throw new InvalidArgumentException("Invalid resource file path: " + str);
        }
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() < 3) {
            throw new InvalidArgumentException("Invalid resource file path: " + str);
        }
        String str2 = pathSegments.get(1);
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        String strSubstringBefore$default = StringsKt.substringBefore$default(str2, '-', (String) null, 2, (Object) null);
        String str3 = pathSegments.get(2);
        Intrinsics.checkNotNull(str3);
        Integer numValueOf = Integer.valueOf(context.getResources().getIdentifier(StringsKt.substringBeforeLast(str3, '.', str3), strSubstringBefore$default, context.getPackageName()));
        if (numValueOf.intValue() != 0) {
            return numValueOf;
        }
        return null;
    }
}
