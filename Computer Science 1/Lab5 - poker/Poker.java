import java.util.Arrays;
import java.util.ArrayList;

class Poker{
    static String[] deck = {"cA", "cK", "cQ", "cJ", "c10", "c9", "c8", "c7", "c6", "c5", "c4", "c3", "c2",  // Clovers
                          "pA", "pK", "pQ", "pJ", "p10", "p9", "p8", "p7", "p6", "p5", "p4", "p3", "p2",    // Pickes
                          "hA", "hK", "hQ", "hJ", "h10", "h9", "h8", "h7", "h6", "h5", "h4", "h3", "h2",    // Hearts
                          "dA", "dK", "dQ", "dJ", "d10", "d9", "d8", "d7", "d6", "d5", "d4", "d3", "d2"};   // Diamonds

    static String[][] player_combinations = new String[0][5];
    static String[][] opponent_combinations = new String[0][5];

    public static void main (String[] args) {
        String[] cards = {"c2", "c3", "c4", "c5", "c6", "c7"};
        Poker p = new Poker();      // This statement requires knowledge about Object-Oriented Programming (more in CS2)

        // Example to validate your implementation of method deleteCards
        String[] discard = {"c4"};
        String[] newCards = p.discard_cards(cards, discard);
        System.out.println(Arrays.toString(newCards));
        // The following call must print the following combination (order of the elements inside the combination does not matter):
        //  "c2", "c3", "c5", "c6", "c7"

        // Example to validate your implementation of method possible_hands
        p.possible_hands(cards, new String[0]);
        // The following call must print the following combinations (order of combinations and/or elements inside the combinations do not matter):
        //  "c2", "c3", "c4", "c5", "c6" done
        //  "c2", "c3", "c4", "c5", "c7" done
        //  "c2", "c3", "c4", "c6", "c7" done
        //  "c2", "c3", "c5", "c6", "c7" done
        //  "c2", "c4", "c5", "c6", "c7" done
        //  "c3", "c4", "c5", "c6", "c7" done
        System.out.println(Arrays.deepToString(Poker.player_combinations));

        // Example to validate your implementation of method possible_hands_opponent
        String[] cardsOnCommunity = {"c2", "c3", "c4"};
        String[] cardsAvailable = {"c2", "c3", "c4", "c5", "c6", "c7"};
        p.possible_hands_opponent(cardsAvailable, cardsOnCommunity, new String[0]);
        // The following call must print the following combinations (order of combinations and/or elements inside the combinations do not matter):
        //  "c2", "c3", "c4", "c5", "c6"
        //  "c2", "c3", "c4", "c5", "c7"
        //  "c2", "c3", "c4", "c6", "c7"
        System.out.println(Arrays.deepToString(Poker.opponent_combinations));
        
    }

    public String[] discard_cards(String[] initialCards, String[] cardsToDiscard) {
        // Write your code below
        ArrayList<String> initialCardsList = ArrayManipulation.Array2ArrayList(initialCards);
        ArrayList<String> cardsToDiscardList = ArrayManipulation.Array2ArrayList(cardsToDiscard);

        if(cardsToDiscardList.size()==0){
            return ArrayManipulation.ArrayList2Array(initialCardsList);
        }
        else{
            initialCardsList.remove(cardsToDiscardList.get(0));
            cardsToDiscardList.remove(0);
            initialCards = ArrayManipulation.ArrayList2Array(initialCardsList);
            cardsToDiscard = ArrayManipulation.ArrayList2Array(cardsToDiscardList);
            return discard_cards(initialCards, cardsToDiscard);
        }
        // Write your code above
    }

    public void possible_hands (String[] cardsAvailable, String[] cardsOnHands) {
        // Write your code below
        ArrayList<String> cardsAvailableList = ArrayManipulation.Array2ArrayList(cardsAvailable);
        ArrayList<String> cardOnHandsList = ArrayManipulation.Array2ArrayList(cardsOnHands);
        
        if(cardOnHandsList.size()==5){
            player_combinations = ArrayManipulation.add_element_2Darray(player_combinations,cardsOnHands);
            //return;
        }
        else{
            if(cardsAvailableList.size()>0){
                cardOnHandsList.add(cardsAvailable[0]);
                cardsAvailableList.remove(0);

                possible_hands(ArrayManipulation.ArrayList2Array(cardsAvailableList),ArrayManipulation.ArrayList2Array(cardOnHandsList));
                possible_hands(ArrayManipulation.ArrayList2Array(cardsAvailableList), cardsOnHands);
            }
            //return;
        }

        ArrayManipulation.add_element_2Darray(opponent_combinations, cardsOnHands);

        // Write your code above
    }

    public void possible_hands_opponent (String[] cardsAvailable, String[] cardsOnCommunity, String[] cardsOnHands) {
        // Write your code below
        ArrayList<String> cardsAvailableList = ArrayManipulation.Array2ArrayList(cardsAvailable);
        ArrayList<String> cardOnHandsList = ArrayManipulation.Array2ArrayList(cardsOnHands);
        ArrayList<String> cardsOnCommunityList = ArrayManipulation.Array2ArrayList(cardsOnCommunity);

        if(cardOnHandsList.size()==5){
            if(discard_cards(cardsOnHands, cardsOnCommunity).length<3){
                opponent_combinations = ArrayManipulation.add_element_2Darray(opponent_combinations,cardsOnHands);
                //return;
            }
        }
        else{
            if(cardsAvailableList.size()>0){
                cardOnHandsList.add(cardsAvailable[0]);
                cardsAvailableList.remove(0);

                possible_hands_opponent(ArrayManipulation.ArrayList2Array(cardsAvailableList), ArrayManipulation.ArrayList2Array(cardsOnCommunityList), ArrayManipulation.ArrayList2Array(cardOnHandsList));
                possible_hands_opponent(ArrayManipulation.ArrayList2Array(cardsAvailableList), ArrayManipulation.ArrayList2Array(cardsOnCommunityList), cardsOnHands);
            }
            //return;
        }
        
        
        
        // Write your code above
    }
/*
    // Method to "transform" an ArrayList into an array (both containing String)
    public static String[] ArrayList2Array(ArrayList<String> strList) {
        String[] array = strList.toArray(new String[0]);
        return array;
    }

    // Method to "transform" an array into an ArrayList (both containing String)
    public static ArrayList<String> Array2ArrayList(String[] array) {
        return new ArrayList<String>(Arrays.asList(array));
    }

    public class ArrayManipulation {
        // Method to add a new element into a 2D array (array of array of String)
        public static String[][] add_element_2Darray(String[][] oldArray, String[] newElement) {
            int elements = oldArray.length;
            String[][] newArray = new String[elements+1][5];
            if(oldArray.length>0)
            {
                for(int i=0; i<elements; i++) {
                    newArray[i] = oldArray[i];
                }
                newArray[elements] = newElement;
            } else
               newArray[0] = newElement; 
            return newArray;
        }
    }*/

}