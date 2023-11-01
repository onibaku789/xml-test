package org.example;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.immutables.value.Value;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Value.Immutable
@JsonSerialize(as = org.example.ImmutableStore.class)
@JsonDeserialize(as = org.example.ImmutableStore.class)
@JacksonXmlRootElement(localName = "delete")
public interface Store extends Action {
}
