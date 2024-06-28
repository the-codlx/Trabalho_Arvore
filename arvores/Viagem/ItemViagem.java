package arvore;

public class ItemViagem {
		
		private int codigoV;
		private String origemV;
		private String destinoV;
		private double valorV;
		
		public ItemViagem(int codigoV, String origemV, String destinoV, double valorV) {
			super();
			this.codigoV = codigoV;
			this.origemV = origemV;
			this.destinoV = destinoV;
			this.valorV = valorV;
		}
		
		/*

		ideia do lester
		
		private int codigo, qtdTuristas;
		private double valorPessoa, valorTotal;

		public ItemViagem(int codigo, int turistas, double valorPessoa) {
			this.codigo = random;
			this.qtdTuristas = turistas;
			this.valorPessoa = valorPessoa;
			this.valorTotal = turistas * valorPessoa;
			}
		*/



		public ItemViagem() {
			super();
			this.codigoV = 0;
			this.origemV = "";
			this.destinoV = "";
			this.valorV = 0;
		}

		public int getCodigoV() {
			return codigoV;
		}

		public void setCodigoV(int codigoV) {
			this.codigoV = codigoV;
		}

		public String getOrigemV() {
			return origemV;
		}

		public void setOrigemV(String origemV) {
			this.origemV = origemV;
		}

		public String getDestinoV() {
			return destinoV;
		}

		public void setDestinoV(String destinoV) {
			this.destinoV = destinoV;
		}

		public double getValorV() {
			return valorV;
		}

		public void setValorV(double valorV) {
			this.valorV = valorV;
		}

		@Override
		public String toString() {
			return "ItemViagem [codigoV=" + codigoV + ", origemV=" + origemV + ", destinoV=" + destinoV + ", valorV="
					+ valorV + "]";
		}
		
	
		
	}
