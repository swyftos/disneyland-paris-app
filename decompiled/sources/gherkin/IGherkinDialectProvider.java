package gherkin;

import gherkin.ast.Location;
import java.util.List;

/* loaded from: classes5.dex */
public interface IGherkinDialectProvider {
    GherkinDialect getDefaultDialect();

    GherkinDialect getDialect(String str, Location location);

    List<String> getLanguages();
}
