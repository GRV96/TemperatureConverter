# temperature_converter
This repository contains two applications that can convert temperatures in
degrees Celsius, degrees Fahrenheit and kelvins. One is a GUI application;
the other is a command line application. Both depend on the same conversion
package.

The GUI application is started by class GuiConvApp. The GUI provides a text
field to enter a temperature and two selectors to set the input and output
scales. The temperature's decimal part must be separated from the integral part
by a point, not a comma. Another selector can change the GUI's language.

The command line application is started by class CmdLineConvApp. It takes three
arguments: the temperature, the input scale and the output scale. The
temperature's decimal part must be separated from the integral part by a point,
not a comma. The temperature scales can be represented with lower or upper case
letters or their symbol (°C, °F, K). If the three arguments are valid, the
application outputs the converted temperature in the console. Here are examples
of valid command line arguments on Windows.

java -jar temperature_converter.jar 15.8 c f

java -jar temperature_converter.jar 0 F K

java -jar temperature_converter.jar -40 °C °F

Scripts in directory documentation can be parsed in [PlantUML]
(https://www.planttext.com/) to produce UML diagrams. Documentation of PlantUML
is available [here](https://plantuml.com/en/).