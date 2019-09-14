package dataStructures.extensibleArray;

/**
 * Created by Tommy on 2019/8/24.
 */
public class StackArrayBox implements Box {
    private static final int DEFAULT_CAPACITY =0;
    private int[] elementData;
    private int size;

    private void ensureCapacityInternal(int minCapacity) {
        if (minCapacity - this.elementData.length > 0) {
            this.growSpace(minCapacity);
        }
    }

    private void growSpace(int minCapacity) {
        int oldCapacity = this.elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        elementData = this.copyOf(elementData, newCapacity);

    }


    private int[] copyOf(int[] oldArr, int newCapacity) {
        int[] newArr = new int[newCapacity];
        for (int i = 0; i < oldArr.length; i++) {
            newArr[i] = oldArr[i];
        }
        return newArr;
    }

    private void rangeCheck(int index) {
        if (index >= this.size || index < 0) {
            throw new BoxIndexOutOfBoundsException("index:" + index + "size:" + this.size);
        }
    }



    @Override
    public boolean add(int element) {
        this.ensureCapacityInternal(size + 1);
        elementData[size++] = element;
        return true;
    }

    @Override
    public int get(int index) {
        this.rangeCheck(index);
        return elementData[index];
    }

    @Override
    public int pop(int index){
        this.rangeCheck(index);
        int oldValue = elementData[index];
        for(int i = index; i<size - 1;i++){
            elementData[i] = elementData[i+1];
        }
        elementData[ --size] = 0;
        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }


    public int[] getElementData() {
        return elementData;
    }

    public StackArrayBox() {
        elementData = new int[DEFAULT_CAPACITY];
    }

    public StackArrayBox(int capacity) {
        this.elementData = new int[capacity];
    }
}
