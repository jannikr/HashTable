

public class Test {

	public static void main(String[] args) {
		
		//Testet die HashTable 
		
		//Erzeuge die HashTable mit einer Arraygröße 10 und Datentyp Key: Integer und Value: String
		HashTable<Integer, String> ht = new HashTable<Integer, String>(10);
		
		//Füge Key-Value Paar in HashTable ein 
		ht.put(1, "Hallo");
		
		//Bekomme den Wert zum Schlüssel 1 – Erwartet: "Hallo" – Ist: "Hallo"
		System.out.println(ht.get(1));
		
		//Lösche das Key-Value Paar mit dem Key 1 – Erwartet: "Hallo" [value] – Ist: "Hallo"
		System.out.println(ht.remove(1));
		
		//Lösche das Key-Value Paar mit dem Key 1 – Erwartet: null [value] – Ist: null
		System.out.println(ht.remove(1));
		
		//-----------------------------------------------------------------------------------
		
		//Testet, ob mehr als 10 Key-Value Paare gespeichert werden können.
		ht.put(1, "Hallo");
		ht.put(2, "Hallo");
		ht.put(3, "Hallo");
		ht.put(4, "Hallo");
		ht.put(5, "Test");
		ht.put(6, "Hallo");
		ht.put(7, "Hallo");
		ht.put(8, "Hallo");
		ht.put(9, "Hallo");
		ht.put(10, "Hallo");
		ht.put(11, "Hallo");
		
		//Testet, beliebiges Element aus den put-Anweisungen
		System.out.println(ht.get(5));
		
		//-----------------------------------------------------------------------------------
		
		//Überschreibe ein Element mit put();
		
		//Speichert neuen Value in dem Key-Value Paar Key -> 5 – Erwartet: "Test" – Ist: "Test"
		System.out.println(ht.put(5, "NeuerTest"));
		
		//Bekomme den überschriebenen Wert zum Schlüssel 5 – Erwartet: "NeuerTest" – Ist: "NeuerTest"
		System.out.println(ht.get(5));
		
		
	}

}
