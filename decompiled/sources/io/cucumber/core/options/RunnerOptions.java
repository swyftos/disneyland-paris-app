package io.cucumber.core.options;

import cucumber.api.SnippetType;
import java.net.URI;
import java.util.List;

/* loaded from: classes5.dex */
public interface RunnerOptions {
    List<URI> getGlue();

    SnippetType getSnippetType();

    boolean isDryRun();
}
