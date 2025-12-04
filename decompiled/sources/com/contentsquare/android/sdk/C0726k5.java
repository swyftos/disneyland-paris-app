package com.contentsquare.android.sdk;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Base64;
import com.contentsquare.android.core.utils.ExtensionsKt;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

@SourceDebugExtension({"SMAP\nScreenWiseGraphHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenWiseGraphHelper.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/screengraphhelper/ScreenWiseGraphHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,182:1\n766#2:183\n857#2,2:184\n1855#2,2:186\n1549#2:188\n1620#2,3:189\n1963#2,14:195\n1855#2,2:209\n1549#2:211\n1620#2,3:212\n43#3,3:192\n*S KotlinDebug\n*F\n+ 1 ScreenWiseGraphHelper.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/screenrecorder/screengraphhelper/ScreenWiseGraphHelper\n*L\n42#1:183\n42#1:184,2\n43#1:186,2\n66#1:188\n66#1:189,3\n120#1:195,14\n152#1:209,2\n174#1:211\n174#1:212,3\n100#1:192,3\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.k5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0726k5 {
    public static final String a(C0726k5 c0726k5, Rect rect, Bitmap bitmap) {
        c0726k5.getClass();
        Bitmap bitmap2 = Bitmap.createBitmap(rect.width(), rect.height(), ExtensionsKt.orDefault(bitmap.getConfig()));
        Intrinsics.checkNotNullExpressionValue(bitmap2, "createBitmap(\n          …fig.orDefault()\n        )");
        Canvas canvas = new Canvas(bitmap2);
        Rect rect2 = new Rect(rect);
        rect2.offsetTo(0, 0);
        canvas.drawBitmap(bitmap, rect, rect2, (Paint) null);
        Intrinsics.checkNotNullParameter(bitmap2, "bitmap");
        if (bitmap2.getHeight() <= 0 || bitmap2.getWidth() <= 0) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] imageByteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(imageByteArray, "stream.toByteArray()");
        Intrinsics.checkNotNullParameter(imageByteArray, "imageByteArray");
        String strEncodeToString = Base64.encodeToString(imageByteArray, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(imageByteArray, Base64.NO_WRAP)");
        return strEncodeToString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Iterable, java.util.List<com.contentsquare.android.sdk.G2>] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.contentsquare.android.sdk.j5] */
    public static void a(G2 g2, C0716j5 c0716j5, C0706i5 c0706i5) throws JSONException {
        ?? EmptyList;
        c0706i5.invoke(g2);
        List<G2> list = g2.c;
        if (list != null) {
            EmptyList = new ArrayList();
            for (Object obj : list) {
                if (((Boolean) c0716j5.invoke(obj)).booleanValue()) {
                    EmptyList.add(obj);
                }
            }
        } else {
            EmptyList = 0;
        }
        if (EmptyList == 0) {
            EmptyList = CollectionsKt.emptyList();
        }
        Iterator it = EmptyList.iterator();
        while (it.hasNext()) {
            a((G2) it.next(), (C0716j5) c0716j5, c0706i5);
        }
        g2.c = EmptyList;
    }

    public final void a(@NotNull J context, @NotNull Rect rootViewRect, @NotNull Bitmap screenshot, @NotNull G2 containerViewJson) throws JSONException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootViewRect, "rootViewRect");
        Intrinsics.checkNotNullParameter(screenshot, "screenshot");
        Intrinsics.checkNotNullParameter(containerViewJson, "containerViewJson");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootViewRect, "rootViewRect");
        Intrinsics.checkNotNullParameter(screenshot, "screenshot");
        C0716j5 c0716j5 = new C0716j5(screenshot.getHeight() - (rootViewRect.bottom - context.a.bottom));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootViewRect, "rootViewRect");
        Intrinsics.checkNotNullParameter(screenshot, "screenshot");
        a(containerViewJson, c0716j5, new C0706i5(screenshot.getHeight() - (rootViewRect.bottom - context.a.bottom), this, screenshot));
    }
}
