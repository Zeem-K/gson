### Refactor de la méthode doPeek
Cette méthode à elle toute seule faisait plus de 130 lignes en plus d'être dur à comprendre j'ai donc décider de le séparer en plusieurs petites fonctions pour améliorer la lisibilité et la compréhension. [Voir le Commit](https://github.com/google/gson/commit/944b8762d5cf98e4264531575c251bc314e3fba0)
###  Methode avec valeur de retour boolean
La methode isAnonymousOrNonStaticLocaj est la seule fonction qui fait appel à isStatic et elle prend toujours la négation donc il suffit de renvoyer directement la négation dans isStatic pour éviter de le faire ça. [Voir le Commit](https://github.com/google/gson/commit/84bec4497ced57f20ab77253c9ac9789a7745dfe)
### Methode presque Dupliquer
Dans les classes BagOfPrimitivesDeserializationBenchmark et CollectionsDeserializationBenchmark on deux fois deux portions de code qui se ressemble très fortement j'ai donc voulu essayer de généraliser ces méthodes dans une autre classe ce qui s'est avéré trop compliquer dû aux petites subtilités que je n'ai pas remarqué à la première lecture. [Voir le Commit](https://github.com/google/gson/commit/02b1435611310ab3adde0e7ba90d45ad867112ba)
### Supression de Nombre Magique
Dans la methode hashCode de $Gson$Types j'ai remplacé le 31 utilisé dans cette méthode par une variable qui explique réellement son utilité afin d'améliorer la compréhension de la méthode. [Voir le Commit](https://github.com/google/gson/commit/4e209031debf00c8a37177ad98f02c7058065a66)
### Ajout du keyword final
Dans la classe BagOfPrimitives les attributs de cette en sont immubales donc plutôt judicieux de mettre final devant ces attributs pour que cela soit bien clair. [Voir le Commit](https://github.com/google/gson/commit/904c0c4372ee2e37949dbdb548400e0e681a4f93)
### Réduction du nombre de ligne d'une méthode
Dans la classe Excluder j'ai modifié la méthode excludeField en le séparant en plusieurs petites méthodes afin d'améliorer la lecture et la compréhension. [Voir le Commit](https://github.com/google/gson/commit/2e6c329f5fc9ba3f67d54ff6cac413881155062b)
