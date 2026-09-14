package cucumber.api;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
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
