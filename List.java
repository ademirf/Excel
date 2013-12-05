
public class List {
	
	// VARIAVEIS PARA MANIPULAÇÃO DA LIST LIST
	private List nextList;
	private List previousList;
	private Object dataList;
	private int indexList;
	
	// VARIAVEIS PARA MANIPULAR AS CÉLULAS
	private Cell first;
	private Cell last;
	private int totalData;
	
	public List(List nextList, Object dataList) {
		
		this.nextList		= nextList;
		this.previousList 	= previousList;
		this.dataList 		= dataList;
	}
	
	public List(Object dataList) {
		
	    this.dataList = dataList;
	}

	public void Adds(Object data) {
		
		if(this.totalData == 0) {
			this.AddsBeginning(data);
		}
		else {
			Cell newCell = new Cell(data);
			this.last.setNext(newCell);
			this.last = newCell;
			this.totalData++;
		}
	}
	
	public void AddsBeginning(Object data) {
		
		Cell newCell = new Cell(this.first, data);
		this.first = newCell;
		
		if (totalData == 0) {
			// fila vazia
			this.last = this.first;
		}
		this.totalData++;
	}
	
	// adiciona em qualquer posição
	public void Adds(int position, Object data) {
		
		if(position == 0) {		// no começo
			this.AddsBeginning(data);
		}
		else if (position == this.totalData) {		// no fim
			this.Adds(data);
		}
		else {		// em posição intermediaria
			Cell previous = this.MagpieCell(position - 1);
			Cell next = previous.getNext();
			Cell newCell = new Cell(previous.getNext(), data); // verificar erro apontando para o construtor da classe Cell
			newCell.setPrevious(previous);
			previous.setNext(newCell);
			previous.setPrevious(newCell);
		    this.totalData++;
		}
	}
	
	public void RemoveBeginning() {
		
		if (!this.OccupiedPosition(0)) {
		    throw new IllegalArgumentException("Posição não existe!");
		}
		    
		this.first = this.first.getNext();
		this.totalData--;
  
		if (this.totalData == 0) {
			this.last = null;
		}
	}
	
	public void Remove(int position) {
		
		if (!this.OccupiedPosition(position)) {
			throw new IllegalArgumentException("Posição não existe!");
		}
		    
		if (position == 0) {
			this.RemoveBeginning();
		}
		else if (position == this.totalData - 1) {
			this.RemoveEnd();
		}
		else {
			Cell previous = this.MagpieCell(position - 1);
			Cell currentCell = previous.getNext();
			Cell next = currentCell.getNext();    
			previous.setNext(next);
			next.setPrevious(previous);
			this.totalData--;
		}
	}
	
	public void RemoveEnd() {
		if (!this.OccupiedPosition(this.totalData - 1)) {
			throw new IllegalArgumentException("Posição não existe!");
		}
		if (this.totalData == 1) {
			this.RemoveBeginning();
		}
		else {
			Cell beforeLast = this.last.getPrevious();
			beforeLast.setNext(null);
			this.last = beforeLast;
			this.totalData--;
		}
	}
	
	public int Size() {
		return this.totalData;
	}
	
	public Object Magpie(int position) {
		  return this.MagpieCell(position).getData();
	}
	
	public boolean Contains(Object data) {
		
		Cell currentCell = this.first;
		
		while (currentCell != null) {
		
			if (currentCell.getData().equals(data)) {
				return true;
			}
			currentCell = currentCell.getNext();	
		}
		return false;
	}
	
	public String toString() {
		//verificando se a lista está vazia
		if (this.totalData == 0) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		Cell currentCell = first;
		
		//percorrendo até o último dado
		while (currentCell != null) {
		    builder.append(currentCell.getData());
		    builder.append(", ");
		    currentCell = currentCell.getNext();
		}
		//ultimo dado
		builder.append(currentCell.getData());
		builder.append("]");
		
		return builder.toString();
	}
	
	private boolean OccupiedPosition(int position) {
		return position >= 0 && position < totalData;
	}
	
	private Cell MagpieCell(int position) {
		if (!OccupiedPosition(position)) {
			throw new IllegalArgumentException("Posição não existe!");
		}
		else {
			Cell currentCell = first;
			for (int i = 0; i < position; i++) {
				currentCell = currentCell.getNext();
			}
			return currentCell;
		}
	}
	

	public List getNextList() {
		return nextList;
	}
	public void setNextList(List nextList) {
		this.nextList = nextList;
	}

	
	public List getPreviousList() {
		return previousList;
	}
	public void setPreviousList(List previousList) {
		this.previousList = previousList;
	}

	
	public Object getDataList() {
		return dataList;
	}
	public void setDataList(Object dataList) {
		this.dataList = dataList;
	}

	
	public int getIndexList() {
		return indexList;
	}
	public void setIndexList(int indexList) {
		this.indexList = indexList;
	}
	
}
	
