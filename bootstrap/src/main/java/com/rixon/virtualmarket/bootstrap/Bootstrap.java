package com.rixon.virtualmarket.bootstrap;

import com.alibaba.fastjson.JSON;
import com.rixon.virtualmarket.bootstrap.models.participant.*;
import com.rixon.virtualmarket.bootstrap.models.config.MarketConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bootstrap {
    public static void main(String[] args) throws Exception{
        if(args.length!=2) {
            System.err.println("Usage java -jar rvm_bootstrap.jar --file <properties.file>");
            return;
        }
        RVMLoader loader = new RVMLoader();
        loader.start(args[1]);
    }
}
