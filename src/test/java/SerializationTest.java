import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.assertj.core.api.Assertions;
import org.example.Manifest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;

import javax.xml.transform.Source;
import java.io.IOException;
import java.io.StringWriter;

public class SerializationTest {

    private XmlMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = XmlMapper.builder()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .build();
        mapper.registerModule(new Jdk8Module())
                .registerModule(new GuavaModule());
    }

    @Test
    void name() throws IOException {
        String xml = """
                  <manifest>
                  <objectGroups>
                    <objectGroup>
                      <store id="2">
                        <properties>
                          <properties key="key1" value="value1"/>
                          <properties key="key2" value="value2"/>
                        </properties>
                      </store>
                      <properties>
                        <properties key="groupKey1" value="groupValue1"/>
                        <properties key="groupKey2" value="groupValue2"/>
                      </properties>
                    </objectGroup>
                    <objectGroup>
                      <store id="1">
                        <properties>
                          <properties key="key1" value="value1"/>
                          <properties key="key2" value="value2"/>
                        </properties>
                      </store>
                      <properties>
                        <properties key="groupKey1" value="groupValue1"/>
                        <properties key="groupKey2" value="groupValue2"/>
                      </properties>
                    </objectGroup>
                  </objectGroups>
                </manifest>
                """;


        Manifest manifest = mapper.readValue(xml, Manifest.class);
        StringWriter stringWriter = new StringWriter();
        mapper.writeValue(stringWriter, manifest);
        var xmlDiff = DiffBuilder.compare(xml)
                .withTest(stringWriter.toString())
                .ignoreWhitespace()
                .build();
        Assertions.assertThat(xmlDiff.hasDifferences())
                .withFailMessage(xmlDiff.toString())
                .isFalse();
    }
}
