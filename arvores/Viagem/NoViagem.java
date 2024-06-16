package arvore;

public class NoViagem {
	
	private ItemViagem info;
	private NoViagem esq, dir;

	public NoViagem(ItemViagem elem){
		this.info = elem;
		this.esq = null;
		this.dir = null;
	}
	public NoViagem getEsq(){
		return this.esq;
	}
	public NoViagem getDir(){
		return this.dir;
	}
	public ItemViagem getInfo(){
		return this.info;
	}
	public void setEsq(NoViagem no){
		this.esq = no;
	}
	public void setDir(NoViagem no){
		this.dir = no;
	}
	public void setInfo(ItemViagem elem){
		this.info = elem;
	}

}
