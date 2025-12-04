package io.cucumber.datatable.dependency.difflib;

import io.cucumber.datatable.dependency.difflib.Delta;
import java.util.List;

/* loaded from: classes5.dex */
public class DeleteDelta<T> extends Delta<T> {
    public DeleteDelta(Chunk<T> chunk, Chunk<T> chunk2) {
        super(chunk, chunk2);
    }

    @Override // io.cucumber.datatable.dependency.difflib.Delta
    public void applyTo(List<T> list) throws PatchFailedException {
        verify(list);
        int position = getOriginal().getPosition();
        int size = getOriginal().size();
        for (int i = 0; i < size; i++) {
            list.remove(position);
        }
    }

    @Override // io.cucumber.datatable.dependency.difflib.Delta
    public void restore(List<T> list) {
        int position = getRevised().getPosition();
        List<T> lines = getOriginal().getLines();
        for (int i = 0; i < lines.size(); i++) {
            list.add(position + i, lines.get(i));
        }
    }

    @Override // io.cucumber.datatable.dependency.difflib.Delta
    public Delta.TYPE getType() {
        return Delta.TYPE.DELETE;
    }

    @Override // io.cucumber.datatable.dependency.difflib.Delta
    public void verify(List<T> list) throws PatchFailedException {
        getOriginal().verify(list);
    }

    public String toString() {
        return "[DeleteDelta, position: " + getOriginal().getPosition() + ", lines: " + getOriginal().getLines() + "]";
    }
}
