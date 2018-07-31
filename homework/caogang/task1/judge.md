1. ArrayList的add方法中，每次扩容只增长1的长度，在大量插入时效率低，JDK里是1.5倍扩容
1. ArrayList的remove方法中，不需要每次都重新更换底层数组，可以直接在原数组里移动元素，然后将size - 1
1. LinkedList的get/set/remove方法，在index大于 size/2 时，可以考虑从链表尾端进行查找
1. LinkedList的set方法，没有保存 node  的oldValue，导致set方法的返回值是错误的
1. LinkedList的remove方法的实现存在问题，导致 remove 一个List中所有的元素后，如果插入元素再调用clear方法，会报空指针错误


总的来说挺不错
