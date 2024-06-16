package arvore;

public class NoTurista {
	
	private ItemTurista info;
	private NoTurista esq, dir;

	public NoTurista(ItemTurista elem){
		this.info = elem;
		this.esq = null;
		this.dir = null;
	}
	public NoTurista getEsq(){
		return this.esq;
	}
	public NoTurista getDir(){
		return this.dir;
	}
	public ItemTurista getInfo(){
		return this.info;
	}
	public void setEsq(NoTurista no){
		this.esq = no;
	}
	public void setDir(NoTurista no){
		this.dir = no;
	}
	public void setInfo(ItemTurista elem){
		this.info = elem;
	}

}
