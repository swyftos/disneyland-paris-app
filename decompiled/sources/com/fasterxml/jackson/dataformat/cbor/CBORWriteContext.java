package com.fasterxml.jackson.dataformat.cbor;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.json.DupDetector;

/* loaded from: classes3.dex */
public final class CBORWriteContext extends JsonStreamContext {
    protected CBORWriteContext _childToRecycle;
    protected long _currentFieldId;
    protected String _currentName;
    protected Object _currentValue;
    protected DupDetector _dups;
    protected boolean _gotFieldId;
    protected final CBORWriteContext _parent;

    protected CBORWriteContext(int i, CBORWriteContext cBORWriteContext, DupDetector dupDetector, Object obj) {
        this._type = i;
        this._parent = cBORWriteContext;
        this._dups = dupDetector;
        this._index = -1;
        this._currentValue = obj;
    }

    private CBORWriteContext reset(int i, Object obj) {
        this._type = i;
        this._index = -1;
        this._gotFieldId = false;
        this._currentValue = obj;
        DupDetector dupDetector = this._dups;
        if (dupDetector != null) {
            dupDetector.reset();
        }
        return this;
    }

    public CBORWriteContext withDupDetector(DupDetector dupDetector) {
        this._dups = dupDetector;
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public Object getCurrentValue() {
        return this._currentValue;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public void setCurrentValue(Object obj) {
        this._currentValue = obj;
    }

    public static CBORWriteContext createRootContext(DupDetector dupDetector) {
        return new CBORWriteContext(0, null, dupDetector, null);
    }

    public CBORWriteContext createChildArrayContext(Object obj) {
        CBORWriteContext cBORWriteContext = this._childToRecycle;
        if (cBORWriteContext == null) {
            DupDetector dupDetector = this._dups;
            CBORWriteContext cBORWriteContext2 = new CBORWriteContext(1, this, dupDetector == null ? null : dupDetector.child(), obj);
            this._childToRecycle = cBORWriteContext2;
            return cBORWriteContext2;
        }
        return cBORWriteContext.reset(1, obj);
    }

    public CBORWriteContext createChildObjectContext(Object obj) {
        CBORWriteContext cBORWriteContext = this._childToRecycle;
        if (cBORWriteContext == null) {
            DupDetector dupDetector = this._dups;
            CBORWriteContext cBORWriteContext2 = new CBORWriteContext(2, this, dupDetector == null ? null : dupDetector.child(), obj);
            this._childToRecycle = cBORWriteContext2;
            return cBORWriteContext2;
        }
        return cBORWriteContext.reset(2, obj);
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public final CBORWriteContext getParent() {
        return this._parent;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public final String getCurrentName() {
        if (!this._gotFieldId) {
            return null;
        }
        String str = this._currentName;
        return str != null ? str : String.valueOf(this._currentFieldId);
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public boolean hasCurrentName() {
        return this._gotFieldId;
    }

    public CBORWriteContext clearAndGetParent() {
        this._currentValue = null;
        return this._parent;
    }

    public DupDetector getDupDetector() {
        return this._dups;
    }

    public boolean writeFieldName(String str) throws JsonProcessingException {
        if (this._type != 2 || this._gotFieldId) {
            return false;
        }
        this._gotFieldId = true;
        this._currentName = str;
        DupDetector dupDetector = this._dups;
        if (dupDetector != null) {
            _checkDup(dupDetector, str);
        }
        return true;
    }

    public boolean writeFieldId(long j) throws JsonProcessingException {
        if (this._type != 2 || this._gotFieldId) {
            return false;
        }
        this._gotFieldId = true;
        this._currentFieldId = j;
        return true;
    }

    private final void _checkDup(DupDetector dupDetector, String str) throws JsonGenerationException {
        if (dupDetector.isDup(str)) {
            Object source = dupDetector.getSource();
            throw new JsonGenerationException("Duplicate field '" + str + "'", source instanceof JsonGenerator ? (JsonGenerator) source : null);
        }
    }

    public boolean writeValue() {
        if (this._type == 2) {
            if (!this._gotFieldId) {
                return false;
            }
            this._gotFieldId = false;
        }
        this._index++;
        return true;
    }
}
