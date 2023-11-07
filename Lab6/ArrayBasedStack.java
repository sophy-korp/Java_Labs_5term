import java.util.Arrays;

public class ArrayBasedStack<T> {
    private T[] m_data;
    private int m_size = 0;

    public ArrayBasedStack(int capacity){
        m_data = (T[]) new Object[capacity];
    }

    public ArrayBasedStack(){
        this(16);
    }

    public T peek(){
        return m_data[m_size - 1];
    }

    public T pop(){
        if(m_size == 0){
            return null;
        }
        T res = m_data[m_size - 1];
        m_data[m_size - 1] = null;
        m_size--;
        return res;
    }

    public void push(T element){
        if(m_size == m_data.length){
            m_data = Arrays.copyOf(m_data, m_data.length * 2);
        }
        m_data[m_size] = element;
        m_size++;
    }

    public boolean is_empty(){
        return m_size == 0;
    }

    public int size(){
        return m_size;
    }
}
