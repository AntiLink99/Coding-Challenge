Technologies used
-----------------
Java + Maven

How do you run this? 🤔
-----------------
1. Stellt sicher, dass ihr euch im Directory "SalesTaxes" befindet
2. Baut das Projekt: `mvn clean package`
3. Wechselt jetzt in den Ordner "target"
   --> Jetzt sollten einige Textdateien und die "SalesTaxes-1.0-SNAPSHOT.jar" generiert worden sein

4. Setzt die Umgebungsvariable "NO_SALES_TAX_FILE_PATH" mit dem absoluten Pfad zur in target generierten Datei "itemsWithoutSalesTax.txt"

Beispiel unter Windows-Cmd: `SET NO_SALES_TAX_FILE_PATH=C:\Users\jlued\git\Coding-Challenge\SalesTaxes\target\itemsWithoutSalesTax.txt`

5. Führt die .jar mit folgendem Befehl aus:
`java -cp SalesTaxes-1.0-SNAPSHOT.jar Main <ABSOLUTER PFAD ZUR GEWÜNSCHTEN INPUT-DATEI>`

Beispiel: `java -cp SalesTaxes-1.0-SNAPSHOT.jar Main C:\Users\jlued\git\Coding-Challenge\SalesTaxes\target\input1.txt`

6. Ihr solltet jetzt (hoffentlich) den Output des Programms in der Konsole sehen

Assumptions
-----------------
Because this project is small, i did not do Dependency Injection or mocking objects.
Simply because it was not necessary. I tried my best to make the code as maintainable as possible without comments.
Hope you are happy with it!

Problem
-----------------

SALES TAX PROBLEM

Basic sales tax is applicable at a rate of 10% on all goods, except books, food,
and medical products that are exempt. Import duty is an additional sales tax
applicable on all imported goods at a rate of 5%, with no
exemptions.
When I purchase items I receive a receipt that lists the name of all the items and
their price (including tax), finishing with the total cost of the items, and the total
amounts of sales tax paid. The rounding rules for sales tax are that for a tax rate
of n%, a shelf price of p contains np/100 rounded up to the nearest 0.05 amount
of sales tax.


INPUTS:

	Input 1:
		1 book at 12.49
		1 music CD at 14.99
		1 chocolate bar at 0.85
		
		
	Input 2:
		1 imported box of chocolates at 10.00
		1 imported bottle of perfume at 47.50
		
	Input 3:
		1 imported bottle of perfume at 27.99
		1 bottle of perfume at 18.99
		1 packet of headache pills at 9.75
		1 box of imported chocolates at 11.25

OUTPUTS:

	Output 1:
		1 book : 12.49
		1 music CD: 16.49
		1 chocolate bar: 0.85
		Sales Taxes: 1.50
		Total: 29.83
		
	Output 2:
		1 imported box of chocolates: 10.50
		1 imported bottle of perfume: 54.65
		Sales Taxes: 7.65
		Total: 65.15
		
	Output 3:
		1 imported bottle of perfume: 32.19
		1 bottle of perfume: 20.89
		1 packet of headache pills: 9.75
		1 imported box of chocolates: 11.85
		Sales Taxes: 6.70
		Total: 74.68

-----------------------
