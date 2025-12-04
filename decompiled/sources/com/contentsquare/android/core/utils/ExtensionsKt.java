package com.contentsquare.android.core.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.contentsquare.android.core.features.logging.Logger;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0003*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0001\u001a\"\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r\u001a\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003\u001a\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0016\u001a\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0003*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003\u001a\u0012\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003\u001a\u0018\u0010\u001c\u001a\u00020\u0019*\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e\u001a\f\u0010\u001f\u001a\u00020 *\u0004\u0018\u00010 \u001a\u0014\u0010!\u001a\u00020\u0003*\u00020\"2\u0006\u0010#\u001a\u00020\u0003H\u0007\u001a\u001c\u0010$\u001a\b\u0012\u0004\u0012\u0002H%0\u001e\"\u0004\b\u0000\u0010%*\b\u0012\u0004\u0012\u0002H%0&\u001a\u0012\u0010'\u001a\u00020\t*\u00020(2\u0006\u0010)\u001a\u00020*\u001a\n\u0010+\u001a\u00020\u0003*\u00020\u0003\u001a\n\u0010,\u001a\u00020\u0003*\u00020\u0001\u001a\n\u0010-\u001a\u00020\u0003*\u00020.\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"HALF_BYTE", "", "HEX_CHARS", "", "NIBBLE_MASK", "convertStackTraceToString", "", "maxLine", "drawOnTop", "", "Landroid/graphics/Bitmap;", "bmp", "posX", "", "posY", "getIntOrNull", "Lorg/json/JSONObject;", "name", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "getJSONObjectOrNull", "getLongOrNull", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Long;", "getStringOrNull", "isDerivedInstanceOf", "", "", "baseClassName", "isVersionBlocked", "blockedVersions", "", "orDefault", "Landroid/graphics/Bitmap$Config;", "resourceStringByName", "Landroid/content/Context;", "resourceName", "reversedList", ExifInterface.GPS_DIRECTION_TRUE, "", "startServiceSafely", "Landroid/app/Application;", NotificationCompat.CATEGORY_SERVICE, "Landroid/content/Intent;", "toBase64", "toColorHex", "toHexString", "", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extensions.kt\ncom/contentsquare/android/core/utils/ExtensionsKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,231:1\n13586#2,2:232\n1549#3:234\n1620#3,3:235\n*S KotlinDebug\n*F\n+ 1 Extensions.kt\ncom/contentsquare/android/core/utils/ExtensionsKt\n*L\n78#1:232,2\n136#1:234\n136#1:235,3\n*E\n"})
/* loaded from: classes2.dex */
public final class ExtensionsKt {
    private static final int HALF_BYTE = 4;

    @NotNull
    private static final String HEX_CHARS = "0123456789ABCDEF";
    private static final int NIBBLE_MASK = 15;

    @NotNull
    public static final String convertStackTraceToString(Throwable th, int i) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        List listTake = CollectionsKt.take(StringsKt.lines(ExceptionsKt.stackTraceToString(th)), i);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listTake, 10));
        Iterator it = listTake.iterator();
        while (it.hasNext()) {
            arrayList.add(((String) it.next()) + '\n');
        }
        return StringsKt.replace$default(arrayList.toString(), ",", "", false, 4, (Object) null);
    }

    public static /* synthetic */ String convertStackTraceToString$default(Throwable th, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 50;
        }
        return convertStackTraceToString(th, i);
    }

    public static final void drawOnTop(Bitmap bitmap, Bitmap bmp, float f, float f2) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Intrinsics.checkNotNullParameter(bmp, "bmp");
        new Canvas(bitmap).drawBitmap(bmp, f, f2, (Paint) null);
    }

    @Nullable
    public static final Integer getIntOrNull(JSONObject jSONObject, String name) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!jSONObject.has(name) || jSONObject.isNull(name)) {
            return null;
        }
        return Integer.valueOf(jSONObject.getInt(name));
    }

    @Nullable
    public static final JSONObject getJSONObjectOrNull(JSONObject jSONObject, String name) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!jSONObject.has(name) || jSONObject.isNull(name)) {
            return null;
        }
        return jSONObject.getJSONObject(name);
    }

    @Nullable
    public static final Long getLongOrNull(JSONObject jSONObject, String name) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!jSONObject.has(name) || jSONObject.isNull(name)) {
            return null;
        }
        return Long.valueOf(jSONObject.getLong(name));
    }

    @Nullable
    public static final String getStringOrNull(JSONObject jSONObject, String name) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!jSONObject.has(name) || jSONObject.isNull(name)) {
            return null;
        }
        return jSONObject.getString(name);
    }

    public static final boolean isDerivedInstanceOf(Object obj, String baseClassName) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(baseClassName, "baseClassName");
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (Intrinsics.areEqual(superclass.getSimpleName(), baseClassName)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isVersionBlocked(String str, List<String> blockedVersions) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(blockedVersions, "blockedVersions");
        for (String str2 : blockedVersions) {
            if (Intrinsics.areEqual(str, str2) || VersionMatcher.match(str2, str)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final Bitmap.Config orDefault(Bitmap.Config config) {
        return config == null ? Bitmap.Config.ARGB_8888 : config;
    }

    @SuppressLint({"DiscouragedApi"})
    @NotNull
    public static final String resourceStringByName(Context context, String resourceName) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(resourceName, "resourceName");
        try {
            int identifier = context.getResources().getIdentifier(resourceName, "string", context.getPackageName());
            String string = identifier != 0 ? context.getResources().getString(identifier) : "";
            Intrinsics.checkNotNullExpressionValue(string, "{\n        val resourceId…       \"\"\n        }\n    }");
            return string;
        } catch (Resources.NotFoundException e) {
            new Logger("Extension").d("Resource not found: " + e.getMessage());
            return "";
        }
    }

    @NotNull
    public static final <T> List<T> reversedList(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return CollectionsKt.toList(iterable);
        }
        List<T> mutableList = CollectionsKt.toMutableList(iterable);
        CollectionsKt.reverse(mutableList);
        return mutableList;
    }

    public static final void startServiceSafely(Application application, Intent service) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        Intrinsics.checkNotNullParameter(service, "service");
        try {
            application.startService(service);
        } catch (IllegalStateException unused) {
            new Logger(null, 1, 0 == true ? 1 : 0).i("Cannot open cs-in-app, please retry.");
        }
    }

    @NotNull
    public static final String toBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 0);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(this.toByteArray(), Base64.DEFAULT)");
        return strEncodeToString;
    }

    @NotNull
    public static final String toColorHex(int i) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.ROOT, "#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        return str;
    }

    @NotNull
    public static final String toHexString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(HEX_CHARS.charAt((b >> 4) & 15));
            sb.append(HEX_CHARS.charAt(b & Ascii.SI));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "hash.toString()");
        return string;
    }
}
