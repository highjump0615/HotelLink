Hotel Service Web App
======

> Hotel booking service web site made with Spring Boot + Velocity

## Overview

Hotel B2B portal which provide hotel booking service to small business cusomers like travel agencies and etc.   

### 1. Main Features
- User management  
Signup, Login, Account info, Reset Password ...
- Hotel Management  
Search, Booking, Manage booking ...
 
### 2. Techniques

Backend data web service is totally separated from this main web page, and not in the scope of this project.

#### 2.1 Backend Development ([Spring Boot 1.3.8](http://projects.spring.io/spring-boot/))
- [Apache Velocity 1.7](http://velocity.apache.org/) for rendering page template   
- Stored common data in ServletContext
- Defined custom configuration in application.properites
- Made utility class; get property values from ApplicationContext
- RestTemplate is used for calling remote backend web service 
- [Json Lib 2.4](http://mvnrepository.com/artifact/net.sf.json-lib/json-lib/2.4) is used for transferring object into JSON
- [Jackson Databind 2.6.7](https://github.com/FasterXML/jackson-databind/) is used for transferring JSON into object

#### 2.2 Frontend Development ([jQuery](https://github.com/jquery/jquery) v1.11.0, [Bootstrap](https://github.com/twbs/bootstrap) v3.3.4)
- [flag-icon-css](https://github.com/lipis/flag-icon-css) for showing national flags with local SVG image
- [jQuery Select2 Plugin](https://github.com/select2/select2/) for selecting items with input
- [jQuery Date picker v5.1.1](https://github.com/kbwood/datepick) for selecting date
- [BxSlider 4.1.2](https://github.com/stevenwanderski/bxslider-4) for Carousel Slider

#### 2.3 Page Implementation
- Layout for not signed in pages; layout.vm    
- Layout for signed in pages; layout_login.vm    
- Page Layout has 3 macros  
headLayout(for stylesheet mainly)  
mainLayout(for body content html)   
scriptLayout(for javascript mainly) 
  
Page | Url | Controller Class | Velocity file | Api Related | Remark 
--- | ------- | ---- | --- | ----- | ------
index | / | HomeController | index.vm |  
About Us | /about | HomeController | aboutus.vm |  
Contact Us | /contact | HomeController | contactus.vm |  
Terms & Conditions | /term | HomeController | term.vm |  
Privacy Policy | /privacy | HomeController | privacy.vm |  
Signup | /signup | UserController | signup.vm |  
Home | /home | HomeController | home.vm | /suggestion/nationality  /suggestion/destination  
Search | /hotel/search | HotelController | search.vm | /suggestion/nationality  /suggestion/destination  /customer/exchange-rate  /customer/supplier-markup  /hotel/availability/city  /hotel/availability/hotel
  
##### 2.3.1 Home & Search
Hotel search form is common for both pages.  
Ajax call is used for destination suggestion and nationality suggestion on key up event of each input text.  
Both suggestion web service is imolemented locally in ApiController, as it needs to save suggested destinations and nationalities for use in search. 

## Need to Improve
- Complete the features not implemented  
... ...