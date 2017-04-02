package com.highjump.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for test api
 */

@RestController
@RequestMapping("/test/service")
public class TestController {

    @RequestMapping("suggestion/nationality")
    public String getNationality() {

        String strData = "[" +
                "  {" +
                "    \"id\": 3," +
                "    \"countryId\": \"AL\"," +
                "    \"countryName\": \"Albania\"," +
                "    \"nationality\": \"Albania\"" +
                "  }," +
                "  {" +
                "    \"id\": 8," +
                "    \"countryId\": \"AG\"," +
                "    \"countryName\": \"Antigua&Barbuda\"," +
                "    \"nationality\": \"Antigua&Barbuda\"" +
                "  }," +
                "  {" +
                "    \"id\": 11," +
                "    \"countryId\": \"AW\"," +
                "    \"countryName\": \"Aruba\"," +
                "    \"nationality\": \"Aruba\"" +
                "  }," +
                "  {" +
                "    \"id\": 15," +
                "    \"countryId\": \"AZ\"," +
                "    \"countryName\": \"Azerbaijan\"," +
                "    \"nationality\": \"Azerbaijan\"" +
                "  }," +
                "  {" +
                "    \"id\": 16," +
                "    \"countryId\": \"BS\"," +
                "    \"countryName\": \"Bahamas\"," +
                "    \"nationality\": \"Bahamas\"" +
                "  }," +
                "  {" +
                "    \"id\": 17," +
                "    \"countryId\": \"BH\"," +
                "    \"countryName\": \"Bahrain\"," +
                "    \"nationality\": \"Bahrain\"" +
                "  }" +
                "]";

        return strData;
    }

    @RequestMapping("suggestion/destination")
    public String getDestination() {

        String strData = "[" +
                "  {" +
                "    \"id\": 21076," +
                "    \"countryId\": \"IT\"," +
                "    \"countryName\": \"Italy\"," +
                "    \"cityId\": 21076," +
                "    \"cityName\": \"Rome\"," +
                "    \"hotelId\": 0," +
                "    \"hotelName\": null," +
                "    \"hotelStarRating\": 0," +
                "    \"hotelCount\": 2217," +
                "    \"type\": \"city\"" +
                "  }," +
                "  {" +
                "    \"id\": 11199," +
                "    \"countryId\": \"FR\"," +
                "    \"countryName\": \"France\"," +
                "    \"cityId\": 11199," +
                "    \"cityName\": \"Paris\"," +
                "    \"hotelId\": 0," +
                "    \"hotelName\": null," +
                "    \"hotelStarRating\": 0," +
                "    \"hotelCount\": 1561," +
                "    \"type\": \"city\"" +
                "  }," +
                "  {" +
                "    \"id\": 29644," +
                "    \"countryId\": \"TR\"," +
                "    \"countryName\": \"Turkey\"," +
                "    \"cityId\": 29644," +
                "    \"cityName\": \"Istanbul\"," +
                "    \"hotelId\": 0," +
                "    \"hotelName\": null," +
                "    \"hotelStarRating\": 0," +
                "    \"hotelCount\": 1484," +
                "    \"type\": \"city\"" +
                "  }," +
                "  {" +
                "    \"id\": 30196," +
                "    \"countryId\": \"GB\"," +
                "    \"countryName\": \"United Kingdom\"," +
                "    \"cityId\": 30196," +
                "    \"cityName\": \"London\"," +
                "    \"hotelId\": 0," +
                "    \"hotelName\": null," +
                "    \"hotelStarRating\": 0," +
                "    \"hotelCount\": 1149," +
                "    \"type\": \"city\"" +
                "  }," +
                "  {" +
                "    \"id\": 47521," +
                "    \"countryId\": \"TH\"," +
                "    \"countryName\": \"Thailand\"," +
                "    \"cityId\": 47521," +
                "    \"cityName\": \"Bangkok\"," +
                "    \"hotelId\": 0," +
                "    \"hotelName\": null," +
                "    \"hotelStarRating\": 0," +
                "    \"hotelCount\": 1121," +
                "    \"type\": \"city\"" +
                "  }," +
                "  {" +
                "    \"id\": 1174," +
                "    \"countryId\": \"CN\"," +
                "    \"countryName\": \"China\"," +
                "    \"cityId\": 1174," +
                "    \"cityName\": \"Beijing\"," +
                "    \"hotelId\": 0," +
                "    \"hotelName\": null," +
                "    \"hotelStarRating\": 0," +
                "    \"hotelCount\": 841," +
                "    \"type\": \"city\"" +
                "  }" +
                "]";

        return strData;
    }
}
