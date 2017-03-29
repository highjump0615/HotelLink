
// inherits Country
var Nationality = function (id, countryId, countryName, nationality) {
    Country.call(this, id, countryId, countryName);

    this.nationality = nationality;
};

Nationality.fromObject = function (object) {
    return new this(object.id, object.countryId, object.countryName, object.nationality)
};