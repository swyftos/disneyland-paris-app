package com.fasterxml.jackson.dataformat.cbor;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.json.DupDetector;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public final class CBORReadContext extends JsonStreamContext {
    protected CBORReadContext _child = null;
    protected String _currentName;
    protected Object _currentValue;
    protected final DupDetector _dups;
    protected int _expEntryCount;
    protected final CBORReadContext _parent;

    public CBORReadContext(CBORReadContext cBORReadContext, DupDetector dupDetector, int i, int i2) {
        this._parent = cBORReadContext;
        this._dups = dupDetector;
        this._type = i;
        this._expEntryCount = i2;
        this._index = -1;
    }

    protected void reset(int i, int i2) {
        this._type = i;
        this._expEntryCount = i2;
        this._index = -1;
        this._currentName = null;
        this._currentValue = null;
        DupDetector dupDetector = this._dups;
        if (dupDetector != null) {
            dupDetector.reset();
        }
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public Object getCurrentValue() {
        return this._currentValue;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public void setCurrentValue(Object obj) {
        this._currentValue = obj;
    }

    public static CBORReadContext createRootContext(DupDetector dupDetector) {
        return new CBORReadContext(null, dupDetector, 0, -1);
    }

    public CBORReadContext createChildArrayContext(int i) {
        CBORReadContext cBORReadContext = this._child;
        if (cBORReadContext == null) {
            DupDetector dupDetector = this._dups;
            cBORReadContext = new CBORReadContext(this, dupDetector == null ? null : dupDetector.child(), 1, i);
            this._child = cBORReadContext;
        } else {
            cBORReadContext.reset(1, i);
        }
        return cBORReadContext;
    }

    public CBORReadContext createChildObjectContext(int i) {
        CBORReadContext cBORReadContext = this._child;
        if (cBORReadContext == null) {
            DupDetector dupDetector = this._dups;
            CBORReadContext cBORReadContext2 = new CBORReadContext(this, dupDetector == null ? null : dupDetector.child(), 2, i);
            this._child = cBORReadContext2;
            return cBORReadContext2;
        }
        cBORReadContext.reset(2, i);
        return cBORReadContext;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public String getCurrentName() {
        return this._currentName;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public CBORReadContext getParent() {
        return this._parent;
    }

    public boolean hasExpectedLength() {
        return this._expEntryCount >= 0;
    }

    public int getExpectedLength() {
        return this._expEntryCount;
    }

    public boolean acceptsBreakMarker() {
        return this._expEntryCount < 0 && this._type != 0;
    }

    public boolean expectMoreValues() {
        int i = this._index + 1;
        this._index = i;
        return i != this._expEntryCount;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public JsonLocation getStartLocation(Object obj) {
        return new JsonLocation(obj, 1L, -1, -1);
    }

    public void setCurrentName(String str) throws JsonProcessingException {
        this._currentName = str;
        DupDetector dupDetector = this._dups;
        if (dupDetector != null) {
            _checkDup(dupDetector, str);
        }
    }

    private void _checkDup(DupDetector dupDetector, String str) throws JsonParseException {
        if (dupDetector.isDup(str)) {
            throw new JsonParseException((JsonParser) null, "Duplicate field '" + str + "'", dupDetector.findLocation());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        int i = this._type;
        if (i == 0) {
            sb.append("/");
        } else if (i == 1) {
            sb.append(AbstractJsonLexerKt.BEGIN_LIST);
            sb.append(getCurrentIndex());
            sb.append(AbstractJsonLexerKt.END_LIST);
        } else if (i == 2) {
            sb.append('{');
            if (this._currentName != null) {
                sb.append('\"');
                CharTypes.appendQuoted(sb, this._currentName);
                sb.append('\"');
            } else {
                sb.append('?');
            }
            sb.append('}');
        }
        return sb.toString();
    }
}
