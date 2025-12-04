package io.cucumber.datatable.dependency.difflib;

/* loaded from: classes5.dex */
public class DiffRow {
    private String newLine;
    private String oldLine;
    private Tag tag;

    public enum Tag {
        INSERT,
        DELETE,
        CHANGE,
        EQUAL
    }

    public DiffRow(Tag tag, String str, String str2) {
        this.tag = tag;
        this.oldLine = str;
        this.newLine = str2;
    }

    public Tag getTag() {
        return this.tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String getOldLine() {
        return this.oldLine;
    }

    public void setOldLine(String str) {
        this.oldLine = str;
    }

    public String getNewLine() {
        return this.newLine;
    }

    public void setNewLine(String str) {
        this.newLine = str;
    }

    public int hashCode() {
        String str = this.newLine;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.oldLine;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Tag tag = this.tag;
        return iHashCode2 + (tag != null ? tag.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DiffRow diffRow = (DiffRow) obj;
        String str = this.newLine;
        if (str == null) {
            if (diffRow.newLine != null) {
                return false;
            }
        } else if (!str.equals(diffRow.newLine)) {
            return false;
        }
        String str2 = this.oldLine;
        if (str2 == null) {
            if (diffRow.oldLine != null) {
                return false;
            }
        } else if (!str2.equals(diffRow.oldLine)) {
            return false;
        }
        Tag tag = this.tag;
        if (tag == null) {
            if (diffRow.tag != null) {
                return false;
            }
        } else if (!tag.equals(diffRow.tag)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "[" + this.tag + "," + this.oldLine + "," + this.newLine + "]";
    }
}
