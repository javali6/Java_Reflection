# Java_Reflection
Application using mechanism of reflection in java. 
The way it works is simple, first we need a class in java bean convention,
fields must be type one of types from list:

- String
- Integer   | int     |
- Double    | double  |
- Float     | float   |
- Long      | long    |
- Short     | short   |
- Byte      | byte    |
- Character | char    |
- Boolean   | bool    |

After typing the name of class in text field we need to press "Create Object"
This will create a instance of class and create text fields with labels.

Right now we can modify any values, but typing wrong type of data may cause runtime exception.
