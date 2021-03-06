package com.rixon.virtualmarket.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rixon.virtualmarket.exchange.order.domain.Order;
import com.rixon.virtualmarket.exchange.order.domain.OrderResponse;
import com.rixon.virtualmarket.util.TestUtil;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This class is used for testing the JSON configuration using filters and SerializerFeatures
 * User: rixon
 * Date: 14/8/13
 * Time: 1:45 PM
 */
public class FastJSONTest {

    @Test
    @Ignore
    public void testJSONStringFunctionality(){
        OrderResponse orderResponse = createMockResponse();
        String response = JSON.toJSONString(orderResponse,true);
        //System.out.println("response = " + response);
    }

    private OrderResponse createMockResponse() {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setStatus("OK");
        orderResponse.setOrderID("101");
        List<String> messages = new ArrayList<String>();
        messages.add("Message1");
        messages.add("Message2");
        orderResponse.setErrorMessages(messages);
        return orderResponse;
    }

    @Test
    @Ignore
    public void testJSONStringFunctionalityWithFeatures() {
        SerializerFeature[] features = {SerializerFeature.UseISO8601DateFormat,SerializerFeature.SkipTransientField};
        OrderResponse orderResponse = createMockResponse();
        String response = JSON.toJSONString(orderResponse, features);
        //System.out.println("response = " + response);
    }


    @Test
    @Ignore
    public void testJSONStringFunctionalityWithFilters() {
         PropertyFilter filter = new PropertyFilter() {
             public boolean apply(Object source, String name, Object value) {
                 return !(name.equals("errorMessages") || name.equals("orderOK"));
             }
         };
         OrderResponse orderResponse = createMockResponse();
         SerializerFeature[] features = {SerializerFeature.UseISO8601DateFormat,
                                         SerializerFeature.PrettyFormat,
                                         SerializerFeature.SortField,
                                         SerializerFeature.WriteNullListAsEmpty
                                         };
         String response = JSON.toJSONString(orderResponse, filter,features);
         //System.out.println("response = " + response);
    }

    @Test
    @Ignore
    public void testReadingMultipleJSONsFromFile() {
        String jsonString = TestUtil.fileContentAsString("rix_exchange_orders-part-0");
        List<Order> orders = JSON.parseArray(jsonString,Order.class);
        assertNotNull(orders);
        assertThat(orders.size(),is(15000));
    }

}