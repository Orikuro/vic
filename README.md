vic
===

VindictusItemComparer, a brute-force Java-client, that compares every possible item-combination of the ARPG Vindictus.  
Multi-threaded, uses args4j and jaxb. Will feature some kind of webclient later to create new sets/items.
Current Phase: Alpha (1.9)
------
**2DOS:**   
Documentation   
New Model   
XML GUI Client
DRY-Refaktoring

**Timeline**  
Beta: ~30.09.13

Howto install (build-info):
---
1) Install ant and get java jdk7  
2) Configure ant to use javac from jdk7   
3) Download args4j from maven repo (see readme in lib folder)   
4) download sources, unzip somewhere  
5) run ant where build.xml is   
6) Done! Start via console, e.g. java -server -jar VindictusItemComparer.jar -c hurk -s cheapdef -d ts_ta -keep -i raider -price 10
