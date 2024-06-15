package arvore;

public class ItemTurista {

	private int codigoV;
	private int codigoT;
	private String nome;
	
	public ItemTurista(int codigoT, String nome,int codigoV) {
		this.codigoT = codigoT;
		this.nome = nome;
		this.codigoV = codigoV;
	}

	public ItemTurista() {
		this.codigoT = 0;
		this.nome = " ";
		this.codigoV = 0;
	

	}

	public int getCodigoV() {
		return codigoV;
	}

	public void setCodigoV(int codigoV) {
		this.codigoV = codigoV;
	}

	public int getCodigoT() {
		return codigoT;
	}

	public void setCodigoT(int codigoT) {
		this.codigoT = codigoT;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "ItemTurista [codigoV=" + codigoV + ", codigoT=" + codigoT + ", nome=" + nome + "]";
	}
	
	
	
}
