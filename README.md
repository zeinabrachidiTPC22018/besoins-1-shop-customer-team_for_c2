# Expression des besoins 0 (1$ shop Customer)

La société Libanaise "1$ shop" vend de tout et n'importe quoi. Elle est implantée depuis plusieurs année au Liban, où ses principaux clients sont domiciliés. Récemment elle a eyu l'idée de passer en ligne et de créer un magazin en ligne Elle continue à exercer sa profession telle qu'elle le faisait à ses débuts, c'est-à-dire qu'elle répertorie ses clients sur des fiches de papier bristol, indexées par le nom de famille, reçoit les commandes par téléphone, fax et les payement par OMT (Transfert de cash). Une fois le montant encaissé, "1$ shop" envoie les produits via son réseau de livreures. Régulièrement "1$ shop" envoie son catalogue à ses clients. Elle trouve ses nouveaux clients au travers de publicités qu'elle envoie aussi par courrier ou démarchage direct (brochure distribué sur les routes libanaise…).
"1$ shop" veut informatiser la gestion de ses clients car ils sont de plus en plus nombreux. Elle voudrait saisir leurs coordonnées et pouvoir les modifier. Cette informatisation lui permettrait surtout de pouvoir retrouver les informations de ses clients plus rapidement. "1$ shop" possède des PC un peu obsolètes avec Windows comme système d'exploitation. Il faut donc que l'application ne consomme pas trop de ressources systèmes.
Cette tâche de gestion des clients sera menée par "l'utilisateur final Bob" qui assure la relation clientèle. L'application devra être uniquement déployée sur le serveur d'impression. La particularité de ce serveur est qu'il est constamment allumé et n'est jamais éteint. "1$ shop" ne possédant pas de base de données, les données peuvent être stockées en mémoire ou dans de simple fichiers. L'application devra être simple d'utilisation et l'interface utilisateur, ainsi que la documentation et le code, devront être rédigés en français. Ce système de gestion clientèle se nomme "1$ shop" Customer.

Nous souhaitons donc définit les cas d'utilisations de 1$C (1$ shop Customer) en travaillant avec Bob.

Après notre premier entretien informel avec Bob il nous fournit sa vision de l'interface texte de l'application comme il le souhaiterait.

```
 (0) Quit
 ----------
 (1) Créer un client
 (2) Trouver Client
 (3) Supprimer Client
 (4) Mettre a jour client
```

(1)On pourra ainsi accéder à l'action « créer d'un client » en tapant le chiffre 1. S'affiche ensuite un menu aidant l'utilisateur à saisir les bonnes données. La ligne Usage permet à Bob de connaître l'ordre des données à saisir et la ligne Example lui fournit un exemple.

--- Créer client ---
> Usage : Id- prénom - nom - tel - adresse

> Exemple : bob001 - Bob - Ducnam - 03240246 - Beyrouth

Bob n'aura plus qu'à saisir les coordonnées d'un client en séparant chaque donnée par le caractère '-'. Le système alertera l'utilisateur du bon ou mauvais fonctionnement d'une action. Le système, dans sa version initiale, ne vérifiera pas la cohérence des données saisies telle que la validité du numéro de téléphone, des états ou des pays.
(2) Pour consulter les informations d'un client, Bob saisi un identifiant et le système affiche les données.

## A faire
### A - Trouvons et décrivons les cas d'utilisations
### B- Analyse conception
Nous utiliserons le patron de conception objet d'accès aux données (en anglais data access object ou DAO)  https://fr.wikipedia.org/wiki/Objet_d%27acc%C3%A8s_aux_donn%C3%A9es
#### B1 - Modèle statique
#### B2 - Modèle dynamique

### Développer le logiciel et ses test (dans netbeans et maven)

# Informations utile [Source](http://aisl.cnam.fr/xwiki/wiki/aisl/view/GLG203/TP01)

Gestion des erreurs
Tout programme comporte des erreurs. C'est à cause de cette constatation que les développeurs essaient d'en réduire le nombre au maximum. Mais malgré cela, toutes les erreurs ne peuvent être prévisibles.

