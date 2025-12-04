package io.cucumber.datatable.dependency.difflib;

import io.cucumber.datatable.dependency.difflib.Delta;
import java.util.List;

/* loaded from: classes5.dex */
public class InsertDelta<T> extends Delta<T> {
    public InsertDelta(Chunk<T> chunk, Chunk<T> chunk2) {
        super(chunk, chunk2);
    }

    @Override // io.cucumber.datatable.dependency.difflib.Delta
    public void applyTo(List<T> list) throws PatchFailedException {
        verify(list);
        int position = getOriginal().getPosition();
        List<T> lines = getRevised().getLines();
        for (int i = 0; i < lines.size(); i++) {
            list.add(position + i, lines.get(i));
        }
    }

    @Override // io.cucumber.datatable.dependency.difflib.Delta
    public void restore(List<T> list) {
        int position = getRevised().getPosition();
        int size = getRevised().size();
        for (int i = 0; i < size; i++) {
            list.remove(position);
        }
    }

    @Override // io.cucumber.datatable.dependency.difflib.Delta
    public void verify(List<T> list) throws PatchFailedException {
        if (getOriginal().getPosition() > list.size()) {
            throw new PatchFailedException("Incorrect patch for delta: delta original position > target size");
        }
    }

    @Override // io.cucumber.datatable.dependency.difflib.Delta
    public Delta.TYPE getType() {
        return Delta.TYPE.INSERT;
    }

    public String toString() {
        return "[InsertDelta, position: " + getOriginal().getPosition() + ", lines: " + getRevised().getLines() + "]";
    }
}
