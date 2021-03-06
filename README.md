# INFO6205-Final-Project


### Problem Statement
   To implement MSD radix sort for a natural language which uses Unicode characters.
   To compare your method with Timsort, Dual-pivot Quicksort, Huskysort, and LSD radix sort.


### Main requirements
* JDK 1.8
* Maven
* Pinyin4j
* log4j
* Junit 4

### Implementation

* Implemented Msd radix sort, LSD radix sort, Tim sort, Dual pivot sort, Husky sort  for Telugu language (Unicode Range: 3072 - 3199)
* Implemented Msd and lsd radix sorts for chinese words with comparison using pinyin conversion.
* Implemented Timsort, Dual pivot quicksort and Husky sort for chinese words using comparator with Collator and comparator with pinyin conversion.

**Modules**
* HuskySort  Utilized  implementation of **PureHuskySort** from https://github.com/rchillyard/The-repository-formerly-known-as




****Execute the
 [Sort benchmark file](https://github.com/santhoshmaddi49/INFO6205-Final-Project/blob/master/src/main/java/edu/neu/coe/info6205/finalProject/sort/BenchMarkForAllSort.java)****

****Execute the
[Driver file](https://github.com/santhoshmaddi49/INFO6205-Final-Project/blob/master/src/main/java/edu/neu/coe/info6205/finalProject/sort/Driver.java)****
