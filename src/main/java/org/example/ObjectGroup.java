package org.example;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.immutables.value.Value;

import javax.xml.bind.annotation.*;
import java.util.List;

@Value.Immutable
@JsonSerialize(as = org.example.ImmutableManifest.class)
@JsonDeserialize(as = org.example.ImmutableManifest.class)
@JacksonXmlRootElement(localName = "object-group")
public interface ObjectGroup {

    @XmlElementWrapper(name = "actions")
    @XmlElements({
            @XmlElement(name = "store", type = org.example.ImmutableStore.Builder.class),
            @XmlElement(name = "delete", type = org.example.ImmutableDelete.Builder.class)
    })
    List<Action> actions();

    Properties properties();
}
