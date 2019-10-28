# Mall

Spring Boot 2 Project using lombok, Orika, juni5, Mockito (Jupiter), Java 8.

Project Description:

1. This porject is a multi-module project

2. I did another test two years ago, at that I used a file to write the data, for this reason I prefer to choose another option. 

3. I use Spring Boot but I not been using @autowired, becaouse declaring beans has this advanges:

  I.promotes / facilitates field injection instead of builder / setter, which makes testing difficult
  
  II. Using @Autowired the module configuration is dispersed, and you cannot know at a glance what configuration do you have
  
  III. You could read more about it https://www.petrikainulainen.net/software-development/design/why-i-changed-my-mind-about-field-injection/
  

Test:

To test this app you have available a SaleServiceTest.java class 
or using swagger
http://localhost:8080/swagger-ui.html