Les erreurs syntaxiques sont interceptées lors de la compilation, mais il reste encore souvent des erreurs « imprévisibles ». Elles se produisent généralement de façon exceptionnelle, c'est-à-dire à la suite d'une action de l'utilisateur, ou de l'environnement. Une première solution pour palier ce problème consiste à mettre en place un système de code d'erreur. Cette technique rend difficile la lecture et l'écriture des programmes (imbrication de test conditionnel if...else...).

Java propose un mécanisme de gestion d'exceptions, consistant à effectuer les instructions dans un bloc d'essai (le bloc try) qui surveille les instructions. Lors de l'apparition d'une erreur, celle-ci est lancée dans un bloc de traitement d'erreur (le bloc catch) sous forme d'un objet appelé Exception. Ce block catch peut alors traiter l'erreur ou la relancer vers un bloc de plus haut niveau. Un dernier block, finally, permet toujours d'exécuter une suite d'instructions qu'il y ait eu ou non exception. Il sert, par exemple, à ce qu'un fichier ouvert dans le bloc try soit systématiquement refermé, quoiqu'il arrive, grâce au bloc finally.

Lorsque le programme rencontre une erreur dans un bloc try, une exception est instanciée puis lancée. L'interpréteur cherche un bloc catch à partir de l'endroit où l'exception a été créée. S'il ne trouve aucun bloc catch, l'exception est lancée dans le bloc de niveau supérieur et ainsi de suite jusqu'au bloc de la classe qui, par défaut, enverra l'exception à l'interpréteur. Celui-ci émettra alors un message d'alerte standard pour le type d'exception. Si un bloc catch est trouvé, celui-ci gérera l'exception et ne l'enverra pas à l'interpréteur.

Si par contre on désire que l'exception soit traitée par les blocs de niveaux supérieurs, il suffit d'inclure à la fin de la série d'instructions contenues dans le bloc catch une clause throw, suivie du type de l'exception entre parenthèse, puis du nom de l'exception. Ainsi l'exception continuera son chemin...

Le mécanisme décrit ci-dessus, correspond aux exceptions contrôlées. Celles-ci doivent hériter de la classe java.lang.Exception. Par contre, les exceptions non contrôlées, comme leur non l'indique n'oblige pas le compilateur à exiger des blocks try/catch. Les exceptions non contrôlées (héritant de RuntimeException) peuvent ne pas être interceptées ou traitées.

Hello PetStore !
Cet exemple vous montre les différences de code entre une exception contrôlée et non contrôlée!

```Java 
public class HelloPetstore {
  // Point d'entrée de l'application
  public static void main(String args) {
    // si vous passez l'argument "controlee"
    if (args[0].equals("controlee")) { (1)
      try {
        controlee(); (2)
        System.out.println("Ce texte ne s'affichera pas");
      } catch (Exception e) {
        System.out.println("Hello"); (5)
      } finally {
        System.out.println("PetStore!");
      }
    } else {
      noncontrolee(); (6)
      System.out.println("Ce texte ne s'affichera pas");
    }
  }
  private static void controlee() throws Exception { (4)
    throw new Exception(); (3)
  }
  private static void noncontrolee() {
    throw new RuntimeException(); (7)
  }
}
```

Exécutez ce programme en lui passant le paramètre « controlee » (java HelloPetstore controlee)(1) la méthode privée controlee() est appelée (2). Cette méthode lance une exception contrôlée (3) et, est donc obligée de la déclarer dans sa signature (4). La classe Exception est la classe mère de toutes les exceptions contrôlées. L'appel de cette méthode doit donc être entouré d'un block try/catch (5).

À l'opposé, si vous passez un autre paramètre au programme, la méthode noncontrolee() est appelée (6). Elle lance une RuntimeException (classe mère des exceptions non contrôlées) et n'a pas besoin de la déclarer dans sa signature (7). L'appel n'a donc pas besoin d'être entouré d'un block try/catch.

Après compilation de cette classe, voici la trace de l'exécution du programme avec les différents paramètres :

java HelloPetstore controlee
Hello
PetStore!
java HelloPetstore noncontrolee
Exception in thread "main" java.lang.RuntimeException
  at HelloPetstore.noncontrolee(HelloPetstore.java:34)
  at HelloPetstore.main(HelloPetstore.java:23)


La pile d'exécution est affichée (8) par l'interpréteur. Cela permet de suivre l'origine de l'exception. Dans notre cas l'exception de type Runtime est levée à la ligne 34 de la classe HelloPetstore.