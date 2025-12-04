package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsonFormatVisitors;

import java.util.Set;

/* loaded from: classes5.dex */
public interface JsonValueFormatVisitor {

    public static class Base implements JsonValueFormatVisitor {
        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormatVisitor
        public void enumTypes(Set<String> set) {
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormatVisitor
        public void format(JsonValueFormat jsonValueFormat) {
        }
    }

    void enumTypes(Set<String> set);

    void format(JsonValueFormat jsonValueFormat);
}
