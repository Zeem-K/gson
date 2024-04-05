### Refactor de la méthode doPeek
Cette méthode à elle toute seule faisait plus de 130 lignes en plus d'être dur à comprendre j'ai donc décider de le séparer en plusieurs petites fonctions pour améliorer la lisibilité et la compréhension
###  Methode avec valeur de retour boolean
La methode isAnonymousOrNonStaticLocaj est la seule fonction qui fait appel à isStatic et elle prend toujours la négation donc il suffit de renvoyer directement la négation dans isStatic pour éviter de le faire ça
### Methode presque Dupliquer
Dans les classes BagOfPrimitivesDeserializationBenchmark et CollectionsDeserializationBenchmark on deux fois deux portions de code qui se ressemble très fortement j'ai donc voulu essayer de généraliser ces méthodes dans une autre classe ce qui s'est avéré trop compliquer dû aux petites subtilités que je n'ai pas remarqué à la première lecture
