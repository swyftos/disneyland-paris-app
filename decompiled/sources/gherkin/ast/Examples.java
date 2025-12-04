package gherkin.ast;

import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class Examples extends Node {
    private final String description;
    private final String keyword;
    private final String name;
    private final List tableBody;
    private final TableRow tableHeader;
    private final List tags;

    public Examples(Location location, List<Tag> list, String str, String str2, String str3, TableRow tableRow, List<TableRow> list2) {
        super(location);
        this.tags = Collections.unmodifiableList(list);
        this.keyword = str;
        this.name = str2;
        this.description = str3;
        this.tableHeader = tableRow;
        this.tableBody = list2 != null ? Collections.unmodifiableList(list2) : null;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public List<TableRow> getTableBody() {
        return this.tableBody;
    }

    public TableRow getTableHeader() {
        return this.tableHeader;
    }

    public List<Tag> getTags() {
        return this.tags;
    }
}
