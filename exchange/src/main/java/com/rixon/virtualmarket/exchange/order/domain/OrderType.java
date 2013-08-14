package com.rixon.virtualmarket.exchange.order.domain;

/**
 * This type represents the various order types supported by FIX. Description of the various order types
 * have been taken from http://fixwiki.org/fixwiki/
 *
 * User: rixon
 * Date: 14/8/13
 * Time: 12:10 PM
 */
public enum OrderType {
    /**
     * Indicates an order to buy or sell a stated amount of a security at the most advantageous price
     * obtainable after the order is represented in the Trading Crowd.
     */
    MARKET('1'),

    /**
     * An order to buy a security at or below a stated price, or to sell a security at or above a
     * stated price.
     */
    LIMIT('2'),

    /**
     * A stop order to buy which becomes a market order when the security trades at - or above - the
     * stop price after the order is represented in the Trading Crowd. A stop order to sell which
     * becomes a market order when the security trades at - or below - the stop price after the order
     * is represented in the Trading Crowd.
     *
     * A stop order that is triggered as a result of a trade in the market at which point the stopped
     * order becomes a market order.
     */
    STOP('3'),

    /**
     * A stop order to buy which becomes a limit order at the limit price when the security trades at -
     * or above - the stop price after the order is represented in the Trading Crowd. A stop order to
     * sell which becomes a limit order at the limit price when the security trades at - or below- the
     * stop price after the order is represented in the Trading Crowd.
     *
     * A stop limit order that is triggered as a result of a trade in the market at which point the stopped
     * order becomes a limit order.
     */
    STOP_LIMIT('4'),

    /**
     * An odd lot order filled on an effective round lot transaction, or on an effective bid or offer,
     * whichever occurs first after the specialist receives the order. (e.g. NYSE order type)
     */
    WITH_OR_WITHOUT('6'),

    /**
     * Indicates an order to
     * - buy a security at the indicated limit price or lower, or to
     * - sell a security at the indicated limit price or higher.
     */
    LIMIT_OR_BETTER('7'),

    /**
     * An order to be executed at a limit price, with or without round-lot sales; valid only for
     * odd lot orders.
     */
    LIMIT_WITH_OR_WITHOUT('8'),

    /**
     * An order to buy or sell at the basis price. The basis price is established by joint agreement of
     * odd lot dealers in 100 share unit stocks when no round lot sale has occurred during the trading
     * session, the spread between the closing bid and offer is two points or more, and an odd lot dealer
     * has been given a basis price order.
     */
    ON_BASIS('9'),

    /**
     * An order sent in response to a Quote message.
     */
    PREVIOUSLY_QUOTED('D'),

    /**
     * An order sent in response to an Indication of Interest message.
     */
    PREVIOUSLY_INDICATED('E'),

    /**
     * A "Swap" order for Foreign Exchange (currency trading).
     */
    FOREX_SWAP('G'),

    /**
     * Japanese term for an order to buy or sell a stated amount of a security at the specified limit
     * price with any unexecuted (leftover) quantity becoming a Market On Close order.
     */
    FUNARI('I'),


    /**
     * Indicates an order to buy or sell a stated amount of a security or commodity as soon as a
     * preset market price is reached, at which point it becomes a Market order.
     */
    MARKET_IF_TOUCHED('J'),

    /**
     *  Indicates an order to buy or sell a stated amount of a security at the prevailing market price
     *  with any unexecuted (leftover) quantity becoming a Limit order at the last executed price.
     */
    MARKET_WITH_LEFTOVER_AS_LIMIT('K'),

    /**
     *  For CIV orders - indicates that the Investor prefers that the order be dealt at the unit price
     *  determined at the immediately preceding Valuation Point, a.k.a. a Historic price.
     *  (This can be overridden by the constitution of the fund or, in certain circumstances,
     *  by the Fund Manager.)
     */
    PREVIOUS_FUND_VALUATION_POINT('L'),

    /**
     *  For CIV orders - indicates that the Investor wishes the order to be dealt at the unit price
     *  determined at the next Valuation Point, a.k.a. a Forward price.
     */
    NEXT_FUND_VALUATION_POINT('M'),

    /**
     * Pegged
     */
    PEGGED('P'),

    /**
     * A model where the user selects which order to hit by providing the order ID in the order being
     * submitted against it (also know as Hit/Take orders).
     */
    COUNT_ORDER_SELECTION('Q'),

    /**
     * A stop order that is triggered by a bid or offer price movement (quote) at which point the stopped
     * order becomes a market order, also known as "stop on quote" in some markets (e.g. US markets).
     * In the US equities market it is common to trigger a stop off the National Best Bid or Offer (NBBO).
     */
    STOP_ON_BID_OR_OFFER('R'),

    /**
     * A stop order that is triggered by a bid or offer price movement (quote) at which point the stopped
     * order becomes a limit order, also known as "stop limit on quote" in some markets (e.g. US markets).
     * In the US equities market it is common to trigger a stop off the National Best Bid or Offer (NBBO).
     */
    STOP_LIMIT_ON_BID_OR_OFFER('S');

    char code;

    OrderType(char code) {
        this.code = code;
    }
}
