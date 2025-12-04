package ch.qos.logback.core.pattern.parser;

import ch.qos.logback.core.pattern.CompositeConverter;
import ch.qos.logback.core.pattern.Converter;
import ch.qos.logback.core.pattern.DynamicConverter;
import ch.qos.logback.core.pattern.LiteralConverter;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.status.ErrorStatus;
import ch.qos.logback.core.util.OptionHelper;
import java.util.Map;

/* loaded from: classes2.dex */
class Compiler extends ContextAwareBase {
    final Map converterMap;
    Converter head;
    Converter tail;
    final Node top;

    Compiler(Node node, Map map) {
        this.top = node;
        this.converterMap = map;
    }

    private void addToList(Converter converter) {
        if (this.head == null) {
            this.tail = converter;
            this.head = converter;
        } else {
            this.tail.setNext(converter);
            this.tail = converter;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [ch.qos.logback.core.pattern.parser.Node] */
    /* JADX WARN: Type inference failed for: r0v2, types: [ch.qos.logback.core.pattern.parser.Node] */
    /* JADX WARN: Type inference failed for: r0v3, types: [ch.qos.logback.core.pattern.parser.Node] */
    Converter compile() {
        Converter literalConverter;
        this.tail = null;
        this.head = null;
        for (CompositeNode compositeNode = this.top; compositeNode != null; compositeNode = compositeNode.next) {
            int i = compositeNode.type;
            if (i != 0) {
                if (i == 1) {
                    SimpleKeywordNode simpleKeywordNode = compositeNode;
                    DynamicConverter dynamicConverterCreateConverter = createConverter(simpleKeywordNode);
                    if (dynamicConverterCreateConverter != null) {
                        dynamicConverterCreateConverter.setFormattingInfo(simpleKeywordNode.getFormatInfo());
                        dynamicConverterCreateConverter.setOptionList(simpleKeywordNode.getOptions());
                        literalConverter = dynamicConverterCreateConverter;
                    } else {
                        Converter literalConverter2 = new LiteralConverter("%PARSER_ERROR[" + simpleKeywordNode.getValue() + "]");
                        addStatus(new ErrorStatus("[" + simpleKeywordNode.getValue() + "] is not a valid conversion word", this));
                        literalConverter = literalConverter2;
                    }
                } else if (i == 2) {
                    CompositeNode compositeNode2 = compositeNode;
                    CompositeConverter compositeConverterCreateCompositeConverter = createCompositeConverter(compositeNode2);
                    if (compositeConverterCreateCompositeConverter == null) {
                        addError("Failed to create converter for [%" + compositeNode2.getValue() + "] keyword");
                        literalConverter = new LiteralConverter("%PARSER_ERROR[" + compositeNode2.getValue() + "]");
                    } else {
                        compositeConverterCreateCompositeConverter.setFormattingInfo(compositeNode2.getFormatInfo());
                        compositeConverterCreateCompositeConverter.setOptionList(compositeNode2.getOptions());
                        Compiler compiler = new Compiler(compositeNode2.getChildNode(), this.converterMap);
                        compiler.setContext(this.context);
                        compositeConverterCreateCompositeConverter.setChildConverter(compiler.compile());
                        literalConverter = compositeConverterCreateCompositeConverter;
                    }
                }
                addToList(literalConverter);
            } else {
                addToList(new LiteralConverter((String) compositeNode.getValue()));
            }
        }
        return this.head;
    }

    CompositeConverter createCompositeConverter(CompositeNode compositeNode) {
        String str = (String) compositeNode.getValue();
        String str2 = (String) this.converterMap.get(str);
        if (str2 == null) {
            addError("There is no conversion class registered for composite conversion word [" + str + "]");
            return null;
        }
        try {
            return (CompositeConverter) OptionHelper.instantiateByClassName(str2, (Class<?>) CompositeConverter.class, this.context);
        } catch (Exception e) {
            addError("Failed to instantiate converter class [" + str2 + "] as a composite converter for keyword [" + str + "]", e);
            return null;
        }
    }

    DynamicConverter createConverter(SimpleKeywordNode simpleKeywordNode) {
        String str = (String) simpleKeywordNode.getValue();
        String str2 = (String) this.converterMap.get(str);
        if (str2 == null) {
            addError("There is no conversion class registered for conversion word [" + str + "]");
            return null;
        }
        try {
            return (DynamicConverter) OptionHelper.instantiateByClassName(str2, (Class<?>) DynamicConverter.class, this.context);
        } catch (Exception e) {
            addError("Failed to instantiate converter class [" + str2 + "] for keyword [" + str + "]", e);
            return null;
        }
    }
}
