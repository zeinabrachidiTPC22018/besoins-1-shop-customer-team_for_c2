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

public class Client {

    private final String _id;
    private final String _prenom;
    private final String _nom;
    private final String _pays;
    private final String _etat;
    private final String _ville;
    private final String _rue;
    private final String _code;
    private String _telephone;
    private String _mail;

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
        private final String _pays;
        private final String _etat;
        private final String _ville;
        private final String _rue;
        private String _code;
        private String _telephone;
        private String _mail;

        public ClientBuilder(String id, String prenom, String nom, String pays, String etat, String ville, String rue) {
            _id = id;
            _prenom = prenom;
            _nom = nom;
            _pays = pays;
           _etat = etat;
           _ville = ville;
           _rue = rue;
       
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
}