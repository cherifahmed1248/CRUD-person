/person/save
Endpoint: GET /person/findAll
Description: renvoie toutes les Personnes enregistrées par ordre alphabétique

Endpoint: POST /person/save
Description: sauvegarde une personne de moins de 150 ans sinon renvoyer une erreur
Response:
Status: 200 OK
OR 
Status: BAD_REQUEST if age >= 150