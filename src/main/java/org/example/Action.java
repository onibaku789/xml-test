package org.example;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

public interface Action {
    @JacksonXmlElementWrapper(localName = "properties")
    List<Property> properties();
}
