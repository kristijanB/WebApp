# WebApp
Korišteno za zadatak:

Java:
openjdk version "1.8.0_212"  
OpenJDK Runtime Environment (build 1.8.0_212-8u212-b03-0ubuntu1.16.04.1-b03)  
OpenJDK 64-Bit Server VM (build 25.212-b03, mixed mode)    
-----------------------------------------------------------------------------
Tomcat v8.5 Server
-----------------------------------------------------------------------------
MYSQL database
	-mysql-connector-java-8.0.16
	
-za bazu je potrebno:  
	1. kreirati ili ažurirati korisnika na user: "root", password= "password" na mysql serveru

	UPDATE mysql.user SET Password=PASSWORD('password') WHERE USER='root' AND Host='localhost';  

	2. kreirati tablicu u schemi pomoću navedenog upita:

```sql
create or replace schema if not exists webappvalute collate latin1_swedish_ci;

create or replace table if not exists hnbapidata
(
	id int not null
		primary key,
	broj_tecajnice varchar(15) null,
	datum_primjene varchar(50) null,
	drzava varchar(50) null,
	sifra_valute varchar(10) null,
	valuta varchar(10) null,
	jedinica int null,
	kupovni_za_devize varchar(15) null,
	srednji_za_devize varchar(15) null,
	prodajni_za_devize varchar(15) null
);
```
-po potrebi postaviti:
	SET GLOBAL time_zone='+02:00';
-----------------------------------------------------------------------------
-za pokretanje stranice pozvati servis sa /GetCurrency  
	npr. http://localhost:8080/WebAplikacija1/GetCurrency
