
// inherits BaseObject
var Country = function (id, countryId, countryName) {
    BaseObject.call(this, id);

    this.countryId = countryId;
    this.countryName = countryName;
};
