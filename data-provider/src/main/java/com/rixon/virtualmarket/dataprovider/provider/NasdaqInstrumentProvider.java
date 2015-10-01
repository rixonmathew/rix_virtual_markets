package com.rixon.virtualmarket.dataprovider.provider;

import com.rixon.virtualmarket.dataprovider.mapper.NasdaqCompanyToFIMapper;
import com.rixon.virtualmarket.dataprovider.models.NasdaqCompany;
import com.rixon.virtualmarket.instrument.FinancialInstrument;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

/**
 * This class is used for providing instrument details from companylist
 * available from Nasdaq site
 */
public class NasdaqInstrumentProvider {

    private String csvFileName = "nasdaq_comps.csv";
    private NasdaqCompanyToFIMapper nasdaqCompanyToFIMapper;
    private Map<String, FinancialInstrument> instruments;

    public NasdaqInstrumentProvider(String csvFileName) {
        this.csvFileName = csvFileName;
        nasdaqCompanyToFIMapper = new NasdaqCompanyToFIMapper();
    }

    public void loadInstrumentsFromCsv() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(csvFileName);
        instruments = Files.lines(Paths.get(classPathResource.getURI()))
                .map(this::parse).collect(toMap(fi->fi.getIdentifier("NASDAQ").getValue(), identity()));
        instruments.values().stream().forEach(System.out::println);

    }

    private FinancialInstrument parse(String csvRecord) {
        NasdaqCompany nasdaqCompany = new NasdaqCompany(csvRecord);
        return nasdaqCompanyToFIMapper.map(nasdaqCompany);
    }

}
