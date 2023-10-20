package linkedList;

public class Box<E> {
	private E data;
	private Box<E> previousBox = null;
	private Box<E> nextBox = null;
	
	public Box(E data) {
		this.data = data;
	}
	
	public void setPreviousBox(Box<E> box) {
		previousBox = box;
		if (getPreviousBox() != null) {
			if (getPreviousBox().getNextBox() != this) {
				previousBox.setNextBox(this);
			}
		}
	}
	
	public void setNextBox(Box<E> box) {
		nextBox = box;
		if (getNextBox() != null) {
			if (getNextBox().getPreviousBox() != this) {
				nextBox.setPreviousBox(this);	
			}
		}
	}
	
	public void clearPreviousBox() {
		previousBox = null;
	}
	
	public void clearNextBox() {
		nextBox = null;
	}
	
	public String toString() {
		return data.toString();
	}
	
	public Box<E> getNextBox() {
		return nextBox;
	}
	
	public Box<E> getPreviousBox() {
		return previousBox;
	}
	
	public E getData() {
		return data;
	}
}
