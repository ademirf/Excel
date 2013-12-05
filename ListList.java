
public class ListList {
	
	// VARIAVEIS PARA MANIPULAÇÃO DAS LIST
	private List firstList;
	private List lastList;
	private int totalList;
	
	public ListList() {
		
	}
	
	public void Adds(Object dataList) {
		
		if(this.totalList == 0) {
			this.AddsBeginning(dataList);
		}
		else {
			List newList = new List(dataList);
			this.lastList.setNextList(newList);
			this.lastList = newList;
			this.totalList++;
		}
	}
	
	public void AddsBeginning(Object dataList) {
		
		List newList = new List(this.firstList, dataList);
		this.firstList = newList;
		
		if (totalList == 0) {	// fila vazia
			this.lastList = this.firstList;
		}
		this.totalList++;
	}
	
	// adiciona em qualquer posição
	public void Adds(int position, Object dataList) {
		
		if(position == 0) {		// no começo
			this.AddsBeginning(dataList);
		}
		else if (position == this.totalList) {		// no fim
			this.Adds(dataList);
		}
		else {		// em posição intermediaria
			List previousList = this.MagpieList(position - 1);
			List nextList = previousList.getNextList();
			List newList = new List(previousList.getNextList(), dataList);
			newList.setPreviousList(previousList);
			previousList.setNextList(newList);
			previousList.setPreviousList(newList);
		    this.totalList++;
		}
	}
	
	public void RemoveBeginning() {
		
		if (!this.OccupiedPosition(0)) {
		    throw new IllegalArgumentException("Posição não existe!");
		}
		    
		this.firstList = this.firstList.getNextList();
		this.totalList--;
  
		if (this.totalList == 0) {
			this.lastList = null;
		}
	}
	
	public void Remove(int position) {
		
		if (!this.OccupiedPosition(position)) {
			throw new IllegalArgumentException("Posição não existe!");
		}
		    
		if (position == 0) {
			this.RemoveBeginning();
		}
		else if (position == this.totalList - 1) {
			this.RemoveEnd();
		}
		else {
			List previousList = this.MagpieList(position - 1);
			List currentList = previousList.getNextList();
			List nextList = currentList.getNextList();	    
			previousList.setNextList(nextList);
			nextList.setPreviousList(previousList);
			this.totalList--;
		}
	}
	
	public void RemoveEnd() {
		if (!this.OccupiedPosition(this.totalList - 1)) {
			throw new IllegalArgumentException("Posição não existe!");
		}
		if (this.totalList == 1) {
			this.RemoveBeginning();
		}
		else {
			List beforeLastList = this.lastList.getPreviousList();
			beforeLastList.setNextList(null);
			this.lastList = beforeLastList;
			this.totalList--;
		}
	}
	
	public int Size() {
		return this.totalList;
	}
	
	public Object Magpie(int position) {
		  return this.MagpieList(position).getDataList();
	}
	
	public boolean Contains(Object dataList) {
		
		List currentList = this.firstList;
		
		while (currentList != null) {
		
			if (currentList.getDataList().equals(dataList)) {
				return true;
			}
			currentList = currentList.getNextList();	
		}
		return false;
	}
	
	public String toString() {
		//verificando se a lista está vazia
		if (this.totalList == 0) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		List currentList = firstList;
		
		//percorrendo até o último dado
		while (currentList != null) {
		    builder.append(currentList.getDataList());
		    builder.append(", ");
		    currentList = currentList.getNextList();
		}
		//ultimo dado
		builder.append(currentList.getDataList());
		builder.append("]");
		
		return builder.toString();
	}
	
	private boolean OccupiedPosition(int position) {
		return position >= 0 && position < totalList;
	}
	
	private List MagpieList(int position) {
		if (!OccupiedPosition(position)) {
			throw new IllegalArgumentException("Posição não existe!");
		}
		else {
			List currentList = firstList;
			for (int i = 0; i < position; i++) {
				currentList = currentList.getNextList();
			}
			return currentList;
		}
	}
}
