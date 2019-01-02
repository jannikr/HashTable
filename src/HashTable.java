import java.util.LinkedList;

public class HashTable<K, V> implements Map<K, V> {

	// inner Klasse mit Key-Value Paaren
	public class HashNode {

		// Attribute
		K key;
		V value;

		//Standard-Elemente einer Klasse:
		// Konstruktor
		public HashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		//Getter und Setter werden genutzt um den Code verständlicher zu machen.
		public K getKey() {
			return this.key;
		}

		public V getValue() {
			return value;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public void setValue(V value) {
			this.value = value;
		}
	}

	// Ende innere Klasse
	// ----------------------------------------------------------------

	// Attribute
	LinkedList<HashNode>[] table = null;
	int arraySize = 0;

	// Konstruktor
	public HashTable(int size) {
		this.arraySize = size;
		this.table = new LinkedList[size];
		/*
		 * Eine Array mit Elementen von dem Datentyp LinkedList wird erzeugt.
		 * Um in der LinkedList Elemente zu speichern, wird jeweils pro Array[index] eine LinkedList
		 * von dem Datentyp HashNode erzeugt.
		 */
		for (int i = 0; i < table.length; i++) {
			table[i] = new LinkedList<HashNode>();
		}
	}

	/**
	 * bestimmt die Arrayposition in abhängikeit von dem Key
	 * @param key der Schluessel
	 * @return index passend zum Array
	 */
	public int hashFunction(K key) {
		int index;
		index = Math.abs(key.hashCode() % arraySize);
		return index;
	}

	@Override
	public V put(K key, V value) {
		int index = hashFunction(key);
		/*
		 * Iteriere durch die Linked List und wenn das Element gefunden wurde, bei dem
		 * der Schlüssel gleich ist, speichere den alten Wert in einer Hilfsvariablen
		 * ab, überschreibe den Node-Wert und gebe die Hilfsvariable zurück.
		 */
		for (HashNode element : table[index]) {
			if (element.getKey().equals(key)) {
				V alt = element.value;
				element.value = value;
				return alt;
			}
		}

		// Füge einen neuen HashNode in der LinkedList an der passenden Array-Position
		// ein.
		HashNode hashNode = new HashNode(key, value);
		table[index].add(hashNode);
		return null;
	}

	@Override
	public V get(K key) {
		int index = hashFunction(key);
		/*
		 * Iteriere durch die Linked List und wenn das Element gefunden wurde, bei dem
		 * der Schlüssel gleich ist, gebe den Wert zu dem passenden HashNode zurück.
		 */
		for (HashNode element : table[index]) {
			if (element.getKey().equals(key)) {
				return element.value;
			}
		}
		return null;

	}

	@Override
	public V remove(K key) {
		int index = hashFunction(key);
		/*
		 * Iteriere durch die Linked List und wenn das Element gefunden wurde, bei dem
		 * der Schlüssel gleich ist, speichere den alten Wert in einer Hilfsvariablen
		 * ab, lösche den Node-Wert und gebe die Hilfsvariable zurück.
		 */
		for (HashNode element : table[index]) {
			if (element.getKey().equals(key)) {
				V altvalue = element.getValue();
				table[index].remove(element);
				return altvalue;
			}
		}
		return null;

	}
}
