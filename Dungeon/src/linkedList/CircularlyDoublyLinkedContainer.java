package linkedList;

import java.util.Objects;

public class CircularlyDoublyLinkedContainer<E> implements DataTraverser<Box<E>> {
	
	private Box<E> head;
	private int size = 1;
	private Box<E> currentBox;
	
	public CircularlyDoublyLinkedContainer() {
		head = null;
	}
	
	public CircularlyDoublyLinkedContainer(E data) {
		head = new Box<E>(data);
		head.setNextBox(head);
		head.setPreviousBox(head);
	}
	
	public void add(E data) {
		Box<E> boxToAdd = new Box<E>(data);
		if (head == null) {
			head = new Box<E>(data);
			head.setNextBox(head);
			head.setPreviousBox(head);
			currentBox = head;
			return;
		}
		boolean foundLastBox = false;
		Box<E> lastBox = head;
		while (!foundLastBox) {
			if (lastBox.getNextBox().equals(head)) {
				foundLastBox = true;
			} else {
				lastBox = lastBox.getNextBox();
			}
		}
		lastBox.setNextBox(boxToAdd);
		head.setPreviousBox(boxToAdd);
		boxToAdd.setNextBox(head);
		size++;
	}
	
	public E get(int index) {
		Box<E> tempCurrent = head;
		for (int i = 0; i < index; i++) {
			tempCurrent = tempCurrent.getNextBox();
		}
		return tempCurrent.getData();
	}
	
	public void add(E data, int index) {
		Box<E> boxToAdd = new Box<E>(data);
		boolean foundBoxToPush = false;
		Box<E> boxToPush = head;
		int i = 0;
		while (!foundBoxToPush) {
			if (i == index) {
				foundBoxToPush = true;
				boxToPush.getPreviousBox().setNextBox(boxToAdd);
				boxToPush.setPreviousBox(boxToAdd);
			} else {
				i++;
				boxToPush = boxToPush.getNextBox();
			}
		}
		head.setPreviousBox(boxToAdd);
		boxToAdd.setNextBox(head);
		size++;
	}
	
	public void removeFromEnd() {
		remove(size-1);
	}
	
	public void removeFromStart() {
		remove(0);
	}
	
	public boolean remove(int index) {
		if (index == 0) {
			if (head != null) {
				head = head.getNextBox();
				head.clearPreviousBox();
			} else {
				head = null;
			}
			size--;
			return true;
		}
		boolean foundBoxToRemove = false;
		Box<E> boxToRemove = head;
		int i = 0;
		while (!foundBoxToRemove) {
			if (i == index) {
				foundBoxToRemove = true;
				Box<E> nextBox = boxToRemove.getNextBox();
				Box<E> previousBox = boxToRemove.getPreviousBox();
	            if (!nextBox.equals(head)) {
	                nextBox.setPreviousBox(previousBox);
	            }
	            if (!previousBox.equals(head)) {
	                previousBox.setNextBox(nextBox);
	            }
			} if (boxToRemove == null) {
				return false;
			}
			
			else {
				i++;
				boxToRemove = boxToRemove.getNextBox();
			}
		}
		size--;
		return true;
	}
	
	public boolean remove(E element) {
		boolean foundElement = false;
		Box<E> boxToRemove = head;
		while (!foundElement) {
			if (boxToRemove.equals(head) && !boxToRemove.getData().equals(element)) {
				return false;
			} else if (boxToRemove.getData().equals(element)) {
				foundElement = true;
				Box<E> nextBox = boxToRemove.getNextBox();
				boxToRemove.setNextBox(boxToRemove.getPreviousBox());
				nextBox.setPreviousBox(boxToRemove.getPreviousBox());
			} else {
				boxToRemove = boxToRemove.getNextBox();
			}
		}
		size--;
		System.out.println(boxToRemove.getData().getClass().getName());
		return true;
	}
		
	public String toString() {
		if (head == null) {
			return "[]";
		}
		String returnValue = "[\"" + head;
		boolean foundLastBox = false;
		Box<E> lastBox = head;
		while (!foundLastBox) {
			if (lastBox.getNextBox().equals(head)) {
				foundLastBox = true;
			} else {
				lastBox = lastBox.getNextBox();
				returnValue += ("\", \"" + lastBox);
			}
		}
		return returnValue + "\"]";
	}
	
	public int getSize() {
		return size;
	}
	
	public void clear() {
		head = null;
	}

	@Override
	public Box<E> next() {
		currentBox = currentBox.getNextBox();
		return currentBox;
	}

	@Override
	public Boolean hasNext() {
		return true;
	}
	
	public Box<E> previous() {
		currentBox = currentBox.getPreviousBox();
		return currentBox;
	}

	@Override
	public int hashCode() {
		return Objects.hash(currentBox, head, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CircularlyDoublyLinkedContainer other = (CircularlyDoublyLinkedContainer) obj;
		return Objects.equals(currentBox, other.currentBox) && Objects.equals(head, other.head) && size == other.size;
	}
}
