package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.cfg;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Version;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Versioned;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.util.VersionUtil;

/* loaded from: classes5.dex */
public final class PackageVersion implements Versioned {
    public static final Version VERSION = VersionUtil.parseVersion("2.9.9", "io.cucumber.datatable.dependency.com.fasterxml.jackson.core", "jackson-databind");

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Versioned
    public Version version() {
        return VERSION;
    }
}
