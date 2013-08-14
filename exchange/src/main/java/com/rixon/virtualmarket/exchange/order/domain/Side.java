package com.rixon.virtualmarket.exchange.order.domain;

/**
 * This enum represents the side in an order
 * User: rixon
 * Date: 14/8/13
 * Time: 12:33 PM
 */
public enum Side {
    /**
     *
     1 Buy
     2 Sell
     3 BuyMinus
     4 SellPlus
     5 SellShort
     6 SellShortExempt
     7 Undisclosed
     8 Cross
     9 CrossShort
     A CrossShortExempt
     B AsDefined
     C Opposite
     D Subscribe
     E Redeem
     F Lend
     G Borrow
     */

    /**
     * Buy
     */
    BUY('1'),

    /**
     * Sell
     */
    SELL('2'),

    /**
     * A round-lot market order to buy -minus- is an order to buy a stated amount of a stock
     * provided that its price is:
     * - not higher than the last sale if the last sale was a -minus- or -zero minus- tick and
     * - not higher than the last sale minus the minimum fractional change in the stock if the
     *   last sale was a -plus- or -zero plus- tick.
     * A limit price order to buy -minus- also states the highest price at which it can be executed.
     */
    BUY_MINUS('3'),

    /**
     * A round-lot market order to sell -plus- is an order to sell a stated amount of a stock
     * provided that its price is:
     *   - not lower than the last sale if the last sale was a -plus- or -zero plus- tick and
     *   - not lower than the last sale minus the minimum fractional change in the stock if
     *     the last sale was a -minus- or -zero minus- tick.
     *  A limit-price order to sell -plus- also states the lowest price at which it can be executed.
     */
    SELL_PLUS('4'),

    /**
     * An order to sell a security that the seller does not own; a sale effected by delivering a
     * security borrowed by, or for the account of, the seller. Can only be executed on a
     * -plus- or -zero plus- tick.
     */
    SELL_SHORT('5'),

    /**
     *  Short sale exempt from short-sale rules.
     */
    SELL_SHORT_EXEMPT('6'),

    /**
     * Undisclosed
     */
    UNDISCLOSED('7'),

    /**
     *  Client sends Broker a buy or sell order. Broker wishes to take the other side and cross
     *  with the client. Broker sends an order with Side=Cross to an exchange.
     */
    CROSS('8'),

    /**
     *  Client wants to establish a short position, and so sends a Sell Short to Broker. Broker
     *  wants to cross with the Client, so Broker sends a Cross Short order to an exchange.
     *  Cross Short is crucial here because many exchanges have tick rules needing to be enforced,
     *  and the order getting converted from Sell Short to Cross (instead of Cross Short) could result
     *  in an illegal short sell.
     */
    CROSS_SHORT('9'),

    /**
     *  Client wants to establish a short position, and is exempt from the uptick restriction.
     *  So Client sends Sell Short Exempt to Broker. Broker wants to cross with the Client,
     *  so Broker needs a way to send "Cross Short Exempt" to the exchange so that an audit trail
     *  traces back indicating that the party selling short was exempt from the uptick rule.
     */
    CROSS_SHORT_EXEMPT('A'),

    /**
     *  Sides of the legs are the same as defined in the multileg instrument.
     */
    AS_DEFINED('B'),

    /**
     *  Sides of the legs are the opposite of their definition in the multileg instrument.
     */
    OPPOSITE('C'),

    /**
     * For CIV:
     * A -buy- order for CIV units which must be forwarded to the fund manager (or their transfer agent)
     * rather than being matched / crossed with a -sell- order, e.g. by an intermediary funds supermarket,
     * broker/dealer etc. This would be used in markets where the originator requires specific tax treatment
     * and/or dealing charges.
     */
    SUBSCRIBE('D'),

    /**
     * For CIV:
     *  A -sell- order for CIV units which must be forwarded to the fund manager (or their transfer agent)
     *  rather than being matched / crossed with a -buy- order, e.g. by an intermediary, funds supermarket,
     *  broker/dealer etc. This would be used in markets where the originator requires specific tax treatment
     *  and/or dealing charges.
     */
    REDEEM('E'),

    /**
     *  Lend (FINANCING - identifies direction of collateral)
     */
    LEND('F'),

    /**
     *  Borrow (FINANCING - identifies direction of collateral)
     */
    BORROW('G');

    private final char code;

    Side(char code){
        this.code = code;
    }
}
