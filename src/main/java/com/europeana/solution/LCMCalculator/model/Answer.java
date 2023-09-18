package com.europeana.solution.LCMCalculator.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JacksonXmlRootElement
public class Answer {
    @JacksonXmlCData
    private Long result;
    @JacksonXmlCData
    private Long timeMc;
}
