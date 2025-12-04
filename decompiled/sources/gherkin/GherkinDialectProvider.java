package gherkin;

import gherkin.ParserException;
import gherkin.ast.Location;
import gherkin.deps.com.google.gson.Gson;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class GherkinDialectProvider implements IGherkinDialectProvider {
    private static Map DIALECTS;
    private final String default_dialect_name;

    static {
        try {
            DIALECTS = (Map) new Gson().fromJson((Reader) new InputStreamReader(GherkinDialectProvider.class.getResourceAsStream("/gherkin/gherkin-languages.json"), "UTF-8"), Map.class);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public GherkinDialectProvider(String str) {
        this.default_dialect_name = str;
    }

    public GherkinDialectProvider() {
        this("en");
    }

    @Override // gherkin.IGherkinDialectProvider
    public GherkinDialect getDefaultDialect() {
        return getDialect(this.default_dialect_name, null);
    }

    @Override // gherkin.IGherkinDialectProvider
    public GherkinDialect getDialect(String str, Location location) {
        Map map = (Map) DIALECTS.get(str);
        if (map == null) {
            throw new ParserException.NoSuchLanguageException(str, location);
        }
        return new GherkinDialect(str, map);
    }

    @Override // gherkin.IGherkinDialectProvider
    public List<String> getLanguages() {
        ArrayList arrayList = new ArrayList(DIALECTS.keySet());
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }
}
