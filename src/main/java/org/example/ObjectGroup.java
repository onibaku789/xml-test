package org.example;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.immutables.value.Value;

import javax.xml.bind.annotation.*;
import java.util.List;

@Value.Immutable
@JsonSerialize(as = org.example.ImmutableObjectGroup.class)
@JsonDeserialize(as = org.example.ImmutableObjectGroup.class)
@JacksonXmlRootElement(localName = "object-group")
public interface ObjectGroup {

    @JacksonXmlProperty(localName = "store")
    Store store();
    @JacksonXmlElementWrapper(localName = "properties")
    List<Property> properties();
}
