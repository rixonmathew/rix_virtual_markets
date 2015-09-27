package com.rixon.virtualmarket.dataprovider.provider;

import com.rixon.virtualmarket.instrument.FinancialInstrument;
import com.rixon.virtualmarket.quote.InstrumentQuote;
import com.rixon.virtualmarket.quote.InstrumentQuoteBuilder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Random;

@Component
public class QuoteProvider {

    private static final BigDecimal MINUS_ONE = BigDecimal.valueOf(-1l);
    private static final int MAX_QUANTITY_LIMIT = 100_000;
    private Random factorRandomizer = new Random();
    private Random quantityRandomizer = new Random();
    private int TICK_SIZE_INCREASE=5;

    public InstrumentQuote getQuote(FinancialInstrument financialInstrument,
                                     InstrumentQuote currentQuote,
                                     PriceGenerationContext priceGenerationContext) {
        /**
         * Price Generation Strategy
         * 1) If current quote is not there start with a random price.
         * 2) Decide on price movement strategy. Get the propbabiliy factor from context and use that to determine direction of price increase
         * 3) For every instrument there should be a upper limit that decides how much percentage the price can move. Calculate a random value
         *    between 0 and that limit
         * 4) Multipleu the value obtained in step # 3 with tick size with the sign value from step # 2.
         * 5) New price = price from step # 1 + value from step # 4
         */

        Random signRandomizer = new Random();
        BigDecimal signMultiplier = MINUS_ONE;
        if (signRandomizer.nextInt(100)<=priceGenerationContext.getProbabilityForPositiveIncrease())
            signMultiplier = BigDecimal.ONE;
        BigDecimal newBid = financialInstrument.getIssuingQuote().getBid();
        if (currentQuote!=null && currentQuote.getBid()!=null) {
            newBid = currentQuote.getBid();
            BigDecimal randomFactor = BigDecimal.valueOf(factorRandomizer.nextDouble())
                                                .multiply(priceGenerationContext.getMaxPriceChangeFactor())
                                                .setScale(2, RoundingMode.HALF_DOWN);
            BigDecimal priceIncrease = randomFactor.multiply(financialInstrument.getTickSize())
                                                   .multiply(signMultiplier);
            newBid = newBid.add(priceIncrease);
        }

        BigDecimal newAsk = financialInstrument.getIssuingQuote().getAsk();
        if (currentQuote!=null && currentQuote.getAsk()!=null) {
            newAsk = currentQuote.getAsk();
            BigDecimal randomFactor = BigDecimal.valueOf(factorRandomizer.nextDouble())
                    .multiply(priceGenerationContext.getMaxPriceChangeFactor())
                    .setScale(2, RoundingMode.HALF_DOWN);
            BigDecimal priceIncrease = randomFactor.multiply(financialInstrument.getTickSize())
                    .multiply(signMultiplier);
            newAsk = newAsk.add(priceIncrease);

        }

        if (newAsk.compareTo(newBid)<=1){
            newAsk = newBid.add(financialInstrument.getTickSize().multiply(BigDecimal.valueOf(TICK_SIZE_INCREASE)));
        }

        BigDecimal newBidQuantity = BigDecimal.valueOf(quantityRandomizer.nextInt(MAX_QUANTITY_LIMIT));
        BigDecimal newAskQuantity = BigDecimal.valueOf(quantityRandomizer.nextInt(MAX_QUANTITY_LIMIT));

        InstrumentQuoteBuilder instrumentQuoteBuilder = new InstrumentQuoteBuilder();
        instrumentQuoteBuilder.setTimeStamp(LocalDateTime.now())
                .setBid(newBid)
                .setBidQuantity(newBidQuantity)
                .setAsk(newAsk)
                .setAskQuantity(newAskQuantity)
                .setTickSize(financialInstrument.getTickSize())
                .setCurrency(financialInstrument.getIssuingCurrency());

        return instrumentQuoteBuilder.createInstrumentQuote();
    }
}
