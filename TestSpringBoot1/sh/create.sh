#curl -H "Content-Type:application/json" -X POST -d '{"city":"shanghai","countryId":"1"}' 127.0.0.1:8080/api/cities
curl -H "Content-Type:application/json" -X POST \
-d '{"title":"title","releaseYear":"1996","languageId":"1","rentalDuration":"6","rentalRate":"0.99","replacementCost":"20.99"}' \
127.0.0.1:8080/api/films