package com.urbanairship.android.layout.util;

import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final class LinkSpan extends ClickableSpan {
    private final Integer color;
    private final Boolean underline;
    private final String url;

    public LinkSpan(String url, Boolean bool, Integer num) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.underline = bool;
        this.color = num;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ContextCompat.startActivity(view.getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.url)), null);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        super.updateDrawState(ds);
        Boolean bool = this.underline;
        ds.setUnderlineText(bool != null ? bool.booleanValue() : false);
        Integer num = this.color;
        ds.setColor(num != null ? num.intValue() : ds.getColor());
    }
}
