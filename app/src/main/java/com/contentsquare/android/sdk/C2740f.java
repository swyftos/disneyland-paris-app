package com.contentsquare.android.sdk;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.contentsquare.android.core.features.logging.Logger;
import java.util.concurrent.ArrayBlockingQueue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.f */
/* JADX INFO: loaded from: classes2.dex */
public final class C2740f implements Function1<ViewGroup, String> {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Activity f2587a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final String f2588b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2550L3 f2589c;

    public C2740f(@NotNull Activity activity, @NotNull String title, @NotNull C2550L3 pathGenerator) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pathGenerator, "pathGenerator");
        this.f2587a = activity;
        this.f2588b = title;
        this.f2589c = pathGenerator;
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        Logger logger;
        StringBuilder sb;
        Logger logger2;
        StringBuilder sb2;
        ViewGroup root = viewGroup;
        C2550L3 c2550l3 = this.f2589c;
        Activity activity = this.f2587a;
        String pageTitle = this.f2588b;
        c2550l3.getClass();
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(pageTitle, "pageTitle");
        Uri uri = Uri.parse("app-and://" + c2550l3.f1824a.getPackageName());
        Intrinsics.checkNotNullExpressionValue(uri, "parse(PROTOCOL + appId)");
        Uri.Builder ub = uri.buildUpon();
        String simpleName = activity.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "activity.javaClass.simpleName");
        ub.appendPath(StringsKt.replace$default(simpleName, "Activity", "", false, 4, (Object) null));
        if (root != null) {
            C2909v8 c2909v8 = c2550l3.f1825b;
            c2909v8.getClass();
            Intrinsics.checkNotNullParameter(root, "root");
            ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
            arrayBlockingQueue.add(root);
            c2909v8.f3197a.m827d("Finding the biggest segment in " + root);
            loop0: while (true) {
                viewGroup2 = null;
                while (true) {
                    if (viewGroup2 != null || arrayBlockingQueue.isEmpty()) {
                        break loop0;
                    }
                    Object objPoll = arrayBlockingQueue.poll();
                    Intrinsics.checkNotNull(objPoll);
                    viewGroup2 = (ViewGroup) objPoll;
                    View viewM1223a = c2909v8.m1223a(viewGroup2);
                    if (viewM1223a == null) {
                        logger = c2909v8.f3197a;
                        sb = new StringBuilder("No biggest child, returning: ");
                    } else {
                        if (viewM1223a instanceof AdapterView) {
                            logger2 = c2909v8.f3197a;
                            sb2 = new StringBuilder("Found an AdapterView, returning as biggest: ");
                        } else {
                            String string = viewM1223a.getClass().toString();
                            Intrinsics.checkNotNullExpressionValue(string, "biggest.javaClass.toString()");
                            if (StringsKt.contains$default((CharSequence) string, (CharSequence) "RecyclerView", false, 2, (Object) null)) {
                                logger2 = c2909v8.f3197a;
                                sb2 = new StringBuilder("Found a RecyclerView, returning as biggest: ");
                            } else {
                                String string2 = viewM1223a.getClass().toString();
                                Intrinsics.checkNotNullExpressionValue(string2, "biggest.javaClass.toString()");
                                if (StringsKt.contains$default((CharSequence) string2, (CharSequence) "AndroidComposeView", false, 2, (Object) null)) {
                                    logger2 = c2909v8.f3197a;
                                    sb2 = new StringBuilder("Found an AndroidComposeView, returning as biggest: ");
                                } else if (viewM1223a instanceof ViewGroup) {
                                    c2909v8.f3197a.m827d("Adding child for processing: " + viewM1223a);
                                    arrayBlockingQueue.add(viewM1223a);
                                } else {
                                    logger = c2909v8.f3197a;
                                    sb = new StringBuilder("Found biggest child, returning parent: ");
                                }
                            }
                        }
                        sb2.append(viewM1223a);
                        logger2.m827d(sb2.toString());
                        viewGroup2 = viewM1223a;
                    }
                    sb.append(viewGroup2);
                    logger.m827d(sb.toString());
                }
            }
            if (viewGroup2 != null) {
                root = viewGroup2;
            }
            String strM942a = C2521I4.m942a(root, "id_".concat(root.getClass().getSimpleName()));
            Intrinsics.checkNotNullExpressionValue(strM942a, "getResourceEntryName(\n  …simpleName,\n            )");
            ub.appendPath(strM942a);
        }
        Intrinsics.checkNotNullExpressionValue(ub, "ub");
        if (pageTitle != null && pageTitle.length() != 0) {
            ub.appendQueryParameter("title", pageTitle);
        }
        String string3 = ub.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "ub.toString()");
        c2550l3.f1826c.m827d("Complete Path: " + string3);
        return string3;
    }
}
