package general;

public class Abono {
	private int dosDiasInicial;
	private int tresDiasInicial;
	private int cantVendidosDosDias;
	private int cantVendidosTresDias;

	
	public Abono(int dosDias, int tresDias, int cantVendidosDosDias, int cantVendidosTresDias) {
		this.dosDiasInicial = dosDias;
		this.tresDiasInicial = tresDias;
		this.cantVendidosDosDias = cantVendidosDosDias;
		this.cantVendidosTresDias = cantVendidosTresDias;
	}
	
	public int getDosDiasInicial() {
		return dosDiasInicial;
	}

	public int getTresDiasInicial() {
		return tresDiasInicial;
	}
	
	public int getCantVendidosDosDias() {
		return cantVendidosDosDias;
	}

	public int getCantVendidosTresDias() {
		return cantVendidosTresDias;
	}
	
	public int cantEntradasActualDosDias() {
		return this.dosDiasInicial - this.cantVendidosDosDias;
	}
	
	public int cantEntradasActualTresDias() {
		return this.tresDiasInicial - this.cantVendidosTresDias;
	}
	
	public boolean hayCuponesDosDiasDisponibles(int cant) {
		return this.cantEntradasActualDosDias() >= cant;
	}
	
	public boolean hayCuponesTresDiasDisponibles(int cant) {
		return this.cantEntradasActualTresDias() >= cant;
	}

	public void compraEntradasDosDias(int cant) {
		this.cantVendidosDosDias+= cant;
	}
	
	public void compraEntradasTresDias(int cant) {
		this.cantVendidosTresDias+= cant;
	}
	
}
