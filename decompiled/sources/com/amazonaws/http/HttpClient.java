package com.amazonaws.http;

import java.io.IOException;

/* loaded from: classes2.dex */
public interface HttpClient {
    HttpResponse execute(HttpRequest httpRequest) throws IOException;

    void shutdown();
}
