package org.example;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@JsonSerialize(as = org.example.ImmutableManifest.class)
@JsonDeserialize(as = org.example.ImmutableManifest.class)
@JacksonXmlRootElement(localName = "manifest")
public interface Manifest {
    @JacksonXmlElementWrapper(localName = "objectGroups")
    @JacksonXmlProperty(localName = "objectGroup")
    List<ObjectGroup> objectGroups();
}
