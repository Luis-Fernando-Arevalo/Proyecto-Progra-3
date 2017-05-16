/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministradorConexion;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

/**
 *
 * @author Luis Arevalo
 */
@Entity
@Table(name = "especie", catalog = "manejovivero", schema = "")
@NamedQueries({
    @NamedQuery(name = "Especie.findAll", query = "SELECT e FROM Especie e")
    , @NamedQuery(name = "Especie.findByIdEspecie", query = "SELECT e FROM Especie e WHERE e.idEspecie = :idEspecie")
    , @NamedQuery(name = "Especie.findByNombre", query = "SELECT e FROM Especie e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Especie.findByCantidad", query = "SELECT e FROM Especie e WHERE e.cantidad = :cantidad")
    , @NamedQuery(name = "Especie.findByCosto", query = "SELECT e FROM Especie e WHERE e.costo = :costo")})
public class Especie implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEspecie")
    private Integer idEspecie;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Cantidad")
    private Integer cantidad;
    @Basic(optional = false)
    @Column(name = "Costo")
    private long costo;

    public Especie() {
    }

    public Especie(Integer idEspecie) {
        this.idEspecie = idEspecie;
    }

    public Especie(Integer idEspecie, String nombre, long costo) {
        this.idEspecie = idEspecie;
        this.nombre = nombre;
        this.costo = costo;
    }

    public Integer getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Integer idEspecie) {
        Integer oldIdEspecie = this.idEspecie;
        this.idEspecie = idEspecie;
        changeSupport.firePropertyChange("idEspecie", oldIdEspecie, idEspecie);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        Integer oldCantidad = this.cantidad;
        this.cantidad = cantidad;
        changeSupport.firePropertyChange("cantidad", oldCantidad, cantidad);
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        long oldCosto = this.costo;
        this.costo = costo;
        changeSupport.firePropertyChange("costo", oldCosto, costo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecie != null ? idEspecie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especie)) {
            return false;
        }
        Especie other = (Especie) object;
        if ((this.idEspecie == null && other.idEspecie != null) || (this.idEspecie != null && !this.idEspecie.equals(other.idEspecie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AdministradorConexion.Especie[ idEspecie=" + idEspecie + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
