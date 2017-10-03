
public class ArrayStack implements Stack {
	
	public int top = 0;
	public Object [] arr = new Object [10];
	
	@Override
	public void push(Object item) {
		if(top == this.arr.length) {
			doubleSizeOfStack();
		}
		this.arr[this.top++] = item;
		
	}

	@Override
	public Object pop() {
		if(!empty()) {
			this.top--;
			return this.arr[this.top];
		}
		return null;
	}

	@Override
	public Object peek() {
		if(!empty()) {
			return this.arr[this.top - 1];
		}
		return null;
	}

	@Override
	public boolean empty() {
		return (top == 0);
	}
	
	public void doubleSizeOfStack() {
		Object [] tempArr = new Object [this.arr.length * 2];
		for(int i = 0; i < this.arr.length; i++) {
			tempArr[i] = this.arr[i];
		}
		this.arr = tempArr;
	}

}
