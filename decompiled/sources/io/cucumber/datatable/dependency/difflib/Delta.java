package io.cucumber.datatable.dependency.difflib;

import java.util.List;

/* loaded from: classes5.dex */
public abstract class Delta<T> {
    private Chunk original;
    private Chunk revised;

    public enum TYPE {
        CHANGE,
        DELETE,
        INSERT
    }

    public abstract void applyTo(List<T> list) throws PatchFailedException;

    public abstract TYPE getType();

    public abstract void restore(List<T> list);

    public abstract void verify(List<T> list) throws PatchFailedException;

    public Delta(Chunk<T> chunk, Chunk<T> chunk2) {
        if (chunk == null) {
            throw new IllegalArgumentException("original must not be null");
        }
        if (chunk2 == null) {
            throw new IllegalArgumentException("revised must not be null");
        }
        this.original = chunk;
        this.revised = chunk2;
    }

    public Chunk<T> getOriginal() {
        return this.original;
    }

    public void setOriginal(Chunk<T> chunk) {
        this.original = chunk;
    }

    public Chunk<T> getRevised() {
        return this.revised;
    }

    public void setRevised(Chunk<T> chunk) {
        this.revised = chunk;
    }

    public int hashCode() {
        Chunk chunk = this.original;
        int iHashCode = ((chunk == null ? 0 : chunk.hashCode()) + 31) * 31;
        Chunk chunk2 = this.revised;
        return iHashCode + (chunk2 != null ? chunk2.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Delta delta = (Delta) obj;
        Chunk chunk = this.original;
        if (chunk == null) {
            if (delta.original != null) {
                return false;
            }
        } else if (!chunk.equals(delta.original)) {
            return false;
        }
        Chunk chunk2 = this.revised;
        if (chunk2 == null) {
            if (delta.revised != null) {
                return false;
            }
        } else if (!chunk2.equals(delta.revised)) {
            return false;
        }
        return true;
    }
}
