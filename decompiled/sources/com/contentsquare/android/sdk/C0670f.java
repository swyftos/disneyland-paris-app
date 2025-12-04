package com.contentsquare.android.sdk;

import android.app.Activity;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.contentsquare.android.core.features.logging.Logger;
import java.util.concurrent.ArrayBlockingQueue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0670f implements Function1<ViewGroup, String> {

    @NotNull
    public final Activity a;

    @NotNull
    public final String b;

    @NotNull
    public final L3 c;

    public C0670f(@NotNull Activity activity, @NotNull String title, @NotNull L3 pathGenerator) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pathGenerator, "pathGenerator");
        this.a = activity;
        this.b = title;
        this.c = pathGenerator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.StringBuilder] */
    @Override // kotlin.jvm.functions.Function1
    public final String invoke(ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        ?? A;
        Logger logger;
        StringBuilder sb;
        Logger logger2;
        ?? sb2;
        ViewGroup root = viewGroup;
        L3 l3 = this.c;
        Activity activity = this.a;
        String pageTitle = this.b;
        l3.getClass();
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(pageTitle, "pageTitle");
        Uri uri = Uri.parse("app-and://" + l3.a.getPackageName());
        Intrinsics.checkNotNullExpressionValue(uri, "parse(PROTOCOL + appId)");
        Uri.Builder ub = uri.buildUpon();
        String simpleName = activity.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "activity.javaClass.simpleName");
        ub.appendPath(StringsKt.replace$default(simpleName, "Activity", "", false, 4, (Object) null));
        if (root != null) {
            v8 v8Var = l3.b;
            v8Var.getClass();
            Intrinsics.checkNotNullParameter(root, "root");
            ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
            arrayBlockingQueue.add(root);
            v8Var.a.d("Finding the biggest segment in " + root);
            loop0: while (true) {
                viewGroup2 = null;
                while (viewGroup2 == null && !arrayBlockingQueue.isEmpty()) {
                    Object objPoll = arrayBlockingQueue.poll();
                    Intrinsics.checkNotNull(objPoll);
                    viewGroup2 = (ViewGroup) objPoll;
                    A = v8Var.a(viewGroup2);
                    if (A == 0) {
                        logger = v8Var.a;
                        sb = new StringBuilder("No biggest child, returning: ");
                    } else {
                        if (A instanceof AdapterView) {
                            logger2 = v8Var.a;
                            sb2 = new StringBuilder("Found an AdapterView, returning as biggest: ");
                        } else {
                            String string = A.getClass().toString();
                            Intrinsics.checkNotNullExpressionValue(string, "biggest.javaClass.toString()");
                            if (StringsKt.contains$default((CharSequence) string, (CharSequence) "RecyclerView", false, 2, (Object) null)) {
                                logger2 = v8Var.a;
                                sb2 = new StringBuilder("Found a RecyclerView, returning as biggest: ");
                            } else {
                                String string2 = A.getClass().toString();
                                Intrinsics.checkNotNullExpressionValue(string2, "biggest.javaClass.toString()");
                                if (StringsKt.contains$default((CharSequence) string2, (CharSequence) "AndroidComposeView", false, 2, (Object) null)) {
                                    logger2 = v8Var.a;
                                    sb2 = new StringBuilder("Found an AndroidComposeView, returning as biggest: ");
                                } else {
                                    if (A instanceof ViewGroup) {
                                        break;
                                    }
                                    logger = v8Var.a;
                                    sb = new StringBuilder("Found biggest child, returning parent: ");
                                }
                            }
                        }
                        sb2.append(A);
                        logger2.d(sb2.toString());
                        viewGroup2 = A;
                    }
                    sb.append(viewGroup2);
                    logger.d(sb.toString());
                }
                v8Var.a.d("Adding child for processing: " + A);
                arrayBlockingQueue.add(A);
            }
            if (viewGroup2 != null) {
                root = viewGroup2;
            }
            String strA = I4.a(root, "id_".concat(root.getClass().getSimpleName()));
            Intrinsics.checkNotNullExpressionValue(strA, "getResourceEntryName(\n  …simpleName,\n            )");
            ub.appendPath(strA);
        }
        Intrinsics.checkNotNullExpressionValue(ub, "ub");
        if (pageTitle != null && pageTitle.length() != 0) {
            ub.appendQueryParameter("title", pageTitle);
        }
        String string3 = ub.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "ub.toString()");
        l3.c.d("Complete Path: " + string3);
        return string3;
    }
}
