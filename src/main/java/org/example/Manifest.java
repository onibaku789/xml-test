package org.example;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.immutables.value.Value;

import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Value.Immutable
@JsonSerialize(as = org.example.ImmutableManifest.class)
@JsonDeserialize(as = org.example.ImmutableManifest.class)
@JacksonXmlRootElement(localName = "manifest")
public interface Manifest {
    @XmlElementWrapper(name = "objectGroups")
    List<ObjectGroup> objectGroups();
}
