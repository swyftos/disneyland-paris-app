package io.cucumber.datatable.dependency.difflib;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
public class Chunk<T> {
    private List lines;
    private final int position;

    public Chunk(int i, List<T> list) {
        this.position = i;
        this.lines = list;
    }

    public Chunk(int i, T[] tArr) {
        this.position = i;
        this.lines = Arrays.asList(tArr);
    }

    public void verify(List<T> list) throws PatchFailedException {
        if (last() > list.size()) {
            throw new PatchFailedException("Incorrect Chunk: the position of chunk > target size");
        }
        for (int i = 0; i < size(); i++) {
            if (!list.get(this.position + i).equals(this.lines.get(i))) {
                throw new PatchFailedException("Incorrect Chunk: the chunk content doesn't match the target");
            }
        }
    }

    public int getPosition() {
        return this.position;
    }

    public void setLines(List<T> list) {
        this.lines = list;
    }

    public List<T> getLines() {
        return this.lines;
    }

    public int size() {
        return this.lines.size();
    }

    public int last() {
        return (getPosition() + size()) - 1;
    }

    public int hashCode() {
        List list = this.lines;
        return (((((list == null ? 0 : list.hashCode()) + 31) * 31) + this.position) * 31) + size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Chunk chunk = (Chunk) obj;
        List list = this.lines;
        if (list == null) {
            if (chunk.lines != null) {
                return false;
            }
        } else if (!list.equals(chunk.lines)) {
            return false;
        }
        return this.position == chunk.position;
    }

    public String toString() {
        return "[position: " + this.position + ", size: " + size() + ", lines: " + this.lines + "]";
    }
}
