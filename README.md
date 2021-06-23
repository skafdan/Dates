# Dates

Writen and tested using: Java - `OpenJDK 14`
To compile the code use the command
`javac dates.java` followed by `java dates` to run the program
The input date is read from stdin and can be passed either by typing in the date 
when prompted or from a file `java dates < <filename.txt>`
Dates should be inputed using dd/mm/yyyy format 
mm - can be replaced with the first three characters of the month name, all 
uppercase or lowercase or the first character uppercase.
yyyy - can be replaced with yy for years between 1950-2049

Important note: When reading inputs from a file from stdin dates should have no trailing whitespace

Invalid test cases:
- 12/05-2020
- 12 05/2020
- mar 05 2020
- 5 MaR 2020
- 05 05 30000
- 33 13 300000
- 00/00/0000
- 00 00 0000
- 12/05/300
- '<no input>'
- asdfds sdsdsa asdsadsd
- //
- \-\- 
- '<space><space>'  
- 31/apr/2005
- 31/nov/2005
- 31/sep/2005
- 1 001 11
- 1 1 0011
- 8 4 56'
- 29 Feb 19000
- 11 111 11 1111
- 1 0 00

Valid test cases:
- 29/02/2020
- 29/02/2016
- 29/02/2012
- 29/02/2008
- 29/02/1904
- 29/02/1756
- 05 05 05 
- 05 MAR 2020
- 05 jan 2020
- 05 feb 2020
- 05/FEB/2020
- 05/Feb/2020
- 1 7 11
- 01 06 50
- 1 Apr 23
- 9 9 1753

Resources:
- https://docs.microsoft.com/en-us/office/troubleshoot/excel/determine-a-leap-year
- https://regex101.com/
