/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yery
 */
@Entity
@Table(name = "articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
    @NamedQuery(name = "Articulo.findByIDarticulo", query = "SELECT a FROM Articulo a WHERE a.iDarticulo = :iDarticulo"),
    @NamedQuery(name = "Articulo.findByDescripcion", query = "SELECT a FROM Articulo a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Articulo.findByPeso", query = "SELECT a FROM Articulo a WHERE a.peso = :peso"),
    @NamedQuery(name = "Articulo.findByExistencia", query = "SELECT a FROM Articulo a WHERE a.existencia = :existencia")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDarticulo")
    private Integer iDarticulo;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Peso")
    private Integer peso;
    @Column(name = "Existencia")
    private Integer existencia;

    public Articulo() {
    }

    public Articulo(Integer iDarticulo) {
        this.iDarticulo = iDarticulo;
    }

    public Integer getIDarticulo() {
        return iDarticulo;
    }

    public void setIDarticulo(Integer iDarticulo) {
        this.iDarticulo = iDarticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDarticulo != null ? iDarticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.iDarticulo == null && other.iDarticulo != null) || (this.iDarticulo != null && !this.iDarticulo.equals(other.iDarticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Articulo[ iDarticulo=" + iDarticulo + " ]";
    }
    
   
    
}
