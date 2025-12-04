package com.contentsquare.android.sdk;

import android.content.Context;
import androidx.annotation.IntRange;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.FileStorageUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@SourceDebugExtension({"SMAP\nEventStorageManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventStorageManager.kt\ncom/contentsquare/android/analytics/internal/features/events/storage/EventStorageManager\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,325:1\n11335#2:326\n11670#2,3:327\n*S KotlinDebug\n*F\n+ 1 EventStorageManager.kt\ncom/contentsquare/android/analytics/internal/features/events/storage/EventStorageManager\n*L\n247#1:326\n247#1:327,3\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.z1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0867z1 {

    @NotNull
    public final FileStorageUtil a;

    @NotNull
    public final A5 b;

    @NotNull
    public final M7 c;

    @NotNull
    public final Logger d;

    @NotNull
    public final String e;
    public String f;
    public int g;
    public int h;
    public int i;

    public C0867z1(@NotNull Context context, @NotNull A5 session, @NotNull M7 userIdRestoreHelper) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(userIdRestoreHelper, "userIdRestoreHelper");
        FileStorageUtil storageUtil = new FileStorageUtil();
        String appFilesLocation = context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(appFilesLocation, "context.filesDir.absolutePath");
        Intrinsics.checkNotNullParameter(storageUtil, "storageUtil");
        Intrinsics.checkNotNullParameter(appFilesLocation, "appFilesLocation");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(userIdRestoreHelper, "userIdRestoreHelper");
        this.a = storageUtil;
        this.b = session;
        this.c = userIdRestoreHelper;
        this.d = new Logger("EventStorageManager");
        this.e = appFilesLocation + File.separator + "cs";
        this.h = -1;
        b();
    }

    public final synchronized void a(JSONObject jSONObject, int i, int i2) {
        try {
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "event.toString()");
            String strReplace$default = StringsKt.replace$default(string, "\n", "", false, 4, (Object) null);
            this.d.d("Storing json to Session " + i + ", bucket " + i2 + ": " + strReplace$default);
            FileStorageUtil fileStorageUtil = this.a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.e);
            String str = File.separator;
            sb.append(str);
            sb.append("evts");
            sb.append(str);
            sb.append(i);
            fileStorageUtil.mkdirs(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.e + str + "evts" + str + i);
            sb2.append(str);
            sb2.append(i2);
            String string2 = sb2.toString();
            File file = this.a.getFile(string2);
            if (!file.exists() || file.length() == 0) {
                String strA = this.c.a();
                if (strA != null) {
                    strReplace$default = "cs_user_id:" + strA + '\n' + strReplace$default;
                }
            }
            this.a.writeStringToFile(string2, strReplace$default + '\n', true);
        } catch (Throwable th) {
            throw th;
        }
    }

    @NotNull
    public final synchronized Pair<String, List<JSONObject>> b(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        String strComponent1;
        ArrayList arrayList;
        this.d.d("Retrieving bucket content for session " + i + " bucket " + i2 + ' ');
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        String str = File.separator;
        sb.append(str);
        sb.append("evts");
        sb.append(str);
        sb.append(i);
        sb.append(str);
        sb.append(i2);
        Pair<String, List<String>> pairB = b(sb.toString());
        strComponent1 = pairB.component1();
        List<String> listComponent2 = pairB.component2();
        arrayList = new ArrayList(listComponent2.size());
        Iterator<String> it = listComponent2.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(new JSONObject(it.next()));
            } catch (JSONException e) {
                Q2.a(this.d, "!! DATALOSS !! Failed to serialize string to JSON Object", e);
            }
        }
        return new Pair<>(strComponent1, arrayList);
    }

    public final Pair<String, List<String>> b(String str) {
        List mutableList = CollectionsKt.toMutableList((Collection) this.a.readFileContentByLine(str));
        String strSubstring = null;
        if (!mutableList.isEmpty()) {
            String str2 = (String) mutableList.get(0);
            if (StringsKt.startsWith$default(str2, "cs_user_id:", false, 2, (Object) null)) {
                strSubstring = str2.substring(11);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                mutableList.remove(0);
            }
        }
        return new Pair<>(strSubstring, mutableList);
    }

    public final void b() throws NumberFormatException {
        int size;
        int i = this.b.k;
        if (this.h != i) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.e);
            String str = File.separator;
            sb.append(str);
            sb.append("evts");
            sb.append(str);
            sb.append(i);
            String string = sb.toString();
            Intrinsics.checkNotNullParameter(string, "<set-?>");
            this.f = string;
            this.h = i;
            int iA = a(i);
            this.g = iA;
            if (iA == 0) {
                size = 0;
            } else {
                int i2 = this.h;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.e + str + "evts" + str + i2);
                sb2.append(str);
                sb2.append(iA);
                size = b(sb2.toString()).getSecond().size();
            }
            this.i = size;
        }
    }

    public final synchronized void a(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        try {
            FileStorageUtil fileStorageUtil = this.a;
            StringBuilder sb = new StringBuilder();
            sb.append(this.e);
            String str = File.separator;
            sb.append(str);
            sb.append("evts");
            sb.append(str);
            sb.append(i);
            sb.append(str);
            sb.append(i2);
            if (!fileStorageUtil.deleteFileOrFolder(sb.toString())) {
                this.d.e("failed to delete file for session " + i + ", bucket " + i2);
            }
            String str2 = this.e + str + "evts" + str + i;
            String[] strArrListFolder = this.a.listFolder(str2);
            if (strArrListFolder == null || strArrListFolder.length == 0) {
                this.a.deleteFileOrFolder(str2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public final int a(int i) throws NumberFormatException {
        Integer numValueOf;
        int i2;
        int i3;
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        String str = File.separator;
        sb.append(str);
        sb.append("evts");
        sb.append(str);
        sb.append(i);
        String[] strArrListFolder = this.a.listFolder(sb.toString());
        if (strArrListFolder == null || strArrListFolder.length == 0) {
            numValueOf = null;
        } else {
            String str2 = strArrListFolder[0];
            try {
                i2 = Integer.parseInt(str2);
            } catch (NumberFormatException e) {
                Q2.a(this.d, "[initBucketNumberAndSize] trying to convert the bucket : " + str2 + " to an integer but failed", e);
                i2 = 0;
            }
            numValueOf = Integer.valueOf(i2);
            ?? it = new kotlin.ranges.IntRange(1, ArraysKt.getLastIndex(strArrListFolder)).iterator();
            while (it.hasNext()) {
                String str3 = strArrListFolder[it.nextInt()];
                try {
                    i3 = Integer.parseInt(str3);
                } catch (NumberFormatException e2) {
                    Q2.a(this.d, "[initBucketNumberAndSize] trying to convert the bucket : " + str3 + " to an integer but failed", e2);
                    i3 = 0;
                }
                Integer numValueOf2 = Integer.valueOf(i3);
                if (numValueOf.compareTo(numValueOf2) < 0) {
                    numValueOf = numValueOf2;
                }
            }
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    public final List<Integer> a(String str) throws NumberFormatException {
        int i;
        String[] strArrListFolder = this.a.listFolder(str);
        if (strArrListFolder == null) {
            this.d.w("error while listing folder, returning an empty array.");
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(strArrListFolder.length);
        for (String str2 : strArrListFolder) {
            try {
                i = Integer.parseInt(str2);
            } catch (NumberFormatException e) {
                Q2.a(this.d, "Failed to parse the file name " + str2 + " to integer", e);
                i = -1;
            }
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public final synchronized void a() {
        this.g++;
        this.i = 0;
        FileStorageUtil fileStorageUtil = this.a;
        String str = this.f;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionStoragePath");
            str = null;
        }
        fileStorageUtil.mkdirs(str);
        int i = this.h;
        int i2 = this.g;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.e);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("evts");
        sb2.append(str2);
        sb2.append(i);
        sb.append(sb2.toString());
        sb.append(str2);
        sb.append(i2);
        this.a.touchFile(new File(sb.toString()));
    }
}
