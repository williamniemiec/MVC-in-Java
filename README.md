# MVC in Java
![](https://github.com/williamniemiec/MVC-in-Java/blob/master/media/logo/mvc-in-java_logo.jpg)

This project aims to provide an MVC Java framework for you to use in your projects. If you want to see an example there is a simple and complete example about a scheduler in "example" folder.

<hr />

## What is MVC?
Briefly, MVC (Model View Controller) is a design pattern widely used in projects because it leaves the project structured in order to facilitate the identification of application modules, understand how it is structured, in addition to facilitating maintenance. It structures the project in three modules:

|Name| Funcion
|------- | -------------- 
|Models | Responsible for business logic
|View | Responsible for the visual part
|Controllers | Responsible for the behavior of the visual part

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
Just create your modal class and put it in `models` folder.
### Views
Views should implement [View interface](https://github.com/williamniemiec/MVC-in-Java/blob/master/src/views/View.java). This interface just have one method that must be implemented: "close".
### Controllers
Controllers also should implement an interface: [Controller interface](https://github.com/williamniemiec/MVC-in-Java/blob/master/src/controllers/Controller.java). This interface also have one method that must be implemented: "run".

## Overview of a generic MVC Java framework structure
![](https://github.com/williamniemiec/MVC-in-Java/blob/master/media/uml/uml.png)

## Application execution
To execute the application just run [Main class](https://github.com/williamniemiec/MVC-in-Java/blob/master/src/Main.java). It will execute [HomeController](https://github.com/williamniemiec/MVC-in-Java/blob/master/src/controllers/HomeController.java) (that will execute [HomeView](https://github.com/williamniemiec/MVC-in-Java/blob/master/src/views/HomeView.java)).

## Project organization
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
| controllers | `Directory`| Contains all application controller classes
| models | `Directory`| Contains all application model classes
| views | `Directory`| Contains all application view classes
| Main&#46;java | `File`| File responsible for starting the application

## Example
To be clear how the framework works I made a small application that consists of a scheduler, being possible to create new events and see the ones already created. It is located in [example](https://github.com/williamniemiec/MVC-in-Java/tree/master/example) folder.
