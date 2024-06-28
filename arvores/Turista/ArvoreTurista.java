package arvore;

public class ArvoreTurista {

	private NoTurista raiz;
	private int quantNos;// opcional

	public Arvore(){

		this.quantNos=0;
		this.raiz = null;
	
    }



	public boolean eVazia() {

		return (this.raiz == null);

	}



	public NoTurista getRaiz() {

		return this.raiz;

	}



	public int getQuantNos() {

		return this.quantNos;

	}



	public boolean inserir(ItemTurista elem) {

		if (pesquisar(elem.getCodigoT())) {

			return false;

		} 
		
		else {

			this.raiz = inserir(elem, this.raiz);
			this.quantNos++;
			return true;

		}

	}



	private NoTurista inserir(ItemTurista elem, NoTurista no) {

		if (no == null) {

			NoTurista novo = new NoTurista(elem);
			return novo;

		}
		
		else {

			if (elem.getCodigoT() < no.getInfo().getCodigoT()) {

				no.setEsq(inserir(elem, no.getEsq()));
				return no;

			} 
			
			else {

				no.setDir(inserir(elem, no.getDir()));
				return no;

			}

		}

	}
	


	public boolean pesquisar(int codigoT) {

		if (pesquisar(codigoT, this.raiz) != null) {

			return true;

		} else {

			return false;

		}
	}



	private NoTurista pesquisar(int codigoT, NoTurista no) {

		if (no != null) {
			
			if (codigoT < no.getInfo().getCodigoT()) {

				no = pesquisar(codigoT, no.getEsq());

			} 
			
			else {

				if (codigoT > no.getInfo().getCodigoT()) {

					no = pesquisar(codigoT, no.getDir());

				}

			}

		}

		return no;

	}



	public boolean remover(int codigo) {

		if (pesquisar(codigo, this.raiz) != null) {

			this.raiz = remover(codigo, this.raiz);
			this.quantNos--;
			return true;

		} 
		
		else {

			return false;

		}

	}




	private NoTurista remover(int codigo, NoTurista arvoreT) {

		if (codigo < arvoreT.getInfo().getCodigoT()) {

			arvoreT.setEsq(remover(codigo, arvoreT.getEsq()));

		} 
		
		else {

			if (codigo > arvoreT.getInfo().getCodigoT()) {

				arvoreT.setDir(remover(codigo, arvoreT.getDir()));

			} 
			
			else {

				if (arvoreT.getDir() == null) {

					return arvoreT.getEsq();

				} 
				
				else {

					if (arvoreT.getEsq() == null) {

						return arvoreT.getDir();

					} 
					
					else {

						arvoreT.setEsq(arrumar(arvoreT, arvoreT.getEsq()));

					}

				}

			}

		}
		
		return arvoreT;

	}



	private NoTurista arrumar(NoTurista arv, NoTurista maior) {

		if (maior.getDir() != null) {

			maior.setDir(arrumar(arv, maior.getDir()));

		}
		
		else {

			arv.setInfo(maior.getInfo());
			maior = maior.getEsq();

		}

		return maior;

	}



	/*public Double ValorTotal() {
		int[] n = new int[1];
		n[0] = 0;
		
		return (FazCamCentral(this.raiz, vet, n));
	}*/

	public Double valorTotal(NoViagem raiz, int quantidade, double valor) {
		
		if (raiz != null) {

			if(raiz.getInfo().getCodigoV() == codigo) {

				valor = raiz.getInfo().getValor();
				return valor * quantidade;

			}
		
		}

		valor = valorTotal(raiz.getEsq(), quantidade, );
		valor = valorTotal(arv.getDir(), quantidade, n);

		return valor;
	
	}

	

	public int contarTuristasPorViagem(NoTurista no, int codigoViagem) {
		
		if (no == null) {
			return 0;
		}

		int contador = 0;

		if (no.getInfo().getCodigoV() == codigoViagem) {
			contador = 1;
		}

		contador += contarTuristasPorViagem(no.getEsq(), codigoViagem);
		contador += contarTuristasPorViagem(no.getDir(), codigoViagem);

		return contador;
	}

	

	public String alterarTurista(int codigo, int codigoViagem, ArvoreViagem arvoreV) {

		NoTurista no = pesquisar(codigo, this.raiz);

		if (no != null) {

			if (arvoreV.pesquisar(codigoViagem) == true) {

				no.getInfo().setCodigoV(codigoViagem);
				return "Viagem do turista alterada com sucesso!";

			} else {

				return "Viagem com o codigo " + codigoViagem + " não encontrada.";

			}

		} else {

			return "Turista com o codigo " + codigo + " não encontrado.";

		}

	}

}
