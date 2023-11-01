package org.example;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.immutables.value.Value;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Value.Immutable
@JsonSerialize(as = org.example.ImmutableProperty.class)
@JsonDeserialize(as = org.example.ImmutableProperty.class)
@JacksonXmlRootElement(localName = "property")
public interface Property {

    @JacksonXmlProperty(localName = "key", isAttribute = true)
    String key();

    @JacksonXmlProperty(localName = "value", isAttribute = true)
    String value();
}
