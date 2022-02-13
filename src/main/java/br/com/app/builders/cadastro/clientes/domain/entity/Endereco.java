package br.com.app.builders.cadastro.clientes.domain.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Endereco implements Serializable {

        private static final long serialVersionUID = 1L;
        private String logradouro;
        private Integer numero;
        private String bairro;
        private String cep;
        private String cidade;
        private String pais;

        public Endereco() {
        }

        public Endereco(String cidade, String logradouro, Integer numero, String bairro, String cep, String pais) {
            this.cidade = cidade;
            this.logradouro = logradouro;
            this.numero = numero;
            this.bairro = bairro;
            this.cep = cep;
            this.pais = pais;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getLogradouro() {
            return logradouro;
        }

        public void setLogradouro(String logradouro) {
            this.logradouro = logradouro;
        }

        public Integer getNumero() {
            return numero;
        }

        public void setNumero(Integer numero) {
            this.numero = numero;
        }

        public String getBairro() {
            return bairro;
        }

        public void setBairro(String bairro) {
            this.bairro = bairro;
        }

        public String getCep() {
            return cep;
        }

        public void setCep(String cep) {
            this.cep = cep;
        }

        public String getPais() {
            return pais;
        }

        public void setPais(String pais) {
            this.pais = pais;
        }

}
