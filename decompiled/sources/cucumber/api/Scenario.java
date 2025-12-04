package cucumber.api;

import cucumber.api.Result;
import java.util.Collection;
import java.util.List;

@Deprecated
/* loaded from: classes5.dex */
public interface Scenario {
    void embed(byte[] bArr, String str);

    void embed(byte[] bArr, String str, String str2);

    String getId();

    List<Integer> getLines();

    String getName();

    Collection<String> getSourceTagNames();

    Result.Type getStatus();

    String getUri();

    boolean isFailed();

    void write(String str);
}
