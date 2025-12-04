package com.fasterxml.jackson.databind.util;

/* loaded from: classes3.dex */
public abstract class PrimitiveArrayBuilder<T> {
    protected Node _bufferHead;
    protected Node _bufferTail;
    protected int _bufferedEntryCount;
    protected T _freeBuffer;

    protected abstract T _constructArray(int i);

    protected PrimitiveArrayBuilder() {
    }

    public int bufferedSize() {
        return this._bufferedEntryCount;
    }

    public T resetAndStart() {
        _reset();
        T t = this._freeBuffer;
        return t == null ? _constructArray(12) : t;
    }

    public final T appendCompletedChunk(T t, int i) {
        Node node = new Node(t, i);
        if (this._bufferHead == null) {
            this._bufferTail = node;
            this._bufferHead = node;
        } else {
            this._bufferTail.linkNext(node);
            this._bufferTail = node;
        }
        this._bufferedEntryCount += i;
        return _constructArray(i < 16384 ? i + i : i + (i >> 2));
    }

    public T completeAndClearBuffer(T t, int i) {
        int i2 = this._bufferedEntryCount + i;
        T t_constructArray = _constructArray(i2);
        int iCopyData = 0;
        for (Node next = this._bufferHead; next != null; next = next.next()) {
            iCopyData = next.copyData(t_constructArray, iCopyData);
        }
        System.arraycopy(t, 0, t_constructArray, iCopyData, i);
        int i3 = iCopyData + i;
        if (i3 == i2) {
            return t_constructArray;
        }
        throw new IllegalStateException("Should have gotten " + i2 + " entries, got " + i3);
    }

    protected void _reset() {
        Node node = this._bufferTail;
        if (node != null) {
            this._freeBuffer = (T) node.getData();
        }
        this._bufferTail = null;
        this._bufferHead = null;
        this._bufferedEntryCount = 0;
    }

    static final class Node {
        final Object _data;
        final int _dataLength;
        Node _next;

        public Node(Object obj, int i) {
            this._data = obj;
            this._dataLength = i;
        }

        public Object getData() {
            return this._data;
        }

        public int copyData(Object obj, int i) {
            System.arraycopy(this._data, 0, obj, i, this._dataLength);
            return i + this._dataLength;
        }

        public Node next() {
            return this._next;
        }

        public void linkNext(Node node) {
            if (this._next != null) {
                throw new IllegalStateException();
            }
            this._next = node;
        }
    }
}
