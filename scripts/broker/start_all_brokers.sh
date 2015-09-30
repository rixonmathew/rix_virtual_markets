#!/usr/bin/env bash

java -Dspring.config.location=<specify the properties file> -Dbroker.name.log=broker1 -Dbroker.log.location=/tmp/rvm_logs/broker -jar <broker app jar file>