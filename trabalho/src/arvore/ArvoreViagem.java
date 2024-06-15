package arvore;

public class ArvoreViagem {
	private NoViagem raiz;
	private int quantNos;

	public ArvoreViagem(){
		this.quantNos=0;
		this.raiz = null;
	}
	public boolean eVazia (){
		return (this.raiz == null);
	}
	public NoViagem getRaiz(){
		return this.raiz;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	
	public boolean inserir (ItemViagem elem){
		if (pesquisar (elem.getCodigoV())){
			return false;
		}else{
			this.raiz = inserir (elem, this.raiz);
			this.quantNos++;
			return true;
		}
	}
	public NoViagem inserir (ItemViagem elem, NoViagem no){
		if (no == null){
			NoViagem novo = new NoViagem(elem);
			return novo;
		}else {
			if (elem.getCodigoV() < no.getInfo().getCodigoV()){
				no.setEsq(inserir(elem, no.getEsq()));
				return no;
			}else{
				no.setDir(inserir(elem, no.getDir()));
				return no;
			}
		}
	}
	
	public boolean pesquisar (int chave){
		if (pesquisar (chave, this.raiz)!= null){
			return true;
		}else{
			return false;
		}
	}
	private NoViagem pesquisar (int chave, NoViagem no){
		if (no != null){
			if (chave < no.getInfo().getCodigoV()){
				no = pesquisar (chave, no.getEsq());
			}else{
				if (chave > no.getInfo().getCodigoV()){
					no = pesquisar (chave, no.getDir());
				}
			}
		}
		return no;
	}

	public boolean remover (int chave){
		if (pesquisar (chave, this.raiz) != null){
			this.raiz = remover (chave, this.raiz);
			this.quantNos--;
			return true;
		}
		else {
			return false;
		}
	}
	public NoViagem remover (int chave, NoViagem arv){
		if (chave < arv.getInfo().getCodigoV()){
			arv.setEsq(remover (chave, arv.getEsq()));
		}else{
			if (chave > arv.getInfo().getCodigoV()){
				arv.setDir(remover (chave, arv.getDir()));
			}else{
				if (arv.getDir()== null){
					return arv.getEsq();
				}else{
					if (arv.getEsq() == null){ 
						return arv.getDir();
					}else{
						arv.setEsq(arrumar(arv, arv.getEsq()));
					}
				}
			}
		}
		return arv;
	}
	private NoViagem arrumar (NoViagem arv, NoViagem maior){
		if (maior.getDir() != null){
			maior.setDir(arrumar (arv, maior.getDir()));
		}
		else{
			arv.setInfo(maior.getInfo());
			maior = maior.getEsq();
		}
		return maior;
	}
	
	public ItemViagem [] CamCentral (){
		int []n= new int[1];
		n[0]=0;
		ItemViagem [] vet = new ItemViagem[this.quantNos];
		return (FazCamCentral (this.raiz, vet, n));
	}
	private ItemViagem [] FazCamCentral (NoViagem arv, ItemViagem [] vet, int []n){
		if (arv != null) {
			vet = FazCamCentral (arv.getEsq(),vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamCentral (arv.getDir(),vet,n);
		}
		return vet;
	}
	
	public ItemViagem [] CamPreFixado (){
		int []n= new int[1];
		n[0]=0;
		ItemViagem [] vet = new ItemViagem[this.quantNos];
		return (FazCamPreFixado (this.raiz, vet, n));
	}
	private ItemViagem [] FazCamPreFixado (NoViagem arv, ItemViagem [] vet, int []n){
		if (arv != null) {
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamPreFixado (arv.getEsq(), vet,n);
			vet = FazCamPreFixado (arv.getDir(), vet,n);
		}
		return vet;
	}
	
	public ItemViagem [] CamPosFixado (){
		int []n= new int[1];
		n[0]=0;
		ItemViagem [] vet = new ItemViagem[this.quantNos];
		return (FazCamPosFixado (this.raiz, vet, n));
	}
	private ItemViagem [] FazCamPosFixado (NoViagem arv, ItemViagem[] vet, int []n){
		if (arv != null) {
			vet = FazCamPosFixado (arv.getEsq(), vet,n);
			vet = FazCamPosFixado (arv.getDir(), vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
		}
		return vet;
	}

}
