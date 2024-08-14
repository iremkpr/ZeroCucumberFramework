@tag
Feature: Title of your feature
 	@outline
 	Scenario Outline:
		When enter valid "<username>" and "<password>"
		And  Click login button
		Then Validate "<accountName>"
 		
 		Examples:
				|username|	password		|	accountName|
				| Admin	 |	Neotech@123	| Jacqueline White|
 		 		|AdenAdenova|Neotech@123|Aden Adenov|