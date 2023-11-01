package org.example;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.immutables.value.Value;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Value.Immutable
@JsonSerialize(as = org.example.ImmutableDelete.class)
@JsonDeserialize(as = org.example.ImmutableDelete.class)
@JacksonXmlRootElement(localName = "delete")
public interface Delete extends Action {
}
