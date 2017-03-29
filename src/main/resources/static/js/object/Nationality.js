
var Nationality = function (id, countryId, countryName, nationality) {
    BaseObject.call(this, id);

    this.countryId = countryId;
    this.countryName = countryName;
    this.nationality = nationality;
};

Nationality.fromObject = function (object) {
    return new this(object.id, object.countryId, object.countryName, object.nationality)
};