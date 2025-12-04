package io.cucumber.core.model;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class FeatureWithLines implements Serializable {
    private static final Pattern FEATURE_COLON_LINE_PATTERN = Pattern.compile("^(.*?):([\\d:]+)$");
    private static final long serialVersionUID = 20190126;
    private final SortedSet lines;
    private final URI uri;

    private FeatureWithLines(URI uri, Collection collection) {
        this.uri = uri;
        this.lines = Collections.unmodifiableSortedSet(new TreeSet(collection));
    }

    public static FeatureWithLines create(URI uri, Collection<Integer> collection) {
        if (collection.isEmpty()) {
            return new FeatureWithLines(uri, collection);
        }
        return new FeatureWithLines(FeatureIdentifier.parse(uri), collection);
    }

    public static FeatureWithLines parse(String str, Collection<Integer> collection) {
        return create(FeaturePath.parse(str), collection);
    }

    public static FeatureWithLines parse(String str) {
        Matcher matcher = FEATURE_COLON_LINE_PATTERN.matcher(str);
        try {
            if (!matcher.matches()) {
                return parseFeaturePath(str);
            }
            String strGroup = matcher.group(1);
            if (strGroup.isEmpty()) {
                throw new IllegalArgumentException(str + " is not valid. Try URI[:LINE]*");
            }
            try {
                return parseFeatureIdentifierAndLines(strGroup, matcher.group(2));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(str + " is not valid. Try URI[:LINE]*", e);
            }
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException(str + " is not valid. Try URI[:LINE]*", e2);
        }
    }

    private static FeatureWithLines parseFeatureIdentifierAndLines(String str, String str2) {
        return parse(str, toInts(str2.split(":")));
    }

    private static FeatureWithLines parseFeaturePath(String str) {
        return create(FeaturePath.parse(str), Collections.emptyList());
    }

    private static List toInts(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Integer.valueOf(Integer.parseInt(str)));
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.uri.toString());
        for (Integer num : this.lines) {
            sb.append(':');
            sb.append(num);
        }
        return sb.toString();
    }

    public SortedSet<Integer> lines() {
        return this.lines;
    }

    public URI uri() {
        return this.uri;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FeatureWithLines featureWithLines = (FeatureWithLines) obj;
        return this.uri.equals(featureWithLines.uri) && this.lines.equals(featureWithLines.lines);
    }

    public int hashCode() {
        return Objects.hash(this.uri, this.lines);
    }
}
