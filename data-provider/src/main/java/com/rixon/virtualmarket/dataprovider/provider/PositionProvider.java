package com.rixon.virtualmarket.dataprovider.provider;

import com.rixon.virtualmarket.instrument.FinancialInstrument;
import com.rixon.virtualmarket.position.Position;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PositionProvider {

    public List<Position> createPositionsFor(FinancialInstrument financialInstrument,long maxLimit) {
        return new ArrayList<>(); //TODO provide implementation
    }
}
