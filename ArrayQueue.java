
public class ArrayQueue implements Queue {
	
	public Object [] arrayQ = new Object [10];
	private int head = 0;
	private int tail = 0;
	
	@Override
	public Object dequeue() {
		if(empty()) {
			return null;
		}
		Object item = this.arrayQ[this.head++];
		if(this.head == this.arrayQ.length) {
			this.head = 0;
		}
		return item;
	}

	@Override
	public void enqueue(Object item) {
		if(queueIsFull()) {
			doubleSizeOfQueue();
		}
		this.arrayQ[this.tail++] = item;
		if(this.tail == this.arrayQ.length) {
			this.tail = 0;
		}
	}

	@Override
	public boolean empty() {
		return (this.tail == this.head);	
	}
	
	public boolean queueIsFull() {
		return (this.tail + 1 % this.arrayQ.length == head);
	}
	
	//create new array that is double size of original array
	public void doubleSizeOfQueue() {
		Object [] tempArr = new Object [this.arrayQ.length * 2];
		if(this.tail < this.head) { //we've added to the beginning of our circular array
			int i = this.head;
			int tempArrIndex = 0;
			while(i < this.arrayQ.length) { //copy from head to end
				tempArr[tempArrIndex++] = this.arrayQ[i++];
			}
			i = 0;
			while(i < this.tail) { //copy from tail to head
				tempArr[tempArrIndex++] = this.arrayQ[i++];
			}
		} else {
			for(int i = 0; i < this.arrayQ.length; i++) {
				tempArr[i] = this.arrayQ[i];
			}
		}
		this.head = 0;
		this.tail = this.arrayQ.length - 1;
		this.arrayQ = tempArr;
		
	}
}
