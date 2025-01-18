/*
 * I implemented and experimented with 4 different hash functions. Simple hash function is a very simple implementation,
 * it just takes the word and loops through every character and adding its ASCII value, in the end I do modulus of a
 * size of the hash table and then return the index for the hassed word. The distribution was quite even, but when I changed
 * the size of the hashtable the number of keys per slot started to be more uneven.
 * Next I introduced a polynomial hash function, which uses a polynomial evaluation technique to produce the hashcode. It is
 * using only adiition and multiplication to produce an output. From my observation, polynomial has function performed better 
 * than a simple hash function, distributing the words more uniformly.
 * DJB2 hash function was written by Daniel J. Bernstein in 1991, it is an improved simple hash function. This function is multiplying
 * the hashValue variable by 33 and then adds the ASCII value of the current character. (multiplying by 33 is done by bit shifting hashValue << 5).
 * This function was surprisingly good, making very uniform distribution of the words.
 * The last hash function I implemented, was FNV hash function (Fowler–Noll–Vo). It is used for its speed and low collision rate, and yet
 * I found that this hash function was probably the best in terms of distribution.
 * Overall, I did not find any particular corolation between different hash functions and the the time taken to hash all words and
 * to find a random word. The distribution maily depended on the size of the hash table. 
 * 
 * Resources:
 * Karásek, J. (1970, January 1). Hashovací funkce - charakteristika, implementace a kolize. Handle Proxy. Retrieved March 6, 2023, from http://hdl.handle.net/11012/11096
 * Lecture notes + code
 * Book
 */

import java.util.LinkedList;
import java.util.List;


@SuppressWarnings("unchecked")
class HashTable {
    private final int SIZE = 128;
    private LinkedList<String>[] table;

    /**
     * constructor for a hash table with a given size
     */
    public HashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    /**
     * method to insert a word into a hash table at the appropriate index
     * @param word word to insert
     */
    public void insert(String word) {
        // TODO: Implement this method - it should insert the word into the HashTable at the appropriate index
        int index = hashFunction(word);
        table[index].add(word);
    }

    /**
     * m,ethod to get the word from the hash table, f the word doesn't exist in the HashTable return null
     * @param word word to find
     * @return given word, otherwise null 
     */
    public String get(String word){
        // TODO: Implement this method - it should return the word if it exists in the HashTable
        // If the word doesn't exist in the HashTable, don't return it.

        int index = hashFunction(word);
        for (int i = 0; i < table[index].size(); i++) {
            if(table[index].get(i).equals(word)){
                return table[index].get(i);
            }
        }
        return null;
    }

    /**
     * method to hash the given word (returns the hash value)
     * @param word word to find a hash value of
     * @return hash value of the word
     */
    public int hashFunction(String word) {
        // TODO:    Hash function goes here
        // Input:   String to be hashed
        // Output:  Hashcode of the input String


        //simple hash funcion
        
        
        //Test with SIZE 256:
        // Time taken to insert all words: 41 ms
        // Number of collisions: 369849
        // Min per slot: 1250
        // Max per slot: 1646
        // Time taken to search for 10,000 words: 1053 ms

        // Test with size 512:
        // Time taken to insert all words: 62 ms
        // Number of collisions: 369593
        // Min per slot: 256
        // Max per slot: 1313
        // Time taken to search for 10,000 words: 538 ms
        
        // Test with size 128:
        // Time taken to insert all words: 34 ms
        // Number of collisions: 369977
        // Min per slot: 2561
        // Max per slot: 3196
        // Time taken to search for 10,000 words: 1779 ms

        int Hashcode = 0;
        for (int i = 0; i < word.length(); i++) {
            Hashcode += (int)word.charAt(i);
        }
        return Hashcode % SIZE;

//--------------------------------------------------------------------------------------------------------------------------

        //polynomial hash function

        // Test with size 512:
        // Time taken to insert all words: 73 ms
        // Number of collisions: 369593
        // Min per slot: 636
        // Max per slot: 817
        // Time taken to search for 10,000 words: 471 ms


        // Test with size 256:
        // Time taken to insert all words: 67 ms
        // Number of collisions: 369849
        // Min per slot: 1340
        // Max per slot: 1590
        // Time taken to search for 10,000 words: 892 ms

        // Test with size 128:
        // Time taken to insert all words: 65 ms
        // Number of collisions: 369977
        // Min per slot: 2748
        // Max per slot: 3090
        // Time taken to search for 10,000 words: 1860 ms

        // int p = 31; // prime number
        // int m = 1000000007; // large prime number
        // int hashValue = 0;
        // int pPower = 1;
        // for (int i = 0; i < word.length(); i++) {
        //     hashValue = (hashValue + (word.charAt(i) - 'a' + 1) * pPower) % m;
        //     hashValue = Math.abs(hashValue);
        //     pPower = (pPower * p) % m;
        // }
        // return hashValue % SIZE;

//--------------------------------------------------------------------------------------------------------------------------

        //DJB2 hash function
        
        // Test with size 512:
        // Time taken to insert all words: 87 ms
        // Number of collisions: 369593
        // Min per slot: 658
        // Max per slot: 805
        // Time taken to search for 10,000 words: 473 ms


        // Test with size 256:
        // Time taken to insert all words: 58 ms
        // Number of collisions: 369849
        // Min per slot: 1333
        // Max per slot: 1533
        // Time taken to search for 10,000 words: 1182 ms


        // Test with size 128:
        // Time taken to insert all words: 144 ms
        // Number of collisions: 369977
        // Min per slot: 2727
        // Max per slot: 3030
        // Time taken to search for 10,000 words: 1827 ms

        // int hashValue = 5381;
        // for (int i = 0; i < word.length(); i++) {
        // hashValue = ((hashValue << 5) + hashValue) + word.charAt(i);
        // hashValue = Math.abs(hashValue);
        // }
        // return hashValue % SIZE;


//--------------------------------------------------------------------------------------------------------------------------
        //FNV hash function

        // Test with size 512:
        // Time taken to insert all words: 55 ms
        // Number of collisions: 369593
        // Min per slot: 642
        // Max per slot: 785
        // Time taken to search for 10,000 words: 465 ms


        // Test with size 256:
        // Time taken to insert all words: 116 ms
        // Number of collisions: 369849
        // Min per slot: 1352
        // Max per slot: 1545
        // Time taken to search for 10,000 words: 898 ms

        // Test with size 128:
        // Time taken to insert all words: 80 ms
        // Number of collisions: 369977
        // Min per slot: 2742
        // Max per slot: 3006
        // Time taken to search for 10,000 words: 1748 ms
        
        // final int FNV_OFFSET_BASIS = 0x811c9dc5;
        // final int FNV_PRIME = 0x01000193;
        // int hashValue = FNV_OFFSET_BASIS;
        // for (int i = 0; i < word.length(); i++) {
        //     hashValue = hashValue ^ (word.charAt(i) & 0xff);
        //     hashValue = (hashValue * FNV_PRIME) & 0xffffffff;
        //     hashValue = Math.abs(hashValue);
        // }
        // return hashValue % SIZE;
    }

    /**
     * method to find if a given word is present in a hash table
     * @param word word to search for
     * @return true if the word is in the hash table, false otherwise
     */
    public boolean search(String word) {
        int index = hashFunction(word);
        return table[index].contains(word);
    }

    /**
     * method to delete a given word from a hash table
     * @param word word to delete
     */
    public void delete(String word) {
        int index = hashFunction(word);
        table[index].remove(word);
    }

    /**
     * method to get the hash table
     * @return hast table
     */
    public List<String>[] getTable() {
        return table;
    }
}
