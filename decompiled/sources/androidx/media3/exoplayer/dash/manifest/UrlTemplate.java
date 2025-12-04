package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@UnstableApi
/* loaded from: classes.dex */
public final class UrlTemplate {
    private final List identifierFormatTags;
    private final List identifiers;
    private final List urlPieces;

    public static UrlTemplate compile(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        parseTemplate(str, arrayList, arrayList2, arrayList3);
        return new UrlTemplate(arrayList, arrayList2, arrayList3);
    }

    private UrlTemplate(List list, List list2, List list3) {
        this.urlPieces = list;
        this.identifiers = list2;
        this.identifierFormatTags = list3;
    }

    public String buildUri(String str, long j, int i, long j2) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.identifiers.size(); i2++) {
            sb.append((String) this.urlPieces.get(i2));
            if (((Integer) this.identifiers.get(i2)).intValue() == 1) {
                sb.append(str);
            } else if (((Integer) this.identifiers.get(i2)).intValue() == 2) {
                sb.append(String.format(Locale.US, (String) this.identifierFormatTags.get(i2), Long.valueOf(j)));
            } else if (((Integer) this.identifiers.get(i2)).intValue() == 3) {
                sb.append(String.format(Locale.US, (String) this.identifierFormatTags.get(i2), Integer.valueOf(i)));
            } else if (((Integer) this.identifiers.get(i2)).intValue() == 4) {
                sb.append(String.format(Locale.US, (String) this.identifierFormatTags.get(i2), Long.valueOf(j2)));
            }
        }
        sb.append((String) this.urlPieces.get(this.identifiers.size()));
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void parseTemplate(java.lang.String r11, java.util.List r12, java.util.List r13, java.util.List r14) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.UrlTemplate.parseTemplate(java.lang.String, java.util.List, java.util.List, java.util.List):void");
    }
}
