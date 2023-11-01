package org.example;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.immutables.value.Value;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Value.Immutable
@JsonSerialize(as = org.example.ImmutableProperties.class)
@JsonDeserialize(as = org.example.ImmutableProperties.class)
@JacksonXmlRootElement(localName = "properties")
public interface Properties {
    @JacksonXmlElementWrapper(localName = "properties")
    List<Property> properties();
}
