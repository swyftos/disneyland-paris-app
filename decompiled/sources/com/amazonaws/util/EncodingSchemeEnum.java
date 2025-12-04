package com.amazonaws.util;

/* loaded from: classes2.dex */
public enum EncodingSchemeEnum implements EncodingScheme {
    BASE16 { // from class: com.amazonaws.util.EncodingSchemeEnum.1
        @Override // com.amazonaws.util.EncodingSchemeEnum, com.amazonaws.util.EncodingScheme
        public String encodeAsString(byte[] bArr) {
            return Base16.encodeAsString(bArr);
        }

        @Override // com.amazonaws.util.EncodingScheme
        public byte[] decode(String str) {
            return Base16.decode(str);
        }
    },
    BASE32 { // from class: com.amazonaws.util.EncodingSchemeEnum.2
        @Override // com.amazonaws.util.EncodingSchemeEnum, com.amazonaws.util.EncodingScheme
        public String encodeAsString(byte[] bArr) {
            return Base32.encodeAsString(bArr);
        }

        @Override // com.amazonaws.util.EncodingScheme
        public byte[] decode(String str) {
            return Base32.decode(str);
        }
    },
    BASE64 { // from class: com.amazonaws.util.EncodingSchemeEnum.3
        @Override // com.amazonaws.util.EncodingSchemeEnum, com.amazonaws.util.EncodingScheme
        public String encodeAsString(byte[] bArr) {
            return Base64.encodeAsString(bArr);
        }

        @Override // com.amazonaws.util.EncodingScheme
        public byte[] decode(String str) {
            return Base64.decode(str);
        }
    };

    @Override // com.amazonaws.util.EncodingScheme
    public abstract String encodeAsString(byte[] bArr);
}
