package com.pojo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Broj tečajnice", "Datum primjene", "Država", "Šifra valute", "Valuta", "Jedinica",
		"Kupovni za devize", "Srednji za devize", "Prodajni za devize" })
public class TecajPOJO {
	@JsonProperty("Broj tečajnice")
	private String brojTecanice;
	@JsonProperty("Datum primjene")
	private String datumPrimjene;
	@JsonProperty("Država")
	private String drzava;
	@JsonProperty("Šifra valute")
	private String sifraValut;
	@JsonProperty("Valuta")
	private String valuta;
	@JsonProperty("Jedinica")
	private int jedinica;
	@JsonProperty("Kupovni za devize")
	private String kupovniZaDevize;
	@JsonProperty("Srednji za devize")
	private String srednjiZaDevize;
	@JsonProperty("Prodajni za devize")
	private String prodajniZaDevize;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Broj tečajnice")
	public String getBrojTecanice() {
		return brojTecanice;
	}

	@JsonProperty("Broj tečajnice")
	public void setBrojTecanice(String brojTecanice) {
		this.brojTecanice = brojTecanice;
	}

	public TecajPOJO withBrojTeAjnice(String brojTeAjnice) {
		this.brojTecanice = brojTeAjnice;
		return this;
	}

	@JsonProperty("Datum primjene")
	public String getDatumPrimjene() {
		return datumPrimjene;
	}

	@JsonProperty("Datum primjene")
	public void setDatumPrimjene(String datumPrimjene) {
		this.datumPrimjene = datumPrimjene;
	}

	public TecajPOJO withDatumPrimjene(String datumPrimjene) {
		this.datumPrimjene = datumPrimjene;
		return this;
	}

	@JsonProperty("Država")
	public String getDrzava() {
		return drzava;
	}

	@JsonProperty("Država")
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public TecajPOJO withDrAva(String drAva) {
		this.drzava = drAva;
		return this;
	}

	@JsonProperty("Šifra valute")
	public String getSifraValut() {
		return sifraValut;
	}

	@JsonProperty("Šifra valute")
	public void setSifraValut(String sifraValut) {
		this.sifraValut = sifraValut;
	}

	public TecajPOJO withIfraValute(String sifraValut) {
		this.sifraValut = sifraValut;
		return this;
	}

	@JsonProperty("Valuta")
	public String getValuta() {
		return valuta;
	}

	@JsonProperty("Valuta")
	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

	public TecajPOJO withValuta(String valuta) {
		this.valuta = valuta;
		return this;
	}

	@JsonProperty("Jedinica")
	public int getJedinica() {
		return jedinica;
	}

	@JsonProperty("Jedinica")
	public void setJedinica(int jedinica) {
		this.jedinica = jedinica;
	}

	public TecajPOJO withJedinica(int jedinica) {
		this.jedinica = jedinica;
		return this;
	}

	@JsonProperty("Kupovni za devize")
	public String getKupovniZaDevize() {
		return kupovniZaDevize;
	}

	@JsonProperty("Kupovni za devize")
	public void setKupovniZaDevize(String kupovniZaDevize) {
		this.kupovniZaDevize = kupovniZaDevize;
	}

	public TecajPOJO withKupovniZaDevize(String kupovniZaDevize) {
		this.kupovniZaDevize = kupovniZaDevize;
		return this;
	}

	@JsonProperty("Srednji za devize")
	public String getSrednjiZaDevize() {
		return srednjiZaDevize;
	}

	@JsonProperty("Srednji za devize")
	public void setSrednjiZaDevize(String srednjiZaDevize) {
		this.srednjiZaDevize = srednjiZaDevize;
	}

	public TecajPOJO withSrednjiZaDevize(String srednjiZaDevize) {
		this.srednjiZaDevize = srednjiZaDevize;
		return this;
	}

	@JsonProperty("Prodajni za devize")
	public String getProdajniZaDevize() {
		return prodajniZaDevize;
	}

	@JsonProperty("Prodajni za devize")
	public void setProdajniZaDevize(String prodajniZaDevize) {
		this.prodajniZaDevize = prodajniZaDevize;
	}

	public TecajPOJO withProdajniZaDevize(String prodajniZaDevize) {
		this.prodajniZaDevize = prodajniZaDevize;
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public TecajPOJO withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("brojTecanice", brojTecanice).append("datumPrimjene", datumPrimjene)
				.append("drzava", drzava).append("sifraValut", sifraValut).append("valuta", valuta)
				.append("jedinica", jedinica).append("kupovniZaDevize", kupovniZaDevize)
				.append("srednjiZaDevize", srednjiZaDevize).append("prodajniZaDevize", prodajniZaDevize)
				.append("additionalProperties", additionalProperties).toString();
	}
	/*
	 * @Override public int hashCode() { return new
	 * HashCodeBuilder().append(jedinica).append(drzava).append(additionalProperties
	 * ).append(sifraValut).append(srednjiZaDevize).append(kupovniZaDevize).append(
	 * prodajniZaDevize).append(valuta).append(datumPrimjene).append(brojTecanice).
	 * toHashCode(); }
	 * 
	 * @Override public boolean equals(Object other) { if (other == this) { return
	 * true; } if ((other instanceof TecajPOJO) == false) { return false; }
	 * TecajPOJO rhs = ((TecajPOJO) other); return new
	 * EqualsBuilder().append(jedinica, rhs.jedinica).append(drzava,
	 * rhs.drzava).append(additionalProperties,
	 * rhs.additionalProperties).append(sifraValut,
	 * rhs.sifraValut).append(srednjiZaDevize,
	 * rhs.srednjiZaDevize).append(kupovniZaDevize,
	 * rhs.kupovniZaDevize).append(prodajniZaDevize,
	 * rhs.prodajniZaDevize).append(valuta, rhs.valuta).append(datumPrimjene,
	 * rhs.datumPrimjene).append(brojTecanice, rhs.brojTecanice).isEquals(); }
	 * 
	 */
}
