package coil3;

import com.google.android.gms.actions.SearchIntents;
import com.urbanairship.actions.ToastAction;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001aL\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003\u001a:\u0010\t\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\u0016\u0010\u0011\u001a\u00020\u0001*\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003H\u0007\u001a \u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\u0015\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\"\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0018\u001a\u00020\u0019*\u0004\u0018\u00010\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, m1836d2 = {"Uri", "Lcoil3/Uri;", "scheme", "", "authority", "path", SearchIntents.EXTRA_QUERY, "fragment", "separator", "buildData", "pathSegments", "", "getPathSegments", "(Lcoil3/Uri;)Ljava/util/List;", "filePath", "getFilePath", "(Lcoil3/Uri;)Ljava/lang/String;", "toUri", "parseUri", "data", "original", "percentDecode", "bytes", "", ToastAction.LENGTH_KEY, "", "getLength", "(Ljava/lang/String;)I", "coil-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class UriKt {
    @JvmOverloads
    @NotNull
    public static final Uri toUri(@NotNull String str) {
        return toUri$default(str, null, 1, null);
    }

    public static /* synthetic */ Uri Uri$default(String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        if ((i & 16) != 0) {
            str5 = null;
        }
        if ((i & 32) != 0) {
            str6 = Path.DIRECTORY_SEPARATOR;
        }
        return Uri(str, str2, str3, str4, str5, str6);
    }

    @NotNull
    public static final Uri Uri(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull String str6) {
        if (str == null && str2 == null && str3 == null && str4 == null && str5 == null) {
            throw new IllegalArgumentException("At least one of scheme, authority, path, query, or fragment must be non-null.");
        }
        return new Uri(buildData(str, str2, str3, str4, str5), str6, str, str2, str3, str4, str5);
    }

    private static final String buildData(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
            sb.append(':');
        }
        if (str2 != null) {
            sb.append("//");
            sb.append(str2);
        }
        if (str3 != null) {
            sb.append(str3);
        }
        if (str4 != null) {
            sb.append('?');
            sb.append(str4);
        }
        if (str5 != null) {
            sb.append('#');
            sb.append(str5);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @NotNull
    public static final List<String> getPathSegments(@NotNull Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int iIndexOf$default = -1;
        while (iIndexOf$default < path.length()) {
            int i = iIndexOf$default + 1;
            iIndexOf$default = StringsKt.indexOf$default((CharSequence) path, '/', i, false, 4, (Object) null);
            if (iIndexOf$default == -1) {
                iIndexOf$default = path.length();
            }
            String strSubstring = path.substring(i, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            if (strSubstring.length() > 0) {
                arrayList.add(strSubstring);
            }
        }
        return arrayList;
    }

    @Nullable
    public static final String getFilePath(@NotNull Uri uri) {
        List<String> pathSegments = getPathSegments(uri);
        if (pathSegments.isEmpty()) {
            return null;
        }
        String path = uri.getPath();
        Intrinsics.checkNotNull(path);
        return CollectionsKt.joinToString$default(pathSegments, uri.getSeparator(), StringsKt.startsWith$default(path, uri.getSeparator(), false, 2, (Object) null) ? uri.getSeparator() : "", null, 0, null, null, 60, null);
    }

    public static /* synthetic */ Uri toUri$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = Path.DIRECTORY_SEPARATOR;
        }
        return toUri(str, str2);
    }

    @JvmOverloads
    @NotNull
    public static final Uri toUri(@NotNull String str, @NotNull String str2) {
        return parseUri(!Intrinsics.areEqual(str2, "/") ? StringsKt.replace$default(str, str2, "/", false, 4, (Object) null) : str, str, str2);
    }

    private static final Uri parseUri(String str, String str2, String str3) {
        String strSubstring;
        String strSubstring2;
        String strSubstring3;
        String strSubstring4;
        String strSubstring5;
        boolean z = true;
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        while (i6 < str.length()) {
            char cCharAt = str.charAt(i6);
            if (cCharAt != '#') {
                if (cCharAt != '/') {
                    if (cCharAt != ':') {
                        if (cCharAt == '?' && i3 == -1 && i == -1) {
                            i3 = i6 + 1;
                        }
                    } else if (z && i3 == -1 && i == -1) {
                        int i7 = i6 + 2;
                        if (i7 < str2.length() && str2.charAt(i6 + 1) == '/' && str2.charAt(i7) == '/') {
                            i4 = i6 + 3;
                            z = false;
                            i5 = i6;
                            i6 = i7;
                        } else if (Intrinsics.areEqual(str, str2)) {
                            i2 = i6 + 1;
                            i5 = i6;
                            i6 = i2;
                            i4 = i6;
                        }
                    }
                } else if (i2 == -1 && i3 == -1 && i == -1) {
                    i2 = i4 == -1 ? 0 : i6;
                    z = false;
                }
            } else if (i == -1) {
                i = i6 + 1;
            }
            i6++;
        }
        int iMin = Math.min(i == -1 ? Integer.MAX_VALUE : i - 1, str.length());
        int iMin2 = Math.min(i3 == -1 ? Integer.MAX_VALUE : i3 - 1, iMin);
        if (i4 != -1) {
            strSubstring2 = str.substring(0, i5);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            strSubstring = str.substring(i4, Math.min(i2 != -1 ? i2 : Integer.MAX_VALUE, iMin2));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        } else {
            strSubstring = null;
            strSubstring2 = null;
        }
        if (i2 != -1) {
            strSubstring3 = str.substring(i2, iMin2);
            Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
        } else {
            strSubstring3 = null;
        }
        if (i3 != -1) {
            strSubstring4 = str.substring(i3, iMin);
            Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
        } else {
            strSubstring4 = null;
        }
        if (i != -1) {
            strSubstring5 = str.substring(i, str.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
        } else {
            strSubstring5 = null;
        }
        byte[] bArr = new byte[Math.max(0, Math.max(getLength(strSubstring2), Math.max(getLength(strSubstring), Math.max(getLength(strSubstring3), Math.max(getLength(strSubstring4), getLength(strSubstring5))))) - 2)];
        return new Uri(str, str3, strSubstring2 != null ? percentDecode(strSubstring2, bArr) : null, strSubstring != null ? percentDecode(strSubstring, bArr) : null, strSubstring3 != null ? percentDecode(strSubstring3, bArr) : null, strSubstring4 != null ? percentDecode(strSubstring4, bArr) : null, strSubstring5 != null ? percentDecode(strSubstring5, bArr) : null);
    }

    private static final String percentDecode(String str, byte[] bArr) {
        int length = str.length();
        int i = 0;
        int iMax = Math.max(0, length - 2);
        int i2 = 0;
        while (true) {
            if (i >= iMax) {
                if (i == i2) {
                    return str;
                }
                if (i >= length) {
                    return StringsKt.decodeToString$default(bArr, 0, i2, false, 5, null);
                }
            } else if (str.charAt(i) == '%') {
                int i3 = i + 3;
                try {
                    String strSubstring = str.substring(i + 1, i3);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    bArr[i2] = (byte) Integer.parseInt(strSubstring, CharsKt.checkRadix(16));
                    i2++;
                    i = i3;
                } catch (NumberFormatException unused) {
                    bArr[i2] = (byte) str.charAt(i);
                    i2++;
                    i++;
                }
            }
            bArr[i2] = (byte) str.charAt(i);
            i2++;
            i++;
        }
    }

    private static final int getLength(String str) {
        if (str != null) {
            return str.length();
        }
        return 0;
    }
}
