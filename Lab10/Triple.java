public class Triple<T extends Comparable<T>> {
    private T m_first;
    private T m_second;
    private T m_third;

    public Triple(T first, T second, T third){
        m_first = first;
        m_second = second;
        m_third = third;
    }

    public T getFirst(){
        return m_first;
    }
    public T getSecond(){
        return m_second;
    }
    public T getThird(){
        return m_third;
    }

    public void setFirst(T first){
        m_first = first;
    }
    public void setSecond(T second){
        m_second = second;
    }
    public void setThird(T third){
        m_third = third;
    }

    @Override
    public String toString() {
        return "{" + m_first + ", " + m_second + ", " + m_third + "}";
    }

    public T min() throws ImpossibleOperationExeption {
        if (m_first.compareTo(m_second) == 0) {
            if (m_third.compareTo(m_second) < 0) {
                return m_third;
            } else {
                throw new ImpossibleOperationExeption("Невозможно определить наименьший элемент тройки");
            }
        }


        if(m_second.compareTo(m_third) == 0){
            if(m_first.compareTo(m_third) < 0){
                return m_first;
            }
            else{
                throw new ImpossibleOperationExeption("Невозможно определить наименьший элемент тройки");
            }
        }

        if(m_first.compareTo(m_third) == 0){
            if(m_second.compareTo(m_third) < 0){
                return m_second;
            }
            else{
                throw new ImpossibleOperationExeption("Невозможно определить наименьший элемент тройки");
            }
        }

        if (m_first.compareTo(m_second) < 0) {
            return (m_first.compareTo(m_third) < 0 ? m_first : m_third);
        }
        else {
            return (m_second.compareTo(m_third) < 0 ? m_second : m_third);
        }
    }

    public T max() throws ImpossibleOperationExeption{
        if(m_first.compareTo(m_second) == 0){
            if(m_third.compareTo(m_second) > 0){
                return m_third;
            }
            else{
                throw new ImpossibleOperationExeption("Невозможно определить наибольший элемент тройки");
            }
        }

        if(m_second.compareTo(m_third) == 0){
            if(m_first.compareTo(m_third) > 0){
                return m_first;
            }
            else{
                throw new ImpossibleOperationExeption("Невозможно определить наибольший элемент тройки");
            }
        }

        if(m_first.compareTo(m_third) == 0){
            if(m_second.compareTo(m_third) > 0){
                return m_second;
            }
            else{
                throw new ImpossibleOperationExeption("Невозможно определить наибольший элемент тройки");
            }
        }

        if(m_first.compareTo(m_second) > 0){
            return (m_first.compareTo(m_third) > 0 ? m_first : m_third);
        }
        else{
            return (m_second.compareTo(m_third) > 0 ? m_second : m_third);
        }
    }

    public T mean() throws ImpossibleOperationExeption{
        if((m_first.compareTo(m_second) == 0) || (m_second.compareTo(m_third) == 0) || (m_third.compareTo(m_first) == 0)){
            throw new ImpossibleOperationExeption("Невозможно определить средний по значению элемент тройки");
        }
        if (m_first.compareTo(m_second) > 0) {
            if (m_first.compareTo(m_third) < 0){
                return m_first;
            }
            else{
                return (m_second.compareTo(m_third) > 0 ? m_second : m_third);
            }
        }
        else {
            if (m_second.compareTo(m_third) < 0){
                return m_second;
            }
            else{
                return m_first.compareTo(m_third) > 0 ? m_first : m_third;
            }
        }


    }
}
