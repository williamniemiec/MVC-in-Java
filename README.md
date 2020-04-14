# MVC in Java
![](https://github.com/williamniemiec/MVC-in-Java/blob/master/media/logo/mvc-in-java_logo.jpg?raw=true)

This project aims to provide an MVC Java framework for you to use in your projects. If you want to see an example there is a simple and complete example about a scheduler in "example" folder.

<hr />

## What is MVC?
Briefly, MVC (Model View Controller) is a design pattern widely used in projects because it leaves the project structured in order to facilitate the identification of application modules, understand how it is structured, in addition to facilitating maintenance. It structures the project in three modules:

|Name| Funcion
|------- | -------------- 
|Models | Responsible for business logic
|View | Responsible for the visual part
|Controllers | Responsible for the behavior of the visual part

This project is based on book [Head First design patterns](https://www.oreilly.com/library/view/head-first-design/0596007124/). Below are some illustrations from this book about how MVC works.
![generalView1](https://github.com/williamniemiec/MVC-in-Java/blob/master/media/example/GeneralView.jpg?raw=true)
![generalView2](https://github.com/williamniemiec/MVC-in-Java/blob/master/media/example/GeneralView2.png?raw=true)


### Nomenclature
This project adopted the following naming pattern:
|Type| Name
|------- | --- 
| Controller | <i>&lt;ControllerName&gt;</i>Controller
| View| <i>&lt;ViewName&gt;</i>View


<b>Note:</b> This is just an adopted standard; if you do not like it, you can use another one.

## How to use this structure in my project?
In `src` folder is all what you need to apply this pattern in your project. 

## How to create new models, views and controllers?

### Models
Models should implement [Model interface](https://github.com/williamniemiec/MVC-in-Java/blob/master/src/core/Model.java). This interface is like an [observable](https://www.javaworld.com/article/2077258/observer-and-observable.html) and has three methods that must be implemented: "attach", "detach" and "notifyViews".

### Views
Views should implement [View interface](https://github.com/williamniemiec/MVC-in-Java/blob/master/src/core/View.java). This interface just have one method that must be implemented: "update".

### Controllers
Controllers should extend [Controller class](https://github.com/williamniemiec/MVC-in-Java/blob/master/src/core/Controller.java). This class has one method that must be implemented: "run".

## Application execution
To execute the application just run [Main class](https://github.com/williamniemiec/MVC-in-Java/blob/master/src/Main.java). It will execute [HomeController](https://github.com/williamniemiec/MVC-in-Java/blob/master/src/controllers/HomeController.java) (that will execute [HomeView](https://github.com/williamniemiec/MVC-in-Java/blob/master/src/views/HomeView.java)).

## Classes and interfaces

### core
|        Name        | Type |	Description	|
|----------------|-------|--------------------------------------------------|
|		Controller 		|	`Abstract class`	| 	Contains the main frame of the application. All controllers must extend this	|
|		Model 			|	`Interface`			| 	Has behavior of a [Observator](https://www.javaworld.com/article/2077258/observer-and-observable.html). All model classes should implement this interface		|
|		View 			|	`Interface`			| 	Has behavior of a [Observer](https://www.javaworld.com/article/2077258/observer-and-observable.html). All view classes should implement this interface		|

### controllers

|        Name        | Type |	Description	|
|----------------|-------|--------------------------------------------------|
|	HomeController			|	`Class`			|	It will be responsible for [HomeView](https://github.com/williamniemiec/TextPlayer/blob/master/src/views/HomeView.java) behavior.	|

### models

|        Name        | Type |	Description	|
|----------------|-------|--------------------------------------------------|
|	Model1 				|	`Class`	| 	Example model		|

### views

|        Name        | Type |	Description	|
|----------------|-------|--------------------------------------------------|
|	HomeView 				|	`Class`	| 	Responsible for the look of application's main screen		|


## Project organization
![](https://github.com/williamniemiec/MVC-in-Java/blob/master/media/uml/uml.png)

The MVC structure is in `src` folder. In it, there are three folders and one files.

### /
|Name| Type| Function
|------- | --- | ----
| bin| `Directory`| Binary files (&#46;class files)
| example| `Directory`| Example of a project using mvc
| media| `Directory`| Visual information
| src| `Directory`| MVC framework
| &#46;classpath | `File`| IDE generated file
| &#46;project| `File`| IDE generated file


### /src
|Name| Type| Function
|------- | --- | ----
| 	assets	| `Directory`	| Contains all application content files
| controllers | `Directory`| Contains all application controller classes
| 	core 	| `Directory`	| Contains classes and interfaces essential for the functioning of the MVC structure
| models | `Directory`| Contains all application model classes
| views | `Directory`| Contains all application view classes
| Main&#46;java | `File`| Class responsible for starting the application

## Example
To be clear how the framework works I made a small application that consists of a scheduler, being possible to create new events and see the ones already created. It is located in [example](https://github.com/williamniemiec/MVC-in-Java/tree/master/example) folder.

## References
- Freeman, Eric, Elisabeth Robson, Kathy Sierra, and Bert Bates. 2004. Head First design patterns. Sebastopol, CA: O'Reilly.