package com.facebook.react.views.unimplementedview;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1836d2 = {"Lcom/facebook/react/views/unimplementedview/ReactUnimplementedView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "setName", "", "name", "", "setName$ReactAndroid_release", "ReactAndroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ReactUnimplementedView extends LinearLayout {

    @NotNull
    private final AppCompatTextView textView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactUnimplementedView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        this.textView = appCompatTextView;
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        appCompatTextView.setGravity(17);
        appCompatTextView.setTextColor(-1);
        setBackgroundColor(1442775040);
        setGravity(1);
        setOrientation(1);
        addView(appCompatTextView);
    }

    public final void setName$ReactAndroid_release(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.textView.setText("'" + name + "' is not Fabric compatible yet.");
    }
}
