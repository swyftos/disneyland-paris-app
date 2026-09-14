package com.contentsquare.android.sdk;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.o3 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2834o3 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2508H1 f2937a;

    public C2834o3(@NotNull C2508H1 eventsProvidersManager) {
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        this.f2937a = eventsProvidersManager;
    }

    /* JADX INFO: renamed from: a */
    public final void m1185a(@NotNull C2874s3 event) {
        Intrinsics.checkNotNullParameter(event, "newEvent");
        StringBuilder sb = new StringBuilder();
        sb.append("API Error Details - " + event.f3095a.getHttpMethod() + ' ' + event.f3095a.getStatusCode() + ' ' + event.f3095a.getUrl());
        C2874s3.m1199a(", Request Headers", sb, event.f3095a.getCustomRequestHeaders(), event.f3095a.getPlainCustomRequestHeaders());
        C2874s3.m1199a(", Response Headers", sb, event.f3095a.getCustomResponseHeaders(), event.f3095a.getPlainCustomResponseHeaders());
        C2874s3.m1199a(", Request Body Attributes", sb, event.f3095a.getRequestBodyAttributes(), event.f3095a.getPlainRequestBodyAttributes());
        C2874s3.m1199a(", Response Body Attributes", sb, event.f3095a.getResponseBodyAttributes(), event.f3095a.getPlainResponseBodyAttributes());
        if (event.f3095a.getRequestBody() != null) {
            sb.append(", Request Body: (encrypted)");
        }
        if (event.f3095a.getResponseBody() != null) {
            sb.append(", Response Body: (encrypted)");
        }
        if (event.f3095a.getQueryParameters() != null) {
            sb.append(", Query Parameters (encrypted)");
        }
        event.f3096b.m827d(sb.toString());
        C2508H1 c2508h1 = this.f2937a;
        synchronized (c2508h1) {
            Intrinsics.checkNotNullParameter(event, "event");
            c2508h1.f1661a.add(event);
        }
    }
}
