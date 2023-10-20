package linkedList;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(data, nextBox, previousBox);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Box<E> other = (Box<E>) obj;
		return Objects.equals(data, other.data) && Objects.equals(nextBox, other.nextBox)
				&& Objects.equals(previousBox, other.previousBox);
	}
}
