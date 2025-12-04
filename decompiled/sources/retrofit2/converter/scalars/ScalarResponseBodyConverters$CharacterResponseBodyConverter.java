package retrofit2.converter.scalars;

import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: classes.dex */
final class ScalarResponseBodyConverters$CharacterResponseBodyConverter implements Converter {
    static final ScalarResponseBodyConverters$CharacterResponseBodyConverter INSTANCE = new ScalarResponseBodyConverters$CharacterResponseBodyConverter();

    ScalarResponseBodyConverters$CharacterResponseBodyConverter() {
    }

    @Override // retrofit2.Converter
    public Character convert(ResponseBody responseBody) throws IOException {
        String strString = responseBody.string();
        if (strString.length() != 1) {
            throw new IOException("Expected body of length 1 for Character conversion but was " + strString.length());
        }
        return Character.valueOf(strString.charAt(0));
    }
}
