package io.cucumber.core.api;

import io.cucumber.core.event.Status;
import java.util.Collection;
import org.apiguardian.api.API;

@API(status = API.Status.STABLE)
/* loaded from: classes5.dex */
public interface Scenario {
    void embed(byte[] bArr, String str);

    void embed(byte[] bArr, String str, String str2);

    String getId();

    Integer getLine();

    String getName();

    Collection<String> getSourceTagNames();

    Status getStatus();

    String getUri();

    boolean isFailed();

    void write(String str);
}
