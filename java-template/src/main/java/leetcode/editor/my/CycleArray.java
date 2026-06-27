package leetcode.editor.my;

public class CycleArray<T> {
    private T[] arr;
    private int start;
    private int end;
    private int count;
    private int size;

    public CycleArray() {
        this(1);
    }

    @SuppressWarnings("unchecked")
    public CycleArray(int size) {
        this.size = size;
        arr = (T[]) new Object[size];
        // start是一个闭区间
        start = 0;
        // end是一个开区间，end 指向最后一个有效元素的下一个
        end = 0;
        count = 0;
    }

    @SuppressWarnings("unchecked")
    private void reSize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        for(int i =0; i< count; i ++) {
            newArray[i] = arr[(start + i) % size];
        }
        arr = newArray;
        size = newSize;
        // start 重置
        start = 0;
        // end 重置
        end = count;
        
    }

    public boolean isFull() {
        return count == size;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void addFirst(T t) {
        if(isFull()) {
            reSize(size * 2);
        }
        start = (start - 1 + size) % size;
        arr[start] = t;
        count ++;
    }

    public void addLast(T t) {
        if (isFull()) {
            reSize(size * 2);
        }
        arr[end] = t;
        end = (end + 1) % size;
        count ++;
    }

    public void removeFist() {
        if(isEmpty()) {
            throw new IllegalStateException();
        }

        arr[start] = null;
        start = (start + 1) % size;
        count--;

        if (count>0 && count == size / 4 ) {
            reSize( size  / 2 );
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        end = (end - 1 + size) % size;
        arr[end] = null;
        count -- ;
        if (count>0 && count == size / 4 ) {
            reSize( size  / 2 );
        }
    }
}