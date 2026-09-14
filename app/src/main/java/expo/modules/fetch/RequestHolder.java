package expo.modules.fetch;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;

/* JADX INFO: loaded from: classes5.dex */
final class RequestHolder {
    private Request request;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RequestHolder) && Intrinsics.areEqual(this.request, ((RequestHolder) obj).request);
    }

    public int hashCode() {
        Request request = this.request;
        if (request == null) {
            return 0;
        }
        return request.hashCode();
    }

    public String toString() {
        return "RequestHolder(request=" + this.request + ")";
    }

    public RequestHolder(Request request) {
        this.request = request;
    }

    public final void setRequest(Request request) {
        this.request = request;
    }
}
