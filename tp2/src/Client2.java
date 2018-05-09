/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zeina
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Client2 {

    private final String _id;
    private final String _prenom;
    private final String _nom;
    private String _telephone;
    private String _rue;
    private String _ville;
    private String _etat;
    private String _code;
    private String _pays;
    private String _mail;

    public Client2(ClientBuilder cb) {
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

    public String getTelephone() {
        return _telephone;
    }
    
    public String getRue() {
        return _rue;
    }
    
    public String getVille() {
        return _ville;
    }

    public String getEtat() {
        return _etat;
    }

    public String getCode() {
        return _code;
    }
  
    public String getPays() {
        return _pays;
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
        private final String _prenom;
        private final String _nom;
        private String _telephone;
        private String _rue;
        private String _ville;
        private String _etat;
        private String _code;
        private String _pays;
        private String _mail;

        public ClientBuilder(String id, String prenom, String nom) {
            _id = id;
            _prenom = prenom;
            _nom = nom;
        }

        public ClientBuilder setTelephone(String _telephone) {
            this._telephone = _telephone;
            return this;
        }

        public ClientBuilder setRue(String _rue) {
            this._rue = _rue;
            return this;
        }

        public ClientBuilder setVille(String _ville) {
            this._ville = _ville;
            return this;
        }

        public ClientBuilder setEtat(String _etat) {
            this._etat = _etat;
            return this;
        }

        public ClientBuilder setCode(String _code) {
            this._code = _code;
            return this;
        }

        public ClientBuilder setPays(String _pays) {
            this._pays = _pays;
            return this;
        }

        public ClientBuilder setMail(String _mail) {
            this._mail = _mail;
            return this;
        }

        public Client2 build() {
            return new Client2(this);
        }
    }
}