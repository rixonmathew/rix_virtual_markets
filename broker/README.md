#Broker Service

A Broker service represents a simplified broker in capital markets. It accepts orders from various institutions. It first tries to see if there are orders in its own book with which it can match against. If none is found
it forwards the order to an exchange and provides response back to institution.

Multiple instances of brokers can be run. The different endpoints supported by Brokers are as follows

1) 