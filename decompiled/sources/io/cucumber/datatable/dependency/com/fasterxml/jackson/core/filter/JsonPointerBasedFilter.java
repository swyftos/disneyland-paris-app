package io.cucumber.datatable.dependency.com.fasterxml.jackson.core.filter;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonPointer;

/* loaded from: classes5.dex */
public class JsonPointerBasedFilter extends TokenFilter {
    protected final JsonPointer _pathToMatch;

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.filter.TokenFilter
    public TokenFilter filterStartArray() {
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.filter.TokenFilter
    public TokenFilter filterStartObject() {
        return this;
    }

    public JsonPointerBasedFilter(String str) {
        this(JsonPointer.compile(str));
    }

    public JsonPointerBasedFilter(JsonPointer jsonPointer) {
        this._pathToMatch = jsonPointer;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.filter.TokenFilter
    public TokenFilter includeElement(int i) {
        JsonPointer jsonPointerMatchElement = this._pathToMatch.matchElement(i);
        if (jsonPointerMatchElement == null) {
            return null;
        }
        if (jsonPointerMatchElement.matches()) {
            return TokenFilter.INCLUDE_ALL;
        }
        return new JsonPointerBasedFilter(jsonPointerMatchElement);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.filter.TokenFilter
    public TokenFilter includeProperty(String str) {
        JsonPointer jsonPointerMatchProperty = this._pathToMatch.matchProperty(str);
        if (jsonPointerMatchProperty == null) {
            return null;
        }
        if (jsonPointerMatchProperty.matches()) {
            return TokenFilter.INCLUDE_ALL;
        }
        return new JsonPointerBasedFilter(jsonPointerMatchProperty);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.filter.TokenFilter
    protected boolean _includeScalar() {
        return this._pathToMatch.matches();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.filter.TokenFilter
    public String toString() {
        return "[JsonPointerFilter at: " + this._pathToMatch + "]";
    }
}
