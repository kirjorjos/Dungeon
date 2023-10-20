package JoshuaDataHolder;

public class JoshuaDataHolder <E> {
    private E[] data;
    private int dataSize;
    private int intialCapacity;
    
    public JoshuaDataHolder() {
        data = (E[]) new Object[5];
        intialCapacity= 5;
    }
    
    public JoshuaDataHolder(int initialCapacity) {
        this.intialCapacity = initialCapacity;
        data = (E[]) new Object[initialCapacity];
	}
    
    public JoshuaDataHolder(E[] data, int size) {
        this.data = data;
        this.dataSize = size;
    }
    
    public JoshuaDataHolder(E[] data, int size, int initialCapacity) {
        this.data = data;
        this.dataSize = size;
        this.intialCapacity = initialCapacity;
    }
    
    public void addElement(E element) {
        addElement(element, dataSize);
    }
    
    public void clearData() {
        data = (E[])new Object[intialCapacity];
    }
    
    public JoshuaDataHolder<E> deepClone() {
        return new JoshuaDataHolder<E>(this.data, this.data.length, this.intialCapacity);
    }
    
    public void addElement(E element, int index) {
    	// increase array size if not big enough
        if (dataSize >= data.length-1) {
        	E[] oldData = data;
        	data = (E[])new Object[oldData.length*2];
        	for (int i = 0; i<dataSize; i++) {
        		data[i] = oldData[i];
        	}
        }
        
        for (int i = dataSize-1; i>index; i--) {
        	data[i+1] = data[i];
        }
        
        data[index] = element;
        dataSize++;   		
    }
    
    public E getElement(int index) {
    	if (index >= dataSize) throw new ArrayIndexOutOfBoundsException();
    	return data[index];
    }
    
    public boolean isEmpty() {
        return (this.dataSize == 0);
    }
    
    public void removeElement(int index) {
    	for (int i = index; i<dataSize-1; i++) {
    		data[i] = data[i+1];
    	}
    	dataSize--;
    }
    
    public void removeElement() {
    	data[dataSize-1] = null;
    	dataSize--;
    }
    
    public boolean removeElement(final E element) {
        int i = 0;
        boolean loopDone = false;
        while (!loopDone) {
            if (this.data[i++].equals(element)) {
                this.removeElement(i);
                return true;
            }
            if (i >= this.dataSize) {
                loopDone = true;
                return false;
            }
            ++i;
        }
        return false;
    }
    
    public int getSize() {
        return this.dataSize;
    }
    
    public boolean hasElement(E element) {
    	for (int i = 0; i < dataSize; i++) {
    		if (data[i].equals(element)) {
    			return true;
    		}
    	}
    	return false;
    }
}