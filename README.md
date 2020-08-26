# Algorithms Api
Application written mainly in Java with usage of Spring Boot, 
MySQL, JavaScript, and a little of HTML with CSS. Main logic of this project
is to see difference between sorting algorithms and show results with some kind
of graph.To make application going on your machine, you need to take the following steps:
<br>
  1.Change url links in Algorithms.html to your backend port 
  (if you didn't change default port of spring you can leave that as it is), 
  <br>
  2.Change url in MainController.java to url of your Algorithms.html,
  <br>
  3.Run Spring Boot Api,
  <br>
  4.Open Algorithms.html to see results.

##  Folders and explanation

* `src/main/java/com/matthewksc/sortingAlgorithmsApi/Services` -service to make operations 
on data and class with sorting algorithm's methods,
* `src/main/java/com/matthewksc/sortingAlgorithmsApi/dao` - folder with data logic, entity's and repository,
* `src/main/java/com/matthewksc/sortingAlgorithmsApi/Controller` - folder with basic rest controller to 
send data in json to web,
* `src/main/java/com/matthewksc/sortingAlgorithmsApi/InitData.java` - init of data,
* `src/main/java/com/matthewksc/sortingAlgorithmsApi/Timer.java` - Timer class to time execution of sorting algorithm's.

##  Api in brower
![Alt text](https://github.com/MatthewKsc/sorting-Algorithms-Api/blob/master/src/main/resources/static/api.png?raw=true)
<br>
