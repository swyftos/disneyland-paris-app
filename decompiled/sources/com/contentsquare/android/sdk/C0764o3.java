package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.o3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0764o3 {

    @NotNull
    public final H1 a;

    public C0764o3(@NotNull H1 eventsProvidersManager) {
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        this.a = eventsProvidersManager;
    }

    public final void a(@NotNull C0803s3 event) {
        Intrinsics.checkNotNullParameter(event, "newEvent");
        StringBuilder sb = new StringBuilder();
        sb.append("API Error Details - " + event.a.getHttpMethod() + ' ' + event.a.getStatusCode() + ' ' + event.a.getUrl());
        C0803s3.a(", Request Headers", sb, event.a.getCustomRequestHeaders(), event.a.getPlainCustomRequestHeaders());
        C0803s3.a(", Response Headers", sb, event.a.getCustomResponseHeaders(), event.a.getPlainCustomResponseHeaders());
        C0803s3.a(", Request Body Attributes", sb, event.a.getRequestBodyAttributes(), event.a.getPlainRequestBodyAttributes());
        C0803s3.a(", Response Body Attributes", sb, event.a.getResponseBodyAttributes(), event.a.getPlainResponseBodyAttributes());
        if (event.a.getRequestBody() != null) {
            sb.append(", Request Body: (encrypted)");
        }
        if (event.a.getResponseBody() != null) {
            sb.append(", Response Body: (encrypted)");
        }
        if (event.a.getQueryParameters() != null) {
            sb.append(", Query Parameters (encrypted)");
        }
        event.b.d(sb.toString());
        H1 h1 = this.a;
        synchronized (h1) {
            Intrinsics.checkNotNullParameter(event, "event");
            h1.a.add(event);
        }
    }
}
