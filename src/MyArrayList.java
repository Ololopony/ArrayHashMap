



public class MyArrayList<E> {

	private Object[] array;
	private final int defaultListCapasity = 10;
	private int size;

    public MyArrayList() {
		array = new Object[defaultListCapasity];
    }

	public MyArrayList(int capacity) throws Exception {
		if (capacity > 0){
			array = new Object[capacity];
		} else if (capacity == 0){
			array = new Object[defaultListCapasity];
		} else{
			throw new Exception("Capacity is below 0");
		}
	}

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < size; i++) {
			builder.append(array[i]);
			builder.append(" ");
		}
		return builder.toString();
	}

	public int indexOf(Object object){
		for (int i = 0; i < size; i++) {
			if (array[i].equals(object)){
				return i;
			}
		}
		return -1;
	}

	private void growSize(){
		Object[] temp = new Object[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			temp[i] = array[i];
		}
		array = temp;
	}

	public void add(E element){
		if (size == array.length) {
			growSize();
		}
		array[size] = element;
		size++;
	}

	public void add(int index, E element){
		if (index >= 0){
			if (size == array.length) {
				growSize();
			}
			Object[] temp = new Object[array.length];
			for (int i = 0; i < size + 1; i++) {
				if (i < index - 1){
					temp[i] = array[i];
				}
				else if (i == index - 1){
					temp[i] = element;
				}
				else {
					temp[i] = array[i - 1];
				}
			}
			array = temp;
			size++;
		}
	}

	public void set(int index, E element){
		if (index >= 0) {
			array[index] = element;
		}
	}

	public E get(int index) throws Exception
	{
		if (index >= 0){
			return (E) array[index];
		} else{
			throw new Exception("Index below 0");
		}
	}

	public E remove(int index) throws Exception{
		if (index >= 0) {	
			E element = (E) array[index];
			Object[] temp = new Object[array.length];
			for (int i = 0, k = 0; i < size; i++) {
				if (i == index){
					continue;
				}
				temp[k++] = array[i];
			}
			array = temp;
			size--;
			return element;
		} else{
			throw new Exception("Index below 0");
		}
	}

}
