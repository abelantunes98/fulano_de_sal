package br.com.marmitaria.persistence.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idUsuario")
public class Cliente extends Usuario{

private static final long serialVersionUID = 8712302465568275399L;


}
