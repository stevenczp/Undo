package test;
/**
 * @author ���찲
 * @date 2018/7/26 ����13:25
 */
public interface MyList {
    /**
     * ���� List ��Ԫ������
     * @return
     */
    int size();

    /**
     * ���� true ��ʾ List Ϊ�գ�false ��ʾ List ����Ԫ��
     * @return
     */
    boolean isEmpty();

    /**
     * ������� element ��ӵ� List ��β��
     * @param element
     * @return
     */
    void add(Object element);

    /**
     * ��ȡ List �±�Ϊ index ��Ԫ�أ��±��0��ʼ��
     * @param index
     * @return
     */
    Object get(int index);

    /**
     * �� List ���±�Ϊ index ��Ԫ���滻Ϊ element������ index λ��ԭ�е�Ԫ�ط���
     * ��� index Խ�磬��Ҫ�׳��쳣
     * @param index
     * @param element
     * @return
     */
    Object set(int index, Object element);

    /**
     *  �Ƴ� List ���±�Ϊ index ��Ԫ�أ��������Ԫ�ط���
     *  ��� index Խ�磬��Ҫ�׳��쳣
     * @param index
     * @return
     */
    Object remove(int index);

    /**
     * ��� List ������Ԫ��
     */
    void clear();

}
