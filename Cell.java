
public class Cell {
	
	// VARIAVEIS PARA MANIPULAÇÃO DAS CÉLULAS
	private Cell next;
	private Cell previous;
	private Object data;
	
	public Cell(Cell next, Object data) {
		this.next		= next;
		this.previous 	= previous;
		this.data 		= data;
	}
	
	public Cell(Object data) {
		
	    this.data = data;
	}


	public Cell getNext() {
		return next;
	}
	public void setNext(Cell next) {
		this.next = next;
	}

	
	public Cell getPrevious() {
		return previous;
	}
	public void setPrevious(Cell previous) {
		this.previous = previous;
	}

	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
