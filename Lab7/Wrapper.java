class Wrapper<ObjectType> {
    private ObjectType m_data;

    public Wrapper(ObjectType data) {
        m_data = data;
    }

    public void swap (Wrapper swapObject) {
        SwapObjects(this, swapObject);
    }

    public static void SwapObjects (Wrapper firstObject, Wrapper secondObject) {
        if (firstObject.GetData().getClass() == secondObject.GetData().getClass()) {
            Object dataSaveObject = secondObject.m_data;
            secondObject.m_data = firstObject.m_data;
            firstObject.m_data = dataSaveObject;
        }
    }

    public ObjectType GetData() {
        return m_data;
    }

    public void SetData(ObjectType data) {
        m_data = data;
    }
}