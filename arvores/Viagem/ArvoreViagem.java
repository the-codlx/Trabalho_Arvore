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
	
	public boolean inserirViagem (ItemViagem elem){
		if (pesquisar (elem.getCodigoV())){
			return false;
		}else{
			this.raiz = inserirViagem (elem, this.raiz);
			this.quantNos++;
			return true;
		}
	}
	public NoViagem inserirViagem (ItemViagem elem, NoViagem no){
		if (no == null){
			NoViagem novo = new NoViagem(elem);
			return novo;
		}else {
			if (elem.getCodigoV() < no.getInfo().getCodigoV()){
				no.setEsq(inserirViagem(elem, no.getEsq()));
				return no;
			}else{
				no.setDir(inserirViagem(elem, no.getDir()));
				return no;
			}
		}
	}
	
	public boolean pesquisar (int codigo){
		if (pesquisar (codigo, this.raiz)!= null){
			return true;
		}else{
			return false;
		}
	}

	public NoViagem pesquisar (int codigo, NoViagem no){
		if (no != null){
			if (codigo < no.getInfo().getCodigoV()){
				no = pesquisar (codigo, no.getEsq());
			}else{
				if (codigo > no.getInfo().getCodigoV()){
					no = pesquisar (codigo, no.getDir());
				}
			}
		}
		return no;
	}


	public void alterarViagem (int codigo, NoViagem novoNo) {
		
		NoViagem no = pesquisar(codigo, this.raiz);

		if (no != null) {
			
			no.setInfo(novoNo.getInfo());
			System.out.println("Viagem alterada com sucesso! ");
		
		} 
		else {
			
			System.out.println("Viagem com o código " + codigo + " não encontrada.");
		
		}
		
	}


	public boolean remover (int codigo) {

		if (pesquisar (codigo, this.getRaiz()) != null){
			this.raiz = remover(codigo, this.getRaiz());
			this.quantNos--;
			return true;
		}
		else {
			return false;
		}
	}

	public NoViagem remover (int codigo, NoViagem arv){
		if (codigo < arv.getInfo().getCodigoV()){
			arv.setEsq(remover(codigo, arv.getEsq()));
		}else{
			if (codigo > arv.getInfo().getCodigoV()){
				arv.setDir(remover(codigo, arv.getDir()));
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
	public ItemViagem [] FazCamPreFixado (NoViagem arv, ItemViagem [] vet, int []n){
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


	public void mostraViagensPreFixado (NoViagem arv){

		if (arv != null) {

			System.out.println("Codigo da viagem: " + arv.getInfo().getCodigoV() + "\n");
            System.out.println("Origem da viagem " + arv.getInfo().getOrigemV() + "\n");
            System.out.println("Destino da viagem: " + arv.getInfo().getDestinoV() + "\n");
            System.out.println("Valor da viagem: " + arv.getInfo().getValorV() + "\n");

            System.out.println("------------------------");

			mostraViagensPreFixado(arv.getEsq());
			mostraViagensPreFixado(arv.getDir());
		}
		
	}



}
