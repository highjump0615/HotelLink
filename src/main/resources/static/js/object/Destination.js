
// inherits Country
var Destination = function (id, countryId, countryName, cityId, cityName, hotelId, hotelName, hotelStarRating, hotelCount, type) {
    Country.call(this, id, countryId, countryName);

    this.cityId = cityId;
    this.cityName = cityName;
    this.hotelId = hotelId;
    this.hotelName = hotelName;
    this.hotelStarRating = hotelStarRating;
    this.hotelCount = hotelCount;
    this.type = type;
};

Destination.fromObject = function (object) {
    return new this(
        object.id,
        object.countryId,
        object.countryName,
        object.cityId,
        object.cityName,
        object.hotelId,
        object.hotelName,
        object.hotelStarRating,
        object.hotelCount,
        object.type
    );
};