package com.cc.test.learn;

/**
 * @author cc
 * @date 2018/7/23 下午8:25
 */
public interface MyList {
    /**
     * 返回 List 内元素总量
     * @return
     */
    int size();

    /**
     * 返回 true 表示 List 为空，false 表示 List 内有元素
     * @return
     */
    boolean isEmpty();

    /**
     * 将传入的 element 添加到 List 的尾部
     * @param element
     * @return
     */
    void add(Object element);

    /**
     * 获取 List 下标为 index 的元素（下标从0开始）
     * @param index
     * @return
     */
    Object get(int index);

    /**
     * 将 List 中下标为 index 的元素替换为 element，并将 index 位上原有的元素返回
     * 如果 index 越界，需要抛出异常
     * @param index
     * @param element
     * @return
     */
    Object set(int index, Object element);

    /**
     *  移除 List 中下标为 index 的元素，并将这个元素返回
     *  如果 index 越界，需要抛出异常
     * @param index
     * @return
     */
    Object remove(int index);

    /**
     * 清空 List 内所有元素
     */
    void clear();

}
