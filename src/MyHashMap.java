public class MyHashMap<K, V> {

	private final int DEFAULT_CAPACITY = 8;
	private Entry<K, V>[] table;

	private class Entry<K, V> {
		private final K key;
		private V value;
		private Entry<K, V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return this.key;
		}

		public V getValue() {
			return this.value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		@Override
		public String toString() {
		Entry<K,V> temp = this;
		StringBuilder sb = new StringBuilder();
		while (temp != null) {
			sb.append(temp.key).append(" -> ").append(temp.value).append(",");
			temp = temp.next;
		}      
		return sb.toString();
		}
	}

	public MyHashMap() {
		table = new Entry[DEFAULT_CAPACITY];
	}

	public void put(K key, V value) {
		int hashCode = key.hashCode() % DEFAULT_CAPACITY;
		Entry<K, V> entry = table[hashCode];

		if (entry == null) {
			table[hashCode] = new Entry<>(key, value);
		} else {
			while (entry.next != null) {
				if (entry.getKey() == key) {
					entry.setValue(value);
					return;
				}
				entry = entry.next;
			}
			if (entry.getKey() == key) {
				entry.setValue(value);
				return;
			}
			entry.next = new Entry<>(key, value);
		}
	}

	public V get(K key) {
		int hashCode = key.hashCode() % DEFAULT_CAPACITY;
		Entry<K, V> entry = table[hashCode];

		if (entry == null) {
			return null;
		}
		while (entry != null) {
			if (entry.getKey() == key) {
				return entry.getValue();
			}
			entry = entry.next;
		}
		return null;
	}

	public V remove(K key) {
		int hash = key.hashCode() % DEFAULT_CAPACITY;
		Entry<K, V> entry = table[hash];
	
		if (entry == null) {
			return null;
		}
	
		if (entry.getKey() == key) {
			table[hash] = entry.next;
			entry.next = null;
			return entry.getValue();
		}
	
		Entry<K, V> prev = entry;
		entry = entry.next;
	
		while (entry != null) {
			if (entry.getKey() == key) {
				prev.next = entry.next;
				entry.next = null;
				return entry.getValue();
			}
			prev = entry;
			entry = entry.next;
		}
	
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < DEFAULT_CAPACITY; i++) {
		if (table[i] != null) {
			sb.append(i).append(" ").append(table[i]).append("\n");
		} else {
			sb.append(i).append(" null\n");
		}
		}
	
		return sb.toString();
	}
}
