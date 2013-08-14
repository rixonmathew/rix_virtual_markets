package com.rixon.virtualmarket.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rixon.virtualmarket.exchange.order.domain.OrderResponse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used for testing the JSON configuration
 * User: rixon
 * Date: 14/8/13
 * Time: 1:45 PM
 */
public class FastJSONTest {

    @Test
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
    public void testJSONStringFunctionalityWithFeatures() {
        SerializerFeature[] features = {SerializerFeature.UseISO8601DateFormat,SerializerFeature.SkipTransientField};
        OrderResponse orderResponse = createMockResponse();
        String response = JSON.toJSONString(orderResponse, features);
        //System.out.println("response = " + response);
    }


     @Test
    public void testJSONStringFunctionalityWithFilters() {
         PropertyFilter filter = new PropertyFilter() {
             public boolean apply(Object source, String name, Object value) {
                 if (name.equals("errorMessages")||name.equals("orderOK")){
                     return false;
                 }
                 return true;
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
}