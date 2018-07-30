编写代码前先理清楚逻辑，最好是先写测试代码
可以参考JDK的ArrayList/LinkedList的实际实现，学习一下真正的大佬是怎么写代码的


注意：
1. set方法的返回值是oldValue，很多人直接返回newValue了
1. ArrayList的扩容最好是按1.5倍或者2倍扩容，定长扩容不可取
1. LinkedList最好是双向链表实现，这样在get/set/remove index > size/2的元素时，可以从链表尾端遍历，效率更高
1. LinkedList里设置一个全局的tail指针，否则每次add都要遍历整个链表，开销大
1. 如果一段代码重复了三次以上，尝试将其抽象成方法