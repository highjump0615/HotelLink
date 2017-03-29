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
                "  }\n" +
                "]";

        return strData;
    }
}
