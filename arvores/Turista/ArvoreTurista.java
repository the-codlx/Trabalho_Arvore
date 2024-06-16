package arvore;

public class ArvoreTurista {

    private NoTurista raiz;
	private int quantNos;//opcional

	public Arvore(){

		this.quantNos=0;
		this.raiz = null;
	
    }
	
    public boolean eVazia (){
		
        return (this.raiz == null);
	
    }

	public NoTurista getRaiz(){
	
        return this.raiz;
	
    }
	
    public int getQuantNos(){
	
        return this.quantNos;
	
    }
	
	public boolean inserir (ItemTurista elem){
	
        if (pesquisar (elem.getCodigoT())){
		
            return false;
		
        }
        else{
		
            this.raiz = inserir (elem, this.raiz);
			this.quantNos++;
			return true;
		
        }
	}

	public NoTurista inserir (ItemTurista elem, NoTurista no){

		if (no == null) {

			NoTurista novo = new NoTurista(elem);
			return novo;

		}
        else {

			if (elem.getCodigoT() < no.getInfo().getCodigoT()){
				
                no.setEsq(inserir(elem, no.getEsq()));
				return no;
			
            }
            else{
				
                no.setDir(inserir(elem, no.getDir()));
				return no;
			
            }
		
        }
	
    }
	
	public boolean pesquisar (int codigoT){
		
        if (pesquisar (codigoT, this.raiz)!= null){
			
            return true;
		
        }
        else{
			
            return false;
		
        }
	}

	private NoTurista pesquisar (int codigoT, NoTurista no){
		if (no != null){
			if (codigoT < no.getInfo().getCodigoT()){
				no = pesquisar (codigoT, no.getEsq());
			}else{
				if (codigoT > no.getInfo().getCodigoT()){
					no = pesquisar (codigoT, no.getDir());
				}
			}
		}
		return no;
	}

	public boolean remover (int codigo){
		if (pesquisar (codigo, this.raiz) != null){
			this.raiz = remover (codigo, this.raiz);
			this.quantNos--;
			return true;
		}
		else {
			return false;
		}
	}
	public NoTurista remover (int codigo, NoTurista arvoreT){
		if (codigo < arvoreT.getInfo().getCodigoT()){
			arvoreT.setEsq(remover (codigo, arvoreT.getEsq()));
		}else{
			if (codigo > arvoreT.getInfo().getCodigoT()){
				arvoreT.setDir(remover (codigo, arvoreT.getDir()));
			}else{
				if (arvoreT.getDir()== null){
					return arvoreT.getEsq();
				}else{
					if (arvoreT.getEsq() == null){ 
						return arvoreT.getDir();
					}else{
						arvoreT.setEsq(arrumar(arvoreT, arvoreT.getEsq()));
					}
				}
			}
		}
		return arvoreT;
	}
	private NoTurista arrumar (NoTurista arv, NoTurista maior){
		if (maior.getDir() != null){
			maior.setDir(arrumar (arv, maior.getDir()));
		}
		else{
			arv.setInfo(maior.getInfo());
			maior = maior.getEsq();
		}
		return maior;
	}
	//caminhamento central
	public Item [] CamCentral (){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamCentral (this.raiz, vet, n));
	}
	private Item [] FazCamCentral (NoArv arv, Item [] vet, int []n){
		if (arv != null) {
			vet = FazCamCentral (arv.getEsq(),vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamCentral (arv.getDir(),vet,n);
		}
		return vet;
	}
	//caminhamento pr�-fixado
	public Item [] CamPreFixado (){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamPreFixado (this.raiz, vet, n));
	}
	private Item [] FazCamPreFixado (NoArv arv, Item [] vet, int []n){
		if (arv != null) {
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamPreFixado (arv.getEsq(), vet,n);
			vet = FazCamPreFixado (arv.getDir(), vet,n);
		}
		return vet;
	}
	//caminhamento p�s-fixado
	public Item [] CamPosFixado (){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamPosFixado (this.raiz, vet, n));
	}
	private Item [] FazCamPosFixado (NoArv arv, Item[] vet, int []n){
		if (arv != null) {
			vet = FazCamPosFixado (arv.getEsq(), vet,n);
			vet = FazCamPosFixado (arv.getDir(), vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
		}
		return vet;
	}


    public void mostraTuristaPreFixado (NoTurista arvoreT){

		if (arvoreT != null) {

			System.out.println("Codigo da viagem: " + arvoreT.getInfo().getCodigoV() + "\n");
            System.out.println("Nome do turista: " + arvoreT.getInfo().getNome() + "\n");
            System.out.println("Codigo do turista: " + arvoreT.getInfo().getCodigoT() + "\n");

            System.out.println("------------------------");

			mostraTuristaPreFixado(arvoreT.getEsq());
			mostraTuristaPreFixado(arvoreT.getDir());
		} 
		
	}

	public void alterarTurista (int codigo, int codigoViagem, ArvoreViagem arvoreV) {
		
		NoTurista no = pesquisar(codigo, this.raiz);

		if (no != null) {
			
			if(arvoreV.pesquisar(codigoViagem) == true) {

				no.getInfo().setCodigoV(codigoViagem);
				System.out.println("Viagem do turista alterada com sucesso! ");
			
			}
			else {

				System.out.println("Viagem com o codigo " + codigoViagem + " não encontrada.");

			}
		
		} 
		else {
			
			System.out.println("Turista com o codigo " + codigo + " não encontrada.");
		
		}
		
	}

}



