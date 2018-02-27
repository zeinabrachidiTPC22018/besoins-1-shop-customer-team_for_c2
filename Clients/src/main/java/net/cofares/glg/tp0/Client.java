package net.cofares.glg.tp0;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author pascalfares
 *
 * Classe client (bean) avec les getter setter
 */
public class Client {

    private String _id;
    private String _prenom;
    private String _nom;
    private String _telephone;
    private String _rue;
    private String _ville;
    private String _etat;
    private String _code;
    private String _pays;
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

    /**
     * @return the _id
     */
    public String getId() {
        return _id;
    }

    /**
     * @return the _prenom
     */
    public String getPrenom() {
        return _prenom;
    }

    /**
     * @return the _nom
     */
    public String getNom() {
        return _nom;
    }

    /**
     * @return the _telephone
     */
    public String getTelephone() {
        return _telephone;
    }

    /**
     * @return the _rue
     */
    public String getRue() {
        return _rue;
    }

    /**
     * @return the _ville
     */
    public String getVille() {
        return _ville;
    }

    /**
     * @return the _etat
     */
    public String getEtat() {
        return _etat;
    }

    /**
     * @return the _code
     */
    public String getCode() {
        return _code;
    }

    /**
     * @return the _pays
     */
    public String getPays() {
        return _pays;
    }

    /**
     * @return the _mail
     */
    public String getMail() {
        return _mail;
    }

    @Override
    public String toString() {
        //Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
    /**
     * pattern builder exemple utilisation new
     * Client.ClientBuilder(1).prenom("pascal").nom("fares").telephone("03240").....build()
     */
    public static class ClientBuilder {

        private final String _id;
        private String _prenom;
        private String _nom;
        private String _telephone;
        private String _rue;
        private String _ville;
        private String _etat;
        private String _code;
        private String _pays;
        private String _mail;

        public ClientBuilder(String id) {
            _id = id;
        }

        /**
         * @param _prenom the _prenom to set
         */
        public ClientBuilder prenom(String _prenom) {
            this._prenom = _prenom;
            return this;
        }

        /**
         * @param _nom the _nom to set
         */
        public ClientBuilder nom(String _nom) {
            this._nom = _nom;
            return this;
        }

        /**
         * @param _telephone the _telephone to set
         */
        public ClientBuilder telephone(String _telephone) {
            this._telephone = _telephone;
            return this;
        }

        /**
         * @param _rue the _rue to set
         */
        public ClientBuilder rue(String _rue) {
            this._rue = _rue;
            return this;
        }

        /**
         * @param _ville the _ville to set
         */
        public ClientBuilder ville(String _ville) {
            this._ville = _ville;
            return this;
        }

        /**
         * @param _etat the _etat to set
         */
        public ClientBuilder etat(String _etat) {
            this._etat = _etat;
            return this;
        }

        /**
         * @param _code the _code to set
         */
        public ClientBuilder code(String _code) {
            this._code = _code;
            return this;
        }

        /**
         * @param _pays the _pays to set
         */
        public ClientBuilder pays(String _pays) {
            this._pays = _pays;
            return this;
        }

        /**
         * @param _mail the _mail to set
         */
        public ClientBuilder mail(String _mail) {
            this._mail = _mail;
            return this;
        }

        public Client build() {
            return new Client(this);
        }

    }
}
