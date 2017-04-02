
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

    this.toString = function () {
        var strResult = '';

        // hotel name
        if (this.hotelName) {
            strResult += this.hotelName + ',';
        }

        // city name
        strResult += this.cityName + ',';

        // country name
        strResult += this.countryName;

        return strResult;
    }
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