/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp2_jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author zeina
 */
@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c._id = :_id")
    , @NamedQuery(name = "Client.findByPrenom", query = "SELECT c FROM Client c WHERE c._prenom = :_prenom")
    , @NamedQuery(name = "Client.findByNom", query = "SELECT c FROM Client c WHERE c._nom = :_nom")
    , @NamedQuery(name = "Client.findByPays", query = "SELECT c FROM Client c WHERE c._pays = :_pays")
    , @NamedQuery(name = "Client.findByEtat", query = "SELECT c FROM Client c WHERE c._etat = :_etat")
    , @NamedQuery(name = "Client.findByVille", query = "SELECT c FROM Client c WHERE c._ville = :_ville")
    , @NamedQuery(name = "Client.findByRue", query = "SELECT c FROM Client c WHERE c._rue = :_rue")
    , @NamedQuery(name = "Client.findByCode", query = "SELECT c FROM Client c WHERE c._code = :_code")
    , @NamedQuery(name = "Client.findByTelephone", query = "SELECT c FROM Client c WHERE c._telephone = :_telephone")
    , @NamedQuery(name = "Client.findByMail", query = "SELECT c FROM Client c WHERE c._mail = :_mail")})

public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "_id")
    private final String _id;
    @Basic(optional = false)
    @Column(name = "_prenom")
    private String _prenom;
    @Basic(optional = false)
    @Column(name = "_nom")
    private String _nom;
    @Basic(optional = false)
    @Column(name = "_pays")
    private final String _pays;
    @Basic(optional = false)
    @Column(name = "_etat")
    private final String _etat;
    @Basic(optional = false)
    @Column(name = "_ville")
    private String _ville;
    @Column(name = "_rue")
    private String _rue;
    @Column(name = "_code")
    private String _code;
    @Column(name = "_telephone")
    private String _telephone;
    @Column(name = "mail")
    private String _mail;

    //public Client() {
    //}
    
    //public Client(String id) {
    //    this._id = id;
    //}

    //public Client(String id, String prenom, String nom, String pays, String etat, String ville) {
    //    this._id = id;
    //    this._prenom = prenom;
    //    this._nom = nom;
    //    this._pays = pays;
    //    this._etat = etat;
    //    this._ville = ville;
    //}

    //public void setId(String id) {
    //    this._id = id;
   // }

    //public void setPrenom(String prenom) {
    //    this.prenom = prenom;
    //}

    //public void setNom(String nom) {
    //    this.nom = nom;
    //}

    //public void setPays(String pays) {
    //    this.pays = pays;
    //}

    //public void setEtat(String etat) {
    //    this.etat = etat;
    //}

   // public void setVille(String ville) {
    //    this.ville = ville;
    //}

    //public void setRue(String rue) {
    //    this.rue = rue;
    //}

    //public void setCode(String code) {
    //    this.code = code;
    //}

    //public void setTelephone(String telephone) {
    //    this.telephone = telephone;
    //}

    //public void setMail(String mail) {
    //    this.mail = mail;
    //}
    
    public Client(ClientBuilder cb) {
        _id = cb._id;
        _prenom = cb._prenom;
        _nom=cb._nom;
        _telephone = cb._telephone;
        _rue = cb._rue;
        _ville = cb._ville;
        _etat = cb._etat;
        _code =cb._code;
        _pays = cb._pays;
        _mail = cb._mail;
    }
    
    public String getId() {
        return _id;
    }
    public String getPrenom() {
       return _prenom;
    }
     public String getNom() {
        return _nom;
    }
    public String getPays() {
        return _pays;
    }
    public String getEtat() {
        return _etat;
    }
    public String getVille() {
        return _ville;
    }
    public String getRue() {
        return _rue;
    }
     public String getCode() {
        return _code;
    }
    public String getTelephone() {
        return _telephone;
    }
    public String getMail() {
        return _mail;
    }
    
    @Override
    public String toString() {
        //Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
    
    public static class ClientBuilder {

        private final String _id;
        private String _prenom;
        private String _nom;
        private final String _pays;
        private final String _etat;
        private String _ville;
        private String _rue;
        private String _code;
        private String _telephone;
        private String _mail;

        public ClientBuilder(String id, String pays, String etat) {
            _id = id;
            _pays = pays;
            _etat = etat;  
        }
        
        public ClientBuilder setPrenom(String _prenom) {
            this._prenom = _prenom;
            return this;
        }
        
        public ClientBuilder setNom(String _nom) {
            this._nom = _nom;
            return this;
        }
        
        //public ClientBuilder setPays(String _pays) {
        //    this._pays = _pays;
        //    return this;
        //}
        
       // public ClientBuilder setEtat(String _etat) {
        //    this._etat = _etat;
        //    return this;
        //}

        public ClientBuilder setVille(String _ville) {
            this._ville = _ville;
            return this;
        }
        public ClientBuilder setRue(String _rue) {
            this._rue = _rue;
            return this;
        }      

        public ClientBuilder setCode(String _code) {
            this._code = _code;
            return this;
        }
        
        public ClientBuilder setTelephone(String _telephone) {
            this._telephone = _telephone;
            return this;
        }
        public ClientBuilder setMail(String _mail) {
            this._mail = _mail;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
        
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (_id != null ? _id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this._id == null && other._id != null) || (this._id != null && !this._id.equals(other._id))) {
            return false;
        }
        return true;
    }

    //@Override
   // public String toString() {
    //    return "tp2_jpa.Client[ _id=" + _id + " ]";
   // }
    
}

