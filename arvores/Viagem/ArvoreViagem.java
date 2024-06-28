package arvore;

public class ArvoreViagem {

	private NoViagem raiz;
	private int quantNos;

	public ArvoreViagem() {

		this.quantNos = 0;
		this.raiz = null;

	}

	public boolean eVazia() {

		return (this.raiz == null);

	}

	public NoViagem getRaiz() {

		return this.raiz;

	}

	public int getQuantNos() {

		return this.quantNos;

	}

	public boolean inserirViagem(ItemViagem elem) {

		if (pesquisar(elem.getCodigoV())) {

			return false;

		}

		else {

			this.raiz = inserirViagem(elem, this.raiz);
			this.quantNos++;
			return true;

		}

	}

	public NoViagem inserirViagem(ItemViagem elem, NoViagem no) {

		if (no == null) {

			NoViagem novo = new NoViagem(elem);
			return novo;

		}

		else {

			if (elem.getCodigoV() < no.getInfo().getCodigoV()) {

				no.setEsq(inserirViagem(elem, no.getEsq()));
				return no;

			}

			else {

				no.setDir(inserirViagem(elem, no.getDir()));
				return no;

			}
		}
	}

	public boolean pesquisar(int codigo) {

		if (pesquisar(codigo, this.raiz) != null) {

			return true;

		}

		else {

			return false;

		}
	}

	private NoViagem pesquisar(int codigo, NoViagem no) {

		if (no != null) {

			if (codigo < no.getInfo().getCodigoV()) {

				no = pesquisar(codigo, no.getEsq());

			}

			else {

				if (codigo > no.getInfo().getCodigoV()) {

					no = pesquisar(codigo, no.getDir());

				}

			}

		}

		return no;

	}

	public boolean remover(int codigo) {

		if (pesquisar(codigo, this.getRaiz()) != null) {

			this.raiz = remover(codigo, this.getRaiz());
			this.quantNos--;
			return true;

		}

		else {

			return false;

		}

	}

	public NoViagem remover(int codigo, NoViagem arv) {

		if (codigo < arv.getInfo().getCodigoV()) {

			arv.setEsq(remover(codigo, arv.getEsq()));

		} else {

			if (codigo > arv.getInfo().getCodigoV()) {

				arv.setDir(remover(codigo, arv.getDir()));

			}

			else {

				if (arv.getDir() == null) {

					return arv.getEsq();

				}

				else {

					if (arv.getEsq() == null) {

						return arv.getDir();

					}

					else {

						arv.setEsq(arrumar(arv, arv.getEsq()));

					}

				}

			}

		}

		return arv;

	}

	private NoViagem arrumar(NoViagem arv, NoViagem maior) {

		if (maior.getDir() != null) {

			maior.setDir(arrumar(arv, maior.getDir()));

		}

		else {

			arv.setInfo(maior.getInfo());
			maior = maior.getEsq();

		}

		return maior;

	}



	public String alterarViagemBooleano(int codigo, NoViagem novoNo) {

		NoViagem no = pesquisar(codigo, this.raiz);

		no.setInfo(novoNo.getInfo());
		return "Viagem com o código " + codigo + " alterada com sucesso.";

	}



		public Double valorViagem(NoViagem raiz, int codigo) {
		
			if (raiz == null) {
				return 0.0;
			}
		
			if (raiz.getInfo().getCodigoV() == codigo) {
				return raiz.getInfo().getValorV();
			}
    		
			if (valorViagem(raiz.getEsq(), codigo) != 0.0) { 

        		return valorViagem(raiz.getEsq(), codigo);
    		
			}

    		return valorViagem(raiz.getDir(), codigo);
	
		}

}
