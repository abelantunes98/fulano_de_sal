package br.com.marmitaria.rest.util;

import java.util.Comparator;

import br.com.marmitaria.persistence.model.Pedido;

public class ComparatorPedido implements Comparator<Pedido>{

	@Override
	public int compare(Pedido o1, Pedido o2) {
		int retorno = 0;
		
		int retorno1 = 0;
		int retorno2 = 0;
		if(o1.getConfirmado())retorno1 = 1;
		if(o2.getConfirmado())retorno2 = 1;
		
		retorno = retorno1 - retorno2;
		
		if(retorno==0){
			retorno = (int) (o2.getIdPedido() - o1.getIdPedido());
		}
		return retorno;
	}

}
