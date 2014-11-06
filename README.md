vic
===

VindictusItemComparer, a brute-force Java-client, that compares every possible item-combination of itemsets from the ARPG Vindictus.  
Multi-threaded, uses args4j and jaxb.
Current Phase: Alpha (2.1)
------
**2DOS:**   
Documentation   
XML GUI Client   
DRY-Refaktoring

**Updates**  
05.11.2014 - Arisha added, 3 new sets, GUI Starter   
June 2014 - Lynn added

Howto build from scratch:
---
1) Install ant and get java jdk7  
2) Configure ant to use javac from jdk7   
3) Download args4j from maven repo (see readme in lib folder)   
4) download sources, unzip somewhere  
5) run ant where build.xml is   
6) Done! Start via console, e.g. java -server -jar VindictusItemComparer.jar -c hurk -s cheapdef -d ts_ta -keep -i raider -price 10

Recent already compiled package:
---
https://github.com/Orikuro/vic/releases
