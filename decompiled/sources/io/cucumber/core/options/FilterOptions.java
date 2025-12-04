package io.cucumber.core.options;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public interface FilterOptions {
    int getLimitCount();

    Map<URI, Set<Integer>> getLineFilters();

    List<Pattern> getNameFilters();

    List<String> getTagFilters();
}
